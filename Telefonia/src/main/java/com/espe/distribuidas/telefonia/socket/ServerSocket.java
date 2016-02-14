/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.telefonia.socket;

import com.espe.distribuidas.telefonia.modelo.Cliente;
import com.espe.distribuidas.telefonia.modelo.Transaccion;
import com.espe.distribuidas.telefonia.servicio.ClienteServicio;
import com.espe.distribuidas.telefonia.servicio.TransaccionServicio;
import java.util.Date;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Andres Vr
 */
@ServerEndpoint("/serversocket")
public class ServerSocket {
    
    
    private ClienteServicio clienteServicio = new ClienteServicio();
    private TransaccionServicio transaccionServicio = new TransaccionServicio();
    
    @OnOpen
    public void handleOpen() {
        System.out.println("cliente telefonica conectado ahora");
    }

    @OnClose
    public void handleClose() {
        System.out.println("cliente estaa desconectado");

    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }
    
    @OnMessage
    public String handleMessage(String message){
        System.out.println("mesaje: "+ message);
        
        String []datos = StringUtils.split(message,"|");
        
        
        String telefono = datos[0];
        double valor = Double.parseDouble(datos[1]);
        
        System.out.println(telefono + " ------ " + valor);
        
        Cliente c = this.clienteServicio.obtenerTelefonoPorNumero(telefono);
        
        if(c != null){
            message = "cliente SI existe";
            System.out.println(message + " _> " + c.toString());
            
            Transaccion t = new Transaccion();
            t.setCliente(c);
            t.setFechaRecarga(new Date());
            t.setMonto(valor);
            double newSaldo = valor + c.getSaldo();
            t.setSaldoActual(newSaldo);
            
            this.transaccionServicio.insertarTransaccion(t);
            this.clienteServicio.actualizarSaldo(telefono, newSaldo);
            
            System.out.println("Transaccion realizada con exito " + t.toString());
            message = "OK";
        }else{
            message = "cliente NO existe";
            System.out.println(message);
            message = "NO";
        }
        
        String replyMessage="echo "+ message;
        System.out.println("Mensaje  enviar:" + replyMessage);
        return replyMessage;
    }
}
