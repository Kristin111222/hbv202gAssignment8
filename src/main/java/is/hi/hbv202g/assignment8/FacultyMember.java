package is.hi.hbv202g.assignment8;

public class FacultyMember extends User implements Observer{
    
    private String department;

    public FacultyMember(String name, String department) {
        super(name);
        this.department = department;
    }   

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void update(String message) {
        System.out.println("Faculty " + getName() + " received notification: " + message);
    }
}
