import java.time;
public class Movie{
	public int id;
	public LocalTime[] time;
	public int level;
	public String place;
	public Movie();
	public Movie(int id,LocalTime[] time,int level,String place);
	/**
	 *
	 * this method is to show information 
	 * about this ticket(expect for search)
	 *
	 * @return String is mean the text suppose to show to user. 
	 */
	public String showInfo();
}
}
