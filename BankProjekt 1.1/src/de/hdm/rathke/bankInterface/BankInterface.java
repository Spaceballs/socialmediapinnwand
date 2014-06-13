/*
 * Created on 04.12.2005
 *
 */
package de.hdm.rathke.bankInterface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import de.hdm.thies.bankProjekt.data.Account;
import de.hdm.thies.bankProjekt.data.Customer;

/**
 * Hauptklasse des Bank-Interface.
 * @author Christian Rathke
 *
 */
public class BankInterface implements ActionListener, TreeSelectionListener {
    /**
     * 
     * @uml.property name="ic"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private InterfaceClient ic = new InterfaceClient();

    
    
    /**
     * 
     * @uml.property name="kuk"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private KundenUndKonten kuk = new KundenUndKonten();

    /**
     * 
     * @uml.property name="kof"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private Kontoformular kof = new Kontoformular();

    /**
     * 
     * @uml.property name="kuf"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private Kundenformular kuf = new Kundenformular();  

 
    JFrame frame;
    
    private Customer selectedCustomer = null;
    private Account selectedAccount = null;
    
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        BankInterface bi = new BankInterface();
        bi.generateComponents();
    }
    
    /**
     * Erzeugen der sichtbaren Komponenten.
     * Das Hauptfenster wird in drei Teile für den Kunden-und-Konten-Baum, die
     * Kundenangaben und die Kontoangaben unterteilt. Zusätzlich wird die Menü-
     * Erzeugung angestoßen.
     *
     */
    void generateComponents(){
        frame = new JFrame ("Bankanwendung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*
         * Für den Kunden-und-Konten-Baum wird zunächst die sichtbare Komponente erzeugt.
         * Danach wird diese mit den Inhalten erzeugt, die vom Applikationsserver geliefert
         * werden.
         */
        Component treePane = kuk.generateComponents(this);
        kuk.update(ic.getAllCustomersAndAccounts());
        
        Component kundenPane = kuf.generateComponents(this);
        Component kontenPane = kof.generateComponents(this);
        
        JSplitPane rightPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, kundenPane, kontenPane);        
        JSplitPane mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,treePane,rightPane);
        
        frame.getContentPane().add(mainPane, BorderLayout.CENTER);
        
