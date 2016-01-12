package org.jboss.as.quickstarts.helloworld.beans;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by fpagetti on 11/11/2015.
 */
public class ApplicationData implements Serializable {

    private HashMap<String,HttpSession> data;

    public HashMap<String, HttpSession> getData() {
        if(data == null) {
            data = new LinkedHashMap<String, HttpSession>();
        }
        return data;
    }

    public void setData(HashMap<String, HttpSession> data) {
        this.data = data;
    }

    public void registerSession(HttpSession session){
        getData().put(session.getId(),session);
    }

    public void unregisterSession(HttpSession session){
        getData().remove(session.getId());
    }

}
