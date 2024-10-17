public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        bookManager.loadBooks();

        BookGUI window = new BookGUI();
        window.setVisible(true);

        for (Book book : Book.books) {
            System.out.println(book);
        }
    }
}
