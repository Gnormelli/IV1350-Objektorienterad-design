package se.kth.iv1350.salesProcess.util;

import java.io.IOException;
import java.util.logging.*;

/**
 * Instance to created for handling logging of exceptions
 */
public class Log {
    private final Logger log;
    private FileHandler fileHandler;
    private static final String LOG_FILE_NAME = "LogFile";

    /**
     * Creates instance of the log and attaches file to log in.
     * @throws IOException if something goes wrong
     */
    public Log() throws IOException {
        this.log = Logger.getLogger(Log.class.getName());
        this.fileHandler = new FileHandler(LOG_FILE_NAME);
        log.addHandler(fileHandler);
    }

    /**
     * Instantiates new log message entry in log file.
     * @param msg message to add to log
     */
    public void makeALog(String msg){
        log.log(Level.SEVERE, msg);
    }
}
