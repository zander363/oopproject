package basicClass;
import basicClass.ourtime;


public class Movie{
	public int id;
	public ourtime[] time;
	public int level;
	public String place;

	public Movie() {
		id=0;
		time = new ourtime[0];
		level=0;
		place="";

    };
	public Movie(int id,ourtime[] time,int level,String place){
		this.id=id;
		this.time = time;
		this.level=level;
		this.place=place;

    };
	/**
	 *
	 * this method is to show information 
	 * about this ticket(expect for search)
	 *
	 * @return String is mean the text suppose to show to user. 
	 */
	public String showInfo(){
        return "ID:"+id+", time:"+time+", level:"+level+", place:"+place;
    };
}

