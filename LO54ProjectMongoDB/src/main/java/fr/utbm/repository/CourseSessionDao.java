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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aloïs
 */
public class CourseSessionDao {

    private Session session;

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
    
    // - filtrer la liste des formations en fonction du lieu de la session, ce lieu provenant d'une liste déroulante.
    public List<Course_Session> getCourseSessionsFilterByLocation(Integer locationId) {
        
        List<Course_Session> courseSessionList = null;

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Course_Session WHERE Course_Session.LOCATIONID = :locationId").setParameter("locationId", locationId);
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
    
    //(- filtrer la liste des formations par les sessions disponibles à une date donnée.)        
    public List<Course_Session> getCourseSessionsFilterByDate(Date d) { // Je suis pas certain de l'énoncé, c'est ambigu.
        
        List<Course_Session> courseSessionList = null;

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Course_Session WHERE Course_Session.STARTDATE < :date AND Course_Session.ENDDATE > :date").setParameter("date", d);
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
    
    // - filtrer la liste des formations par un mot clé contenu dans le titre de la formation.
    public List<Course_Session> getCourseSessionsFilterBy(String s) {
        
        List<Course_Session> courseSessionList = null;

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Course_Session cse where cse.courseCode LIKE :code").setString("code", '%'+s+'%');
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
    
}
