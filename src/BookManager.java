import java.io.*;
import java.util.Arrays;

public class BookManager {
    static String FILE_NAME = "book_log.txt";

    private void ensureFileExists() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile(); // Create the file if it doesn't exist
            } catch (IOException e) {
                throw new RuntimeException("Error while creating the file", e);
            }
        }
    }

    public void loadBooks() {
        ensureFileExists();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String type = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    String genre = parts[3].trim();
                    double cost = Double.parseDouble(parts[4].trim());
                    if (type.equalsIgnoreCase("PRINTED")) {
                        int pages = Integer.parseInt(parts[5].trim());
                        PrintedBook printedBook = new PrintedBook(title, author, genre, cost, pages);
                    } else if (type.equalsIgnoreCase("AUDIO")) {
                        int length = Integer.parseInt(parts[5].trim());
                        AudioBook audioBook = new AudioBook(title, author, genre, cost, length);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(Book book) {
        String title = book.getTitle();
        boolean isLogged = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].trim().equalsIgnoreCase(title)) {
                    isLogged = true;
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!isLogged) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(book.toString());
                writer.newLine();
                System.out.println("Book logged: " + book.getTitle());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}