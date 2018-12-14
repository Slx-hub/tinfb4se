package de.codecrunch.model.unit;

import org.junit.Test;

import static org.junit.Assert.*;

public class M_SmallUnitTest {

    private int speed = 1;
    private int maxLife = 100;

    @Test
    public void m_SmallUnit_shouldCreateSmallUnit() {
        int expected[] = {speed,maxLife,maxLife};

        MA_Unit smallUnit = new M_SmallUnit();
        int actual_speed = smallUnit.getSpeed();
        int actual_maxLife = smallUnit.getMaxLife();
        int actual_currentLife = smallUnit.getCurrentLife();
        int actual[] = {actual_speed,actual_maxLife,actual_currentLife};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void getSpeed_shouldReturnCurrentSpeed() {
        int expected = speed;

        M_SmallUnit smallUnit = new M_SmallUnit();
        int actual = smallUnit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setSpeed_canBeChanged_shouldBeChanged() {
        int expected = speed+1;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setSpeed(speed+1);
        int actual = smallUnit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setSpeed_canNotBeNegative_speedShouldBeUnchanged() {
        int expected = speed;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setSpeed(-1);
        int actual = smallUnit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void getMaxLife_shouldReturnCurrentMaxLife() {
        int expected = maxLife;

        M_SmallUnit smallUnit = new M_SmallUnit();
        int actual = smallUnit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canBeChanged_maxLifeShouldBeChanged() {
        int expected = maxLife+100;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setMaxLife(maxLife+100);
        int actual = smallUnit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeZero_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setMaxLife(0);
        int actual = smallUnit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeNegative_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setMaxLife(-1);
        int actual = smallUnit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void getCurrentLife_shouldReturnCurrentLife() {
        int expected = maxLife;

        M_SmallUnit smallUnit = new M_SmallUnit();
        int actual = smallUnit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_lowerThanMaxLife_currentLifeShouldBeChanged() {
        int expected = maxLife-1;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setCurrentLife(maxLife-1);
        int actual = smallUnit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_higherThanMaxLife_currentLifeShouldBeMaxLife() {
        int expected = maxLife;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setCurrentLife(maxLife+1);
        int actual = smallUnit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageLowerThanLife_currentLifeShouldBeOne() {
        int expected = 1;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.takeDamage(maxLife-1);
        int actual = smallUnit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageHigherThanLife_currentLifeShouldBeZero(){
        int expected = 0;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.takeDamage(maxLife+1);
        int actual = smallUnit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_overheal_CurrentLifeShouldBeMaxLife(){
        int expected = maxLife;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setCurrentLife(1);
        smallUnit.heal(maxLife+1);
        int actual = smallUnit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_heal_currentLifeShouldBeOneLowerThanMaxLife(){
        int expected = maxLife-1;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setCurrentLife(1);
        smallUnit.heal(maxLife-2);
        int actual = smallUnit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_healDeadDoesNotRevive_currentLifeShouldBeZero(){
        int expected = 0;

        M_SmallUnit smallUnit = new M_SmallUnit();
        smallUnit.setCurrentLife(0);
        smallUnit.heal(1);
        int actual = smallUnit.getCurrentLife();

        assertEquals(expected,actual);
    }
}