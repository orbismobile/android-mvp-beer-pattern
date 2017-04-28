package com.rba.androidmvp.ui.main;

import android.util.Log;

import com.rba.androidmvp.app.MyApplication;
import com.rba.androidmvp.model.entity.UserEntity;
import com.rba.androidmvp.storage.db.UserDB;
import com.rba.androidmvp.util.UserUtil;

/**
 * Created by Ricardo Bravo on 26/04/17.
 */

public class MainPresenter implements MainCallback{

    MainView mainView;
    private UserDB userDB;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        userDB = new UserDB(MyApplication.getAppContext());
    }

    public void validateUser(String userName, int age){

        if(!UserUtil.validName(userName)){
            mainView.showToast("UserName Incorrecto");
            return;
        }

        if(!UserUtil.validateAge(age)){
            mainView.showToast("UserName Incorrecto");
            return;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setAge(age);

        MainInteractor.storeDataInSharePreference(age, this);
        MainInteractor.storeDataInSqlite(userDB, userEntity, this);
    }

    public void getUsers(){

        Log.e("vamos ","vaims "  + MainInteractor.getUsersFromSqlite(userDB).size());
        mainView.updateUserList(MainInteractor.getUsersFromSqlite(userDB));
    }

    @Override
    public void onSuccessUS(String suma) {
        mainView.updateAdapter(suma);
        mainView.showToast("correctamente");
    }

    @Override
    public void onErrorUS() {

    }

    public void destroyData(){
        userDB.close();
        mainView = null;
    }
}
