import java.util.HashMap;
import java.util.List;

public interface BookInterface {

    // Returns last 6 added books
    default List<BookDTO> getLastSixBooks() {
        List<BookDTO> allBooks = BookLogger.readBooksFromFile();
        int size =  allBooks.size();
        if (size <= 6) {
            return allBooks;
        }

        return allBooks.subList(size - 6, size);
    }

    HashMap<String, Integer> numberOfBooksPerGenre();
    double getTotalCost();


}
