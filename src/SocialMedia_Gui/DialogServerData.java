
package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Client.SocialMediaReportClient;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

/**
 * Dialog where user inserts serverAdress, serverPort and clientPort
 * @author Sebastian
 */
public class DialogServerData extends JFrame implements ActionListener{
    
    private SocialMediaClient client = null;
    private SocialMediaReportClient rClient = null;    
    JTextField adresse = new JTextField();;
    JTextField serverPort = new JTextField();
    JTextField clientPort = new JTextField();
    JButton buttonUebernehmen = new JButton("Übernehmen");

    /**
     * Constructor
     * @param client
     * @param adresse
     * @param serverPort
     * @param clientPort
     */
    public DialogServerData(SocialMediaClient client, String adresse, String serverPort, String clientPort) {
        this.client = client;
        this.adresse.setText(adresse);
        this.serverPort.setText(serverPort);
        this.clientPort.setText(clientPort);
        initialize();
    }
    
    /**
     * Constructor
     * @param client
     * @param adresse
     * @param serverPort
     * @param clientPort
     */
    public DialogServerData(SocialMediaReportClient client, String adresse, String serverPort, String clientPort) {
        this.rClient = client;
        this.adresse.setText(adresse);
        this.serverPort.setText(serverPort);
        this.clientPort.setText(clientPort);
        initialize();
    }
    /**
     * Initializes the Dialog and the ActionListener of the Button
     */
    private void initialize() {
        initializeDialog();
        initializeListeners();
    }
    /**
     * Creates the Dialog with Labels, TextFields and Button
     */
    private void initializeDialog() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        this.add(new JLabel("Server Adresse:", JLabel.RIGHT), c);        
        c.gridx = 1;
        c.gridy = 0;
        this.add(adresse, c);
        
        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("Server Port:", JLabel.RIGHT), c);        
        c.gridx = 1;
        c.gridy = 1;
        this.add(serverPort, c);
        
        c.gridx = 0;
        c.gridy = 2;
        this.add(new JLabel("Client Port:", JLabel.RIGHT), c);        
        c.gridx = 1;
        c.gridy = 2;
        this.add(clientPort, c);      
                       
        c.gridx = 0;
        c.gridy = 3;
        this.add(buttonUebernehmen, c);

        JRootPane rootPane = this.getRootPane();
        rootPane.setDefaultButton(buttonUebernehmen);

        this.setTitle("Server Data");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * All required Listeners
     */
    private void initializeListeners() {
        //ActionListener Button Uebernehmen
        buttonUebernehmen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (client != null){
                    client.executeClient(adresse.getText(), serverPort.getText(), clientPort.getText());
                    dispose();
                }
                if(rClient != null){
                    rClient.executeClient(adresse.getText(), serverPort.getText(), clientPort.getText());
                    dispose();
                }

            }
        });
    }

    /**
     * UnsupportedOperationException
     * @param e - ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

