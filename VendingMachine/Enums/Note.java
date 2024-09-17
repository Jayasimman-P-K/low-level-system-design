package VendingMachine.Enums;

public enum Note {
    TEN(10.00),
    TWENTY(20.00),
    FIFTY(50.00),
    HUNDRED(100.00);

    private final double value;

    Note(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
