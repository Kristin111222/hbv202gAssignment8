# describe  where a pattern is used and what classes have which role in that pattern.

 ## Class: LibrarySystem:

 ### 1 Notify
 -the class extends Notify
- Now the LibrarySystem is part of an Observer pattern setup. It's acting as a "Subject" and can notify "Observers" (users like Student or FacultyMember) og events.

### 2 Users added are now attached as observers
- When a student or faculty member is added, they´re also attached as observers if they implement the Observer interface.

### 3 borrowBook and returnBook now notify observers
 ```bash
notifyObservers(user.getName() + " has borrowed " + book.getTitle());
 ```

### 4 New method getAllBooks()
- Returns a formatted list of all books and their authors
-Could be useful UI or debugging

### 5 New method getAllUsers()
- Returns list of user names

## Class: FacultyMember

-   FacultyMember now implements the Observer interface
- It´s capable of being notified when book is borrowed or returned.

## Class: Main
- View books and users
- Add books and users
- Borrow and return books
- Get help
- Exit the application

## New Class: Notify
- Keeps a list of "observers"
- add (attach) observer
- remove (detatch) observer
- notifyObservers - sends a message to all observers
- The class LibrarySystem extends Notify.

## New Class: Observer
- update(String message), this method gets called when something changes
-Classes that implement Observer: Student and FacultyMember

