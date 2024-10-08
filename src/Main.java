import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<BookDTO> books = BookLogger.readBooksFromFile();
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

                    // PRINTED BOOK
                    if (bookType == 1) {
                        while (true) {
                            System.out.println("Enter book details");
                            System.out.println("Title, Author, Genre, Cost, Pages");
                            System.out.println("Cancel to cancel");
                            String printedBook = input.nextLine();

                            if (printedBook.equalsIgnoreCase("cancel")) {
                                break;
                            } else {
                                // Split string into parts, and extract info
                                String[] parts = printedBook.split(",");
                                if (parts.length == 5) {
                                    try {
                                        String title = parts[0].trim();
                                        String author = parts[1].trim();
                                        String genre = parts[2].trim();
                                        int pages = Integer.parseInt(parts[3].trim());
                                        double cost = Double.parseDouble(parts[4].trim());

                                        new PrintedBook(title, author, genre, pages, cost);
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input format");
                                    }
                                } else {
                                    System.out.println("Invalid input format");
                                }
                            }
                        }
                    }
                    // AUDIOBOOK
                    else if (bookType == 2) {
                        while (true) {
                            System.out.println("Enter book details");
                            System.out.println("Title, Author, Genre, Cost, Length (in minutes)");
                            System.out.println("Cancel to cancel");
                            String audioBook = input.nextLine();

                            // Split string into parts, and extract info
                            String[] parts = audioBook.split(",");
                            try {
                                if (parts[0].equalsIgnoreCase("cancel")) {
                                    break;
                                } else if (parts.length == 5) {
                                    String title = parts[0].trim();
                                    String author = parts[1].trim();
                                    String genre = parts[2].trim();
                                    double cost = Double.parseDouble(parts[3].trim());
                                    double length = Integer.parseInt(parts[4].trim());

                                    new AudioBook(title, author, genre, cost, length);
                                    break;
                                } else {
                                    System.out.println("Invalid input format");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input format");
                            }
                        }

                    } else if (bookType == 3) {
                        break;
                    }
                    break;
                // DELETE BOOKS
                case 2:
                    while(true) {
                        System.out.println("Enter the title of the book");
                        System.out.println("Cancel to cancel");
                        String bookTitle = input.nextLine();

                        if (bookTitle.equalsIgnoreCase("cancel")) {
                            break;
                        } else {
                            for (BookDTO book : books) {
                                if (bookTitle.trim().equalsIgnoreCase(book.getTitle().trim())) {
                                app.deleteBook(bookTitle);
                                }
                            }
                        }
                    }
                    break;
                // DISPLAY BOOKS
                case 3:
                    app.displayAllBooks();
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    break;
            }
            if (userChoice == '4') {
                break;
            }
        }
    }
}
