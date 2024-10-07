import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PrintedBook extends BookAbstract {
    static final double COST_PER_PAGE = 10.0;

    private final String title;
    private final String author;
    private final String genre;
    private final double cost;
    private final int pages;


    public PrintedBook(String title, String author, String genre, double cost, int pages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
        this.pages = pages;

        BookLogger.writeBookToFile("PRINTED," + title + ", " + author + ", " + genre + ", " + pages + ", " + cost + "\n");
    }

    public double getCost() {
        return cost;
    }

    public static double totalCost() {
        int totalPages = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
                String[] parts = line.split(",", 6);
                System.out.println("Parts count: " + parts.length);
                if (parts.length >= 4) {
                    int page = Integer.parseInt(parts[3].trim());
                    totalPages += page;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalPages * COST_PER_PAGE;
    }


    public static int averagePages() {
        int amountOfBooks = 0;
        int totalPages = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int page = Integer.parseInt(parts[4].trim());
                totalPages += page;
                amountOfBooks ++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                String[] parts = lastThree.get(j).split(",");
                if (parts.length == 6) {
                    String detail = "[Title]: " + parts[0].trim() + "\n" +
                            "[Author]: " + parts[1].trim() + "\n" +
                            "[Genre]: " + parts[2].trim() + "\n" +
                            "[Pages]: " + parts[3].trim() + "\n" +
                            "[Cost]: $" + parts[4].trim() + "\n";
                    bookList.add(detail);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                String[] parts = line.split(",");
                if (parts.length == 6 && parts[0].trim().equals("PRINTED,")) {
                    String detail = "[Title]: " + parts[1].trim() + "\n" +
                            "[Author]: " + parts[2].trim() + "\n" +
                            "[Genre]: " + parts[3].trim() + "\n" +
                            "[Pages]: " + parts[4].trim() + "\n" +
                            "[Cost]: $" + parts[5].trim() + "\n";
                    bookList.add(detail);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    public static HashMap<String, Integer> printedGenreCount() {
        HashMap<String, Integer> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 6 && parts[0].trim().equals("PRINTED")) {
                    String genre = parts[3].trim();
                    System.out.println(parts[3]);
                    map.put(genre, map.getOrDefault(genre, 0) + 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    @Override
    public String toString() {
        return "PrintedBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", cost=" + cost +
                ", pages=" + pages +
                '}';
    }
}