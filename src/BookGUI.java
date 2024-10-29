import javax.swing.*;
import java.awt.*;

class BookGUI extends JFrame {
    final int WIDTH = 300;
    final int HEIGHT = 350;

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
                    PrintedBook printedBook = new PrintedBook(parts[1].trim(), parts[2].trim(), parts[3].trim(),
                            Double.parseDouble(parts[4].trim()), Integer.parseInt(parts[5].trim()));
                    JOptionPane.showMessageDialog(null, "Printed Book added: " + parts[1].trim());

                } else if (bookDetails.split(",")[0].equalsIgnoreCase("audio")) {
                    String[] parts = bookDetails.split(",");
                    AudioBook audioBook = new AudioBook(parts[1].trim(), parts[2].trim(), parts[3].trim(),
                            Double.parseDouble(parts[4].trim()), Integer.parseInt(parts[5].trim()));
                    JOptionPane.showMessageDialog(null, "AudioBook added: " + parts[1].trim());

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid book type.");
                }
            }
        });

        // ADD VIEW BOOK BUTTON
        viewBook.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(viewBook);

        // DYNAMIC BUTTON PANEL FOR VIEWING BOOKS
        JPanel dynamicButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton printedBooks = new JButton("Printed books");
        JButton audioBooks = new JButton("Audiobooks");
        JButton specialActions = new JButton("Special Actions");
        JButton backButton = new JButton("Back");

        printedBooks.setPreferredSize(new Dimension(150, 50));
        audioBooks.setPreferredSize(new Dimension(150, 50));
        specialActions.setPreferredSize(new Dimension(150, 50));
        backButton.setPreferredSize(new Dimension(150, 50));

        // Add options to the dynamic panel
        dynamicButtonPanel.add(printedBooks);
        dynamicButtonPanel.add(audioBooks);
        dynamicButtonPanel.add(specialActions);
        dynamicButtonPanel.add(backButton);

        // ADD DYNAMIC PANEL TO CARD LAYOUT
        cardPanel.add(dynamicButtonPanel, "dynamicPanel");

        // VIEW BOOK ACTION
        viewBook.addActionListener(e -> {
            // Reset the dynamic panel by clearing and re-adding buttons
            dynamicButtonPanel.removeAll();
            dynamicButtonPanel.add(printedBooks);
            dynamicButtonPanel.add(audioBooks);
            dynamicButtonPanel.add(specialActions);
            dynamicButtonPanel.add(backButton);
            dynamicButtonPanel.revalidate();
            dynamicButtonPanel.repaint();

            // Show the dynamic view panel
            cardLayout.show(cardPanel, "dynamicPanel");
        });

        // SPECIAL ACTIONS BUTTON ACTION
        specialActions.addActionListener(e -> {
            // Clear the dynamic panel before adding new buttons
            dynamicButtonPanel.removeAll();

            // Buttons for special actions options
            JButton lastSixBooksButton = new JButton("Last six books");
            JButton genreCountButton = new JButton("Genre count");
            JButton totalCostOfAllBooks = new JButton("Total cost of all books");

            // Set button sizes
            lastSixBooksButton.setPreferredSize(new Dimension(150, 50));
            genreCountButton.setPreferredSize(new Dimension(150, 50));
            totalCostOfAllBooks.setPreferredSize(new Dimension(250, 50));

            // Add buttons to dynamic panel
            dynamicButtonPanel.add(lastSixBooksButton);
            dynamicButtonPanel.add(genreCountButton);
            dynamicButtonPanel.add(totalCostOfAllBooks);
            dynamicButtonPanel.add(backButton);

            // GENRE COUNT BUTTON
            genreCountButton.addActionListener(a -> {
                JOptionPane.showMessageDialog(null, "Genre count:" + Book.getNumberOfBooksByGenre());
            });

            // LAST SIX BOOKS BUTTON
            lastSixBooksButton.addActionListener(a -> {
                BookApp bookApp = new BookApp();
                JTextArea textArea = new JTextArea((bookApp.displayLastSixBooks()));
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 300)); // Set preferred size

                JOptionPane.showMessageDialog(null, scrollPane, "Last six books", JOptionPane.INFORMATION_MESSAGE);
            });

            // COST OF ALL BOOKS BUTTON
            totalCostOfAllBooks.addActionListener(a -> {
                JOptionPane.showMessageDialog(null, "Total cost: $" + Book.getTotalCost());
            });

            dynamicButtonPanel.revalidate();
            dynamicButtonPanel.repaint();
        });


        // PRINTED BOOKS BUTTON ACTION
        printedBooks.addActionListener(e -> {
            // Clear the dynamic panel before adding new buttons
            dynamicButtonPanel.removeAll();

            // Buttons for printed book options
            JButton averagePagesButton = new JButton("Average pages");
            JButton lastThreeBooksButton = new JButton("Last 3 books");
            JButton costOfAllPrintedBooksButton = new JButton("Total cost");

            // Set button sizes
            averagePagesButton.setPreferredSize(new Dimension(150, 50));
            lastThreeBooksButton.setPreferredSize(new Dimension(150, 50));
            costOfAllPrintedBooksButton.setPreferredSize(new Dimension(150, 50));

            // Add buttons to dynamic panel
            dynamicButtonPanel.add(averagePagesButton);
            dynamicButtonPanel.add(lastThreeBooksButton);
            dynamicButtonPanel.add(costOfAllPrintedBooksButton);
            dynamicButtonPanel.add(backButton);

            // AVERAGE PAGES ACTION
            averagePagesButton.addActionListener(a -> {
                JOptionPane.showMessageDialog(null, "Average pages: " + PrintedBook.getAveragePages());
            });

            // LAST THREE BOOKS ACTION
            lastThreeBooksButton.addActionListener(a -> {
                JTextArea textArea = new JTextArea(PrintedBook.getLastThreePrintedBooks());
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 300)); // Set preferred size

                JOptionPane.showMessageDialog(null, scrollPane, "Last Three Printed Books", JOptionPane.INFORMATION_MESSAGE);
            });

            // COST OF ALL PRINTED BOOKS BUTTON
            costOfAllPrintedBooksButton.addActionListener(a -> {
                JOptionPane.showMessageDialog(null, "Total cost: $" + PrintedBook.costOfAllPrintedBooks());
            });

            dynamicButtonPanel.revalidate();
            dynamicButtonPanel.repaint();
        });

        // AUDIO BOOKS ACTION BUTTON
        audioBooks.addActionListener(e -> {
            // Clear the dynamic panel before adding new buttons
            dynamicButtonPanel.removeAll();

            // Buttons for audio book options
            JButton averageLengthButton = new JButton("Average length");
            JButton lastThreeAudioBooksButton = new JButton("Last 3 books");
            JButton costOfAllAudioBooksButton = new JButton("Total cost");

            // Set button sizes
            averageLengthButton.setPreferredSize(new Dimension(150, 50));
            lastThreeAudioBooksButton.setPreferredSize(new Dimension(150, 50));
            costOfAllAudioBooksButton.setPreferredSize(new Dimension(150, 50));

            // Add buttons to dynamic panel
            dynamicButtonPanel.add(averageLengthButton);
            dynamicButtonPanel.add(lastThreeAudioBooksButton);
            dynamicButtonPanel.add(costOfAllAudioBooksButton);
            dynamicButtonPanel.add(backButton);

            // AVERAGE LENGTH ACTION
            averageLengthButton.addActionListener(a -> {
                JOptionPane.showMessageDialog(null, "Average length: " + AudioBook.getAverageLength());
            });

            // LAST THREE AUDIO BOOKS ACTION
            lastThreeAudioBooksButton.addActionListener(a -> {
                JTextArea textArea = new JTextArea(AudioBook.getLastThreeAudioBooks());
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 300)); // Set preferred size

                JOptionPane.showMessageDialog(null, scrollPane, "Last three audioBooks", JOptionPane.INFORMATION_MESSAGE);
            });

            // COST OF ALL AUDIO BOOKS ACTION
            costOfAllAudioBooksButton.addActionListener(a -> {
                JOptionPane.showMessageDialog(null, "Total cost: $" + AudioBook.costOfAllAudioBooks());
            });

            dynamicButtonPanel.revalidate();
            dynamicButtonPanel.repaint();
        });

        // BACK BUTTON ACTION
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "mainPanel"));

        // DELETE BOOK BUTTON
        deleteBook.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(deleteBook);

        // DELETE BUTTON ACTION
        deleteBook.addActionListener(e -> {
            String bookTitle = JOptionPane.showInputDialog(null, "Enter the title of the book you want to delete.");
            BookManager.deleteBook(bookTitle);
        });

        add(title, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}