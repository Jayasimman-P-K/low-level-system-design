package TaxiBooking.Services;

import TaxiBooking.Enum.Location;
import TaxiBooking.Models.Booking;
import TaxiBooking.Models.Taxi;

public class BookingService {
    private static int bookingIdCounter = 1;
    private TaxiService taxiService;

    public BookingService(TaxiService taxiService)  {
        this.taxiService = taxiService;
    }

    public boolean bookTaxi(int customerId, Location pickupLocation, Location dropoffLocation) {
        Taxi availableTaxi = taxiService.findAvailableTaxi(pickupLocation);
        if (availableTaxi != null) {
            Booking booking = new Booking(bookingIdCounter++,customerId, pickupLocation, dropoffLocation);
            taxiService.updateTaxiStatus(availableTaxi, dropoffLocation, booking, booking.getFare());
            System.out.println("Taxi-" + availableTaxi.getTaxiId() + " is allotted.");
            return true;
        } else {
            System.out.println("No taxi available.");
            return false;
        }
    }
}
