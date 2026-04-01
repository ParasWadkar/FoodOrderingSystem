# Food Ordering System — JDBC Console App

A full **CRUD** food ordering system built in Java using JDBC and PreparedStatements.

---

## Project Structure

```
FoodOrderingSystem/
├── .gitignore                         ← Keeps credentials & build files off GitHub
├── db.properties                      ← Your DB credentials (never push this)
├── db.properties.example              ← Safe template for others to copy
├── setup.sql                          ← Run this first in MySQL
├── lib/
│   └── mysql-connector-j-8.x.xx.jar  ← MySQL JDBC driver (download separately)
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
**Never hardcode your password in Java files.** Instead, copy the example credentials file:
```bash
cp db.properties.example db.properties
```
Then open `db.properties` and fill in your details:
```properties
db.url=jdbc:mysql://localhost:3306/food_ordering_db
db.user=root
db.password=YOUR_PASSWORD_HERE
```
`DBConnection.java` reads from this file automatically. `db.properties` is listed in `.gitignore` so it will never be pushed to GitHub.

### 3. Add MySQL Connector/J
Download from: https://dev.mysql.com/downloads/connector/j/

Select **Platform Independent**, download the ZIP, unzip it, and place the `.jar` file inside the `lib/` folder in your project root.

---

## Compile & Run

Always run these commands from the **project root** (`FoodOrderingSystem/`), not from inside `src/`. This is important because Java needs to find `db.properties` which lives in the root folder.

```bash
# Compile (Windows)
javac -cp ".;lib/mysql-connector-j-8.x.xx.jar" -d out src/db/*.java src/model/*.java src/dao/*.java src/FoodOrderingSystem.java

# Run (Windows)
java -cp ".;lib/mysql-connector-j-8.x.xx.jar;out" FoodOrderingSystem
```

```bash
# Compile (Mac/Linux)
javac -cp ".:lib/mysql-connector-j-8.x.xx.jar" -d out src/db/*.java src/model/*.java src/dao/*.java src/FoodOrderingSystem.java

# Run (Mac/Linux)
java -cp ".:lib/mysql-connector-j-8.x.xx.jar:out" FoodOrderingSystem
```

> Replace `8.x.xx` with the actual version number of your JAR file.

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
*Built with Java + JDBC + MySQL | PreparedStatements throughout*