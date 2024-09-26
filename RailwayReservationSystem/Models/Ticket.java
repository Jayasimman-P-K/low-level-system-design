package RailwayReservationSystem.Models;

public class Ticket {
    private final Passenger passenger;
    private final int seatNumber;

    public Ticket(Passenger passenger, int seatNumber) {
        this.passenger = passenger;
        this.seatNumber = seatNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    
}
