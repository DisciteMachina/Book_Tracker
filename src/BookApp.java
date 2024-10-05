// For printed books: title, author, genre, cost, pages

// For audiobooks: title, author, genre, cost, length


import java.util.ArrayList;

public class BookApp {
    public static void main(String[] args) {
        PrintedBook book1 = new PrintedBook("Title1", "author1", "genre1", 10.0, 210);
        PrintedBook book2 = new PrintedBook("Title1", "author1", "genre1", 50.0, 210);

        AudioBook book3 = new AudioBook("Title2", "author2", "genre2", 20.0, 320.21);
        AudioBook book4 = new AudioBook("Title2", "author2", "genre2", 40.0, 320.21);


        //printed
        System.out.println("Average number of pages of all printed books: " + PrintedBook.averagePages());
        System.out.println("Average cost of all printed books: " + PrintedBook.totalCost());

        ArrayList<String> detailsP = PrintedBook.lastThreePrintedBooks();
        for (String detail : detailsP) {
            System.out.println(detail);
        }

        //audio
        System.out.println("Average length of all audiobooks: " + AudioBook.averageLength());
        System.out.println("Average cost of all audiobooks: " + AudioBook.totalCost());


        ArrayList<String> detailsA = AudioBook.lastThreeAudioBooks();
        for (String detail : detailsA) {
            System.out.println(detail);
        }


    }
}
