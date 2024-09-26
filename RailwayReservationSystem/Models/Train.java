package RailwayReservationSystem.Models;

import java.util.ArrayList;
import java.util.List;

import RailwayReservationSystem.Enum.BookingStatus;

public class Train {
    private final List<Passenger> lowerBerth;
    private final List<Passenger> middleBerth;
    private final List<Passenger> upperBerth;
    private final List<Passenger> waitingList;

    public Train() {
        this.lowerBerth = new ArrayList<>(20);
        this.middleBerth = new ArrayList<>(20);
        this.upperBerth = new ArrayList<>(20);  
        this.waitingList = new ArrayList<>(10);
    }

    // check availability and assign a seat based on preference
    public boolean bookTicket(Passenger passenger) {
        String preferredBerth = passenger.getPreferredBerth();

        if (preferredBerth.equals("LOWER")) {
            if (lowerBerth.size() < 20) {
                lowerBerth.add(passenger);
                assignTicket(passenger, "LOWER", lowerBerth.size());
                return true;
            } else if (middleBerth.size() < 20) {
                middleBerth.add(passenger);
                assignTicket(passenger, "MIDDLE", middleBerth.size());
                return true;
            } else if (upperBerth.size() < 20) {
                upperBerth.add(passenger);
                assignTicket(passenger, "UPPER", upperBerth.size());
                return true;
            }
        } else if (preferredBerth.equals("MIDDLE")) {
            if (middleBerth.size() < 20) {
                middleBerth.add(passenger);
                assignTicket(passenger, "MIDDLE", middleBerth.size());
                return true;
            } else if (lowerBerth.size() < 20) {
                lowerBerth.add(passenger);
                assignTicket(passenger, "LOWER", lowerBerth.size());
                return true;
            } else if (upperBerth.size() < 20) {
                upperBerth.add(passenger);
                assignTicket(passenger, "UPPER", upperBerth.size());
                return true;
            }
        } else if (preferredBerth.equals("UPPER")) {
            if (upperBerth.size() < 20) {
                upperBerth.add(passenger);
                assignTicket(passenger, "UPPER", upperBerth.size());
                return true;
            } else if (lowerBerth.size() < 20) {
                lowerBerth.add(passenger);
                assignTicket(passenger, "LOWER", lowerBerth.size());
                return true;
            } else if (middleBerth.size() < 20) {
                middleBerth.add(passenger);
                assignTicket(passenger, "MIDDLE", middleBerth.size());
                return true;
            }
        }

        // if no berth are available, add to waiting list
        if (waitingList.size() < 20) {
            waitingList.add(passenger);
            passenger.setBookingStatus(BookingStatus.WAIT_LISTED);
            passenger.setTicketNumber(60 + waitingList.size());
            return true;
        }

        return false; // Fully booked
    }

    private void assignTicket(Passenger passenger, String berthType, int seatNumber) {
        passenger.setBookingStatus(BookingStatus.CONFIRMED);
        passenger.setTicketNumber(seatNumber);
        System.out.println("Ticket booked for " + passenger.getPassengerName() + " with " + berthType + " berth, Seat No: " + seatNumber);
    }

    // method to cancel the ticket
    public boolean cancelTicket(Passenger passenger) {
        // check is the passenger is in any of the booked berths
        if (upperBerth.remove(passenger) || middleBerth.remove(passenger) || lowerBerth.remove(passenger)) {
            System.out.println("Ticket cancelled for " + passenger.getPassengerName());
            // if there are people on the waiting list, move one to the confirmed list
            if (!waitingList.isEmpty()) {
                Passenger waitlistedPassenger = waitingList.remove(0);
                System.out.println("Waitlisted passenger " + waitlistedPassenger.getPassengerName() + " is now confirmed!!");
                bookTicket(waitlistedPassenger);
            }
            return true;
        } else if (waitingList.remove(passenger)) {
            System.out.println("Waitlisted Ticket cancelled for " + passenger.getPassengerName());
            return true;
        } else {
            System.out.println("Passenger not found in the booking list!!");
            return false;
        }
    }

    public List<Passenger> getLowerBerth() {
        return lowerBerth;
    }

    public List<Passenger> getMiddleBerth() {
        return middleBerth;
    }

    public List<Passenger> getUpperBerth() {
        return upperBerth;
    }

    public List<Passenger> getWaitingList() {
        return waitingList;
    }

}
