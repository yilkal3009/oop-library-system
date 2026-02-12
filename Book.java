package librarymodel;

// 4. Encapsulation - Book Class
public class Book implements IBorrowable {
    private String isbn;
    private String title;
    private boolean isAvailable = true;

    // Constructor
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    // Getters
    public String getTitle() { 
        return title; 
    }

    public String getIsbn() { 
        return isbn; 
    }

    // Fixed: Standard getter for boolean (no parameters needed)
    public boolean isAvailable() { 
        return isAvailable; 
    }

    // Added: Setter for availability (needed for loadData in LibraryManager)
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public void borrowItem(String memberName) {
        if (isAvailable) {
            this.isAvailable = false;
            System.out.println(memberName + " borrowed " + title);
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    @Override
    public String returnItem() {
        this.isAvailable = true;
        return title + " has been returned.";
    }
}