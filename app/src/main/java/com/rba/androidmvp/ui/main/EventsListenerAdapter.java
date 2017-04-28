package com.rba.androidmvp.ui.main;

import android.view.View;

/**
 * Created by Ricardo Bravo on 28/04/17.
 */

public interface EventsListenerAdapter {

    void onItemClick(View itemView, int position);
    void onItemLongClick(View itemView, int position);

}
