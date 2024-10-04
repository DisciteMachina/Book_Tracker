import java.text.DecimalFormat;
import java.util.ArrayList;

public class PrintedBook extends BookAbstract {
    final double COST_PER_PAGE = 10.0;

    private static final ArrayList<PrintedBook> bookList = new ArrayList<>();
    private static int totalPages;

    public PrintedBook(String title, String author, String genre, double cost, int pages) {
        super(title, author, genre, pages);
        this.cost = pages * COST_PER_PAGE;
        bookList.add(this);
        totalPages += pages;
    }

    public double getCost() {
        return cost;
    }

    public static String averagePages() {
        DecimalFormat df = new DecimalFormat("#.00");

        // Avoid division by 0
        if (bookList.isEmpty()) {
            return "0.0";
        }
        
        double average = (double) totalPages / bookList.size();
        return df.format(average);
    }

    public void lastThreePrintedBooks() {
        ArrayList<PrintedBook> lastThree = new ArrayList<>();
        int i = Math.max(0, bookList.size() - 3);
        for (int j = i; j < bookList.size(); j ++) {
            lastThree.add(bookList.get(j));
        }
        getDetails(lastThree);
    }

    private void getDetails(ArrayList<PrintedBook> lastThree) {
        String details = "Title: " + title;
    }

}
