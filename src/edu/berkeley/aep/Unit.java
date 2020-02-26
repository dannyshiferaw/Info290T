package edu.berkeley.aep;

// Understands how to convert itself to inches
public enum Unit {
    INCHES(1),
    FEET(12),
    YARD(36),
    MILE(1760 * 36),
    TBSP(3),
    TSP(1),
    OZ(2 * 3),
    CUP(8 * 2 * 3);


    private final int factor;

    Unit(int factor) {
        this.factor = factor;
    }

    public double toInches(double value) {
        return value * this.factor;
    }

    public double toTSP(double value) {
        return value * this.factor;
    }



}
