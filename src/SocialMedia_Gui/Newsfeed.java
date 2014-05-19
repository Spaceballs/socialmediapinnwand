
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
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
    private JLabel newsfeedLabel = new JLabel("Newsfeed");
    private BeitragPanel beitragPanel = new BeitragPanel(server, clientNutzer, null);
    private KommentarPanel kommentarPanel = new KommentarPanel(server, clientNutzer, null);
    private JButton beitragVerfassen = new JButton("Neuer Beitrag");
    private JPanel header = new JPanel();

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

        newsfeedLabel.setFont(new Font("Arial", Font.BOLD, 48));
        
        header.setLayout(new GridBagLayout());
        GridBagConstraints gridBagLayout = new GridBagConstraints();
        gridBagLayout.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.anchor = GridBagConstraints.WEST;
//        gridBagLayout.insets = new Insets(5, 5, 5, 5);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        header.add(newsfeedLabel, gridBagLayout);
        
//        gridBagLayout.gridx = 1;
//        gridBagLayout.gridy = 1;
//        header.add(beitragVerfassen, gridBagLayout);
        
        this.add(header,BorderLayout.NORTH);
        
        this.add(beitragPanel,BorderLayout.CENTER);
    }

}
