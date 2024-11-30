package dev.acacia.bank_account;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

    private CheckingAccount checkAcc;

    @BeforeEach
    void setUp() {
        checkAcc = new CheckingAccount(-5_000, 3.50f);
    }
    
    @Test
    void testDeposit() {
        checkAcc.deposit(500.00f);
        assertEquals(checkAcc.getBalance(), -4_500.00f);
    }

    @Test
    void testMonthlyExtract() {
        float monthlyComm = 30.00f;
        checkAcc.monthlyExtract(monthlyComm);
        assertEquals(checkAcc.getBalance(), -5_044.5835f);
    }
    @Test
    void testPrintCheckAcc() {

    }

    @Test
    void testWithdraw() {
        checkAcc.withdraw(100.00f);
        assertEquals(checkAcc.getBalance(), -4_900.00f);
    }
}