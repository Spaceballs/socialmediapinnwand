/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author Max
 */
public class DialogNutzer {

    public DialogNutzer(){
        JFrame dialog = new JFrame("Accoundaten ändern");

        // GridBagLayout mit Abstand zwischen den Elementen.
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 5, 5);

        // Abstand nach außen erzeugen.
        //dialog.setBorder(new EmptyBorder(10, 10, 10, 10));

        c.gridx = 0;
        c.gridy = 0;
        dialog.add(new JLabel("Username:", JLabel.RIGHT), c);

        JTextField username = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        dialog.add(username, c);

        c.gridx = 0;
        c.gridy = 1;
        dialog.add(new JLabel("Nachname:", JLabel.RIGHT), c);

        JTextField name = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        dialog.add(name, c);

        c.gridx = 0;
        c.gridy = 2;
        dialog.add(new JLabel("Vorname:", JLabel.RIGHT), c);

        JTextField surname = new JTextField();
        c.gridx = 1;
        c.gridy = 2;
        dialog.add(surname, c);

        c.gridx = 0;
        c.gridy = 3;
        dialog.add(new JLabel("Passwort:", JLabel.RIGHT), c);

        JTextField password = new JTextField();
        c.gridx = 1;
        c.gridy = 3;
        dialog.add(password, c);


        JButton speichern = new JButton("Speichern");
        c.gridx = 1;
        c.gridy = 4;
        dialog.add(speichern, c);

        dialog.pack(); //Komplettes Frame auf optimale Größe packen
        //dialog.setSize(400,400);
        dialog.setLocationRelativeTo(null); //Position des Fensters
        dialog.setVisible(true); //Anzeigen des Frames

        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}
