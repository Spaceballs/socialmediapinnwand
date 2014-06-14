
package SocialMedia_Gui;

import SocialMedia_IOandHelper.FormattedTextFieldVerifier;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import SocialMedia_Report.HTMLWriter;
import SocialMedia_ReportGenerator.ReportGenerator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Report Generator class for the graphical user interface.
 * Here the user can choose a report and order the generation of its content.
 * After that the report is opened in the standard html application.
 * @author Sebastian
 */
public class HauptfensterReport extends JFrame {
    private SocialMediaLogic server = null;
    private ReportGenerator reportGenerator = null;
    private JPanel initPanel;
    private JPanel contributionOfNutzerReportPanel;
    private JPanel contributionOfNutzerTextFieldPanel;
    private JPanel popularityOfBeitragReportPanel;
    private JPanel popularityOfBeitragTextFieldPanel;
    private JTabbedPane tabbedPane;
    private JComboBox<String> contributionOfNutzerReportPanelSortByBox;
    private int nutzerReportPanelSortByBox = 0;
    private final String[] data0 = {"Beiträge", "Likes", "Abonnenten"};
    private JComboBox<String> popularityOfBeitragReportPanelSortByBox;
    private int beitragReportPanelSortByBox = 0;
    private final String[] data1 = {"Likes", "Kommentare"};
    private JButton runNutzerReportButton;
    private JButton runBeitragReportButton;
    private JFormattedTextField calendarStartDateField;
    private JFormattedTextField calendarEndDateField;
    private JFormattedTextField calendarStartDateField0;
    private JFormattedTextField calendarEndDateField0;
    private final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy | kk:mm", Locale.GERMANY);

    /**
     * Constructor of the HauptfensterReport class.
     * The data displayed by this class is obtained from the server object.
     * @param server - The SocialMediaLogic reference is needed to get data and call the report generation methods.
     */
    public HauptfensterReport(SocialMediaLogic server) {
        this.server = server;
        initialize();
    }

    /**
     * Init method for the report generator main window.
     */
    private void initialize() {
        initListAndComboBox();
        initData();
        initPanel();
        initFrame();
    }

