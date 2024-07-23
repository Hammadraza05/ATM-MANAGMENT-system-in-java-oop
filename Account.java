import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
class Account {
    // declaring instances
    String accountNumber;
    private double balance;
    private int pin;
    private List<Transaction> transactions;
    // Constructer of class account
    public Account(String accountNumber, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();}
    // getters to return all the instances
    public double getBalance() {
        return balance;}
    public int getPin() {
        return pin;}
    public String getAccNumber() {
        return accountNumber;}
    public List<Transaction> getTransactions() {
        return transactions;}
    // Methods using a parameter
    public void withdrawal(double withdraw) {
        if (withdraw > balance || withdraw < 0) {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount.", "Error", JOptionPane.ERROR_MESSAGE);}
        else {
            balance -= withdraw;
            transactions.add(new Transaction("Withdrawal", withdraw));
            JOptionPane.showMessageDialog(null, "Withdrawal successful. Your new balance is: " + balance);}}
    public void deposit(double deposit) {
        if (deposit >= 0) {
            balance += deposit;
            transactions.add(new Transaction("Deposit", deposit));
            JOptionPane.showMessageDialog(null, "Deposit successful. Your new balance is: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.", "Error", JOptionPane.ERROR_MESSAGE);}}}
