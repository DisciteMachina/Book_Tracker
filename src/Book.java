import java.util.List;

public abstract class Book implements BookInterface{
    public Book() {
    }

    public double getTotalCost() {
        List<Book> allBooks = BookManager.loadBooksFromFile();
        double totalCost = 0;
        for (Book book : allBooks) {
            double bookCost = book.getCost();
            totalCost += bookCost;
        }
        return totalCost;
    }

    public String numberOfBooksPerGenre() {
        return "";
    }


    public abstract void storeBookInfo(String title, String author, String genre, double cost);
    public abstract double getCost();
}