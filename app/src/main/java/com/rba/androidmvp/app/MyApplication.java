package com.rba.androidmvp.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ricardo Bravo on 26/04/17.
 */

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }

}
