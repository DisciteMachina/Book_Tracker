import java.util.HashMap;
import java.util.List;

public interface BookInterface {

    default void lastSixBooks() {
    }

    int numberOfBooksPerGenre(String genre);

    double getTotalCost();
}