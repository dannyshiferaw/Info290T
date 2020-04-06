package edu.berkeley.aep;

public class Bester {
    private final Bestable[] values;

    public Bester(Bestable... values) {
        this.values = values;
    }

    public Bestable best() {
        assert values.length > 1;
        Bestable best = this.values[0];
        for (Bestable bestable : this.values) {
            if (bestable.betterThan(best)) {
                best = bestable;
            }
        }

        return best;
    }
}
