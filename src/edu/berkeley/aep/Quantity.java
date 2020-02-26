package edu.berkeley.aep;

import java.util.Arrays;

import static edu.berkeley.aep.Unit.*;

// how to represent a quantity in units
public class Quantity {

    private double value;
    private Unit unit;

    Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Quantity)) {
            return false;
        }

        Quantity o = (Quantity) other;
        return this.unit.toInches(value) == o.unit.toInches(o.value);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    public Quantity add(Quantity other) {
        if (Arrays.asList(new Unit[]{TBSP, TSP, OZ, CUP}).contains(this.unit)) {
            return new Quantity(this.unit.toTSP(value) + other.unit.toTSP(other.value), TBSP);
        } else {
            return new Quantity(this.unit.toInches(value) + other.unit.toTSP(other.value), INCHES);
        }

    }
}
