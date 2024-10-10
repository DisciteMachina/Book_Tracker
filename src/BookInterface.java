public interface BookInterface {

    default String lastSixBooks() {
        return null;
    }

    String numberOfBooksPerGenre();
    double getTotalCost();
}

