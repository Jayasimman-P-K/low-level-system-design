package RailwayReservationSystem.Services;

import RailwayReservationSystem.Models.Passenger;
import RailwayReservationSystem.Models.Train;

public class CancellationService {
    public boolean cancelTicket(Passenger passenger, Train train) {
        return train.cancelTicket(passenger);
    }
}
