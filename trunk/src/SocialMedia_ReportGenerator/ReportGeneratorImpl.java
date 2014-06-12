package SocialMedia_ReportGenerator;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Like;
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand;
import SocialMedia_Data.PinnwandImpl;
import SocialMedia_Logic.SocialMediaLogicImpl;
import SocialMedia_Report.Column;
import SocialMedia_Report.ColumnImpl;
import SocialMedia_Report.CompositeParagraph;
import SocialMedia_Report.CompositeParagraphImpl;
import SocialMedia_Report.ContributionOfNutzer;
import SocialMedia_Report.ContributionOfNutzerImpl;
import SocialMedia_Report.PopularityOfBeitrag;
import SocialMedia_Report.PopularityOfBeitragImpl;
import SocialMedia_Report.Report;
import SocialMedia_Report.Row;
import SocialMedia_Report.RowImpl;
import SocialMedia_Report.SimpleParagraphImpl;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E7C2C07C-F969-9A30-C188-C220A1AD2C41]
// </editor-fold> 
/**
 * Generator class which creates the <code>Report</code>-Object in the given manner.
 * 
 * @author Sebastian
 */
public class ReportGeneratorImpl 
    extends java.rmi.server.UnicastRemoteObject 
    implements ReportGenerator {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5F731C06-B576-8C5F-7EB5-3ED06DFC5D1B]
    // </editor-fold> 
    private SocialMediaLogicImpl socialMediaLogic = null;
    private final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy | HH:mm", Locale.GERMANY);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.657F1B43-DFBC-7C21-6CDC-195ADE1929AA]
    // </editor-fold> 
    /**
     * Constructor of the <code>ReportGeneratorImpl</code> class.
     * This constructor will be called once when the server logic is started.
     * Each Server has its own <code>ReportGenerator</code>.
     * 
     * @param val - <code>SocialMediaLogic</code> will be needed to get some data for the reports.
     * @throws java.rmi.RemoteException
     */
    public ReportGeneratorImpl (SocialMediaLogicImpl val) throws RemoteException {
        socialMediaLogic = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.975F3159-35F0-CCCD-CB7B-ACA6F8F16C17]
    // </editor-fold> 
    /**
     * Method to create the <code>ContributionOfNutzerImpl</code>-Report by the given criteria.
     * 
     * @param nutzerVal - Defines the user over which should be reported.
     * @param sortByVal - sorts the <code>Nutzer</code> by most <code>Beitrag</code>, most Like get or most <code>Abonnement</code> in a specific timespan.
     * @param startDateVal - Start Date of the timespan.
     * @param endDateVal - End Date of the timespan.
     * @return ContributionOfNutzerImpl - Returns created the Report object.
     * @throws java.rmi.RemoteException
     */
    public Report createContributionOfNutzerReport (Nutzer nutzerVal, final int sortByVal, final Date startDateVal, final Date endDateVal) throws RemoteException {
        Logger.getLogger(this.getClass().getName()).info("nutzerVal " + nutzerVal);
        Logger.getLogger(this.getClass().getName()).info("sortByVal " + sortByVal);
        Logger.getLogger(this.getClass().getName()).info("startDateVal " + startDateVal);
        Logger.getLogger(this.getClass().getName()).info("endDateVal " + endDateVal);
        
        ContributionOfNutzer report = new ContributionOfNutzerImpl();
        Vector<Nutzer> nutzers = socialMediaLogic.getAllNutzer();
        Vector<Nutzer> n0 = new Vector<Nutzer>();
        for (int i = 0; i < nutzers.size(); i++) {
            if (!nutzers.elementAt(i).getUsername().contentEquals("Deaktivierter Nutzer"))
                n0.add(nutzers.elementAt(i));
        }
        nutzers = n0;
        report.setCreationDate(new Date());
        report.setStartDate(startDateVal);
        report.setEndDate(endDateVal);
        report.setHeaderAndTitleParagraph(new SimpleParagraphImpl("Nutzer Popularitäts-/Aktivitäts Report"));
        if (nutzerVal != null){
            report.setBodyParagraph(new SimpleParagraphImpl("Report über die Aktivität des Nutzers: " + nutzerVal.getUsername() + " zwischen dem " + startDateVal + " und dem " + endDateVal));
            nutzers = new Vector<Nutzer>();
            nutzers.add(nutzerVal);
        } else {
            report.setBodyParagraph(new SimpleParagraphImpl("Report zwischen dem " + startDateVal + " und dem " + endDateVal));
        }
        
        //@todo createContributionOfNutzerReport// Welcher nutzer hat die meisten beiträge gemacht? meiste likes erhalten? meisten abonnenten? in einem zeitraum?
        
        /**
         * Wenn die Beiträge im Report nach menge der Kommentare sortiert werden soll dann den entsprechenden Sortieralgorythmus anwerfen.
         * Ansonsten soll der Report nach menge der Likes sortiert werden.
         */
        if (sortByVal == 1 && nutzers.size() > 1){
            Collections.sort(nutzers, new Comparator<Nutzer>() {
                public int compare(Nutzer o1, Nutzer o2){
                    try {
                        Vector<Beitrag> o1Beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o1));
                        Vector<Beitrag> beitraege2 = new Vector<Beitrag>();
                        for (int i = 0; i < o1Beitraege.size(); i++) {
                            if (!startDateVal.after(o1Beitraege.elementAt(i).getCreationDate()) && !endDateVal.before(o1Beitraege.elementAt(i).getCreationDate()))
                                beitraege2.add(o1Beitraege.elementAt(i));
                        }
                        o1Beitraege = beitraege2;
                        
                        Vector<Beitrag> o2Beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o2));
                        beitraege2 = new Vector<Beitrag>();
                        for (int i = 0; i < o2Beitraege.size(); i++) {
                            if (!startDateVal.after(o2Beitraege.elementAt(i).getCreationDate()) && !endDateVal.before(o2Beitraege.elementAt(i).getCreationDate()))
                                beitraege2.add(o2Beitraege.elementAt(i));
                        }
                        o2Beitraege = beitraege2;
                        
                        return ((Integer)o2Beitraege.size()).compareTo((Integer)o1Beitraege.size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return -1;
                }
            });  
        }else if (sortByVal == 0 && nutzers.size() > 1){
            Collections.sort(nutzers, new Comparator<Nutzer>() {
                public int compare(Nutzer o1, Nutzer o2){
                    try {
                        Vector<Beitrag> o1Beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o1));
                        Vector<Like> o1Likes = new  Vector<Like>();
                        for (int i = 0; i < o1Beitraege.size(); i++) {
                            o1Likes.addAll(o1Beitraege.get(i).getAllBeitragLikes(socialMediaLogic));
                        }
                        Vector<Like> likes2 = new Vector<Like>();
                        for (int i = 0; i < o1Likes.size(); i++) {
                            if (!startDateVal.after(o1Likes.elementAt(i).getCreationDate()) && !endDateVal.before(o1Likes.elementAt(i).getCreationDate()))
                                likes2.add(o1Likes.elementAt(i));
                        }
                        o1Likes = likes2;
                        Vector<Beitrag> o2Beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o2));
                        Vector<Like> o2Likes = new  Vector<Like>();
                        for (int i = 0; i < o2Beitraege.size(); i++) {
                            o2Likes.addAll(o2Beitraege.get(i).getAllBeitragLikes(socialMediaLogic));
                        }
                        likes2 = new Vector<Like>();
                        for (int i = 0; i < o2Likes.size(); i++) {
                            if (!startDateVal.after(o2Likes.elementAt(i).getCreationDate()) && !endDateVal.before(o2Likes.elementAt(i).getCreationDate()))
                                likes2.add(o2Likes.elementAt(i));
                        }
                        o2Likes = likes2;
                        return ((Integer)o2Likes.size()).compareTo((Integer)o1Likes.size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return -1;
                }
            });
        } else if (sortByVal == 2 && nutzers.size() > 1){
            Collections.sort(nutzers, new Comparator<Nutzer>() {
                public int compare(Nutzer o1, Nutzer o2){
                    try {
                        Vector<Abonnement> o1Abonnements = socialMediaLogic.getPinnwandOfNutzer(o1).getAllAbonnementsOfPinnwand(socialMediaLogic);
                        Vector<Abonnement> abonnements2 = new Vector<Abonnement>();
                        for (int i = 0; i < o1Abonnements.size(); i++) {
                            if (!startDateVal.after(o1Abonnements.elementAt(i).getCreationDate()) && !endDateVal.before(o1Abonnements.elementAt(i).getCreationDate()))
                                abonnements2.add(o1Abonnements.elementAt(i));
                        }
                        o1Abonnements = abonnements2;
                        Vector<Abonnement> o2Abonnements = socialMediaLogic.getPinnwandOfNutzer(o2).getAllAbonnementsOfPinnwand(socialMediaLogic);
                        abonnements2 = new Vector<Abonnement>();
                        for (int i = 0; i < o2Abonnements.size(); i++) {
                            if (!startDateVal.after(o2Abonnements.elementAt(i).getCreationDate()) && !endDateVal.before(o2Abonnements.elementAt(i).getCreationDate()))
                                abonnements2.add(o2Abonnements.elementAt(i));
                        }
                        o2Abonnements = abonnements2;
                        return ((Integer)o2Abonnements.size()).compareTo((Integer)o1Abonnements.size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return -1;
                }
            });
        }
        System.out.println(nutzers);
        
        
        
        /**
         * Schleife über alle Nutzer.
         */
        Vector<Row> rows = new Vector<Row>();
        for (int i = 0; i < nutzers.size(); i++) {
            
            Vector<Beitrag> beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(nutzers.elementAt(i)));
            Vector<Abonnement> abonnements = socialMediaLogic.getAllAbonnementsOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(nutzers.elementAt(i)));
            System.out.println(abonnements);
            int laufindex0 = (beitraege.size() > abonnements.size()) ?  beitraege.size() : abonnements.size();
            Logger.getLogger(this.getClass().getName()).info(" Laufindex0: " + laufindex0);
            Logger.getLogger(this.getClass().getName()).info(" Laufindex0: " + beitraege.size());
            Logger.getLogger(this.getClass().getName()).info(" Laufindex0: " + abonnements.size());
            
            if (sortByVal==0){
                //sortByVal Beiträge
                /**
                 * Wenn erste Zeile dann TableHeader schreiben.
                 */
                if (i==0){
                    Column c = new ColumnImpl();
                    Row r = new RowImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Nutzer"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Beiträge"));
                    c.addSubParagraph(new SimpleParagraphImpl(df.format(startDateVal) + " - " + df.format(endDateVal)));
                    c.addSubParagraph(new SimpleParagraphImpl("sort By Value"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Likes"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Kommentare"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Abonnements"));
                    r.addColumn(c);
                    rows.add(r);
                }
                /**
                 * Schleife über alle Beiträge und Abonnements, wovon mehr da ist.
                 * Wenn nix da ist dann leere Zeile erzeugen
                 */
                
                for (int j = 0; j < laufindex0; j++) {
                    Vector<Like> likes;
                    Vector<Kommentar> kommentare;
                    try{
                        likes = socialMediaLogic.getAllLikeOfBeitrag(beitraege.get(j));
                        kommentare = socialMediaLogic.getAllKommentarOfBeitrag(beitraege.get(j));
                    } catch (IndexOutOfBoundsException ex){
                        likes=new Vector<Like>();
                        kommentare=new Vector<Kommentar>();
                    }
                    int laufindex = (likes.size() > kommentare.size()) ?  likes.size() : kommentare.size();
                    Logger.getLogger(this.getClass().getName()).info(" Laufindex: " + laufindex);
                    Logger.getLogger(this.getClass().getName()).info(" Laufindex: " + likes.size());
                    Logger.getLogger(this.getClass().getName()).info(" Laufindex: " + kommentare.size());
                    
                    /**
                     * Schleife über alle Likes und Kommentare, wovon mehr da ist.
                     * Wenn nix da ist dann leere Zeile erzeugen
                     */
                    for (int counter = 0; counter < laufindex; counter++){
                        Row r0 = new RowImpl();
                        Column c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        if (counter == 0){
                            r0.addColumn(writeNutzer(nutzers.elementAt(i)));
                        } else {
                            r0.addColumn(c);
                        }
                        if (counter == 0){
                            try{
                                r0.addColumn(writeBeitrag(beitraege.elementAt(j)));
                            } catch (IndexOutOfBoundsException ex){
                                r0.addColumn(c);
                            }
                        } else {
                            r0.addColumn(c);
                        }
                        try{
                            r0.addColumn(writeLike(likes.elementAt(counter)));
                        } catch (IndexOutOfBoundsException ex){
                            r0.addColumn(c);
                        }
                        try{
                            r0.addColumn(writeKommentar(kommentare.elementAt(counter)));
                        } catch (IndexOutOfBoundsException ex){
                            r0.addColumn(c);
                        } 
                        if (counter == 0){
                            try{
                                System.out.println(abonnements);
                                r0.addColumn(writeAbonnement(abonnements.elementAt(j)));
                            } catch (IndexOutOfBoundsException ex){
                                r0.addColumn(c);
                            } 
                        } else {
                            r0.addColumn(c);
                        }
                        rows.add(r0);
                    }
                }
            }
            
            
            
            
            
            
            
//            else if(sortByVal==1){
//                //sortByVal Likes
//                /**
//                 * Wenn erste Zeile dann TableHeader schreiben.
//                 */
//                if (i==0){
//                    Column c = new ColumnImpl();
//                    Row r = new RowImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Nutzer"));
//                    r.addColumn(c);
//                    c = new ColumnImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Likes"));
//                    c.addSubParagraph(new SimpleParagraphImpl(df.format(startDateVal) + " - " + df.format(endDateVal)));
//                    c.addSubParagraph(new SimpleParagraphImpl("sort By Value"));
//                    r.addColumn(c);
//                    c = new ColumnImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Beiträge"));
//                    r.addColumn(c);
//                    c = new ColumnImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Kommentare"));
//                    r.addColumn(c);
//                    c = new ColumnImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Abonnements"));
//                    r.addColumn(c);
//                    rows.add(r);
//                }
//                beitragColumn = writeBeitrag(beitrag);
//                /**
//                 * Laufindex über alle Likes
//                 */
//                
//                /**
//                 * Schleife über alle Beiträge oder Kommentare, wovon mehr da ist.
//                 * Wenn nix da ist dann leere Zeile erzeugen
//                 */
//                for (int counter = 0; counter < laufindex; counter++){
//                    Row r0 = new RowImpl();
//                    Column c = new ColumnImpl();
//                    if (counter == 0){
//                        r0.addColumn(beitragColumn);
//                    } else {
//                        c.addSubParagraph(new SimpleParagraphImpl(""));
//                        r0.addColumn(c);
//                    }
//                    try{
//                        r0.addColumn(writeLike(likes.elementAt(counter)));
//                    } catch (IndexOutOfBoundsException ex){
//                        c = new ColumnImpl();
//                        c.addSubParagraph(new SimpleParagraphImpl(""));
//                        r0.addColumn(c);
//                    }
//                    try{
//                        r0.addColumn(writeKommentar(kommentare.elementAt(counter)));
//                    } catch (IndexOutOfBoundsException ex){
//                        c = new ColumnImpl();
//                        c.addSubParagraph(new SimpleParagraphImpl(""));
//                        r0.addColumn(c);
//                    }
//                    rows.add(r0);
//                }
//                
//            }
//            
//            
//            
//            
//            
//            
//            else if(sortByVal==2){
//                //sortByVal Abonnement
//                /**
//                 * Wenn erste Zeile dann TableHeader schreiben.
//                 */
//                if (i==0){
//                    Column c = new ColumnImpl();
//                    Row r = new RowImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Nutzer"));
//                    r.addColumn(c);
//                    c = new ColumnImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Abonnements"));
//                    c.addSubParagraph(new SimpleParagraphImpl(df.format(startDateVal) + " - " + df.format(endDateVal)));
//                    c.addSubParagraph(new SimpleParagraphImpl("sort By Value"));
//                    r.addColumn(c);
//                    c = new ColumnImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Beiträge"));
//                    r.addColumn(c);
//                    c = new ColumnImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Likes"));
//                    r.addColumn(c);
//                    c = new ColumnImpl();
//                    c.addSubParagraph(new SimpleParagraphImpl("Kommentare"));
//                    r.addColumn(c);
//                    rows.add(r);
//                }
//                /**
//                 * Schleife über alle Abonnements
//                 */
//                for (int k = 0; k < abonnements.size(); k++) {
//                    row.add(writeAbonnement(abonnements.elementAt(k)));
//                    /**
//                     * Schleife über alle Beiträge Likes oder Kommentare, wovon mehr da ist.
//                     * Wenn nix da ist dann leere Zeile erzeugen
//                     */
//                    for (int counter = 0; counter < laufindex; counter++){
//                    Row r0 = new RowImpl();
//                    Column c = new ColumnImpl();
//                    if (counter == 0){
//                        r0.addColumn(beitragColumn);
//                    } else {
//                        c.addSubParagraph(new SimpleParagraphImpl(""));
//                        r0.addColumn(c);
//                    }
//                    try{
//                        r0.addColumn(writeLike(likes.elementAt(counter)));
//                    } catch (IndexOutOfBoundsException ex){
//                        c = new ColumnImpl();
//                        c.addSubParagraph(new SimpleParagraphImpl(""));
//                        r0.addColumn(c);
//                    }
//                    try{
//                        r0.addColumn(writeKommentar(kommentare.elementAt(counter)));
//                    } catch (IndexOutOfBoundsException ex){
//                        c = new ColumnImpl();
//                        c.addSubParagraph(new SimpleParagraphImpl(""));
//                        r0.addColumn(c);
//                    }
//                    rows.add(r0);
//                }
            
        }
        report.setRows(rows);
        report.setImprintParagraph(addImprint());
        return report;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A085AD62-913F-0C59-690A-A589531FAEA9]
    // </editor-fold> 
    /**
     * Method to create the <code>PopularityOfBeitragImpl</code>-Report by the given criteria.
     * 
     * 
     * @param sortByVal - sorts the List of <code>Beitrag</code> by most </code>Like</code> or most </code>Kommentar</code> in a specific timespan.
     * @param startDateVal - Start Date of the timespan.
     * @param endDateVal - End Date of the timespan.
     * @return PopularityOfBeitragImpl - Returns created the Report object.
     * @throws java.rmi.RemoteException
     */
    public Report createPopularityOfBeitragReport (int sortByVal, Date startDateVal, Date endDateVal) throws RemoteException {
        PopularityOfBeitrag report = new PopularityOfBeitragImpl();
        
        report.setCreationDate(new Date());
        report.setStartDate(startDateVal);
        report.setEndDate(endDateVal);
        report.setHeaderAndTitleParagraph(new SimpleParagraphImpl("Beitrag Popularitäts-Report"));
        report.setBodyParagraph(new SimpleParagraphImpl("Report über die Popularität der Beiträge zwischen dem " + df.format(startDateVal) + " und dem " + df.format(endDateVal)));
        
        Vector<Beitrag> beitraege = socialMediaLogic.getAllBeitrag();
        Vector<Beitrag> beitraege2 = new Vector<Beitrag>();
        for (int i = 0; i < beitraege.size(); i++) {
            if (!startDateVal.after(beitraege.elementAt(i).getCreationDate()) && !endDateVal.before(beitraege.elementAt(i).getCreationDate()))
                beitraege2.add(beitraege.elementAt(i));
        }
        beitraege = beitraege2;
        /**
         * Wenn die Beiträge im Report nach menge der Kommentare sortiert werden soll dann den entsprechenden Sortieralgorythmus anwerfen.
         * Ansonsten soll der Report nach menge der Likes sortiert werden.
         */
        if (sortByVal == 1){
            Collections.sort(beitraege, new Comparator<Beitrag>() {
                public int compare(Beitrag o1, Beitrag o2){
                    try {
                        return ((Integer)socialMediaLogic.getAllKommentarOfBeitrag(o2).size()).compareTo((Integer)socialMediaLogic.getAllKommentarOfBeitrag(o1).size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return -1;
                }
            });  
        }else if (sortByVal == 0){
            Collections.sort(beitraege, new Comparator<Beitrag>() {
                public int compare(Beitrag o1, Beitrag o2){
                    try {
                        return ((Integer)socialMediaLogic.getAllLikeOfBeitrag(o2).size()).compareTo((Integer)socialMediaLogic.getAllLikeOfBeitrag(o1).size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return -1;
                }
            });
        }
        
        /**
         * Schleife über alle Beiträge.
         */
        Vector<Row> rows = new Vector<Row>();
        for (int i = 0; i < beitraege.size(); i++) {
            Column beitragColumn;
            Beitrag beitrag = beitraege.get(i);
            Vector<Like> likes = socialMediaLogic.getAllLikeOfBeitrag(beitrag);
            Vector<Kommentar> kommentare = socialMediaLogic.getAllKommentarOfBeitrag(beitrag);
            int laufindex = (likes.size() > kommentare.size()) ?  likes.size() : kommentare.size();
            if (sortByVal==1){
                /**
                 * Wenn erste Zeile dann TableHeader schreiben.
                 */
                if (i==0){
                    Column c = new ColumnImpl();
                    Row r = new RowImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Beiträge"));
                    c.addSubParagraph(new SimpleParagraphImpl(df.format(startDateVal) + " - " + df.format(endDateVal)));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Kommentare"));
                    c.addSubParagraph(new SimpleParagraphImpl("sort By Value"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Likes"));
                    r.addColumn(c);
                    rows.add(r);
                }
                beitragColumn = writeBeitrag(beitrag);
                /**
                 * Schleife über alle Likes oder Kommentare, wovon mehr da ist.
                 * Wenn nix da ist dann leere Zeile erzeugen
                 */
                for (int counter = 0; counter < laufindex; counter++){
                    Row r0 = new RowImpl();
                    Column c = new ColumnImpl();
                    if (counter == 0){
                        r0.addColumn(beitragColumn);
                    } else {
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    try{
                        r0.addColumn(writeKommentar(kommentare.elementAt(counter)));
                    } catch (IndexOutOfBoundsException ex){
                        c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    try{
                        r0.addColumn(writeLike(likes.elementAt(counter)));
                    } catch (IndexOutOfBoundsException ex){
                        c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    rows.add(r0);
                }
            }else if(sortByVal==0){
            /**
             * Wenn erste Zeile dann TableHeader schreiben.
             */
                if (i==0){
                    Column c = new ColumnImpl();
                    Row r = new RowImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Beiträge"));
                    c.addSubParagraph(new SimpleParagraphImpl(df.format(startDateVal) + " - " + df.format(endDateVal)));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Likes"));
                    c.addSubParagraph(new SimpleParagraphImpl("sort By Value"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Kommentare"));
                    r.addColumn(c);
                    rows.add(r);
                }
                beitragColumn = writeBeitrag(beitrag);
                /**
                 * Schleife über alle Likes oder Kommentare, wovon mehr da ist.
                 * Wenn nix da ist dann leere Zeile erzeugen
                 */
                for (int counter = 0; counter < laufindex; counter++){
                    Row r0 = new RowImpl();
                    Column c = new ColumnImpl();
                    if (counter == 0){
                        r0.addColumn(beitragColumn);
                    } else {
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    try{
                        r0.addColumn(writeLike(likes.elementAt(counter)));
                    } catch (IndexOutOfBoundsException ex){
                        c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    try{
                        r0.addColumn(writeKommentar(kommentare.elementAt(counter)));
                    } catch (IndexOutOfBoundsException ex){
                        c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    rows.add(r0);
                }
            }
            report.setRows(rows);
        }
        report.setImprintParagraph(addImprint());
        //createPopularityOfBeitragReport//Beiträge mit den meisten Likes, Kommentaren in einem Zeitraum
        return report;
    }
    
    /**
     * Helper method for the report generation. Transforms a <code>Nutzer</code> into an <code>Column</code>.
     * 
     * @param n - The <code>Nutzer</code> which should be written into the report.
     * @return Returns the <code>Column</code> entry for the report.
     * @throws RemoteException 
     */
    private Column writeNutzer(Nutzer n) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("User: " + n.getName() + ", " + n.getSurname()));
        column.addSubParagraph(new SimpleParagraphImpl("alias " + n.getUsername()));
        column.addSubParagraph(new SimpleParagraphImpl("Abonnements: " + socialMediaLogic.getAllAbonnementOfNutzer(n).size() + "\t wurde Abonniert: " + socialMediaLogic.getAllAbonnementsOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(n)).size()));
        return column;
    }
    
    /**
     * Helper method for the report generation. Transforms a <code>Beitrag</code> into an <code>Column</code>.
     * 
     * @param b - The <code>Beitrag</code> which should be written into the report.
     * @return Returns the <code>Column</code> entry for the report.
     * @throws RemoteException 
     */
    private Column writeBeitrag(Beitrag b) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("User: " + socialMediaLogic.getNutzerOf(b).getUsername()));
        column.addSubParagraph(new SimpleParagraphImpl("Erstellt am: " + df.format(b.getCreationDate())));
        column.addSubParagraph(new SimpleParagraphImpl("Inhalt: " + b.getText()));
        column.addSubParagraph(new SimpleParagraphImpl("anz. Likes: " + socialMediaLogic.getAllLikeOfBeitrag(b).size() + "\t anz. Kommentare: " + socialMediaLogic.getAllKommentarOfBeitrag(b).size()));
        return column;
    }
    
    /**
     * Helper method for the report generation. Transforms a <code>Kommentar</code> into an <code>Column</code>.
     * 
     * @param k - The <code>Kommentar</code> which should be written into the report.
     * @return Returns the <code>Column</code> entry for the report.
     * @throws RemoteException 
     */    
    private Column writeKommentar(Kommentar k) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("User: " + socialMediaLogic.getNutzerOf(k).getUsername()));
        column.addSubParagraph(new SimpleParagraphImpl("Erstellt am: " + df.format(k.getCreationDate())));
        column.addSubParagraph(new SimpleParagraphImpl("Inhalt: " + k.getText()));
        return column;
    }
    
    /**
     * Helper method for the report generation. Transforms a <code>Like</code> into an <code>Column</code>.
     * 
     * @param l - The <code>Like</code> which should be written into the report.
     * @return Returns the <code>Column</code> entry for the report.
     * @throws RemoteException 
     */
    private Column writeLike(Like l) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("Von: " + socialMediaLogic.getNutzerOf(l).getUsername()));
        column.addSubParagraph(new SimpleParagraphImpl("Erstellt am: " + df.format(l.getCreationDate())));
        return column;
    }
    
    /**
     * Helper method for the report generation. Transforms a <code>Abonnement</code> into an <code>Column</code>.
     * @param a - The <code>Abonnement</code> which should be written into the report.
     * @return Returns the <code>Column</code> entry for the report.
     * @throws RemoteException 
     */
    private Column writeAbonnement(Abonnement a) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("Von: " + socialMediaLogic.getNutzerOf(a).getUsername()));
        column.addSubParagraph(new SimpleParagraphImpl("Erstellt am: " + df.format(a.getCreationDate())));
        return column;
        
    }

    /**
     * Helper method for the report generation. Generates the imprint for the report.
     * 
     * @throws RemoteException 
     */
    private CompositeParagraph addImprint() throws RemoteException {
        CompositeParagraph imprintCompositeParagraph = new CompositeParagraphImpl();
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Dieser Report wird ihnen Präsentiert von: IT3-Team 02"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Sebastian Fink"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Max Kobald"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Benjamin Kiss"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Riccardo Antonio Giugno"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Leo Christ"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Kevin Hüber"));
        return imprintCompositeParagraph;
    }
}

