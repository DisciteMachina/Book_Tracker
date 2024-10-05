import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

interface BookInterface {

    static String lastSixBooks() {
        ArrayList<String> lastSixBooks = getLastSixBooksFromLog();
        StringBuilder sb = new StringBuilder("Last Six Book Titles:\n");

        for (String title : lastSixBooks) {
            sb.append(title).append("\n");
        }

        return sb.toString();
    }

    static ArrayList<String> getLastSixBooksFromLog() {
        ArrayList<String> lastSixBooks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            ArrayList<String> allBooks = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                allBooks.add(line);
            }

            int startIndex = Math.max(0, allBooks.size() - 6);
            for (int i = startIndex; i < allBooks.size(); i++) {
                String title = allBooks.get(i).split(",")[0];
                lastSixBooks.add(title.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lastSixBooks;
    }

    static int numberOfBooksPerGenre(String genre) {
        return 0;
    }

    double getTotalCost();
}
