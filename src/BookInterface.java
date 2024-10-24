import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface BookInterface {
    List<Book> books = new ArrayList<>();

    default String displayLastSixBooks() {
        StringBuilder lastSixBooks = new StringBuilder("[Last six books]\n");
        int totalBooks = Book.books.size();

        if (books.size() < 6) {
            return "There aren't six books";
        } else {
            int start = Math.max(totalBooks - 6, 0);
            for (int i = start; i < totalBooks; i++) {
                lastSixBooks.append('\n');
                lastSixBooks.append("[");
                lastSixBooks.append(books.get(i).toString());
                lastSixBooks.append("]");
                lastSixBooks.append('\n');
            }
        }
        return lastSixBooks.toString();
    }

    static HashMap<String, Integer> getNumberOfBooksByGenre() {
        return null;
    }

    static double getTotalCost() {
        return 0;
    }
}