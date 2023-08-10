package com.example.vigwamgomel.enums;

public enum WigwamBottomType {
    SLIM("Тонкий"),
    FAT("Толстый");

    private final String displayValue;

    private WigwamBottomType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static WigwamBottomType getEnum(String value) {
        for(WigwamBottomType b : values())
            if(b.getDisplayValue().equalsIgnoreCase(value)) return b;
        throw new IllegalArgumentException();
    }
}
