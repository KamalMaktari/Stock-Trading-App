import java.awt.*;
import java.awt.event.*;

public class InvestmentTradingApp extends Frame {

    public static void main(String[] args) {
        new InvestmentTradingApp();
    }

    public InvestmentTradingApp() {

        this.setLayout(new FlowLayout());

        Button Public = new Button("Public option"); // This creates a button that gives the option for public.
        Public.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Prompt acp = new Prompt();

                TextField text = new TextField("Input username");
                acp.add(text);

                acp.addSubmitListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String username = text.getText().toString();
                        new Security(false, username);
                        dispose();
                    }
                });
                acp.activate();
            }
        });
        this.add(Public);
        this.setVisible(true);

        Button Private = new Button("Private option"); // This creates a button that gives the option for private.
        Private.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Prompt acp = new Prompt();

                TextField text = new TextField("Input username");
                acp.add(text);

                acp.addSubmitListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String username = text.getText().toString();
                        new Security(true, username);
                        dispose();
                    }
                });
                acp.activate();
            }
        });
        this.add(Private);
        this.setVisible(true);

        WindowCloser wc = new WindowCloser();
        this.addWindowListener(wc);

        this.setSize(250, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}