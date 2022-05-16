package se.kth.iv1350.salesProcess.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.salesProcess.controller.Controller;
import se.kth.iv1350.salesProcess.integration.CashRegister;
import se.kth.iv1350.salesProcess.integration.ExternalSystemStartUp;
import se.kth.iv1350.salesProcess.integration.Printer;
import se.kth.iv1350.salesProcess.view.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Uses logger from Java library
 */
class AuditTrailLogHandlerTest {
    AuditTrailLogHandler instanceToTest;
    ExternalSystemStartUp essu;
    Printer printer;
    Controller contr;
    CashRegister cashRegister;
    View view;
    private String LOG_FILE_NAME;

    @BeforeEach
    void setUp() throws IOException {
        instanceToTest = new AuditTrailLogHandler();
        essu = new ExternalSystemStartUp();
        printer = new Printer();
        cashRegister = new CashRegister();
        contr = new Controller(essu, printer, cashRegister);
        view = new View(contr);
        LOG_FILE_NAME = "AuditTrailLogFile.txt";
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
        essu = null;
        printer = null;
        cashRegister = null;
        contr = null;
        view = null;
        LOG_FILE_NAME = null;
    }

    @Test
    void makeALog() throws IOException {
        view.simulatorOfExecution(new Scanner("Yes"));
        assertTrue(fileContains("Could not connect to External Inventory System"));
    }

    private boolean fileContains(String searchedString) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(LOG_FILE_NAME));
        String line;
        while ((line = file.readLine()) != null) {
            if (line.contains(searchedString)) {
                return true;
            }
        }
        return false;
    }
}