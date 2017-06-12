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
        List<Course_Session> listCourses = consultCtrl.getAllCourseSessions();
        List<Location> listLocations = consultCtrl.getAllLocations();
        
        request.setCharacterEncoding("UTF-8");
        String button = request.getParameter("button");
        
        request.setAttribute("course_sessions", listCourses);
        request.setAttribute("locations", listLocations);
        request.setAttribute("button", button);
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
