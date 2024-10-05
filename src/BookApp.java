// For printed books: title, author, genre, cost, pages

// For audio books: title, author, genre, cost, length


import java.util.ArrayList;

public class BookApp {
    public static void main(String[] args) {
        PrintedBook book1 = new PrintedBook("Title1", "author1", "genre1", 10.0, 210);
        PrintedBook book2 = new PrintedBook("Title2", "author2", "genre2", 20.0, 320);
        PrintedBook book3 = new PrintedBook("Title3", "author3", "genre3", 30.0, 450);

        System.out.println("Average cost of all books: " + PrintedBook.averagePages());

        ArrayList<String> details = PrintedBook.lastThreePrintedBooks();
        for (String detail : details) {
            System.out.println(detail);
        }
    }
}
