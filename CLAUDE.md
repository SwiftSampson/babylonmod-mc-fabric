# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
./gradlew build          # Build the mod JAR → build/libs/babylonmod-0.1-1.20.1.jar
./gradlew runClient      # Launch Minecraft client with the mod loaded
./gradlew runDatagen     # Generate block models, blockstates, and world gen JSON into src/main/generated/
./gradlew runServer      # Run a dedicated server with the mod
```

There are no unit tests. The primary way to verify changes is `runClient`.

## Architecture Overview

**Mod ID:** `babylonmod` | **Package:** `com.palana.babylonmod` | **MC version:** 1.20.1 (Fabric)

The mod is a decorative/architectural content mod themed around ancient Mesopotamia (Babylon, Ishtar Gate, etc.). It is almost entirely blocks — one custom item (`babylon_wheat_seeds`) plus block items auto-generated for every registered block.

### Entry Points

| File | Interface | Purpose |
|------|-----------|---------|
| `BabylonMod.java` | `ModInitializer` | Registers blocks, items, item groups, world gen |
| `BabylonModClient.java` | `ClientModInitializer` | Sets render layers (cutout/translucent), color providers, Special Model Loader |
| `BabylonModDataGenerator.java` | `DataGeneratorEntrypoint` | Runs Fabric datagen providers |

### Block Registration Pattern

All blocks are registered as static fields in `ModBlocks.java` via a `registerBlock(name, Block)` helper that simultaneously creates and registers the associated `BlockItem`. Settings typically use `FabricBlockSettings.copyOf(Blocks.STONE)` (or another vanilla block) to inherit material properties.

When adding a new block:
1. Define it as a `public static final Block` in `ModBlocks.java`
2. Add it to the appropriate creative tab in `ModItemGroup.java`
3. Add blockstate JSON + model JSON (either by hand in `src/main/resources/assets/babylonmod/` or via datagen in `ModModelProvider.java`)

### Custom Block Types (`block/custom/`)

| Class | Behavior |
|-------|----------|
| `ModDirectionalBlock` | Horizontal facing (`FACING` property) |
| `ModDiagonalBlock` | Diagonal placement |
| `ModScalableBlock` | Size variants using `SizeType` enum |
| `ModConnectedBlock` / `ModConnectedLionBlock` | Connected-texture logic |
| `ModPassableStairBlock` | Visually thin but walkable |
| `ModIshtarGateBlock` | Multi-block Ishtar Gate structure |
| `ModProcessionalBlock` | Processional way block |
| `ModGrassBlock` | Custom grass with biome color tinting |
| `ModDynamicSandBlock` | Falling sand variant |
| `ModRugBlock` | Decorative rug (non-full-cube) |
| `DirectionalPalmLeaves` | Directional leaves for palm trees |

Block property enums live in `block/custom/types/` (`SizeType`, `LocationType`, `SandType`).

### Creative Tabs

Four tabs registered in `ModItemGroup.java`:
- `babylon_tab` — architectural blocks (peaks, arches, walls, windows)
- `mc_babylon_tab` — reskinned vanilla blocks
- `items` — decorative items (rugs, vases, barrels, crates)
- `new_blocks` — recent additions (glazed tiles, baked bricks, etc.)

### World Generation

Custom palm and chestnut tree generation lives in `world/tree/`. Trees are triggered by sapling interaction (`PalmSaplingGenerator`, `ChestnutSaplingGenerator`) rather than world feature placement. Custom trunk/foliage placers are registered through mixins (`FoliagePlacerTypeInvoker`, `TrunkPlacerTypeInvoker`) that access package-private vanilla registries.

### Asset Layout

```
src/main/resources/assets/babylonmod/
├── blockstates/        # One JSON per block defining model variants
├── models/block/       # Block model JSONs (including walls/ subfolder for multi-part walls)
├── models/item/        # Item model JSONs
├── textures/block/     # Block textures (PNG)
├── textures/item/
└── optifine/ctm/       # OptiFine connected-texture properties files
```

Generated assets (from `runDatagen`) go to `src/main/generated/` and are included in the build automatically via `sourceSets` in `build.gradle`.

### Dependencies

- **Fabric API** — core mod hooks
- **REI** (Roughly Enough Items) — recipe viewer; `compileOnly` at build time, available at runtime
- **Special Model Loader** — enables custom OBJ/complex models referenced from blockstate JSON
- **Team Reborn Energy** — included as jar-in-jar (not actively used for gameplay yet)
