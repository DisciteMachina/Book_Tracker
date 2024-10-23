import java.util.ArrayList;
import java.util.List;

public abstract class Book implements BookInterface{
    private final String title;
    private final String author;
    private final String genre;
    private final double cost;

    protected static List<Book> books = new ArrayList<>();
    public Book(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    public abstract double getCost();
    public abstract String getTitle();
    public abstract String getAuthor();
    public abstract String getGenre();


    @Override
    public double getTotalCost() {
        double totalCost = 0;
        for (Book book : books) {
            totalCost += book.getCost();
        }
        return totalCost;
    }

    @Override
    public void displayLastSixBooks() {
        System.out.println("Last six books:");
        for (int i = Math.max(0, books.size() - 6); i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

    @Override
    public int getNumberOfBooksByGenre() {
        return 0;
    }
}