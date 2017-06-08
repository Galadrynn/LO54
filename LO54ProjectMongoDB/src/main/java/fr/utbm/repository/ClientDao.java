/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.entity.Client;
import fr.utbm.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aloïs
 */
public class ClientDao {

    private Session session;
    
    public void registerClientToCourseInDatabase(Client cl) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(cl);
            session.getTransaction().commit();            
        }
        catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null)
                try {
                    session.getTransaction().rollback();
                } catch(HibernateException he2) {
                    he2.printStackTrace();
                }
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
    }
    
    public List<Client> getAllClient() {
            
        List<Client> clientList = null;
        
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Client");
            clientList = query.list();
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
        return clientList;
    }
    
}
