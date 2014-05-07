
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates the content of the panelRechtsUnten
 * Shows the Abonnements of the logged-in Nutzer
 * @author Max
 */
public class AbonnementInfo extends JPanel{

    private SocialMediaLogic server;
    private Nutzer clientNutzer = null;
    JLabel abonnementsOfNutzer = new JLabel("",JLabel.LEFT);
    JLabel abonnement = new JLabel("",JLabel.LEFT);

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

        try {
            abonnementsOfNutzer.setText("Abonnements von " + clientNutzer.getUsername());
        } catch (RemoteException ex) {
            Logger.getLogger(NutzerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.add(abonnementsOfNutzer);

    }


}
