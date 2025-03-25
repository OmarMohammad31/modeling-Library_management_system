import javax.swing.*;
import java.awt.*;

public class EnterItemData extends JDialog {
    private JTextField titleField, authorField, isbnField;
    private String title, author, isbn;
    private boolean submitted = false;

    public EnterItemData(JFrame parent) {
        super(parent, "Enter Item Data", true);
        this.setSize(600, 400);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x0A2A4A)); // Dark Blue Background
        this.setLocationRelativeTo(parent);

        // Title Label
        JLabel titleLabel = new JLabel("Enter Item Data");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setBounds(200, 20, 300, 40);
        add(titleLabel);

        // Input Fields
        JLabel titleText = new JLabel("Title:");
        titleText.setForeground(Color.WHITE);
        titleText.setBounds(100, 80, 100, 30);
        add(titleText);

        titleField = new JTextField();
        titleField.setBounds(200, 80, 250, 30);
        add(titleField);

        JLabel authorText = new JLabel("Author:");
        authorText.setForeground(Color.WHITE);
        authorText.setBounds(100, 130, 100, 30);
        add(authorText);

        authorField = new JTextField();
        authorField.setBounds(200, 130, 250, 30);
        add(authorField);

        JLabel isbnText = new JLabel("ISBN:");
        isbnText.setForeground(Color.WHITE);
        isbnText.setBounds(100, 180, 100, 30);
        add(isbnText);

        isbnField = new JTextField();
        isbnField.setBounds(200, 180, 250, 30);
        add(isbnField);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 250, 100, 40);
        submitButton.addActionListener(e -> {
            title = titleField.getText().trim();
            author = authorField.getText().trim();
            isbn = isbnField.getText().trim();

            if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            submitted = true;
            this.dispose(); // Close Window
        });
        add(submitButton);

        this.setVisible(true);
    }

    // Getters
    public boolean isSubmitted() { return submitted; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return isbn; }
}
