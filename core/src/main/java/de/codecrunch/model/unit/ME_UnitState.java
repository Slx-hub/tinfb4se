package de.codecrunch.model.unit;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public enum ME_UnitState {
    IDLE {
        @Override
        void applyMovement(Matrix4 transform, float step) {

        }
    }, ROTATE_RIGHT {
        @Override
        void applyMovement(Matrix4 transform, float step) {
            transform.rotate(new Vector3(0, -1, 0), step);
        }
    }, ROTATE_LEFT {
        @Override
        void applyMovement(Matrix4 transform, float step) {
            transform.rotate(new Vector3(0, 1, 0), step);
        }
    }, DRIVE_FORWARD {
        @Override
        void applyMovement(Matrix4 transform, float step) {
            transform.translate(0,0,step);
        }
    };

    abstract void applyMovement(Matrix4 transform, float step);
}
