/*
 * Created on 08.11.2004
 *
 */

package de.hdm.rathke.bankInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import de.hdm.thies.bankProjekt.data.Account;
import de.hdm.thies.bankProjekt.data.Customer;

/**
 * Kontoformulare enthalten Felder für den Eigentümer, den Kontostand und den einzuzahlenden
 * oder abzuhebenden Geldbetrag. Für die Erzeugung, das Löschen und die Kontobewegungen existieren
 * jeweils Schaltflächen und Menüeinträge.
 * 
 * @author Christian Rathke
 */

public class Kontoformular {

    private DecimalFormat df = new DecimalFormat("##0.00#");
	private JTextField idText;
	private JTextField ownerText;
    private JFormattedTextField balanceText;
    private JFormattedTextField amountText;

	/**
	 * Das Setzen des Kontos bewirkt das Füllen der Formularfelder.
	 * @uml.property name="shownAccount"
	 */
	void setAccount(Account a) {
		if (a != null) {
			try {
				idText.setText(Integer.toString(a.getId()));
				balanceText.setText(df.format(a.getBalance()));
                amountText.setText("");
			} catch (RemoteException re) {
				System.out.println("RemoteException");
				System.out.println(re);
			}
		} else {
			removeAccount();
		}
	}
    
    /**
     * Der Text im Kontostandfeld wird mit den Daten des Kontos <code>a<code> aktualisiert.
     * @param a
     */
    void updateBalance(Account a){
        if (a!=null) {
            try {
                balanceText.setText(df.format(a.getBalance()));
            } catch (RemoteException re) {
                System.out.println("RemoteException");
                System.out.println(re);
            }
        } else {
            balanceText.setText("");
        }
    }
    

    /**
     * Das Entfernen des Kontos bewirkt das Löschen der Formularfelder.
     *
     */
	void removeAccount() {
        idText.setText("");
		ownerText.setText("");
		balanceText.setText("");
		amountText.setText("");
	}
    
    /**
     * Das Setzen des Kunden bewirkt das Füllen des Feldes zur Anzeige des Kontoinhabers.
     * @param c
     */
    void setCustomer(Customer c){
        try {
            ownerText.setText(c.getFirstName() + " " + c.getLastName());
        } catch (RemoteException re) {
            System.out.println("RemoteException");
            System.out.println(re);
        }
    }

    /**
     * Gibt den Inhalt des Betragfeldes als <code>float<code> zurück.
     * @return
     * @throws ParseException
     */
    float getAmount() throws ParseException {
            return df.parse(amountText.getText()).floatValue();
    }
    
    /**
     * Gibt die ID des Kontos als <code>int<code> zurück.
     * @return
     */
    int getId() {
        return Integer.parseInt(idText.getText());
    }

    /**
     * Erzeugt die Felder und Schaltflächen für das Kontoformular und gibt ein <code>JPanel<code>,
     * das diese Komponenten enthält zurück.
     * @param bi
     * @return
     */
	JPanel generateComponents(BankInterface bi) {
		JLabel id = new JLabel("Kontonummer", JLabel.TRAILING);
		idText = new JTextField(5);
		idText.setEditable(false);

		JLabel owner = new JLabel("Eigentümer", JLabel.TRAILING);
		ownerText = new JTextField(5);
		ownerText.setEditable(false);

		JLabel balance = new JLabel("Kontostand", JLabel.TRAILING);
		balanceText = new JFormattedTextField(df);
		balanceText.setEditable(false);

		JLabel amount = new JLabel("Betrag", JLabel.TRAILING);
		amountText = new JFormattedTextField(df);
        amountText.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		amountText.setEditable(true);
        amountText.setActionCommand("depositAmount");
        amountText.addActionListener(bi);

		JPanel fieldsPane = new JPanel(new SpringLayout());
		fieldsPane.add(id);
		fieldsPane.add(idText);
		fieldsPane.add(owner);
		fieldsPane.add(ownerText);
		fieldsPane.add(balance);
		fieldsPane.add(balanceText);
		fieldsPane.add(amount);
		fieldsPane.add(amountText);

		fieldsPane.setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(fieldsPane, 4, 2, 6, 6, 6, 6);

		JButton deposit = new JButton("Einzahlen");
        deposit.setActionCommand("depositAmount");
        deposit.addActionListener(bi);
        
		JButton withdraw = new JButton("Abheben");
        withdraw.setActionCommand("withdrawAmount");
		withdraw.addActionListener(bi);
        
        JButton delete = new JButton("Löschen");
        delete.setActionCommand("deleteAccount");
		delete.addActionListener(bi);
        
        JButton create = new JButton("Neu");
        create.setActionCommand("createAccount");
        create.addActionListener(bi);
        
		JPanel buttonPane = new JPanel();
		buttonPane.add(deposit);
		buttonPane.add(withdraw);
		buttonPane.add(delete);
		buttonPane.add(create);

		JPanel pane = new JPanel(new BorderLayout());
        pane.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createEmptyBorder(5, 5, 5, 5), BorderFactory
				.createTitledBorder(
						BorderFactory.createLineBorder(Color.black), "Konto")));
		pane.add(fieldsPane, BorderLayout.CENTER);
		pane.add(buttonPane, BorderLayout.SOUTH);
        
        return pane;
	}


}