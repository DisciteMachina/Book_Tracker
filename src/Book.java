import java.util.HashMap;
import java.util.List;

public abstract class Book implements BookInterface{
    private static List<Book> allBooks = new BookManager().loadBooksFromFile();

    public abstract void storeBookInfo(String title, String author, String genre, double cost);

    @Override
    public double getTotalCost() {
        double totalCost = 0;
        for (Book book : allBooks) {
            double bookCost = book.getCost();
            totalCost += bookCost;
        }
        return totalCost;
    }

    public HashMap<String, Integer> numberOfBooksPerGenre() {
        HashMap<String, Integer> totalGenreCountMap = new HashMap<>();

        totalGenreCountMap.putAll(getPrintedBookGenres());
        totalGenreCountMap.putAll(getAudioBookGenres());

        return totalGenreCountMap;
    }

    private HashMap<String, Integer> getPrintedBookGenres() {
        PrintedBook printedBook = new PrintedBook("", "", "", 0, 0);
        return printedBook.numberOfBooksPerGenre();
    }

    private HashMap<String, Integer> getAudioBookGenres() {
        AudioBook audioBook = new AudioBook("", "", "", 0, 0);
        return audioBook.numberOfBooksPerGenre();
    }

    public abstract double getCost();
    public abstract String getTitle();
}