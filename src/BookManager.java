import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    static String FILE_NAME = "book_log.txt";

    public void writeToFile(String book) {
        if (!checkIfLogged(book)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(book);
                writer.newLine();
            } catch (IOException e) {
                throw new RuntimeException("Error while writing the file", e);
            }
        }

    }

    public boolean checkIfLogged(String book) {
        List<String> books = readBooksFromFile();
        String[] bookParts = book.split(",");

        if (bookParts.length < 2) {
            throw new IllegalArgumentException("Invalid book format: " + book);
        }

        String title = bookParts[1];

        for (String loggedBook : books) {

            String loggedTitle = loggedBook.split(",")[1].trim();
            if (loggedTitle.equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> readBooksFromFile() {
        List<String> books = new ArrayList<>();
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

    public static List<Book> loadBooksFromFile() {
        List<String> books = readBooksFromFile();
        List<Book> bookList = new ArrayList<>();

        for (String book : books) {
            String[] loggedBook = book.split(",");
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

    public List<String> getPrintedBooks() {
        List<String> books = readBooksFromFile();
        List<String> printedBooks = new ArrayList<>();

        for (String loggedBook : books) {
            String type = loggedBook.split(",")[0].trim();
            if (type.equalsIgnoreCase("PRINTED")) {
                printedBooks.add(loggedBook);
            }
        }
        return printedBooks;
    }

    public List<String> getAudioBooks() {
        List<String> books = readBooksFromFile();
        List<String> audioBooks = new ArrayList<>();

        for (String loggedBook : books) {
            String type = loggedBook.split(",")[0].trim();
            if (type.equalsIgnoreCase("AUDIO")) {
                audioBooks.add(loggedBook);
            }
        }
        return audioBooks;
    }
}