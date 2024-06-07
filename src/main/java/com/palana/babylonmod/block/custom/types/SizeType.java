package com.palana.babylonmod.block.custom.types;

import net.minecraft.util.StringRepresentable;

public enum SizeType implements StringRepresentable {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    EXTRA_LARGE("extra_large");

    private final String name;

    private SizeType(String pName) {
        this.name = pName;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }

}