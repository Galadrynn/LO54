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
import java.util.List;

/**
 *
 * @author Aloïs
 */
public class RegisterService {
    
    private ClientDao clDao;
    private CourseSessionDao csDao;
    private CourseDao cDao;
    
    public RegisterService()
    {
        clDao = new ClientDao();
        csDao = new CourseSessionDao();
        cDao = new CourseDao();
    }
    
    public Course_Session getCourseSessionById (Integer id) {
        return csDao.getCourseSessionById(id);
    }
 
    public void registerClientToCourse(Client c) {
        clDao.registerClientToCourseInDatabase(c);
    }
    
    public List<Course> getAllCourses() {
       return cDao.getAllCourseFromDb();
    }
    
    public List<Client> getAllClient(){
        return clDao.getAllClient();
    }
}
