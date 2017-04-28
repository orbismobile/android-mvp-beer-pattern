package com.rba.androidmvp.storage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rba.androidmvp.util.ConstantDB;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static DatabaseHandler mInstance;

    public DatabaseHandler(Context context){
        super(context, ConstantDB.DATABASE_NAME, null, ConstantDB.DATABASE_VERSION);
    }

    protected void getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseHandler(context);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USER_TABLE = "CREATE TABLE " + ConstantDB.TABLE_USER + "("
                + ConstantDB.KEY_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantDB.KEY_USER_NAME+" TEXT, "
                + ConstantDB.KEY_USER_AGE+" TEXT)";

        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
}