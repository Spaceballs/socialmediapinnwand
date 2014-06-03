/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class HTMLWriter {
    
    StringBuilder buffer;
    Report report;
    
    /**
     * Constructor of the class. Checks for the type of the report and calls the method for the transformation.
     * 
     * @param contributionOfNutzerReport
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
     * 
     * @param r 
     */
    private void writeHTML (Report r) throws IOException{
            System.out.println("Writing Report...");
            writeHeader();
            buffer.append("<H1>");
            writeParagraph(r.getHeaderAndTitleParagraph());
            buffer.append("</H1>").append("<p></p>").append("Report Datum: ").append(r.getCreationDate()).append("<p></p>");
            writeParagraph(r.getBodyParagraph());
            buffer.append("<p></p>");            
            tableToHTML(r.getRows());
            
            //@todo WRITE CODE
            writeImprint(r.getImprintParagraph());
            writeClosure();
            finalizeDocument(); 
    }
    
    /**
     * 
     */
    private void writeHeader() throws RemoteException{
        buffer.append("<html><head><title>");
        buffer.append(this.report.getHeaderAndTitleParagraph());
        buffer.append("</title></head><body>");
    }
    
    /**
     * 
     */
    private  void writeClosure(){
        buffer.append("</body></html>");
    }
    
    /**
     * 
     * @param rows 
     */
    private void tableToHTML(Vector<Row> rows) throws RemoteException{
        if (rows != null){
            buffer.append("<p></p>").append("<table>");
                Row headRow = rows.firstElement();
                rows.remove(rows.firstElement());
                writeHeadRow(headRow);
                for (int i = 0; i < rows.size(); i++) {
                    Row row = rows.elementAt(i);
                }
            buffer.append("</table>").append("<p></p>");
        }
    }
    
    
    /**
     * 
     * @param r 
     */
    private void writeRow(Row r) throws RemoteException{
        buffer.append("<tr>");
        Vector<Column> columns = null; 
        try {
            columns = r.getColumns();
        } catch (RemoteException ex) {
            Logger.getLogger(HTMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(columns == null) {
        } else {
            for (int i = 0; i < columns.size(); i++) {
                writeColumn(columns.elementAt(i));
            }
        }
        buffer.append("</tr>");
    }
    
    /**
     * 
     * @param c 
     */
    private void writeColumn(Column c) throws RemoteException{
        buffer.append("<td valign=\"top\">");
        writeParagraph(c);
        buffer.append("</td>");
    }
    
    /**
     * 
     * @param p 
     */
    private void writeParagraph(Paragraph p) throws RemoteException{
        if ( p instanceof CompositeParagraph && p != null) {
            System.out.println("Writing CompositeParagraph...");
            this.writeParagraph((CompositeParagraph)p);
        } else if (p != null){
            System.out.println("Writing SimpleParagraph...");
            this.writeParagraph((SimpleParagraph)p);
        }
    }
    
    /**
     * 
     * @param p 
     */
    private void writeParagraph(CompositeParagraph p) throws RemoteException{
        for ( int i = 0; i < p.getNumParagraphs(); i++ ) {
            writeParagraph(p.getParagraphAt(i));
        }
    }
    
    /**
     * 
     * @param p 
     */
    private void writeParagraph(SimpleParagraph p) throws RemoteException{
        buffer.append(p.toStrings());
    }
    
    /**
     * 
     */
    private void finalizeDocument() throws FileNotFoundException, IOException {
        String result = buffer.toString();
        result = result.replaceAll("&", "&amp;").replaceAll("%p", "<p>").replaceAll("%/p", "</p>").replaceAll("ä", "&auml;").replaceAll("ü", "&uuml;").replaceAll("ö", "&ouml;").replaceAll("ß", "&szlig;")
                .replaceAll("Ä", "&Auml;").replaceAll("Ü", "&Uuml;").replaceAll("Ö", "&Ouml;");
        System.out.println(this.report.getClass().getSimpleName() + ".html");
        File htmlFile = new File("report.html");
        htmlFile.createNewFile();
        PrintWriter writer = new PrintWriter(htmlFile);
        writer.print(result);
        writer.close();
        Desktop.getDesktop().browse(htmlFile.toURI());
    }

    /**
     * 
     * @param headRow 
     */
    private void writeHeadRow(Row headRow) throws RemoteException {
        buffer.append("<tr>");
        Vector<Column> columns = headRow.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            writeHeadColumn(columns.elementAt(i));
        }
        buffer.append("</tr>");
    }

    /**
     * 
     * @param elementAt 
     */
    private void writeHeadColumn(Column c) {
        buffer.append("\"<valign=\\\"top\\\"><b>\"");
        buffer.append("<th valign=\"top\">").append(c.toString()).append("</th>");
        buffer.append("\"</b>\"");
    }

    private void writeImprint(Paragraph p) throws RemoteException {
        writeParagraph(p);
    }
}
