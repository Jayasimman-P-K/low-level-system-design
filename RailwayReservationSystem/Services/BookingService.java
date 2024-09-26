package RailwayReservationSystem.Services;

import RailwayReservationSystem.Models.Passenger;
import RailwayReservationSystem.Models.Train;

public class BookingService {
    public boolean bookTicket(Passenger passenger, Train train) {
        return train.bookTicket(passenger);
    }
}
