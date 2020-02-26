package edu.berkeley.aep;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ChanceTest {

    @Test
    public void twoChancesWithSameProbabilityShouldBeEqual() {
        assertEquals(new Chance(1.0f), new Chance(1.0f));
    }

    @Test
    public void getTwoChancesWithDifferentProbabilitiesShouldNotBeEqual() {
        assertNotEquals(new Chance(0.0f), new Chance(0.1f));
    }

    @Test
    public void twoChancesWithDifferentProbabilitiesShouldHaveDifferentHashCodes() {
        assertNotEquals(new Chance(0.0f).hashCode(), new Chance(0.1f).hashCode());
    }

    @Test
    public void twoChancesWithSameProbabilitiesShouldHaveSameHashCodes() {
        assertEquals(new Chance(0.0f).hashCode(), new Chance(0.0f).hashCode());
    }

    @Test
    public void chanceOfNotGettingOneWhenRollingDiceIsFiveSixth() {
        Chance chanceOfGettingOne = new Chance(1.0f/6.0f);
        Chance chanceOfNotGettingOne = new Chance(5.0f/6.0f);
        assertEquals(chanceOfNotGettingOne, chanceOfGettingOne.not());
    }

    /**
     * In TDD, each test should be specific, meaning should test one feature
     */
    @Test
    public void testProbabilityOfEitherOfTwoEventsHappening() {
        final int inputSize = 3;
        float[] event1Chances = new float[] {1.0f/3.0f, 1.0f/2.0f, 2.0f/3.0f};
        float[] event2Chances = new float[] {1.0f/2.0f, 2.0f/3.0f, 1.0f/3.0f};

        for (int i = 0; i < inputSize; i++) {
            float p1 = event1Chances[i];
            float p2 = event2Chances[i];
            Chance event1 = new Chance(p1);
            Chance event2 = new Chance(p2);
            assertEquals(event1.or(event2), new Chance((p1 + p2) - (p1 * p2)));
        }
    }
}
