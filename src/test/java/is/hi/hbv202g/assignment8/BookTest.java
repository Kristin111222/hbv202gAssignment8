package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BookTest {

     @Test
    public void testConstructorWithSingleAuthor() {
        Book book = new Book("1984", "George Orwell");

        assertEquals("1984", book.getTitle());
        assertEquals(1, book.getAuthors().size());
        assertEquals("George Orwell", book.getAuthors().get(0).getName());
    }

    @Test
    public void testConstructorWithMultipleAuthors() throws EmptyAuthorListException {
        List<Author> authors = Arrays.asList(new Author("Author A"), new Author("Author B"));
        Book book = new Book("Collaborative Book", authors);

        assertEquals("Collaborative Book", book.getTitle());
        assertEquals(2, book.getAuthors().size());
    }

    @Test(expected = EmptyAuthorListException.class)
    public void testConstructorThrowsExceptionOnEmptyAuthorList() throws EmptyAuthorListException {
        new Book("Title", new ArrayList<>());
    }

    @Test
    public void testSetAndGetTitle() {
        Book book = new Book("Original Title", "Author");
        book.setTitle("New Title");

        assertEquals("New Title", book.getTitle());
    }

    @Test
    public void testSetAuthors() throws EmptyAuthorListException {
        Book book = new Book("Book", "Initial Author");
        List<Author> newAuthors = Arrays.asList(new Author("A"), new Author("B"));

        book.setAuthors(newAuthors);
        assertEquals(2, book.getAuthors().size());
        assertEquals("A", book.getAuthors().get(0).getName());
    }

    @Test(expected = EmptyAuthorListException.class)
    public void testSetAuthorsThrowsExceptionOnEmptyList() throws EmptyAuthorListException {
        Book book = new Book("Book", "Author");
        book.setAuthors(new ArrayList<>());
    }

    @Test
    public void testAddAuthor() {
        Book book = new Book("Book", "First Author");
        Author newAuthor = new Author("Second Author");

        book.addAuthor(newAuthor);

        assertEquals(2, book.getAuthors().size());
        assertEquals("Second Author", book.getAuthors().get(1).getName());
    }
    
}
