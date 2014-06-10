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
            
            System.out.println("\t Writing Header...");
            writeHeader();
            
            System.out.println("\t Writing HeaderAndTitleParagraph...");
            buffer.append("<H1>");
            writeParagraph(r.getHeaderAndTitleParagraph());
            buffer.append("</H1>").append("<p></p>").append("Report Datum: ").append(r.getCreationDate()).append("<p></p>");
            
            System.out.println("\t Writing BodyParagraph...");
            writeParagraph(r.getBodyParagraph());
            
            buffer.append("<p></p>"); 
            
            System.out.println("\t Writing Table...");
            tableToHTML(r.getRows());
            
            System.out.println("\t Writing Imprint...");
            writeImprint(r.getImprintParagraph());
            
            System.out.println("\t Writing Closures...");
            writeClosure();
            
            System.out.println("\t Writing finalizeDocument...");
            finalizeDocument(); 
    }
    
    /**
     * 
     */
    private void writeHeader() throws RemoteException{
        System.out.println("\t\t Writing HeaderAndTitleParagraph...");
        
        buffer.append("<html><head><title>");
        buffer.append(this.report.getHeaderAndTitleParagraph());
        buffer.append("</title></head><body>");
    }
    
    /**
     * 
     */
    private  void writeClosure(){
        System.out.println("\t\t Writing Closures...");
        buffer.append("</body></html>");
    }
    
    /**
     * 
     * @param rows 
     */
    private void tableToHTML(Vector<Row> rows) throws RemoteException{
        System.out.println(rows);
        System.out.println("\t\t Writing Table...");
        if (rows != null){
            buffer.append("<p></p>").append("<table border=\"3\" bordercolor=\"#c86260\" bgcolor=\"#ffffcc\" width=\"50%\" cellspacing=\"5\" cellpadding=\"3\">");
            for (int i = 0; i < rows.size(); i++) {
                if (i==0){
                    System.out.println("\t\t\t Writing HeadRow...");
                    writeHeadRow(rows.elementAt(i));
                } else {
                    System.out.println("\t\t\t Writing Rows...");
                    writeRow(rows.elementAt(i));
                }
            }
            buffer.append("</table>").append("<p></p>");
        }
    }
    
    
    /**
     * 
     * @param r 
     */
    private void writeRow(Row r) throws RemoteException{
        System.out.println("\t\t\t\t Writing Row...");
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
     * 
     * @param c 
     */
    private void writeColumn(Column c) throws RemoteException{
        System.out.println("\t\t\t\t\t Writing Column...");
        buffer.append("<td valign=\"top\">");
        buffer.append(c.toStrings());
        buffer.append("</td>");
    }
    
    /**
     * 
     * @param p 
     */
    private void writeParagraph(Paragraph p) throws RemoteException{
        if (p != null)
            if ( p instanceof CompositeParagraph) {
                System.out.println("\t\t Writing CompositeParagraph...");
                buffer.append(((CompositeParagraph)p).toStrings());
            } else if (p instanceof SimpleParagraph){
                System.out.println("\t\t Writing SimpleParagraph...");
                buffer.append(((SimpleParagraph)p).toStrings());
            } else if (p instanceof ColumnImpl){
                System.out.println("\t\t Casting Column to CompositeParagraph...");
                buffer.append(((Column) p).toStrings());
            }
    }

    /**
     * 
     * @param headRow 
     */
    private void writeHeadRow(Row headRow) throws RemoteException {
        System.out.println("\t\t\t\t Writing HeadRow...");
        buffer.append("<tr>");
        Vector<Column> columns = headRow.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            writeHeadColumn(columns.elementAt(i));
            System.out.println(columns.elementAt(i).toStrings());
        }
        buffer.append("</tr>");
    }

    /**
     * 
     * @param elementAt 
     */
    private void writeHeadColumn(Column c) throws RemoteException {
        System.out.println("\t\t\t\t\t Writing HeadColumn...");
        buffer.append("<valign=\"top\"><b>");
        buffer.append("<th valign=\"top\">").append(c.toStrings()).append("</th>");
        buffer.append("</b>");
    }

    private void writeImprint(Paragraph p) throws RemoteException {
        System.out.println("\t\t Writing Imprint...");
        writeParagraph(p);
    }
    
    
        
    /**
     * 
     */
    private void finalizeDocument() throws FileNotFoundException, IOException {
        String result = buffer.toString();
        result = result.replaceAll("&", "&amp;").replaceAll("%p", "<p>").replaceAll("%/p", "</p>").replaceAll("%tr", "</tr>").replaceAll("%/tr", "</tr>").replaceAll("%br", "<br>")
                .replaceAll("ä", "&auml;").replaceAll("ü", "&uuml;").replaceAll("ö", "&ouml;").replaceAll("ß", "&szlig;").replaceAll("Ä", "&Auml;").replaceAll("Ü", "&Uuml;").replaceAll("Ö", "&Ouml;");
        System.out.println(this.report.getClass().getSimpleName() + ".html");
        File htmlFile = new File("report.html");
        htmlFile.createNewFile();
        PrintWriter writer = new PrintWriter(htmlFile);
        writer.print(result);
        writer.close();
        Desktop.getDesktop().browse(htmlFile.toURI());
    }
}