    /**
     * This method sets up the jlist and adds an selection listener to the list.
     * This listener sets, if selection occurs, the selected user for the report and sets the buttons <code>setEnabled(true)</code>.
     */
    private void initListAndComboBox() {
        //@todo - Alles mit nutzerliste kann glaube ich weg
        contributionOfNutzerReportPanelSortByBox = new JComboBox<String>(data0);
        contributionOfNutzerReportPanelSortByBox.setSelectedIndex(0);
        contributionOfNutzerReportPanelSortByBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nutzerReportPanelSortByBox = contributionOfNutzerReportPanelSortByBox.getSelectedIndex();
            }
        });
        popularityOfBeitragReportPanelSortByBox = new JComboBox<String>(data1);
        popularityOfBeitragReportPanelSortByBox.setSelectedIndex(0);
        popularityOfBeitragReportPanelSortByBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                beitragReportPanelSortByBox = popularityOfBeitragReportPanelSortByBox.getSelectedIndex();
            }
        });
    }
    
    /**
     * This Method sets the initial data for the report generator. 
     * This data is obtained from the server.
     */
    private void initData() {
        // @todo - Hier kann glaub auch was raus
        try {
            reportGenerator = server.getReportGenerator();
        } catch (RemoteException ex) {
            Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method sets up the frame of the window and its form, size and default behaviour.
     */
    private void initFrame() {
        this.setTitle("Report Generator");
        this.pack();
        this.setTitle("Report Generator");
        this.setResizable(false);
        this.setSize(new Dimension(400, 250));
        this.setLocationRelativeTo(null); // frame is at the center of the screen
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * The initPanel() method calls for the creation of the child panels and later creates the tabbed panel.
     * After that child panels are added to the tabbed panel.
     */
    private void initPanel() {
        tabbedPane = new JTabbedPane();
        initInitPanel();
        initContributionOfNutzerReportPanel();
        initPopularityOfBeitragReportPanel();
        tabbedPane.addTab("Start", initPanel);
        tabbedPane.addTab("Popularity of Users", contributionOfNutzerReportPanel);
        tabbedPane.addTab("Popularity of Articles", popularityOfBeitragReportPanel);
        this.add(tabbedPane);
        this.setVisible(true);
    }

    /**
     * In this method the initial panel for the tabbed panel is created.
     */
    private void initInitPanel() {
        initPanel = new JPanel();
        initPanel.setLayout(new BorderLayout());
        JLabel startLabel = new JLabel("Report Generator",JLabel.CENTER);
        startLabel.setFont(new Font("Arial", Font.BOLD, 28));
        initPanel.add(startLabel, BorderLayout.CENTER);
    }

    /**
     * In this method the panel for the ContributionOfNutzerReport is created.
     */
    private void initContributionOfNutzerReportPanel() {
        contributionOfNutzerReportPanel = new JPanel();
        contributionOfNutzerReportPanel.setLayout(new BorderLayout());
        
        contributionOfNutzerTextFieldPanel = new JPanel();
        contributionOfNutzerTextFieldPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 5, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        contributionOfNutzerTextFieldPanel.add(new JLabel("Start Date: "), c);        
        
        calendarStartDateField = new JFormattedTextField(df);
        calendarStartDateField.setText(df.format(new Date(new Date().getTime()-86400000)));
        calendarStartDateField.setInputVerifier(new FormattedTextFieldVerifier());
        calendarStartDateField.setPreferredSize(new Dimension(140, 20));
        
        c.gridx = 1;
        c.gridy = 0;
        contributionOfNutzerTextFieldPanel.add(calendarStartDateField, c);
        
        c.gridx = 0;
        c.gridy = 1;
        contributionOfNutzerTextFieldPanel.add(new JLabel("End Date: "), c);        
        
        calendarEndDateField = new JFormattedTextField(df);
        calendarEndDateField.setText(df.format(new Date()));
        calendarEndDateField.setInputVerifier(new FormattedTextFieldVerifier());
        calendarEndDateField.setPreferredSize(new Dimension(140, 20));
        
        c.gridx = 1;
        c.gridy = 1;
        contributionOfNutzerTextFieldPanel.add(calendarEndDateField, c);
        
        c.gridx = 0;
        c.gridy = 2;
        contributionOfNutzerTextFieldPanel.add(new JLabel("Sort by... "), c);
        
        c.gridx = 1;
        c.gridy = 2;
        contributionOfNutzerTextFieldPanel.add(contributionOfNutzerReportPanelSortByBox, c);
        
        contributionOfNutzerReportPanel.add(contributionOfNutzerTextFieldPanel, BorderLayout.CENTER);
        
        //@todo - ReportGeneratorImpl anpassen!!
        runNutzerReportButton = new JButton("Go!");
        runNutzerReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Date dateStart = df.parse(calendarStartDateField.getText());
                    Date dateEnd = df.parse(calendarEndDateField.getText());
                    HTMLWriter htmlWriter = new HTMLWriter(
                            reportGenerator.createContributionOfNutzerReport( 
                                    nutzerReportPanelSortByBox,
                                    dateStart, 
                                    dateEnd));
                } catch (RemoteException ex) {
                    Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        contributionOfNutzerReportPanel.add(runNutzerReportButton, BorderLayout.SOUTH); 
    }

    /**
     * In this method the panel for the PopularityOfBeitragReport is created.
     */
    private void initPopularityOfBeitragReportPanel() {
        popularityOfBeitragReportPanel = new JPanel();
        popularityOfBeitragReportPanel.setLayout(new BorderLayout());
        
        popularityOfBeitragTextFieldPanel = new JPanel();
        popularityOfBeitragTextFieldPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 5, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        popularityOfBeitragTextFieldPanel.add(new JLabel("Start Date: "), c);        
        
        calendarStartDateField = new JFormattedTextField(df);
        calendarStartDateField.setText(df.format(new Date(new Date().getTime()-86400000)));
        calendarStartDateField.setInputVerifier(new FormattedTextFieldVerifier());
        calendarStartDateField.setPreferredSize(new Dimension(140, 20));
        
        c.gridx = 1;
        c.gridy = 0;
        popularityOfBeitragTextFieldPanel.add(calendarStartDateField, c);
        
        c.gridx = 0;
        c.gridy = 1;
        popularityOfBeitragTextFieldPanel.add(new JLabel("End Date: "), c);        
        
        calendarEndDateField = new JFormattedTextField(df);
        calendarEndDateField.setText(df.format(new Date()));
        calendarEndDateField.setInputVerifier(new FormattedTextFieldVerifier());
        calendarEndDateField.setPreferredSize(new Dimension(140, 20));
        
        c.gridx = 1;
        c.gridy = 1;
        popularityOfBeitragTextFieldPanel.add(calendarEndDateField, c);
        
        c.gridx = 0;
        c.gridy = 2;
        popularityOfBeitragTextFieldPanel.add(new JLabel("Sort by... "), c);
        
        c.gridx = 1;
        c.gridy = 2;
        popularityOfBeitragTextFieldPanel.add(popularityOfBeitragReportPanelSortByBox, c);
        
        popularityOfBeitragReportPanel.add(popularityOfBeitragTextFieldPanel, BorderLayout.CENTER);
        
        runBeitragReportButton = new JButton("Go!");
        runBeitragReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Date dateStart = df.parse(calendarStartDateField0.getText());
                    Date dateEnd = df.parse(calendarEndDateField0.getText());
                    HTMLWriter htmlWriter = new HTMLWriter(
                            reportGenerator.createPopularityOfBeitragReport(
                                    beitragReportPanelSortByBox, 
                                    dateStart, 
                                    dateEnd));
                } catch (RemoteException ex) {
                    Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        popularityOfBeitragReportPanel.add(runBeitragReportButton, BorderLayout.SOUTH);
    }
}











