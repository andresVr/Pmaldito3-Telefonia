/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.telefonia.servicio;

import com.espe.distribuidas.telefonia.DAO.TransaccionDAO;
import com.espe.distribuidas.telefonia.modelo.Transaccion;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@LocalBean
@Stateless
public class TransaccionServicio {
    
    private TransaccionDAO transaccionDAO = new TransaccionDAO();
    
    public void insertarTransaccion(Transaccion t){
        this.transaccionDAO.save(t);
    }
}
