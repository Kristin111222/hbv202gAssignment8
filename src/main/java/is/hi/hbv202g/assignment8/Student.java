package is.hi.hbv202g.assignment8;

public class Student extends User implements Observer {
    private Boolean feePaid;

    public Student(String name, Boolean feePaid) {
        super(name);
        this.feePaid = feePaid;
    }

    public Boolean isFeePaid(){
        return feePaid;
    }

    public void setFeePaid(Boolean feePaid) {
        this.feePaid = feePaid;
    }

    @Override
    public void update(String message) {
        System.out.println("Student " + getName() + " received notification: " + message);
    }
}
