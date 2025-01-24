

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("12345", "John Doe", 100.0);
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.printBalance());
    }

    @Test
    void testWithdraw() {
        account.withdraw(70.0);
        assertEquals(30.0, account.printBalance());
    }

    @Test
    void testInsufficientFunds() {
        account.withdraw(200.0);
        assertEquals(100.0, account.printBalance());
    }

    @Test
    void testTransfer() {
        BankAccount targetAccount = new BankAccount("67890", "Jane Doe", 50.0);
        account.transfer(targetAccount, 50.0);
        assertEquals(50.0, account.printBalance());
        assertEquals(100.0, targetAccount.printBalance());
    }

    @Test
    void testInvalidTransfer() {
        BankAccount targetAccount = new BankAccount("67890", "Jane Doe", 50.0);
        account.transfer(targetAccount, 200.0);
        assertEquals(100.0, account.printBalance());
    }

}