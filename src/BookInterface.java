import java.util.Map;

interface BookInterface {
    default String lastSixBooks() {
        return "";
    }

    static int numberOfBooksPerGenre(String genre) {
        return 0;
    }

    double getTotalCost();

}
