/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socket;

/**
 *
 * @author Rubenhag
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketTjener {
    public static void main(String[] args) throws IOException {
        final int PORT_NR = 8080;
        
        Scanner readFromCommand = new Scanner(System.in);
        ServerSocket server = new ServerSocket(PORT_NR);
        System.out.println("Logg for tjenersiden. Nå venter vi...");
        Socket connection = server.accept();
        System.out.println("Test1");
        InputStreamReader readConnection = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(readConnection);
        PrintWriter writer = new PrintWriter(connection.getOutputStream(), true);
        System.out.println("Test2");
        
        writer.println("Hei, du har kontakt med tjenersiden!");

        System.out.println("Test3");
        
        /*
        String aLine = reader.readLine();
        while(aLine!=null){
            System.out.println("En klient skrev: "+aLine);
            writer.println("Du skrev: "+aLine);
            aLine = reader.readLine();
        }*/
        
        String aLine = readFromCommand.nextLine();
        while(!aLine.equals("")){
            writer.println(aLine);
            aLine = readFromCommand.nextLine();
            if(aLine.equals("exit")){
                System.exit(0);
            }
        }
        reader.close();
        writer.close();
        connection.close();
    }
    
}
