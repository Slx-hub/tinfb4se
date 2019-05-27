package de.codecrunch.model.tower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.model.unit.MA_Unit;

public abstract class MA_Tower {

    protected int x_pos, y_pos;
    protected ModelInstance model;
    protected ME_TowerState state = ME_TowerState.RELOAD;
    protected MA_Unit unitAimingAt;
    protected float currentReloadTime = getReloadTime();

    public static List<MA_Tower> getAllTowers() {
        List<MA_Tower> list = new ArrayList<>();
        list.addAll(Arrays.asList(new M_SmallTower(), new M_MediumTower(), new M_BigTower()));
        return list;
    }

    public void setPos(int x, int y) {
        if (x < 0 || y < 0) return;
        x_pos = x;
        y_pos = y;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public abstract float getReloadTime();

    public abstract int getDamage();

    public abstract int getPrice();

    public abstract int getRange();

    public abstract ModelInstance getModel();

    public void tick(float delta) {
        switch (state) {
            case IDLE:
                break;
            case RELOAD:
                currentReloadTime -= delta;
                if (currentReloadTime <= 0)
                    state = ME_TowerState.SHOOT;
                break;
            case SHOOT:
                if (unitAimingAt != null && unitAimingAt.isDead())
                    unitAimingAt = null;

                if (unitAimingAt == null)
                    state = ME_TowerState.IDLE;
                else
                    shoot();
                break;
        }
    }

    private void shoot() {
        unitAimingAt.takeDamage(this.getDamage());
        state = ME_TowerState.RELOAD;
        currentReloadTime = getReloadTime();
    }

    public void onUnitInRange(MA_Unit unit) {
        if (unitAimingAt != null)
            return;
        unitAimingAt = unit;
        if (state == ME_TowerState.IDLE)
            state = ME_TowerState.SHOOT;
    }

    protected enum ME_TowerState {
        IDLE, RELOAD, SHOOT;
    }
}
