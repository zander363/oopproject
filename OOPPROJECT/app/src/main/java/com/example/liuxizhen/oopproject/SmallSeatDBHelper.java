package com.example.liuxizhen.oopproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SmallSeatDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "oop.movie";
    public static final int VERSION = 1;
    private static SQLiteDatabase database;

    public SmallSeatDBHelper(Context context, String name,
                      SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new SmallSeatDBHelper(context, DATABASE_NAME,
                    null, VERSION).getWritableDatabase();
        }
        return database;
    }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(OOPSmallSeat.CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + OOPSmallSeat.TABLE_NAME);

            onCreate(db);
        }


}

