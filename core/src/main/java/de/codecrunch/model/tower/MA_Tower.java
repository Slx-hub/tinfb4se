package de.codecrunch.model.tower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

import de.codecrunch.model.ME_TileState;
import de.codecrunch.model.unit.MA_Unit;

public abstract class MA_Tower {

    protected int x_pos, y_pos;
    protected ModelInstance model;
    protected ME_TowerState state = ME_TowerState.RELOAD;
    protected MA_Unit unitAimingAt;
    protected float currentWaitTime = getReloadTime();
    protected LineCoordinates laserLine = new LineCoordinates();

    public static List<MA_Tower> getAllTowers() {
        List<MA_Tower> list = new ArrayList<>();
        list.addAll(Arrays.asList(new M_SmallTower(), new M_MediumTower(), new M_BigTower()));
        return list;
    }

    public void setPos(int x, int y) {
        if (x < 0 || y < 0) return;
        x_pos = x;
        y_pos = y;
        laserLine.setStart(new Vector3(x * ME_TileState.tileDistance, 1f, y * ME_TileState.tileDistance));
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
                currentWaitTime -= delta;
                if (currentWaitTime <= 0)
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
            case WAITFORBULLET:
                currentWaitTime -= delta;
                setLaserEndOnUnit();
                if (currentWaitTime <= 0) {
                    laserLine.render = false;
                    currentWaitTime = getReloadTime();
                    state = ME_TowerState.RELOAD;
                }
                break;
        }
    }

    private void shoot() {
        unitAimingAt.takeDamage(this.getDamage());
        laserLine.render = true;
        setLaserEndOnUnit();
        state = ME_TowerState.WAITFORBULLET;
        currentWaitTime = getReloadTime() / 10;
    }

    private void setLaserEndOnUnit() {
        if (unitAimingAt == null)
            return;
        laserLine.setEnd(unitAimingAt.getModel().transform.getTranslation(laserLine.getEnd()));
    }

    public void onUnitInRange(MA_Unit unit) {
        if (unitAimingAt != null)
            return;
        unitAimingAt = unit;
        if (state == ME_TowerState.IDLE)
            state = ME_TowerState.SHOOT;
    }

    protected enum ME_TowerState {
        IDLE, RELOAD, SHOOT, WAITFORBULLET;
    }

    public LineCoordinates getLaserLine() {
        return laserLine;
    }

    public class LineCoordinates {
        public boolean render = false;
        private Vector3 start = new Vector3();
        private Vector3 end = new Vector3();

        protected void setStart(Vector3 pos) {
            start = pos;
        }

        protected void setEnd(Vector3 pos) {
            end = pos;
        }

        public Vector3 getStart() {
            return start;
        }

        public Vector3 getEnd() {
            return end;
        }
    }
}
