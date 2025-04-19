package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
     private User testUser;

    private class TestUser extends User {
        public TestUser(String name) {
            super(name);
        }
    }

    @Before
    public void setUp() {
        testUser = new TestUser("Test");
    }

    @Test
    public void testGetName() {
        assertEquals("Test", testUser.getName());
    }

    @Test
    public void testSetName() {
        testUser.setName("Test2");
        assertEquals("Test2", testUser.getName());
    }
}
