package dao;
import db.DBConnection;
import model.MenuItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MenuDAO {
public List<MenuItem> getAllMenuItems() throws SQLException {
List<MenuItem> menu = new ArrayList<>();
String sql = "SELECT * FROM menu";
try (Connection conn = DBConnection.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql)) {
while (rs.next()) {
menu.add(new MenuItem(rs.getInt("item_id"), rs.getString("item_name"), rs.getDouble("price")));
}
}
return menu;
}
}