package is.hi.hbv202g.assignment8;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class StudentTest {

    private Student student;

    @Before
    public void setUp() {
        student = new Student("test", true);
    }

    @Test
    public void testGetName() {
        assertEquals("test", student.getName());
    }

    @Test
    public void testIsFeePaid() {
        assertTrue(student.isFeePaid());
    }

    @Test
    public void testSetFeePaidToFalse() {
        student.setFeePaid(false);

        assertFalse(student.isFeePaid());
    }
}
