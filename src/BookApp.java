import java.util.HashMap;

public class BookApp extends BookAbstract {
    public static void main(String[] args) {
        BookApp app = new BookApp();
        HashMap<String, Integer> genreCounts = app.numberOfBooksPerGenre();

        for (String genre : genreCounts.keySet()) {
            System.out.println(genre + ": " + genreCounts.get(genre));
        }
    }

    @Override
    public double getCost() {
        return 0;
    }
}

