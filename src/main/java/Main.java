import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {

        boolean isRunning = true;
        int choice;

        while (isRunning){

            System.out.println("**************");
            System.out.println("BANKING PROGRAM");
            System.out.println("**************");

            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Balance");
            System.out.println("4. Transfer Money");
            System.out.println("5. Create Account");
            System.out.println("6. Save Report to File");
            System.out.println("7. Exit");
            System.out.println("**************");

            System.out.print("Enter your choice (1-7)");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> deposit();
                case 2 -> withdraw();
                case 3 -> printAccounts();
                case 4 -> transfer();
                case 5 -> createAccount();
                case 6 -> saveReportToFile();
                case 7 -> {
                    System.out.println("Exiting Banking System!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
        scanner.close();

    }
    //****************************DEPOSIT*******************************************
    private static void deposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Invalid account number!");
        }
    }
    //****************************CREATE ACCOUNT*******************************************
    private static void createAccount() {
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine(); // Read account number

        System.out.println("Enter account holder name: ");
        String accountHolderName = scanner.nextLine(); // Read account holder name

        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        BankAccount account = new BankAccount(accountNumber, accountHolderName, balance);
        accounts.put(accountNumber, account); // Add account to the map

        System.out.println("Account created successfully!");
    }
    //****************************CHECK THE ACCOUNT*******************************************
    private static void printAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            accounts.values().forEach(System.out::println);
        }
    }
    //****************************WITHDRAW*******************************************
    private static void withdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
    //****************************TRANSFER*******************************************
    private static void transfer() {
        System.out.print("Enter sender's account number: ");
        String senderAccountNumber = scanner.nextLine();

        BankAccount sender = accounts.get(senderAccountNumber);
        if (sender != null) {
            System.out.print("Enter recipient's account number: ");
            String recipientAccountNumber = scanner.nextLine();

            BankAccount recipient = accounts.get(recipientAccountNumber);
            if (recipient != null) {
                System.out.print("Enter amount to transfer: ");
                double amount = scanner.nextDouble();
                sender.transfer(recipient, amount);
            } else {
                System.out.println("Recipient account not found.");
            }
        } else {
            System.out.println("Sender account not found.");
        }
    }
    //****************************SAVE TO A FILE*******************************************
    private static void saveReportToFile() {
        String defaultFileName = "accounts_report.txt"; // Default file name
        String filePath = System.getProperty("user.dir") + File.separator + defaultFileName; // Save in the current working directory

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (BankAccount account : accounts.values()) {
                writer.write(account.toString());
                writer.newLine();
            }
            System.out.println("Report saved successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }
}

