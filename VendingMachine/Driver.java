package VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VendingMachine.Enums.Coin;
import VendingMachine.Enums.Note;
import VendingMachine.Models.Product;
import VendingMachine.Models.VendingMachine;
import VendingMachine.Services.VendingMachineService;

public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineService vendingMachineService = new VendingMachineService(vendingMachine);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Sample Products
        vendingMachine.addProduct(new Product("Soda", 1.25, 10));
        vendingMachine.addProduct(new Product("Chips", 1.00, 5));
        vendingMachine.addProduct(new Product("Candy", 0.75, 20));

        while (running) {
            System.out.println("Enter command (purchase, restock, collect, exit): ");
            String command = scanner.nextLine();

            switch (command) {
                case "purchase":
                    System.out.println("Enter product name: ");
                    String productName = scanner.nextLine();

                    System.out.println("Enter coins (PENNY, NICKEL, DIME, QUARTER) separated by commas: ");
                    String coinInput = scanner.nextLine();
                    List<Coin> coins = parseCoins(coinInput);

                    System.out.println("Enter notes (ONE, FIVE, TEN, TWENTY) separated by commas: ");
                    String noteInput = scanner.nextLine();
                    List<Note> notes = parseNotes(noteInput);

                    String result = vendingMachineService.purchaseProduct(productName, coins, notes);
                    System.out.println(result);
                    break;

                case "restock":
                    System.out.println("Enter product name: ");
                    String productNameToRestock = scanner.nextLine();
                    System.out.println("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    vendingMachineService.restockProduct(productNameToRestock, quantity);
                    System.out.println("Product restocked.");
                    break;

                case "collect":
                    vendingMachineService.collectMoney();
                    System.out.println("Money collected.");
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }

    private static List<Coin> parseCoins(String coinInput) {
        List<Coin> coins = new ArrayList<>();
        if (!coinInput.trim().isEmpty()) {
            String[] coinStrings = coinInput.split(",");
            for (String coinString : coinStrings) {
                coins.add(Coin.valueOf(coinString.trim().toUpperCase()));
            }
        }
        return coins;
    }

    private static List<Note> parseNotes(String noteInput) {
        List<Note> notes = new ArrayList<>();
        if (!noteInput.trim().isEmpty()) {
            String[] noteStrings = noteInput.split(",");
            for (String noteString : noteStrings) {
                notes.add(Note.valueOf(noteString.trim().toUpperCase()));
            }
        }
        return notes;
    }
}
