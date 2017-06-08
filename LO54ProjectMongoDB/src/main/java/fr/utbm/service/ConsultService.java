/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course;
import fr.utbm.entity.Course_Session;
import fr.utbm.entity.Location;
import fr.utbm.repository.ClientDao;
import fr.utbm.repository.CourseDao;
import fr.utbm.repository.CourseSessionDao;
import fr.utbm.repository.LocationDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Norgannon
 */
public class ConsultService {
    
    private ClientDao clDao;
    private CourseSessionDao csDao;
    private CourseDao cDao;
    private LocationDao lDao;
    
    public ConsultService()
    {
        clDao = new ClientDao();
        csDao = new CourseSessionDao();
        cDao = new CourseDao();
        lDao = new LocationDao();
    }
    
    public List<Course_Session> getAllCourseSessions () {
        return csDao.getAllCourseSessionsFromDb();
    }
    
    public Course_Session getCourseSessionById (Integer id) {
        return csDao.getCourseSessionById(id);
    }
 
    public List<Course> getAllCourses() {
       return cDao.getAllCourseFromDb();
    }
    
    public List<Client> getAllClients() {
        return clDao.getAllClient();
    }
    
    public List<Location> getAllLocations() {
        return lDao.getAllLocations();
    }

    public List<Course_Session> getCourseSessionsWithFilters(Date date, Integer locId, String desc) {
        return csDao.getCourseSessionsFilter(date, locId, desc);
    }
}
