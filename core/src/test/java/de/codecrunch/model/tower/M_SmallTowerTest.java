package de.codecrunch.model.tower;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class M_SmallTowerTest{

    private int price;
    private int range;
    private MA_Tower tower;

    @Before
    public void initialize() {
        tower = new M_SmallTower();
        price = tower.getPrice();
        range = tower.getRange();
    }

    @Test
    public void setPos_canBeChanged_positionShouldBeChanged() {
        tower.setPos(1,2);
        int[] expected = {1,2};
        int[] actual = {tower.getX_pos(), tower.getY_pos()};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void setPos_canBeZeroZero_positionShouldBeZeroZero() {
        tower.setPos(0,0);
        int[] expected = {0,0};
        int[] actual = {tower.getX_pos(), tower.getY_pos()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setPos_canNotBeNegativeAtX_positionShouldBeUnchanged() {
        tower.setPos(-1,2);
        int[] expected = {0,0};
        int[] actual = {tower.getX_pos(), tower.getY_pos()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setPos_canNotBeNegativeAtY_positionShouldBeUnchanged() {
        tower.setPos(1,-2);
        int[] expected = {0,0};
        int[] actual = {tower.getX_pos(), tower.getY_pos()};
        assertArrayEquals(expected, actual);
    }
}