package dev.acacia.bank_account;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void testCalcInterest() {

    }

    @Test
    void testDepositCount() {
        Account account = new Account(1_000.00f, 3.50f);
        account.deposit(100.00f);
        assertTrue(account.getDepositCount() == 1);
    }

    @Test
    void testDepositBalance() {
        Account account = new Account(1_000.00f, 3.50f);
        account.deposit(100.00f);
        assertTrue(account.getBalance() == 1_100.00f);
    }

/*     public void deposit (float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error: Deposit must be greater than 0. Your amount is: " + amount);
        }
        setDepositCount(getDepositCount() + 1); 
        setBalance(getBalance() + amount);
        System.out.println(String.format("Deposit number: %d | Deposit amount: %.2f | New balance: %.2f", getDepositCount(), amount, getBalance()));
    } */

    @Test
    void testGetBalance() {

    }

    @Test
    void testGetDepositCount() {

    }

    @Test
    void testGetInterestAmount() {

    }

    @Test
    void testGetMonthlyComm() {

    }

    @Test
    void testGetTaePercent() {

    }

    @Test
    void testGetWithdrawCount() {

    }

    @Test
    void testMonthlyExtract() {

    }

    @Test
    void testSetBalance() {

    }

    @Test
    void testSetDepositCount() {

    }

    @Test
    void testSetInterestAmount() {

    }

    @Test
    void testSetMonthlyComm() {

    }

    @Test
    void testSetTaePercent() {

    }

    @Test
    void testSetWithdrawCount() {

    }

    @Test
    void testWithdraw() {

    }
}
