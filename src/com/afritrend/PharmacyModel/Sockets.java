/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyModel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
/**
 *
 * @author Xavier Khonje
 */

public class Sockets extends Endpoint{
    
    private Session session;
    public String Messagegotten;

    @Override
    public void onOpen(Session sn, EndpointConfig ec) {
        this.session = sn;        
        this.session.addMessageHandler(new MessageHandler.Whole<String>() {            
            @Override
            public void onMessage(String message) 
            {                
                Messagegotten = message;
                System.out.println(Messagegotten);
                
//                ByteArrayInputStream bis = null;
//                ObjectInputStream ois = null;
//                
//                try 
//                {
//                    byte data[] = Base64.getDecoder().decode(message);
//                    bis = new ByteArrayInputStream(data);
//                    ois = new ObjectInputStream(bis);
//
//                    ArrayList list = (ArrayList) ois.readObject();
//                    for(int i = 0; i < list.size(); i++)
//                    {
//                        System.out.println(list.get(i));
//                    }
//                } 
//                catch (Exception ex) 
//                {
//                    System.out.println(ex.getMessage());
//                }
//                finally
//                {
//                    if(bis != null)
//                    {
//                        try {                
//                            bis.close();
//                        } catch (IOException ex) {
//                            Logger.getLogger(Sockets.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                    if(ois != null)
//                    {
//                        try {
//                            ois.close();
//                        } catch (IOException ex) {
//                            Logger.getLogger(Sockets.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }                
            }
        });
    }
    
    public void SendMessage(ArrayList listobj)throws IOException
    {        
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ObjectOutputStream objoutstream = new ObjectOutputStream(bytearrayoutputstream);
        objoutstream.writeObject(listobj);
        String str = Base64.getEncoder().encodeToString(bytearrayoutputstream.toByteArray());        
        
        this.session.getBasicRemote().sendText(str);
    }    
}
