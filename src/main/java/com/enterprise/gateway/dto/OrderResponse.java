package com.enterprise.gateway.dto;

public class OrderResponse {

    private String orderId;

    private String status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}