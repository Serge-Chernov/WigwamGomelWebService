package com.example.vigwamgomel.DTO;

public class OrderStatusDTO {
    private String status;

    private String orderId;

    private String userId;

    public OrderStatusDTO() {
    }

    public OrderStatusDTO(String status, String orderId, String userId) {
        this.status = status;
        this.orderId = orderId;
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