        /*
         * Erzeugen der Menüstrukturen.
         */
        JMenuBar menuBar = new JMenuBar();
        generateMenus(menuBar);

        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(200, 20));
        frame.setJMenuBar(menuBar);
              
        frame.pack();
        frame.setVisible(true);  
    }


    /**
     * Das Setzen des ausgewählten Kunden wird an die Unterkomponenten weitergereicht.
     * @param c
     */
    private void setSelectedCustomer (Customer c){
        selectedCustomer = c;
        kuf.setCustomer(c);
        kof.setCustomer(c);
    }
    
    /**
     * Das Entfernen des ausgewählten Kunden wird an die Unterkomponenten weitergereicht.
     *
     */
    private void removeSelectedCustomer () {
        kuf.removeCustomer();
        kuk.removeCustomerTreeNode(selectedCustomer);
        selectedCustomer = null;
        
        kof.removeAccount();
        selectedAccount = null;
    }
    
    /**
     * Das Setzen des ausgewählten Kontos wird an die Unterkomponente weitergereicht.
     * @param a
     */
    private void setSelectedAccount (Account a) {
        selectedAccount = a;
        kof.setAccount(a);
    }
    
    /**
     * Das Löschen des ausgewählten Kontos wird an die Unterkomponente weitergereicht.
     *
     */
    private void removeSelectedAccount() {
        kof.removeAccount();
        kuk.removeAccountTreeNode(selectedAccount);
        selectedAccount = null;
        
        kof.setCustomer(selectedCustomer);
    }

    /**
     * Implementierung der vom Interface ActionListener geforderten Methode zur Reaktion
     * auf ActionEvents.
     */
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("changeCustomer")){
            if (selectedCustomer != null) {
                setSelectedCustomer(ic.modifyCustomer(selectedCustomer, kuf.getVorname(),kuf.getNachname()));
                kuk.modifyCustomerTreeNode(selectedCustomer);
            } else {
                JOptionPane.showMessageDialog(frame, "Kein Kunde ausgewählt!");
            }
            return;
        }
        
        if (e.getActionCommand().equals("createCustomer")) {
            System.out.println("Creating: Mathilda Mustermann.");
            setSelectedCustomer(ic.createCustomer("Mathilda", "Mustermann"));
            kuk.addCustomerTreeNode(new CustomerInfo(selectedCustomer));
            return;
        }
        
        if (e.getActionCommand().equals("deleteCustomer")) {
            if (selectedCustomer != null) {
                if (JOptionPane.showConfirmDialog(
                            frame,
                            "Soll " + kuf.getVorname() + " "
                                    + kuf.getNachname() + " wirklich gelöscht werden?",
                            "Bestätigung",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    ic.deleteCustomer(selectedCustomer);
                    removeSelectedCustomer();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Kein Kunde ausgewählt!");
            }
            return;
        }
        
        if (e.getActionCommand().equals("findCustomer")) {
            System.out.println("Finding: " + kuf.getVorname() + " "
                    + kuf.getNachname() + ".");
            Customer c = ic.findCustomer(kuf.getNachname());
            if (c != null){
                setSelectedCustomer(c);
                kuk.selectCustomerTreeNode(c);
            } else {
                JOptionPane.showMessageDialog(frame, "Kein Kunde gefunden!");
            }
            return;
        }
        
        if (e.getActionCommand().equals("depositAmount")) {
            if (selectedAccount != null) {
                float tmpValue;
                try {
                    tmpValue = kof.getAmount();
                    System.out.println("Adding: " + tmpValue + ".");
                    ic.modifyAccount(selectedAccount, tmpValue);
                    kof.updateBalance(selectedAccount);
                } catch (ParseException pe){
                    JOptionPane.showMessageDialog(frame, "Kein korrekter Betrag angegeben!");
                }               
            } else {
                JOptionPane.showMessageDialog(frame, "Kein Konto ausgewählt!");
            }
            return;
        }
        
        if (e.getActionCommand().equals("withdrawAmount")) {
            if (selectedAccount != null) {
                float tmpValue;
                try {
                    tmpValue= kof.getAmount();
                    System.out.println("Withdrawing: " + tmpValue + ".");
                    ic.modifyAccount(selectedAccount, -tmpValue);
                    kof.updateBalance(selectedAccount); 
                } catch (ParseException pe){
                    JOptionPane.showMessageDialog(frame, "Kein korrekter Betrag angegeben!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Kein Konto ausgewählt!");
            }
            return;
        }
        
        if (e.getActionCommand().equals("deleteAccount")) {
            if (selectedAccount != null) {
                if (JOptionPane.showConfirmDialog(frame, "Soll Konto "
                        + kof.getId() + " von " + kuf.getVorname() + " " + kuf.getNachname() 
                        + " wirklich gelöscht werden?", "Bestätigung",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    ic.deleteAccount(selectedAccount);
                    removeSelectedAccount();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Kein Konto ausgewählt!");
            }
            return;
        }
        
        if (e.getActionCommand().equals("createAccount")) {
            if (selectedCustomer != null){
                System.out.println("Creating Account for " + kuf.getVorname() + " " + kuf.getNachname() + ".");
                setSelectedAccount(ic.createAccountFor(selectedCustomer));
                kuk.addAccountTreeNode(new AccountInfo(selectedAccount));
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Kein Kunde ausgewählt!");
        }
    }
    
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = kuk.getLastSelectedPathComponent();
        if (node != null) {
            if (node.getUserObject() instanceof CustomerInfo) {
                setSelectedAccount(null);
                kuk.setSelectedAccountNode(null);

                CustomerInfo ci = (CustomerInfo)node.getUserObject();
                setSelectedCustomer(ci.getCustomer());
                kuk.setSelectedCustomerNode(node);

            } else {
                AccountInfo ai = (AccountInfo)node.getUserObject();
                setSelectedAccount(ai.getAccount());
                kuk.setSelectedAccountNode(node);
                
                node = (DefaultMutableTreeNode)node.getParent();
                CustomerInfo ci = (CustomerInfo)node.getUserObject();
                setSelectedCustomer(ci.getCustomer());
                kuk.setSelectedCustomerNode(node);
            }
        }
    }
   
    protected void generateMenus(JMenuBar menubar) {
        JMenu aktionenMenu = new JMenu("Aktionen");

        JMenuItem tmpMenuItem = new JMenuItem("Aktualisieren");
        tmpMenuItem.setActionCommand("Aktualisieren");
        tmpMenuItem.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e){
                if (e.getActionCommand().equalsIgnoreCase("Aktualisieren")){
                    kuf.removeCustomer();
                    kof.removeAccount();
                    kuk.update(ic.getAllCustomersAndAccounts());
                }
            }
        });
        aktionenMenu.add(tmpMenuItem);      
        
        tmpMenuItem = new JMenuItem("Beenden");
        tmpMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });    
        aktionenMenu.add(tmpMenuItem);
        
        menubar.add(aktionenMenu);
        
        
        
        JMenu kundeMenu = new JMenu("Kunde");

        tmpMenuItem = new JMenuItem("Ändern");
        tmpMenuItem.setActionCommand("changeCustomer");
        tmpMenuItem.addActionListener(this);
        kundeMenu.add(tmpMenuItem);
        
        tmpMenuItem = new JMenuItem("Neu");
        tmpMenuItem.setActionCommand("createCustomer");
        tmpMenuItem.addActionListener(this);
        kundeMenu.add(tmpMenuItem);
        
        tmpMenuItem = new JMenuItem("Löschen");
        tmpMenuItem.setActionCommand("deleteCustomer");
        tmpMenuItem.addActionListener(this);
        kundeMenu.add(tmpMenuItem);
        
        tmpMenuItem = new JMenuItem("Suchen");
        tmpMenuItem.setActionCommand("findCustomer");
        tmpMenuItem.addActionListener(this);
        kundeMenu.add(tmpMenuItem);
        
        menubar.add(kundeMenu);
        
        
        JMenu kontoMenu = new JMenu("Konto");
        
        tmpMenuItem = new JMenuItem("Einzahlen");
        tmpMenuItem.setActionCommand("depositAmount");
        tmpMenuItem.addActionListener(this);
        kontoMenu.add(tmpMenuItem);
        
        tmpMenuItem = new JMenuItem("Abheben");
        tmpMenuItem.setActionCommand("withdrawAmount");
        tmpMenuItem.addActionListener(this);
        kontoMenu.add(tmpMenuItem);
        
        tmpMenuItem = new JMenuItem("Neu");
        tmpMenuItem.setActionCommand("createAccount");
        tmpMenuItem.addActionListener(this);
        kontoMenu.add(tmpMenuItem);
        
        tmpMenuItem = new JMenuItem("Löschen");
        tmpMenuItem.setActionCommand("deleteAccount");
        tmpMenuItem.addActionListener(this);
        kontoMenu.add(tmpMenuItem);
        
        menubar.add(kontoMenu);

    }

}
