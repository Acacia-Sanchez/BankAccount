package dev.acacia.bank_account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(1_000.00f, 3.50f); // Inicializar la cuenta antes de cada test
    }
  
    @Test
    void testAccountDefaultConstructor() {
        Account account = new Account();
        assertEquals(0.00f, account.getBalance(), 0.001f); // 0.001f es la tolerancia permitida en las operaciones con float
        assertEquals(0.00f, account.getTaePercent(), 0.001f);
    }
    
    @Test
    void testDepositCount() {
        float amount = 100.00f;
        account.deposit(amount);
        float amount2 = 100.00f;
        account.deposit(amount2);
        assertTrue(account.getDepositCount() ==2);
    }

    @Test
    void testDepositBalance() {
        float amount = 100.00f;
        account.deposit(amount);
        assertTrue(account.getBalance() == 1_100.00f);
    }

    @Test
    void testWithdrawCount() {
        float amount = 100.00f;
        account.withdraw(amount);
        assertTrue(account.getWithdrawCount() == 1);
    }

    @Test
    void testCalcInterest() {
        account.calcInterest();
        assertEquals(account.getInterestAmount(), 2.9166667f);
    }

    @Test
    void testGetAndSetMonthlyComm() {
        float monthlyComm = 30.00f;
        account.setMonthlyComm(monthlyComm);
        assertEquals(account.getMonthlyComm(), monthlyComm);
    }

    @Test
    void testMonthlyExtract() {
        float monthlyComm = 30.00f;
        account.monthlyExtract(monthlyComm);
        assertEquals(account.getBalance(), 972.9167f);
    }

}