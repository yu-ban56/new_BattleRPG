package battlerpg.server;

import battlerpg.server.threads.ServerThread;

import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        System.out.println("[main]BattleRPG Server b1.0");
        Thread t = new Thread(new ServerThread(), "Server Thread");
        t.start();
        for(;;) {
            try {
                ServerThread.source = new Scanner(System.in).nextLine();
            }catch(Exception e){break;}
        }
    }
}
