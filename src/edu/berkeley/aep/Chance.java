package edu.berkeley.aep;


/**
 * Understands the likelihood of something happening
 */
public class Chance implements Bestable{

    private final float probability;

    public Chance(float probability) {
        this.probability = probability;
    }

    public float getProbability() {
        return this.probability;
    }


    public Chance not() {
        return new Chance(1 - this.probability);
    }

    public Chance and(Chance other) { return new Chance(this.probability * other.probability); }

    /**
     * Using De morgan's Law P(A || B) = !(!P(A) && !P(B))
     * @param other
     * @return
     */
    public Chance or(Chance other) { return (not().and(other.not())).not(); }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Chance)) {
            return false;
        }

        Chance otherChance = (Chance) other;
        return Float.compare(this.probability, otherChance.probability) == 0;
    }

    @Override
    public int hashCode() {
        return Float.hashCode(this.probability);
    }

    @Override
    public boolean betterThan(Bestable other) {
        return probability > ((Chance) other).probability;
    }
}
