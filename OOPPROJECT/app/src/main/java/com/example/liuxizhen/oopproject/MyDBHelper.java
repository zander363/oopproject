package com.example.liuxizhen.oopproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context, String name,
                      SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(oopUser.CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
	    db.execSQL("DROP TABLE IF EXISTD"+"oop.user");
	    onCreate(db);

    }

}
