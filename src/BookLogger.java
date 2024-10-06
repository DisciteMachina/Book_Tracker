import java.io.*;

public class BookLogger {

    private static final String FILE_NAME = "book_log.txt";

    public static void writeBookToFile(String bookDetails) {
        if (!checkLogged(bookDetails)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(bookDetails);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //System.out.println("Book already logged: " + bookDetails);
            System.out.println();
        }
    }

    private static boolean checkLogged(String bookDetails) {
        String bookDetailsNoSpaces = bookDetails.replaceAll(" ", "");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String lineNoSpaces = line.replaceAll(" ", "");
                if (lineNoSpaces.equals(bookDetailsNoSpaces)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}

