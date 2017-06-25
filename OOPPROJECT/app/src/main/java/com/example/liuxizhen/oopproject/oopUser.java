package com.example.liuxizhen.oopproject;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import basicClass.*;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class OOPUser {
	public static final String TABLE_NAME="user";
	
	public static final String KEY_ID= "_id";

	public static final String NAME_COLUMN= "name";
	public static final String AGE_COLUMN= "age";
	public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME_COLUMN+"TEXT NOT NULL,"+AGE_COLUMN+"INTEGER NOT NOT NULL)"; 
	private SQLiteDatabase db;
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

		String where=NAME_COLUMN+"="+name+" AND "+AGE_COLUMN+"="+age;

		Cursor result=db.query(TABLE_NAME,null,where,null,null,null,null,null);

		if(result.moveToFirst()){
			user=getRecord(result);

		}
		result.close();
		return user;
	}

	public User getRecord(Cursor cursor){
		User result=new User(cursor.getString(1),cursor.getInt(2),cursor.getInt(0));
		return result;
	}

	public int getCount(){
		int result =0;
		Cursor cursor=db.rawQuery("SELECT COUNT(*) FROM"+TABLE_NAME,null);
		if(cursor.moveToNext()){
			result=cursor.getInt(0);
		}
		return result;
	}


	public void connect(){


		Request request = new Request.Builder()
				.url("https://gist.githubusercontent.com/ychins1340/62676449991ed2eee47b93394ad13760/raw/b2683c0d5bd5c2c1b2a19ea2fe5cbe5afd9fe069/user.json")
				.build();
		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String json = response.body().string();
				Log.d("OKHTTP", json);
				//解析JSON
				loadSample(json);
			}
			@Override
			public void onFailure(Call call, IOException e) {
				//告知使用者連線失敗

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
				insert(a);
			}

		}catch(JSONException e){
			e.printStackTrace();
		}


	}
}
