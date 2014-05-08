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
     * 
     * @param report 
     */
    public HTMLWriter (Object report){
        buffer = new StringBuilder();
        writeHeader();
        this.report = (Report) report;
        System.out.println(this.report);
        if (report instanceof ContributionOfNutzer) {
            System.out.println("ContributionOfNutzer");
            ContributionOfNutzer contributionOfNutzerReport = (ContributionOfNutzer) report;
            writeHTML(contributionOfNutzerReport);
        }
        if (report instanceof PopularityOfBeitrag) {
            System.out.println("PopularityOfBeitrag");
            PopularityOfBeitrag contributionOfNutzerReport = (PopularityOfBeitrag) report;
            writeHTML(contributionOfNutzerReport);
        }
        writeClosure();
        finalizeDocument();
    }
    
    /**
     * 
     * @param r 
     */
    private void writeHTML (ContributionOfNutzer r){
        try {
            System.out.println("Writing Report...");
            System.out.println(r.getReportTitle());
            buffer.append("\"<H1>\"").append(r.getReportTitle()).append("\"</H1>\"").append("\"<p></p>\"");
            
            tableToHTML(r.getAllRows());
            
            // TO-DO: WRITE CODE
            
        } catch (RemoteException ex) {
            Logger.getLogger(HTMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * 
     * @param r 
     */
    private void writeHTML (PopularityOfBeitrag r){
        try {
            System.out.println("Writing Report...");
            System.out.println(r.getReportTitle());
            buffer.append("<H1>").append(r.getReportTitle()).append("</H1>").append("<p></p>");
            
            tableToHTML(r.getAllRows());
            
            // TO-DO: WRITE CODE
            
        } catch (RemoteException ex) {
            Logger.getLogger(HTMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     */
    private void writeHeader(){
        buffer.append("<html><head><title></title></head><body>");
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
    public void tableToHTML(Vector<Row> rows){
        if (rows != null){
            buffer.append("\"<p></p>").append("\"<table>\"");
                Row headRow = rows.firstElement();
                rows.remove(rows.firstElement());
                writeHeadRow(headRow);
                for (int i = 0; i < rows.size(); i++) {
                    Row row = rows.elementAt(i);
                }
            buffer.append("\"</table>").append("\"<p></p>\"");
        }
    }
    
    
    /**
     * 
     * @param r 
     */
    public void writeRow(Row r){
        buffer.append("\"<tr>\"");
        Vector<Column> columns = null; 
        try {
            columns = r.getColumns();
        } catch (RemoteException ex) {
            Logger.getLogger(HTMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < columns.size(); i++) {
            writeColumn(columns.elementAt(i));
        }
        buffer.append("\"</tr>\"");
    }
    
    /**
     * 
     * @param c 
     */
    public void writeColumn(Column c){
        buffer.append("\"<td valign=\"top\">\"").append(c.toString()).append("\"</td>\"");
    }
    
    /**
     * 
     * @param p 
     */
    public void writeParagraph(Paragraph p){
        if ( p instanceof CompositeParagraphImpl ) {
            this.writeParagraph((CompositeParagraph)p);
        } else {
            this.writeParagraph((SimpleParagraph)p);
        }
    }
    
    /**
     * 
     * @param p 
     */
    public void writeParagraph(CompositeParagraph p){
        try {
            for ( int i = 0; i < p.getNumParagraphs(); i++ ) {
                buffer.append(p.getParagraphAt(i));
            }
        } catch (RemoteException ex) {
            Logger.getLogger(HTMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param p 
     */
    public void writeParagraph(SimpleParagraph p){
        buffer.append(p.toString());
    }
    
    /**
     * 
     */
    private void finalizeDocument() {
        String result = buffer.toString();
        result.replaceAll("\"%p\"", "\"<p>\"");
        result.replaceAll("\"%/p\"", "\"</p>\"");

        try {
            File htmlFile = new File("report.html");
            htmlFile.createNewFile();
            PrintWriter writer = new PrintWriter(htmlFile);
            writer.print(result);
            writer.close();
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HTMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HTMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param headRow 
     */
    private void writeHeadRow(Row headRow) {
        try {
            buffer.append("<tr>");
            Vector<Column> columns = headRow.getColumns();
            for (int i = 0; i < columns.size(); i++) {
                writeHeadColumn(columns.elementAt(i));
            }
            buffer.append("</tr>");
        } catch (RemoteException ex) {
            Logger.getLogger(HTMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
