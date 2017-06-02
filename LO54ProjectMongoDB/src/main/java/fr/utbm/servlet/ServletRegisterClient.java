/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.servlet;

import fr.utbm.controler.SubscribePage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aloïs
 */
@WebServlet(name = "ServletRegisterClient", urlPatterns = {"/ServletRegisterClient"})
public class ServletRegisterClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Get params from request
        String idReq = request.getParameter("idReq");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        Integer id = Integer.parseInt(idReq);
        
        Integer phone2 = Integer.parseInt(phone); // TODO : delete this line
        
        SubscribePage subscribePage = new SubscribePage();
        subscribePage.registerClient(id, last_name, first_name, address, phone2, email);
        
        
        // response JSON
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println("{\"val\":2}");
        }
        
        
    }

}
