interface BookInterface {
    default String lastSixBooks() {
        return "";
    }

    double numberOfBooksPerGenre();
    double getTotalCost();

}
