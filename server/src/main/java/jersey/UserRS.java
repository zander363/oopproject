package jersey;

import javax.ws.rs.*;

@Path("/user")
public class UserRS{

	@GET
	@Path("/{user}")
	public String getUser(int user){
		return ""+user;
	}
	
	@POST
	@Path("/new")
	public int getMovie(@PathParam("name") String name,
			@QueryParam("old")@DefaultValue("1")int old){
		int id=1;
		return id;
	}
}
