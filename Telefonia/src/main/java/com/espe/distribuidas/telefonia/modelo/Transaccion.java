/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.telefonia.modelo;

import com.espe.distribuidas.telefonia.persistence.BaseEntity;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author david
 */
@Entity(value = "transaccion")
public class Transaccion extends BaseEntity{
    
    @Reference
    private Cliente cliente;
    private double monto;
    private double saldoActual;    
    private Date fechaRecarga;

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaRecarga() {
        return fechaRecarga;
    }

    public void setFechaRecarga(Date fechaRecarga) {
        this.fechaRecarga = fechaRecarga;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "monto=" + monto + ", saldoActual=" + saldoActual + ", cliente=" + cliente + ", fechaRecarga=" + fechaRecarga + '}';
    }        
    
}
