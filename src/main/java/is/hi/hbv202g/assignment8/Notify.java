package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class implementing the observer pattern
 */
public abstract class Notify {
    
    private List<Observer> observers; 

    /**
     * Constructs a Notify object with an empty list of observers
     */
    public Notify() {
        observers = new ArrayList<Observer>();
    }

    /**
     * Adds an observer to the list of observers
     * @param observer the observer to add
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers
     * @param observer the observer to detach
     */
    public void detatch(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all attached observers with a message
     * @param message the message to send to the observers
     */
    public void notifyObservers(String message) {
        for(Observer observer : observers) {
            observer.update(message);
        }
    }

}