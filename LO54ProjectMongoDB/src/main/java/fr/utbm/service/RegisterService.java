/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course_Session;
import fr.utbm.repository.ClientDao;

/**
 *
 * @author Aloïs
 */
public class RegisterService {
    
    private ClientDao clDao = new ClientDao();
    
    public void registerClientToCourse(Course_Session courseSessionId, String name, String surname, String adress, Integer phone, String email)
    {
        Client cl = new Client (courseSessionId, name, surname, adress, phone, email);
        clDao.registerClientToCourseInDatabase(cl);
        
        
    }
}
