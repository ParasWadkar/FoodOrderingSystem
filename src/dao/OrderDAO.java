package dao;
import db.DBConnection;
import model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OrderDAO {
public void placeOrder(int customerId, int itemId, int quantity, double totalPrice) throws SQLException {
String sql = "INSERT INTO orders (customer_id, item_id, quantity, total_price) VALUES (?, ?, ?, ?)";
try (Connection conn = DBConnection.getConnection();
PreparedStatement pstmt = conn.prepareStatement(sql)) {
pstmt.setInt(1, customerId);
pstmt.setInt(2, itemId);
pstmt.setInt(3, quantity);
pstmt.setDouble(4, totalPrice);
pstmt.executeUpdate();
}
}
public List<Order> getAllOrders() throws SQLException {
List<Order> orders = new ArrayList<>();
String sql = "SELECT * FROM orders";
try (Connection conn = DBConnection.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql)) {
while (rs.next()) {
orders.add(new Order(rs.getInt("order_id"), rs.getInt("customer_id"), rs.getInt("item_id"), rs.getInt("quantity"), rs.getDouble("total_price")));
}
}
return orders;
}
public void updateOrderQuantity(int orderId, int newQuantity, double newTotalPrice) throws SQLException {
String sql = "UPDATE orders SET quantity = ?, total_price = ? WHERE order_id = ?";
try (Connection conn = DBConnection.getConnection();
PreparedStatement pstmt = conn.prepareStatement(sql)) {
pstmt.setInt(1, newQuantity);
pstmt.setDouble(2, newTotalPrice);
pstmt.setInt(3, orderId);
pstmt.executeUpdate();
}
}
public void deleteOrder(int orderId) throws SQLException {
String sql = "DELETE FROM orders WHERE order_id = ?";
try (Connection conn = DBConnection.getConnection();
PreparedStatement pstmt = conn.prepareStatement(sql)) {
pstmt.setInt(1, orderId);
pstmt.executeUpdate();
}
}
}