package de.codecrunch.model.tower;

import org.junit.Test;

import static org.junit.Assert.*;

public class M_BigTowerTest {

    private int price = 200;
    private int range = 3;

    @Test
    public void getPrice_shouldReturnTwoHundred() {
        MA_Tower tower = new M_BigTower();
        int expected = price;
        int actual = tower.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    public void getRange_shouldReturnThree() {
        MA_Tower tower = new M_BigTower();
        int expected = range;
        int actual = tower.getRange();
        assertEquals(expected, actual);
    }

    @Test
    public void getX_posShouldReturnZero() {
        MA_Tower tower = new M_BigTower();
        int expected = 0;
        int actual = tower.getX_pos();
        assertEquals(expected, actual);
    }

    @Test
    public void getY_pos_shouldReturnZero() {
        MA_Tower tower = new M_BigTower();
        int expected = 0;
        int actual = tower.getY_pos();
        assertEquals(expected, actual);
    }

    @Test
    public void setPos_canBeChanged_positionShouldBeChanged() {
        MA_Tower tower = new M_BigTower();
        tower.setPos(1,2);
        int[] expected = {1,2};
        int[] actual = {tower.getX_pos(), tower.getY_pos()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setPos_canBeZeroZero_positionShouldBeZeroZero() {
        MA_Tower tower = new M_BigTower();
        tower.setPos(0,0);
        int[] expected = {0,0};
        int[] actual = {tower.getX_pos(), tower.getY_pos()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setPos_canNotBeNegativeAtX_positionShouldBeUnchanged() {
        MA_Tower tower = new M_BigTower();
        tower.setPos(-1,2);
        int[] expected = {0,0};
        int[] actual = {tower.getX_pos(), tower.getY_pos()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setPos_canNotBeNegativeAtY_positionShouldBeUnchanged() {
        MA_Tower tower = new M_BigTower();
        tower.setPos(1,-2);
        int[] expected = {0,0};
        int[] actual = {tower.getX_pos(), tower.getY_pos()};
        assertArrayEquals(expected, actual);
    }
}