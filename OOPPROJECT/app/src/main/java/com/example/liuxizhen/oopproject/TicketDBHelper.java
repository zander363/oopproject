package com.example.liuxizhen.oopproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TicketDBHelper extends SQLiteOpenHelper {

    public TicketDBHelper(Context context, String name,
                      SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new TicketDBHelper(context, DATABASE_NAME, 
                    null, VERSION).getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(com.example.liuxizhen.oopproject.OOPTicket.CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
	    db.execSQL("DROP TABLE IF EXISTD"+"oop.user");
	    onCreate(db);

    }

}

