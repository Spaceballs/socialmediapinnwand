
package SocialMedia_Gui;

import SocialMedia_IOandHelper.FormattedTextFieldVerifier;
import SocialMedia_IOandHelper.NutzerListCellRenderer;
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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
    private JPanel contributionOfNutzerTextFieldPanel;
    private JPanel popularityOfBeitragReportPanel;
    private JPanel popularityOfBeitragTextFieldPanel;
    private JTabbedPane tabbedPane;
    private JList<Nutzer> nutzerliste;
    private JComboBox<String> contributionOfNutzerReportPanelSortByBox;
    private final String[] data0 = {"Beiträge", "Likes", "Abonnenten"};
    private JComboBox<String> popularityOfBeitragReportPanelSortByBox;
    private final String[] data1 = {"Likes", "Kommentare"};
    private ScrollPane nutzerlisteScrollPane;
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
        popularityOfBeitragReportPanelSortByBox = new JComboBox<String>(data1);

//        nutzerliste = new JList<Nutzer>();
//        nutzerliste.setCellRenderer(new NutzerListCellRenderer());
//        nutzerliste.addListSelectionListener(new ListSelectionListener() {
//            public void valueChanged(ListSelectionEvent e) {
//                reportUser = nutzerliste.getSelectedValue();
//            }
//        });
//        nutzerliste.setSelectionModel(new DefaultListSelectionModel() {
//            private static final long serialVersionUID = 1L;
//
//            boolean gestureStarted = false;
//
//            @Override
//            public void setSelectionInterval(int index0, int index1) {
//                if(!gestureStarted){
//                if (index0==index1) {
//                    if (isSelectedIndex(index0)) {
//                        removeSelectionInterval(index0, index0);
//                        return;
//                    }
//                }
//                super.setSelectionInterval(index0, index1);
//                }
//                gestureStarted = true;
//            }
//
//            @Override
//            public void addSelectionInterval(int index0, int index1) {
//                if (index0==index1) {
//                    if (isSelectedIndex(index0)) {
//                        removeSelectionInterval(index0, index0);
//                        return;
//                    }
//                super.addSelectionInterval(index0, index1);
//                }
//            }
//
//            @Override
//            public void setValueIsAdjusting(boolean isAdjusting) {
//                if (isAdjusting == false) {
//                    gestureStarted = false;
//                }
//            }
//        });
//    
//        nutzerliste.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent evt) {
//                JList list = (JList)evt.getSource();
//                if (evt.getClickCount() == 2) {
//                    int index = list.locationToIndex(evt.getPoint());
//                    try {
//                        Date dateStart = df.parse(calendarStartDateField.getText());
//                        Date dateEnd = df.parse(calendarEndDateField.getText());
//                        HTMLWriter htmlWriter = new HTMLWriter(reportGenerator.createContributionOfNutzerReport(reportUser, 
//                                contributionOfNutzerReportPanelSortByBox.getSelectedIndex(),
//                                dateStart, 
//                                dateEnd));
//                        nutzerliste.clearSelection();
//                        reportUser = null;
//                    } catch (RemoteException ex) {
//                        Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (ParseException ex) {
//                        Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        });
//        nutzerliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    /**
     * This Method sets the initial data for the report generator. 
     * This data is obtained from the server.
     */
    private void initData() {
        // @todo - Hier kann glaub auch was raus
        try {
            Vector<Nutzer> n = server.getAllNutzer();
            Vector<Nutzer> n0 = new Vector<Nutzer>();
            for (int i = 0; i < n.size(); i++) {
                if (!n.elementAt(i).getUsername().contentEquals("Deaktivierter Nutzer"))
                    n0.add(n.elementAt(i));
            }
            nutzerliste.setListData(n0);
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
//                                    reportUser, 
                                    contributionOfNutzerReportPanelSortByBox.getSelectedIndex(),
                                    dateStart, 
                                    dateEnd));
//                    nutzerliste.clearSelection();
//                    reportUser = null;
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
                                    popularityOfBeitragReportPanelSortByBox.getSelectedIndex(), 
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











