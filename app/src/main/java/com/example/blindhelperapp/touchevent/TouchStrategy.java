package com.example.blindhelperapp.touchevent;

import android.view.MotionEvent;

import com.example.blindhelperapp.action.Action;

public abstract class TouchStrategy {

    protected TouchPosition lastTouchPosition;

    public static final TouchStrategy getStrategy(int event) {
        switch (event) {
            case MotionEvent.ACTION_UP:
                return new TouchKeyUp();
            case MotionEvent.ACTION_DOWN:
                return new TouchKeyDown();
            default:
                return new TouchNothing();
        }
    }

    public Action doAction(TouchPosition first, TouchPosition last) {
        updateLastTouchPosition(last);
        return first.compare(last);
    }

    protected void updateLastTouchPosition(TouchPosition touchPosition) {
        this.lastTouchPosition = touchPosition;
    }

    public TouchPosition getLastTouchPosition() {
        return lastTouchPosition;
    }
}
