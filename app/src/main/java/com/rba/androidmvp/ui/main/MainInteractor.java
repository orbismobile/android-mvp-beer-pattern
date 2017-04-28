package com.rba.androidmvp.ui.main;

import com.rba.androidmvp.app.MyApplication;
import com.rba.androidmvp.model.entity.UserEntity;
import com.rba.androidmvp.storage.db.UserDB;
import com.rba.androidmvp.storage.sp.MySharedPreference;

import java.util.List;

/**
 * Created by Ricardo Bravo on 26/04/17.
 */

public class MainInteractor {

    public static void storeDataInSharePreference(int suma, MainCallback mainCallback) {

        if (suma > 0){
            MySharedPreference.storeSum(MyApplication.getAppContext(), suma);
            mainCallback.onSuccessUS(""+suma);
        }else{
            mainCallback.onErrorUS();
        }
    }

    public static void storeDataInSqlite(UserDB userDB, UserEntity userEntity, MainCallback mainCallback){
        userDB.addUser(userEntity);
    }

    public static List<UserEntity> getUsersFromSqlite(UserDB userDB){
        return userDB.getUser();
    }

}
