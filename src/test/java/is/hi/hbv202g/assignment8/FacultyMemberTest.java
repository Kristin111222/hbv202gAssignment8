package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FacultyMemberTest {
      private FacultyMember facultyMember;

    @Before
    public void setUp() {
        facultyMember = new FacultyMember("Dr. Test", "The testing Department");
    }

    @Test
    public void testGetName() {
        assertEquals("Dr. Test", facultyMember.getName());
    }

    @Test
    public void testGetDepartment() {
        assertEquals("The testing Department", facultyMember.getDepartment());
    }

    @Test
    public void testSetDepartment() {
        facultyMember.setDepartment("Not the testing Department");

        assertEquals("Not the testing Department", facultyMember.getDepartment());
    }

}
