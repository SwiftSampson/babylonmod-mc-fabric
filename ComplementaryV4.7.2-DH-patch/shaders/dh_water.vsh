/*
 * Distant Horizons water patch for ComplementaryShaders v4.7.2
 * See dh_terrain.vsh for the explanation of why #version 130 is required.
 */

#version 130
#define OVERWORLD
#define DH_WATER
#define VSH

#include "/lib/common.glsl"

varying vec4 color;
varying vec2 lightCoord;
varying vec3 viewPos;
varying vec3 viewNormal;
varying vec3 sunVec;
varying vec3 upVec;

void main() {
    vec4 vp    = gl_ModelViewMatrix * gl_Vertex;
    gl_Position = gl_ProjectionMatrix * vp;

    color      = gl_Color;
    lightCoord = clamp((gl_TextureMatrix[1] * gl_MultiTexCoord1).xy, 0.0, 1.0);
    viewPos    = vp.xyz;
    viewNormal = normalize(mat3(gl_ModelViewMatrix) * gl_Normal);
    upVec      = normalize(gl_ModelViewMatrix[1].xyz);

    const vec2 sunRotationData = vec2(
        cos(sunPathRotation * 0.01745329251994),
        -sin(sunPathRotation * 0.01745329251994)
    );
    float ang = fract(timeAngle - 0.25);
    ang = (ang + (cos(ang * 3.14159265358979) * -0.5 + 0.5 - ang) / 3.0) * 6.28318530717959;
    sunVec = normalize((gl_ModelViewMatrix * vec4(vec3(-sin(ang), cos(ang) * sunRotationData) * 2000.0, 1.0)).xyz);
}
