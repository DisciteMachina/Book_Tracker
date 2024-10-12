import java.util.List;

public class PrintedBook extends Book {
    private String title;
    private String author;
    private String genre;
    private double cost;
    private double pages;

    private static double totalPages;

    public PrintedBook(String title, String author, String genre, double cost, double pages) {
        super();
        storeBookInfo(title, author, genre, cost);
        setPages(pages);

    }

    public void storeBookInfo(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    // Setter for pages
    public void setPages(double pages) {
        this.pages = pages;
        writeFile(title, author, genre, cost, pages);
    }

    public static double getTotalPages() {
        BookManager bookManager = new BookManager();
        List<String> books = bookManager.getPrintedBooks();

        for (String loggedBook : books) {
            double bookPages = Double.parseDouble(loggedBook.split(",")[5].trim());
            totalPages += bookPages;
        }
        return totalPages;
    }

    @Override
    public double getCost() {
        double COST_PER_PAGE = 10;
        System.out.println("The cost of " + getTitle() + "is " + pages * COST_PER_PAGE);
        return (pages * COST_PER_PAGE);
    }

    public String getTitle() {
        return title;
    }

    public void writeFile(String title, String author, String genre, double cost, double pages) {
        BookManager bookManager = new BookManager();
        String book = String.join(",", "PRINTED", title, author, genre, String.valueOf(cost), String.valueOf(pages));
        bookManager.writeToFile(book);
    }

    public static double averagePages() {
        List<String> books = BookManager.readBooksFromFile(); // All the books
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            count ++;
        }
        return (getTotalPages() / count);
    }

    public static void lastThreePrintedBooks() {
        BookManager bookManager = new BookManager();
        List<String> printedBooks = bookManager.getPrintedBooks();

        // Get the last three books with subList(size of array - 3, size of array)
        List<String> lastThreeBooks = printedBooks.subList(printedBooks.size() -3, printedBooks.size());
        System.out.println("---------------------------------");
        System.out.println("[The last three printed books are]: ");
        for (String loggedBook : lastThreeBooks) {
            String[] parts = loggedBook.split(",");
            String detail = "[Title]: " + parts[1].trim() + "\n" +
                    "[Author]: " + parts[2].trim() + "\n" +
                    "[Genre]: " + parts[3].trim() + "\n" +
                    "[Pages]: " + parts[4].trim() + "\n" +
                    "[Cost]: $" + parts[5].trim() + "\n";
            System.out.println("---------------------------------");
            System.out.println(detail);
        }
    }

    @Override
    public String toString() {
        return "[PRINTED BOOK]" + '\n' +
                "[title]: " + title + '\n' +
                "[author]: " + author + '\n' +
                "[genre]: " + genre + '\n' +
                "[cost]: $" + cost + '\n' +
                "[pages]: " + pages + '\n';
    }
}