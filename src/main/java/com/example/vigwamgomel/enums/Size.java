package com.example.vigwamgomel.enums;

public enum Size {
    SMALL("110*110"),
    MEDIUM("115*115"),
    LARGE("120*120");

    private final String displayValue;

    private Size(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static Size getEnum(String value) {
        for(Size s : values())
            if(s.getDisplayValue().equalsIgnoreCase(value)) return s;
        throw new IllegalArgumentException();
    }
}
