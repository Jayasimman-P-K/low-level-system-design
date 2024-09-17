# Designing a Parking Lot System

## Requirements

1. The parking lot should have multiple levels, each level with a certain number of parking spots.
2. The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks.
3. Each parking spot should be able to accommodate a specific type of vehicle.
4. The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits.
5. The system should track the availability of parking spots and provide real-time information to customers.
6. The system should handle multiple entry and exit points and support concurrent access.

## Directory Structure

```css
src
├── models
│   ├── Vehicle.java
│   ├── ParkingSpot.java
│   ├── Level.java
│   └── Ticket.java
├── enums
│   └── VehicleType.java
├── services
│   ├── ParkingLotService.java
│   ├── EntryGate.java
│   └── ExitGate.java
├── main
│   └── Driver.java

```

## Explanation

1. **VehicleType Enum**: Defines different types of vehicles (MOTORCYCLE, CAR, TRUCK).
2. **Vehicle Class**: Represents a vehicle with a license plate and type.
3. **ParkingSpot Class**: Represents a parking spot with a spot number, type, occupation status, and the vehicle parked.
4. **ParkingLevel Class**: Represents a level in the parking lot containing multiple parking spots.
5. **Ticket Class**: Represents a parking ticket with details of the vehicle, spot, and entry/exit times.
6. **ParkingLotService Class**: Manages the parking lot operations including parking and releasing vehicles, and checking available spots.
7. **EntryGate Class**: Handles vehicle entry and issues parking tickets.
8. **ExitGate Class**: Handles vehicle exit and processes parking tickets.
9. **Driver Class**: The main class that simulates the parking lot system with user interaction through the console.
