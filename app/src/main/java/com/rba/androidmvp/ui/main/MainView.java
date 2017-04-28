package com.rba.androidmvp.ui.main;

import com.rba.androidmvp.model.entity.UserEntity;

import java.util.List;

/**
 * Created by Ricardo Bravo on 26/04/17.
 */

public interface MainView {

    void showToast(String carloMessage);
    void updateUserList(List<UserEntity> userEntityList);
    void closeToast();

    void updateAdapter(String name);
}
