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

import java.io.IOException;
import java.util.Scanner;
public class ServerTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        final int PORT_NR = 8080;
        Server server = new Server(PORT_NR);
        System.out.println("Server has started and is listening on port:"+PORT_NR);
        
        Scanner readFromCmd = new Scanner(System.in);
        String cmd = readFromCmd.nextLine();
        while(!cmd.equals("exit")){
            server.message(cmd);
            System.out.println("Message sent to all: "+cmd);
            cmd = readFromCmd.nextLine();
        }
        
        System.out.println("Shutting down");
        server.shutdown();
        System.exit(0);
    }
    
}
