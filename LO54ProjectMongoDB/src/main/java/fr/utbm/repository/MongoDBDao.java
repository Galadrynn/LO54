/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.utbm.entity.Client;
import org.bson.Document;

/**
 *
 * @author Aloïs
 */
public class MongoDBDao {
    
    public void subscribeClientToCourseSession(Client cl) {

        MongoClient mongoClient = null;
        
        try{
            mongoClient = new MongoClient("localhost", 27017);

            MongoDatabase db;
            db = mongoClient.getDatabase("SCHOOL");
            
            MongoCollection<Document> collection = db.getCollection("CLIENTS");
            
            Document doc = new Document();
            doc.put("lastName", cl.getLastName());
            doc.put("firstName", cl.getFirstName());
            doc.put("address", cl.getAddress());
            doc.put("phone", cl.getPhone());
            doc.put("email", cl.getEmail());
            doc.put("courseSessionId", cl.getCourseSessionId().getId());
            
            collection.insertOne(doc);
            
        } catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        } finally {
            mongoClient.close();
        }
    }
}
