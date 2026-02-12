package librarymodelservice;
import java.io.*;
import java.util.ArrayList;

public class LibraryService {
   
    private final String FILE_PATH = "library_data.txt";

    // Save data to file
    public void saveData(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(data);
            writer.newLine();
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to file: " + e.getMessage());
        }
    }

    // Read data from file
    public void readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file!");
        }
    }
}
