import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnItemWindow extends JFrame {
    public ReturnItemWindow() {
        this.getContentPane().setBackground(new Color(0x123456));
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Return an item");

        // Create a panel for content
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(new Color(0x123456));

        // Title label
        JLabel returnItemLabel = new JLabel("Enter item title to return", SwingConstants.CENTER);
        returnItemLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        returnItemLabel.setForeground(Color.GREEN);
        returnItemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // User ID Panel
        JPanel userIdPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        userIdPanel.setBackground(new Color(0x123456));

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        userIdLabel.setForeground(Color.WHITE);

        JTextField userIdField = new JTextField(20);
        userIdField.setFont(new Font("Tahoma", Font.PLAIN, 24));

        userIdPanel.add(userIdLabel);
        userIdPanel.add(userIdField);

        // Panel for input field (Title Label + TextField)
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setMaximumSize(new Dimension(200, 50));
        submitButton.setFocusable(false);

        // Add ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Library.getInstance().getUser(userIdField.getText()) == null) Library.getInstance().addUser(userIdField.getText());
                if (!Library.getInstance().isExistingItem(titleField.getText()) || Library.getInstance().isBorrowed(titleField.getText())) JOptionPane.showMessageDialog(ReturnItemWindow.this, "Item \"" + titleField.getText() + "\" not found or not borrowed!", "Error", JOptionPane.ERROR_MESSAGE);
                else JOptionPane.showMessageDialog(ReturnItemWindow.this, "Item \"" + titleField.getText() + "\" was successfully returned!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add components with spacing
        topPanel.add(Box.createVerticalStrut(30));
        topPanel.add(returnItemLabel);
        topPanel.add(Box.createVerticalStrut(15));
        topPanel.add(userIdPanel);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(inputPanel);
        topPanel.add(Box.createVerticalStrut(15));
        topPanel.add(submitButton);

        // Add top panel to the frame
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new ReturnItemWindow();
    }
}
