
package SocialMedia_Report;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates the format of the Reports in HTML
 * @author Sebastian
 */
public class HTMLWriter {
    
    StringBuilder buffer;
    Report report;
    private final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);
    
    /**
     * Constructor for the class
     * @param report - a Report
     */
    public HTMLWriter (Report report){
        buffer = new StringBuilder();
        this.report = report;
        try {
            writeHTML(report);
        } catch (IOException ex) {
            Logger.getLogger(HTMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @todo was macht des? :D
     * @param r
     * @throws IOException 
     */
    private void writeHTML (Report r) throws IOException{
            Logger.getLogger(this.getClass().getName()).info("Writing Report...");
            
            Logger.getLogger(this.getClass().getName()).info("\t Writing Header...");
            writeHeader();
            
            Logger.getLogger(this.getClass().getName()).info("\t Writing HeaderAndTitleParagraph...");
            buffer.append("<H1>");
            writeParagraph(r.getHeaderAndTitleParagraph());
            buffer.append("</H1>").append("<p></p>").append("Report Datum: ").append(df.format(r.getCreationDate())).append("<p></p>");
            
            Logger.getLogger(this.getClass().getName()).info("\t Writing BodyParagraph...");
            writeParagraph(r.getBodyParagraph());
            
            buffer.append("<p></p>"); 
            
            Logger.getLogger(this.getClass().getName()).info("\t Writing Table...");
            tableToHTML(r.getRows());
            
            Logger.getLogger(this.getClass().getName()).info("\t Writing Imprint...");
            writeImprint(r.getImprintParagraph());
            
            Logger.getLogger(this.getClass().getName()).info("\t Writing Closures...");
            writeClosure();
            
            Logger.getLogger(this.getClass().getName()).info("\t Writing finalizeDocument...");
            finalizeDocument(); 
    }
    
    /**
     * Writes the Header and Title
     * @throws RemoteException 
     */
    private void writeHeader() throws RemoteException{
        Logger.getLogger(this.getClass().getName()).info("\t\t Writing HeaderAndTitleParagraph...");
        
        buffer.append("<html><head><title>");
        buffer.append(((SimpleParagraph)this.report.getHeaderAndTitleParagraph()).toStrings());
        buffer.append("</title></head><body style=\"width:1024px\">");
    }
    
    /**
     * Writes the closure
     */
    private  void writeClosure(){
        Logger.getLogger(this.getClass().getName()).info("\t\t Writing Closures...");
        buffer.append("</body></html>");
    }
    
    /**
     * Converts the Vector of Rows into HTML
     * @param rows - a Vector of Rows
     * @throws RemoteException 
     */
    private void tableToHTML(Vector<Row> rows) throws RemoteException{
        Logger.getLogger(this.getClass().getName()).info("\t\t Writing Table...");
        if (rows != null){
            buffer.append("<p></p>").append("<table border=\"3\" bordercolor=\"#c86260\" bgcolor=\"#ffffcc\" width=\"99%\" cellspacing=\"5\" cellpadding=\"3\">");
            for (int i = 0; i < rows.size(); i++) {
                if (i==0){
                    Logger.getLogger(this.getClass().getName()).info("\t\t\t Writing HeadRow...");
                    writeHeadRow(rows.elementAt(i));
                } else {
                    Logger.getLogger(this.getClass().getName()).info("\t\t\t Writing Rows...");
                    writeRow(rows.elementAt(i));
                }
            }
            buffer.append("</table>").append("<p></p>");
        }
    }
    
    /**
     * Writes a Row
     * @param r - a Row
     * @throws RemoteException 
     */
    private void writeRow(Row r) throws RemoteException{
        Logger.getLogger(this.getClass().getName()).info("\t\t\t\t Writing Row...");
        buffer.append("<tr>");
        Vector<Column> columns = r.getColumns();
        if(columns == null) {
        } else {
            for (int i = 0; i < columns.size(); i++) {
                writeColumn(columns.elementAt(i));
            }
        }
        buffer.append("</tr>");
    }
    
    /**
     * Writes a Column
     * @param c - a Column
     * @throws RemoteException 
     */
    private void writeColumn(Column c) throws RemoteException{
        Logger.getLogger(this.getClass().getName()).info("\t\t\t\t\t Writing Column...");
        buffer.append("<td valign=\"top\">");
        buffer.append(c.toStrings());
        buffer.append("</td>");
    }
    
    /**
     * Writes a Paragraph
     * @param p - a Paragraph
     * @throws RemoteException 
     */
    private void writeParagraph(Paragraph p) throws RemoteException{
        if (p != null)
            if ( p instanceof CompositeParagraph) {
                Logger.getLogger(this.getClass().getName()).info("\t\t Writing CompositeParagraph...");
                buffer.append(((CompositeParagraph)p).toStrings());
            } else if (p instanceof SimpleParagraph){
                Logger.getLogger(this.getClass().getName()).info("\t\t Writing SimpleParagraph...");
                buffer.append(((SimpleParagraph)p).toStrings());
            }
    }

    /**
     * Writes the HeadRow
     * @param headRow - a Row
     * @throws RemoteException 
     */
    private void writeHeadRow(Row headRow) throws RemoteException {
        Logger.getLogger(this.getClass().getName()).info("\t\t\t\t Writing HeadRow...");
        buffer.append("<tr>");
        Vector<Column> columns = headRow.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            writeHeadColumn(columns.elementAt(i));
        }
        buffer.append("</tr>");
    }

    /**
     * Writes the HeadColumn
     * @param c - a Column
     * @throws RemoteException 
     */
    private void writeHeadColumn(Column c) throws RemoteException {
        Logger.getLogger(this.getClass().getName()).info("\t\t\t\t\t Writing HeadColumn...");
        buffer.append("<valign=\"top\"><b>");
        buffer.append("<th valign=\"top\">").append(c.toStrings()).append("</th>");
        buffer.append("</b>");
    }

    /**
     * Writes the imprint
     * @param p - a Paragraph
     * @throws RemoteException 
     */
    private void writeImprint(Paragraph p) throws RemoteException {
        Logger.getLogger(this.getClass().getName()).info("\t\t Writing Imprint...");
        writeParagraph(p);
    }
    
    /**
     * Finalizes the HTML report
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void finalizeDocument() throws FileNotFoundException, IOException {
        String result = buffer.toString();
        result = result.replaceAll("&", "&amp;").replaceAll("%p", "<p>").replaceAll("%/p", "</p>").replaceAll("%tr", "</tr>").replaceAll("%/tr", "</tr>").replaceAll("%br", "<br>")
                .replaceAll("ä", "&auml;").replaceAll("ü", "&uuml;").replaceAll("ö", "&ouml;").replaceAll("ß", "&szlig;")
                .replaceAll("Ä", "&Auml;").replaceAll("Ü", "&Uuml;").replaceAll("Ö", "&Ouml;")
                .replaceAll("é", "&eacute;").replaceAll("è", "&egrave;").replaceAll("ê", "&ecirc;")
                .replaceAll("ì", "&igrave;").replaceAll("í", "&iacute;").replaceAll("î", "&icirc;")
                .replaceAll("ò", "&oacute;").replaceAll("ó", "&ograve;").replaceAll("ô", "&ocirc;")
                .replaceAll("ù", "&uacute;").replaceAll("ú", "&ugrave;").replaceAll("û", "&ucirc;");
        File htmlFile = new File("report_von_" + df.format(report.getStartDate()) + "_bis_" + df.format(report.getEndDate()) + ".html");
        htmlFile.createNewFile();
        PrintWriter writer = new PrintWriter(htmlFile);
        writer.print(result);
        writer.close();
        Desktop.getDesktop().browse(htmlFile.toURI());
    }
}
