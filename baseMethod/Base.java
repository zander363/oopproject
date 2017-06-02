import basicClass.Movie;
import basicClass.User;
import basicClass.Ticket;
import java.Time;

public class BookAndRefund{

	/**
	 *this method is to load the movies running schedule when the app start.
	 *
	 * @return Movie[] is the all Movie running schedule.
	 */
	public static Movie[] loadMovie();
	/**
	 *this method is use to search the database
	 *,return the corresponding data when it exist,or return NULL; 
	 *
	 *@param name is the name of the user.
	 *@param age is the age of the user.
	 *@return User this is a object to transfer all data in program.
	 */
	public static User searchUser(String name,int age);
}
