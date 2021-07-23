package com.example.blindhelperapp.touchevent;

import android.view.MotionEvent;

import com.example.blindhelperapp.action.Action;

public class TouchPosition {

    private int x;
    private int y;

    public TouchPosition(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();
    }

    public Action compare(TouchPosition other) {
        int xFinal = this.x - other.x;
        int yFinal = this.y - other.y;

        if (Math.abs(xFinal) > Math.abs(yFinal)) {
            return xFinal > 0 ? Action.RIGHT : Action.LEFT;
        }

        return yFinal > 0 ? Action.UP : Action.DOWN;
    }
}
