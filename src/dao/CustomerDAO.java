package dao;
import db.DBConnection;
import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CustomerDAO {
public void addCustomer(String name) throws SQLException {
String sql = "INSERT INTO customers (name) VALUES (?)";
try (Connection conn = DBConnection.getConnection();
PreparedStatement pstmt = conn.prepareStatement(sql)) {
pstmt.setString(1, name);
pstmt.executeUpdate();
}
}
public List<Customer> getAllCustomers() throws SQLException {
List<Customer> customers = new ArrayList<>();
String sql = "SELECT * FROM customers";
try (Connection conn = DBConnection.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql)) {
while (rs.next()) {
customers.add(new Customer(rs.getInt("customer_id"), rs.getString("name")));
}
}
return customers;
}
}