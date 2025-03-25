import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends javax.swing.JFrame
{
    public GUI(){
        this.setTitle("Library Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exits the app when exiting the GUI
        this.setSize(1920, 1080); //window size
        this.getContentPane().setBackground(new Color(0x123456));//window color
        this.setLayout(null);

        JLabel welcome = new JLabel("Welcome to the Library Management System!");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setVerticalAlignment(JLabel.TOP);
        welcome.setForeground(Color.GREEN);
        welcome.setBounds(300, 30, 900, 50);
        welcome.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 36));
        this.add(welcome);

        JButton addNewItem = new JButton("1. Add a New Item");
        addNewItem.setBounds(100, 100, 200, 100);
        addNewItem.addActionListener(e -> new AddNewItemWindow().setVisible(true));
        this.add(addNewItem);

        JButton listAvailableItems = new JButton("2. List Available Items");
        listAvailableItems.setBounds(100, 200, 200, 100);
        listAvailableItems.addActionListener(e -> new ListAvailableItemsWindow().setVisible(true));
        this.add(listAvailableItems);

        JButton borrowItem = new JButton("3. Borrow an Item");
        borrowItem.setBounds(100, 300, 200, 100);
        borrowItem.addActionListener(e -> new BorrowItemWindow().setVisible(true));
        this.add(borrowItem);

        JButton returnItem = new JButton("4. Return an Item");
        returnItem.setBounds(100, 400, 200, 100);
        returnItem.addActionListener(e -> new ReturnItemWindow().setVisible(true));
        this.add(returnItem);

        JButton exit = new JButton("5. Exit");
        exit.setBounds(100, 500, 200, 100);
        exit.addActionListener(e -> System.exit(0));
        this.add(exit);

        this.revalidate();
        this.repaint();
        this.setVisible(true);
        this.requestFocusInWindow(); //removes the focus from the first added button
    }
}