package RailwayReservationSystem.Models;

import RailwayReservationSystem.Enum.BookingStatus;

public class Passenger {
    private final String passengerName;
    private int ticketNumber;
    private final String preferredBerth; // LOWER, MIDDLE, UPPER
    private BookingStatus bookingStatus; // BOOKED, CANCELLED, WAIT_LISTED



    public Passenger(String passengerName, String preferredBerth) {
        this.passengerName = passengerName;
        this.preferredBerth = preferredBerth;
        this.bookingStatus = BookingStatus.WAIT_LISTED; // default status
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getPreferredBerth() {
        return preferredBerth;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    
}
