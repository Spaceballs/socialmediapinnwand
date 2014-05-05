
package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Max
 */
public class Hauptfenster extends JFrame {
    
    private SocialMediaLogic server;

    public Hauptfenster(SocialMediaLogic server, Nutzer clientNutzer){
        this.server = server;
        initialize();
    }

    private void initialize() {
        JMenuBar menueLeiste = new JMenuBar(); //Menueleiste erzeugen

        JMenu menue = new JMenu("Menü"); //Menue erzeugen
        menueLeiste.add(menue); //Menue zu Menueleiste hinzufuegen

        JMenu meinAccount = new JMenu("Mein Account");
        menueLeiste.add(meinAccount);


        JMenuItem newsfeed = new JMenuItem("Newsfeed"); //Untermenue erzeugen
        menue.add(newsfeed); //Untermenue zum Menue hinzufuegen

        JMenuItem meinePinnwand = new JMenuItem("Meine Pinnwand");
        menue.add(meinePinnwand);

        JMenuItem suchen = new JMenuItem("Nutzer suchen");
        menue.add(suchen);


        JMenuItem accountdaten = new JMenuItem("Accountdaten ändern");
        meinAccount.add(accountdaten);

        JMenuItem abmelden = new JMenuItem("Abmelden");
        meinAccount.add(abmelden);


        //ActionListener Nutzer suchen
        suchen.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               new DialogSuchen(server);
           }
        });



        //ActionListener Accountdaten ändern
        accountdaten.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               new DialogNutzer(server);
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

        this.setJMenuBar(menueLeiste); //Menueleiste zu Frame hinzufuegen

        JPanel panelLinks = new JPanel();
        JPanel panelRechts = new JPanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLinks, panelRechts);
        splitPane.setResizeWeight(0.7); //Position des Dividers relativ zu Framegroesse
        splitPane.setEnabled(false); //Divider fixieren

        this.getContentPane().add(splitPane);

        this.setTitle("Social Media Pinnwand");
        this.pack(); //Komplettes Frame auf optimale Größe packen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //Frame an Bildschirmgroesse anpassen
        //frame.setSize(d);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null); //Position des Fensters
        this.setVisible(true); //Anzeigen des Frames

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
