package fr.utbm.servlet;

import fr.utbm.entity.Course_Session;
import fr.utbm.repository.CourseSessionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moi
 */
public class ServletHome extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // get allsessionCourse à l'arrache
        CourseSessionDao test = new CourseSessionDao();
        List<Course_Session> toto = test.getAllCourseSessionsFromDb();
                
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>List Sessions courses</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>List Sessions courses</h1>");
                for(Course_Session cs : toto){
                    out.println("<p>"+ cs.getCourseCode());
                    // lien avec ID
                    out.println("<a href='./description?num="+ cs.getId() +"'>Détails</a>");
                    out.println("</p>");
                }
                out.println("</body>");
                out.println("</html>");
            }
        }
    
}
