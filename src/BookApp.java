import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Book Tracker");
            System.out.println("------------");
            System.out.println("[1] Add Books");
            System.out.println("[2] Manage Books");
            System.out.println("[3] Exit");

            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("What kind of book?");
                System.out.println("------------");
                System.out.println("[1] Printed Book");
                System.out.println("[2] Audiobook");
                System.out.println("[3] Exit");
                int bookType = input.nextInt();
                input.nextLine();

                if (bookType == 1) {
                    System.out.println("Enter book details.");
                    System.out.println("------------");
                    System.out.println("(Title, Author, Genre, Pages, Cost)");
                    String bookInfo = input.nextLine();

                    String[] parts = bookInfo.split(",");

                    if (parts.length == 5) {
                        String title = parts[0].trim();
                        String author = parts[1].trim();
                        String genre = parts[2].trim();

                        boolean validInput = false;
                        int pages = 0;
                        double cost = 0;

                        while (!validInput) {
                            try {
                                pages = Integer.parseInt(parts[3].trim());
                                cost = Double.parseDouble(parts[4].trim());
                                validInput = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input for pages or cost. Please enter the details again.");
                                System.out.println("(Title, Author, Genre, Pages, Cost)");
                                bookInfo = input.nextLine();
                                parts = bookInfo.split(",");
                            }
                        }

                        String bookDetails = title + "," + author + "," + genre + "," + pages + "," + cost;

                        if (BookLogger.checkLogged(bookDetails)) {
                            BookLogger.writeBookToFile(bookDetails);
                            System.out.println("Logged " + title + " By " + author);
                        } else {
                            System.out.println("Book already logged: " + title);
                        }
                    }
                } else if (bookType == 2) {
                    System.out.println("Enter book details.");
                    System.out.println("------------");
                    System.out.println("(Title, Author, Genre, Length, Cost)");
                    String bookInfo = input.nextLine();

                    String[] parts = bookInfo.split(",");

                    if (parts.length == 5) {
                        String title = parts[0].trim();
                        String author = parts[1].trim();
                        String genre = parts[2].trim();
                        double length = Integer.parseInt(parts[3].trim());
                        double cost = Double.parseDouble(parts[4].trim());

                        String bookDetails = title + "," + author + "," + genre + "," + length + "," + cost;

                        if (BookLogger.checkLogged(bookDetails)) {
                            BookLogger.writeBookToFile(bookDetails);
                        } else {
                            System.out.println("Book already logged: " + title);
                        }

                    }
                }
                if (bookType == 3) {
                    continue;
                }

            } else if (choice == 2) {
                System.out.println("------------");
                System.out.println("[1] Printed Books");
                System.out.println("[2] Audiobooks");
                System.out.println("[3] View All Books");
                System.out.println("[4] Exit");
                int typeBook = input.nextInt();
                input.nextLine();

                if (typeBook == 1) {
                    System.out.println("------------");
                    System.out.println("[1] View All Printed Books");
                    System.out.println("[2] Last Three Added Books");
                    System.out.println("[3] Calculate Average Pages");
                    System.out.println("[4] Calculate Total Cost");
                    System.out.println("[5] Exit");

                    int bookInfo = input.nextInt();
                    input.nextLine();

                    if (bookInfo == 1) {
                        ArrayList<String> allBooks = PrintedBook.allPrintedBooks();
                        for (String detail : allBooks) {
                            System.out.println(detail);
                        }
                    }

                    if (bookInfo == 2) {
                        ArrayList<String> pBooks = PrintedBook.lastThreePrintedBooks();
                        for (String pDetail : pBooks) {
                            System.out.println(pDetail);
                        }
                    }


                    if (bookInfo == 3) {
                        System.out.println(PrintedBook.averagePages());
                    }

                    if (bookInfo == 4) {
                        System.out.println(PrintedBook.totalCost());
                    }

                    if (bookInfo == 5) {
                        continue;
                    }
                }

                if (typeBook == 2) {
                }

                if (typeBook == 3) {
                    System.out.println("[1] View All Book Info");
                    System.out.println("[2] View All Book Genres");
                    int bookInfo = input.nextInt();

                    if (bookInfo == 1) {

                    }

                    if (bookInfo == 2) {
                        BookAbstract.numberOfBooksPerGenre();
                    }
                }

                if (typeBook == 4) {
                    continue;
                }

            } else if (choice == 3) {
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
    }
}

                // Genre count for both Printed and Audio books
                // BookAbstract.numberOfBooksPerGenre();

                //  System.out.println(BookInterface.lastSixBooks());

                // GUI
                //  BookGUI window = new BookGUI();
                //  window.setVisible(true);


