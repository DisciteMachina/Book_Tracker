import java.util.HashMap;
import java.util.List;

public interface BookInterface {

    default void displayLastSixBooks(List<Book> books) {
        int count = Math.min(6, books.size());
        for (int i = books.size() - count; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }


    HashMap<String, Integer> numberOfBooksPerGenre();

    String getTitle();
    String getAuthor();
    String getGenre();
    double getCost();

    double getTotalCost();
}