package com.example.blindhelperapp.touchevent;

import com.example.blindhelperapp.action.Action;

public class TouchNothing extends TouchStrategy {

    @Override
    public Action doAction(TouchPosition first, TouchPosition last) {
        updateLastTouchPosition(first);
        return Action.NOTHING;
    }
}
