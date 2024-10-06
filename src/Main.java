import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookApp app = new BookApp();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Book Manager");
            System.out.println("------------");
            System.out.println("Choose an option: ");
            System.out.println("1. Add a book");
            System.out.println("2. Delete a book");
            System.out.println("3. View books");
            System.out.println("4. Exit");

            int userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {
                // Add book
                case 1:
                    System.out.println("1. Printed book");
                    System.out.println("2. Audio book");
                    System.out.println("3. Cancel");
                    int bookType = input.nextInt();
                    input.nextLine();

                    if (bookType == 1) {
                        while (true) {
                            System.out.println("Enter book details");
                            System.out.println("Title, Author, Genre, Cost, Pages");
                            System.out.println("Cancel to cancel");
                            String book = input.nextLine();

                            // Split string into parts, and extract info
                            String[] parts = book.split(",");
                            try {
                                if (parts[0].equalsIgnoreCase("cancel")) {
                                    break;
                                } else if (parts.length == 5) {
                                    String title = parts[0].trim();
                                    String author = parts[1].trim();
                                    String genre = parts[2].trim();
                                    double cost = Double.parseDouble(parts[3].trim());
                                    int pages = Integer.parseInt(parts[4].trim());


                                    new PrintedBook(title, author, genre, cost, pages);
                                    break;
                                } else {
                                    System.out.println("Invalid input format");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input format");
                            }
                        }
                    } else if (bookType == 2) {

                        System.out.println("Enter book details");
                        System.out.println("Title, Author, Genre, Cost, Length (in minutes)");
                    } else if (bookType == 3) {
                        break;
                }
                    break;

                // Delete book
                case 2:
                    break;

                // View books
                case 3:
                    app.displayLastSixBooks();
                    break;

                // Exits
                case 4:
                    System.out.println("Exiting the program...");
                    break;
            }

            // Exits
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
