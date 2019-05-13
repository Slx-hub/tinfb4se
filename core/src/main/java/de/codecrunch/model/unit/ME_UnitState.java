package de.codecrunch.model.unit;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

import de.codecrunch.model.ME_TileState;

public enum ME_UnitState {
    IDLE {
        @Override
        boolean applyMovement(Matrix4 transform, float step) {
            return false;
        }
    }, ROTATE_RIGHT {
        float rotationToGo = 90;
        @Override
        boolean applyMovement(Matrix4 transform, float step) {
            transform.rotate(Vector3.Y, -step);
            rotationToGo -= step;
            if (rotationToGo <= 0)
                return true;
            return false;
        }
    }, ROTATE_LEFT {
        float rotationToGo = 90;
        @Override
        boolean applyMovement(Matrix4 transform, float step) {
            transform.rotate(Vector3.Y, step);
            rotationToGo -= step;
            if (rotationToGo <= 0)
                return true;
            return false;
        }
    }, DRIVE_FORWARD {
        float distanceToMove = ME_TileState.tileDistance;
        @Override
        boolean applyMovement(Matrix4 transform, float step) {
            transform.translate(0,0,-step);
            distanceToMove -= step;
            if (distanceToMove <= 0)
                return true;
            return false;
        }
    };

    abstract boolean applyMovement(Matrix4 transform, float step);
}
