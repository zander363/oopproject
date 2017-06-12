package jersey;

import javax.ws.rs.*;

@Path("/ticket")
public class TicketRS{

	@GET
	@Path("/{id}")
	public String getTicket(@PathParam("id")int id){
		return ""+id;
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
