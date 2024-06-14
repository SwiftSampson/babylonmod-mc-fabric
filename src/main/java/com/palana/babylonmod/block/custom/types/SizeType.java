package com.palana.babylonmod.block.custom.types;

import net.minecraft.util.StringIdentifiable;

public enum SizeType implements StringIdentifiable {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    EXTRA_LARGE("extra_large");

    private final String name;

    private SizeType(String pName) {
        this.name = pName;
    }

    public String asString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }

}