package edu.berkeley.aep;

// Understands how to present value in different units
public class Quantity implements Bestable {
    private final int size;
    private final Unit unit;

    public Quantity(int size, Unit unit) {
        this.size = size;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Quantity)) return false;
        return equals((Quantity) other);
    }

    public boolean equals(Quantity other) {
        try {
            return this.size == other.convertTo(unit);
        } catch (RuntimeException e) {
            return false;
        }
    }

    private int convertTo(Unit toUnits) {
        try {
            return unit.convertTo(toUnits, size);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return size + " " + unit;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(size);
    }

    public Quantity add(Quantity other) {
        return new Quantity(size + other.convertTo(unit), unit);
    }

    @Override
    public boolean betterThan(Bestable other) {
        return this.size > ((Quantity) other).convertTo(this.unit);
    }
}