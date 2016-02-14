/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.telefonia.DAO;

import com.espe.distribuidas.telefonia.modelo.Cliente;
import com.espe.distribuidas.telefonia.persistence.PersistenceManager;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author david
 */
public class ClienteDAO extends BasicDAO<Cliente, Object>{

    public ClienteDAO() {
        super(Cliente.class, PersistenceManager.getMongoClient(),PersistenceManager.getMorphia(),"telefonia");
    }
    
}
