package dev.acacia.bank_account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    private SavingsAccount savAcc;
    
    @BeforeEach
    void setUp() {
        savAcc = new SavingsAccount(10_000.00f, 3.50f);
    }
    
    @Test
    void testAccountDefaultConstructor() {
        assertEquals(0.00f, savAcc.getBalance(), 10_000.00f);
        assertEquals(0.00f, savAcc.getTaePercent(), 3.50f);
    }
    
    @Test
    void testPrintSavAcc() {
        savAcc.printSavAcc();
        assertEquals(savAcc.getBalance(), 10_000.00f);
        assertEquals(savAcc.getMonthlyComm(), 0.00f);
    }

    @Test
    void testDeposit() {
        savAcc.deposit(500.00f);
        assertEquals(savAcc.getBalance(), 10_500.00f);
    }

    @Test
    void testIsActive() {
        savAcc.isActive();
        savAcc.setBalance(10_000.00f);
        assertTrue(savAcc.isActive());
    }

    @Test
    void testMonthlyExtract() {
        
    }

    @Test
    void testWithdraw() {
        savAcc.withdraw(100.00f);
        assertEquals(savAcc.getBalance(), 9_900.00f);
    }

}