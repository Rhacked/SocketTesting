/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socket;

/**
 *
 * @author Ruben
 */
import java.util.ArrayList;
import java.net.*;
import java.io.IOException;

public class Server {
    private ArrayList<Connection> clientList;
    private ServerSocket serverSocket;
    
    public Server(int port) throws IOException{
        clientList = new ArrayList<>();
        serverSocket = new ServerSocket(port);
        
        Thread accept = new Thread(){
            @Override
            public void run(){
                while(true){
                    try{
                        Socket s = serverSocket.accept();
                        System.out.println("New connection on "+s.getPort());
                        clientList.add(new Connection(s));
                    } catch (IOException e){
                        e.printStackTrace(System.err);
                    }
                }
            }
        };
        
        accept.setDaemon(true);
        accept.start();
    }
    
    public void message(String message){
        for(Connection connection : clientList){
            connection.write(message);
        }
    }
    
    public void shutdown() throws IOException{
        serverSocket.close();
    }
}
