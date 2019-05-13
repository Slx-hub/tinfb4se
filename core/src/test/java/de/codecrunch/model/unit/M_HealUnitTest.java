package de.codecrunch.model.unit;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class M_HealUnitTest {

    private int speed = 2;
    private int maxLife = 300;

    @Test
    public void m_HealUnit_shouldCreateHealUnit() {
        int expected[] = {speed,maxLife,maxLife};

        MA_Unit unit = new M_HealUnit();
        int actual_speed = unit.getSpeed();
        int actual_maxLife = unit.getMaxLife();
        int actual_currentLife = unit.getCurrentLife();
        int actual[] = {actual_speed,actual_maxLife,actual_currentLife};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void getSpeed_shouldReturnCurrentSpeed() {
        int expected = speed;

        M_HealUnit unit = new M_HealUnit();
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setSpeed_canBeChanged_shouldBeChanged() {
        int expected = speed+1;

        M_HealUnit unit = new M_HealUnit();
        unit.setSpeed(speed+1);
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setSpeed_canNotBeNegative_speedShouldBeUnchanged() {
        int expected = speed;

        M_HealUnit unit = new M_HealUnit();
        unit.setSpeed(-1);
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void getMaxLife_shouldReturnCurrentMaxLife() {
        int expected = maxLife;

        M_HealUnit unit = new M_HealUnit();
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canBeChanged_maxLifeShouldBeChanged() {
        int expected = maxLife+100;

        M_HealUnit unit = new M_HealUnit();
        unit.setMaxLife(maxLife+100);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeZero_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_HealUnit unit = new M_HealUnit();
        unit.setMaxLife(0);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeNegative_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_HealUnit unit = new M_HealUnit();
        unit.setMaxLife(-1);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void getCurrentLife_shouldReturnCurrentLife() {
        int expected = maxLife;

        M_HealUnit unit = new M_HealUnit();
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_lowerThanMaxLife_currentLifeShouldBeChanged() {
        int expected = maxLife-1;

        M_HealUnit unit = new M_HealUnit();
        unit.setCurrentLife(maxLife-1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_higherThanMaxLife_currentLifeShouldBeMaxLife() {
        int expected = maxLife;

        M_HealUnit unit = new M_HealUnit();
        unit.setCurrentLife(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageLowerThanLife_currentLifeShouldBeOne() {
        int expected = 1;

        M_HealUnit unit = new M_HealUnit();
        unit.takeDamage(maxLife-1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageHigherThanLife_currentLifeShouldBeZero(){
        int expected = 0;

        M_HealUnit unit = new M_HealUnit();
        unit.takeDamage(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_overheal_CurrentLifeShouldBeMaxLife(){
        int expected = maxLife;

        M_HealUnit unit = new M_HealUnit();
        unit.setCurrentLife(1);
        unit.heal(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_heal_currentLifeShouldBeOneLowerThanMaxLife(){
        int expected = maxLife-1;

        M_HealUnit unit = new M_HealUnit();
        unit.setCurrentLife(1);
        unit.heal(maxLife-2);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_healDeadDoesNotRevive_currentLifeShouldBeZero(){
        int expected = 0;

        M_HealUnit unit = new M_HealUnit();
        unit.setCurrentLife(0);
        unit.heal(1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }


    @Test
    public void setPos_shouldSetXPosition_XShouldReturnOne(){
        int expected = 1;

        M_HealUnit unit = new M_HealUnit();
        unit.setPos(1,0);
        int actual = unit.getCurrentTile_xPos();

        assertEquals(expected,actual);
    }

    @Test
    public void setPos_shouldSetYPosition_YShouldReturnOne(){
        int expected = 1;

        M_HealUnit unit = new M_HealUnit();
        unit.setPos(0,1);
        int actual = unit.getCurrentTile_yPos();

        assertEquals(expected,actual);
    }

    @Test
    public void setPos_XCanNotBeNegative_XShouldNotChange(){
        int expected = 1;

        M_HealUnit unit = new M_HealUnit();
        unit.setPos(1,0);
        unit.setPos(-1,0);
        int actual = unit.getCurrentTile_xPos();

        assertEquals(expected,actual);
    }

    @Test
    public void setPos_YCanNotBeNegative_YShouldNotChange(){
        int expected = 1;

        M_HealUnit unit = new M_HealUnit();
        unit.setPos(0,1);
        unit.setPos(0,-1);
        int actual = unit.getCurrentTile_yPos();

        assertEquals(expected,actual);
    }

    @Test
    public void getX_pos_shouldReturnActualXPosition(){
        int expected = 0;

        M_HealUnit unit = new M_HealUnit();
        int actual = unit.getCurrentTile_xPos();

        assertEquals(expected,actual);
    }

    @Test
    public void getY_pos_shouldReturnActualXPosition(){
        int expected = 0;

        M_HealUnit unit = new M_HealUnit();
        int actual = unit.getCurrentTile_yPos();

        assertEquals(expected,actual);
    }
}