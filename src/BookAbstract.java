import java.util.HashMap;
import java.util.Map;

abstract class BookAbstract implements BookInterface {
    protected String title;
    protected String author;
    protected String genre;
    protected double cost;

    public BookAbstract(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    public static void numberOfBooksPerGenre() {
        Map<String, Integer> genreCounts = new HashMap<>();

        PrintedBook.numberOfBooksPerGenre(genreCounts);
        AudioBook.numberOfBooksPerGenre(genreCounts);

        for (Map.Entry<String, Integer> entry : genreCounts.entrySet()) {
            System.out.println("Genre: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }

    public double getTotalCost() {
        return PrintedBook.totalCost() + AudioBook.totalCost();
    }

    public abstract double getCost();
    public abstract String getTitle();
    public abstract String getAuthor();
    public abstract String getGenre();



}
