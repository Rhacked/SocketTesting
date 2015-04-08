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

public class SocketKlient {
    public static void main(String[] args)throws IOException {
        final int PORT_NR = 8080;
        Scanner readFromCommand = new Scanner(System.in);
        System.out.println("Oppgi navnet på maskinen der tjenerprogrammet kjører");
        String server = readFromCommand.nextLine();
        
        Socket connection = new Socket(server,PORT_NR);
        System.out.println("Nå er forbindelsen opprettet");
        
        InputStreamReader readConnection = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(readConnection);
        PrintWriter writer = new PrintWriter(connection.getOutputStream(), true);
        
        System.out.println("Test1");
        
        String innledning1 = reader.readLine();
        String innledning2 = reader.readLine();
        System.out.println("Test2");
        System.out.println(innledning1+"\n"+innledning2);
        
        String aLine = readFromCommand.nextLine();
        while(!aLine.equals("")){
            writer.println(aLine);
            String respons = reader.readLine();
            System.out.println("Fra tjenerprogrammet: "+respons);
            aLine = readFromCommand.nextLine();
        }
        
        reader.close();
        writer.close();
        connection.close();
    }
    
}
