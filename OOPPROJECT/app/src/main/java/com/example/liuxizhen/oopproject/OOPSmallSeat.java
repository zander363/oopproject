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

public class OOPSmallSeat {


	public static final String TABLE_NAME="smallseat";

	
	public static final String KEY_ID= "_id";

	public static final String ROW_COLUMN= "row";
	public static final String NUM_COLUMN= "seatnum";
	public static final String OCC_COLUMN= "occupied";
	public static final String MOVIE_COLUMN="movie";
	public static final String TIME_COLUMN="time";
	public static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+KEY_ID+" TEXT PRIMARY KEY AUTOINCREMENT, "
			+MOVIE_COLUMN+" TEXT NOT NULL, "+TIME_COLUMN+" TEXT NOT NULL, "
			+ROW_COLUMN+" TEXT NOT NULL, "+NUM_COLUMN+" INTEGER NOT NULL"+OCC_COLUMN+" TEXT NOT NULL)";
	private SQLiteDatabase db;

	public static ArrayList<User> usersList=new ArrayList<>();
	static OkHttpClient client = new OkHttpClient();

	public OOPSmallSeat(Context context,String movie,ourtime time){
		db=UserDBHelper.getDatabase(context);
	}

	public void close(){
		db.close();
	}
	public boolean update(SmallSeat seat,ourtime time,String movie){
		ContentValues cv=new ContentValues();

		cv.put(KEY_ID, seat.seatid);
		cv.put(ROW_COLUMN, seat.row);
		cv.put(NUM_COLUMN, seat.seatNum);
		cv.put(OCC_COLUMN, seat.occupied);
		cv.put(MOVIE_COLUMN, movie);
		cv.put(TIME_COLUMN, time.toString());


		// 設定修改資料的條件為編號
		// 格式為「欄位名稱＝資料」
		String where = KEY_ID + "=" + seat.seatid;

		// 執行修改資料並回傳修改的資料數量是否成功
		return db.update(TABLE_NAME, cv, where, null) > 0;
	}
	public SmallSeat get(int id){
		SmallSeat seat=null;

		String where=KEY_ID+" =  "+id;

		Cursor result=db.query(TABLE_NAME,null,where,null,null,null,null,null);

		if(result.moveToFirst()){
			seat=getRecord(result);

		}
		result.close();
		return seat;
	}
	public SmallSeat insert(SmallSeat seat,ourtime time,String movie) {
		ContentValues cv = new ContentValues();


		cv.put(KEY_ID, seat.seatid);
		cv.put(ROW_COLUMN, seat.row);
		cv.put(NUM_COLUMN, seat.seatNum);
		cv.put(OCC_COLUMN, seat.occupied);
		cv.put(MOVIE_COLUMN, movie);
		cv.put(TIME_COLUMN, time.toString());
		return seat;
	}
	public List<SmallSeat> getAll() {
		List<SmallSeat> result = new ArrayList<>();
		Cursor cursor = db.query(
				TABLE_NAME, null, null, null, null, null, null, null);

		while (cursor.moveToNext()) {
			result.add(getRecord(cursor));
		}

		cursor.close();
		return result;
	}
	public boolean update(BigSeat seat,ourtime time,String movie) {
		// 建立準備修改資料的ContentValues物件
		ContentValues cv = new ContentValues();

		cv.put(KEY_ID, seat.seatid);
		cv.put(ROW_COLUMN, seat.row);
		cv.put(NUM_COLUMN, seat.seatNum);
		cv.put(OCC_COLUMN, seat.occupied);

		// 設定修改資料的條件為編號
		// 格式為「欄位名稱＝資料」
		String where = KEY_ID + "=" + seat.seatid;

		// 執行修改資料並回傳修改的資料數量是否成功
		return db.update(TABLE_NAME, cv, where, null) > 0;
	}

	public SmallSeat getRecord(Cursor cursor){
		SmallSeat result=new SmallSeat(cursor.getString(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3)=="true");
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
				.url("https://raw.githubusercontent.com/zander363/oopproject/master/OOPPROJECT/json/small_room.json")
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

			ourtime time=null;
			String movie= null;
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);

				String id=obj.getString(("id"));
				String row=obj.getString(("row"));
				int num = Integer.parseInt( obj.getString("seatNum") );
				Boolean occ=Boolean.parseBoolean(obj.getString("occupied").trim());
				SmallSeat a = new SmallSeat(id,row,num,occ);
				insert(a,time,movie);
			}

		}catch(JSONException e){
			e.printStackTrace();
		}


	}
}