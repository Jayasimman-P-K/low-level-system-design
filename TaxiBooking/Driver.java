package TaxiBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TaxiBooking.Enum.Location;
import TaxiBooking.Models.Taxi;
import TaxiBooking.Services.BookingService;
import TaxiBooking.Services.TaxiService;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create taxis
        List<Taxi> taxis = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            taxis.add(new Taxi(i + ""));
        }

        // initialize services
        TaxiService taxiService = new TaxiService(taxis);
        BookingService bookingService = new BookingService(taxiService);

        boolean loop = true;
        while (loop) {
            System.out.print("\n1. Book Taxi\n2. Display Taxi Details\n3. Exit\n");      
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            
            switch(option) {
                // book taxi
                case 1: {
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();

                    System.out.print("Enter Pickup Point (A-F): ");
                    String pickupPointStr = scanner.next().toUpperCase();
                    Location pickupPoint = Location.valueOf(pickupPointStr);

                    System.out.print("Enter Drop Point (A-F): ");
                    String dropPointStr = scanner.next().toUpperCase();
                    Location dropPoint = Location.valueOf(dropPointStr);

                    boolean bookingResult = bookingService.bookTaxi(customerId, pickupPoint, dropPoint);
                    if (!bookingResult) {
                        System.out.println("No taxi available for booking.");
                    }
                    break;
                }

                // display taxi details
                case 2: {
                    taxiService.displayTaxiDetails();
                    break;
                }

                // exit the application
                case 3: {
                    loop = false;
                    System.out.println("Exiting the application...");
                    break;
                }

                default : {
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
                }
            }
        }

        scanner.close();
    }
}
