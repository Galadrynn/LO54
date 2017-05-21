/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.entity.Course;
import fr.utbm.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aloïs
 */
public class CourseDao {
    
    private Session session;

    public List<Course> getAllCourseFromDb() {

        List<Course> courseList = null;

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Course");
            courseList = query.list();
        }
        catch (HibernateException he) {
            he.printStackTrace();
        }
        finally {
            if (session != null)
                try {
                    session.close();
                }
                catch (HibernateException he) {
                    he.printStackTrace();
                }
        }
        
        return courseList;
    }
    
}
