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
                throw new RuntimeException(e);
            }
        } else {
            // This removes the PRINTED/AUDIO from the line
            int commaIndex = bookDetails.indexOf(",");
            System.out.println("Book already logged: " + bookDetails.substring(commaIndex + 1));
            System.out.println();
        }
    }

    // Helper method to check if a book is logged in the txt file before adding
    public static boolean checkLogged(String bookDetails) {
        List<BookDTO> books = readBooksFromFile();
        String title = bookDetails.split(",")[1].trim(); // Get the title (the first part)

        for (BookDTO book : books) {
            if (book.getTitle().equals(title)) {
                return false;
            }
        }
        return true;
    }

    // Read all books from txt file and add them to the books list
    public static List<BookDTO> readBooksFromFile() {
        List<BookDTO> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                BookDTO book = createBookFromLine(line);
                books.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return books;
    }

    // Add books from txt file to a list for easy manipulation.
    public static BookDTO createBookFromLine(String line) {
        String[] parts = line.split(",");

        String type = parts[0].trim(); // Should be "PRINTED" or "AUDIO"
        String title = parts[1].trim();
        String author = parts[2].trim();
        String genre = parts[3].trim();

        // Check the type and appropriately assign pages or length
        int pages;
        double length;
        double cost;

        if (type.equalsIgnoreCase("PRINTED")) {
            pages = Integer.parseInt(parts[4].trim());
            cost = Double.parseDouble(parts[5].trim());
            return new BookDTO(type, title, author, genre, cost, pages);
        } else if (type.equalsIgnoreCase("AUDIO")) {
            length = Double.parseDouble(parts[4].trim());
            cost = Double.parseDouble(parts[5].trim());
            return new BookDTO(type, title, author, genre, cost, length);

        } else {
            throw new IllegalArgumentException("Invalid book type: " + type);
        }
    }

    // Method to delete book
    public static void deleteBook(String book) {
        List<String> linesToKeep = new ArrayList<>();

        System.out.println(book);
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!book.trim().toLowerCase().equals(parts[1].toLowerCase().trim())) {
                    linesToKeep.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String remainingLine : linesToKeep) {
                writer.write(remainingLine);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Book " + book.toUpperCase() + " deleted successfully.");
    }
}

