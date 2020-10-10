package com.nt.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtil;

/**
 * Application Lifecycle Listener implementation class HBSessionFactoryCloserServletContextListener
 *
 */
@WebListener
public class HBSessionFactoryCloserServletContextListener implements ServletContextListener {

    
    public HBSessionFactoryCloserServletContextListener() {
    	System.out.println("HBSessionFactoryCloserServletContextListener::contextInitalized(-)");
    	
		try{
		  Class.forName("com.nt.utility.HibernateUtil");
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("HBSessionFactoryCloserServletContextListener::contextDestroyed(-)");
    	HibernateUtil.closeSessionFactory();
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
    	

    }


	private ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
