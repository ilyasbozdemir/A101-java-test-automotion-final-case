package logger;

import org.apache.log4j.LogManager;
import org.testng.log4testng.Logger;

import java.time.LocalDateTime;
import java.util.Date;

public class Log {
    private static Logger logger = Logger.getLogger(Log.class);
    public static void info(String msg){
        System.out.println("INFO: "+toDate()+" "+msg);
    }
    public static void fail(String msg){
        System.err.println("FAIL: "+toDate()+" "+msg);
    }
    public static String toDate(){
        LocalDateTime now = LocalDateTime.now();
        return "[" +now.toString()+"]";

    }
}
