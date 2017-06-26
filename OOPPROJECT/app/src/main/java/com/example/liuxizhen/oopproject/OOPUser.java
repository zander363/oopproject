package com.example.liuxizhen.oopproject;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import basicClass.*;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class OOPUser {
	public static final String TABLE_NAME="user";
	
	public static final String KEY_ID= "_id";

	public static final String NAME_COLUMN= "name";
	public static final String AGE_COLUMN= "age";
	public static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME_COLUMN+" TEXT NOT NULL, "+AGE_COLUMN+" INTEGER NOT NULL)";
	private SQLiteDatabase db;

	public static ArrayList<User> usersList=new ArrayList<>();
	static OkHttpClient client = new OkHttpClient();

	public OOPUser(Context context){
		db=UserDBHelper.getDatabase(context);
	}

	public void close(){
		db.close();
	}
	public User insert(User user){
		ContentValues cv=new ContentValues();

		cv.put(NAME_COLUMN,user.id);
		cv.put(AGE_COLUMN,user.age);
		long id=db.insert(TABLE_NAME,null,cv);
		user.id=(int)id;

		return user;
	}
	public User get(String name,int age){
		User user=null;

		String where=NAME_COLUMN+" = \'"+name+"\' AND "+AGE_COLUMN+" = "+age;

		Cursor result=db.query(TABLE_NAME,null,where,null,null,null,null,null);

		if(result.moveToFirst()){
			user=getRecord(result);

		}
		result.close();
		return user;
	}
	public List<User> getAll() {
		List<User> result = new ArrayList<>();
		Cursor cursor = db.query(
				TABLE_NAME, null, null, null, null, null, null, null);

		while (cursor.moveToNext()) {
			result.add(getRecord(cursor));
		}

		cursor.close();
		return result;
	}

	public User getRecord(Cursor cursor){
		User result=new User(cursor.getString(1),cursor.getInt(2),cursor.getInt(0));
		return result;
	}

	public int getCount(){

		Cursor cursor=db.rawQuery("SELECT * FROM ["+TABLE_NAME+']',null);
		return cursor.getCount();

	}


	public void connect(){


		Request request = new Request.Builder()
				.url("https://raw.githubusercontent.com/zander363/oopproject/master/OOPPROJECT/json/user.json")
				.build();
		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String json = response.body().string();
				Log.d("OKHTTP", json);
				loadSample(json);
			}
			@Override
			public void onFailure(Call call, IOException e) {

			}
		});
	};
	public void loadSample(String s){
		try {
			JSONArray array = new JSONArray(s);
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				int index = obj.getInt("index");
				String name=obj.getString(("name"));
				int age=obj.getInt("age");
				User a = new User(name,age,index);
				usersList.add( a );
				insert(a);
			}

		}catch(JSONException e){
			e.printStackTrace();
		}


	}
}