// Data transfer object for easy look up, rather
// than having to read the txt file over and over

public class BookDTO {
    private final String type;
    private final String title;
    private final String author;
    private final String genre;
    private final double cost;
    private final int pages;
    private final double length;

    // Constructor for printed books
    public BookDTO(String type, String title, String author, String genre, double cost, int pages) {
        this.type = type;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
        this.pages = pages;
        this.length = 0; // N/A
    }

    // Constructor for audiobooks
    public BookDTO(String type, String title, String author, String genre, double cost, double length) {
        this.type = type;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
        this.length = length;
        this.pages = 0; // N/A
    }

    public String getTitle() {
        return title;
    }

    // Override the default to string method so it looks better
    @Override
    public String toString() {
        String details = "[Title]: " + title + "\n" +
                "[Author]: " + author + "\n" +
                "[Genre]: " + genre + "\n" +
                "[Cost]: $" + cost;
        if (type.equals("PRINTED")) {
            details += "\n" + "[Pages]: " + pages +"\n" + "[Type]: " + type + "\n";
        } else {
            details += "\n" + "[Length]: " + length +  " minutes" + "\n" +  "[Type]: " + type + "\n";
        }
        return details;
    }
}
