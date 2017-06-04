/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.controler;

import fr.utbm.entity.Course;
import fr.utbm.service.RegisterService;
import java.util.List;

/**
 *
 * @author Aloïs
 */
public class CoursesCtrl {
        private RegisterService registerService;
    
    public CoursesCtrl () {
        registerService = new RegisterService();
    }
    
    public List<Course> getAllCourses(){
       return registerService.getAllCourses();
    }
}
