package se.kth.iv1350.salesProcess.view;

import se.kth.iv1350.salesProcess.controller.Controller;
import se.kth.iv1350.salesProcess.integration.ItemDTO;
import se.kth.iv1350.salesProcess.integration.RegisteredItemDTO;

/**
 * A placeholder for the real view with hardcoded calls to simulate the
 * system operations to the controller.
 */
public class View {
    private Controller contr;

    /**
     * Constructor for the view.
     *
     * @param contr is the controller in the architectural pattern.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Placeholder that simulates user input to this program.
     */
    public void simulatorOfExecution(){
        contr.startNewSale();
        System.out.println("A new sale has been started.");

        RegisteredItemDTO itemBeingRegistered = new RegisteredItemDTO(3,55555);
        ItemDTO foundItem = contr.searchForItemIdentifier(itemBeingRegistered);
    }
}
