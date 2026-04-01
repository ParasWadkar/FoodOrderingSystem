import dao.CustomerDAO;
import model.Customer;
import java.util.List;
public class TestMain {
public static void main(String[] args) {
try {
CustomerDAO dao = new CustomerDAO();
System.out.println("--- Adding a new customer ---");
dao.addCustomer("Test User");
System.out.println("--- Fetching all customers ---");
List<Customer> list = dao.getAllCustomers();
for (Customer c : list) {
System.out.println("ID: " + c.getId() + " | Name: " + c.getName());
}
} catch (Exception e) {
System.err.println("Error: " + e.getMessage());
e.printStackTrace();
}
}
}