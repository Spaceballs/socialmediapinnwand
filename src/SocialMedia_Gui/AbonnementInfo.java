
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Creates the content of the panelRechtsUnten
 * Shows the Abonnements of the logged-in Nutzer
 * @author Max
 */
public class AbonnementInfo extends JPanel{

    private SocialMediaLogic server;
    private Nutzer clientNutzer = null;
    private JLabel titleAbonnements = new JLabel("Abonnements",JLabel.LEFT);
    private Vector<Nutzer> abonnementNutzer = new Vector<Nutzer>();
    private AbonnementPanel abonnementPanel = new AbonnementPanel(server, clientNutzer, null);

    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public AbonnementInfo(SocialMediaLogic server, Nutzer clientNutzer){
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

        titleAbonnements.setFont(new Font("Arial", Font.BOLD, 28));
        this.add(titleAbonnements,BorderLayout.PAGE_START);
        
        this.add(abonnementPanel,BorderLayout.CENTER);
        
        try {
            Vector<Abonnement> abonnements = server.getAllAbonnementOfNutzer(clientNutzer);
            for (int i = 0; i < abonnements.size(); i++) {
                Abonnement abonnement = abonnements.elementAt(i);
                Nutzer nutzer = server.getOwnerOfPinnwandOfAbonnement(abonnement);
                System.out.println(nutzer.getUsername());
                
            }
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
