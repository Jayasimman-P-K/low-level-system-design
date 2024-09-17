package VendingMachine.Models;

import java.util.List;

import VendingMachine.Enums.Note;
import VendingMachine.Enums.Coin;

public class Transaction {
    private Product product;
    private double amountPaid;
    private double change;
    private List<Coin> coins;
    private List<Note> notes;

    public Transaction(Product product, double amountPaid, double change, List<Coin> coins, List<Note> notes) {
        this.product = product;
        this.amountPaid = amountPaid;
        this.change = change;
        this.coins = coins;
        this.notes = notes;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Product: " + product +
                ", Amount Paid: " + amountPaid +
                ", Change: " + change +
                ", Coins: " + coins +
                ", Notes: " + notes + 
                "}";
    }
}
