package ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Models.ParkingLevel;
import ParkingLot.Models.ParkingSpot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle;
import ParkingLot.Services.EntryGate;
import ParkingLot.Services.ExitGate;
import ParkingLot.Services.ParkingLotService;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<ParkingLevel> parkingLevels = new ArrayList<>();
        parkingLevels.add(new ParkingLevel(1, 10, VehicleType.MOTORCYCLE));
        parkingLevels.add(new ParkingLevel(2, 10, VehicleType.CAR));
        parkingLevels.add(new ParkingLevel(3, 10, VehicleType.TRUCK));

        ParkingLotService parkingLotService = new ParkingLotService(parkingLevels);
        EntryGate entryGate = new EntryGate("EntryGate1", parkingLotService);
        ExitGate exitGate = new ExitGate("ExitGate1", parkingLotService);

        boolean loop = true;
        while (loop) {
            System.out.println("\n1. Park vehicle\n2. Leave parking lot\n3. Check availablity of parking lot\n4. Exit\n");
            System.out.print("Choose an option: ");
           
            int option = scanner.nextInt();
            switch (option) {
                case 1: {
                    System.out.print("Enter vehicle type(MOTORCYCLE/CAR/TRUCK): ");
                    VehicleType vehicleType = VehicleType.valueOf(scanner.next().toUpperCase());
                    System.out.print("Enter license plate no: ");
                    String licensePlate = scanner.next();
                   
                    Vehicle vehicle = new Vehicle(licensePlate, vehicleType);
                    Ticket ticket = entryGate.issueTicket(vehicle);
                    
                    if (ticket != null) {
                        System.out.println("Vehicle parked. Ticket ID: " + ticket.getTicketId());
                    } else {
                        System.out.println("No available spots for this Vehicle type");
                    }

                    break;
                }

                case 2: {
                    System.out.print("Enter license plate number: ");
                    String licensePlate = scanner.next();

                    for (ParkingLevel parkingLevel : parkingLevels) {
                        for (ParkingSpot parkingSpot : parkingLevel.getParkingSpots()) {
                            if (parkingSpot.isOccupied() && parkingSpot.getVehicle().getLicencePlate().equals(licensePlate)) {
                                Ticket leavingTicket = new Ticket(UUID.randomUUID().toString(), parkingSpot.getVehicle(), parkingSpot, null);
                                exitGate.processTicket(leavingTicket);
                                System.out.println("vehicle left the spot.");
                                break;
                            }
                        }
                    }

                    break;
                }

                case 3: {
                    parkingLotService.getAvailableParkingSpots();
                    break;
                }

                case 4: {
                    loop = false;
                    break;
                }

                default: {
                    System.out.println("Not an option. Choose a correct option.");
                    break;
                }
            }
        }
    
        scanner.close();
    }
}
