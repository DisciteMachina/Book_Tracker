import java.util.HashMap;

abstract class BookAbstract implements BookInterface {

    // returns the number of books per genre
    public HashMap<String, Integer> numberOfBooksPerGenre() {
        HashMap<String, Integer> printedGenreCount = PrintedBook.printedGenreCount();
        HashMap<String, Integer> audioGenreCount = AudioBook.audioGenreCount();
        HashMap<String, Integer> combinedGenreCount = new HashMap<>();

            for (String genre : printedGenreCount.keySet()) {
            combinedGenreCount.put(genre, printedGenreCount.get(genre));
            }

            for (String genre : audioGenreCount.keySet()) {
            combinedGenreCount.put(genre, combinedGenreCount.getOrDefault(genre, 0) + audioGenreCount.get(genre));
            }

            return combinedGenreCount;
    }

    public double getTotalCost() {
        return PrintedBook.totalCost() + AudioBook.totalCost();
    }

    public abstract double getCost();
}
