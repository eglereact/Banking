public class BankAccount {

    private double balance;

    BankAccount(){
        this.balance = 0;
    }

    BankAccount(double balance){
        this.balance = balance;
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
            System.out.println("Transferred " + amount + " to target account.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance to transfer!");
        } else {
            System.out.println("Invalid transfer amount!");
        }
    }

}
