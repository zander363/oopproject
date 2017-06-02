import basicClass.Movie;
import basicClass.User;
import basicClass.Ticket;
import java.Time;

public class BookAndRefund{

	/**
	 *this method is use to check whether the fittable seat can be booked.
	 *
	 *@param user is mean the user who intend to book the tickets.
	 *@param movie is mean the movie user want to book.
	 *@param time is mean the start time of movie.
	 *@param n is mean the number of ticket user intend to book.
	 *@return int mean the distinguish situation by our definition.
	 *
	 */
	public static int bookReportCode(User user,Movie movie,LocalTime time,int n);
	/**
	 *this method is use to check whether the fittable seat can be booked in special condition.
	 *
	 *@param user is mean the user who intend to book the tickets.
	 *@param movie is mean the movie user want to book.
	 *@param time is mean the start time of movie.
	 *@param n is mean the number of ticket user intend to book.
	 *@param region is mean the spefisic region the user want,
	 * if no this condition it will be null.
	 *@param continous is mean the condition continous nessarary or not.
	 *@return int mean the distinguish situation by our definition.
	 *
	 */
	public static int bookReportCode(User user,Movie movie,LocalTime time,String region,boolean continuous,int n);
	/**
	 *this method is use to book when check some seat can be book.
	 *
	 *@param user is mean the user who intend to book the tickets.
	 *@param movie is mean the movie user want to book.
	 *@param time is mean the start time of movie.
	 *@param n is mean the number of ticket user intend to book.
	 *@return Ticket[] mean the tickets which be booked.
	 *
	 */
	public static Ticket[] book(User user,Movie movie,LocalTime time,int n);
	/**
	 *this method is use to book when check some seat can be book in some special condition.
	 *
	 *@param user is mean the user who intend to book the tickets.
	 *@param movie is mean the movie user want to book.
	 *@param time is mean the start time of movie.
	 *@param n is mean the number of ticket user intend to book.
	 *@param region is mean the spefisic region the user want,
	 * if no this condition it will be null.
	 *@param continous is mean the condition continous nessarary or not.
	 *@return Ticket[] mean the tickets which be booked.
	 *
	 */
	public static Ticket[] book(User user,Movie movie,LocalTime time,String region,boolean continuous,int n);
	/**
	 *this method is use to report the consequrmce of 
	 *the booking(include normal and conditional booking).
	 *
	 *@param reportCode is mean the code we define to each situation.
	 *@param ticket is mean the tickets user just book 
	 *,if did not book successfully it would be null.
	 *@return String is the text to inform user.
	 *
	 */
	public static String reportBookResult(int reportCode,Ticket[] ticket);
	/**
	 *this method is use to check whether the ticket can be refunded.
	 *
	 *@param ticketID is mean the ticket user have booked.
	 *@return int mean the distinguish situation by our definition.
	 *
	 */
	public static int refundReportCode(int ticketID);
	/**
	 *this method is use to report the consequrmce of 
	 *the refunding.
	 *
	 *@param reportCode is mean the code we define to each situation.
	 *@param ticketID is mean the ticket user have booked.
	 *@return String is the text to inform user.
	 *
	 */
	public static String reportRefundResult(int reportCode,int ticketID);
}

