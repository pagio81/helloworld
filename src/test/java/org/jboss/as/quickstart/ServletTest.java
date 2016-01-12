package org.jboss.as.quickstart;

import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class ServletTest {

    @Test
    @Ignore
    public void testCookie() throws IOException{

        CookieStore cookieStore = new BasicCookieStore();

        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", "4HqnCb3csujZiPMZS9uwt31W");
        cookie.setDomain("10.133.16.72");
        cookie.setPath("/jboss-helloworld");


        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://10.133.16.84:8080/jboss-helloworld/HelloWorld");

        HttpContext localContext = new BasicHttpContext();
        localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

        CloseableHttpResponse response1 = httpclient.execute(httpGet,localContext);

        // The underlying HTTP connection is still held by the response object
        // to allow the response content to be streamed directly from the network socket.
        // In order to ensure correct deallocation of system resources
        // the user MUST call CloseableHttpResponse#close() from a finally clause.
        // Please note that if response content is not fully consumed the underlying
        // connection cannot be safely re-used and will be shut down and discarded
        // by the connection manager.
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            //EntityUtils.consume(entity1);

            System.out.println(EntityUtils.toString(entity1));
        } finally {
            response1.close();
        }




    }


}
