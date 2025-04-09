package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibrarySystem extends Notify {

    private List<Lending> lendings;
    private List<User> users;
    private List<Book> books;
    
    public LibrarySystem(){
        lendings = new ArrayList<Lending>();
        books = new ArrayList<Book>();
        users = new ArrayList<User>();
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName){
        books.add(new Book(title, authorName));
    }

    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException{
        if(authors.isEmpty()){
            throw new EmptyAuthorListException("Author list is empty");
    }{
        books.add(new Book(title, authors));
    }
    }

    public void addStudentUser(String name, boolean feePaid){   
        Student student = new Student(name, feePaid);
        users.add(student);
        if( student instanceof Observer){
            attach((Observer) student);
        }
    }

    public void addFacultyMemberUser(String name, String department){   
        FacultyMember facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
        if( facultyMember instanceof Observer){
            attach((Observer) facultyMember);
        }
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        if(books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null) == null){
            throw new UserOrBookDoesNotExistException("Book does not exist");
    }{ 
        return books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
    }
    }

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

