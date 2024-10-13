import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BookGUI extends JFrame {
    final int WIDTH = 500;
    final int HEIGHT = 400;

    // Constructor
    public BookGUI() {

        // MAIN FRAME
        setTitle("Book Tracker");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

        // MAIN PANEL
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // TITLE LABEL
        JLabel title = new JLabel("Book Tracker");
        title.setBounds(150, 50, 200, 30);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BUTTON PANEL
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // ADD BOOK BUTTON
        JButton addBook = new JButton("Add Book");
        addBook.setSize(150, 50);
        addBook.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(addBook);

        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookDetails = JOptionPane.showInputDialog(null, "Enter book (type, title, author, genre, cost, pages/length)");
                if (bookDetails != null && !bookDetails.trim().isEmpty()) {
                    // PRINTED BOOKS
                    if (bookDetails.split(",")[0].equalsIgnoreCase("printed")) {
                        String[] parts = bookDetails.split(",");

                        String title = parts[1].trim();
                        String author = parts[2].trim();
                        String genre = parts[3].trim();
                        double cost = Double.parseDouble(parts[4].trim());
                        double pages = Double.parseDouble(parts[5].trim());

                        new PrintedBook(title, author, genre, cost, pages);

                        JOptionPane.showMessageDialog(null, "Printed Book added: " + title);
                        // AUDIOBOOKS
                    } else if (bookDetails.split(",")[0].equalsIgnoreCase("audio")) {
                        String[] parts = bookDetails.split(",");

                        String title = parts[1].trim();
                        String author = parts[2].trim();
                        String genre = parts[3].trim();
                        double cost = Double.parseDouble(parts[4].trim());
                        double length = Double.parseDouble(parts[5].trim());

                        new AudioBook(title, author, genre, cost, length);

                        JOptionPane.showMessageDialog(null, "AudioBook added: " + bookDetails.split(",")[1]);
                    } else {
                        JOptionPane.showMessageDialog(null, "Something went wrong.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Empty input");
                }
            }
        });

        // ADD VIEW BOOK BUTTON
        JButton viewBook = new JButton("View Books");
        viewBook.setSize(150, 50);
        viewBook.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(viewBook);

        viewBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button Clicked!");
            }
        });

        // ADD DELETE BUTTON
        JButton deleteBook = new JButton("Delete Book");
        deleteBook.setSize(150, 50);
        deleteBook.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(deleteBook);

        deleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button Clicked!");
            }
        });

        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(buttonPanel);

        add(mainPanel);
    }
}