package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

/**
 * Represents a lending of a book to a user.
 */
public class Lending {
    
    private java.time.LocalDate dueDate;
    private User user;
    private Book book;
    
    /**
     * Constructs a new lending.
     * 
     * @param book the book being borrowed
     * @param user the user borrowing the book
     */
    public Lending(Book book, User user) {
        this.book = book;
        this.user = user;
        this.dueDate = java.time.LocalDate.now().plusDays(30);
    }

    /**
     * Gets the due date of the lending.
     * 
     * @return the due date
     */
    public LocalDate getDueDate(){
        return dueDate;
    }

    /**
     * Sets the due date of the lending.
     * 
     * @param dueDate the new due date
     */
    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }

    /**
     * Gets the book that was lent.
     * 
     * @return the book
     */
    public Book getBook(){
        return book;
    }

    /**
     * Sets the book that was lent.
     * 
     * @param book the book to set
     */
    public void setBook(Book book){
        this.book = book;
    }

    /**
     * Gets the user that borrowed the book.
     * 
     * @return the user
     */
    public User getUser(){
        return user;
    }
    
    /**
     * Sets the user who is borrowing the book.
     * 
     * @param user the user to set
     */
    public void setUser(User user){
        this.user = user;
    }
}