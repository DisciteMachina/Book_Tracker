import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface BookInterface {

    default ArrayList<String> getLastSixBooks() {
        ArrayList<String> bookList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("book_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String detail = "[Title]: " + parts[1].trim() + "\n" +
                            "[Author]: " + parts[2].trim() + "\n" +
                            "[Genre]: " + parts[3].trim() + "\n" +
                            "[Pages]: " + parts[4].trim() + "\n" +
                            "[Cost]: $" + parts[5].trim() + "\n";
                    bookList.add(detail);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    public HashMap<String, Integer> numberOfBooksPerGenre();
}
