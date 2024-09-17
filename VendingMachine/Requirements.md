# Designing a Vending Machine

## Requirements

1. The vending machine should support multiple products with different prices and quantities.
2. The machine should accept coins and notes of different denominations.
3. The machine should dispense the selected product and return change if necessary.
4. The machine should keep track of the available products and their quantities.
5. The machine should handle multiple transactions concurrently and ensure data consistency.
6. The machine should provide an interface for restocking products and collecting money.
7. The machine should handle exceptional scenarios, such as insufficient funds or out-of-stock products.

### Project Structure

```css
src
├── enums
│   ├── Coin.java
│   └── Note.java
├── models
│   ├── Product.java
│   ├── VendingMachine.java
│   └── Transaction.java
├── services
│   └── VendingMachineService.java
└── main
    └── Driver.java
```

## Explanation

1. **Product Model**: Represents a product with a name, price, and quantity.
2. **Coin Enum**: Represents different coin denominations.
3. **Note Enum**: Represents different note denominations.
4. **Transaction Model**: Represents a transaction with details of the product, amount paid, change, coins, and notes used.
5. **VendingMachine Model**: Represents the vending machine with products, coins, notes, and total money.
6. **VendingMachineService Class**: Provides methods for purchasing products, restocking products, and collecting money. Uses locks to ensure thread safety.
7. **Driver Class**: The main class that simulates the vending machine operations with user interaction through the console.
