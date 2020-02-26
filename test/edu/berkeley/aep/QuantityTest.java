package edu.berkeley.aep;

import org.junit.Test;

import static edu.berkeley.aep.Unit.*;
import static org.junit.Assert.assertEquals;

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
    public void twoInchesPlustwoInchesIsFour() {
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

    @Test(expected =  RuntimeException.class)
    public void shouldNotBeAbleToAddFourOzandTwoInches() {
        Quantity oz = new Quantity(4, OZ);
        Quantity twoInches = new Quantity(2, INCHES);
        oz.add(twoInches);
    }





}
