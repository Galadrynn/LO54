/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.controler;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course;
import fr.utbm.entity.Course_Session;
import fr.utbm.entity.Location;
import fr.utbm.service.ConsultService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aloïs
 */
public class ConsultController {
    
    private ConsultService consultService;
    
    public ConsultController () {
        consultService = new ConsultService();
    }
    
    public  List<Course_Session> getCourseSessionsWithFilters(Date date, Integer locId, String desc) {
        return consultService.getCourseSessionsWithFilters(date, locId, desc);
    }
    
    public  List<Course_Session> getAllCourseSessions() {
        return consultService.getAllCourseSessions();
    }
    
    public  List<Location> getAllLocations() {
        return consultService.getAllLocations();
    }

    public List<Client> getAllClient(){
       return consultService.getAllClients();
    }
    
    public List<Course> getAllCourses(){
       return consultService.getAllCourses();
    }
}
