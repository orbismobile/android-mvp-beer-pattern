package com.rba.androidmvp.storage.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.rba.androidmvp.model.entity.UserEntity;
import com.rba.androidmvp.util.ConstantDB;

import java.util.ArrayList;
import java.util.List;

public class UserDB extends DatabaseHandler {

    private final Context context;

    public UserDB(Context context) {
        super(context);
        getInstance(context);
        this.context = context;
    }

    public void addUser(UserEntity userEntity){

        String sql = "INSERT INTO "+ ConstantDB.TABLE_USER +
                " ("+ ConstantDB.KEY_USER_NAME+
                ", "+ConstantDB.KEY_USER_AGE+
                ") VALUES (?,?)";


        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(sql);
        db.beginTransaction();
        statement.clearBindings();
        statement.bindString(1, userEntity.getUserName());
        statement.bindString(2, String.valueOf(userEntity.getAge()));
        statement.execute();

        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public List<UserEntity> getUser(){

        List<UserEntity> userEntities = new ArrayList<>();

        String selectQuery = "SELECT "+
                ConstantDB.KEY_USER_ID+", "+
                ConstantDB.KEY_USER_NAME+", "+
                ConstantDB.KEY_USER_AGE+" FROM " + ConstantDB.TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        try{
            if (cursor.moveToFirst()) {
                do {
                    UserEntity userEntity = new UserEntity();

                    userEntity.setId(cursor.getInt(0));
                    userEntity.setUserName(cursor.getString(1));
                    userEntity.setAge(cursor.getInt(2));
                    userEntities.add(userEntity);
                } while (cursor.moveToNext());
            }
        }finally {
            cursor.close();
        }
        return userEntities;
    }
}