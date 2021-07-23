package com.example.blindhelperapp.touchevent;

import com.example.blindhelperapp.action.Action;

public class TouchKeyDown extends TouchStrategy {

    @Override
    public Action doAction(TouchPosition first, TouchPosition last) {
        updateLastTouchPosition(last);
        return Action.NOTHING;
    }
}
