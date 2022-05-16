package se.kth.iv1350.salesProcess.integration;

/**
 * Exception thrown when operation in <code>ExternalInventorySystem</code> fails.
 */
public class ExternalInventorySystemException extends RuntimeException{

    /**
     * A new instance of the condition in the message is created.
     *
     * @param msg with information of what went wrong.
     */
    public ExternalInventorySystemException(String msg){
        super(msg);
    }
}
