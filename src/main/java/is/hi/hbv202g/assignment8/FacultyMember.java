package is.hi.hbv202g.assignment8;
/**
 * Represents a faculty member in the library system
 * A faculty member has a name and a department and can receive notifications
 */

public class FacultyMember extends User implements Observer{
    
    private String department;

    /**
     * Creates a new faculty member
     * @param name the name of the faculty member
     * @param department the department the faculty member belongs to
     */
    public FacultyMember(String name, String department) {
        super(name);
        this.department = department;
    }   

    /**
     * Returns the department of the faculty member
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the faculty member
     * @param department the new department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Receives a notification message
     * @param message the notification message
     */
    @Override
    public void update(String message) {
        System.out.println("Faculty " + message);
    }
}
