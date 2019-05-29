package de.codecrunch.model.unit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class M_MediumUnitTest {

    private int speed;
    private int maxLife;
    private MA_Unit unit;

    @Before
    public void initialization(){
        unit = new M_MediumUnit();
        speed = unit.getSpeed();
        maxLife = unit.getMaxLife();
    }

    @Test
    public void setSpeed_canBeChanged_speedShouldBeChanged() {
        int expected = speed+1;

        unit.setSpeed(speed+1);
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setSpeed_canNotBeNegative_speedShouldBeUnchanged() {
        int expected = speed;

        unit.setSpeed(-1);
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canBeChanged_maxLifeShouldBeChanged() {
        int expected = maxLife+100;

        unit.setMaxLife(maxLife+100);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeZero_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        unit.setMaxLife(0);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeNegative_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        unit.setMaxLife(-1);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_lowerThanMaxLife_currentLifeShouldBeChanged() {
        int expected = maxLife-1;

        unit.setCurrentLife(maxLife-1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_higherThanMaxLife_currentLifeShouldBeMaxLife() {
        int expected = maxLife;

        unit.setCurrentLife(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageLowerThanLife_currentLifeShouldBeOne() {
        int expected = 1;

        unit.takeDamage(maxLife-1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageHigherThanLife_currentLifeShouldBeZero(){
        int expected = 0;

        unit.takeDamage(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_overheal_CurrentLifeShouldBeMaxLife(){
        int expected = maxLife;

        unit.setCurrentLife(1);
        unit.heal(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_heal_currentLifeShouldBeOneLowerThanMaxLife(){
        int expected = maxLife-1;

        unit.setCurrentLife(1);
        unit.heal(maxLife-2);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_healDeadDoesNotRevive_currentLifeShouldBeZero(){
        int expected = 0;

        unit.setCurrentLife(0);
        unit.heal(1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

}