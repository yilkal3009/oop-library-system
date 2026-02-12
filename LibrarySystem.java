package librarymodel;

import java.util.ArrayList;
import java.io.*;
public class LibrarySystem {
    // Inside LibraryManager class
private ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();
 private ArrayList<Book> bookList = new ArrayList<>();
 private final String DATA_FILE = "library_data.txt";
public void borrowBook(String bookTitle, String studentName) {
    // Create a new record
    BorrowRecord record = new BorrowRecord(bookTitle, studentName);
    borrowRecords.add(record);
    
    // Optional: Print confirmation
    System.out.println("Record Created: " + studentName + " borrowed " + bookTitle + " on " + record.date);
}
public void listRecords() {
    System.out.println("\n--- Borrowing History ---");
    for (BorrowRecord r : borrowRecords) {
        System.out.println("Student: " + r.uName + " | Book: " + r.bName + " | Date: " + r.date);
    }
}

    // Adds a book to the list and automatically updates the text file
    public void addBook(Book b) {
        bookList.add(b);
        saveToFile();
    }

    // Displays all books currently in the library list
    public void listBooks() {
        System.out.println("\n--- Library Inventory ---");
        if (bookList.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }
        for (Book b : bookList) {
            String status = b.isAvailable() ? "Available" : "Borrowed";
            System.out.println(b.getIsbn() + " | " + b.getTitle() + " | " + status);
        }
    }

    // Saves the current bookList to library_data.txt
    public void saveToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Book b : bookList) {
                out.println(b.getIsbn() + "," + b.getTitle() + "," + b.isAvailable());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // Loads books from the text file back into the bookList ArrayList
    public void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;

        bookList.clear(); // Clear list to prevent duplicates when reloading
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    Book b = new Book(parts[0], parts[1]);
                    if (parts.length >= 3) {
                        b.setAvailable(Boolean.parseBoolean(parts[2]));
                    }
                    bookList.add(b);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Searches for a book by its Title (Case-Insensitive)
    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("\n--- Searching for Title: " + title + " ---");
        for (Book b : bookList) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Match Found: " + b.getIsbn() + " | " + b.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Result: No book found with that title.");
        }
    }

    // Searches for a book by its unique ISBN number
    public void searchByIsbn(String isbn) {
        System.out.println("\n--- Searching for ISBN: " + isbn + " ---");
        for (Book b : bookList) {
            if (b.getIsbn().equals(isbn)) {
                System.out.println("Match Found: " + b.getIsbn() + " - " + b.getTitle());
                return; // Stop searching once found
            }
        }
        System.out.println("Result: No book found with ISBN " + isbn);
    }
}