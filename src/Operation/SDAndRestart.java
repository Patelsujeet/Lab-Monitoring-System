/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import AllThreads.ShutDownThread;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author HP
 */
public class SDAndRestart {

    HashMap hashMap;
    public SDAndRestart(HashMap hashMap, String op) 
    {
        
        this.hashMap=hashMap;
        Set setofUser=hashMap.entrySet();
        Iterator it=setofUser.iterator();
        while(it.hasNext())
        {
            Map.Entry map=(Map.Entry)it.next();
            Socket sc=(Socket)map.getValue();
            ShutDownThread sht=new ShutDownThread(sc, op);
            sht.start();
        }
        
        
    }
    
}
