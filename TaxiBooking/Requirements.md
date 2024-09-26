## Call Taxi Booking (LLD):

To design a **Call Taxi Booking Application**, we can break down the problem into different modules and classes. Below is a low-level system design that addresses the requirements and constraints. We'll have two main functionalities:

1. **Call Taxi Booking**: This handles taxi allocation based on the current availability, nearest taxi, and the pickup/drop points.
2. **Display Taxi Details**: This provides details of all the taxis, their bookings, and their earnings.

We'll build a system that supports this and is modular enough to be extended for any number of taxis or locations.

---

### Key Concepts

1. **Taxi Allocation**:

   - Taxis are initially stationed at point A.
   - If a taxi is available at the pickup point, it will be allocated.
   - If no taxi is available, the nearest available taxi is allocated.
   - If two taxis are free at the same location, the one with the lower total earnings is selected.
   - A rejected booking happens if no taxi is available.

2. **Fare Calculation**:

   - For the first 5 km: ₹100.
   - For each subsequent km: ₹10/km.

3. **Travel Time**:

   - Each point is 15 km apart.
   - Travel time between two adjacent points is 60 minutes.

4. **Taxi Data**:
   - Taxi No.
   - Total Earnings.
   - Booking Details (Booking ID, Customer ID, Pickup/Drop Point, Pickup Time, Drop Time, Amount Charged).

---

### Folder Structure

```css
src
├── CallTaxi
│   ├── Models
│   │   ├── Taxi.java
│   │   ├── Booking.java
│   │   └── Location.java
│   ├── Services
│   │   ├── TaxiService.java
│   │   └── BookingService.java
│   └── Driver.java

```
