import basicClass.Movie;
import basicClass.User;
import basicClass.Ticket;
import java.Time;

public class search{
	/**
	 * this method is to select the movies have a good rate.
	 * @param rate is mean the least rate user except. 
	 * @return Movies[] is mean all the movies adapt to the condition
	 */
	public static Movies[] searchRate(int rate);
	/**
	 * this method is to search the inofrmation about the ticket
	 *
	 * @param ID is mean the ticket id.
	 * @return Ticket is contain the imformation about the ticket.
	 */
	public static Ticket searchTicket(int ID);
	/**
	 * this method is to search the inofrmation about the movie 
	 *
	 * @param ID is mean the movie id.
	 * @return Movie is contain the information about the movie.
	 */
	public static Movie searchMovie(int ID);

	/**
	 * this method is to search the the movie in some condition about time 
	 *
	 * @param n is mean the number of seat.
	 * @param startTime is the earliest time user ask
	 * @param endTime is the earliest time user ask
	 * @param maxMin is the longest movie user ask ,if no it will be -1
	 * @param minMin is the shortest movie user ask, if no it will be -1
	 * @return Movies[] is mean all the movies adapt to the condition
	 */
	public static Movie[] searchTime(int n,Time startTime,Time endTime,int maxMin,int minMin);

	/**
	 * this method is to search the the movie in some condition about seat 
	 *
	 * @param n is mean the number of seat.
	 * @param region is the region user ask
	 * @return Movies[] is mean all the movies adapt to the condition
	 */
	public static Movie[] searchRegion(int n,String region);


}
