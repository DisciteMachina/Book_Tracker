import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BookGUI extends JFrame {
    final int WIDTH = 500;
    final int HEIGHT = 400;

    // Scale image
    ImageIcon originalInputIcon = new ImageIcon("resources/open-book.png");
    Image scaledOriginalIcon = originalInputIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon inputIcon = new ImageIcon(scaledOriginalIcon);

    ImageIcon originalConfirmationIcon = new ImageIcon("resources/book.png");
    Image scaledConfirmationIcon = originalConfirmationIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon confirmationIcon = new ImageIcon(scaledConfirmationIcon);

    public BookGUI() {
        // MAIN FRAME
        setTitle("My JFrame Window");
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
                JTextField bookTitleField = new JTextField(20);

                JPanel inputPanel = new JPanel();
                inputPanel.add(new JLabel("Enter book details, (title, author, genre, cost, pages"));
                inputPanel.add(bookTitleField);

                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Add Book", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, inputIcon);
                if (result == JOptionPane.OK_OPTION) {
                    String bookTitle = bookTitleField.getText();
                    if (bookTitle != null && !bookTitle.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Book added: " + bookTitle, "Confirmation", JOptionPane.INFORMATION_MESSAGE, confirmationIcon);
                    } else {
                        JOptionPane.showMessageDialog(null, "No book title entered!");
                    }
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