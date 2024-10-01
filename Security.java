import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class Security extends Frame {

	private String username;
	private boolean priv;
	private Agent agt;
	private Panel user;
	TextArea stats = new TextArea();

	public Security(boolean priv, String username) {

		this.username = username;
		this.priv = priv;
		String version = "";
		if (priv == false) {
			version = "public";
		} else {
			version = "private";
		}
		print("Welcome " + username + ", you have picked the " + version
				+ " option for the investment trading app. Remember, buy low, sell high!");
		this.agt = new Agent();
		this.setLayout(new FlowLayout());

		Button viewPortfolio = new Button("Portfolio"); // This creates a button that allows you to view your portfolio.
		viewPortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				printClientInfo(0);
			}
		});
		this.add(viewPortfolio);
		this.setVisible(true);

		Button deposit = new Button("Deposit"); // This creates a button that allows you to deposit money to your
												// balance.
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();

				TextField field = new TextField("Input amount");
				acp.add(field);

				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							int depositAmount = Integer.parseInt(field.getText());
							deposit(username, depositAmount);
						} catch (Exception e) {
							print("Please input numbers only.");
						}
					}
				});
				acp.activate();
			}
		});
		this.add(deposit);

		Button withdraw = new Button("Withdraw"); // This creates a button that allows you to withdraw money from your
													// balance.
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();

				TextField field = new TextField("Input amount");
				acp.add(field);

				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							int withdrawAmount = Integer.parseInt(field.getText());
							withdraw(username, withdrawAmount);
						} catch (Exception e) {
							print("Please input numbers only.");
						}
					}
				});
				acp.activate();
			}
		});
		this.add(withdraw);

		Button buySecurity = new Button("Buy"); // This creates a button that allows you to buy assets from companies
												// such as Amazon or Tesla.
		buySecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();

				TextField field = new TextField("Input security");
				acp.add(field);
				TextField field2 = new TextField("Input amount");
				acp.add(field2);

				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String stock = field.getText().toString();
						try {
							double buySecurities = Double.parseDouble(field2.getText());
							buySecurity(stock, buySecurities);
						} catch (Exception e) {
							print("Please input numbers only.");
						}
					}
				});
				acp.activate();
			}
		});
		this.add(buySecurity);

		Button sellSecurity = new Button("Sell"); // This creates a button that allows you to sell assets from companies
													// such as Amazon or Tesla.
		sellSecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();

				TextField field = new TextField("Input security");
				acp.add(field);
				TextField field2 = new TextField("Input amount");
				acp.add(field2);

				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String stock = field.getText().toString();
						try {
							double sellSecurities = Double.parseDouble(field2.getText());
							sellSecurity(stock, sellSecurities);
						} catch (Exception e) {
							print("Please input numbers only.");
						}
					}
				});
				acp.activate();
			}
		});
		this.add(sellSecurity);

		Button sellAllSecurity = new Button("Sell all"); // This creates a button that allows you to sell all
															// your assets at once.
		sellAllSecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();

				TextField field = new TextField("Please confirm that you want to sell all securities that you own.");
				acp.add(field);
				field.setEditable(false);

				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						sellAllSecurity();
					}
				});
				acp.activate();
			}
		});
		this.add(sellAllSecurity);

		Button savePortfolio = new Button("Save portfolio"); // This creates a button that allows you to save your
																// portfolio onto a text file.
		savePortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userPortfolio(0);
			}
		});
		this.add(savePortfolio);
		this.setVisible(true);

		stats.setEditable(false);
		this.add(stats);

		user = new Panel();
		user.setLayout(new GridLayout(0, 1));
		user.setVisible(true);
		this.add(user);

		WindowCloser wc = new WindowCloser();
		this.addWindowListener(wc);

		this.setSize(600, 250);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addClient();
	}

	public void print(String text) {
		stats.setText(text);
	}

	public void deposit(String client, int depositAmount) {
		boolean found = agt.deposit(client, depositAmount, priv);
		if (found == false) {
			print("Error!");
		} else {
			print("Complete.");
		}
	}

	public void withdraw(String client, int withdrawAmount) {
		boolean found = agt.withdraw(client, withdrawAmount, priv);
		if (found == false) {
			print("Error!");
		} else {
			print("Complete.");
		}
	}

	public void buySecurity(String stock, double amount) {
		boolean found = agt.buySecurity(stock, amount, priv);
		if (found == false) {
			print("Error!");
		} else {
			print("Complete.");
		}
	}

	public void sellSecurity(String stock, double amount) {
		boolean found = agt.sellSecurity(stock, amount, priv);
		if (found == false) {
			print("Error!");
		} else {
			print("Complete.");
		}
	}

	public void sellAllSecurity() {
		agt.sellAllSecurity(priv);
	}

	public void printClientInfo(int index) {
		String text = agt.Portfolio(index, priv);
		print(text);
	}

	public void addClient() {
		agt.addClient(new Client(this.username, priv));
	}

	public void userPortfolio(int index) {
		try {
			FileWriter write = new FileWriter("savePortfolio.txt");
			write.write(agt.Portfolio(index, priv));
			write.close();
			print("Complete.");
		} catch (IOException e) {
			print("Error!");
			e.printStackTrace();
		}
	}
}