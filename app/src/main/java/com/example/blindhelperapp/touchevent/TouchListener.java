package com.example.blindhelperapp.touchevent;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.example.blindhelperapp.QRCode;
import com.example.blindhelperapp.action.Action;
import com.example.blindhelperapp.action.ActionStrategy;

public class TouchListener implements View.OnTouchListener {

    private QRCode qrCode;
    private TouchPosition lastTouch;
    private int selected;

    public TouchListener() {
        setInformationQRCode(null);
    }

    public void setInformationQRCode(QRCode qrCode) {
        this.qrCode = qrCode;
        this.selected = 0;
        this.lastTouch = null;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Action action = getAction(event);
        runAction(v, action);
        return true;
    }

    public Action getAction(MotionEvent event) {
        int eventAction = event.getActionMasked();

        TouchStrategy touchStrategy = TouchStrategy.getStrategy(eventAction);
        Action action = touchStrategy.doAction(lastTouch, new TouchPosition(event));

        lastTouch = touchStrategy.getLastTouchPosition();

        return action;
    }

    public void runAction(View v, Action action) {
        ActionStrategy actionStrategy = ActionStrategy.getStrategy(action);
        actionStrategy.doAction((ListView) v, qrCode, selected);

        selected = actionStrategy.getLastSelectedValue();
    }
}
