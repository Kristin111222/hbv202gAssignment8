package is.hi.hbv202g.assignment8;

/**
 * Represents a user in the library system.
 * This class is an abstract class and cannot be instantiated directly.
 */
public abstract class User {
    private String name;

    /**
     * Constructs a new User with the given name.
     * 
     * @param name the name of the user
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the user.
     * 
     * @return the user´s name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the user.
     * 
     * @param name the new name of the user
     */
    public void setName(String name){
        this.name = name;
    }
}
