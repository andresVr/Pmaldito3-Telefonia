/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.telefonia.modelo;

import com.espe.distribuidas.telefonia.persistence.BaseEntity;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author david
 */
@Entity(value = "cliente")
public class Cliente extends BaseEntity{
    
    private String numeroTelefono;
    private double saldo;

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
        

    @Override    
    public String toString() {
        return "Cliente{" + "numeroTelefono=" + numeroTelefono + ", saldo=" + saldo + '}';
    }
    
    
}
