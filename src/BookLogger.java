import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BookLogger {

    private static final String FILE_NAME = "book_log.txt";

    public static void logBook(String bookDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(bookDetails);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}

