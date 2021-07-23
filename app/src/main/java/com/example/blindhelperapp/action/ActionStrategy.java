package com.example.blindhelperapp.action;

import android.widget.ListView;

import com.example.blindhelperapp.QRCode;
import com.example.blindhelperapp.TextToSpeechService;

abstract public class ActionStrategy {

    protected int lastSelected;

    public static final ActionStrategy getStrategy(Action action) {
        switch (action) {
            case LEFT:
                return new ActionLeft();
            case RIGHT:
                return new ActionRight();
            case UP:
                return new ActionUp();
            case DOWN:
                return new ActionDown();
            default:
                return new ActionNothing();
        }
    }

    public void doAction(ListView v, QRCode qrCode, int selected) {
        updateSelectedValue(v, selected);
        runAction(v, qrCode);
    }

    protected void runAction(ListView v, QRCode qrCode) {
        String key = v.getAdapter().getItem(lastSelected).toString();
        String value = qrCode.getInfo(key);
        TextToSpeechService.speak(key + ": " + value);
    }

    protected void updateSelectedValue(ListView v, int selected) {
        this.lastSelected = selected;
    }

    public int getLastSelectedValue() {
        return lastSelected;
    }
}
