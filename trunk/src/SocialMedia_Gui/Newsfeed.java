
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
    JLabel abonnement = new JLabel("",JLabel.LEFT);
    JButton button1 = new JButton("Button 1");

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

        String[] columnNames = {
          "Abonnierter Nutzer", "Gehe zu Pinnwand"
        };

        JTable table = new JTable(rowData,columnNames);
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(0).setPreferredWidth(150);
//        columnModel.getColumn(1).setPreferredWidth(50);

        JScrollPane scrollPane = new JScrollPane(table);
//        Dimension dim = new Dimension(50, 200);
//        scrollPane.setPreferredSize(dim);

        this.add(scrollPane,BorderLayout.CENTER);
    }

}
