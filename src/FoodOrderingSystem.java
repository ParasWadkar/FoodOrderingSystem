import dao.CustomerDAO;
import dao.MenuDAO;
import dao.OrderDAO;
import model.Customer;
import model.MenuItem;
import model.Order;
import java.util.List;
import java.util.Scanner;
public class FoodOrderingSystem {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
CustomerDAO customerDAO = new CustomerDAO();
MenuDAO menuDAO = new MenuDAO();
OrderDAO orderDAO = new OrderDAO();
boolean running = true;
while (running) {
System.out.println("--- Food Ordering System ---");
System.out.println("1. View Menu");
System.out.println("2. View Customers");
System.out.println("3. Place Order");
System.out.println("4. View All Orders");
System.out.println("5. Update Order Quantity");
System.out.println("6. Delete Order");
System.out.println("7. Exit");
System.out.print("Choose an option: ");
int choice = scanner.nextInt();
try {
switch (choice) {
case 1:
List<MenuItem> menu = menuDAO.getAllMenuItems();
for (MenuItem item : menu) {
System.out.println(item.getId() + ". " + item.getName() + " - $" + item.getPrice());
}
break;
case 2:
List<Customer> customers = customerDAO.getAllCustomers();
for (Customer c : customers) {
System.out.println(c.getId() + ". " + c.getName());
}
break;
case 3:
System.out.print("Enter Customer ID: ");
int customerId = scanner.nextInt();
System.out.print("Enter Menu Item ID: ");
int itemId = scanner.nextInt();
System.out.print("Enter Quantity: ");
int quantity = scanner.nextInt();
double price = 0;
for (MenuItem item : menuDAO.getAllMenuItems()) {
if (item.getId() == itemId) {
price = item.getPrice();
break;
}
}
double total = price * quantity;
orderDAO.placeOrder(customerId, itemId, quantity, total);
System.out.println("Order placed successfully! Total: $" + total);
break;
case 4:
List<Order> orders = orderDAO.getAllOrders();
for (Order o : orders) {
System.out.println("Order ID: " + o.getOrderId() + " | Customer ID: " + o.getCustomerId() + " | Item ID: " + o.getItemId() + " | Qty: " + o.getQuantity() + " | Total: $" + o.getTotalPrice());
}
break;
case 5:
System.out.print("Enter Order ID to update: ");
int orderId = scanner.nextInt();
System.out.print("Enter new Quantity: ");
int newQty = scanner.nextInt();
System.out.print("Enter new Total Price: ");
double newTotal = scanner.nextDouble();
orderDAO.updateOrderQuantity(orderId, newQty, newTotal);
System.out.println("Order updated!");
break;
case 6:
System.out.print("Enter Order ID to delete: ");
int delId = scanner.nextInt();
orderDAO.deleteOrder(delId);
System.out.println("Order deleted!");
break;
case 7:
running = false;
System.out.println("Exiting...");
break;
default:
System.out.println("Invalid option.");
}
} catch (Exception e) {
System.out.println("Error: " + e.getMessage());
}
}
scanner.close();
}
}