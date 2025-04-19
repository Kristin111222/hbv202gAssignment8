package is.hi.hbv202g.assignment8;

/**
 * Observer interface for implementing the Observer design pattern.
 */
public interface Observer {
    
    /**
     * Called when the subject (Observable) notifies the observer.
     * 
     * @param message the update message sent from the subject
     */
    void update(String message);
}