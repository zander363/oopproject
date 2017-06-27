package basicClass;

public class Ticket{
	public int userID;
	public String movieID;
	public String seatID;
	public ourtime time;
	public Ticket(){
		userID=0;
		movieID="";
		seatID="";
		time=new ourtime();

	}
	public Ticket(int userID,String movieID,String seatID,ourtime time){
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
		return " movieID:"+movieID+", seatID:"+seatID+", userID:"+userID;
	}
}
