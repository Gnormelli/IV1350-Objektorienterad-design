package se.kth.iv1350.salesProcess.controller;

/**
 * Is thrown if an operation fails to execute and the cause is unknown
 */
public class OperationFailedException extends Exception{

    /**
     * A new instance with a message and a cause is created
     *
     * @param message is the exception message
     * @param cause is the reason for the exception
     */
    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
