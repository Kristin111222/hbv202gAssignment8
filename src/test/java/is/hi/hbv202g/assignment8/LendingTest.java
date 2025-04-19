package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class LendingTest {
    private Lending lending;
    private User testUser;
    private Book testBook;

    private class TestUser extends User {
        public TestUser(String name) {
            super(name);
        }
    }

    private class TestBook extends Book {
        public TestBook(String title, String authorName) {
            super(title, authorName);
        }
    }

    @Before
    public void setUp() {
        testUser = new TestUser("Test");
        testBook = new TestBook("TestBook", "TestAuthor");
        lending = new Lending(testBook, testUser);
    }

    @Test
    public void testGetDueDate() {
        LocalDate expectedDueDate = LocalDate.now().plusDays(30);
        assertEquals(expectedDueDate, lending.getDueDate());
    }

    @Test
    public void testSetDueDate() {
        LocalDate newDueDate = LocalDate.of(2025, 5, 15);
        lending.setDueDate(newDueDate);
        assertEquals(newDueDate, lending.getDueDate());
    }

    @Test
    public void testGetBook() {
        assertEquals(testBook, lending.getBook());
    }

    @Test
    public void testSetBook() {
        Book newBook = new TestBook("AnotherTestBook", "AuthorTest");
        lending.setBook(newBook);
        assertEquals(newBook, lending.getBook());
    }

    @Test
    public void testGetUser() {
        assertEquals(testUser, lending.getUser());
    }

    @Test
    public void testSetUser() {
        User newUser = new TestUser("Bob");
        lending.setUser(newUser);
        assertEquals(newUser, lending.getUser());
    }
}
