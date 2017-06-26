package basicClass;
import basicClass.ourtime;


public class Movie{
	public String moviename;
	public String id;
	public ourtime[] time;
	public int level;
	public String place;
	public double rate;

	public Movie() {
		id="";
		time = new ourtime[0];
		level=0;
		place="";
		rate=0;

    };
	public Movie(String moviename,String id,ourtime[] time,int level,String place,Double rate){
		this.moviename=moviename;
		this.id=id;
		this.time = time;
		this.level=level;
		this.place=place;
		this.rate=rate;

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
    }
    public String determine_theater(){
		switch(this.place){
			case "武當":
				return "大廳";
			case "少林":
				return "大廳";
			case "華山":
				return "大廳";
			case "峨嵋":
				return "小廳";
			case "崆峒":
				return "小廳";
			default:
				return null;


		}

	}



}

