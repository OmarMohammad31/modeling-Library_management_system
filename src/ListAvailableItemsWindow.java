import javax.swing.*;
import java.awt.*;

public class ListAvailableItemsWindow extends JFrame
{
    public ListAvailableItemsWindow(){
        this.setTitle("Available items list");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setLayout(new BorderLayout());

        JLabel availableItemsLabel = new JLabel("Available Items", SwingConstants.CENTER);
        availableItemsLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        availableItemsLabel.setForeground(Color.GREEN);
        this.add(availableItemsLabel, BorderLayout.NORTH);

        JTextArea itemListArea = new JTextArea();
        itemListArea.setFont(new Font("Monospaced", Font.PLAIN, 24));
        itemListArea.setForeground(Color.WHITE);
        itemListArea.setBackground(new Color(0x123456));
        itemListArea.setEditable(false);

        StringBuilder itemListText = new StringBuilder();
        for (int i = 0,j=1; i < Library.getInstance().size(); i++) {
            if (Library.getInstance().getItem(i).isAvailable(Library.getInstance().getItem(i))){
                itemListText.append((j)).append(". ").append(Library.getInstance().getItem(i).getTitle()).append("\n");
                j++;
            }

        }
        itemListArea.setText(itemListText.toString());

        // Add JScrollPane in case of long lists
        JScrollPane scrollPane = new JScrollPane(itemListArea);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
