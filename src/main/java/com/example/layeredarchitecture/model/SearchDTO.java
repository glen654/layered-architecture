package com.example.layeredarchitecture.model;

public class SearchDTO {
    private String orderId;
    private String orderDate;
    private String description;
    private String qty;
    private String unitPrice;

    public SearchDTO() {
    }

    public SearchDTO(String orderId, String orderDate, String description, String qty, String unitPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", description='" + description + '\'' +
                ", qty='" + qty + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}