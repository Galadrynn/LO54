/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course_Session;
import fr.utbm.repository.CourseSessionDao;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Aloïs
 */
public class ListCoursesService {
    
    private CourseSessionDao coSessDao = new CourseSessionDao();
    
    public List<Course_Session> getAllCourseSessions()
    {
        return coSessDao.getAllCourseSessionsFromDb();
    }
    
    public ResultSet filterCoursesByFormationTitle(ResultSet r)
    {
        
        return r;
    }
    
    public ResultSet filterCoursesByDate(ResultSet r)
    {
        
        return r;
    }
    
    public ResultSet filterCoursesByLocation(ResultSet r)
    {
        
        return r;
    }
}
