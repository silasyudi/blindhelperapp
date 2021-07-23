package com.example.blindhelperapp.action;

import android.widget.ListView;

public class ActionDown extends ActionStrategy {

    @Override
    protected void updateSelectedValue(ListView v, int selected) {
        selected++;

        if (selected >= v.getAdapter().getCount()) {
            selected = 0;
        }

        this.lastSelected = selected;
    }
}
