/*
 * Distant Horizons terrain patch for ComplementaryShaders v4.7.2
 *
 * Must use #version 130 (not 330 core) so Iris's TransformPatcher routes to the
 * non-core branch where DH_TERRAIN is registered. The DHTerrainTransformer then:
 *   - Upgrades the shader to GLSL 4.10 core automatically
 *   - Renames gl_ModelViewMatrix  -> iris_ModelViewMatrix
 *   - Renames gl_ProjectionMatrix -> iris_ProjectionMatrix  (= dhProjection)
 *   - Renames gl_Vertex            -> getVertexPosition()   (decodes DH uvec4 vPosition)
 *   - Renames gl_Color             -> _vert_color
 *   - Renames gl_Normal            -> _vert_normal
 */

#version 130
#define OVERWORLD
#define VSH

#include "/lib/common.glsl"

varying vec4 color;
varying vec2 lightCoord;
varying vec3 viewPos;
varying vec3 viewNormal;
varying vec3 sunVec;
varying vec3 upVec;

void main() {
    // gl_ModelViewMatrix and gl_ProjectionMatrix are renamed by DHTerrainTransformer
    // gl_Vertex is replaced with getVertexPosition() which decodes DH's packed position
    vec4 vp    = gl_ModelViewMatrix * gl_Vertex;
    gl_Position = gl_ProjectionMatrix * vp;

    color      = gl_Color;
    lightCoord = clamp((gl_TextureMatrix[1] * gl_MultiTexCoord1).xy, 0.0, 1.0);
    viewPos    = vp.xyz;
    // mat3(gl_ModelViewMatrix) becomes mat3(iris_ModelViewMatrix) after transform
    viewNormal = normalize(mat3(gl_ModelViewMatrix) * gl_Normal);
    upVec      = normalize(gl_ModelViewMatrix[1].xyz);

    // Compute sunVec matching Complementary's terrain VSH exactly
    const vec2 sunRotationData = vec2(
        cos(sunPathRotation * 0.01745329251994),
        -sin(sunPathRotation * 0.01745329251994)
    );
    float ang = fract(timeAngle - 0.25);
    ang = (ang + (cos(ang * 3.14159265358979) * -0.5 + 0.5 - ang) / 3.0) * 6.28318530717959;
    sunVec = normalize((gl_ModelViewMatrix * vec4(vec3(-sin(ang), cos(ang) * sunRotationData) * 2000.0, 1.0)).xyz);
}
