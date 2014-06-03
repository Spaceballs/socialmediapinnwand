
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import SocialMedia_Report.HTMLWriter;
import SocialMedia_Report.Report;
import SocialMedia_ReportGenerator.ReportGenerator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Report Generator class for the graphical user interface.
 * Here the user can choose a report and order the generation of its content.
 * After that the report is opened in the standard html application.
 * @author Sebastian
 */
public class HauptfensterReport extends JFrame {
    
    private Nutzer reportUser = null;
    private SocialMediaLogic server = null;
    private ReportGenerator reportGenerator = null;
    private JPanel initPanel;
    private JPanel contributionOfNutzerReportPanel;
    private JPanel popularityOfBeitragReportPanel;
    private JTabbedPane tabbedPane;
    private JList<Nutzer> nutzerliste;
    private JComboBox contributionOfNutzerReportPanelSortByBox;
    private String[] data0 = {"Beiträge", "Likes", "Abonnenten"};
    private JComboBox popularityOfBeitragReportPanelSortByBox;
    private String[] data1 = {"Likes", "Kommentare"};
    private ScrollPane nutzerlisteScrollPane;
    private JButton runNutzerReportButton;
    private JButton runBeitragReportButton;
    private JFormattedTextField calendarStartDateField;
    private JFormattedTextField calendarEndDateField;
    private final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);

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
        initFrame();
        initPanel();
    }

    /**
     * This method sets up the jlist and adds an selection listener to the list.
     * This listener sets, if selection occurs, the selected user for the report and sets the buttons <code>setEnabled(true)</code>.
     */
    private void initListAndComboBox() {
        contributionOfNutzerReportPanelSortByBox = new JComboBox(data0);
        popularityOfBeitragReportPanelSortByBox = new JComboBox(data1);
        
        
        nutzerliste = new JList();
        nutzerliste.setCellRenderer(new NutzerListCellRenderer());
        nutzerliste.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                runBeitragReportButton.setEnabled(true);
                runNutzerReportButton.setEnabled(true);
                reportUser = nutzerliste.getSelectedValue();
            }
        });
        nutzerliste.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    try {
                        Date dateStart = df.parse(calendarStartDateField.getText());
                        Date dateEnd = df.parse(calendarEndDateField.getText());
                        HTMLWriter htmlWriter = new HTMLWriter(reportGenerator.createContributionOfNutzerReport(reportUser, 
                                contributionOfNutzerReportPanelSortByBox.getSelectedIndex(),
                                dateStart, 
                                dateEnd));
                    } catch (RemoteException ex) {
                        Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    /**
     * This Method sets the initial data for the report generator. 
     * This data is obtained from the server.
     */
    private void initData() {
        try {
            nutzerliste.setListData(server.getAllNutzer());
            reportGenerator = server.getReportGenerator();
        } catch (RemoteException ex) {
            Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method sets up the frame of the window and its form, size and default behaviour.
     */
    private void initFrame() {
        this.pack();
        this.setExtendedState(this.getExtendedState()); // Frame is maximized on start
        this.setMinimumSize(new Dimension(500, 300));
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
        tabbedPane.addTab("Contribution of Users", contributionOfNutzerReportPanel);
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
        JLabel startLabel = new JLabel("Social Media Report Generator",JLabel.LEFT);
        startLabel.setFont(new Font("Arial", Font.BOLD, 28));
        initPanel.add(startLabel, BorderLayout.CENTER);
    }

    /**
     * In this method the panel for the ContributionOfNutzerReport is created.
     */
    private void initContributionOfNutzerReportPanel() {
        contributionOfNutzerReportPanel = new JPanel();
        contributionOfNutzerReportPanel.setLayout(new BorderLayout());
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.add(new JLabel("Start Date: "), BorderLayout.NORTH);
        calendarStartDateField = new JFormattedTextField(df);
        calendarStartDateField.setText(df.format(new Date()));
        calendarStartDateField.setInputVerifier(new FormattedTextFieldVerifier());
        textFieldPanel.add(calendarStartDateField, BorderLayout.NORTH);
        
        textFieldPanel.add(new JLabel("End Date: "), BorderLayout.NORTH);
        calendarEndDateField = new JFormattedTextField(df);
        calendarEndDateField.setText(df.format(new Date()));
        calendarEndDateField.setInputVerifier(new FormattedTextFieldVerifier());
        textFieldPanel.add(calendarEndDateField, BorderLayout.NORTH);
        
        textFieldPanel.add(new JLabel("Sort by... "), BorderLayout.NORTH);
        textFieldPanel.add(contributionOfNutzerReportPanelSortByBox, BorderLayout.NORTH);
        contributionOfNutzerReportPanel.add(textFieldPanel, BorderLayout.NORTH);
        
        nutzerlisteScrollPane = new ScrollPane();
        nutzerliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nutzerliste.setLayoutOrientation(JList.VERTICAL);
        nutzerlisteScrollPane.add(nutzerliste);
        contributionOfNutzerReportPanel.add(nutzerlisteScrollPane, BorderLayout.CENTER);
        
        runNutzerReportButton = new JButton("Go!");
        runNutzerReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Date dateStart = df.parse(calendarStartDateField.getText());
                    Date dateEnd = df.parse(calendarEndDateField.getText());
                    HTMLWriter htmlWriter = new HTMLWriter(reportGenerator.createContributionOfNutzerReport(reportUser, 
                            contributionOfNutzerReportPanelSortByBox.getSelectedIndex(),
                            dateStart, 
                            dateEnd));
                } catch (RemoteException ex) {
                    Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        runNutzerReportButton.setEnabled(false);
        contributionOfNutzerReportPanel.add(runNutzerReportButton, BorderLayout.SOUTH);
    }

    /**
     * In this method the panel for the PopularityOfBeitragReport is created.
     */
    private void initPopularityOfBeitragReportPanel() {
        popularityOfBeitragReportPanel = new JPanel();
        popularityOfBeitragReportPanel.setLayout(new BorderLayout());
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.add(new JLabel("Start Date: "), BorderLayout.NORTH);
        calendarStartDateField = new JFormattedTextField(df);
        calendarStartDateField.setText(df.format(new Date()));
        calendarStartDateField.setInputVerifier(new FormattedTextFieldVerifier());
        textFieldPanel.add(calendarStartDateField, BorderLayout.NORTH);
        
        textFieldPanel.add(new JLabel("End Date: "), BorderLayout.NORTH);
        calendarEndDateField = new JFormattedTextField(df);
        calendarEndDateField.setText(df.format(new Date()));
        calendarEndDateField.setInputVerifier(new FormattedTextFieldVerifier());
        textFieldPanel.add(calendarEndDateField, BorderLayout.NORTH);
        
        textFieldPanel.add(new JLabel("Sort by... "), BorderLayout.NORTH);
        textFieldPanel.add(popularityOfBeitragReportPanelSortByBox, BorderLayout.NORTH);
        popularityOfBeitragReportPanel.add(textFieldPanel, BorderLayout.NORTH);
        
        
        
        
        runBeitragReportButton = new JButton("Go!");
        runBeitragReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Date dateStart = df.parse(calendarStartDateField.getText());
                    Date dateEnd = df.parse(calendarEndDateField.getText());
                    HTMLWriter htmlWriter = new HTMLWriter(reportGenerator.createPopularityOfBeitragReport(popularityOfBeitragReportPanelSortByBox.getSelectedIndex(), 
                            dateStart, 
                            dateEnd));
                } catch (RemoteException ex) {
                    Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        runBeitragReportButton.setEnabled(false);
        popularityOfBeitragReportPanel.add(runBeitragReportButton, BorderLayout.SOUTH);
    }
}











