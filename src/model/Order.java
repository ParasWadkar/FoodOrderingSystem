package model;
public class Order {
private int orderId;
private int customerId;
private int itemId;
private int quantity;
private double totalPrice;
public Order(int orderId, int customerId, int itemId, int quantity, double totalPrice) {
this.orderId = orderId;
this.customerId = customerId;
this.itemId = itemId;
this.quantity = quantity;
this.totalPrice = totalPrice;
}
public int getOrderId() { return orderId; }
public int getCustomerId() { return customerId; }
public int getItemId() { return itemId; }
public int getQuantity() { return quantity; }
public double getTotalPrice() { return totalPrice; }
}