package basicClass;

public class Ticket{
	public String userID;
	public String movieID;
	public String seatID;
	public String ticketID;
	public ourtime time
	public Ticket(){
		ticketID="";
		userID="";
		movieID="";
		seatID="";
		time=new ourtime();

	}
	public Ticket(String ticketID,String userID,String movieID,String seatID,ourtime time){
		this.ticketID=ticketID;
		this.seatID=seatID;
		this.movieID=movieID;
		this.userID=userID;
		this.time=time;
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
