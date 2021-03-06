
package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Client.SocialMediaReportClient;
import java.awt.Dimension;
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
public class DialogServerData extends JFrame{
    
    private SocialMediaClient client = null;
    private SocialMediaReportClient rClient = null;    
    JTextField adresse;
    JTextField serverPort;
    JTextField clientPort;
    JButton buttonUebernehmen = new JButton("Übernehmen");

    /**
     * Constructor for the SocialMediaClient
     * @param client - the client
     * @param adresse - adress of the server
     * @param serverPort - port of the server
     * @param clientPort - port of the client
     */
    public DialogServerData(SocialMediaClient client, String adresse, String serverPort, String clientPort) {
        this.client = client;
        this.adresse = new JTextField(adresse);
        this.adresse.setPreferredSize(new Dimension(140, 20));
        this.serverPort = new JTextField(serverPort);
        this.clientPort = new JTextField(clientPort);
        initialize();
    }
    
    /**
     * Constructor for the SocialMediaReportClient
     * @param client - the client
     * @param adresse - adress of the server
     * @param serverPort - port of the server
     * @param clientPort - port of the client
     */
    public DialogServerData(SocialMediaReportClient client, String adresse, String serverPort, String clientPort) {
        this.rClient = client;
        this.adresse = new JTextField(adresse);
        this.adresse.setPreferredSize(new Dimension(140, 20));
        this.serverPort = new JTextField(serverPort);
        this.clientPort = new JTextField(clientPort);
        initialize();
    }
    
    /**
     * Initializes the needed operations
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
        c.gridwidth = 1;
        this.add(new JLabel("Server Adresse:", JLabel.RIGHT), c); 
        
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        this.add(adresse, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        this.add(new JLabel("Server Port:", JLabel.RIGHT), c);   
        
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        this.add(serverPort, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(new JLabel("Client Port:", JLabel.RIGHT), c);        
        
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        this.add(clientPort, c);      
                       
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        this.add(buttonUebernehmen, c);

        JRootPane rootPane = this.getRootPane();
        rootPane.setDefaultButton(buttonUebernehmen);

        this.setTitle("Server Data");
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Initializes the Actionlistener
     */
    private void initializeListeners() {
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
}

