package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import basicClass.Ticket;
import basicClass.User;
import basicClass.ourtime;

public class OOPTicket {
	public static final String TABLE_NAME = "ticket";

	public static final String KEY_ID = "_id";

	public static final String USER_COLUMN = "userid";
	public static final String MOVIE_COLUMN = "movieid";
	public static final String SEAT_COLUMN = "seatid";
	public static final String TIME_COLUMN = "time";

	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_COLUMN + " TEXT NOT NULL," + MOVIE_COLUMN + " INTEGER NOT NULL " + TIME_COLUMN + " TEXT NOT NULL)";
	private SQLiteDatabase db;

	public OOPTicket(Context context) {
		db = TicketDBHelper.getDatabase( context );
	}

	public void close() {
		db.close();
	}

	public Ticket insert(Ticket ticket) {
		ContentValues cv = new ContentValues();

		cv.put( USER_COLUMN, ticket.userID );
		cv.put( MOVIE_COLUMN, ticket.movieID );
		cv.put( SEAT_COLUMN, ticket.seatID );
		cv.put( TIME_COLUMN, ticket.time.getinfo() );
		long id = db.insert( TABLE_NAME, null, cv );
		return ticket;
	}

	public Ticket get(String id) {
		Ticket ticket = null;

		String where = KEY_ID + " = " + id;

		Cursor result = db.query( TABLE_NAME, null, where, null, null, null, null, null );

		if (result.moveToFirst()) {
			ticket = getRecord( result );

		}
		result.close();
		return ticket;
	}

	public boolean delete(int id) {
		String where = KEY_ID + " = " + id;
		return db.delete( TABLE_NAME, where, null ) > 0;
	}

	public Ticket getRecord(Cursor cursor) {
		Ticket result = new Ticket(  Integer.parseInt(cursor.getString( 1 )), cursor.getString( 2 ), cursor.getString( 3 ), new ourtime( cursor.getString( 4 ) ) );
		return result;
	}

	public int getCount() {
		int result = 0;
		Cursor cursor = db.rawQuery( "SELECT COUNT(*) FROM " + TABLE_NAME, null );
		if (cursor.moveToNext()) {
			result = cursor.getInt( 0 );
		}
		return result;
	}
}
