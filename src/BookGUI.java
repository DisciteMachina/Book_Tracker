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

        // VIEW BOOK ACTION
        viewBook.addActionListener(e -> cardLayout.show(cardPanel, "dynamicPanel"));

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
            dynamicButtonPanel.removeAll();

            // Buttons for printed book options
            JButton averagePagesButton = new JButton("Average pages");
            JButton lastThreeBooksButton = new JButton("Last 3 books");
            JButton allPrintedBooksButton = new JButton("All books");

            averagePagesButton.setPreferredSize(new Dimension(150, 50));
            lastThreeBooksButton.setPreferredSize(new Dimension(150, 50));
            allPrintedBooksButton.setPreferredSize(new Dimension(150, 50));

            dynamicButtonPanel.add(averagePagesButton);
            dynamicButtonPanel.add(lastThreeBooksButton);
            dynamicButtonPanel.add(allPrintedBooksButton);
            dynamicButtonPanel.add(backButton);

            // AVERAGE PAGES
            averagePagesButton.addActionListener(a -> {
                JOptionPane.showMessageDialog(null, "Average pages: " + PrintedBook.averagePages());
            });

            // LAST THREE BOOKS
            lastThreeBooksButton.addActionListener(a -> {
                String lastThreeBooks = PrintedBook.lastThreePrintedBooks();

                JTextArea textArea = new JTextArea(lastThreeBooks);
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 300)); // Set preferred size

                JOptionPane.showMessageDialog(null, scrollPane, "All Printed Books", JOptionPane.INFORMATION_MESSAGE);
            });

            // ALL PRINTED BOOKS
            allPrintedBooksButton.addActionListener(a -> {
                String allBooksInfo = PrintedBook.allPrintedBooks();

                JTextArea textArea = new JTextArea(allBooksInfo);
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 300)); // Set preferred size

                JOptionPane.showMessageDialog(null, scrollPane, "All Printed Books", JOptionPane.INFORMATION_MESSAGE);
            });

            // BACK BUTTON
            backButton.addActionListener(a -> {
                dynamicButtonPanel.removeAll();
                dynamicButtonPanel.add(printedBooks);
                dynamicButtonPanel.add(audioBooks);
                dynamicButtonPanel.add(allBooks);
                dynamicButtonPanel.add(backButton);
                dynamicButtonPanel.revalidate();
                dynamicButtonPanel.repaint();
                cardLayout.show(cardPanel, "mainPanel");
            });

            dynamicButtonPanel.revalidate();
            dynamicButtonPanel.repaint();
        });


        // DELETE BOOK BUTTON
        deleteBook.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(deleteBook);

        // DELETE BUTTON ACTION
        deleteBook.addActionListener(e -> JOptionPane.showMessageDialog(null, "Button Clicked!"));


        // ADD DYNAMIC PANEL TO CARD LAYOUT
        cardPanel.add(dynamicButtonPanel, "dynamicPanel");

        add(title, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}

