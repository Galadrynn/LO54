/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moi
 */

@WebServlet( name="description", urlPatterns = "/description" )
public class ServletDescrption extends HttpServlet {
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Description</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Description</h1>");
                out.println("<p>"+ request.getParameter("num") +"</p>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    
}
