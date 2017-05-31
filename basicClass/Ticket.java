public class Ticket{
	public int userID;
	public int movieID;
	public int seatID;
	public int ticketID;
	public Ticket();
	public Ticket(int userId,int movieID,int seatId,int ticketID);
	/**
	 *this method reportCode is use to check
	 *whether there are any problem in the proccess of gernerating object.
	 *
	 *
	 *@return the int is mean the different situation defined by ourselves.
	 */
	public int reportCode();
