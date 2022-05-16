package se.kth.iv1350.salesProcess.util;

import java.io.IOException;
import java.util.logging.*;

/**
 * Instance to created for handling logging of exceptions
 */
public class AuditTrailLogHandler {
    private final Logger auditTrailLog;
    private FileHandler fileHandler;
    private Level LEVEL_TO_LOG = Level.SEVERE;
    private static final String LOG_FILE_NAME = "AuditTrailLogFile.txt";

    /**
     * Creates instance of the  audit trail log and attaches file to log in.
     * @throws IOException if something goes wrong
     */
    public AuditTrailLogHandler() throws IOException {
        this.auditTrailLog = Logger.getLogger(AuditTrailLogHandler.class.getName());
        this.fileHandler = new FileHandler(LOG_FILE_NAME);
        auditTrailLog.addHandler(fileHandler);
    }

    /**
     * Instantiates new log message entry in log file.
     * @param msg message to add to log
     */
    public void makeALog(String msg){
        auditTrailLog.log(LEVEL_TO_LOG, msg);
    }
}
