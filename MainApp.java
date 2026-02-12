package librarymodelservice;

import librarymodel.Book;
import librarymodel.Manager;
import librarymodel.Librarian;
import librarymodel.Student;
import librarymodel.LibrarySystem;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
         System.out.println("====================================");
        System.out.println("   LIBRARY MANAGEMENT SYSTEM   ");
        System.out.println("====================================");
        // Initializing the system manager
        Manager mainMgr = new Manager("1800736", "Yilkal");
        mainMgr.performRole();
        
        // List to store librarians added via Scanner
        ArrayList<Librarian> librarians = new ArrayList<>();
        
        LibrarySystem library = new LibrarySystem();
        LibraryService service = new LibraryService();

        // Load data at startup
        try {
            library.loadData();
        } catch (Exception e) {
  System.out.println("Notice: Could not load previous data. Starting fresh.");
        }
        boolean running = true;
        while (running) {
            try {
                System.out.println("\nMAIN MENU:");
                System.out.println("1. Add a New Book");
                System.out.println("2. List All Books");
                System.out.println("3. Search by Title");
                System.out.println("4. Search by ISBN");
                System.out.println("5. Record borrow books");
                System.out.println("6. List Borrowed Records");
                System.out.println("7. Register New Librarian");
                System.out.println("8. List All Librarians");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                String inputLine = input.nextLine();
                int choice = Integer.parseInt(inputLine);

        switch (choice) {
                case 1:
       System.out.print("Enter ISBN: ");
     String isbn = input.nextLine();
     System.out.print("Enter Title: ");
      String title = input.nextLine();
     library.addBook(new Book(isbn, title));
   service.saveData("Action: Added Book | ISBN: " + isbn + " | Title: " + title);
    System.out.println("Book added successfully!");
               break;
         case 2:
        library.listBooks();
               break;
       case 3:
    System.out.print("Enter Title to search: ");
    String sTitle = input.nextLine();
    library.searchByTitle(sTitle);
             break; // Added missing break
           case 4:
  System.out.print("Enter ISBN to search: ");
    String sIsbn = input.nextLine();
library.searchByIsbn(sIsbn);
             break;
         case 5:
  System.out.print("Enter Student ID: ");
       String sid = input.nextLine();
   System.out.print("Enter Student Name: ");
      String sname = input.nextLine();
 Student activeStudent = new Student(sid, sname);
       activeStudent.performRole();
System.out.print("Enter Book Title to borrow: ");
      String bookToBorrow = input.nextLine();
library.borrowBook(bookToBorrow, activeStudent.getName());
           break;
         case 6:
   library.listRecords();
          break;
         case 7:
  System.out.println("--- Register a New Librarian ---");
   System.out.print("Enter Librarian ID: ");
    String libId = input.nextLine();
      System.out.print("Enter Librarian Name: ");
       String libName = input.nextLine();
    // Use the correct list name "librarians"
   Librarian newLib = new Librarian(libId, libName);
     librarians.add(newLib);
System.out.println("Librarian " + libName + " registered successfully!");
           break;
          case 8:
  System.out.println("\n--- Current Librarian List ---");
          if (librarians.isEmpty()) {
 System.out.println("No librarians registered yet.");
         }
         else {
           for (Librarian lib : librarians) {
       System.out.println(lib.toString());
            lib.performRole();
                            }
                        }
              break;
          case 0:
       System.out.println("Saving and Exiting...");
          running = false;
           break;

       default:
  System.out.println("Error: Choice must be between 0 and 8.");
           break;
                }}
     catch (NumberFormatException e) {
    System.out.println("INVALID INPUT: Please enter a number (0-8).");
         } 
    catch (Exception e) {
   System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        input.close();
    }
}