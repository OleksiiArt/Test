package ua.nure.artemenko.SummaryTask4.listener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// obtain file name with locales descriptions
    	ServletContext context = event.getServletContext();
    	String localesFileName = context.getInitParameter("locales");
    	
    	// obtain real path on server
    	String localesFileRealPath = context.getRealPath(localesFileName);
    	
    	// locale descriptions
    	Properties locales = new Properties();
    	try {
			locales.load(new FileInputStream(localesFileRealPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	// save descriptions to servlet context
    	context.setAttribute("locales", locales);
    	
		
	}

}
