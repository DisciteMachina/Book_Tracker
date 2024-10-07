import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookApp extends BookAbstract {

    public HashMap<String, Integer> getGenreCounts() {
        return numberOfBooksPerGenre();
    }

    public double getCost() {
        return 0;
    }

    public void displayLastSixBooks() {
        List<BookDTO> lastBooks = getLastSixBooks(); // Call the default method
        for (BookDTO book : lastBooks) {
            System.out.println(book);
        }
    }

    public void displayAllBooks() {
        List<BookDTO> books = BookLogger.readBooksFromFile();
        for (BookDTO book : books) {
            System.out.println(book);
        }
    }

    public void deleteBook(String book) {
        BookLogger.deleteBook(book);
    }
}


