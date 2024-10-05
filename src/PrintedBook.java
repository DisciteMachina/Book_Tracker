import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintedBook extends BookAbstract {

    static final double COST_PER_PAGE = 10.0;
    private static final ArrayList<PrintedBook> bookList = new ArrayList<>();
    private static int totalPages;


    private final String title;
    private final String author;
    private final String genre;
    private final double cost;
    private static int pages;

    public PrintedBook(String title, String author, String genre, double cost, int pages) {
        super(title, author, genre, pages);
        this.title = title;
        this.author = author;
        this.genre = genre;
        PrintedBook.pages = pages;
        this.cost = cost;

        totalPages += pages;
        bookList.add(this);
    }

    // Getters
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

    public int getPages() {
        return pages;
    }

    // Returns cost of all printed books
    public static double totalCost() {
        return totalPages * COST_PER_PAGE;
    }

    // Returns the average amount of pages for all the printed books
    public static String averagePages() {
        DecimalFormat df = new DecimalFormat("#");

        // Avoid division by 0
        if (bookList.isEmpty()) {
            return "0.0";
        }

        double average = (double) totalPages / bookList.size();
        return df.format(average);
    }

    // Returns the last three printed books added
    public static ArrayList<String> lastThreePrintedBooks() {
        ArrayList<PrintedBook> lastThree = new ArrayList<>();
        int i = Math.max(0, bookList.size() - 3);
        for (int j = i; j < bookList.size(); j ++) {
            lastThree.add(bookList.get(j));
        }

        ArrayList<String> details = new ArrayList<>();
        for (PrintedBook book : lastThree) {
            String detail = "Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor() +
                    ", Genre: " + book.getGenre() +
                    ", Pages: " + book.getPages() +
                    ", Cost: $" + book.getCost();
            details.add(detail);
        }
        return details;
    }

    // Keeps count of types of genre
    public static void numberOfBooksPerGenre(Map<String, Integer> genreCounts) {
        for (PrintedBook book : bookList) {
            genreCounts.put(book.getGenre().toLowerCase(), genreCounts.getOrDefault(book.getGenre().toLowerCase(), 0) + 1);
        }
    }
}
