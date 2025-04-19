package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class LibrarySystemTest {

    LibrarySystem librarySystem;

    @Before
    public void setUp() {
        librarySystem = new LibrarySystem();
    }
        
    @Test
    public void testAddBookWithTitleAndNameOfSingleAuthor() throws UserOrBookDoesNotExistException, EmptyAuthorListException {
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Little Women", "Louisa May Alcott");
        Book found = librarySystem.findBookByTitle("Little Women");
        assertEquals("Little Women", found.getTitle());
    }

    @Test
    public void testAddBookWithTitleAndAuthorList() throws UserOrBookDoesNotExistException, EmptyAuthorListException {
        librarySystem.addBookWithTitleAndAuthorList("Let It Snow", Arrays.asList(new Author("John Green"), new Author("Maureen Johnson"), new Author("Lauren Myracle")));
        Book found = librarySystem.findBookByTitle("Let It Snow");
        assertEquals("Let It Snow", found.getTitle());
    }

    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testFindBookByTitle() throws UserOrBookDoesNotExistException {
        librarySystem.findBookByTitle("Pride and Prejudice");
    }

    @Test(expected = EmptyAuthorListException.class)
    public void testAddBookWithEmptyAuthorList() throws UserOrBookDoesNotExistException, EmptyAuthorListException {
        librarySystem.addBookWithTitleAndAuthorList("Let It Snow", Arrays.asList());
    }

    @Test
    public void testAddStudentUser() throws UserOrBookDoesNotExistException {
        librarySystem.addStudentUser("test", true);
        User studentUser = librarySystem.findUserByName("test");
        assertEquals("test", studentUser.getName());
    }

    @Test
    public void testAddDuplicateStudentUserIsIgnored() throws UserOrBookDoesNotExistException {
        librarySystem.addStudentUser("test", true);
        librarySystem.addStudentUser("test", false);
        assertEquals(1, librarySystem.getAllUsers().size());
    }

    @Test
    public void testAddFacultyMemberUser() throws UserOrBookDoesNotExistException {
        librarySystem.addFacultyMemberUser("test", "the test department");
        User facultyMemberUser = librarySystem.findUserByName("test");
        assertEquals("test", facultyMemberUser.getName());
    }

    @Test
    public void testAddDuplicateFacultyMemberUserIsIgnored() throws UserOrBookDoesNotExistException {
        librarySystem.addFacultyMemberUser("test", "Dept A");
        librarySystem.addFacultyMemberUser("test", "Dept B");
        assertEquals(1, librarySystem.getAllUsers().size());
    }


    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testFindUserByName() throws UserOrBookDoesNotExistException {
        librarySystem.findUserByName("John Green");
    }

    @Test
    public void testBorrowAndReturnBook() throws Exception {
        librarySystem.addStudentUser("test", true);
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Little Women", "Louisa May Alcott");

        User user = librarySystem.findUserByName("test");
        Book book = librarySystem.findBookByTitle("Little Women");

        librarySystem.borrowBook(user, book);
        librarySystem.returnBook(user, book);
    }

    @Test
    public void testExtendLending() throws Exception {
        librarySystem.addFacultyMemberUser("test", "testing department");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Little Women", "Louisa May Alcott");

        FacultyMember faculty = librarySystem.findFacultyMemberByName("test");
        Book book = librarySystem.findBookByTitle("Little Women");

        librarySystem.borrowBook(faculty, book);
        LocalDate newDueDate = LocalDate.now().plusDays(30);
        librarySystem.extendLending(faculty, book, newDueDate);
    }

    @Test
    public void testGetAllBooks() throws EmptyAuthorListException {
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Little Women", "Louisa May Alcott");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("The Lord Of the Rings", "J.R.R.Tolkien");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Pride and Prejudice", "Jane Austen");
        librarySystem.addBookWithTitleAndAuthorList("Let It Snow", Arrays.asList(new Author("John Green"), new Author("Maureen Johnson"), new Author("Lauren Myracle")));
        assertEquals(4, librarySystem.getAllBooks().size());
    }

    @Test
    public void testGetAllUsers() throws UserOrBookDoesNotExistException {
        librarySystem.addStudentUser("test", true);
        librarySystem.addFacultyMemberUser("test2", "testing department");
        assertEquals(2, librarySystem.getAllUsers().size());
    }
}
