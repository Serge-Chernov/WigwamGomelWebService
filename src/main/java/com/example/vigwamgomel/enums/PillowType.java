package com.example.vigwamgomel.enums;

public enum PillowType {
    SQUARE( "Квадратная"),
    ROUND("Круглая"),
    STAR("Звезда"),
    CLOUD("Облако");


    private final String displayValue;

    private PillowType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static PillowType getEnum(String value) {
        for(PillowType p : values())
            if(p.getDisplayValue().equalsIgnoreCase(value)) return p;
        throw new IllegalArgumentException();
    }
}
