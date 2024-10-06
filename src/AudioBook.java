import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class AudioBook extends BookAbstract {

    protected static double COST_PER_MINUTE = 5.0;
    private static ArrayList<AudioBook> bookList = new ArrayList<AudioBook>();
    private static double totalLength;

    private final String title;
    private final String author;
    private final String genre;
    private final double cost;
    private final double length;


    public AudioBook(String title, String author, String genre, double cost, double length) {
        super(title, author, genre, length);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.length = length;
        this.cost = cost;

        totalLength += length;
        bookList.add(this);

        BookLogger.writeBookToFile(title + ", " + author + ", " + genre + ", " + length + ", " + cost);
    }

    public double getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public double getLength() {
        return length;
    }

    // Returns cost of all audiobooks
    public static double totalCost() {
        return totalLength * COST_PER_MINUTE;
    }

    public static String averageLength() {
        DecimalFormat df = new DecimalFormat("#.00");

        // Avoid division by 0
        if (bookList.isEmpty()) {
            return "0.0";
        }

        double average = totalLength / bookList.size();
        return df.format(average);
    }

    // Returns the last three audiobooks added
    public static ArrayList<String> lastThreeAudioBooks() {
        System.out.println();
        System.out.println("AUDIOBOOKS");
        ArrayList<AudioBook> lastThree = new ArrayList<>();

        int i = Math.max(0, bookList.size() - 3);
        for (int j = i; j < bookList.size(); j ++) {
            lastThree.add(bookList.get(j));
        }

        ArrayList<String> details = new ArrayList<>();
        for (AudioBook book : lastThree) {
            String detail = "[Title]: " + book.getTitle() +
                    ", [Author]: " + book.getAuthor() +
                    ", [Genre]: " + book.getGenre() +
                    ", [Length]: " + book.getLength() +
                    ", [Cost]: $" + book.getCost();
            details.add(detail);
        }
        return details;
    }

    public static ArrayList<String> allAudioBooks() {
        ArrayList<String> detailedBooks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String detail = "[Title]: " + parts[0].trim() + "\n" +
                            ", [Author]: " + parts[1].trim() + "\n" +
                            ", [Genre]: " + parts[2].trim() + "\n" +
                            ", [Length]: " + parts[3].trim() + "\n" +
                            ", [Cost]: $" + parts[4].trim() + "\n";
                    detailedBooks.add(detail);
                } else {
                    System.out.println("Invalid book entry format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return detailedBooks;
    }
}
