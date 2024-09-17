package VendingMachine.Enums;

public enum Coin {
    ONE(1.00),
    TWO(2.00),
    FIVE(5.00),
    TEN(10.00);

    private final double value;
    
    Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
