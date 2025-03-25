import javax.swing.*;
import java.awt.*;

public class EnterItemData extends JFrame
{
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

        JPanel itemData = new JPanel();
        itemData.setLayout(new BoxLayout(itemData, BoxLayout.Y_AXIS));
        itemData.setOpaque(false);

        itemData.add(createLabeledField("Title:", 20));
        itemData.add(Box.createVerticalStrut(10)); // Spacing
        itemData.add(createLabeledField("Author:", 20));
        itemData.add(Box.createVerticalStrut(10)); // Spacing
        itemData.add(createLabeledField("ISBN:", 20));
        itemData.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemData.setMaximumSize(new Dimension(600, 300));
        this.add(itemData);
        //this.add(Box.createVerticalStrut(20));

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(new Color(0x123456));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(e -> {this.dispose();});
        this.add(submitButton);
        this.setVisible(true);
    }
    private JPanel createLabeledField(String labelText, int columns) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Align fields left
        panel.setOpaque(false); // Transparent background

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Tahoma", Font.PLAIN, 24));
        label.setForeground(Color.WHITE);

        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 24));

        panel.add(label);
        panel.add(textField);
        return panel;
    }
}
