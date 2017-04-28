package com.rba.androidmvp.service.recoverypassword;
/**
 * Created by Ricardo Bravo on 26/04/17.
 */
public interface RecoveryPasswordCallback {
    void onSuccessfulRP();
    void onErrorRP();
    void onFailureRP();
}
