package de.codecrunch.model.unit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class M_HealFountainTest {

    private int speed;
    private int maxLife;
    private int healRadius; //tiles
    private int healingPerSecond;
    private M_HealFountain unit;

    @Before
    public void initialization(){
        unit = new M_HealFountain();
        speed = unit.getSpeed();
        maxLife = unit.getMaxLife();
        healingPerSecond = unit.getHealingPerSecond();
        healRadius = unit.getHealingPerSecond();
    }

    @Test
    public void setSpeed_canNotBeChanged_speedShouldBeUnchanged() {
        int expected = speed;

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
    public void heal_canNotGetHealing_currentLifeShouldNotChange(){
        int expected = 1;

        unit.setCurrentLife(1);
        unit.heal(maxLife-2);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setHealRadius_canBeChanged_healRadiusShouldBeChanged(){
        int expected = healRadius+1;

        unit.setHealRadius(healRadius+1);
        int actual = unit.getHealRadius();

        assertEquals(expected,actual);
    }

    @Test
    public void setHealRadius_canNotBeZero_healRadiusShouldNotBeChanged(){
        int expected = healRadius;

        unit.setHealRadius(0);
        int actual = unit.getHealRadius();

        assertEquals(expected,actual);
    }

    @Test
    public void setHealRadius_canNotBeNegative_healRadiusShouldNotBeChanged(){
        int expected = healRadius;

        unit.setHealRadius(-1);
        int actual = unit.getHealRadius();

        assertEquals(expected,actual);
    }

    @Test
    public void setHealingPerSecond_canBeChanged_healingPerSecondShouldBeChanged(){
        int expected = healingPerSecond+1;

        M_HealFountain unit = new M_HealFountain();
        unit.setHealingPerSecond(healingPerSecond+1);
        int actual = unit.getHealingPerSecond();

        assertEquals(expected,actual);
    }

    @Test
    public void setHealingPerSecond_canNotBeZero_healingPerSecondShouldNotBeChanged(){
        int expected = healingPerSecond;

        M_HealFountain unit = new M_HealFountain();
        unit.setHealingPerSecond(0);
        int actual = unit.getHealingPerSecond();

        assertEquals(expected,actual);
    }

    @Test
    public void setHealingPerSecond_canNotBeNegative_healingPerSecondShouldNotBeChanged(){
        int expected = healingPerSecond;

        M_HealFountain unit = new M_HealFountain();
        unit.setHealingPerSecond(-1);
        int actual = unit.getHealingPerSecond();

        assertEquals(expected,actual);
    }

}