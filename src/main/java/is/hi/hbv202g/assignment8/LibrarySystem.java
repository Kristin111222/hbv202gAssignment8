package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a library system, managing books, users, and lendings.
 * Extends the Notify class to implement the observer pattern
 */
public class LibrarySystem extends Notify {

    private List<Lending> lendings;
    private List<User> users;
    private List<Book> books;
    
    /**
     * Default constructor
     */
    public LibrarySystem(){
        lendings = new ArrayList<Lending>();
        books = new ArrayList<Book>();
        users = new ArrayList<User>();
    }



    /**
     * Adds a book to the library
     * @param title the title of the book to be added
     * @param authors the list of authors of the book
     * @throws EmptyAuthorListException if the authors list is empty
     */
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException{
        if(authors.isEmpty()){
            throw new EmptyAuthorListException("Author list is empty");
    }{
        books.add(new Book(title, authors));
    }
    }

    /**
     * Adds a new student user to the library
     * @param name the name of the student
     * @param feePaid feePaid wether the student has paid their fees
     */
    public void addStudentUser(String name, boolean feePaid){   
        Student student = new Student(name, feePaid);
        users.add(student);
        if( student instanceof Observer){
            attach((Observer) student);
        }
    }

    /**
     * Adds a new faculty member user to the library system
     * @param name the name of the faculty member
     * @param department the department the faculty member belongs to
     */
    public void addFacultyMemberUser(String name, String department){   
        FacultyMember facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
        if( facultyMember instanceof Observer){
            attach((Observer) facultyMember);
        }
    }

    /**
     * Finds a book by its title
     * @param title the title of the book to search for
     * @return the book object that matches the title
     * @throws UserOrBookDoesNotExistException
     */
    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        if(books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null) == null){
            throw new UserOrBookDoesNotExistException("Book does not exist");
    }{ 
        return books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
    }
    }

    /**
     * Finds a user by their name
     * @param name
     * @return the user object that matches the name
     * @throws UserOrBookDoesNotExistException
     */
    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        if(users.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null) == null){
            throw new UserOrBookDoesNotExistException("User does not exist");
    }{
    }    
        return users.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
    }

    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if(user ==null || book == null){
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }
    { 
        lendings.add(new Lending(book, user));
        notifyObservers(user.getName() + " has borrowed " + book.getTitle());
    }
    }

    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate){
        lendings.stream().filter(l -> l.getBook().equals(book) && l.getUser().equals(facultyMember)).findFirst().ifPresent(l -> l.setDueDate(newDueDate));
    }

    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException{
        if(user ==null || book == null){
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }
        {
        lendings.removeIf(l -> l.getBook().equals(book) && l.getUser().equals(user));
        notifyObservers(user.getName() + " has returned " + book.getTitle());
    }
    }

    /**
     * Returns a list of all the books in the library
     * @return a list of string, each string contains the title and author of the book
     */
    public List<String> getAllBooks(){
        List<String> lagaseinna = new ArrayList<>();
        for(Book book: books){
            String authors = book.getAuthors().stream()
                            .map(Author::getName).collect(Collectors.joining(", "));

            lagaseinna.add("Title: " + book.getTitle() + " Author: " + authors);
        }
        return lagaseinna;
    }

    public List<String> getAllUsers(){
        List<String> lagaseinna = new ArrayList<>();
        for(User user: users){
            lagaseinna.add(user.getName());
        }
        return lagaseinna;    
    }
}

