abstract class BookAbstract implements BookInterface {
    protected String title;
    protected String author;
    protected String genre;
    protected double cost;

    public BookAbstract(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    public double numberOfBooksPerGenre() {
        return 0;
    }

    public double getTotalCost() {
        return 0;
    }

    public abstract double getCost();
}
