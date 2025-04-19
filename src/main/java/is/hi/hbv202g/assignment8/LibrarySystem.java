package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a library system, managing books, users, and lendings.
 * Extends the Notify class to implement the observer pattern.
 */
public class LibrarySystem extends Notify {

    private List<Lending> lendings;
    private List<User> users;
    private List<Book> books;
    
    /**
     * Default constructor.
     */
    public LibrarySystem(){
        lendings = new ArrayList<Lending>();
        books = new ArrayList<Book>();
        users = new ArrayList<User>();
    }

    /**
     * Adds a book to the library.
     * 
     * @param title the title of the book to be added
     * @param authorName the name of the author of the book
     */
    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName){
        books.add(new Book(title, authorName));
    }


    /**
     * Adds a book to the library.
     * 
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
     * Adds a new student user to the library.
     * 
     * @param name the name of the student
     * @param feePaid feePaid wether the student has paid their fees
     */
    public void addStudentUser(String name, boolean feePaid){   
        boolean userExists = users.stream().anyMatch(u -> u.getName().equals(name));
        if (!userExists) {
            Student student = new Student(name, feePaid);
            users.add(student);
            if (student instanceof Observer) {
                attach((Observer) student);
            }
    }
    }

    /**
     * Adds a new faculty member user to the library system.
     * 
     * @param name the name of the faculty member
     * @param department the department the faculty member belongs to
     */
    public void addFacultyMemberUser(String name, String department){   
        boolean userExists = users.stream().anyMatch(u -> u.getName().equals(name));
        if (!userExists) {
            FacultyMember facultyMember = new FacultyMember(name, department);
            users.add(facultyMember);
            if (facultyMember instanceof Observer) {
                attach((Observer) facultyMember);
            }
    }
    }

    /**
     * Finds a book by its title.
     * 
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
     * Finds a user by their name.
     * 
     * @param name the name of the user to search for
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

    /**
    * Finds a faculty member by their name.

    * @param name the name of the faculty member to search for
    * @return the FacultyMember object that matches the name
    * @throws UserOrBookDoesNotExistException 
    */
    public FacultyMember findFacultyMemberByName(String name) throws UserOrBookDoesNotExistException {
        return users.stream()
                    .filter(user -> user instanceof FacultyMember && user.getName().equals(name))
                    .map(user -> (FacultyMember) user)
                    .findFirst()
                    .orElseThrow(() -> new UserOrBookDoesNotExistException("Faculty member does not exist"));
    }


  /**
    * Allows a user to borrow a book.

     * @param user the user who is borrowing the book
     * @param book the book that is being borrowed
     * @throws UserOrBookDoesNotExistException
     */
    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if(user ==null || book == null){
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }
    { 
        lendings.add(new Lending(book, user));
        notifyObservers(user.getName() + " has borrowed " + book.getTitle());
    }
    }

    /**
     * Extends the lending due date for a faculty member.
     * 
     * @param facultyMember The faculty member extending the lending
     * @param book The book that is being extended
     * @param newDueDate The new due date
     */
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate){
        lendings.stream().filter(l -> l.getBook().equals(book) && l.getUser().equals(facultyMember)).findFirst().ifPresent(l -> l.setDueDate(newDueDate));
    }

    /**
     * Allows a user to return a book.
     * 
     * @param user the user who is returning the book
     * @param book the book that is being returned
     * @throws UserOrBookDoesNotExistException 
     */
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
     * Returns a list of all the books in the library.
     * 
     * @return a list of string, each string contains the title and author of the book
     */
    public List<String> getAllBooks(){
        List<String> formatedBooks = new ArrayList<>();
        for(Book book: books){
            String authors = book.getAuthors().stream()
                            .map(Author::getName).collect(Collectors.joining(", "));

            formatedBooks.add("Title: " + book.getTitle() + " Author: " + authors);
        }
        return formatedBooks;
    }

    /**
     * Returns a list of all the users in the library.
     * 
     * @return a list of string, each string contains the name of the user
     */
    public List<String> getAllUsers(){
        List<String> formatedUsers = new ArrayList<>();
        for(User user: users){
            formatedUsers.add("Name: " + user.getName() );
        }
        return formatedUsers;    
    }
}


