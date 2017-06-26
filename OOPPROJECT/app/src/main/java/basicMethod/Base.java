package basicMethod;

import basicClass.*;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.util.Log;
import android.widget.Toast;

import com.example.liuxizhen.oopproject.MainActivity;
import com.example.liuxizhen.oopproject.booking2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class Base{
	public static ArrayList<Movie> moviesList=new ArrayList<>();
	static OkHttpClient client = new OkHttpClient();

	/**
	 *this method is to load the movies running schedule when the app start.
	 *
	 */
	public static void loadMovie(){

		moviesList.clear();
		Request request = new Request.Builder()
				.url("https://raw.githubusercontent.com/b04505009/sample_json/master/movie_info.json")
				.build();
		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String json = response.body().string();
				Log.d("OKHTTP", json);
				//解析JSON
				parseJSON(json);
			}
			@Override
			public void onFailure(Call call, IOException e) {
				//告知使用者連線失敗

			}
		});
	};

	private static void parseJSON(String s) {
		try {
			JSONArray array = new JSONArray(s);
			for (int i=0; i<array.length(); i++){
				JSONObject obj = array.getJSONObject(i);
				String movie = obj.getString("movie").trim();
				String id = obj.getString("id").trim();
				double rate =Double.parseDouble(obj.getString("score").substring(0,4));
				ourtime[] time = new ourtime[obj.getString("time").split( "、" ).length];
				String timeLogStr="";
				for(int j=0; j<obj.getString("time").split( "、" ).length; j++){
					time[j] = new ourtime(obj.getString("time").split( "、" )[j].trim());
					timeLogStr += obj.getString("time").split( "、" )[j].trim()+" ";
				}
				int level = Base.classificationToLevel(obj.getString("classification").trim());
				String place = obj.getString("hall").trim();
				Log.d("JSON:",movie+"/"+id+"/"+timeLogStr+"/"+level+"/"+place);
				Movie t = new Movie(movie, id, time, level, place,rate);
				moviesList.add(t);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	/**
	 *this method is use to search the database
	 *,return the corresponding data when it exist,or return NULL; 
	 *
	 *@param name is the name of the user.
	 *@param age is the age of the user.
	 *@return User this is an object to transfer all data in program.
	 */
	public static User searchUser(String name,int age){
		return null;
	};
	/**
	 * this method is use to construct a Movie object by id.
	 *
	 *@return Movie this is an object to transfer all data in program.
	 */
	public static Movie searchMovie(int id){
		return null;
	};
	/**
	 * this method is use to construct a Seat object by id.
	 *
	 *@return Seat this is an object to transfer all data in program.
	 */
	public static Seat searchSeat(int id){
		return null;
	};

	public static int classificationToLevel(String classification){
		switch (classification){
			case "普遍":
				return 0;
			case "保護":
				return 6;
			case "輔導":
				return 15;
			case "限制":
				return 18;
			default:
				return 18;
		}
	}
}
