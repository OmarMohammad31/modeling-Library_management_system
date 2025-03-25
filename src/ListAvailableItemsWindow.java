import javax.swing.*;
import java.awt.*;

public class ListAvailableItemsWindow extends JFrame
{
    public ListAvailableItemsWindow(){
        this.setTitle("Available items list");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setLayout(new FlowLayout());
        JLabel availableItemsLabel = new JLabel("Available items");
        availableItemsLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 36));
        availableItemsLabel.setForeground(Color.GREEN);
        this.add(availableItemsLabel);
    }
}
