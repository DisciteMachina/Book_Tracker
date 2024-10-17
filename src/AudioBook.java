import java.util.ArrayList;
import java.util.List;

public class AudioBook extends Book {
    private int length;
    private final String title;
    private final String author;
    private final String genre;
    private final double cost;

    public AudioBook(String title, String author, String genre, double cost, int length) {
        super(title, author, genre, cost);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
        this.length = length;
    }

    @Override
    public double getCost() {
        double COST_PER_MINUTE = 5;
        return (length * COST_PER_MINUTE);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return title;
    }

    @Override
    public String getGenre() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public double getAverageLength() {
        int totalBooks = 0;
        int totalLength = 0;
        for (Book book : books) {
            if (book instanceof AudioBook) {
                totalBooks++;
                totalLength += ((AudioBook) book).length;
            }
        }
        return totalBooks > 0 ? (double) totalLength / totalBooks : 0;
    }

    // GET LAST THREE AUDIOBOOKS
    public static List<Book> lastThreeAudioBooks() {
        List<Book> audioBooks = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof PrintedBook) {
                audioBooks.add(book);
            }
        }
        return audioBooks.subList(audioBooks.size() - 3, audioBooks.size());
    }

    @Override
    public String toString() {
        return "AUDIO, " + title + ", " + author + ", " + genre + ", " + cost;
    }
}