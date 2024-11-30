package dev.acacia.bank_account;

public class SavingsAccount extends Account{
    
    private boolean active;

    public SavingsAccount(float balance, float taePercent) {
        super(balance, taePercent);
    }

    public SavingsAccount() {
        super();
        isActive();
    }

    public boolean isActive() {
        active = getBalance() >= 10_000.00f;
        if (!active) {
            System.out.println("Savings account is not active, because balance less than $10,000. Balance: " + getBalance());
        }
        return active;
    }

    @Override
    public void deposit(float amount) {
        if (isActive()) {
            super.deposit(amount);
        } else {
            throw new IllegalArgumentException("Error: Savings account is not active, because balance less than $10,000. Balance: " + getBalance());
        }
    }

    @Override
    public void withdraw(float amount) {
        if (isActive()) {
            super.withdraw(amount);
        } else {
            throw new IllegalArgumentException(
                "Error: Savings account is not active, because balance less than $10,000. Balance: " + getBalance());
        }
    }

    @Override
    public void monthlyExtract(float monthlyComm) {
        if (getWithdrawCount() > 4) {
            int commEachUp4 = 10_000;
            super.setMonthlyComm(commEachUp4 * (getWithdrawCount() - 4));
            System.out.println("A commission of: " + commEachUp4 + " will be applied after the 4th withdrawal of the month");
        }
        super.monthlyExtract(monthlyComm);

        if (!isActive()) {
            throw new IllegalArgumentException("Savings account is, from now, not active, due to balance under $10,000. Balance: " + getBalance());
        }
    }

    // Un nuevo método imprimir que retorna el saldo de la cuenta, la comisión mensual y el 
    // número de transacciones realizadas (suma de cantidad de consignaciones y retiros)
    public void printSavAcc() {
        System.out.println(String.format("Balance: %.2f | Monthly commission: %.2f | Number of transactions: %d", getBalance(), getMonthlyComm(), (getDepositCount() + getWithdrawCount())));
    }
}