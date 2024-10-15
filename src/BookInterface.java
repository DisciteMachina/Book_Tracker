import java.util.HashMap;

public interface BookInterface {

    default void lastSixBooks() {
    }

    HashMap<String, Integer> numberOfBooksPerGenre();

    double getTotalCost();
}