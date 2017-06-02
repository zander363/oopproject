public class Ticket{
	public int userID;
	public int movieID;
	public int seatID;
	public int ticketID;
	public Ticket();
	public Ticket(int userId,int movieID,int seatId,int ticketID);
	/**
	 *
	 * this method is to show information 
	 * about this ticket(expect for search)
	 * @return String is mean the text suppose to show to user. 
	 */
	public String showInfo();
