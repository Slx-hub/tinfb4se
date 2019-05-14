package de.codecrunch.model.unit.state;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

import de.codecrunch.model.ME_TileState;

public abstract class MA_UnitState {

    abstract public boolean applyMovement(Matrix4 transform, float step);

    protected float rotationMultiplier = 10;

    public boolean isRotating() {
        return false;
    }

    public boolean isIdle() {
        return false;
    }
}
