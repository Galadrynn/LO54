/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.servlet;

import fr.utbm.controler.ConsultController;
import fr.utbm.entity.Course_Session;
import fr.utbm.repository.CourseSessionDao;
import fr.utbm.service.ConsultService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Integer locId = null;
            if(!loc.equals("null")) {
                locId = Integer.parseInt(loc);
            }
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = null;
            try {
                if(!datereq.equals("")) {
                    date = formatter.parse(datereq);
                }
            }
            catch (ParseException e) {
			e.printStackTrace();
            }

            ConsultController consultCtrl = new ConsultController();
            List<Course_Session> listCourses = consultCtrl.getCourseSessionsWithFilters(date, locId, desc);
            
            // response JSON
            response.setContentType("application/json");
            String dateSart = "";
            String dateEnd = "";
            
            String actu = "[";
           
            try (PrintWriter out = response.getWriter()) {
                for(Course_Session c : listCourses){
                     
                    dateSart = formatter.format(c.getStartDate());
                    dateEnd = formatter.format(c.getEndDate());
                    
                    actu += "{";
                    actu += "\"Desc\":"+"\""+c.getCourseCode().getTitle()+"\"";
                    actu += ",";
                    actu += "\"Code\":"+"\""+c.getCourseCode().getCode()+"\"";
                    actu += ",";
                    actu += "\"Id\":"+"\""+c.getId()+"\"";
                    actu += ",";
                    actu += "\"Location\":"+"\""+c.getLocationId().getCity()+"\"";
                    actu += ",";
                    actu += "\"StartDate\":"+"\""+dateSart+"\"";
                    actu += ",";
                    actu += "\"EndDate\":"+"\""+dateEnd+"\"";
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
    
}
