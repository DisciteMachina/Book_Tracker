import java.io.*;

public class BookLogger {

    private static final String FILE_NAME = "book_log.txt";

    public static void writeBookToFile(String bookDetails) {
        if (checkLogged(bookDetails)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(bookDetails);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Book already logged: " + bookDetails);
            System.out.println();
        }
    }

    public static boolean checkLogged(String bookDetails) {
        String title = bookDetails.split(",")[0].trim(); // Get the title (the first part)

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String loggedTitle = line.split(",")[0].trim();
                if (loggedTitle.equalsIgnoreCase(title)) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


}

