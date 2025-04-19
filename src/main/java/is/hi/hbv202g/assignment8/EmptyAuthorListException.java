package is.hi.hbv202g.assignment8;

/**
 * Exception thrown when attempting to create a book with an empty author list.
 */
public class EmptyAuthorListException extends Exception {

    /**
     * Constructor.
     * 
     * @param message the detail message
     */
    public EmptyAuthorListException(String message) {
        super(message);
    }
    
}

