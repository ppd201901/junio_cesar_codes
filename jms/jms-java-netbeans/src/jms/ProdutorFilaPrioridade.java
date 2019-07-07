/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import java.util.Scanner;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

/**
 *
 * @author junio
 */
public class ProdutorFilaPrioridade {
     public static void main(String[] args) throws Exception {
        
         InitialContext context = new InitialContext();
         
         ConnectionFactory cf = (ConnectionFactory) context.lookup("ConnectionFactory");
         Connection conexao = cf.createConnection();
         
         conexao.start();
         
         Session session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
         
         Destination fila = (Destination) context.lookup("ppdFilaPrioridade");
         
         MessageProducer produtor = session.createProducer(fila);
         
         
        Message message = session.createTextMessage("Mensagem prioridade 0");
        produtor.send(message, DeliveryMode.PERSISTENT, 0,60000);
        message = session.createTextMessage("Mensagem prioridade 9");
        produtor.send(message, DeliveryMode.PERSISTENT, 9,60000);
        message = session.createTextMessage("Mensagem prioridade 5");
        produtor.send(message, DeliveryMode.PERSISTENT, 5,60000); 
        message = session.createTextMessage("Mensagem prioridade 3");
        produtor.send(message, DeliveryMode.PERSISTENT, 3,60000); 
        message = session.createTextMessage("Mensagem prioridade 8");
        produtor.send(message, DeliveryMode.PERSISTENT, 8,60000);  
         session.close();
         conexao.close();
         context.close();
    }
}