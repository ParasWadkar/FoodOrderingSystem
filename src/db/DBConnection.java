package db;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DBConnection {
public static Connection getConnection() throws SQLException {
Properties props = new Properties();
try (FileInputStream fis = new FileInputStream("db.properties")) {
props.load(fis);
} catch (IOException e) {
e.printStackTrace();
return null;
}
return DriverManager.getConnection(
props.getProperty("db.url"),
props.getProperty("db.user"),
props.getProperty("db.password")
);
}
}