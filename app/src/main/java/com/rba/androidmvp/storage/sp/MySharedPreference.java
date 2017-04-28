package com.rba.androidmvp.storage.sp;

/**
 * Created by Ricardo Bravo on 26/04/17.
 */

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {

    //Sharedpref file name
    private static final String PREF_NAME = "ChatRoomPreference";

    //All Shared Preferences Keys
    private static final String KEY_USER_NAME = "user_fake_name";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_SUM = "sum";

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static void initSessionManager(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(PREF_NAME,
                    Context.MODE_PRIVATE);
        }
        editor = sharedPreferences.edit();
        editor.apply();
    }


    public MySharedPreference(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(PREF_NAME,
                    Context.MODE_PRIVATE);
        }
        editor = sharedPreferences.edit();
        editor.apply();
    }


    public static void storeSum(Context context, int suma) {
        initSessionManager(context);
        editor.putInt(KEY_SUM, suma);
        editor.apply();
    }


    public static int getSum(Context context){
        initSessionManager(context);
        return sharedPreferences.getInt(KEY_SUM, -1);
    }

}
