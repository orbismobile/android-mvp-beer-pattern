package com.rba.androidmvp.util;

import android.text.TextUtils;

/**
 * Created by Ricardo Bravo on 27/04/17.
 */

public class UserUtil {

    public static boolean validName(String userName){
        return !TextUtils.isEmpty(userName);
    }

    public static boolean validateAge(int age){
        return age > 0;
    }
}
