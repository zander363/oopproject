package database;

import android.context.Context;

public class OOPTicket{
	public static final String TABLE_NAME="ticket";
	
	public static final String KEY_ID= "_id";

	public static final String USER_COLUMN= "userid";
	public static final String MOVIE_COLUMN= "movieid";
	public static final String SEAT_COLUMN= "seatid";
	public static final String TIME_COLUMN= "time";

	public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+USER_COLUMN+"TEXT NOT NULL,"+MOVIE_COLUMN+"INTEGER NOT NOT NULL"+TIME_COLUMN+"TEXT NOT NULL)"; 
	private SQLiteDatabase db;

	public OOPTicket(Context context){
		db=TicketDBHelper.getDatabase(context);
	}

	public void close(){
		db.close();
	}
	public Ticket insert(Ticket ticket){
		ContentValues cv=new ContentValues();

		cv.put(USER_COLUMN,ticket.id);
		cv.put(MOVIE_COLUMN,ticket.id);
		cv.put(SEAT_COLUMN,ticket.id);
		cv.put(TIME_COLUMN,ticket.age);
		long id=db.insert(TABLE_NAME,null,cv);
		ticket.ticketID=id;

		return ticket;
	}
	public User get(String id){
		Ticket ticket=null;

		String where=KEY_ID+"="+id;

		Cursor result=db.query(TABLE_NAME,null,where,null,null,null,null,null);

		if(result.moveToFirst()){
			ticket=getRecord(result);

		}
		result.close();
		return ticket;
	}
        public boolean delete(int id){
            String where = KEY_ID + "=" + id;
            return db.delete(TABLE_NAME, where , null) > 0;
        }

	public Ticket getRecord(Cursor cursor){
		Ticket result=new Ticket(cusor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
		return result;
	}

	public int getCount(){
		int result =0;
		Cursor cursor=db.rawQuery("SELECT COUNT(*) FROM"+TABLE_NAME,null);
		if(cursor.movieToNwxt()){
			result=cursorInt(0);
		}
		return result;
	}

}
