package se.kth.iv1350.salesProcess.util;

import se.kth.iv1350.salesProcess.view.TotalRevenueDisplay;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Log messages is printed to file called log.txt in current directory.
 */
public class TotalRevenueFileOutput extends TotalRevenueDisplay {
    private PrintWriter toStream;

    /**
     * New instance and log file created.
     * Deletes existing log files.
     */
    public TotalRevenueFileOutput(){
        try{
            toStream = new PrintWriter(new FileWriter("log.txt"),true);
        }catch(IOException excp){
            System.out.println("Error: Cannot log");
            excp.printStackTrace();
        }
    }

    /**
     *  Sting is printed to the log file
     *
     * @param msg to be printed.
     */
    @Override
    public void log(String msg) {
        toStream.println(msg);
    }
}

