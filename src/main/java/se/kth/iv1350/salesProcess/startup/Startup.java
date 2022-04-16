package se.kth.iv1350.salesProcess.startup;

import se.kth.iv1350.salesProcess.controller.Controller;
import se.kth.iv1350.salesProcess.integration.ExternalSystemStartUp;
import se.kth.iv1350.salesProcess.integration.Printer;
import se.kth.iv1350.salesProcess.view.View;

public class Startup {
    /**
     * Starts up the program.
     * @param args The application doesn't take any command line input.
     */
    public static void main(String[] args) {
        ExternalSystemStartUp creator = new ExternalSystemStartUp();
        Printer printer = new Printer();
        Controller contr = new Controller(creator, printer);
        View view = new View(contr);
    }
}
