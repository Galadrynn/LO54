/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course;
import fr.utbm.entity.Course_Session;
import fr.utbm.repository.ClientDao;
import fr.utbm.repository.CourseDao;
import fr.utbm.repository.CourseSessionDao;
import fr.utbm.repository.MongoDBDao;
import java.util.List;

/**
 *
 * @author Aloïs
 */
public class RegisterService {
    
    private ClientDao clDao;
    private CourseSessionDao csDao;
    private CourseDao cDao;
    private MongoDBDao mongoDao;
    
    public RegisterService()
    {
        clDao = new ClientDao();
        csDao = new CourseSessionDao();
        cDao = new CourseDao();
        mongoDao = new MongoDBDao();
    }
 
    public void registerClientToCourse(Client c) {
        clDao.registerClientToCourseInDatabase(c);
        mongoDao.subscribeClientToCourseSession(c);
    }
    
}
