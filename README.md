# Food Ordering System — JDBC Console App

A full **CRUD** food ordering system built in Java using JDBC and PreparedStatements.

---

## Project Structure

```
FoodOrderingSystem/
├── setup.sql                          ← Run this first in MySQL
└── src/
    ├── FoodOrderingSystem.java        ← Main entry point (menu-driven UI)
    ├── db/
    │   └── DBConnection.java          ← JDBC connection manager
    ├── model/
    │   ├── Customer.java
    │   ├── MenuItem.java
    │   └── Order.java
    └── dao/
        ├── CustomerDAO.java           ← Customer CRUD
        ├── MenuDAO.java               ← Menu READ
        └── OrderDAO.java              ← Order CRUD (full)
```

---

## Setup Steps

### 1. MySQL Database
Open MySQL Workbench (or terminal) and run:
```sql
source setup.sql
```
This creates the database, 3 tables, and sample data.

### 2. Configure DB Credentials
Open `src/db/DBConnection.java` and set:
```java
private static final String DB_URL  = "jdbc:mysql://localhost:3306/food_ordering_db";
private static final String USER     = "root";      // ← your username
private static final String PASSWORD = "yourpass";  // ← your password
```

### 3. Add MySQL Connector/J to classpath
Download from: https://dev.mysql.com/downloads/connector/j/

Place the JAR in your project folder, then compile with it on the classpath.

---

## Compile & Run

From the `src/` folder:

```bash
# Compile
javac -cp ".;../mysql-connector-j-8.x.xx.jar" db/*.java model/*.java dao/*.java FoodOrderingSystem.java

# Run
java -cp ".;../mysql-connector-j-8.x.xx.jar" FoodOrderingSystem
```

> On Mac/Linux replace `;` with `:`

---

## Features (Full CRUD)

| Operation | Feature                    |
|-----------|----------------------------|
| CREATE    | Place Order, Add Customer  |
| READ      | Display Menu, View Orders  |
| UPDATE    | Update Order (item + qty)  |
| DELETE    | Delete Order               |

---

## Database Schema

```
customers          menu               orders
──────────         ────────           ──────────────────────
customer_id (PK)   item_id (PK)       order_id (PK)
name               item_name          customer_id (FK)
                   price              item_id (FK)
                                      quantity
                                      total_price
```

---

## Notes for GUI Migration (Next Step)
- All business logic is inside DAOs — zero changes needed when adding GUI
- Just wire your JButtons to call the same DAO methods
- Consider making DAOs return result objects/messages instead of printing

---
*Built with Java + JDBC + MySQL*
