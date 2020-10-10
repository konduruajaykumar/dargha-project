package com.nt.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtil;

@WebListener
public class HBSessionCloserRequestListener implements ServletRequestListener {

    
    public HBSessionCloserRequestListener() {
        System.out.println("HBSessionCloserRequestListener()");
    }

	
    public void requestDestroyed(ServletRequestEvent arg0)  { 
    	System.out.println("HBSessionClonserRequestListenr::requestDestroyed(-)");
    	//close HB session 
    	HibernateUtil.closeSesion();
    }

	
    public void requestInitialized(ServletRequestEvent arg0)  { 
        
    }
	
}
