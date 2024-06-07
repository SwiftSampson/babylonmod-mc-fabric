package com.palana.babylonmod.block.custom.types;

import net.minecraft.util.StringRepresentable;

public enum LocationType implements StringRepresentable {
    MIDDLE("middle"),
    LEFT("left"),
    RIGHT("right");

    private final String name;

    private LocationType(String pName) {
        this.name = pName;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}