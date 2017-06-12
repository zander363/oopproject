package jersey;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("oop")
public class OOPApplication extends ResourceConfig{
	public OOPApplication(){
		packages("jersey");
	}
}
