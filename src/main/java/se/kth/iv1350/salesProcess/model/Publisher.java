package se.kth.iv1350.salesProcess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * To invoke events for observers. When changing state or executes code
 * observers are notified. Lets observers be added and removed
 */
public abstract class Publisher {
    private List<Observer> observers = new ArrayList<>();

    void notifyObservers(Sale salesInfo) {
        for (Observer obs : observers) {
            obs.settledSale(salesInfo);
        }
    }

    /**
     * Remove single observer
     * @param obs observer to remove
     */
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    /**
     * Remove multiple observers
     * @param obs observers to remove
     */
    public void removeObservers(List<Observer> obs) {
        observers.removeAll(obs);
    }

    /**
     * Add single observer
     * @param obsr to be added
     */
    public void addObserver(Observer obsr) {
        observers.add(obsr);
    }

    /**
     * Add multiple observers
     * @param obsrs to be added
     */
    public void addObservers(List<Observer> obsrs) {
        observers.addAll(obsrs);
    }
}
