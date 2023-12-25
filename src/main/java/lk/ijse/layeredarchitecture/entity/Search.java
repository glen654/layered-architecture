package lk.ijse.layeredarchitecture.entity;

public class Search {
    private String orderId;
    private String orderDate;
    private String description;
    private String qty;
    private String unitPrice;

    public Search() {
    }

    public Search(String orderId, String orderDate, String description, String qty, String unitPrice) {
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
}
