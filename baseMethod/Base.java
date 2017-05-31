import basicClass.Movie;
import basicClass.User;
import basicClass.Ticket;
import java.Time;

public class BookAndRefund{
    //可...可惡

	public static User searchUser(String name,int age);
	public static Ticket book(User user,Movie movie,LocalTime time,int n);
	public static String reportBookResult(int reportCode,Ticket ticket,User user,Movie movie,LocalTime time);
	public static int refundReportCode(int ticketID);
	public static String reportRefundResult(int reportCode,int ticketID);
}
