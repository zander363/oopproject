

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/ticket")
public class TicketRS{

	@GET
	@Path("/{id}")
	public String getTicket(@PathParam("id")int id){
		return id;
	}
	@POST
	@Path("/{id}")
	public void postTicket(@PathParam("id")int id){
	}
	@DELETE
	@Path("/{id}")
	public void deleteTicket(@PathParam("id") int id){
	}
}
