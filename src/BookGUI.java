import javax.swing.*;
import java.awt.*;

class BookGUI extends JFrame {
    final int WIDTH = 700;
    final int HEIGHT = 400;

    public BookGUI() {
        JButton addBook = new JButton("Add Book");
        JButton viewBook = new JButton("View Books");
        JButton deleteBook = new JButton("Delete Book");

        // MAIN FRAME
        setTitle("Book Tracker");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TITLE LABEL
        JLabel title = new JLabel("Book Tracker");
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // CARD LAYOUT TO MANAGE PANELS
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // BUTTON PANEL FOR MAIN PAGE
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // MAIN BUTTON PANEL
        cardPanel.add(buttonPanel, "mainPanel");

        // ADD BOOK BUTTON
        addBook.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(addBook);

        addBook.addActionListener(e -> {
            String bookDetails = JOptionPane.showInputDialog(null, "Enter book (type (printed/audio), title, author, genre, cost, pages/length)");
            if (bookDetails != null && !bookDetails.trim().isEmpty()) {

                if (bookDetails.split(",")[0].equalsIgnoreCase("printed")) {
                    String[] parts = bookDetails.split(",");
                    new PrintedBook(parts[1].trim(), parts[2].trim(), parts[3].trim(),
                            Double.parseDouble(parts[4].trim()), Double.parseDouble(parts[5].trim()));
                    JOptionPane.showMessageDialog(null, "Printed Book added: " + parts[1].trim());

                } else if (bookDetails.split(",")[0].equalsIgnoreCase("audio")) {
                    String[] parts = bookDetails.split(",");
                    new AudioBook(parts[1].trim(), parts[2].trim(), parts[3].trim(),
                            Double.parseDouble(parts[4].trim()), Double.parseDouble(parts[5].trim()));
                    JOptionPane.showMessageDialog(null, "AudioBook added: " + parts[1].trim());

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid book type.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No input provided.");
            }
        });

        // ADD VIEW BOOK BUTTON
        viewBook.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(viewBook);

        // DYNAMIC BUTTON PANEL FOR VIEWING BOOKS
        JPanel dynamicButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton printedBooks = new JButton("Printed books");
        JButton audioBooks = new JButton("Audiobooks");
        JButton allBooks = new JButton("All books");
        JButton backButton = new JButton("Back");

        printedBooks.setPreferredSize(new Dimension(150, 50));
        audioBooks.setPreferredSize(new Dimension(150, 50));
        allBooks.setPreferredSize(new Dimension(150, 50));
        backButton.setPreferredSize(new Dimension(150, 50));

        dynamicButtonPanel.add(printedBooks);
        dynamicButtonPanel.add(audioBooks);
        dynamicButtonPanel.add(allBooks);
        dynamicButtonPanel.add(backButton);

        printedBooks.addActionListener(e -> {
            // Clear the dynamic panel before adding new buttons
            dynamicButtonPanel.removeAll();

            // Buttons for printed book options
            JButton averagePagesButton = new JButton("Average pages");
            JButton lastThreeBooksButton = new JButton("Last 3 books");
            JButton allPrintedBooksButton = new JButton("All books");

            // Set button sizes
            averagePagesButton.setPreferredSize(new Dimension(150, 50));
            lastThreeBooksButton.setPreferredSize(new Dimension(150, 50));
            allPrintedBooksButton.setPreferredSize(new Dimension(150, 50));

            // Add buttons to dynamic panel
            dynamicButtonPanel.add(averagePagesButton);
            dynamicButtonPanel.add(lastThreeBooksButton);
            dynamicButtonPanel.add(allPrintedBooksButton);

            // Action listeners for new buttons
            averagePagesButton.addActionListener(a -> {
                // Logic to calculate and show average pages
                JOptionPane.showMessageDialog(null, "Average pages: " + PrintedBook.averagePages());
            });

            lastThreeBooksButton.addActionListener(a -> {
                // Logic to show the last 3 printed books
                JOptionPane.showMessageDialog(null, PrintedBook.lastThreePrintedBooks());
            });

            allPrintedBooksButton.addActionListener(a -> {
                // Logic to show all printed books
                JOptionPane.showMessageDialog(null, "All printed books: ");
            });

            backButton.addActionListener(a -> cardLayout.show(cardPanel, "mainPanel"));

            // Refresh the dynamic panel
            dynamicButtonPanel.revalidate();
            dynamicButtonPanel.repaint();
        });


        // ADD DYNAMIC PANEL TO CARD LAYOUT
        cardPanel.add(dynamicButtonPanel, "dynamicPanel");

        // VIEW BOOK ACTION
        viewBook.addActionListener(e -> cardLayout.show(cardPanel, "dynamicPanel"));

        // DELETE BOOK BUTTON
        deleteBook.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(deleteBook);

        // DELETE BUTTON ACTION
        deleteBook.addActionListener(e -> JOptionPane.showMessageDialog(null, "Button Clicked!"));

        // BACK BUTTON ACTION
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "mainPanel"));

        add(title, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
