package de.codecrunch.model.unit;

import com.badlogic.gdx.math.Matrix4;

public enum ME_UnitState {
    IDLE,ROTATE_RIGHT,ROTATE_LEFT,DRIVE_FORWARD;
    abstract void applyMovement(Matrix4 transform, int speed);
}
