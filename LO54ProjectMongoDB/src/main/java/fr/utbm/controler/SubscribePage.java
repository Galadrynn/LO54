/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.controler;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course_Session;
import fr.utbm.service.RegisterService;

/**
 *
 * @author Aloïs
 */
public class SubscribePage {

    private RegisterService registerService;
    
    public SubscribePage () {
        registerService = new RegisterService();
        
    }
    
    public void registerClient(Integer id, String lastName, String firstName, String address, Integer phone, String email) {
        Course_Session cs = registerService.getCourseSessionById(id);
        Client c = new Client(cs, lastName, firstName, address, phone, email);
        System.out.println(c);
        registerService.registerClientToCourse(c);
    }
}
