
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Max
 */
public class Hauptfenster extends JFrame {
    
    private SocialMediaLogic server;
    private Nutzer clientNutzer = null;
    private JMenuBar menueLeiste = new JMenuBar();
    private JMenu meinAccount = new JMenu("Mein Account");
    private JMenu menue = new JMenu("Menü");
    private JMenuItem newsfeed = new JMenuItem("Newsfeed"); //Untermenue erzeugen
    private JMenuItem meinePinnwand = new JMenuItem("Meine Pinnwand");
    private JMenuItem suchen = new JMenuItem("Nutzer suchen");
    private JMenuItem accountdaten = new JMenuItem("Accountdaten ändern");
    private JMenuItem abmelden = new JMenuItem("Abmelden");
    private JPanel panelLinks = new JPanel();
    private JPanel panelRechts = new JPanel();

    /**
     * 
     * @param server
     * @param clientNutzer 
     */
    public Hauptfenster(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initialize();
    }

    /**
     * 
     */
    private void initialize() {
        initalizeMenu();
        initalizeListeners();
        initalizePane();
    }

    /**
     * 
     */
    private void initalizeMenu() {
        //Menueleiste erzeugen
        menueLeiste.add(menue); //Menue zu Menueleiste hinzufuegen
        menueLeiste.add(meinAccount);
        menue.add(newsfeed); //Untermenue zum Menue hinzufuegen
        menue.add(meinePinnwand);
        menue.add(suchen);
        meinAccount.add(accountdaten);
        meinAccount.add(abmelden);
        this.setJMenuBar(menueLeiste); //Menueleiste zu Frame hinzufuegen
    }

    /**
     * 
     */
    private void initalizeListeners() {
        //ActionListener Nutzer suchen
        suchen.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               DialogSuchen dialogSuchen;
               dialogSuchen = new DialogSuchen(server);
           }
        });
        //ActionListener Accountdaten ändern
        accountdaten.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               DialogNutzer dialogNutzer;
               dialogNutzer = new DialogNutzer(server, clientNutzer);
           }
        });
        //ActionListener Abmelden
        abmelden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(Hauptfenster.this,
                        "Das Programm wirklich beenden?", "Beenden",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    System.exit(0);
                }
            }
        });
    }

    /**
     * 
     */
    private void initalizePane() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLinks, panelRechts);
        splitPane.setResizeWeight(0.7); //Position des Dividers relativ zu Framegroesse
        splitPane.setEnabled(false); //Divider fixieren

        this.getContentPane().add(splitPane);
        try {
            this.setTitle("Social Media von " + clientNutzer.getUsername());
        } catch (RemoteException ex) {
            Logger.getLogger(Hauptfenster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.pack(); //Komplettes Frame auf optimale Größe packen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //Frame an Bildschirmgroesse anpassen
        //frame.setSize(d);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null); //Position des Fensters
        this.setVisible(true); //Anzeigen des Frames
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
