import java.util.ArrayList;

public class BookApp {
    public static void main(String[] args) {
        PrintedBook book1 = new PrintedBook("Way Of Kings", "Brandon Sanderson", "Fantasy", 8.99, 1001);
        PrintedBook book2 = new PrintedBook("Crime and Punishment", "Dostoevsky", "Psychological Thriller", 6.51, 492);
        PrintedBook book3 = new PrintedBook("Metamorphosis", "Franz Kafka", "Fiction", 5.00, 70);
        PrintedBook book4 = new PrintedBook("The Fellowship of the Ring", "J.R.R Tolkien", "Fantasy", 5.84, 423);
        PrintedBook book5 = new PrintedBook("Frankenstein", "Mary Shelley", "Horror", 6.59, 280);

        AudioBook book6 = new AudioBook("The World as Will and Representation", "Arthur Schopenhauer", "Philosophy", 5.00, 1226);
        AudioBook book7 = new AudioBook("The Last Olympian", "Rick Riordan", "Fantasy", 9.00, 660);

        /*ArrayList<String> pBooks = PrintedBook.lastThreePrintedBooks();
        for (String detail : pBooks) {
            System.out.println(detail);


        ArrayList<String> aBooks = AudioBook.lastThreeAudioBooks();
        for (String detail : aBooks) {
            System.out.println(detail);
        }*/

        // Genre count for both Printed and Audio books
        BookAbstract.numberOfBooksPerGenre();

        System.out.println(BookInterface.lastSixBooks());

        // GUI
        BookGUI window = new BookGUI();
        window.setVisible(true);
    }
}
