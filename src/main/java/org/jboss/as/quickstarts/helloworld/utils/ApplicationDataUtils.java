package org.jboss.as.quickstarts.helloworld.utils;

import org.jboss.as.quickstarts.helloworld.beans.ApplicationData;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.directory.SchemaViolationException;

public class ApplicationDataUtils {

    private ApplicationDataUtils() {
    }

    public static synchronized ApplicationData getApplicationData() {
        ApplicationData applicationData = null;
        try{
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            Object objData = null;
            try{
                objData = envCtx.lookup("helloworld/session-data");
            } catch (Exception nameException){
                System.out.println("First Call, no application data in the context");
            }
            if(objData == null){
                applicationData = new ApplicationData();
                System.out.println("Going to register application data in the context");
                envCtx.bind("helloworld/session-data",applicationData);
            } else {
                System.out.println("Application data found in the context");
                applicationData = (ApplicationData) objData;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return applicationData;
    }

}
