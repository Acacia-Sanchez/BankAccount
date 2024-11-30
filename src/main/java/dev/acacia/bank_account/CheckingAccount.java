package dev.acacia.bank_account;

public class CheckingAccount extends Account {

    private float overdraft = 0.00f;  // importe en descubierto

    public CheckingAccount (float balance, float taePercent) {
        super(balance, taePercent);
        this.overdraft = overdraft;
    }

    public CheckingAccount() {
        super();
    }
    
    public float getOverdraft() {
        return overdraft;
    }
    public void setOverdraft(float overdraft) {
        this.overdraft = overdraft;
    }

    // Consignar: invoca al método heredado. Si hay sobregiro, la cantidad consignada reduce el sobregiro.
    @Override
    public void deposit(float amount) {
        if (getBalance() < 0) {
            setOverdraft(getBalance());
            super.setBalance(getBalance() + amount);
            System.out.println(String.format("Previous overdraft: %.2f | Now overdraft reduced: %.2f | New balance: %.2f", getOverdraft(), amount, getBalance()));
        } else {
            super.deposit(amount);
        }
    }

    // Retirar: se retira dinero de la cuenta actualizando su saldo. Se puede retirar dinero
    // superior al saldo. El dinero que se debe queda como sobregiro.
    @Override
    public void withdraw(float amount) {
        super.withdraw(amount);
        if (getBalance() < 0) {
            setOverdraft(getBalance());
            System.out.println(String.format("After withdraw: %.2f | Balance: %.2f | Now overdraft: %.2f", amount, getBalance(), getOverdraft()));
        }
    }

    // Extracto mensual: invoca al método heredado.
    @Override
    public void monthlyExtract(float monthlyComm) {
        super.monthlyExtract(monthlyComm);
    }

    // Un nuevo método imprimir que retorna el saldo de la cuenta, la comisión mensual, el número 
    // de transacciones realizadas (suma de cantidad de consignaciones y retiros) y el valor de sobregiro
    public void printCheckAcc(){
        System.out.println(String.format("Balance %.2f | Monthly commission: %.2f | Transactions: %d | Overdraft: %.2f",
                                        getBalance(), getMonthlyComm(), (getDepositCount() + getWithdrawCount()), getOverdraft()));
    }

}