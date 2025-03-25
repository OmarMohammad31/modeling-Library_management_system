import javax.swing.*;
import java.awt.*;

public class EnterItemData extends JFrame
{
    public EnterItemData(){
        this.setTitle("Enter Item Data");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setLayout(new FlowLayout());

        JLabel enterItemData = new JLabel("Enter Item Data");
        enterItemData.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 36));
        enterItemData.setForeground(Color.GREEN);
        this.add(enterItemData);
    }
}
