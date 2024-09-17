package VendingMachine.Models;

import java.util.HashMap;
import java.util.Map;

import VendingMachine.Enums.Coin;
import VendingMachine.Enums.Note;

public class VendingMachine {
    private Map<String, Product> products = new HashMap<>();
    private Map<Coin, Integer> coins = new HashMap<>();
    private Map<Note, Integer> notes = new HashMap<>();
    private double totalMoney;

    public VendingMachine() {
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
        for (Note note : Note.values()) {
            notes.put(note, 0);
        }
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public void addCoins(Coin coin, int quantity) {
        coins.put(coin, coins.get(coin) + quantity);
    }

    public void addNotes(Note note, int quantity) {
        notes.put(note, notes.get(note) + quantity);
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void addToTotalMoney(double amount) {
        totalMoney += amount;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public Map<Note, Integer> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "products=" + products +
                ", coins=" + coins +
                ", notes=" + notes +
                ", totalMoney=" + totalMoney +
                '}';
    }
}


