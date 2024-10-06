import java.util.ArrayList;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintedBook extends BookAbstract {
    static final double COST_PER_PAGE = 10.0;
    private static ArrayList<PrintedBook> bookList = new ArrayList<>();

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
        this.cost = cost;
        PrintedBook.pages = pages;

        totalPages += pages;
        bookList.add(this);

        BookLogger.writeBookToFile(title + ", " + author + ", " + genre + ", " + pages + ", " + cost);

    }

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

    public static double totalCost() {
        int totalPages = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
                String[] parts = line.split(",", 5);
                System.out.println("Parts count: " + parts.length);
                if (parts.length >= 4) { // Removing this completely breaks it. I have no idea why
                    int page = Integer.parseInt(parts[3].trim());
                    totalPages += page;
                } else {
                    System.out.println("Malformed line: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalPages * COST_PER_PAGE;
    }


    public static int averagePages() {
        int amountOfBooks = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 5);
                int page = Integer.parseInt(parts[3].trim());
                totalPages += page;
                amountOfBooks ++;
            }

        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return totalPages / amountOfBooks;
    }

    public static ArrayList<String> lastThreePrintedBooks() {
        System.out.println();
        System.out.println("PRINTED BOOKS");
        ArrayList<String> lastThree = new ArrayList<>();
        ArrayList<String> bookList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                lastThree.add(line);
            }
            int i = Math.max(0, lastThree.size() - 3);
            for (int j = i; j < lastThree.size(); j ++) {
                String[] parts = lastThree.get(j).split(",", 5);
                if (parts.length == 5) {
                    String detail = "[Title]: " + parts[0].trim() + "\n" +
                            "[Author]: " + parts[1].trim() + "\n" +
                            "[Genre]: " + parts[2].trim() + "\n" +
                            "[Pages]: " + parts[3].trim() + "\n" +
                            "[Cost]: $" + parts[4].trim() + "\n";
                    bookList.add(detail);
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return bookList;
    }

    public static ArrayList<String> allPrintedBooks() {
        System.out.println();
        System.out.println("PRINTED BOOKS");
        ArrayList<String> bookList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 5);
                if (parts.length == 5) {
                    String detail = "[Title]: " + parts[0].trim() + "\n" +
                            "[Author]: " + parts[1].trim() + "\n" +
                            "[Genre]: " + parts[2].trim() + "\n" +
                            "[Pages]: " + parts[3].trim() + "\n" +
                            "[Cost]: $" + parts[4].trim() + "\n";
                    bookList.add(detail);
                } else {
                    System.out.println("Invalid book entry format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return bookList;
    }

   /* public static void numberOfBooksPerGenre(Map<String, Integer> genreCounts) {

        for (PrintedBook book : bookList) {
            genreCounts.put(book.getGenre().toLowerCase(), genreCounts.getOrDefault(book.getGenre().toLowerCase(), 0) + 1);
        }
    }

    */
}
