package basicClass;

public class Ticket{
	public int userID;
	public String movieID;
	public String seatID;
	public int ticketID;
	public Ticket(){
		userID=0;
		movieID="";
		seatID="";
		ticketID=0;

	}
	public Ticket(int userID,String movieID,String seatID,int ticketID){
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
		return "ticketID:"+ticketID+", movieID:"+movieID+", seatID:"+seatID+", userID:"+userID;

	}
}
