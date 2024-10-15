import java.util.HashMap;
import java.util.List;

public class AudioBook extends Book {
    private String title;
    private String author;
    private String genre;
    private double cost;
    private double length;

    private static double totalLength = 0;


    public AudioBook(String title, String author, String genre, double cost, double length) {
        super(title, author, genre, cost);
        this.length = length;

        storeBookInfo(title, author, genre, cost);
        writeFile();
    }

    public void storeBookInfo(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        double COST_PER_MINUTE = 5;
        System.out.println("The cost of " + getTitle() + "is " + length * COST_PER_MINUTE);
        return length * COST_PER_MINUTE;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    public static double getTotalLength() {
        BookManager bookManager = new BookManager();
        List<String> books = bookManager.getAudioBooks();

        for (String loggedBook : books) {
            double bookLength = Double.parseDouble(loggedBook.split(",")[5].trim());
            totalLength += bookLength;
        }
        return totalLength;
    }

    public void writeFile() {
        BookManager bookManager = new BookManager();
        String book = String.join(",", "AUDIO", title, author, genre, String.valueOf(cost), String.valueOf(length));
        bookManager.writeToFile(book);
    }

    public static double averageLength () {
        List<String> books = BookManager.readBooksFromFile(); // All the books
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            count ++;
        }
        return (getTotalLength() / count);
    }

    public static void lastThreeAudioBooks() {
        BookManager bookManager = new BookManager();
        List<String> audioBooks = bookManager.getAudioBooks();

        // Get the last three books with subList(size of array - 3, size of array)
        List<String> lastThreeBooks = audioBooks.subList(audioBooks.size() -3, audioBooks.size());
        System.out.println("---------------------------------");
        System.out.println("[The last three audiobooks are]: ");
        for (String loggedBook : lastThreeBooks) {
            String[] parts = loggedBook.split(",");
            String detail = "[Title]: " + parts[1].trim() + "\n" +
                    "[Author]: " + parts[2].trim() + "\n" +
                    "[Genre]: " + parts[3].trim() + "\n" +
                    "[Cost]: " + parts[4].trim() + "\n" +
                    "[Length]: $" + parts[5].trim() + "\n";
            System.out.println("---------------------------------");
            System.out.println(detail);
        }
    }

    public static String allAudioBooks() {
        BookManager bookManager = new BookManager();
        List<String> audioBooks = bookManager.getPrintedBooks();

        StringBuilder sb = new StringBuilder();
        sb.append("[All audiobooks]:\n");
        sb.append("---------------------------------\n");

        for (String loggedBook : audioBooks) {
            String[] parts = loggedBook.split(",");
            sb.append("[Title]: ").append(parts[1].trim()).append("\n")
                    .append("[Author]: ").append(parts[2].trim()).append("\n")
                    .append("[Genre]: ").append(parts[3].trim()).append("\n")
                    .append("[Cost]: $").append(parts[4].trim()).append("\n")
                    .append("[Length]: ").append(parts[5].trim()).append("\n")
                    .append("---------------------------------\n");
        }

        return sb.toString();
    }

    public HashMap<String, Integer> numberOfBooksPerGenre() {
        HashMap<String, Integer> genreCount = new HashMap<>();
        BookManager bookManager = new BookManager();
        List<String> audioBooks = bookManager.getAudioBooks();

        for (String loggedBook : audioBooks) {
            String bookGenre = loggedBook.split(",")[3].trim();
            genreCount.put(bookGenre, genreCount.getOrDefault(bookGenre, 0) + 1);
        }
        return genreCount;
    }

    @Override
    public String toString() {
        return "[AUDIO BOOK]" + '\n' +
                "[title]: " + title + '\n' +
                "[author]: " + author + '\n' +
                "[genre]: " + genre + '\n' +
                "[cost]: $" + cost + '\n' +
                "[length]: " + length + '\n';
    }
}
