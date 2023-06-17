package battlerpg.api.util.logging;

import java.io.*;

public class Logger {
    private static PrintWriter outStream;
    private static Logger theInstance;

    public static Logger getInstance() {
        if (theInstance == null) {
            theInstance = new Logger("battlerpg.log");
        }
        return theInstance;
    }

    private Logger(String log) {
        try {
            outStream = new PrintWriter(log);
        }catch(Exception e) {e.printStackTrace();}
    }

    public void trace(String message) {
        outStream.println("[TRACE]" + message);
    }

    public void debug(String message) {
        outStream.println("[DEBUG]" + message);
    }

    public void info(String message) {
        outStream.println("[INFO]" + message);
    }

    public void warn(String message) {
        outStream.println("[WARN]" + message);
    }

    public void warn(Throwable t) {
        outStream.println("[WARN]" + t.getMessage());
        t.printStackTrace(outStream);
    }

    public void warn(Throwable t, String message) {
        outStream.println("[WARN]" + message);
        t.printStackTrace(outStream);
    }

    public void error(String message) {
        outStream.println("[ERROR]" + message);
    }

    public void error(Throwable t) {
        outStream.println("[ERROR]" + t.getMessage());
        t.printStackTrace(outStream);
    }

    public void error(Throwable t, String message) {
        outStream.println("[ERROR]" + message);
        t.printStackTrace(outStream);
    }

    public void fatal(String message) {
        outStream.println("[FATAL]" + message);
    }

    public void fatal(Throwable t) {
        outStream.println("[FATAL]" + t.getMessage());
        t.printStackTrace(outStream);
    }

    public void fatal(Throwable t, String message) {
        outStream.println("[FATAL]" + message);
        t.printStackTrace(outStream);
    }

    public void close() {
        outStream.close();
    }
}
