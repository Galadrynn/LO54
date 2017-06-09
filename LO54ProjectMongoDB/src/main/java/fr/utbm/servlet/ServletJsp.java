/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.servlet;


import fr.utbm.controler.ConsultController;
import fr.utbm.entity.Location;
import fr.utbm.entity.Course_Session;
import fr.utbm.repository.CourseSessionDao;
import fr.utbm.repository.LocationDao;
import fr.utbm.service.ConsultService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletjsp", urlPatterns = {"/"})
public class ServletJsp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ConsultController consultCtrl = new ConsultController();
        
        List<Course_Session> toto = consultCtrl.getAllCourseSessions();
        
        List<Location> toto2 = consultCtrl.getAllLocations();
        
        /*CourseSessionDao test = new CourseSessionDao();
        List<Course_Session> toto = test.getCourseSessionsFilterBy("LO54");*/
       
       
        /*CourseDao test = new CourseDao();
        List<Course> toto = test.getAllCourseFromDb();
        System.out.println("efeaf " + toto.size());*/
       
        Map<String, String> map = new HashMap<String, String>();
        /*map.put("test","test");
        map.put("oui","oui");*/
        
        //map.put("course_sessions", toto);
        
        request.setAttribute("course_sessions", toto);
        request.setAttribute("locations", toto2);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/home.jsp" ).forward( request, response );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
