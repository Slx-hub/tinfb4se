package de.codecrunch.model.unit.state;

import com.badlogic.gdx.math.Matrix4;

import de.codecrunch.model.ME_TileState;

public class M_UnitState_DRIVE_FORWARD extends MA_UnitState {
    float distanceToMove = ME_TileState.tileDistance;

    @Override
    public boolean applyMovement(Matrix4 transform, float step) {
        distanceToMove -= step;
        transform.translate(0, 0, -step - (distanceToMove < 0 ? distanceToMove : 0));
        if (distanceToMove <= 0)
            return true;
        return false;
    }
}
