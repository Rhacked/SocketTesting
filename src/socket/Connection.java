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
import java.io.PrintWriter;
import java.net.*;
import java.io.IOException;

public class Connection{
    PrintWriter out;
    Socket socket;
    
    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream(), true);
    }
    
    public void write(String command){
        out.println(command);
    }
}
