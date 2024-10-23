public class PrintedBook extends Book {
    private final int pages;
    private final String title;
    private final String author;
    private final String genre;
    private final double cost;

    public PrintedBook(String title, String author, String genre, double cost, int pages) {
        super(title, author, genre, cost);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
        this.pages = pages;
        books.add(this);
        BookManager.writeToFile(this);
    }

    @Override
    public double getCost() {
        int COST_PER_PAGE = 10;
        return (pages * COST_PER_PAGE);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return title;
    }

    @Override
    public String getGenre() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    // GET TOTAL COST
    public double costOfAllPrintedBooks() {
        double totalCost = 0;
        for (Book book : books) {
            if (book instanceof PrintedBook) {
                totalCost += book.getCost();
                System.out.println(book);
            }
        }
        return totalCost;
    }

    // GET AVERAGE PAGES
    public static double getAveragePages() {
        int totalBooks = 0;
        int totalPages = 0;
        // For each book in list books
        for (Book book : books) {
            // if book is a PrintedBook
            if (book instanceof PrintedBook) {
                totalBooks++;
                totalPages += ((PrintedBook) book).pages;
            }
        }
        // If totalBooks > 0 (true) -> totalPages / totalBooks else (false) -> 0
        return totalBooks > 0 ? (double) totalPages / totalBooks : 0;
    }

    // GET LAST THREE PRINTED BOOKS
    public static String getLastThreePrintedBooks() {
        StringBuilder lastThreePrintedBooks = new StringBuilder("[Last three printed books]\n");
        int totalBooks = Book.books.size();
        int start = Math.max(totalBooks - 3, 0);

        for (int i = start; i < totalBooks; i++) {
            if (books.get(i) instanceof PrintedBook) {
                lastThreePrintedBooks.append('\n');
                lastThreePrintedBooks.append("[");
                lastThreePrintedBooks.append(books.get(i).toString());
                lastThreePrintedBooks.append("]");
                lastThreePrintedBooks.append('\n');
            }
        }
        return lastThreePrintedBooks.toString();
    }

    @Override
    public String toString() {
        return "PRINTED, " + title + ", " + author + ", " + genre + ", " + cost + ", " + pages;
    }

}
