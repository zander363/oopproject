package jersey;

import javax.ws.rs.*;
import mybatis.MovieMapper;

@Path("/movie")
public class MovieRS{

	/**
	 *this method is to get all movie
	 *(suppose use when Start the App).
	 *
	 *@return String the json contain all movie.
	 */
	@GET
	public String getAllMovie(){
		return "";
	}
	
	@GET
	@Path("/normal/{id}")
	public String getMovie(int id){
		return ""+id;
	}
	
	@GET
	@Path("/rate/{rate}")
	public String getMovieRate(int rate){
		return ""+rate;
	}
}
