package com.example.liuxizhwn.oopproject;
import

import android.context.Context;

public class OOPUser{
	public static final String TABLE_NAME="user";
	
	public static final String KEY_ID= "_id";

	public static final String NAME_COLUMN= "name";
	public static final String AGE_COLUMN= "age";
	public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME_COLUMN+"TEXT NOT NULL,"+AGE_COLUMN+"INTEGER NOT NOT NULL)"; 
	private SQLiteDatabase db;

	public OOPUser(Context context){
		db=MyDBHelper.getDatabase(context);
	}

	public void close(){
		db.close();
	}
	public User insert(User user){
		ContentValues cv=new ContentValues();

		cv.put(NAME_COLUMN,user.id);
		cv.put(AGE_COLUMN,user.age);
		long id=db.insert(TABLE_NAME,null,cv);
		user.setId(id);

		return user;
	}
	public User get(String name,int age){
		User user=null;

		String where=NAME_COLUMN+"="+name+" AND "+AGE_COLUMN+"="+age;

		Cursor result=db.query(TABLE_NAME,null,where,null,null,null,null,null);

		if(result.moveToFirst()){
			user=getRecord(result);

		}
		result.close();
		return user;
	}

	public User getRecord(Cursor cursor){
		User result=new User(cusor.getString(1),cursor.getInt(2),cursor.getInt(0));
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
	public void loadSameple(){
	}
}
