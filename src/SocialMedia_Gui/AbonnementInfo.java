
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

/**
 * Creates the content of the panelRechtsUnten
 * Shows the Abonnements of the logged-in Nutzer
 * @author Max
 */
public class AbonnementInfo extends JPanel{

    private SocialMediaLogic server;
    private Nutzer clientNutzer = null;
    private JLabel titleAbonnements = new JLabel("Abonnements",JLabel.LEFT);
    private JButton button1 = new JButton("Button 1");
    private Vector<Nutzer> abonnementNutzer = new Vector<Nutzer>();
    private JList abonnementList = new JList();

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

        Abonnement abonnement;



        try {
            Vector<Abonnement> abonnements = server.getAllAbonnementOfNutzer(clientNutzer);
            for (int i = 0; i < abonnements.size(); i++) {
                abonnement = abonnements.elementAt(i);
                AbonnementPanel abonnementPanel = new AbonnementPanel(server,clientNutzer,abonnement);
                abonnementList.add(abonnementPanel);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[][] rowData = {
            { "Japan", "245" }, { "USA", "240" }, { "Italien", "220" },
            { "Spanien", "217" }, {"Türkei", "215"} ,{ "England", "214" },
            { "Frankreich", "190" }, {"Griechenland", "185" },
            { "Deutschland", "180" }, {"Portugal", "170" }, {"Portugal", "170" }
            , {"Portugal", "170" }, {"Portugal", "170" }, {"Portugal", "170" }
            , {"Portugal", "170" }, {"Portugal", "170" }, {"Portugal", "170" }
            , {"Portugal", "170" }, {"Portugal", "170" }, {"Portugal", "170" }
            , {"Portugal", "170" }, {"Portugal", "170" }, {"Portugal", "170" }
            , {"Portugal", "170" }, {"Portugal", "170" }, {"Portugal", "170" }
            , {"Portugal", "170" }, {"Portugal", "170" }, {"Portugal", "170" }
            , {"Portugal", "170" }, {"Portugal", "170" }, {"Portugal", "170" }
            , {"Portugal", "170" }, {"Portugal", "170" }, {"Portugal", "170" }
            , {"Portugal", "170" }, {"Portugal", "170" }, {"Portugal", "170" }
        };

        String[] columnNames = {"",""};

        JTable table = new JTable(rowData,columnNames);
        table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(100);

        JScrollPane scrollPane = new JScrollPane(table);
        Dimension dim = new Dimension(0, 0);
        scrollPane.setPreferredSize(dim);

        this.add(scrollPane,BorderLayout.CENTER);
        this.setPreferredSize(dim);
    }
}
