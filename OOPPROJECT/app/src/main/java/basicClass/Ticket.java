package basicClass;

public class Ticket{
	public String userID;
	public String movieID;
	public String seatID;
	public String ticketID;
	public Ticket(){
		userID="";
		movieID="";
		seatID="";
		ticketID="";

	}
	public Ticket(String userID,String movieID,String seatID,String ticketID){
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
