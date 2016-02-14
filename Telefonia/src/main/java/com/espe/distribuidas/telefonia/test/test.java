/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.telefonia.test;

import com.espe.distribuidas.telefonia.modelo.Cliente;
import com.espe.distribuidas.telefonia.persistence.PersistenceManager;

/**
 *
 * @author david
 */
public class test {
    public static void main(String[] args) {
        
        
        System.out.println("Se crea");
        Cliente c = new Cliente();
        c.setNumeroTelefono("0995025418");
        c.setSaldo(9);        
        
        PersistenceManager pm = new PersistenceManager();
        pm.context().save(c);
        
    }
}
