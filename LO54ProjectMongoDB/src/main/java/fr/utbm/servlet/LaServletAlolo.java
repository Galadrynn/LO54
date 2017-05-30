/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.servlet;

import fr.utbm.entity.Course_Session;
import fr.utbm.repository.CourseSessionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moi
 */
@WebServlet(name = "servlettoto", urlPatterns = {"/toto"})
public class LaServletAlolo extends HttpServlet {
    
    
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>List Sessions courses</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>List Sessions courses</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    
    
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            String val = request.getParameter("val");
            
            CourseSessionDao test = new CourseSessionDao();
            List<Course_Session> toto = test.getCourseSessionsFilterBy(val);
            
           response.setContentType("application/json");
           String actu = "[";
           
            try (PrintWriter out = response.getWriter()) {
                for(Course_Session c : toto){
                    actu += "{";
                    actu += "\"Code\":"+"\""+c.getCourseCode().getCode()+"\"";
                    actu += ",";
                    actu += "\"Id\":"+"\""+c.getId()+"\"";
                    actu += "},";
                }
                 if(actu.equals("[")) actu="0";
                 else  {
                     actu = actu.substring(0, actu.length()-1);
                     actu += "]";
                 }
                 out.println("{\"val\":"+actu+"}");
            }
       
            /*response.setContentType("text/html");
            
            try (PrintWriter out = response.getWriter()) {
                out.println("Hellowww");
                for(Course_Session c : toto){
                    out.println(c.getCourseCode());
                }
                
            }*/
        }
    
}
