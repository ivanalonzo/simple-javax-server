package app_server;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	
	/*
	 * This method behaves like the hello world method, but it accepts one query 
	 * string. The value in the query string is is returned back to the user
	 * Note there is no error handling in the code, so if the query string is 
	 * malformed, or invalid, there is a strong possibility the server could crash
	 */
	@GET
	@Path("queryGet")
	@Produces(MediaType.TEXT_PLAIN)
	public String differentMethod(
			@QueryParam(value = "queryString") String queryString
			) {
		log.info("This is query GET. The query was: " + queryString);
		return queryString;
	}
	
	@GET
	@Path("queryGet2")
	@Produces(MediaType.TEXT_PLAIN)
	public String differentMethod(
			@QueryParam(value = "queryString") String queryString,
			@QueryParam(value = "queryString2") String queryString2
			) 
	{
		
	try {
		
		int one = Integer.parseInt(queryString.trim());
		int two = Integer.parseInt(queryString2.trim());
		int sum = one + two;
		log.info("This is queryGET. The query was: " + sum);
		return " " + sum;
	}
	catch (NumberFormatException nfe) {
		
		log.info("Input not valid. (Input was: " + queryString + ", " + queryString2 + ")");
		return "Input not valid. (Input was: " + queryString + ", " + queryString2 + ")";
		}
	}
}
