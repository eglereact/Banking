import java.io.Serializable;

public class BankAccount implements Serializable {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(){}

    public BankAccount(String accountNumber, String accountHolderName, double balance){
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount){
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    public void printBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to " + targetAccount.getAccountHolderName());
        } else if (amount > balance) {
            System.out.println("Insufficient balance to transfer!");
        } else {
            System.out.println("Invalid transfer amount!");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Account Holder: " + accountHolderName + ", Balance: $" + balance;
    }

}
