/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientbase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author galimberti.tommaso
 */
public class ClientBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Apertua connessione");
        try {
            Socket server = new Socket("127.0.0.1", 5500);

            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            Scanner sc = new Scanner(System.in);
            String s = "";
            String[]a =in.readLine().split("::");
            for(int i=0;i<10;i++){
                System.out.print(" "+a[i]);
            }
            System.out.println("");
            System.out.println("Quale conto vuoi usare?");
            s = sc.next();
            out.println(s);
            float cifra;
            int controllo;
            do {
                System.out.println("MENU");
                System.out.println("(1) Versa");
                System.out.println("(2) Preleva");
                System.out.println("(3) Saldo");
                System.out.println("(4) esci");
                System.out.println("Scegli cosa fare");
                controllo = sc.nextInt();
                switch (controllo) {
                    case 1:
                        System.out.println("inserisci la cifra da depositare");
                        cifra = sc.nextFloat();
                        out.println("1" + cifra);
                        System.out.println(in.readLine());
                        break;
                    case 2:
                        System.out.println("inserisci la cira da prelevare");
                        cifra = sc.nextFloat();
                        out.println("2" + cifra);
                        System.out.println(in.readLine());
                        break;
                    case 3:
                        out.println("3");
                        System.out.println(in.readLine());
                        break;
                    case 4:
                        out.println("4");
                        break;
                }
            } while (controllo != 4);
            in.close();
            server.close();
            System.out.println("chiusura connessione");
        } catch (IOException ex) {
            Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
