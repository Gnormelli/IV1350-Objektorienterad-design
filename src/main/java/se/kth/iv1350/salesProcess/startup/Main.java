package se.kth.iv1350.salesProcess.startup;

import se.kth.iv1350.salesProcess.controller.Controller;
import se.kth.iv1350.salesProcess.integration.ExternalSystemStartUp;
import se.kth.iv1350.salesProcess.integration.Printer;
import se.kth.iv1350.salesProcess.integration.CashRegister;
import se.kth.iv1350.salesProcess.view.View;

import java.util.Scanner;

public class Main {
    /**
     * Starts up the program.
     * @param args The application takes command line input.
     */
    public static void main(String[] args) {
        ExternalSystemStartUp creator = new ExternalSystemStartUp();

        CashRegister cashRegister = new CashRegister();
        Printer printer = new Printer();
        Controller contr = new Controller(creator, printer, cashRegister);

        View view = new View(contr);
        Scanner scan = new Scanner(System.in);
        view.simulatorOfExecution(scan);
        view.simulatorOfExecution(scan);
    }
}
