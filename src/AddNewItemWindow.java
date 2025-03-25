import javax.swing.*;
import java.awt.*;

public class AddNewItemWindow extends JFrame
{
    public AddNewItemWindow(){
        this.setTitle("Add a new item");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel enterItemType = new JLabel("Enter Item Type");
        enterItemType.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 36));
        this.add(enterItemType);
        enterItemType.setHorizontalAlignment(JLabel.CENTER);
        enterItemType.setVerticalAlignment(JLabel.TOP);
        enterItemType.setForeground(Color.GREEN);
        enterItemType.setBounds(1000, 30, 900, 50);

        JButton physicalBook = new JButton("1. PhysicalBook");
        physicalBook.setBounds(100, 100, 200, 100);
        physicalBook.addActionListener(e -> {
            EnterItemData enterItemData = new EnterItemData(this); // Pass parent JFrame
            if (enterItemData.isSubmitted()) { // Ensure valid input
                PhysicalBook newBook = new PhysicalBook(
                        enterItemData.getTitle(),
                        enterItemData.getAuthor(),
                        enterItemData.getISBN()
                );
                Library.getInstance().addItem(newBook);

                // Show success message
                JOptionPane.showMessageDialog(this, "Item \"" + newBook.getTitle() + "\" with ISBN " + newBook.getISBN() + " was added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.add(physicalBook);

        JButton EBook = new JButton("2. EBook");
        EBook.setBounds(100, 200, 200, 100);
        EBook.addActionListener(e -> {
            EnterItemData enterItemData = new EnterItemData(this); // Pass parent JFrame
            if (enterItemData.isSubmitted()) { // Ensure valid input
                EBook newBook = new EBook(
                        enterItemData.getTitle(),
                        enterItemData.getAuthor(),
                        enterItemData.getISBN()
                );
                Library.getInstance().addItem(newBook);

                // Show success message
                JOptionPane.showMessageDialog(this, "Item \"" + newBook.getTitle() + "\" with ISBN " + newBook.getISBN() + " was added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.add(EBook);

        JButton ReferenceBook = new JButton("3. ReferenceBook");
        ReferenceBook.setBounds(100, 300, 200, 100);
        ReferenceBook.addActionListener(e -> {
            EnterItemData enterItemData = new EnterItemData(this); // Pass parent JFrame
            if (enterItemData.isSubmitted()) { // Ensure valid input
                ReferenceBook newBook = new ReferenceBook(
                        enterItemData.getTitle(),
                        enterItemData.getAuthor(),
                        enterItemData.getISBN()
                );
                Library.getInstance().addItem(newBook);

                // Show success message
                JOptionPane.showMessageDialog(this, "Item \"" + newBook.getTitle() + "\" with ISBN " + newBook.getISBN() + " was added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.add(ReferenceBook);

        JButton CD = new JButton("4. CD");
        CD.setBounds(100, 400, 200, 100);
        CD.addActionListener(e -> {
            EnterItemData enterItemData = new EnterItemData(this); // Pass parent JFrame
            if (enterItemData.isSubmitted()) { // Ensure valid input
                CD newBook = new CD(
                        enterItemData.getTitle(),
                        enterItemData.getAuthor(),
                        enterItemData.getISBN()
                );
                Library.getInstance().addItem(newBook);

                // Show success message
                JOptionPane.showMessageDialog(this, "Item \"" + newBook.getTitle() + "\" with ISBN " + newBook.getISBN() + " was added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.add(CD);

        JButton DVD = new JButton("5. DVD");
        DVD.setBounds(100, 500, 200, 100);
        DVD.addActionListener(e -> {
            EnterItemData enterItemData = new EnterItemData(this); // Pass parent JFrame
            if (enterItemData.isSubmitted()) { // Ensure valid input
                DVD newBook = new DVD(
                        enterItemData.getTitle(),
                        enterItemData.getAuthor(),
                        enterItemData.getISBN()
                );
                Library.getInstance().addItem(newBook);

                // Show success message
                JOptionPane.showMessageDialog(this, "Item \"" + newBook.getTitle() + "\" with ISBN " + newBook.getISBN() + " was added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.add(DVD);

        JButton journal = new JButton("6. Journal");
        journal.setBounds(100, 600, 200, 100);
        journal.addActionListener(e -> {
            EnterItemData enterItemData = new EnterItemData(this); // Pass parent JFrame
            if (enterItemData.isSubmitted()) { // Ensure valid input
                Journal newBook = new Journal(
                        enterItemData.getTitle(),
                        enterItemData.getAuthor(),
                        enterItemData.getISBN()
                );
                Library.getInstance().addItem(newBook);

                // Show success message
                JOptionPane.showMessageDialog(this, "Item \"" + newBook.getTitle() + "\" with ISBN " + newBook.getISBN() + " was added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.add(journal);

        JButton[] buttons = {physicalBook, EBook, ReferenceBook, CD, DVD, journal};

        Dimension buttonSize = new Dimension(200, 100);

        for (JButton button : buttons) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(buttonSize);
            button.setPreferredSize(buttonSize);
            button.setMinimumSize(buttonSize);
            this.add(Box.createVerticalStrut(10)); // Adds spacing between buttons
            this.add(button);
        }

        this.revalidate();
        this.repaint();
        this.setVisible(true);
        this.requestFocusInWindow(); //removes the focus from the first added button
    }
}