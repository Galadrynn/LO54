/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.utbm.entity.Client;
import fr.utbm.entity.Course_Session;
import fr.utbm.repository.ClientDao;
import fr.utbm.repository.MongoDBDao;
import fr.utbm.service.RegisterService;
import org.bson.Document;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import fr.utbm.tools.HibernateUtil;
import java.util.List;

/**
 *
 * @author Moi
 */
public class MainApp {

    public static void main(String[] args) {
        
        /* This is the function to add something in database*/
       // RegisterService regSer = new RegisterService();
       // regSer.registerClientToCourse(1, "A", "PATOIS", "46 avenue Joffre - Audincourt", 5124684, "je@utbm.fr");
        
        /*ListCoursesService liCoSer = new ListCoursesService();
        List l = liCoSer.getAllCourseSessions();
        System.out.println(l.get(0).toString());*/
            
            
        
        //Session session = HibernateUtil.getSessionFactory().openSession();
        //RegisterService registerService = new RegisterService();
        
        MongoDBDao mongo = new MongoDBDao();
        ClientDao client = new ClientDao();
        List<Client> tata = client.getAllClient();
        mongo.subscribeClientToCourseSession(tata.get(0));
        
        // new Client(), "BRAVO", "Yvan", "Rue de la gare de Belfort", 607874565, "bravoyvan@gtruc.com");
        
        /*
        session.beginTransaction();
        session.persist(new Client("LO54", ));
        session.getTransaction().commit();*/
        /*
        System.out.println("fr.utbm.main.MainApp.main()");
        MongoClient mongoClient = new MongoClient( "localhost" );
        MongoDatabase database = mongoClient.getDatabase("dbLo54");
        MongoCollection<Document> collection = database.getCollection("test");
        System.out.println("toto");
        System.out.println(collection);*/
        
        

    }
    
}
