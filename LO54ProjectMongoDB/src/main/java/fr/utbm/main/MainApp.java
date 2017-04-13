/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Moi
 */
public class MainApp {

    public static void main(String[] args) {
        System.out.println("fr.utbm.main.MainApp.main()");
        MongoClient mongoClient = new MongoClient( "localhost" );
        MongoDatabase database = mongoClient.getDatabase("dbLo54");
        MongoCollection<Document> collection = database.getCollection("test");
        System.out.println("fr.utbm.main.MainApp.main()");

    }
    
}
