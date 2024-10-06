import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        PrintedBook a = new PrintedBook("Way Of Kings", "Brandon Sanderson", "Fantasy", 8.99, 1001);
        PrintedBook b = new PrintedBook("Crime and Punishment", "Dostoevsky", "Psychological Thriller", 6.51, 492);
        PrintedBook c = new PrintedBook("Metamorphosis", "Franz Kafka", "Fiction", 5.00, 70);
        PrintedBook d = new PrintedBook("The Fellowship of the Ring", "J.R.R Tolkien", "Fantasy", 5.84, 423);
        PrintedBook e = new PrintedBook("Frankenstein", "Mary Shelley", "Horror", 6.59, 280);

        AudioBook f = new AudioBook("The World as Will and Representation", "Arthur Schopenhauer", "Philosophy", 5.00, 1226);
        AudioBook g = new AudioBook("The Last Olympian", "Rick Riordan", "Fantasy", 9.00, 660);

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Book Tracker");
            System.out.println("------------");
            System.out.println("[1] Add Books");
            System.out.println("[2] Manage Books");
            System.out.println("[3] Exit");

            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("What kind of book?");
                System.out.println("[1] Printed Book");
                System.out.println("[2] Audiobook");
                int bookType = input.nextInt();
                input.nextLine();

                if (bookType == 1) {
                    System.out.println("Enter book details.");
                    System.out.println("(Title, Author, Genre, Pages, Cost)");
                    String bookInfo = input.nextLine();

                    String[] parts = bookInfo.split(",");

                    if (parts.length == 5) {
                        String title = parts[0].trim();
                        String author = parts[1].trim();
                        String genre = parts[2].trim();
                        int pages = Integer.parseInt(parts[3].trim());
                        double cost = Double.parseDouble(parts[4].trim());

                        PrintedBook book = new PrintedBook(title, author, genre, cost, pages);

                        System.out.println("Book created: " + book.getTitle() + " by " + book.getAuthor());
                    } else {
                        System.out.println("Invalid input. Please provide Title, Author, Genre, Pages, and Cost.");
                    }
                }

                if (bookType == 2) {
                    System.out.println("Enter book details.");
                    System.out.println("(Title, Author, Genre, Length, Cost)");
                    String bookInfo = input.nextLine();

                    String[] parts = bookInfo.split(",");

                    if (parts.length == 5) {
                        String title = parts[0].trim();
                        String author = parts[1].trim();
                        String genre = parts[2].trim();
                        double length = Integer.parseInt(parts[3].trim());
                        double cost = Double.parseDouble(parts[4].trim());

                        AudioBook book = new AudioBook(title, author, genre, cost, length);

                        System.out.println("Book created: " + book.getTitle() + " by " + book.getAuthor());
                    } else {
                        System.out.println("Invalid input. Please provide Title, Author, Genre, Pages, and Cost.");
                    }

                }
            }

            if (choice == 2) {
                // LOOK AT BOOKS, USE SPECIAL METHODS
            }

            if (choice == 3) {
                break;
            }
        }


        ArrayList<String> pBooks = PrintedBook.lastThreePrintedBooks();
        for (String pDetail : pBooks) {
            System.out.println(pDetail);
        }


        ArrayList<String> aBooks = AudioBook.lastThreeAudioBooks();
        for (String aDetail : aBooks) {
            System.out.println(aDetail);
        }

            // Genre count for both Printed and Audio books
            // BookAbstract.numberOfBooksPerGenre();

            //  System.out.println(BookInterface.lastSixBooks());

            // GUI
            //  BookGUI window = new BookGUI();
            //  window.setVisible(true);
    }
}

