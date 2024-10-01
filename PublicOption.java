public class PublicOption extends sellAllSecurity {

    private double balance;
    private double AmazonSecurity;
    private double TeslaSecurity;

    public PublicOption() {
        this.balance = 0;
        this.AmazonSecurity = 0;
        this.TeslaSecurity = 0;
    }

    public PublicOption(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public double getAmazonSecurity() {
        return this.AmazonSecurity;
    }

    public double getTeslaSecurity() {
        return this.TeslaSecurity;
    }

    public void buyAmazonSecurity(double amount) {
        this.AmazonSecurity += amount;
    }

    public void buyTeslaSecurity(double amount) {
        this.TeslaSecurity += amount;
    }

    public void sellAmazonSecurity(double amount) {
        this.AmazonSecurity -= amount;
    }

    public void sellTeslaSecurity(double amount) {
        this.TeslaSecurity -= amount;
    }

    public void sellAllSecurity() {
        this.balance += (25 * this.AmazonSecurity);
        this.balance += (20 * this.TeslaSecurity);
        this.AmazonSecurity = 0;
        this.TeslaSecurity = 0;
    }

    public String toString() {
        return "Balance: " + this.balance;
    }
}