package basicClass;

public class Ticket{
	public int userID;
	public int movieID;
	public int seatID;
	public int ticketID;
	public Ticket(){
		userID=0;
		movieID=0;
		seatID=0;
		ticketID=0;

	}
	public Ticket(int userID,int movieID,int seatID,int ticketID){
		this.ticketID=ticketID;
		this.seatID=seatID;
		this.movieID=movieID;
		this.userID=userID;
	}
	/**
	 *
	 * this method is to show information 
	 * about this ticket(expect for search)
	 *
	 * @return String is mean the text suppose to show to user. 
	 */
	public String showInfo(){
		return null;


	}
}