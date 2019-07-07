/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import java.util.Scanner;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

/**
 *
 * @author junio
 */
public class ProdutorTopico {
     public static void main(String[] args) throws Exception {
        
         InitialContext context = new InitialContext();
         
         ConnectionFactory cf = (ConnectionFactory) context.lookup("ConnectionFactory");
         Connection conexao = cf.createConnection();
         conexao.start();
         
         Session session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
         
         Destination topico = (Destination) context.lookup("ppdTopico");
         
         MessageProducer produtor = session.createProducer(topico);
         
            for (int i = 0; i < 5; i++) {
                Message message = session.createTextMessage("<pedido><id>" + i + "</id></pedido>");
                produtor.send(message);
            }
         
         
         session.close();
         conexao.close();
         context.close();
    }
}