package jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	}
	@GET
	@Path("/normal/{id}")
	public String getMovie(int id){
		return id;
	}
	@GET
	@Path("/rate/{rate}")
	public String getMovie(int rate){
		return id;
	}
}
