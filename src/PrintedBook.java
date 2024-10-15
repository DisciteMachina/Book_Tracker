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
        totalPages = 0;
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
        return (this.pages * COST_PER_PAGE);
    }

    public String getTitle() {
        return this.title;
    }

    public void writeFile(String title, String author, String genre, double cost, double pages) {
        BookManager bookManager = new BookManager();
        String book = String.join(",", "PRINTED", title, author, genre, String.valueOf(cost), String.valueOf(pages));
        bookManager.writeToFile(book);
    }

    public static int averagePages() {
        List<String> books = BookManager.readBooksFromFile(); // All the books
        int count = books.size();

        if (count == 0) {
            return 0;
        }

        double totalPages = getTotalPages();
        double average = totalPages / count;
        return (int) average;
    }

    public static String lastThreePrintedBooks() {
        BookManager bookManager = new BookManager();
        List<String> printedBooks = bookManager.getPrintedBooks();

        if (printedBooks.size() < 3) {
            return "Not enough printed books available.";
        }

        // Get the last three books
        List<String> lastThreeBooks = printedBooks.subList(printedBooks.size() - 3, printedBooks.size());

        StringBuilder sb = new StringBuilder();
        sb.append("[The last three printed books are]:\n");
        sb.append("---------------------------------\n");

        for (String loggedBook : lastThreeBooks) {
            String[] parts = loggedBook.split(",");
            sb.append("[Title]: ").append(parts[1].trim()).append("\n")
                    .append("[Author]: ").append(parts[2].trim()).append("\n")
                    .append("[Genre]: ").append(parts[3].trim()).append("\n")
                    .append("[Cost]: $").append(parts[4].trim()).append("\n")
                    .append("[Pages]: ").append(parts[5].trim()).append("\n")
                    .append("---------------------------------\n");
        }

        return sb.toString();
    }

    public static String allPrintedBooks() {
        BookManager bookManager = new BookManager();
        List<String> printedBooks = bookManager.getPrintedBooks();

        StringBuilder sb = new StringBuilder();
        sb.append("[All printed books]:\n");
        sb.append("---------------------------------\n");

        for (String loggedBook : printedBooks) {
            String[] parts = loggedBook.split(",");
            sb.append("[Title]: ").append(parts[1].trim()).append("\n")
                    .append("[Author]: ").append(parts[2].trim()).append("\n")
                    .append("[Genre]: ").append(parts[3].trim()).append("\n")
                    .append("[Cost]: $").append(parts[4].trim()).append("\n")
                    .append("[Pages]: ").append(parts[5].trim()).append("\n")
                    .append("---------------------------------\n");
        }

        return sb.toString();
    }

    public int numberOfBooksPerGenre(String genre) {
        return 0;
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