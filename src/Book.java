import java.util.ArrayList;
import java.util.List;

public abstract class Book implements BookInterface{
    private static List<Book> allBooks = new ArrayList<>();

    public Book() {
        allBooks.add(this);
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Book book : allBooks) {
            totalCost += book.getCost();
        }
        return totalCost;
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public String numberOfBooksPerGenre() {
        return "";
    }


    public abstract void storeBookInfo(String title, String author, String genre, double cost);
    public abstract double getCost();
}