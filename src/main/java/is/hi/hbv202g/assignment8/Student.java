package is.hi.hbv202g.assignment8;

/**
 * Represents a student user in the library system.
 * Implements the Observer interface to receive notifications.
 */
public class Student extends User implements Observer {
    private Boolean feePaid;

    /**
     * Constructor.
     * @param name the name of the student
     * @param feePaid true if the student has paid their fees
     */
    public Student(String name, Boolean feePaid) {
        super(name);
        this.feePaid = feePaid;
    }

    /**
     * Checks if the student has paid their fees.
     * @return true if the fee is paid
     */
    public Boolean isFeePaid(){
        return feePaid;
    }

    /**
     * Sets the feePaid status for the student.
     * @param feePaid true if the fee is paid
     */
    public void setFeePaid(Boolean feePaid) {
        this.feePaid = feePaid;
    }

    /**
     * Handles the update from the observable.
     * This method is called when the student receives a notification.
     */
    @Override
    public void update(String message) {
        System.out.println("Student " + getName() + " received notification: " + message);
    }
}
