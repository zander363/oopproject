package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class TicketDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "oop.movie";
    public static final int VERSION = 1;
    private static SQLiteDatabase database;

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
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
	    db.execSQL("DROP TABLE IF EXISTD"+"oop.user");
	    onCreate(db);

    }

}

