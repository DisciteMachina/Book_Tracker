public class Main {
    public static void main(String[] args) {
        BookManager.loadBooksFromFile();

        BookGUI window = new BookGUI();
        window.setVisible(true);
    }
}