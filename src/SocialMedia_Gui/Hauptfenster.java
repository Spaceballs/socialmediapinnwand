
package SocialMedia_Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Max
 */
public class Hauptfenster extends JFrame {

    public Hauptfenster(){
        
        JFrame frame = new JFrame("Social Media Pinnwand"); //Frame erzeugen
        
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


        //ActionListener Accountdaten ändern
        accountdaten.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               new DialogNutzer();
               
               //String username = JOptionPane.showInputDialog("Bitte geben Sie den neuen Usernamen ein:");
               //String name = JOptionPane.showInputDialog("Bitte geben Sie den neuen Nachnamen ein:");
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
        
        frame.setJMenuBar(menueLeiste); //Menueleiste zu Frame hinzufuegen

        JPanel panelLinks = new JPanel();
        JPanel panelRechts = new JPanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLinks, panelRechts);
        splitPane.setResizeWeight(0.7); //Position des Dividers relativ zu Framegroesse       
        splitPane.setEnabled(false); //Divider fixieren

        frame.getContentPane().add(splitPane);

        frame.pack(); //Komplettes Frame auf optimale Größe packen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //Frame an Bildschirmgroesse anpassen
        //frame.setSize(d);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null); //Position des Fensters
        frame.setVisible(true); //Anzeigen des Frames

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
