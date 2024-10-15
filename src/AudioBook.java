import java.text.DecimalFormat;
import java.util.List;

public class AudioBook extends Book {
    private String title;
    private String author;
    private String genre;
    private double cost;
    private double length;

    private static double totalLength = 0;


    public AudioBook(String title, String author, String genre, double cost, double length) {
        super();
        storeBookInfo(title, author, genre, cost);
        setLength(length);
    }

    public void storeBookInfo(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    // Setter for length
    public void setLength(double length) {
        this.length = length;
        writeFile(title, author, genre, cost, length);

    }

    @Override
    public double getCost() {
        double COST_PER_MINUTE = 5;
        System.out.println("The cost of " + getTitle() + "is " + length * COST_PER_MINUTE);
        return length * COST_PER_MINUTE;
    }

    public String getTitle() {
        return title;
    }

    // Convert length to hours
    public static double convertLength(double length) {
        DecimalFormat df = new DecimalFormat("#.##");
        double lengthHours = length / 60;
        return Double.parseDouble(df.format(lengthHours));
    }

    public static double getTotalLength() {
        BookManager bookManager = new BookManager();
        List<String> books = bookManager.getAudioBooks();
        double totalLength = 0;

        for (String loggedBook : books) {
            double bookLength = Double.parseDouble(loggedBook.split(",")[5].trim());
            totalLength += convertLength(bookLength);
        }
        return totalLength;
    }

    public void writeFile(String title, String author, String genre, double cost, double length) {
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
        System.out.println("[The last three printed books are]: ");
        for (String loggedBook : lastThreeBooks) {
            String[] parts = loggedBook.split(",");
            String detail = "[Title]: " + parts[1].trim() + "\n" +
                    "[Author]: " + parts[2].trim() + "\n" +
                    "[Genre]: " + parts[3].trim() + "\n" +
                    "[Length]: " + parts[4].trim() + "\n" +
                    "[Cost]: $" + parts[5].trim() + "\n";
            System.out.println("---------------------------------");
            System.out.println(detail);
        }
    }

    @Override
    public int numberOfBooksPerGenre(String genre) {
        return 0;
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