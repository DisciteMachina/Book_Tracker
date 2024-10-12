import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookManager.loadBooksFromFile();

        PrintedBook theShadowsEdge = new PrintedBook("The Shadow's Edge", "John Stevenson", "Mystery", 10, 1);
        PrintedBook dreamWalkers = new PrintedBook("Dream walkers", "Elena Martel", "Fantasy", 10, 1);
        AudioBook theLastVoyage = new AudioBook("The Last Voyage", "Emily Clarkson", "Adventure", 10, 1);
        PrintedBook beneathTheIronSky = new PrintedBook("Beneath the Iron Sky", "Gregory Hill", "Science Fiction", 10, 1);
        PrintedBook echoesOfThePast = new PrintedBook("Echoes of the Past", "Margaret White", "Historical Fiction", 10, 1);
        AudioBook whispersInTheWind = new AudioBook("Whispers in the Wind", "David Harper", "Romance", 10, 1);
        AudioBook theQuantumParadox = new AudioBook("The Quantum Paradox", "Sophia Lin", "Science Fiction", 10, 1);
        AudioBook voicesOfTheAbyss = new AudioBook("Voices of the Abyss", "Liam Douglas", "Thriller", 10, 1);

        System.out.println("Total cost of all books: $" + theShadowsEdge.getTotalCost());
    }
}