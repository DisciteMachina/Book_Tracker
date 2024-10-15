import java.util.List;

public abstract class Book implements BookInterface{
    private static List<Book> allBooks = new BookManager().loadBooksFromFile();

    public abstract void storeBookInfo(String title, String author, String genre, double cost);

    @Override
    public double getTotalCost() {
        double totalCost = 0;
        for (Book book : allBooks) {
            double bookCost = book.getCost();
            totalCost += bookCost;
        }
        return totalCost;
    }

    public abstract double getCost();
}