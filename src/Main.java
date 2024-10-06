import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<BookDTO> allBooks = BookLogger.readBooksFromFile();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Book Manager");
            System.out.println("------------");
            System.out.println("Choose an option: ");
            System.out.println("1. Add a book");
            System.out.println("2. View all books");
            System.out.println("3. Search for a book");
            System.out.println("4. Exit");

            int userChoice = input.nextInt(); // Assuming input is a Scanner

            switch (userChoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
            }

            if (userChoice == 4) {
                break;
            }
        }
    }
}

/*
for (BookDTO book : allBooks) {
        if (book.getType().equalsIgnoreCase("PRINTED")) {
        System.out.println(book);
            }
                    }

 */
