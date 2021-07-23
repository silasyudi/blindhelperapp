package com.example.blindhelperapp.action;

import android.widget.ListView;

public class ActionUp extends ActionStrategy {

    @Override
    protected void updateSelectedValue(ListView v, int selected) {
        selected--;

        if (selected < 0) {
            selected = v.getAdapter().getCount() - 1;
        }

        this.lastSelected = selected;
    }
}
