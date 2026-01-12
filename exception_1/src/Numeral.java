public class Numeral extends Expression {
    private double value;

    public Numeral(double value) {
        this.value = value;
    }

    public Numeral() {
        value = 0;
    }

    @Override
    public String toString() {
        if (value == Math.round(value)) {
            return String.valueOf(Math.round(value));
        }
        return String.valueOf(value);
    }

    @Override
    public double evaluate() {
        return value;
    }
}
