import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int choice;
        BankAccount account1 = new BankAccount(500.0); // Initial balance
        BankAccount account2 = new BankAccount();



        while (isRunning){

            System.out.println("**************");
            System.out.println("BANKING PROGRAM");
            System.out.println("**************");

            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Balance");
            System.out.println("4. Transfer Money");
            System.out.println("5. Exit");
            System.out.println("**************");

            System.out.print("Enter your choice (1-5)");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter account number (1 or 2): ");
                    int accountChoice = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (accountChoice == 1) {
                        account1.deposit(depositAmount);
                    } else if (accountChoice == 2) {
                        account2.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid account number!");
                    }
                }
                case 2 -> {
                    System.out.print("Enter account number (1 or 2): ");
                    int accountChoice = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (accountChoice == 1) {
                        account1.withdraw(withdrawAmount);
                    } else if (accountChoice == 2) {
                        account2.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid account number!");
                    }
                }
                case 3 -> {
                    System.out.print("Enter account number (1 or 2): ");
                    int accountChoice = scanner.nextInt();
                    if (accountChoice == 1) {
                        account1.printBalance();
                    } else if (accountChoice == 2) {
                        account2.printBalance();
                    } else {
                        System.out.println("Invalid account number!");
                    }
                }
                case 4 -> {
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    System.out.print("Transfer from account (1 or 2): ");
                    int fromAccount = scanner.nextInt();
                    if (fromAccount == 1) {
                        account1.transfer(account2, transferAmount);
                    } else if (fromAccount == 2) {
                        account2.transfer(account1, transferAmount);
                    } else {
                        System.out.println("Invalid account number!");
                    }
                }
                case 5 -> {
                    System.out.println("Exiting Banking System!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }

        scanner.close();

    }
}