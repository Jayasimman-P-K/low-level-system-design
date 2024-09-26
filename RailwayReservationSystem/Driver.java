package RailwayReservationSystem;

import java.util.Scanner;

import RailwayReservationSystem.Models.Passenger;
import RailwayReservationSystem.Models.Train;
import RailwayReservationSystem.Services.BookingService;
import RailwayReservationSystem.Services.CancellationService;
import RailwayReservationSystem.Services.StatusService;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create the train
        Train train = new Train();

        // initiate the services
        BookingService  bookingService = new BookingService();
        CancellationService  cancellationService = new CancellationService();
        StatusService statusService = new StatusService();

        boolean loop = true;
        while (loop) {
            System.out.print("\n1. Book Ticket\n2. Cancel Ticket\n3. Check Status\n4. Exit\n");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch(option) {
                // Book ticket
                case 1: {
                    System.out.print("Enter the passenger name: ");
                    String passengerName = scanner.next();
                    System.out.print("Enter preferred berth (LOWER, MIDDLE, UPPER): ");
                    String preferredBerth = scanner.next().toUpperCase();

                    Passenger passenger = new Passenger(passengerName, preferredBerth);

                    if (bookingService.bookTicket(passenger, train)) {
                        System.out.println("Ticket Booked for " + passenger.getPassengerName() + " | Ticket number: " + passenger.getTicketNumber());
                    } else {
                        System.out.println("Booking Failed. No seats or waitlist available.");
                    }
                    break;
                }

                // cancel ticket 
                case 2: {
                    System.out.println("Enter passenger name for cancellation: ");
                    String passengerName = scanner.next();
                    Passenger passenger = new Passenger(passengerName, "");
                    if (cancellationService.cancelTicket(passenger, train)) {
                        System.out.println("Ticket cancelled for " + passengerName);
                    } else {
                        System.out.println("Cancellation failed, Passenger not found!!");
                    }
                    break;
                }

                // check for the status 
                case 3: {
                    statusService.printStatus(train);
                    break;
                }

                // exit the application
                case 4: {
                    loop = false;
                    System.out.println("Exiting the application...");
                    break;
                }

                default: {
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
                }
            }

        }

        scanner.close();
    }
}
