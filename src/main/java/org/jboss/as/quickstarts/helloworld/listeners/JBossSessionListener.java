package org.jboss.as.quickstarts.helloworld.listeners;

import org.jboss.as.quickstarts.helloworld.beans.ApplicationData;
import org.jboss.as.quickstarts.helloworld.utils.ApplicationDataUtils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebListener
public class JBossSessionListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent event)  {
        HttpSession session = event.getSession();
        System.out.print("Session created: "+session.getId());

        ApplicationData applicationData = ApplicationDataUtils.getApplicationData();
        if (applicationData != null) {
            System.out.print("Session registered");
            applicationData.registerSession(session);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.print("Session destroyed: "+session.getId());

        ApplicationData applicationData = ApplicationDataUtils.getApplicationData();
        if (applicationData != null) {
            System.out.print("Session unregistered");
            applicationData.unregisterSession(session);
        }
    }

}
