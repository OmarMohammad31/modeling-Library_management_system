import javax.swing.*;
import java.awt.*;

public class EnterItemData extends JFrame
{
    private JTextField titleField, authorField, isbnField;
    public String getTitle(){return titleField.getText();}
    public String getAuthor() {return authorField.getText();}
    public String getISBN() {return isbnField.getText();}
    public EnterItemData(){
        this.setTitle("Enter Item Data");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        //this.setLayout(new FlowLayout());
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel enterItemData = new JLabel("Enter Item Data");
        enterItemData.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 36));
        enterItemData.setForeground(Color.GREEN);
        enterItemData.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(enterItemData);
        this.add(Box.createVerticalStrut(20));

        JPanel itemDataPanel = new JPanel();
        itemDataPanel.setLayout(new BoxLayout(itemDataPanel, BoxLayout.Y_AXIS));
        itemDataPanel.setOpaque(false);
        itemDataPanel.setMaximumSize(new Dimension(600, 300));

        titleField = new JTextField(20);
        authorField = new JTextField(20);
        isbnField = new JTextField(20);

        itemDataPanel.add(createLabeledField("Title:",titleField));
        itemDataPanel.add(Box.createVerticalStrut(10)); // Spacing
        itemDataPanel.add(createLabeledField("Author:", authorField));
        itemDataPanel.add(Box.createVerticalStrut(10)); // Spacing
        itemDataPanel.add(createLabeledField("ISBN:", isbnField));
        itemDataPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createVerticalStrut(20));
        this.add(itemDataPanel);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(new Color(0x123456));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(e -> {
            String title = titleField.getText();
            String isbn = isbnField.getText();
            JOptionPane.showMessageDialog(this, "Item '" + title + "' added successfully with ISBN " + isbn);
        });
        this.add(submitButton);
        this.setVisible(true);
    }
    private JPanel createLabeledField(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Align fields left
        panel.setOpaque(false); // Transparent background

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Tahoma", Font.PLAIN, 24));
        label.setForeground(Color.WHITE);

        textField.setFont(new Font("Tahoma", Font.PLAIN, 24));

        panel.add(label);
        panel.add(textField);
        return panel;
    }
}
