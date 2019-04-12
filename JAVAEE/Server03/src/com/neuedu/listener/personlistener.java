package com.neuedu.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class personlistener
 *
 */
@WebListener
public class personlistener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public personlistener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         
		// TODO Auto-generated method stub
    	ServletContext ad=event.getSession().getServletContext();
    	if(event.getName().equals("user")) {
    		Integer total=(Integer)ad.getAttribute("total");
    		if(total==null) {
    			total=1;
    			ad.setAttribute("total", 1);
    		}else {
    			ad.setAttribute("total", ++total);
    		}
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	ServletContext ad=event.getSession().getServletContext();
    	Integer num =(Integer)ad.getAttribute("total");
		if(num==null) {
			num=0;
		}else {
			num--;
		}
		if(num<=0) {
			num=0;
		}
		ad.setAttribute("total", num);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     * Attribute 被更改时做出反应。
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	HttpSession session=event.getSession();
    	Object o =session.getAttribute("user");
    	if(o!=null) {
    		return;
    	}
    	ServletContext ad=event.getSession().getServletContext();
    	if(event.getName().equals("user")) {
    		Integer total=(Integer)ad.getAttribute("total");
    		if(total==null) {
    			total=1;
    			ad.setAttribute("total", 1);
    		}else {
    			ad.setAttribute("total", ++total);
    		}
    	}
    }
	
}
