import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class BookLogger {
    private static final String FILE_NAME = "book_log.txt";

    public static void writeBookToFile(String bookDetails) {
        if (checkLogged(bookDetails)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(bookDetails);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Book already logged: " + bookDetails);
            System.out.println();
        }
    }

    public static boolean checkLogged(String bookDetails) {
        String title = bookDetails.split(",")[1].trim(); // Get the title (the first part)

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String loggedTitle = line.split(",")[0].trim();
                if (loggedTitle.equalsIgnoreCase(title)) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static List<BookDTO> readBooksFromFile() {
        List<BookDTO> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                BookDTO book = createBookFromLine(line);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    // Method to create a BookDTO from a line in the file
    private static BookDTO createBookFromLine(String line) {
        String[] parts = line.split(",");

        String type = parts[0].trim(); // Should be "PRINTED" or "AUDIO"
        String title = parts[1].trim();
        String author = parts[2].trim();
        String genre = parts[3].trim();

        // Check the type and appropriately assign pages or length
        int pages = 0;
        double length = 0.0;
        double cost;

        if (type.equalsIgnoreCase("PRINTED")) {
            pages = Integer.parseInt(parts[4].trim()); // Pages for printed books
            cost = Double.parseDouble(parts[5].trim()); // Cost is the next value
            return new BookDTO(type, title, author, genre, cost, pages);
        } else if (type.equalsIgnoreCase("AUDIO")) {
            length = Double.parseDouble(parts[4].trim()); // Length for audio books
            cost = Double.parseDouble(parts[5].trim()); // Cost is the next value
            return new BookDTO(type, title, author, genre, cost, length);

        } else {
            throw new IllegalArgumentException("Invalid book type: " + type);
        }
    }
}

