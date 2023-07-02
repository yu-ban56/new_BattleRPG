package battlerpg.api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.*;

public class Crash extends Error{
    public String getSubMessage() {return "client";}

    public Crash(String message) {
        super(message);
        StackTraceElement[] elements = getStackTrace();
        StringBuilder stacktrace = new StringBuilder();
        for(StackTraceElement element : elements) {
            stacktrace.append(element.toString()).append("\r\n");
        }
        Logger.getLogger("BattleRPG System Log").severe("CRASHED!!!" + stacktrace);
        try(PrintWriter out = new PrintWriter(new FileWriter("crash-" + getSubMessage() + "-" + new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".log"))) {
            out.println("------------ BattleRPG Crash Report ------------\n");
            out.println("              Message: " + getSubMessage() + ":" + getMessage());
            out.print("              stacktrace: \n              ");
            printStackTrace(out);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.exit(-1);
    }

    public Crash() {
        super();
        StackTraceElement[] elements = getStackTrace();
        StringBuilder stacktrace = new StringBuilder();
        for(StackTraceElement element : elements) {
            stacktrace.append(element.toString());
        }
        Logger.getLogger("BattleRPG System Report").severe("CRASHED!!!\r\n          stacktrace:\r\n" + stacktrace);
        try(PrintWriter out = new PrintWriter(new FileWriter("crash-" + getSubMessage() + "-" + new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".log"))) {
            out.println("------------ BattleRPG Crash Report ------------");
            out.println("              Message: " + getSubMessage() + ":" + getMessage());
            out.print("              stacktrace: \n              ");
            printStackTrace(out);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.exit(-1);
    }

    public Crash(Throwable t) {
        super(t);
        String dateTime = "crash-" + getSubMessage() + "-" + new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".log";
        Logger.getLogger("BattleRPG System Log").severe("CRASHED!!!\r\n     stacktrace: ");
        printStackTrace();
        try(PrintWriter out = new PrintWriter(new FileWriter(dateTime))) {
            out.println("------------ BattleRPG Crash Report ------------");
            out.println("              Message: " + getSubMessage() + ":" + getMessage());
            out.print("              stacktrace: \n              ");
            printStackTrace(out);
            System.out.println("Print Crash Report.");
            ProcessBuilder pb = new ProcessBuilder("notepad", dateTime);
            pb.start();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.exit(-1);
    }
}
