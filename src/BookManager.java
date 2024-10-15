import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static final String FILE_NAME = "book_log.txt";
    private final List<String> cachedBooks;

    public BookManager() {
        ensureFileExists();
        this.cachedBooks = readBooksFromFile();
    }

    private static void ensureFileExists() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile(); // Create the file if it doesn't exist
            } catch (IOException e) {
                throw new RuntimeException("Error while creating the file", e);
            }
        }
    }

    public void writeToFile(String book) {
        if (!checkIfLogged(book)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(book);
                writer.newLine();
                cachedBooks.add(book);
            } catch (IOException e) {
                throw new RuntimeException("Error while writing the file", e);
            }
        }

    }

    public boolean checkIfLogged(String book) {
        String[] bookParts = book.split(",");

        if (bookParts.length < 2) {
            throw new IllegalArgumentException("Invalid book format: " + book);
        }

        String title = bookParts[1];

        for (String loggedBook : cachedBooks) {
            String loggedTitle = loggedBook.split(",")[1].trim();
            if (loggedTitle.equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> readBooksFromFile() {
        List<String> books = new ArrayList<>();
        ensureFileExists();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public List<Book> loadBooksFromFile() {
        List<Book> bookList = new ArrayList<>();

        for (String book : cachedBooks) {
            String[] loggedBook = book.split(",");
            if (loggedBook.length < 6) continue;

            String type = loggedBook[0].trim();
            String title = loggedBook[1].trim();
            String author = loggedBook[2].trim();
            String genre = loggedBook[3].trim();
            double cost = Double.parseDouble(loggedBook[4].trim());

            if (type.equalsIgnoreCase("PRINTED")) {
                double pages = Double.parseDouble(loggedBook[5]);
                bookList.add(new PrintedBook(title, author, genre, cost, pages));
            } else if (type.equalsIgnoreCase("AUDIO")) {
                double length = Double.parseDouble(loggedBook[5]);
                bookList.add(new AudioBook(title, author, genre, cost, length));
            }
        }
        return bookList;
    }

    public List<String> getBooksByType(String type) {
        List<String> matchedBooks = new ArrayList<>();
        for (String loggedBook : cachedBooks) {
            if (loggedBook.startsWith(type.toUpperCase() + ",")) {
                matchedBooks.add(loggedBook);
            }
        }
        return matchedBooks;
    }

    public List<String> getPrintedBooks() {
        return getBooksByType("PRINTED");
    }

    public List<String> getAudioBooks() {
        return getBooksByType("AUDIO");
    }

}