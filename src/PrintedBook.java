public class PrintedBook extends BookAbstract {
    protected int pages;
    final private double COST_PER_PAGE = 10.0;

    public PrintedBook(String title, String author, String genre, double cost) {
        super(title, author, genre, cost);
    }

    public double getCost() {
        return 0;
    }

    public double averagePage() {
        return 0;
    }

    public String lastThreePrintedBooks() {
        return "";
    }
}
