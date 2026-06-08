# Shader Setup — Babylon Mod

This mod is designed around **ComplementaryShaders v4.7.2**. A patch is included to make it work with **Distant Horizons** (DH) so LOD chunks at the horizon are shaded rather than invisible when shaders are active.

## Required mods (Minecraft 1.20.1)

| Mod | Version | Notes |
|-----|---------|-------|
| [Iris Shaders](https://modrinth.com/mod/iris) | 1.7.6+mc1.20.1 | 1.7.5 has a DH_TERRAIN bug that breaks this |
| [Distant Horizons](https://modrinth.com/mod/distanthorizons) | 2.2.1-a | |
| [Sodium](https://modrinth.com/mod/sodium) | 0.5.11+mc1.20.1 | |
| [Indium](https://modrinth.com/mod/indium) | 1.0.36+mc1.20.1 | Required by DH when Sodium is present |

## Applying the patch

1. Download **ComplementaryShaders_v4.7.2** from [shaderlabs.org](https://shaderlabs.org) or the official Complementary page.
2. Place it in your shaderpacks folder (`.minecraft/shaderpacks/` or `run/shaderpacks/` in dev).
3. Open the `ComplementaryV4.7.2-DH-patch/` folder in this repo root.
4. Copy the 4 files from `ComplementaryV4.7.2-DH-patch/shaders/` into `ComplementaryShaders_v4.7.2/shaders/` — merging, not replacing.
   - If the shaderpack is still zipped, unzip it first, then drop the files into the `shaders/` folder inside.
5. The patch adds four files:
   - `dh_terrain.vsh` / `dh_terrain.fsh` — LOD terrain
   - `dh_water.vsh` / `dh_water.fsh` — LOD water

## Why a patch is needed

Complementary v4.7.2 predates Distant Horizons' Iris shader API. Without `dh_terrain` programs in the shaderpack, Iris marks the pack as DH-incompatible and DH chunks become invisible when shaders are on.

The patch shaders use Complementary's own lighting and color libraries so DH LODs match the look of nearby shaded chunks. A custom fog curve is used instead of Complementary's standard fog — vanilla fog uses the render distance as its scale, which would make DH chunks (always beyond that distance) fully opaque.

## Known limitations

- DH chunks won't receive shadows or reflections (these are too expensive to compute for LOD geometry).
- The visual seam at the DH boundary may be noticeable depending on lighting conditions. This is normal.
- This patch requires **Iris 1.7.6** specifically. Earlier builds have a missing `DH_TERRAIN` transform registration that causes the entire shader pipeline to disable when DH is present.
