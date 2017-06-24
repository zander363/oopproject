package basicMethod;

import basicClass.*;



public class Base{
	public static Movie[] moviesList;

	/**
	 *this method is to load the movies running schedule when the app start.
	 *
	 */
	public static void loadMovie(){
		ourtime[] movietime1 = {new ourtime(13,00),new ourtime(15,00)};
		ourtime[] movietime2 = {new ourtime(14,00),new ourtime(16,00)};
		Movie movie1 = new Movie("黑子的籃球","0123",movietime1,2,"峨眉廳");
		Movie movie2 = new Movie("黑子的足球","1234",movietime2,1,"武當廳");
		moviesList = new Movie[]{movie1, movie2};
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
