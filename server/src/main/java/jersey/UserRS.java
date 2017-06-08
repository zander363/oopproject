

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/user")
public class UserRS{

	@GET
	@Path("/{user}")
	public String getUser(int user){
		return user;
	}
	@POST
	@Path("/rate/{user}")
	public String getMovie(int user){
		return user;
	}
}
