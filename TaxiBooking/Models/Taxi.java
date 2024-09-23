package TaxiBooking.Models;

import java.util.ArrayList;
import java.util.List;

import TaxiBooking.Enum.Location;

public class Taxi {
    private final String taxiId;
    private Location currLocation;
    private double totalEarnings;
    private final List<Booking> bookingHistory;

    public Taxi(String taxiId) {
        this.taxiId = taxiId;
        this.currLocation = Location.A; // all taxis start at A location
        this.totalEarnings = 0;
        this.bookingHistory = new ArrayList<>();
    }

    public String getTaxiId() {
        return taxiId;
    }

    public Location getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void addTotalEarnings(double amount) {
        this.totalEarnings += amount;
    }

    public List<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public void addBooking(Booking booking) {
        this.bookingHistory.add(booking);
    }
    
}
