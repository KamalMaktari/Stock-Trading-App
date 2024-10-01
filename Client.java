public class Client extends User {

    private PublicOption PublicOption;
    private PrivateOption PrivateOption;

    public Client(String username, boolean premium) {
        super(username);
        if (premium == false) {
            this.PublicOption = new PublicOption();
        } else {
            this.PrivateOption = new PrivateOption();
        }
    }

    public void deposit(double amount, boolean premium) {
        if (premium == false) {
            this.PublicOption.deposit(amount);
        } else {
            this.PrivateOption.deposit(amount);
        }
    }

    public void withdraw(double amount, boolean premium) {
        if (premium == false) {
            this.PublicOption.withdraw(amount);
        } else {
            this.PrivateOption.withdraw(amount);
        }
    }

    public double getBalance(boolean premium) {
        if (premium == false) {
            return this.PublicOption.getBalance();
        } else {
            return this.PrivateOption.getBalance();
        }
    }

    public double getAmazonSecurity(boolean premium) {
        if (premium == false) {
            return this.PublicOption.getAmazonSecurity();
        } else {
            return this.PrivateOption.getAmazonSecurity();
        }
    }

    public double getTeslaSecurity(boolean premium) {
        if (premium == false) {
            return this.PublicOption.getTeslaSecurity();
        } else {
            return this.PrivateOption.getTeslaSecurity();
        }
    }

    public void buyAmazonSecurity(double shares, boolean premium) {
        if (premium == false) {
            this.PublicOption.buyAmazonSecurity(shares);
        } else {
            this.PrivateOption.buyAmazonSecurity(shares);
        }
    }

    public void buyTeslaSecurity(double shares, boolean premium) {
        if (premium == false) {
            this.PublicOption.buyTeslaSecurity(shares);
        } else {
            this.PrivateOption.buyTeslaSecurity(shares);
        }
    }

    public void sellAmazonSecurity(double shares, boolean premium) {
        if (premium == false) {
            this.PublicOption.sellAmazonSecurity(shares);
        } else {
            this.PrivateOption.sellAmazonSecurity(shares);
        }
    }

    public void sellTeslaSecurity(double shares, boolean premium) {
        if (premium == false) {
            this.PublicOption.sellTeslaSecurity(shares);
        } else {
            this.PrivateOption.sellTeslaSecurity(shares);
        }
    }

    public void sellAllSecurities(boolean premium) {
        if (premium == false) {
            this.PublicOption.sellAllSecurity();
        } else {
            this.PrivateOption.sellAllSecurity();
        }
    }
}