interface BookInterface {
    default void lastSixBooks() {
        // return last six books
    }

    double numberOfBooksPerGenre();
    double getTotalCost();

}
