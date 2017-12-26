package app_server;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Logger log = Logger.getLogger(App.class);
		
		log.info("Hello World!");

		ResourceConfig config = new ResourceConfig();
		config.packages("app_server");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(2222);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			log.info("Starting and joining the server");
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
		} finally {
			server.destroy();
		}

	}
}
