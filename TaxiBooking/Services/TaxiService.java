package TaxiBooking.Services;

import java.util.List;

import TaxiBooking.Enum.Location;
import TaxiBooking.Models.Booking;
import TaxiBooking.Models.Taxi;

public class TaxiService {
    private final List<Taxi> taxis;

    public TaxiService(List<Taxi> taxis) {
        this.taxis = taxis;
    }

    public Taxi findAvailableTaxi(Location pickupPoint) {
        Taxi nearestTaxi = null;
        int nearestDistance = Integer.MAX_VALUE;
        for (Taxi taxi : taxis) {
            int distance = Location.calculateDistance(taxi.getCurrLocation(), pickupPoint);
            // check if the taxi is available and nearest
            if (distance < nearestDistance) {
                nearestTaxi = taxi;
                nearestDistance = distance;
            } else if (nearestDistance == distance) {
                // if two taxis at the same distance, pick one with least earnings 
                if (nearestTaxi != null && taxi.getTotalEarnings() < nearestTaxi.getTotalEarnings()) {
                    nearestTaxi = taxi;
                }
            }
        }
        return nearestTaxi;
    }

    public void updateTaxiStatus(Taxi taxi, Location dropoffLocation, Booking booking, double fare) {
        taxi.setCurrLocation(dropoffLocation);
        taxi.addTotalEarnings(fare);
        taxi.addBooking(booking);
    }

    public void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("Taxi-" + taxi.getTaxiId() + " Total Earnings: Rs. " + taxi.getTotalEarnings());
            for (Booking booking : taxi.getBookingHistory()) {
                System.out.printf("BookingID: %d | CustomerID: %d | From: %s | To: %s | Fare: Rs. %2f%n",
                        booking.getBookingId(), booking.getCustomerId(),
                        booking.getPickupLocation(), booking.getDropoffLocation(),
                        booking.getFare());
            }
        }
    }
}
