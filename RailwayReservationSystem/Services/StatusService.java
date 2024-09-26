package RailwayReservationSystem.Services;

import RailwayReservationSystem.Models.Passenger;
import RailwayReservationSystem.Models.Train;

public class StatusService {
    public void printStatus(Train train) {
        System.out.println("Confirmed Passengers: ");
        for (Passenger p : train.getLowerBerth()) {
            System.out.println("Passenger: " + p.getPassengerName() + " | Ticket number: " + p.getTicketNumber() + " | Berth: Lower berth.");
        }

        for (Passenger p : train.getMiddleBerth()) {
            System.out.println("Passenger: " + p.getPassengerName() + " | Ticket: " + p.getTicketNumber() + " | Berth: Middle berth.");
        }

        for (Passenger p : train.getUpperBerth()) {
            System.out.println("Passenger: " + p.getPassengerName() + " | Ticket: " + p.getTicketNumber() + " | Berth: Upper berth.");
        }

        System.out.println("Waitlisted Passengers: "); 
        for (Passenger p : train.getWaitingList()) {
            System.out.println("Passenger: " + p.getPassengerName() + " | Ticket: " + p.getTicketNumber() + " | Status: Waiting list.");
        }
    }
}
