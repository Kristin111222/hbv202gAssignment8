package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

public class Lending {
    
    private java.time.LocalDate dueDate;
    private User user;
    private Book book;
    
    public Lending(Book book, User user) {
        this.book = book;
        this.user = user;
        this.dueDate = java.time.LocalDate.now().plusDays(30);
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }

    public Book getBook(){
        return book;
    }

    public void setBook(Book book){
        this.book = book;
    }

    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
}