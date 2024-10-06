import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 5);
                genreCounts.put(parts[2].toLowerCase(), genreCounts.getOrDefault(parts[2].toLowerCase(), 0) + 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
