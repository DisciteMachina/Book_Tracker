// For printed books: title, author, genre, cost, pages

// For audiobooks: title, author, genre, cost, length


import java.util.ArrayList;

public class BookApp {
    public static void main(String[] args) {
        PrintedBook book1 = new PrintedBook("Title1", "author1", "genre1", 10.0, 210);
        AudioBook book2 = new AudioBook("Title2", "author2", "genre2", 20.0, 320.21);

        // Average number of pages of all printed books
        System.out.println("Average number of pages of all books: " + PrintedBook.averagePages());

        // Average length of all audiobooks
        System.out.println("Average length of all audio books: " + AudioBook.averageLength());

        // Print last 3 printed books
        ArrayList<String> detailsP = PrintedBook.lastThreePrintedBooks();
        for (String detail : detailsP) {
            System.out.println(detail);
        }

        // Print last 3 audiobooks
        ArrayList<String> detailsA = AudioBook.lastThreeAudioBooks();
        for (String detail : detailsA) {
            System.out.println(detail);
        }
    }
}
