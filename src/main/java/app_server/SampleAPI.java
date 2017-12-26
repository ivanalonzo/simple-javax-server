package app_server;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;


@Path("v1")
public class SampleAPI {
	//This allows you to store your log in a file. It also 
	//provides various levels of logging which can be used for 
	//emitting different messages
	private static Logger log = Logger.getLogger(SampleAPI.class);
	
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		log.info("Hello world");
		return "Hello, world!";
	}
}
