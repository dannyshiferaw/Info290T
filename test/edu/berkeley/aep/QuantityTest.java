package edu.berkeley.aep;

import org.junit.Test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

import static edu.berkeley.aep.Unit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuantityTest {

    @Test
    public void twelveInchesEqualOneFoot() {
        Quantity oneFoot = new Quantity(1, FEET);
        Quantity twelveInches = new Quantity(12, INCHES);

        assertEquals(oneFoot, twelveInches);
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Quantity threeFeet = new Quantity(3, FEET);
        Quantity yard = new Quantity(1, YARD);
        assertEquals(threeFeet, yard);
    }

    @Test
    public void SeventeenHundredSixtyYardsEqualOneMile() {
        Quantity mile = new Quantity(1, MILE);
        Quantity _1769yard = new Quantity(1760, YARD);
        assertEquals(mile, _1769yard);
    }

    @Test
    public void oneTBSPShouldBeEqualToThreeTSP() {
        Quantity tbsp = new Quantity(1, TBSP);
        Quantity threeTSP = new Quantity(3, TSP);
        assertEquals(tbsp, threeTSP);
    }

    @Test
    public void ozShouldBeEqualToTwoTBSP(){
        Quantity oz = new Quantity(1, OZ);
        Quantity twoTBSP = new Quantity(2, TBSP);
        assertEquals(oz, twoTBSP);
    }

    @Test
    public void eightOzShouldBeEqualToOneCup() {
        Quantity cup = new Quantity(1, CUP);
        Quantity oz = new Quantity(8, OZ);
        assertEquals(cup, oz);
    }

    @Test
    public void twoInchesPlusTwoInchesIsFourInches() {
        Quantity twoInches = new Quantity(2, INCHES);
        Quantity expected = new Quantity(4, INCHES);
        assertEquals(expected, twoInches.add(twoInches));
    }

    @Test
    public void twoTBSPPlusOneOZIsTwelveTSP() {
        Quantity twoTBSP = new Quantity(2, TBSP);
        Quantity oz = new Quantity(1, OZ);
        Quantity expected = new Quantity(12, TBSP);
        assertEquals(expected, twoTBSP.add(oz));
    }

    @Test(expected = InputMismatchException.class)
    public void shouldNotBeAbleToAddFourOzAndTwoInches() {
        Quantity oz = new Quantity(4, OZ);
        Quantity twoInches = new Quantity(2, INCHES);
        oz.add(twoInches);
    }

    @Test
    public void fiveInchesIsBetterThanThreeTwoOneInches() {
        Quantity fiveInches = new Quantity(5, INCHES);
        Quantity[] quantities = new Quantity[]{
                fiveInches,
                new Quantity(1, INCHES),
                new Quantity(2, INCHES),
                new Quantity(3, INCHES)

        };
        Bester bester = new Bester(quantities);
        assertEquals(fiveInches, bester.best());
    }

    @Test
    public void OneYardIsGreaterThanOneFeetAndOneInches() {
        Quantity oneYard = new Quantity(1, YARD);
        Quantity[] quantities = new Quantity[]{
                oneYard,
                new Quantity(1, INCHES),
                new Quantity(1, FEET)

        };
        Bester bester = new Bester(quantities);
        assertEquals(oneYard, bester.best());
    }

    @Test(expected = RuntimeException.class)
    public void comparingDifferentTypesOfQuantitiesShouldThrowException() {
        Quantity[] quantities = new Quantity[]{
                new Quantity(1, TBSP),
                new Quantity(1, INCHES),
                new Quantity(1, FEET)
        };
        Bester bester = new Bester(quantities);
        bester.best();
    }


}
