package basicMethod;

import basicClass.*;



public class Base{
	public static Movie[] moviesList;

	/**
	 *this method is to load the movies running schedule when the app start.
	 *
	 */
	public static void loadMovie(){
		ourtime[] movietime1 = {new ourtime("13:00"),new ourtime("15:00")};
		ourtime[] movietime2 = {new ourtime("14:00"),new ourtime("16:00")};
        ourtime[] movietime3 = {new ourtime("13:40"),new ourtime("18:00")};
		Movie movie1 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie2 = new Movie("黑子的足球","1234",movietime2,1,"武當廳");
		Movie movie3 = new Movie("72不能忍","13400",movietime3,16,"少林廳");
		Movie movie4 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie5 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie6 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie7 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie8 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie9 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie10 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie11 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie12 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie13 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		Movie movie14 = new Movie("一仁的胸肌","0123",movietime1,18,"峨嵋廳");
		moviesList = new Movie[]{movie1, movie2, movie3, movie4, movie5,movie6,
				movie7, movie8, movie9, movie10, movie11, movie12, movie13, movie14};
	};
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
}
