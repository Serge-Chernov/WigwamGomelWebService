package com.example.vigwamgomel.enums;

public enum OrderStatus {
    PROCESSED("Ожидает подтверждения"),
    CANCELED("Отменен"),
    IN_PROGRESS("Изготавливается"),
    COMPLETE("Готов к выдаче");

    private final String displayValue;

    private OrderStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static OrderStatus getEnum(String value) {
        for(OrderStatus s : values())
            if(s.getDisplayValue().equalsIgnoreCase(value)) return s;
        throw new IllegalArgumentException();
    }
}
