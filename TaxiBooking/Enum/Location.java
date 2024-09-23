package TaxiBooking.Enum;

public enum Location {
    A, B, C, D, E, F;

    public static int calculateDistance(Location start, Location end) {
        return Math.abs(start.ordinal() - end.ordinal()) * 15; // 15 km per point
    }

    public static int calculateFare(Location start, Location end) {
        int distance = calculateDistance(start, end);
        if (distance <= 5) {
            return 100;
        } else return 100 + (distance - 5) * 10;
    }

}
