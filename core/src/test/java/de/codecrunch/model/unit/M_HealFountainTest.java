package de.codecrunch.model.unit;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class M_HealFountainTest {

    private int speed = 0;
    private int maxLife = 1000;
    private int healRadius = 2; //tiles
    private int healingPerSecond = 10;

    @Test
    public void m_HealFountain_shouldCreateHealFountain() {
        int expected[] = {speed,maxLife,maxLife,healRadius,healingPerSecond};

        MA_Unit unit = new M_HealFountain();
        int actual_speed = unit.getSpeed();
        int actual_maxLife = unit.getMaxLife();
        int actual_currentLife = unit.getCurrentLife();
        int actual_healRadius = ((M_HealFountain) unit).getHealRadius();
        int actual_healingPerSecond = ((M_HealFountain) unit).getHealingPerSecond();
        int actual[] = {actual_speed,actual_maxLife,actual_currentLife,actual_healRadius,actual_healingPerSecond};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void getSpeed_shouldReturnCurrentSpeed() {
        int expected = speed;

        M_HealFountain unit = new M_HealFountain();
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setSpeed_canNotBeChanged_speedShouldBeUnchanged() {
        int expected = speed;

        M_HealFountain unit = new M_HealFountain();
        unit.setSpeed(speed+1);
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setSpeed_canNotBeNegative_speedShouldBeUnchanged() {
        int expected = speed;

        M_HealFountain unit = new M_HealFountain();
        unit.setSpeed(-1);
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void getMaxLife_shouldReturnCurrentMaxLife() {
        int expected = maxLife;

        M_HealFountain unit = new M_HealFountain();
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canBeChanged_maxLifeShouldBeChanged() {
        int expected = maxLife+100;

        M_HealFountain unit = new M_HealFountain();
        unit.setMaxLife(maxLife+100);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeZero_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_HealFountain unit = new M_HealFountain();
        unit.setMaxLife(0);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeNegative_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_HealFountain unit = new M_HealFountain();
        unit.setMaxLife(-1);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void getCurrentLife_shouldReturnCurrentLife() {
        int expected = maxLife;

        M_HealFountain unit = new M_HealFountain();
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_lowerThanMaxLife_currentLifeShouldBeChanged() {
        int expected = maxLife-1;

        M_HealFountain unit = new M_HealFountain();
        unit.setCurrentLife(maxLife-1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_higherThanMaxLife_currentLifeShouldBeMaxLife() {
        int expected = maxLife;

        M_HealFountain unit = new M_HealFountain();
        unit.setCurrentLife(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageLowerThanLife_currentLifeShouldBeOne() {
        int expected = 1;

        M_HealFountain unit = new M_HealFountain();
        unit.takeDamage(maxLife-1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageHigherThanLife_currentLifeShouldBeZero(){
        int expected = 0;

        M_HealFountain unit = new M_HealFountain();
        unit.takeDamage(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_canNotGetHealing_currentLifeShouldNotChange(){
        int expected = 1;

        M_HealFountain unit = new M_HealFountain();
        unit.setCurrentLife(1);
        unit.heal(maxLife-2);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void getHealRadius_shouldReturnHealRadius(){
        int expected = healRadius;

        M_HealFountain unit = new M_HealFountain();
        int actual = unit.getHealRadius();

        assertEquals(expected,actual);
    }

    @Test
    public void setHealRadius_canBeChanged_healRadiusShouldBeChanged(){
        int expected = healRadius+1;

        M_HealFountain unit = new M_HealFountain();
        unit.setHealRadius(healRadius+1);
        int actual = unit.getHealRadius();

        assertEquals(expected,actual);
    }

    @Test
    public void setHealRadius_canNotBeZero_healRadiusShouldNotBeChanged(){
        int expected = healRadius;

        M_HealFountain unit = new M_HealFountain();
        unit.setHealRadius(0);
        int actual = unit.getHealRadius();

        assertEquals(expected,actual);
    }

    @Test
    public void setHealRadius_canNotBeNegative_healRadiusShouldNotBeChanged(){
        int expected = healRadius;

        M_HealFountain unit = new M_HealFountain();
        unit.setHealRadius(-1);
        int actual = unit.getHealRadius();

        assertEquals(expected,actual);
    }

    @Test
    public void getHealingPerSecond_shouldReturnHealingPerSecond(){
        int expected = healingPerSecond;

        M_HealFountain unit = new M_HealFountain();
        int actual = unit.getHealingPerSecond();

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