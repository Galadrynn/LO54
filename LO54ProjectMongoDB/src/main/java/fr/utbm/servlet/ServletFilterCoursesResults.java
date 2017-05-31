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
                out.println("<h1>List Sessions courses</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    
    
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            String val = request.getParameter("val");
            Date date = null;// = SimpleDateFormat.parse(request.getParameter("date"));
            String locationName = request.getParameter("loc");
            
            boolean noFilterOnLocation = false;
            boolean noFilterOnDate = false;
            
            int loc = getLocationIdFromName(locationName);
            
            if (loc == 0)
               noFilterOnLocation = true;
            
            if (date == null)
                noFilterOnDate = true;
            
            CourseSessionDao courseSessionDao = new CourseSessionDao();
            List<Course_Session> listCourses = courseSessionDao.getCourseSessionsFilterByText(val);
            List<Course_Session> listCoursesFilterDate = courseSessionDao.getCourseSessionsFilterByDate(date);
            List<Course_Session> listCoursesFilterLoc = courseSessionDao.getCourseSessionsFilterByLocation(loc);
            
            boolean toRemoveDate = true;
            boolean toRemoveLoc = true;
            
            for (Course_Session c : listCourses)
            {
                toRemoveDate = true;
                toRemoveLoc = true;
                
                if (!noFilterOnDate)
                    for (Course_Session c2 : listCoursesFilterDate)
                        if (c2.getId().intValue() == c.getId().intValue())
                            toRemoveDate = false;
                
                if (!noFilterOnLocation)
                    for (Course_Session c3 : listCoursesFilterLoc)
                        if (c3.getId().intValue() == c.getId().intValue())
                            toRemoveLoc = false;
                
                // must check if can be removed within the foreach.
                // If not, do a list of Course_Session to remove afterwards
                
                if (!noFilterOnDate && toRemoveDate)
                    listCourses.remove(c);
                
                if (!noFilterOnLocation && toRemoveLoc)
                    listCourses.remove(c);
            }
            
            response.setContentType("application/json");
            String actu = "[";
           
            try (PrintWriter out = response.getWriter()) {
                for(Course_Session c : listCourses){
                    actu += "{";
                    actu += "\"Code\":"+"\""+c.getCourseCode().getTitle()+"\"";
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
        }

    private int getLocationIdFromName(String locationName) {
        
        if (locationName.equals("BELFORT"))
            return 1;
        if (locationName.equals("SEVENANS"))
            return 2;
        if (locationName.equals("MONTBELIARD"))
            return 3;
        // or a sql request that does the same
        return 0;
    }
    
}
