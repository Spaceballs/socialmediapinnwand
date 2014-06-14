package SocialMedia_ReportGenerator;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Beitrag;
import SocialMedia_Data.DataReference;
import SocialMedia_Data.DataReferenceImpl;
import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Like;
import SocialMedia_Data.Nutzer;
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

/**
 * @todo - Beiträge von Prinz_Poldi und Superman werden nciht angezeigt
 * report_von_11.01.2014_bis_12.06.2014
 */

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
    public Report createContributionOfNutzerReport ( 
            final int sortByVal, 
            final Date startDateVal, 
            final Date endDateVal) 
            throws RemoteException {
        //@todo createContributionOfNutzerReport - Welcher nutzer hat die meisten beiträge gemacht? meiste likes erhalten? meisten abonnenten? in einem zeitraum?
        /**
         * Neuer Report wird erzeugt
         */
        ContributionOfNutzer report = new ContributionOfNutzerImpl();
        /**
         * Nutzer für den Report werden angelegt
         */
        Vector<Nutzer> nutzers = socialMediaLogic.getAllNutzer();
        /**
         * Deaktivierte Nutzer werden aus dem Report aussortiert
         */
        Vector<Nutzer> n0 = new Vector<Nutzer>();
        for (int i = 0; i < nutzers.size(); i++) {
            if (!nutzers.elementAt(i).getUsername().contentEquals("Deaktivierter Nutzer"))
                n0.add(nutzers.elementAt(i));
        }
        nutzers = n0;
        /**
         * Dem Report werden Datum, Datumsvariablen und Titel hinzugefügt
         */
        report.setCreationDate(new Date());
        report.setStartDate(startDateVal);
        report.setEndDate(endDateVal);
        report.setHeaderAndTitleParagraph(new SimpleParagraphImpl("Nutzer Popularitäts-/Aktivitäts Report"));
        /**
         * 0 = nach beiträgen sortieren
         * 1 = nach likes sortieren
         * 2 = nach Abonnements sortieren
         */
        if (sortByVal == 0 && nutzers.size() > 1){
            Collections.sort(nutzers, new Comparator<Nutzer>() {
                public int compare(Nutzer o1, Nutzer o2){
                    try {
                        /**
                         * Hole alle Beiträge der Pinnwand des nutzers
                         */
                        Vector<Beitrag> o1Beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o1));
                        /**
                         * Sortiere alle Beiträge ausserhalb des zeitraums raus
                         */
                        Vector<Beitrag> beitraege = new Vector<Beitrag>();
                        for (int h = 0; h < o1Beitraege.size(); h++) {
                            if (!startDateVal.after(o1Beitraege.elementAt(h).getCreationDate()) && !endDateVal.before(o1Beitraege.elementAt(h).getCreationDate()))
                                beitraege.add(o1Beitraege.elementAt(h));
                        }
                        o1Beitraege = beitraege;
                        /**
                         * Hole alle Beiträge der Pinnwand des nutzers
                         */
                        Vector<Beitrag> o2Beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o2));
                        /**
                         * Sortiere alle Beiträge ausserhalb des zeitraums raus
                         */
                        beitraege = new Vector<Beitrag>();
                        for (int h = 0; h < o2Beitraege.size(); h++) {
                            if (!startDateVal.after(o2Beitraege.elementAt(h).getCreationDate()) && !endDateVal.before(o2Beitraege.elementAt(h).getCreationDate()))
                                beitraege.add(o2Beitraege.elementAt(h));
                        }
                        o2Beitraege = beitraege;
                        /**
                         * Vergleiche alle beiträge und sortiere nutzer danach
                         */
                        return ((Integer)o2Beitraege.size()).compareTo((Integer)o1Beitraege.size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return 0;
                }
            });  
        }else if (sortByVal == 1 && nutzers.size() > 1){
            Collections.sort(nutzers, new Comparator<Nutzer>() {
                public int compare(Nutzer o1, Nutzer o2){
                    try {
                        /**
                         * Hole alle Beiträge der Pinnwand des nutzers
                         */
                        Vector<Beitrag> o1Beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o1));
                        /**
                         * Hole alle Likes der Beiträge
                         */
                        Vector<Like> o1Likes = new  Vector<Like>();
                        for (int i = 0; i < o1Beitraege.size(); i++) {
                            o1Likes.addAll(socialMediaLogic.getAllLikeOfBeitrag(o1Beitraege.get(i)));
                        }
                        /**
                         * Sortier alle Likes ausserhalb des zeitraums aus
                         */
                        Vector<Like> likes2 = new Vector<Like>();
                        for (int h = 0; h < o1Likes.size(); h++) {
                            if (!startDateVal.after(o1Likes.elementAt(h).getCreationDate()) && !endDateVal.before(o1Likes.elementAt(h).getCreationDate()))
                                likes2.add(o1Likes.elementAt(h));
                        }
                        o1Likes = likes2;
                        /**
                         * Hole alle Beiträge der Pinnwand des nutzers
                         */
                        Vector<Beitrag> o2Beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o2));
                        /**
                         * Hole alle Likes der Beiträge
                         */
                        Vector<Like> o2Likes = new  Vector<Like>();
                        for (int i = 0; i < o2Beitraege.size(); i++) {
                            o2Likes.addAll(socialMediaLogic.getAllLikeOfBeitrag(o2Beitraege.get(i)));
                        }
                        /**
                         * Sortier alle Likes ausserhalb des zeitraums aus
                         */
                        likes2 = new Vector<Like>();
                        for (int h = 0; h < o2Likes.size(); h++) {
                            if (!startDateVal.after(o2Likes.elementAt(h).getCreationDate()) && !endDateVal.before(o2Likes.elementAt(h).getCreationDate()))
                                likes2.add(o2Likes.elementAt(h));
                        }
                        o2Likes = likes2;
                        /**
                         * Vergleiche die menge der likes und sortier die nutzer
                         */
                        return ((Integer)o2Likes.size()).compareTo((Integer)o1Likes.size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return 0;
                }
            });
        } else if (sortByVal == 2 && nutzers.size() > 1){
            Collections.sort(nutzers, new Comparator<Nutzer>() {
                public int compare(Nutzer o1, Nutzer o2){
                    try {
                        /**
                         * Hole alle Abonnements des Nutzers Pinnwand des nutzers
                         */
                        Vector<Abonnement> o1Abonnements = socialMediaLogic.getAllAbonnementsOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o1));
                        /**
                         * Sortier die ausserhalb des zeitraums aus
                         */
                        Vector<Abonnement> abonnements = new Vector<Abonnement>();
                        for (int k = 0; k < o1Abonnements.size(); k++) {
                            if (!startDateVal.after(o1Abonnements.elementAt(k).getCreationDate()) && !endDateVal.before(o1Abonnements.elementAt(k).getCreationDate()))
                                abonnements.add(o1Abonnements.elementAt(k));
                        }
                        o1Abonnements = abonnements;
                        /**
                         * Hole alle Abonnements des Nutzers Pinnwand des nutzers
                         */
                        Vector<Abonnement> o2Abonnements = socialMediaLogic.getAllAbonnementsOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(o2));
                        /**
                         * Sortier die ausserhalb des zeitraums aus
                         */
                        abonnements = new Vector<Abonnement>();
                        for (int k = 0; k < o2Abonnements.size(); k++) {
                            if (!startDateVal.after(o2Abonnements.elementAt(k).getCreationDate()) && !endDateVal.before(o2Abonnements.elementAt(k).getCreationDate()))
                                abonnements.add(o2Abonnements.elementAt(k));
                        }
                        o2Abonnements = abonnements;
                        /**
                         * Vergleiche und sortier nutzer nach der menge der abonnements ihrer pinnwand
                         */
                        return ((Integer)o2Abonnements.size()).compareTo((Integer)o1Abonnements.size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return 0;
                }
            });
        }
        
        /**
         * Schleife über alle Nutzer.
         */
        Vector<Row> rows = new Vector<Row>();
        for (int nutzerschleife = 0; nutzerschleife < nutzers.size(); nutzerschleife++) {
            Vector<Beitrag> beitraege = socialMediaLogic.getAllBeitragOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(nutzers.elementAt(nutzerschleife)));
            Vector<Beitrag> beitraege2 = new Vector<Beitrag>();
            for (int h = 0; h < beitraege.size(); h++) {
                if (!startDateVal.after(beitraege.elementAt(h).getCreationDate()) && !endDateVal.before(beitraege.elementAt(h).getCreationDate()))
                    beitraege2.add(beitraege.elementAt(h));
            }
            beitraege = beitraege2;
            Vector<Abonnement> abonnements = socialMediaLogic.getAllAbonnementsOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(nutzers.elementAt(nutzerschleife)));
            Vector<Abonnement> abonnements2 = new Vector<Abonnement>();
            for (int k = 0; k < abonnements.size(); k++) {
                if (!startDateVal.after(abonnements.elementAt(k).getCreationDate()) && !endDateVal.before(abonnements.elementAt(k).getCreationDate()))
                    abonnements2.add(abonnements.elementAt(k));
            }
            abonnements = abonnements2;
            int laufindex0 = (beitraege.size() > abonnements.size()) ?  beitraege.size() : abonnements.size();
            System.out.println(laufindex0);
            if (sortByVal==0){
                //sortByVal Beiträge
                /**
                 * Wenn erste Zeile dann TableHeader schreiben.
                 */
                if (nutzerschleife==0){
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
                    } catch (IndexOutOfBoundsException ex){
                        likes=new Vector<Like>();
                    }
                    try{
                        kommentare = socialMediaLogic.getAllKommentarOfBeitrag(beitraege.get(j));
                    } catch (IndexOutOfBoundsException ex){
                        kommentare=new Vector<Kommentar>();
                    }
                    Vector<Like> likes2 = new Vector<Like>();
                    for (int h = 0; h < likes.size(); h++) {
                        if (!startDateVal.after(likes.elementAt(h).getCreationDate()) && !endDateVal.before(likes.elementAt(h).getCreationDate()))
                            likes2.add(likes.elementAt(h));
                    }
                    likes = likes2;
                    Vector<Kommentar> kommentare2 = new Vector<Kommentar>();
                    for (int h = 0; h < kommentare.size(); h++) {
                        if (!startDateVal.after(kommentare.elementAt(h).getCreationDate()) && !endDateVal.before(kommentare.elementAt(h).getCreationDate()))
                            kommentare2.add(kommentare.elementAt(h));
                    }
                    kommentare = kommentare2;
                    int laufindex = (likes.size() > kommentare.size()) ?  likes.size() : kommentare.size();
                    if (laufindex==0)
                        laufindex=1;
                    /**
                     * Schleife über alle Likes und Kommentare, wovon mehr da ist.
                     * Wenn nix da ist dann leere Zeile erzeugen
                     */
                    for (int counter = 0; counter <  laufindex; counter++){
                        System.out.println(nutzerschleife + " " + j + " " + counter);
                        Row r0 = new RowImpl();
                        Column c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        if (j == 0){
                            r0.addColumn(writeNutzer(nutzers.elementAt(nutzerschleife)));
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
                                System.out.println("abos to print " + abonnements);
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
            }else if(sortByVal==1){
                //sortByVal Likes
                /**
                 * Wenn erste Zeile dann TableHeader schreiben.
                 */
                if (nutzerschleife==0){
                    Column c = new ColumnImpl();
                    Row r = new RowImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Nutzer"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Likes"));
                    c.addSubParagraph(new SimpleParagraphImpl(df.format(startDateVal) + " - " + df.format(endDateVal)));
                    c.addSubParagraph(new SimpleParagraphImpl("sort By Value"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Beiträge"));
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
                for (int j = 0; j < laufindex0;) {
                    Vector<Like> likes;
                    Vector<Kommentar> kommentare;
                    try{
                        likes = socialMediaLogic.getAllLikeOfBeitrag(beitraege.get(j));
                        kommentare = socialMediaLogic.getAllKommentarOfBeitrag(beitraege.get(j));
                    } catch (IndexOutOfBoundsException ex){
                        likes=new Vector<Like>();
                        kommentare=new Vector<Kommentar>();
                    }
                    Vector<Like> likes2 = new Vector<Like>();
                    for (int h = 0; h < likes.size(); h++) {
                        if (!startDateVal.after(likes.elementAt(h).getCreationDate()) && !endDateVal.before(likes.elementAt(h).getCreationDate()))
                            likes2.add(likes.elementAt(h));
                    }
                    likes = likes2;
                    Vector<Kommentar> kommentare2 = new Vector<Kommentar>();
                    for (int h = 0; h < kommentare.size(); h++) {
                        if (!startDateVal.after(kommentare.elementAt(h).getCreationDate()) && !endDateVal.before(kommentare.elementAt(h).getCreationDate()))
                            kommentare2.add(kommentare.elementAt(h));
                    }
                    kommentare = kommentare2;
                    int laufindex = (likes.size() > kommentare.size()) ?  likes.size() : kommentare.size();
                    /**
                     * Schleife über alle Likes und Kommentare, wovon mehr da ist.
                     * Wenn nix da ist dann leere Zeile erzeugen
                     */
                    for (int counter = 0; counter < laufindex; counter++){
                        Row r0 = new RowImpl();
                        Column c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        if (counter == 0){
                            r0.addColumn(writeNutzer(nutzers.elementAt(nutzerschleife)));
                            nutzerschleife++;
                        } else {
                            r0.addColumn(c);
                        }
                        try{
                            r0.addColumn(writeLike(likes.elementAt(counter)));
                            
                        } catch (IndexOutOfBoundsException ex){
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
            }else if(sortByVal==2){
                //sortByVal Abonnement
                /**
                 * Wenn erste Zeile dann TableHeader schreiben.
                 */
                if (nutzerschleife==0){
                    Column c = new ColumnImpl();
                    Row r = new RowImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Nutzer"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Abonnements"));
                    c.addSubParagraph(new SimpleParagraphImpl(df.format(startDateVal) + " - " + df.format(endDateVal)));
                    c.addSubParagraph(new SimpleParagraphImpl("sort By Value"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Beiträge"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Likes"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Kommentare"));
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
                    Vector<Like> likes2 = new Vector<Like>();
                    for (int h = 0; h < likes.size(); h++) {
                        if (!startDateVal.after(likes.elementAt(h).getCreationDate()) && !endDateVal.before(likes.elementAt(h).getCreationDate()))
                            likes2.add(likes.elementAt(h));
                    }
                    likes = likes2;
                    Vector<Kommentar> kommentare2 = new Vector<Kommentar>();
                    for (int h = 0; h < kommentare.size(); h++) {
                        if (!startDateVal.after(kommentare.elementAt(h).getCreationDate()) && !endDateVal.before(kommentare.elementAt(h).getCreationDate()))
                            kommentare2.add(kommentare.elementAt(h));
                    }
                    kommentare = kommentare2;
                    int laufindex = (likes.size() > kommentare.size()) ?  likes.size() : kommentare.size();
                    /**
                     * Schleife über alle Likes und Kommentare, wovon mehr da ist.
                     * Wenn nix da ist dann leere Zeile erzeugen
                     */
                    for (int counter = 0; counter < laufindex; counter++){
                        Row r0 = new RowImpl();
                        Column c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        if (counter == 0){
                            r0.addColumn(writeNutzer(nutzers.elementAt(nutzerschleife)));
                        } else {
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
                        rows.add(r0);
                    }
                }
            }
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
    public Report createPopularityOfBeitragReport (int sortByVal, final Date startDateVal, final Date endDateVal) throws RemoteException {
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
                        
                        /**
                         * Hole alle Kommentare der Beiträge
                         */
                        Vector<Kommentar> o1Kommentare = socialMediaLogic.getAllKommentarOfBeitrag(o1);
                        /**
                         * Sortier alle Kommentare ausserhalb des zeitraums aus
                         */
                        Vector<Kommentar> kommentare = new Vector<Kommentar>();
                        for (int h = 0; h < o1Kommentare.size(); h++) {
                            if (!startDateVal.after(o1Kommentare.elementAt(h).getCreationDate()) && !endDateVal.before(o1Kommentare.elementAt(h).getCreationDate()))
                                kommentare.add(o1Kommentare.elementAt(h));
                        }
                        o1Kommentare = kommentare;
                        /**
                         * Hole alle Kommentare der Beiträge
                         */
                        Vector<Kommentar> o2Kommentare  = socialMediaLogic.getAllKommentarOfBeitrag(o2);
                        /**
                         * Sortier alle Kommentare ausserhalb des zeitraums aus
                         */
                        kommentare = new Vector<Kommentar>();
                        for (int h = 0; h < o2Kommentare.size(); h++) {
                            if (!startDateVal.after(o2Kommentare.elementAt(h).getCreationDate()) && !endDateVal.before(o2Kommentare.elementAt(h).getCreationDate()))
                                kommentare.add(o2Kommentare.elementAt(h));
                        }
                        o2Kommentare = kommentare;
                        /**
                         * Vergleiche die menge der Kommentare und sortier die nutzer
                         */
                        
                        return ((Integer)o2Kommentare.size()).compareTo((Integer)o1Kommentare.size());
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
                        /**
                         * Hole alle Likes der Beiträge
                         */
                        Vector<Like> o1Likes = socialMediaLogic.getAllLikeOfBeitrag(o1);
                        /**
                         * Sortier alle Likes ausserhalb des zeitraums aus
                         */
                        Vector<Like> likes = new Vector<Like>();
                        for (int h = 0; h < o1Likes.size(); h++) {
                            if (!startDateVal.after(o1Likes.elementAt(h).getCreationDate()) && !endDateVal.before(o1Likes.elementAt(h).getCreationDate()))
                                likes.add(o1Likes.elementAt(h));
                        }
                        o1Likes = likes;
                        /**
                         * Hole alle Likes der Beiträge
                         */
                        Vector<Like> o2Likes  = socialMediaLogic.getAllLikeOfBeitrag(o2);
                        /**
                         * Sortier alle Likes ausserhalb des zeitraums aus
                         */
                        likes = new Vector<Like>();
                        for (int h = 0; h < o2Likes.size(); h++) {
                            if (!startDateVal.after(o2Likes.elementAt(h).getCreationDate()) && !endDateVal.before(o2Likes.elementAt(h).getCreationDate()))
                                likes.add(o2Likes.elementAt(h));
                        }
                        o2Likes = likes;
                        /**
                         * Vergleiche die menge der likes und sortier die nutzer
                         */
                        return ((Integer)o2Likes.size()).compareTo((Integer)o1Likes.size());
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
            Vector<Like> likes0 = new Vector<Like>();
            for (int k = 0; k < likes.size(); k++) {
                if (!startDateVal.after(likes.elementAt(k).getCreationDate()) && !endDateVal.before(likes.elementAt(k).getCreationDate()))
                    likes0.add(likes.elementAt(k));
            }
            likes = likes0;
            Vector<Kommentar> kommentare = socialMediaLogic.getAllKommentarOfBeitrag(beitrag);
            Vector<Kommentar> kommentare0 = new Vector<Kommentar>();
            for (int k = 0; k < kommentare.size(); k++) {
                if (!startDateVal.after(kommentare.elementAt(k).getCreationDate()) && !endDateVal.before(kommentare.elementAt(k).getCreationDate()))
                    kommentare0.add(kommentare.elementAt(k));
            }
            kommentare = kommentare0;
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
        column.addSubParagraph(new SimpleParagraphImpl("Abonnements: " + socialMediaLogic.getAllAbonnementOfNutzer(n).size()));
        column.addSubParagraph(new SimpleParagraphImpl("wurde Abonniert: " + socialMediaLogic.getAllAbonnementsOfPinnwand(socialMediaLogic.getPinnwandOfNutzer(n)).size()));
        return column;
    }
    
    /**
     * Helper method for the report generation. Edits a vector of <code>DataReference</code> so that only the objects between the two dates are present.
     * 
     * @param startDateVal - The <code>startDateVal</code> which should be sorted by.
     * @param endDateVal - The <code>endDateVal</code> which should be sorted by.
     * @param rfV - The vector <code>rfV</code> which should be sorted out.
     * @return Returns Vector<DataReference> of sorted objects which can be down casted.
     * @throws RemoteException 
     */
    private Vector<DataReference> sorterDf(final Date startDateVal, final Date endDateVal, Vector<DataReference> rfV) throws RemoteException{
        Vector<DataReference> rfErgV = new Vector<DataReference>();
        for (int h = 0; h < rfV.size(); h++) {
            if (!startDateVal.after(rfV.elementAt(h).getCreationDate()) && !endDateVal.before(rfV.elementAt(h).getCreationDate()))
                rfErgV.add(rfV.elementAt(h));
        }
        return rfErgV;
        
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

