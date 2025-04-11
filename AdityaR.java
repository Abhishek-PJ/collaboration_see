package programs;

import java.util.Scanner;

public class BankAccount {

    private String accountHolderName;
    private double balance;

    // Static variable to track total number of accounts
    private static int totalAccounts = 0;

    // Constructor Overloading

    // Default Constructor
    public BankAccount() {
        this("Unknown", 0.0); // Calls parameterized constructor
    }

    // Parameterized Constructor
    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++; // Increment total accounts
    }

    // Method Overloading

    // Deposit without message
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Deposit with message
    public void deposit(double amount, String message) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " (" + message + ")");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Debit (withdraw) without message
    public void debit(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Debited: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance to debit: " + amount);
        } else {
            System.out.println("Invalid debit amount.");
        }
    }

    // Debit (withdraw) with message
    public void debit(double amount, String message) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Debited: " + amount + " (" + message + ")");
        } else if (amount > balance) {
            System.out.println("Insufficient balance to debit: " + amount);
        } else {
            System.out.println("Invalid debit amount.");
        }
    }

    // Static method to display total accounts
    public static void displayTotalAccounts() {
        System.out.println("Total accounts: " + totalAccounts);
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an account using constructor overloading
        System.out.println("Enter account holder name:");
        String name = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(name, initialBalance);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Deposit with Message");
            System.out.println("4. Debit");
            System.out.println("5. Debit with Message");
            System.out.println("6. Display Total Accounts");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter message:");
                    String depositMessage = scanner.nextLine();
                    account.deposit(depositAmount, depositMessage);
                    break;
                case 4:
                    System.out.println("Enter amount to debit:");
                    double debitAmount = scanner.nextDouble();
                    account.debit(debitAmount);
                    break;
                case 5:
                    System.out.println("Enter amount to debit:");
                    debitAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter message:");
                    String debitMessage = scanner.nextLine();
                    account.debit(debitAmount, debitMessage);
                    break;
                case 6:
                    BankAccount.displayTotalAccounts();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
