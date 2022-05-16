package se.kth.iv1350.salesProcess.util;

/**
 * Interface for logging messages in class implementations deciding where.
 */
public interface LoggerInterface {

    /**
     * Logs a string in destination.
     *
     * @param msg to be printed.
     */
    void log(String msg);
}
