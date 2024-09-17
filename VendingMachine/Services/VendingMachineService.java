package VendingMachine.Services;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import VendingMachine.Enums.Coin;
import VendingMachine.Enums.Note;
import VendingMachine.Models.Product;
import VendingMachine.Models.Transaction;
import VendingMachine.Models.VendingMachine;

public class VendingMachineService {
    private VendingMachine vendingMachine;
    private ReentrantLock lock = new ReentrantLock();

    public VendingMachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public String purchaseProduct(String productName, List<Coin> coins, List<Note> notes) {
        lock.lock();
        try {
            Product product = vendingMachine.getProduct(productName);
            if (product == null) {
                return "Product not found.";
            }

            if (product.getQuantity() <= 0) {
                return "Product out of stock.";
            }

            double totalAmount = calculateTotalAmount(coins, notes);
            if (totalAmount < product.getPrice()) {
                return "Insufficient funds.";
            }

            double change = totalAmount - product.getPrice();
            if (!canProvideChange(change)) {
                return "Cannot provide change.";
            }

            product.setQuantity(product.getQuantity() - 1);
            vendingMachine.addToTotalMoney(product.getPrice());

            @SuppressWarnings("unused")
            Transaction transaction = new Transaction(product, totalAmount, change, coins, notes);
            updateCoinAndNoteInventory(coins, notes);

            return "Purchase successful. Change: " + change;
        } finally {
            lock.unlock();
        }
    }

    public void restockProduct(String productName, int quantity) {
        lock.lock();
        try {
            Product product = vendingMachine.getProduct(productName);
            if (product != null) {
                product.setQuantity(product.getQuantity() + quantity);
            }
        } finally {
            lock.unlock();
        }
    }

    public void collectMoney() {
        lock.lock();
        try {
            vendingMachine.addToTotalMoney(-vendingMachine.getTotalMoney());
        } finally {
            lock.unlock();
        }
    }

    private double calculateTotalAmount(List<Coin> coins, List<Note> notes) {
        double total = 0.0;
        for (Coin coin : coins) {
            total += coin.getValue();
        }
        for (Note note : notes) {
            total += note.getValue();
        }
        return total;
    }

    private boolean canProvideChange(double change) {
        // Logic to check if the machine can provide change
        // This is a simplified version and may need more complex logic
        return change <= vendingMachine.getTotalMoney();
    }

    private void updateCoinAndNoteInventory(List<Coin> coins, List<Note> notes) {
        for (Coin coin : coins) {
            vendingMachine.addCoins(coin, 1);
        }
        for (Note note : notes) {
            vendingMachine.addNotes(note, 1);
        }
    }
}
