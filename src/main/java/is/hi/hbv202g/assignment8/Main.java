package is.hi.hbv202g.assignment8;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws UserOrBookDoesNotExistException{
        LibrarySystem myLibrarySystem = new LibrarySystem();

         // Add users and books
         myLibrarySystem.addStudentUser("Alice", true);
         myLibrarySystem.addFacultyMemberUser("Bob", "Physics");
         myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("Clean Code", "Robert C. Martin");
 
         // Find users and books
         User alice = myLibrarySystem.findUserByName("Alice");
         Book cleanCode = myLibrarySystem.findBookByTitle("Clean Code");
 
         // Borrow a book (this should trigger notifications)
         myLibrarySystem.borrowBook(alice, cleanCode);
 
         // Return the book (this should also trigger notifications)
         myLibrarySystem.returnBook(alice, cleanCode);
    }
}