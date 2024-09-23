package TaxiBooking.Models;

import TaxiBooking.Enum.Location;

public class Booking {
    private final int bookingId;
    private final int customerId;
    private final Location pickupLocation;
    private final Location dropoffLocation;
    private final double fare;

    public Booking(int bookingId, int customeId, Location pickupLocation, Location dropoffLocation) {
        this.bookingId = bookingId;
        this.customerId = customeId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.fare = Location.calculateFare(pickupLocation, dropoffLocation);
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }

    public double getFare() {
        return fare;
    }
    
}
