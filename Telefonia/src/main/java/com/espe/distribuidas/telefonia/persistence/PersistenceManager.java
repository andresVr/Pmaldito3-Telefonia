/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.telefonia.persistence;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Luig Rocha
 */
public class PersistenceManager {

    private static Morphia morphia;
    private static MongoClient mongoClient;
    private final Datastore mds;

//    private static PersistenceManager managerSingleton;


    static {
        MongoClientOptions mongoOptions = MongoClientOptions.builder().socketTimeout(60000).connectTimeout(60000).build();
        
        try {
            mongoClient = new MongoClient(new ServerAddress("localhost"), mongoOptions);
        
        } catch (Exception e) {
            throw new RuntimeException("Error mongodb", e);
        }
        mongoClient.setWriteConcern(WriteConcern.SAFE);
        morphia = new Morphia();
        morphia.mapPackage("com.espe.distribuidas.telefonia.modelo", true);
        
    }

    public PersistenceManager() {
        mds = morphia.createDatastore(mongoClient, "telefonia");
        mds.ensureIndexes();
    }

    public Datastore context() {
        return this.mds;
    }

    public static Morphia getMorphia() {
        return morphia;
    }

    public static void setMorphia(Morphia morphia) {
        PersistenceManager.morphia = morphia;
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    public static void setMongoClient(MongoClient mongoClient) {
        PersistenceManager.mongoClient = mongoClient;
    }

//    public static PersistenceManager getManagerSingleton() {
//         if (managerSingleton == null) {
//            managerSingleton=new PersistenceManager();
//        }
//        return managerSingleton;
//    }
//
//    public static void setManagerSingleton(PersistenceManager managerSingleton) {
//        PersistenceManager.managerSingleton = managerSingleton;
//    }


}
