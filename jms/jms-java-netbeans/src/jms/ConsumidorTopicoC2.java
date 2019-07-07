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
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

/**
 *
 * @author junio
 */
public class ConsumidorTopicoC2 {
     public static void main(String[] args) throws Exception {
        
         InitialContext context = new InitialContext();
         
         ConnectionFactory cf = (ConnectionFactory) context.lookup("ConnectionFactory");
         Connection conexao = cf.createConnection();
         conexao.setClientID("C2");
         conexao.start();
         
         Session session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
         
         Destination topico = (Topic) context.lookup("ppdTopico");
         
         MessageConsumer consumer = session.createDurableSubscriber((Topic) topico, "assinatura");         
         consumer.setMessageListener(new MessageListener(){
            
            

             @Override
             public void onMessage(Message msg) {
                  TextMessage textMessage = (TextMessage) msg;
                  try {
                      System.out.println(textMessage.getText());
                  } catch(JMSException e) {
                      e.printStackTrace();
                  }
             }
         
         });
         
         new Scanner(System.in).nextLine();
         
         
         session.close();
         conexao.close();
         context.close();
    }
}