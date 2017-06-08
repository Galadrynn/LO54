/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.controler;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course_Session;
import fr.utbm.service.ConsultService;
import fr.utbm.service.RegisterService;

/**
 *
 * @author Aloïs
 */
public class HomeCtrl {

    private RegisterService registerService;
    private ConsultService consultService;
    
    public HomeCtrl () {
        registerService = new RegisterService();
        consultService = new ConsultService();
    }
    
    public void registerClient(Integer id, String lastName, String firstName, String address, String phone, String email) {
                
        Course_Session cs = consultService.getCourseSessionById(id);
        Client c = new Client(cs, lastName, firstName, address, phone, email);
        registerService.registerClientToCourse(c);
    }
}
