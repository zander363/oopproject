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
	 * this method is to search the imofrmation about the ticket
	 *
	 * @param ID is mean the ticket id.
	 * @return Ticket is contain the imformation about the ticket.
	 */
	public static Ticket searchTicket(int ID);
	/**
	 * this method is to search the inofrmation about the movie 
	 *
	 * @param ID is mean the movie id.
	 * @return CompleteMovie is contain the information about the movie.
	 */
	public static CompleteMovie searchTicket(int ID);



}
