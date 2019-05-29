package de.codecrunch.model.unit.state;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class M_UnitState_ROTATE_LEFT extends MA_UnitState {
    float rotationToGo = 90;

    @Override
    public boolean applyMovement(Matrix4 transform, float step) {
        step *= rotationMultiplier;
        rotationToGo -= step;
        transform.rotate(Vector3.Y, step + (rotationToGo < 0 ? rotationToGo : 0));
        return rotationToGo <= 0;
    }

    @Override
    public boolean isRotating() {
        return true;
    }
}
