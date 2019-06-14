package de.codecrunch.model.unit.state;

import com.badlogic.gdx.math.Matrix4;

public class M_UnitState_DONE extends MA_UnitState {
    @Override
    public boolean applyMovement(Matrix4 transform, float step) {
        return false;
    }

    @Override
    public boolean isIdle() {
        return true;
    }

    @Override
    public boolean isDone() {
        return true;
    }
}
