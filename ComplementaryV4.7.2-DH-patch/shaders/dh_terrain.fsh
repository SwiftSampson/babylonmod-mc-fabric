/*
 * Distant Horizons terrain patch for ComplementaryShaders v4.7.2
 * Applies Complementary's lightmap lighting and fog to DH LOD chunks.
 *
 * #version 130 required — see dh_terrain.vsh for explanation.
 * DHTerrainTransformer upgrades this to GLSL 4.10 core automatically.
 */

#version 130
#define OVERWORLD
#define FSH

#include "/lib/common.glsl"

uniform float screenBrightness;
uniform float rainStrengthS;
uniform ivec2 eyeBrightnessSmooth;
uniform float far;
uniform vec3  fogColor;
uniform vec3  skyColor;
uniform int   isEyeInWater;
uniform float blindFactor;
uniform float eyeAltitude;
uniform float isEyeInCave;
uniform mat4  gbufferModelViewInverse;
uniform mat4  gbufferProjectionInverse;

varying vec4 color;
varying vec2 lightCoord;
varying vec3 viewPos;
varying vec3 viewNormal;
varying vec3 sunVec;
varying vec3 upVec;

float eBS           = eyeBrightnessSmooth.y / 240.0;
float sunVisibility = clamp(dot(sunVec, upVec) + 0.0625, 0.0, 0.125) * 8.0;
float vsBrightness  = clamp(screenBrightness, 0.0, 1.0);
vec3  lightVec      = sunVec * ((timeAngle < 0.5325 || timeAngle > 0.9675) ? 1.0 : -1.0);

float GetLuminance(vec3 col) {
    return dot(col, vec3(0.299, 0.587, 0.114));
}

#include "/lib/color/blocklightColor.glsl"
#include "/lib/color/skyColor.glsl"
#include "/lib/color/dimensionColor.glsl"
#include "/lib/color/waterColor.glsl"
#include "/lib/util/spaceConversion.glsl"
#include "/lib/atmospherics/sky.glsl"
#include "/lib/atmospherics/fog.glsl"

/* DRAWBUFFERS:01 */
void main() {
    // DH vertex colors are sRGB — linearize to match Complementary's pipeline
    vec3 albedo = pow(max(color.rgb, vec3(0.0001)), vec3(2.2));

    float skyLight   = lightCoord.y;
    float blockLight = lightCoord.x;

    float minLighting  = MIN_LIGHT * 0.0035 * (vsBrightness * 0.0775 + 0.0125);
    vec3 sceneLighting = ambientCol * (skyLight * skyLight);
    vec3 blockLighting = blocklightCol * (blockLight * blockLight);
    vec3 minLight      = vec3(minLighting) * (1.0 - eBS);

    albedo *= (sceneLighting + blockLighting + minLight) * 4.0;

    // Face shading matching Complementary's quarterNdotU
    float quarterNdotU = clamp(0.25 * dot(viewNormal, upVec) + 0.75, 0.5, 1.0);
    albedo *= quarterNdotU * quarterNdotU;

    float lViewPos = length(viewPos);
    vec3  nViewPos = viewPos / lViewPos;
    float NdotU    = dot(nViewPos, upVec);

    // DH-specific fog: Complementary's startFog() uses vanilla 'far' as its scale,
    // so DH chunks (always beyond far) would be 100% fogged. Instead apply a gentle
    // fade that starts at the vanilla horizon and reaches full opacity 3x further out.
    // Use Complementary's sky color system for a matching fog color.
    vec3  worldPos   = ViewToWorld(viewPos);
    float dhFogStart = far * 0.9;
    float dhFogEnd   = far * 4.0;
    float dhFog      = clamp((lViewPos - dhFogStart) / (dhFogEnd - dhFogStart), 0.0, 1.0);
    dhFog = dhFog * dhFog; // quadratic — slow start, fast end near DH horizon

    // Match Complementary's horizon color using its sky and light system
    float sunVis2 = sunVisibility * sunVisibility;
    float sunVis8 = sunVis2 * sunVis2 * sunVis2 * sunVis2;
    float timeBright2 = sqrt(max(sin(timeAngle * 6.28318530718), 0.0));
    vec3  fogColorDH  = mix(lightCol * 0.5, skyColCustom * skyMult * 1.25, timeBright2);
    fogColorDH = mix(ambientNight * ambientNight, fogColorDH, sunVis8);
    fogColorDH *= FOG2_BRIGHTNESS;

    albedo = mix(albedo, fogColorDH, dhFog);

    // Apply Fog2 (ground haze) only — Fog1 would re-fog DH chunks completely
    albedo = Fog2(albedo, lViewPos, worldPos);

    gl_FragData[0] = vec4(albedo, 1.0);
    gl_FragData[1] = vec4(0.0, 0.0, 0.0, 1.0); // clear water/material flags for DH pixels
}
