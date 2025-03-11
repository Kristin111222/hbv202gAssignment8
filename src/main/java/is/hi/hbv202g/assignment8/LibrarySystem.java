package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

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

    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListExeption{
        if(authors.isEmpty()){
            throw new EmptyAuthorListExeption("Author list is empty");
    }{
        books.add(new Book(title, authors));
    }
    }

    public void addStudentUser(String name, boolean feePaid){   
        users.add(new Student(name, feePaid));
    }

    public void addFacultyMemberUser(String name, String department){   
        users.add(new FacultyMember(name, department));
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

    public void borrowBook(User user, Book book){
        lendings.add(new Lending(book, user));
    }

    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate){
        lendings.stream().filter(l -> l.getBook().equals(book) && l.getUser().equals(facultyMember)).findFirst().ifPresent(l -> l.setDueDate(newDueDate));
    }

    public void returnBook(User user, Book book){
        lendings.removeIf(l -> l.getBook().equals(book) && l.getUser().equals(user));
    }
}

