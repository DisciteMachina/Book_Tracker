import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookManager.loadBooksFromFile();

        PrintedBook theShadowsEdge = new PrintedBook("The Shadow's Edge", "John Stevenson", "Mystery", 12.99, 320);
        PrintedBook dreamWalkers = new PrintedBook("Dream walkers", "Elena Martel", "Fantasy", 8.75, 540);
        AudioBook theLastVoyage = new AudioBook("The Last Voyage", "Emily Clarkson", "Adventure", 19.99, 420);
        PrintedBook beneathTheIronSky = new PrintedBook("Beneath the Iron Sky", "Gregory Hill", "Science Fiction", 15.50, 415);
        PrintedBook echoesOfThePast = new PrintedBook("Echoes of the Past", "Margaret White", "Historical Fiction", 9.99, 290);
        AudioBook whispersInTheWind = new AudioBook("Whispers in the Wind", "David Harper", "Romance", 14.50, 310);
        AudioBook theQuantumParadox = new AudioBook("The Quantum Paradox", "Sophia Lin", "Science Fiction", 22.75, 560);
        AudioBook voicesOfTheAbyss = new AudioBook("Voices of the Abyss", "Liam Douglas", "Thriller", 12.99, 480);

        // current bug: getTotalCost is returning the value of the
        // PAGE count for only printed items,
        // and its adding an extra 2 zeros,
        //e.g: 120 -> 1240.0
        //idk
        double totalCost = theShadowsEdge.getTotalCost();
        System.out.println(totalCost);
    }
}