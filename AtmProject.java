import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
public class AtmProject {
    private Account a = new Account("12345", 50000, 1234);
    private JFrame frame;
    public void atmSystem() {
        // Atm Frame and closing operation
        frame = new JFrame("ATM Machine");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // first phase panel
        JPanel loginPanel = new JPanel(new GridLayout(3,2));
        loginPanel.setBackground(Color.lightGray);
        // Border for all buttons
        Border border = new LineBorder(Color.BLACK, 1);
        // Account Number label
        JLabel accountLabel = new JLabel("Account Number:");
        accountLabel.setForeground(Color.BLACK);
        accountLabel.setFont(new Font(" Ariel ", Font.BOLD, 20));
        accountLabel.setBorder(border);
        // pin label
        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setForeground(Color.BLACK);
        pinLabel.setFont(new Font(" Ariel ", Font.BOLD, 20));
        pinLabel.setBorder(border);
        // Text fields for Account label
        JTextField accountField = new JTextField();
        accountField.setForeground(Color.black);
        accountField.setBackground(Color.WHITE);
        accountField.setBorder(border);
        // Text fields for pin label
        JPasswordField pinField = new JPasswordField();
        pinField.setForeground(Color.black);
        pinField.setBackground(Color.WHITE);
        pinField.setBorder(border);
        // login button
        JButton loginButton = new JButton("");
        loginButton.setBorder(border);
        ImageIcon imglogin = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\pngtree-login-button-png-image_6163957.png");
        Image img = imglogin.getImage();
        Image resizedImg = img.getScaledInstance(1000, 400, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        loginButton.setIcon(resizedIcon);
        // Exit button
        JButton ExitButton = new JButton("");
        ExitButton.setBorder(border);
        ImageIcon imgExit = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\images.png");
        Image img1 = imgExit.getImage();
        Image resizedImg1 = img1.getScaledInstance(1000, 400, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(resizedImg1);
        ExitButton.setIcon(resizedIcon1);
        // Action Listener for login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredAccountNumber = accountField.getText();
                int enteredPin = Integer.parseInt(new String(pinField.getPassword()));
                if (enteredAccountNumber.equals(a.getAccNumber()) && enteredPin == (a.getPin())) {
                    showMainMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid account number or PIN",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }}});
        // Action listener for exit button
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);}});
        // Addition of Labels, TextFields and buttons to panel
        loginPanel.add(accountLabel);
        loginPanel.add(accountField);
        loginPanel.add(pinLabel);
        loginPanel.add(pinField);
        loginPanel.add(loginButton);
        loginPanel.add(ExitButton);
        // Addition of the panel into the frame
        frame.add(loginPanel);
        frame.setVisible(true);}
    // Main Menu Method with Different Choices
    private void showMainMenu() {
        frame.getContentPane().removeAll();
        frame.repaint();
        // New panel for 2nd phase
        JPanel mainMenuPanel = new JPanel(new GridLayout(2, 1));
        mainMenuPanel.setBackground(Color.blue);
        // For Withdraw Button
        JButton withdrawButton = new JButton("Withdraw Money ");
        withdrawButton.setBackground(Color.RED);
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.setFont(new Font(" Times New Romen", Font.BOLD , 20));
        Border border = new LineBorder(Color.WHITE, 2);
        withdrawButton.setBorder(border);

        // For Deposit Button
        JButton depositButton = new JButton("Deposit Money");
        depositButton.setBackground(Color.GREEN);
        depositButton.setForeground(Color.WHITE);
        depositButton.setFont(new Font(" Times New Romen", Font.BOLD , 20));
        depositButton.setBorder(border);
        // For Transaction History Button
        JButton historyButton = new JButton("Transaction History");
        historyButton.setBackground(Color.PINK);
        historyButton.setForeground(Color.WHITE);
        historyButton.setFont(new Font(" Times New Romen", Font.BOLD, 20));
        historyButton.setBorder(border);
        // For Account Balance
        JButton balanceButton = new JButton(" Check Account Balance ");
        balanceButton.setBackground(Color.BLUE);
        balanceButton.setForeground(Color.WHITE);
        balanceButton.setFont(new Font("Ariel", Font.BOLD, 20));
        balanceButton.setBorder(border);
        // Action listeners
        // Action Listener for withdraw button
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter amount to withdraw:"));
                if (amount > 0) {
                    a.withdrawal(amount);}}});
        // Action Listener for deposit button
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter amount to deposit:"));
                if (amount > 0) {
                    a.deposit(amount);}}});
        // Action Listener for Transaction History button
        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTransactionHistory();}});
        //// Action Listener for Account Balance button
        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBalanceLabel();}});
        // Addition of all buttons into the panel
        mainMenuPanel.add(withdrawButton);
        mainMenuPanel.add(depositButton);
        mainMenuPanel.add(historyButton);
        mainMenuPanel.add(balanceButton);
        // Addition of panel into the frame
        frame.add(mainMenuPanel);
        frame.revalidate();}
    // updating balance label method
    private void updateBalanceLabel() {
        JOptionPane.showMessageDialog(frame, "Your Balance is: " + a.getBalance());}
    // show transaction history method
    private void showTransactionHistory() {
        // Creating table for type, amount, date, and time
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("Type");
        table.addColumn("Amount");
        table.addColumn("Date");
        table.addColumn("Time");
        // Adding the transactions in the table
        for (Transaction transaction : a.getTransactions()) {
            table.addRow(new Object[]{transaction.getType(), transaction.getAmount(), transaction.getDate(), transaction.getTime()});
        }

        // Create a JTable to display history in a table
        JTable table1 = new JTable(table);
        table1.setBackground(Color.GREEN);
        table1.setForeground(Color.black);

        // Show the table in a dialog box
        JOptionPane.showMessageDialog(frame, new JScrollPane(table1), "Transaction History", JOptionPane.INFORMATION_MESSAGE);
    }}