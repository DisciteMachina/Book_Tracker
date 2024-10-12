import java.util.ArrayList;
import java.util.List;

public class AudioBook extends Book {
    private String title;
    private String author;
    private String genre;
    private double cost;
    private double length;

    private int totalLength;

    public AudioBook(String title, String author, String genre, double cost, double length) {
        super();
        storeBookInfo(title, author, genre, cost);
        setLength(length);
    }

    public void storeBookInfo(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    // Setter for length
    public void setLength(double length) {
        this.length = length;
        writeFile(title, author, genre, cost, length);

    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public double getCost() {
        double COST_PER_MINUTE = 5;
        System.out.println("The cost of " + getTitle() + "is " + length * COST_PER_MINUTE);
        return length * COST_PER_MINUTE;
    }

    public String getTitle() {
        return title;
    }

    public double getLength() {
        return length;
    }

    public void writeFile(String title, String author, String genre, double cost, double length) {
        BookManager bookManager = new BookManager();
        String book = String.join(",", "AUDIO", title, author, genre, String.valueOf(cost), String.valueOf(length));
        bookManager.writeToFile(book);
    }

    public String averagePages() {
        return null;
    }

    public String lastThreePrintedBooks() {
        return null;
    }

    @Override
    public String toString() {
        return "[PRINTED BOOK]" + '\n' +
                "[title]: " + title + '\n' +
                "[author]: " + author + '\n' +
                "[genre]: " + genre + '\n' +
                "[cost]: $" + cost + '\n' +
                "[length]: " + length + '\n';
    }
}