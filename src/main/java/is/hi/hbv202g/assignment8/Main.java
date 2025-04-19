package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The main class for the library management system.
 * Provides a text-based interface for interacting with the library system.
 */
public class Main {
        /**
         * The main method for the library management system.
         * 
         * @param args command line arguments
         * @throws UserOrBookDoesNotExistException if user or book lookup fails
          * @throws EmptyAuthorListException if author list is empty
          */
         public static void main(String[] args) throws UserOrBookDoesNotExistException, EmptyAuthorListException {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem myLibrarySystem = new LibrarySystem();
        Boolean running = true;

        while (running) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "show library":
                    printBooks(myLibrarySystem);
                    break;
                case "show users":
                    printUsers(myLibrarySystem);
                    break;
                case "initialize library":
                    initializeLibrary(myLibrarySystem);
                    break;
                case "add new user":
                    addNewUser(myLibrarySystem);
                    break;
                case "add book":
                    addNewBook(myLibrarySystem);
                    break;
                case "borrow book":
                    borrowBook(myLibrarySystem);
                    break;
                case "return book":
                    returnBook(myLibrarySystem);
                    break;
                case "extend lending":
                    extendLending(myLibrarySystem);
                    break;
                case "exit":
                    running = false;
                    System.out.println("Thank you for using our service!");
                    break;
                case "help":
                    printHelp();
                    break;
                default:
                    System.out.println("Unknown command. Type 'help' for a list of commands.");
                    break;
            }
        }
    }

    /**
     * Prints a list of available commands.
     */
    public static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("show library - prints all books in the library");
        System.out.println("show users - prints all users in the library");
        System.out.println("initialize library - adds three books to the library");
        System.out.println("add new user - adds a new user to the library");
        System.out.println("borrow book - allows a user to borrow a book");
        System.out.println("exit - exits the program");
    }

    /**
     * Initializes the library with three books.
     * 
     * @param librarySystem the library system
     * @throws UserOrBookDoesNotExistException if book lookup fails
     */
    public static void initializeLibrary(LibrarySystem librarySystem) throws UserOrBookDoesNotExistException, EmptyAuthorListException {
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Pride and Prejudice", "Jane Austen");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("The Lord Of the Rings", "J.R.R.Tolkien");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Little Women", "Louisa May Alcott");
        librarySystem.addBookWithTitleAndAuthorList("Let It Snow", Arrays.asList(new Author("John Green"), new Author("Maureen Johnson"), new Author("Lauren Myracle")));
    }

    /**
     * Prints all books currently in the library.
     * 
     * @param librarySystem the library system instance
     */
    public static void printBooks(LibrarySystem librarySystem) {
        List<String> bookList = librarySystem.getAllBooks();
        if (bookList.isEmpty()) {
            System.out.println("There are no books in the library");
        } else {
            for (String book : bookList) {
                System.out.println(book);
            }
        }
    }

    /**
     * Prints all users currently in the library.
     * 
     * @param librarySystem the library system instance
     */
    public static void printUsers(LibrarySystem librarySystem) {
        List<String> userList = librarySystem.getAllUsers();
        if (userList.isEmpty()) {
            System.out.println("There are no users in the library");
        } else {
            for (String user : userList) {
                System.out.println(user);
            }
        }
    }

    /**
     * Adds a new user to the library.
     * 
     * @param librarySystem the library system
     */
    public static void addNewUser(LibrarySystem librarySystem) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("Are you a student or a faculty member? Write s for student and f for faculty");
        String userType = scanner.nextLine().trim().toLowerCase();

        if (userType.equals("s")) {
            System.out.println("Have you paid your fees? Write yes or no");
            String feePaid = scanner.nextLine().trim().toLowerCase();
            if (feePaid.equals("yes")) {
                librarySystem.addStudentUser(name, true);
            } else {
                librarySystem.addStudentUser(name, false);
            }
        } else if (userType.equals("f")) {
            System.out.println("What is your department?");
            String department = scanner.nextLine();
            librarySystem.addFacultyMemberUser(name, department);
        }
    }

    /**
     * Adds a new book to the library.
     * 
     * @param librarySystem the library system
     */
    public static void addNewBook(LibrarySystem librarySystem) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the title of the book you want to add?");
        String title = scanner.nextLine();

        System.out.println("Does the book have multiple authors? Write yes or no");
        String multipleAuthors = scanner.nextLine().trim().toLowerCase();

        if (multipleAuthors.equals("yes")) {
            System.out.println("What are the names of the authors? (Separate with commas)");
            String authorNames = scanner.nextLine();

            List<Author> authors = Arrays.stream(authorNames.split("\\s*,\\s*"))
                    .map(Author::new)
                    .collect(Collectors.toList());

            try {
                librarySystem.addBookWithTitleAndAuthorList(title, authors);
            } catch (EmptyAuthorListException e) {
                System.out.println("Failed to add book: " + e.getMessage());
            }
        } else {

        System.out.println("What is the name of the author?");
        String authorName = scanner.nextLine();

        librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        }
    }

    /**
     * Allows a user to borrow a book.
     * 
     * @param librarySystem the library system
     */
    public static void borrowBook(LibrarySystem librarySystem) throws UserOrBookDoesNotExistException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("What is the title of the book you want to borrow?");
        String title = scanner.nextLine();

        librarySystem.borrowBook(librarySystem.findUserByName(name), librarySystem.findBookByTitle(title));
    }

    /**
     * Allows a user to return a book.
     * 
     * @param librarySystem the library system
     */
    public static void returnBook(LibrarySystem librarySystem) throws UserOrBookDoesNotExistException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("What is the title of the book you want to return?");
        String title = scanner.nextLine();

        librarySystem.returnBook(librarySystem.findUserByName(name), librarySystem.findBookByTitle(title));
    }

    /**
     * Allows a faculty member to extend a lending.
     * 
     * @param librarySystem the library system
     */
    public static void extendLending(LibrarySystem librarySystem) throws UserOrBookDoesNotExistException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("What is the title of the book you want to extend?");
        String title = scanner.nextLine();

        System.out.println("How many days do you want to extend the lending for?");
        int days = scanner.nextInt();

        librarySystem.extendLending(librarySystem.findFacultyMemberByName(name), librarySystem.findBookByTitle(title),
                LocalDate.now().plusDays(days));
    }

}