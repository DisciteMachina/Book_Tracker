public class AudioBook extends BookAbstract {
    protected double length;
    protected double COST_PER_MINUTE = 5.0;

    public AudioBook(String title, String author, String genre, double cost) {
        super(title, author, genre, cost);
    }

    public double getCost() {
        return 0;
    }

    public double averageLength() {
        return 0;
    }

    public String lastThreeAudioBooks() {
        return "";
    }
}
