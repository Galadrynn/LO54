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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "filterCoursesResults", urlPatterns = {"/filterCoursesResults"})
public class ServletFilterCoursesResults extends HttpServlet {
    
    
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>List Sessions courses</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    
    
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            // Get params from request
            String desc = request.getParameter("desc");
            String datereq = request.getParameter("date");
            String loc = request.getParameter("loc");
            
            // Cast to Date & Int
            Integer locId = Integer.parseInt(loc);       
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                if(!datereq.equals("")) {
                    date = formatter.parse(datereq);
                }
            }
            catch (ParseException e) {
			e.printStackTrace();
            }
            
            CourseSessionDao courseSessionDao = new CourseSessionDao();
            List<Course_Session> listCourses = courseSessionDao.getCourseSessionsFilter(date, locId, desc);
            
            // response JSON
            response.setContentType("application/json");
            String actu = "[";
           
            try (PrintWriter out = response.getWriter()) {
                for(Course_Session c : listCourses){
                    actu += "{";
                    actu += "\"Desc\":"+"\""+c.getCourseCode().getTitle()+"\"";
                    actu += ",";
                    actu += "\"Code\":"+"\""+c.getCourseCode().getCode()+"\"";
                    actu += ",";
                    actu += "\"Id\":"+"\""+c.getId()+"\"";
                    actu += ",";
                    actu += "\"Location\":"+"\""+c.getLocationId().getCity()+"\"";
                    actu += ",";
                    actu += "\"StartDate\":"+"\""+c.getStartDate()+"\"";
                    actu += ",";
                    actu += "\"EndDate\":"+"\""+c.getEndDate()+"\"";
                    actu += "},";
                }
                 if(actu.equals("[")) actu="0";
                 else  {
                     actu = actu.substring(0, actu.length()-1);
                     actu += "]";
                 }
                 out.println("{\"val\":"+actu+"}");
            }
        }

    /*private int getLocationIdFromName(String locationName) {
        
        if (locationName.equals("BELFORT"))
            return 1;
        if (locationName.equals("SEVENANS"))
            return 2;
        if (locationName.equals("MONTBELIARD"))
            return 3;
        // or a sql request that does the same
        return 0;
    }*/
    
}
