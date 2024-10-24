import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AudioBook extends Book {
    private final double length;
    private final String title;
    private final String author;
    private final String genre;
    private final double cost;

    public AudioBook(String title, String author, String genre, double cost, double length) {
        super(title, author, genre, cost);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
        this.length = length;
        books.add(this);
        BookManager.writeToFile(this);
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
    public String getGenre() {
        return genre;
    }

    public double getLength() {
        return length;
    }

    // GET TOTAL COST
    public static double costOfAllAudioBooks() {
        double totalCost = 0;
        for (Book book : books) {
            if (book instanceof AudioBook) {
                totalCost += book.getCost();
            }
        }
        return totalCost;
    }

    public static double getAverageLength() {
        int totalBooks = 0;
        double totalLength = 0;
        for (Book book : books) {
            if (book instanceof AudioBook) {
                totalBooks++;
                totalLength += ((AudioBook) book).length;
            }
        }
        return totalBooks > 0 ? totalLength / totalBooks : 0;
    }

    // GET LAST THREE AUDIOBOOKS
    public static String getLastThreeAudioBooks() {
        StringBuilder lastThreeAudioBooks = new StringBuilder("[Last three audiobooks]\n");
        int totalBooks = Book.books.size();
        int start = Math.max(totalBooks - 3, 0);

        for (int i = start; i < totalBooks; i++) {
            if (books.get(i) instanceof AudioBook) {
                lastThreeAudioBooks.append('\n');
                lastThreeAudioBooks.append("[");
                lastThreeAudioBooks.append(books.get(i).toString());
                lastThreeAudioBooks.append("]");
                lastThreeAudioBooks.append('\n');
            }
        }
        return lastThreeAudioBooks.toString();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "AUDIO, " + title + ", " + author + ", " + genre + ", " + df.format(cost) + ", " + length;
    }
}