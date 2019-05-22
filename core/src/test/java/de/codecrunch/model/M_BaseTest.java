package de.codecrunch.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class M_BaseTest {

    private int maxLife = 100;

    @Test
    public void m_Base_shouldCreateBase(){
        int expected[] = {maxLife, maxLife};

        M_Base base = new M_Base();
        int actual_maxLife = base.getMaxLife();
        int actual_currentLife = base.getCurrentLife();
        int actual[] = {actual_maxLife, actual_currentLife};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getMaxLife_shouldReturnMaxLife(){
        int expected = maxLife;

        M_Base base = new M_Base();
        int actual = base.getMaxLife();

        assertEquals(expected, actual);
    }

    @Test
    public void setMaxLife_canBeChanged_maxLifeShouldBeChanged() {
        int expected = maxLife+100;

        M_Base base = new M_Base();
        base.setMaxLife(maxLife+100);
        int actual = base.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeZero_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_Base base = new M_Base();
        base.setMaxLife(0);
        int actual = base.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeNegative_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_Base base = new M_Base();
        base.setMaxLife(-1);
        int actual = base.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void getCurrentLife_shouldReturnCurrentLife(){
        int expected = maxLife;

        M_Base base = new M_Base();
        int actual = base.getCurrentLife();

        assertEquals(expected, actual);
    }

    @Test
    public void setCurrentLife_lowerThanMaxLife_currentLifeShouldBeChanged() {
        int expected = maxLife-1;

        M_Base base = new M_Base();
        base.setCurrentLife(maxLife-1);
        int actual = base.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_higherThanMaxLife_currentLifeShouldBeMaxLife() {
        int expected = maxLife;

        M_Base base = new M_Base();
        base.setCurrentLife(maxLife+1);
        int actual = base.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_baseShouldTakeOneLifeDamage() {
        int expected = maxLife-1;

        M_Base base = new M_Base();
        base.takeDamage();
        int actual = base.getCurrentLife();

        assertEquals(expected,actual);
    }
}