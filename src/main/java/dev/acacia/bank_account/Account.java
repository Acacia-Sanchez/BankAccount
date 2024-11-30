package dev.acacia.bank_account;

public class Account {
    protected float balance;
    protected int depositCount = 0;
    protected int withdrawCount = 0;
    protected float taePercent;
    protected float monthlyComm = 0.00f;
    protected float interestAmount = 0.00f;

    public Account (float balance, float taePercent) {
        setBalance(balance);
        setTaePercent(taePercent);
    }

    public Account() {
        this.balance = 0.00f;
        this.taePercent = 0.00f;
    }

    public float getBalance(){
        return balance;
    }
    public void setBalance(float balance){
        if (balance < 0.00f) {
            throw new IllegalArgumentException("Error: The initial balance can't be negative, and now is: " + balance);
        }
        this.balance = balance;
    }

    public int getDepositCount(){
        return depositCount;
    }
    public void setDepositCount(int depositCount){
        this.depositCount = depositCount;
    }

    public int getWithdrawCount(){
        return withdrawCount;
    }
    public void setWithdrawCount(int withdrawCount){
        this.withdrawCount = withdrawCount;
    }

    public float getTaePercent(){
        return taePercent;
    }
    public void setTaePercent(float taePercent) {
        if (taePercent <= 0.00f) {
            throw new IllegalArgumentException("Error: Tae percent must be greater than 0, and your Tae is: " + taePercent);
        }        
        this.taePercent = taePercent;
    }

    public float getMonthlyComm(){ 
        return monthlyComm;
    }
    public void setMonthlyComm(float monthlyComm){
        if (monthlyComm < 0.00f) {
            throw new IllegalArgumentException("Error: Monthly commission cannot be negative. Value: " + monthlyComm);
        }
        this.monthlyComm = monthlyComm;
    }

    public float getInterestAmount(){
        return interestAmount;
    }
    public void setInterestAmount(float interestAmount){
        this.interestAmount = interestAmount;
    }

    // Consignar una cantidad de dinero en la cuenta actualizando su saldo
    public void deposit (float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error: Deposit must be greater than 0. Your amount is: " + amount);
        }
        setDepositCount(getDepositCount() + 1); 
        setBalance(getBalance() + amount);
        System.out.println(String.format("Deposit number: %d | Deposit amount: %.2f | New balance: %.2f", getDepositCount(), amount, getBalance()));
    }
    
    // Retirar una cantidad de dinero en la cuenta actualizando su saldo. El valor a retirar no debe superar el saldo
    public void withdraw(float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error: Withdrawal must be greater than 0. Value: " + amount);
        } else if (amount > getBalance()) {
            throw new IllegalArgumentException(
                    String.format("Error: Withdrawn amount %.2f exceeds balance %.2f.", amount, getBalance()));
        }        
        setWithdrawCount(getWithdrawCount() + 1);
        setBalance(getBalance() - amount);
        System.out.println(String.format("Withdrawal number: %d | Withdrawal amount: %.2f | New balance: %.2f", getWithdrawCount(), amount, getBalance()));
    }

    // Calcular el interés mensual de la cuenta y actualiza el saldo correspondiente
    public void calcInterest() {
        setInterestAmount(getBalance() * ((getTaePercent()/12) / 100));
        setBalance(getBalance() + getInterestAmount());
        System.out.println(String.format("Annual TAE: %.2f | Monthly interests amount: %.2f | New balance: %.2f", getTaePercent(), getInterestAmount(), getBalance()));
    }

    // Extracto mensual: actualiza el saldo restándole la comisión mensual y calculando el interés mensual
    // correspondiente (invoca el método anterior)
    public void monthlyExtract (float monthlyComm) {
        calcInterest();
        interestAmount = getInterestAmount();
        setBalance(getBalance() - monthlyComm + getInterestAmount());
        System.out.println(String.format("Monthly interest: %.2f | Monthly commission: %.2f | New balance: %.2f", interestAmount, monthlyComm, getBalance()));
    }

    public void printAccount(){
        System.out.println(String.format("Balance: %.2f | Monthly commission: %.2f | Calculated interest: %.2f with TAE: %.2f| Number of deposits: %d | Number of withdrawals: %d", 
                                                    getBalance(), getMonthlyComm(), getInterestAmount(), getTaePercent(), getDepositCount() + getWithdrawCount()));
    }

} 