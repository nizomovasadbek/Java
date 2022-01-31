package kalkulator.swingda;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KalkulatorSwingda {
    public static void main(String[] args) {
        System.out.println("Initsazilatsiya bo'lmoqda...");
        try{
            Thread.sleep(4400);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("'Host' nomini kiriting");
        Scanner sc= new Scanner(System.in);
        try {
            InetAddress IP = InetAddress.getByName(sc.nextLine());
            System.out.printf("'%s' ning IP manzili\n%s", IP.getHostName(), IP.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(KalkulatorSwingda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}