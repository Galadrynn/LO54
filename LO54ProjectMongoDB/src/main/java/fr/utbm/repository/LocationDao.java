/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.entity.Course_Session;
import org.hibernate.Session;

import java.util.List;
import fr.utbm.entity.Location;
import fr.utbm.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Aloïs
 */
public class LocationDao {
    
     private Session session;

    public List<Location> getAllLocation() {
    
        
        List<Location> locationList = null;

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Location");
            locationList = query.list();
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
        
        return locationList;
        
        
    }
    
}
