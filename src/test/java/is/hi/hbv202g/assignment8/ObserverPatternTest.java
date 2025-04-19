package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ObserverPatternTest {

    private LibrarySystem library;
    private Book book;

    private static class TestObserver implements Observer {
        public String lastMessage = "";

        @Override
        public void update(String message) {
            lastMessage = message;
        }
    }

    private TestObserver testObserver;

    @Before
    public void setUp() throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        library = new LibrarySystem();

        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Louisa May Alcott"));
        library.addBookWithTitleAndAuthorList("Little Women", authors);
        book = library.findBookByTitle("Little Women");

        library.addStudentUser("Anna", true);

        testObserver = new TestObserver();
        library.attach(testObserver);
    }

    @Test
    public void testObserverGetsNotifiedWhenBookIsBorrowed() throws UserOrBookDoesNotExistException {
        User user = library.findUserByName("Anna");

        library.borrowBook(user, book);

        assertEquals("Anna has borrowed Little Women", testObserver.lastMessage);
    }

    @Test
    public void testObserverGetsNotifiedWhenBookIsReturned() throws UserOrBookDoesNotExistException {
        User user = library.findUserByName("Anna");

        library.borrowBook(user, book);
        library.returnBook(user, book);

        assertEquals("Anna has returned Little Women", testObserver.lastMessage);
    }
}