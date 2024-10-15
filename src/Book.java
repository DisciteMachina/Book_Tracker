import java.util.HashMap;
import java.util.List;

public abstract class Book implements BookInterface{
    private final String title;
    private final String author;
    private final String genre;
    private final double cost;

    public Book(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    public abstract void storeBookInfo(String title, String author, String genre, double cost);

    @Override
    public abstract String getTitle();

    @Override
    public abstract String getAuthor();

    @Override
    public abstract String getGenre();

    @Override
    public abstract double getCost();

    public double getTotalCost() {
        List<Book> allBooks = BookManager.loadBooksFromFile();
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
}