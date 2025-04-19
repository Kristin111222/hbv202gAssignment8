# Patterns

# Class: Observer
- In Observer class, there is a method like this:
 ```bash
update(String message)
 ```
- this method gets called when something changes
- Classes that implement Observer are Student and FacultyMember.
```bash
public class Student extends User implements Observer{
```
```bash
public class FacultyMember extends User implements Observer{
```


#### what problem does observer solve? 
Without the Observer pattern, you'd have to manually tell every user when a book is borrowed or returned.

#### Solution: 
Create a new class called Observer.
Any object that wants to "listen" for changes must register itself with the object that changes (the Observable).
Observable object notifies all registered observing objects once it changes state, with a notification in Terminal.
Observers: Users
Notification can be like:
Anna borrowed a book named Little Women.

# Class: Notify
Notify is a part of an Observer pattern setup and can notify with a message (when book is borrowed or returned).


- Notify is extended by the class LibrarySystem
```bash
public class LibrarySystem extends Notify {
```
- Now the LibrarySystem is part of an Observer pattern setup. It's acting as a "Subject" and can notify "Observers" (users like Student or FacultyMember) og events.

What does Notify do?
- Keeps a list of "observers"

It has 3 methods:
1)  add (attach) observer
2) remove (detatch) observer
3)  notifyObservers - sends a message to all observers
When LibrarySystem calls notifyObservers(), all attached observers will get notification

How notificatiions work:



# Class: User 

- User is a class
-Student and FacultyMember extend User and also implement Observer
-Users added are now attached as observers
- When a student or faculty member is added, they´re also attached as observers if they implement the Observer interface.

# Class: LibrarySystem extends Notify

- borrowBook and returnBook notify observers with notification in the terminal when book is borrowed or returned

 
 ### Here are methods and how they work:
 ```bash
getAllBooks()
 ```
- Returns a formatted list of all books and their authors
-Could be useful UI or debugging

 ```bash
getAllUsers()
 ```
- Returns list of user names
 ```bash
borrowBook()
 ```
 - Allows a user to borrow a book
  ```bash
 extendLending()
 ```
 - Extends the lending due date for a faculty member
  ```bash
 returnBook()
 ```
-  Lets a user return a book
```bash
boolean userExists = users.stream().anyMatch(u -> u.getName().equals(name));
if (!userExists) {
    ...
}

 ```
 - prevents Duplicate Users


## Class: Main 
### Methods and what they do:

 ```bash
printHelp()
 ```
-Displays a list of valid commands the user can enter
 ```bash
initializeLibrary(LibrarySystem librarySystem)
 ```
- Adds 3 predefined books to the library system
 ```bash
printBooks(LibrarySystem librarySystem)
 ```
- Prints a list of all books currently in the library.
 ```bash
printUsers(LibrarySystem librarySystem)
 ```
- Prints a list of all registered users in the system.
 ```bash
addNewUser(LibrarySystem librarySystem)
 ```
- Adds a new user to the library system via user input.
 ```bash
borrowBook(LibrarySystem librarySystem)
 ```
- Allows a user to borrow a book
 ```bash
returnBook(LibrarySystem librarySystem)
 ```
- Lets a user return a book
- users need to add "return book" to return a book


# How notifications work?

Let’s say:

Anna (a Student) is added to the system → she’s also added as an observer.

Then she borrows Little Women

What happens:
borrowBook() is called

Inside it: notifyObservers("Anna has borrowed Little Women") is triggered

All users (observers) receive this update via their update(String message) method

The message is shown in the terminal.

 ```bash
Anna has borrowed Little Women
 ```




