package de.codecrunch.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class M_BaseTest {

    private int maxLife;
    private M_Base base;

    @Before
    public void initialize(){
        base = new M_Base();
        maxLife = base.getMaxLife();
    }

    @Test
    public void setMaxLife_canBeChanged_maxLifeShouldBeChanged() {
        int expected = maxLife+100;

        base.setMaxLife(maxLife+100);
        int actual = base.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeZero_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        base.setMaxLife(0);
        int actual = base.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeNegative_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        base.setMaxLife(-1);
        int actual = base.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_lowerThanMaxLife_currentLifeShouldBeChanged() {
        int expected = maxLife-1;

        base.setCurrentLife(maxLife-1);
        int actual = base.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_higherThanMaxLife_currentLifeShouldBeMaxLife() {
        int expected = maxLife;

        base.setCurrentLife(maxLife+1);
        int actual = base.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_baseShouldTakeOneLifeDamage() {
        int expected = maxLife-1;

        base.takeDamage();
        int actual = base.getCurrentLife();

        assertEquals(expected,actual);
    }
}