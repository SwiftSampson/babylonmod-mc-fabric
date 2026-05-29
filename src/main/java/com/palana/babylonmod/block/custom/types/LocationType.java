package com.palana.babylonmod.block.custom.types;

import net.minecraft.util.StringIdentifiable;

public enum LocationType implements StringIdentifiable {
    MIDDLE("middle"),
    LEFT("left"),
    RIGHT("right"),
    TOP("top"),
    BOTTOM("bottom");

    private final String name;

    private LocationType(String pName) {
        this.name = pName;
    }

    public String asString() {
        return this.name;
    }
}