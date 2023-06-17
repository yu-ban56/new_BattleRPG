package battlerpg.server.threads;

import java.net.*;
import java.util.Scanner;

public class ServerThread implements Runnable{
    public static Object source = null;
    @Override public void run() {
        try(ServerSocket serverSock = new ServerSocket(23678)) {
            println("Starting Server.");
            println("Accept Player...");
            Socket accept = serverSock.accept();
            println("Connected " + accept.getInetAddress());
            for(;;) {
                try {
                    String getOut = source.toString();
                    if(getOut.equals("/connection close")) {
                        accept.close();
                    }else if(getOut.equals("/server close")) {
                        serverSock.close();
                    }
                }catch(Exception e){break;}
            }
        }catch(Exception e){e.printStackTrace();}
    }

    private void println(Object str) {
        System.out.println("[Server Thread]" + str);
    }
}
