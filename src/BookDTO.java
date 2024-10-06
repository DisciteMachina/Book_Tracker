public class BookDTO {
    private String type;
    private String title;
    private String author;
    private String genre;
    private double cost;
    private int pages;
    private double length;

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

    // Getters
    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getCost() {
        return cost;
    }

    public int getPages() {
        return pages;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        String details = "[Title]: " + title + "\n" +
                "[Author]: " + author + "\n" +
                "[Genre]: " + genre + "\n" +
                "[Cost]: $" + cost + "\n" +
                "[Type]: " + type;
        if (type.equals("PRINTED")) {
            details += "\n" + "[Pages]: " + pages + "\n";
        } else {
            details += "\n" + " [Length]: " + length + " minutes" + "\n";
        }
        return details;
    }
}
