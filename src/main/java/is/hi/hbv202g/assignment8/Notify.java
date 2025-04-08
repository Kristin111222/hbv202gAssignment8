package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;

public abstract class Notify {
    
    private List<Observer> observers; 

    public Notify() {
        observers = new ArrayList<Observer>();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detatch(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for(Observer observer : observers) {
            observer.update(message);
        }
    }

}