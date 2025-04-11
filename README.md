**_Kristin_ ksr11@hi.is** and **_Gudrun_ gma8@hi.is**
# University Library System
## The goal of this assignment is to implement the backend of a simplified university library system which would handle the lending process of books, extend lending for faculty members and more. The backend will then be used by classes implementing authenication and a user interface.
## Java and Visual Studio code app are used in this assignment



# Key Features
- Users can borrow books for an automatically set of duration (30 days)
- Only faculty members can extend the lending duration of a book
- Each book has at least one author
- The LibrarySystem class stores books and provides the necesssary features for finding, borrowing, extending, and returning books.


## [License](/hbv202gAssignment8/LICENCE)

## [POM](/hbv202gAssignment8/pom.xml)

## [Maven](/hbv202gAssignment8/src/site/markdown/maven.md)

## [Github](/hbv202gAssignment8/src/site/markdown/github.md)




# Steps to Implement



4. Boilerplate Code:
- Getters and Setters
- Constructors
- Methods from UML
- For following methods, leave the bodies empty or with simple returns
 - find()
 - borrow()
 - extend()
 - returnBook()

5. Exeption
- Some methods throw exceptions (when a book or user does not exist)
- Methods that throw exceptions should be marked with throws.
6. Aggregation
- Use List<Type> for fields that handle collection of objects
7. Library Operations
- Lending Due Date: IN the constructor for Lending, set the due date to 30 days from the current date
8. Observer (add an Observer class)


11. Design patterns (Observer)
12. Refactor
13. Jar file
14. README.md




- links to UML - markdown/uml.md or documentation?
15. Javadoc comments<span style="color: yellow;"> 3rd person</span> 

9. Once your project is complete, commit and push all changes to your GitHub repository

 ```bash
LocalDate.now().plusDays(30);
 ```

 17. describe  where a pattern is used and what classes have which role in that pattern. <span style="color: yellow;"> markdown/pattern</span> 

18. Class and method names of the submitted solution need to be **exactly** the same 
as in the UML class diagram in the assignment PDF. 


