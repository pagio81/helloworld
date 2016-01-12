/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.helloworld;

import org.jboss.as.quickstarts.helloworld.beans.NotSerializable;
import org.jboss.as.quickstarts.helloworld.model.City;
import org.jboss.as.quickstarts.helloworld.service.CityService;
import org.jboss.as.quickstarts.helloworld.service.HelloService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <p>
 * A simple servlet taking advantage of features added in 3.0.
 * </p>
 * 
 * <p>
 * The servlet is registered and mapped to /HelloServlet using the {@linkplain WebServlet
 * @HttpServlet}. The {@link HelloService } is injected by CDI.
 * </p>
 * 
 * @author Pete Muir
 * 
 */

public class CityServlet extends HttpServlet {

    static String PAGE_HEADER = "<html><head><title>helloworld</title></head><body>";

    static String PAGE_FOOTER = "</body></html>";

    @Inject
    CityService cityService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        InetAddress ip = null;
        String servername = null;
        HttpSession session = req.getSession();

        PrintWriter writer = resp.getWriter();
        writer.println(PAGE_HEADER);

        writer.println("<table>" +
                            "<tr>" +
                                "<td>ID</td>" +
                                "<td>Name</td>" +
                                "<td>District</td>" +
                                "<td>Population</td>" +
                        "</tr>");
        List<City> cities = cityService.findAll();

        for (City city : cities){
            writer.println(
                    "<tr>" +
                    "<td>"+city.getId()+"</td>" +
                    "<td>"+city.getName()+"</td>" +
                    "<td>"+city.getDistrict()+"</td>" +
                    "<td>"+city.getPopulation()+"</td>" +
                    "</tr>");

        }
        writer.println("</table>");


        writer.println(PAGE_FOOTER);
        writer.close();
    }

}
