package com.example.vigwamgomel.enums;

public enum WindowsCount {
    NONE("0"),
    ONE("1"),
    TWO("2"),
    THREE("3");

    private final String displayValue;

    private WindowsCount(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static WindowsCount getEnum(String value) {
        for(WindowsCount w : values())
            if(w.getDisplayValue().equalsIgnoreCase(value)) return w;
        throw new IllegalArgumentException();
    }
}
