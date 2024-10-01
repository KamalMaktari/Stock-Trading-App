import java.util.ArrayList;
import java.util.Iterator;

public class Agent {

	private ArrayList<Client> clients;

	public Agent() {
		clients = new ArrayList<Client>();
	}

	public int getNumberOfClients() {
		return clients.size();
	}

	public String Portfolio(int clientNumber, boolean premium) { // What is coded here is what will show up when you
																	// click on the portfolio button.

		Client c = clients.get(clientNumber);
		String text = "";

		text += "Username: " + c.getusername() + "\n";
		text += "Balance: " + c.getBalance(premium) + "\n\n";
		text += "Security: Amazon" + "\n";
		text += "Assets owned: " + c.getAmazonSecurity(premium) + "\n\n";
		text += "Security: Tesla" + "\n";
		text += "Assets owned: " + c.getTeslaSecurity(premium);
		return text;
	}

	public void addClient(Client c) {
		clients.add(c);
	}

	public boolean deposit(String clientName, int amount, boolean premium) {
		Iterator<Client> it = clients.iterator();
		boolean found = false;
		while (it.hasNext()) {
			Client c = it.next();
			if (c.getusername().equals(clientName)) {
				found = true;
				c.deposit(amount, premium);
			}
		}
		return found;
	}

	public boolean withdraw(String clientName, double amount, boolean premium) {
		Iterator<Client> it = clients.iterator();
		boolean found = false;
		while (it.hasNext()) {
			Client c = it.next();
			if (c.getusername().equals(clientName)) {
				if (amount <= c.getBalance(premium)) {
					found = true;
					c.withdraw(amount, premium);
				}
			}
		}
		return found;
	}

	public boolean buySecurity(String stockName, double amount, boolean premium) {
		Iterator<Client> it = clients.iterator();
		boolean found = false;
		while (it.hasNext()) {
			Client c = it.next();
			if ((stockName.equals("Amazon")) || (stockName.equals("amazon"))) {
				if (withdraw(c.getusername(), amount, premium) == true) {
					found = true;
					double shares = (amount / 25);
					c.buyAmazonSecurity(shares, premium);
				}
			} else if ((stockName.equals("Tesla")) || (stockName.equals("tesla"))) {
				if (withdraw(c.getusername(), amount, premium) == true) {
					found = true;
					double shares = (amount / 20);
					c.buyTeslaSecurity(shares, premium);
				}
			}
		}
		return found;
	}

	public boolean sellSecurity(String stockName, double amount, boolean premium) {
		Iterator<Client> it = clients.iterator();
		boolean found = false;
		while (it.hasNext()) {
			Client c = it.next();
			if ((stockName.equals("Amazon")) || (stockName.equals("amazon"))) {
				double shares = (amount / 25);
				if (shares <= c.getAmazonSecurity(premium)) {
					found = true;
					c.deposit(amount, premium);
					c.sellAmazonSecurity(shares, premium);
				}
			} else if ((stockName.equals("Tesla")) || (stockName.equals("tesla"))) {
				double shares = (amount / 20);
				if ((shares) <= c.getTeslaSecurity(premium)) {
					found = true;
					c.deposit(amount, premium);
					c.sellTeslaSecurity(shares, premium);
				}
			}
		}
		return found;
	}

	public void sellAllSecurity(boolean premium) {
		Iterator<Client> it = clients.iterator();
		Client c = it.next();
		c.sellAllSecurities(premium);
	}
}