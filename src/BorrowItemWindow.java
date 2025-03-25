import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowItemWindow extends JFrame {
    public BorrowItemWindow() {
        this.getContentPane().setBackground(new Color(0x123456));
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Borrow an item");

        // Create a panel for content
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(new Color(0x123456));

        // Title label
        JLabel enterBorrowItem = new JLabel("Enter item title to borrow", SwingConstants.CENTER);
        enterBorrowItem.setFont(new Font("Tahoma", Font.PLAIN, 36));
        enterBorrowItem.setForeground(Color.GREEN);
        enterBorrowItem.setAlignmentX(Component.CENTER_ALIGNMENT);

        // User ID Panel
        JPanel userIdPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center aligned
        userIdPanel.setBackground(new Color(0x123456));

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        userIdLabel.setForeground(Color.WHITE);

        JTextField userIdField = new JTextField(20);
        userIdField.setFont(new Font("Tahoma", Font.PLAIN, 24));

        userIdPanel.add(userIdLabel);
        userIdPanel.add(userIdField);

        // Panel for input field (Title Label + TextField)
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center aligned
        inputPanel.setBackground(new Color(0x123456));

        JLabel textLabel = new JLabel("Title:");
        textLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        textLabel.setForeground(Color.WHITE);

        JTextField titleField = new JTextField(20);
        titleField.setFont(new Font("Tahoma", Font.PLAIN, 24));

        inputPanel.add(textLabel);
        inputPanel.add(titleField);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center it
        submitButton.setMaximumSize(new Dimension(200, 50)); // Set button size
        submitButton.setFocusable(false);

        //  Add ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Library.getInstance().getUser(userIdField.getText())==null) Library.getInstance().addUser(new LibraryUser(userIdField.getText()) );
                if (Library.getInstance().getUser(userIdField.getText()).borrowItem(titleField.getText())) {
                    JOptionPane.showMessageDialog(BorrowItemWindow.this, "Item \"" + titleField.getText() + "\" was successfully borrowed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else JOptionPane.showMessageDialog(BorrowItemWindow.this, "Item \"" + titleField.getText() + "\" not found!", "Error", JOptionPane.ERROR_MESSAGE);


            }
        });

        // Add components with spacing
        topPanel.add(Box.createVerticalStrut(30)); // Space above title
        topPanel.add(enterBorrowItem);
        topPanel.add(Box.createVerticalStrut(15)); // Space between title and input
        topPanel.add(userIdPanel); // Add User ID field first
        topPanel.add(Box.createVerticalStrut(10)); // Space between User ID and Title input
        topPanel.add(inputPanel); // Add Title field
        topPanel.add(Box.createVerticalStrut(15)); // Space before button
        topPanel.add(submitButton);

        // Add top panel to the frame
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);

        this.setVisible(true); // Display the frame
    }
}
