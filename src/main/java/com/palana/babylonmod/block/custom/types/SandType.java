package com.palana.babylonmod.block.custom.types;

import net.minecraft.util.StringIdentifiable;

public enum SandType implements StringIdentifiable {
    SAND("sand"),
    MYCELIUM("mycelium"),
    RED_SAND("red_sand"),
    GRASS_TWO("grass_two"),
    PODZOL("podzol"),
    GRASS_BLOCK("grass_block");

    private final String name;

    private SandType(String pName) {
        this.name = pName;
    }

    public String asString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}