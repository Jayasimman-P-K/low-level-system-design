Designing a **Railway Reservation System** involves creating a modular system to handle bookings, availability checking, cancellations, and preparing charts. Here's how we can approach the **Low-Level Design (LLD)** for this system:

### Key Components:

1. **Coaches**: Three types of coaches:

   - **AC Coach**
   - **Non-AC Coach**
   - **Seater Coach**

   Each coach has:

   - 60 seats
   - A waiting list of 10 passengers (max).

2. **Ticket Booking**: Users should be able to book tickets based on availability in each coach.

3. **Ticket Cancellation**: Users should be able to cancel their tickets.

4. **Status Checking**: Users should be able to check the current status of their booking.

5. **Prepare Chart**: Prepare a chart showing all confirmed and waitlisted passengers before the journey starts.

### Class Design

#### 1. **Models**

- **Passenger.java**: Represents each passenger's information.
- **Ticket.java**: Represents the booking details like seat number, coach type, and booking status.
- **Coach.java**: Abstract class representing the common properties and methods for all coach types.
- **ACCoach.java**, **NonACCoach.java**, **SeaterCoach.java**: Classes representing specific types of coaches.
- **Train.java**: Represents the train and contains multiple coaches.

#### 2. **Services**

- **BookingService.java**: Handles the booking of tickets.
- **CancellationService.java**: Handles ticket cancellations.
- **StatusService.java**: Checks the current status of booking.
- **ChartService.java**: Prepares the final list of passengers.

### Project Structure

```css
src
├── RailwayReservationSystem
│   ├── Models
│   │   ├── Passenger.java
│   │   ├── Ticket.java
│   │   ├── Coach.java
│   │   ├── ACCoach.java
│   │   ├── NonACCoach.java
│   │   └── SeaterCoach.java
│   ├── Services
│   │   ├── BookingService.java
│   │   ├── CancellationService.java
│   │   ├── StatusService.java
│   │   └── ChartService.java
│   └── Driver.java
```
