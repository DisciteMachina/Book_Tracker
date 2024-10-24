import java.util.HashMap;
public abstract class Book implements BookInterface{
    protected String title;
    protected String author;
    protected String genre;
    protected double cost;


    public Book(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    public abstract double getCost();
    public abstract String getTitle();
    public abstract String getGenre();

    public static double getTotalCost() {
        double totalCost = 0;
        for (Book book : books) {
            totalCost += book.getCost();
        }
        return totalCost;
    }

    public static HashMap<String, Integer> getNumberOfBooksByGenre() {
        HashMap<String, Integer> genreCount = new HashMap<>();
        for (Book book : books) {
            genreCount.put(book.getGenre(), genreCount.getOrDefault(book.getGenre(), 0) + 1);
        }
        return genreCount;
    }
}