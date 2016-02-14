/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.telefonia.servicio;

import com.espe.distribuidas.telefonia.DAO.ClienteDAO;
import com.espe.distribuidas.telefonia.modelo.Cliente;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

/**
 *
 * @author david
 */
@LocalBean
@Stateless
public class ClienteServicio {
    
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    
    public void insertarCliente(Cliente c){
        this.clienteDAO.save(c);
    }
    
    public Cliente obtenerTelefonoPorNumero(String telefono){
        System.out.println("entra dato " + telefono);
        return this.clienteDAO.findOne("numeroTelefono", telefono);
    }
    
    public void actualizarSaldo(String telefono, double valor){
        Query<Cliente> query = this.clienteDAO.createQuery();
        List<Cliente> clientes = query.filter("numeroTelefono", telefono).asList();
        UpdateOperations<Cliente> update = this.clienteDAO.createUpdateOperations().set("saldo", valor);
        UpdateResults results = this.clienteDAO.update(query, update);
    }
}
