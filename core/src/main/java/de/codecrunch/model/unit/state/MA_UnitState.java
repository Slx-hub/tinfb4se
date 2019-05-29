package de.codecrunch.model.unit.state;

import com.badlogic.gdx.math.Matrix4;

public abstract class MA_UnitState {

    public abstract boolean applyMovement(Matrix4 transform, float step);

    protected float rotationMultiplier = 10;

    public boolean isRotating() {
        return false;
    }

    public boolean isIdle() {
        return false;
    }
}
