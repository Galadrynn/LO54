/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.entity.Course_Session;
import fr.utbm.tools.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Aloïs
 */
public class CourseSessionDao {

    private Session session;

    /**
     * Toutes les sessions courses
     * @return 
     */
    public List<Course_Session> getAllCourseSessionsFromDb() {

        List<Course_Session> courseSessionList = null;

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Course_Session");
            courseSessionList = query.list();
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
        
        return courseSessionList;
    }
    
        /**
         * Filtre sur title, date et loc  
         * @param date
         * @param loc
         * @param title
         * @return 
         */
    	public List<Course_Session> getCourseSessionsFilter(Date date, Integer loc, String title) {
            System.out.println(date+" "+loc+" "+title);
		
		session = HibernateUtil.getSessionFactory().openSession();
		List<Course_Session> courseSessions = null;
		
		try {
			session.beginTransaction();
			
                Criteria criteria = session.createCriteria(Course_Session.class,"cs");
                criteria.createCriteria("courseCode","c").add(Restrictions.like("c.title", title, MatchMode.ANYWHERE));
                if (date != null) {
	            criteria.add(Restrictions.le("cs.startDate", date));
	            criteria.add(Restrictions.ge("cs.endDate", date));
	        }
	        if (loc != null) {
	        	criteria.createAlias("locationId", "l");
                        criteria.add(Restrictions.eq("l.id", loc));
	        }
		courseSessions =criteria.list();
		session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	            	session.getTransaction().rollback();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
	        }
		}
		finally {
			if(session != null) {
	            try { 
	            	session.close();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }    
			}
		}
                for(Course_Session c : courseSessions){
                    System.out.println(c.getCourseCode());
                }
		return courseSessions;
	}
}
