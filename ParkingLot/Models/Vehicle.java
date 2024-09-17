package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;

public class Vehicle {
    private final String licencePlate;
    private final VehicleType vehicleType;

    public Vehicle(String licencePlate, VehicleType vehicleType) {
        this.licencePlate = licencePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }   
}
