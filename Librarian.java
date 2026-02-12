package librarymodel;

// Librarian class inheriting from User (Inheritance)
public class Librarian extends User {
    
    // Constructor for Librarian
     //Uses super() to pass id and name to the parent User class
     
    public Librarian(String id, String name) {
        super(id, name);
    }

    // Overriding the abstract method from User class
    
    @Override
    public void performRole() {
        System.out.println("Role: Librarian (Manages books and users)");
    }

    /**
     * Overriding toString() to provide a readable string 
     * representation of the Librarian object
     */
    @Override
    public String toString() {
        return "Librarian ID: " + id + ", Name: " + name;
    }
}