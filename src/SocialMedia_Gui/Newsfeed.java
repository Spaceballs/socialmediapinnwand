
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Creates the content of the panelLinks and
 * shows the Newsfeed (all Beitraege, Kommentare and Likes)
 * of all Abonnements of the logged-in Nutzer
 * @author Max
 */
public class Newsfeed extends JPanel {
    private SocialMediaLogic server;
    private Nutzer clientNutzer = null;
    JLabel newsfeed = new JLabel("Newsfeed",JLabel.LEFT);

    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public Newsfeed(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initialize();
    }

    /**
     * Gets the username, name and surname of the logged-in Nutzer,
     * puts in in a GridLayout and
     * changes the font.
     */
    private void initialize() {
        this.setLayout(new BorderLayout());
        EmptyBorder border = new EmptyBorder(20,20,20,20);
        this.setBorder(border);

        newsfeed.setFont(new Font("Arial", Font.BOLD, 48));
        this.add(newsfeed,BorderLayout.PAGE_START);
        
    }

}
