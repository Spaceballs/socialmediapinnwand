/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class HTMLWriter {
    
    StringBuilder buffer;
    
    /**
     * 
     * @param report 
     */
    public HTMLWriter (Object report){
        buffer = new StringBuilder();
        writeHeader();
        if (report instanceof ContributionOfNutzer) {
            ContributionOfNutzer contributionOfNutzerReport = (ContributionOfNutzer) report;
            writeHTML(contributionOfNutzerReport);
        }
        if (report instanceof PopularityOfBeitrag) {
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
        buffer.append("\"<H1>\"").append(r.getReportTitle()).append("\"</H1>\"").append("\"<p></p>\"");
        
        tableToHTML(r.getAllRows());
        
        // TO-DO: WRITE CODE
        
    }
    
    /**
     * 
     * @param r 
     */
    private void writeHTML (PopularityOfBeitrag r){
        buffer.append("\"<H1>\"").append(r.getReportTitle()).append("\"</H1>\"").append("\"<p></p>\"");
        tableToHTML(r.getAllRows());
        // TO-DO: WRITE CODE
    }
    
    /**
     * 
     */
    private void writeHeader(){
        buffer.append("\"<html><head><title></title></head><body>\"");
    }
    
    /**
     * 
     */
    private  void writeClosure(){
        buffer.append("\"</body></html>\"");
    }
    
    /**
     * 
     * @param rows 
     */
    public void tableToHTML(Vector<Row> rows){
        buffer.append("\"<p></p>").append("\"<table>\"");
            Row headRow = rows.firstElement();
            rows.remove(rows.firstElement());
            buffer.append("\"<valign=\\\"top\\\"><b>\"");
            writeHeadRow(headRow);
            buffer.append("\"</b>\"");
            for (int i = 0; i < rows.size(); i++) {
                Row row = rows.elementAt(i);
            }
        buffer.append("\"</table>").append("\"<p></p>\"");
    }
    
    
    /**
     * 
     * @param r 
     */
    public void writeRow(Row r){
        buffer.append("\"<tr>\"");
        Vector<Column> columns = r.getColumns(); 
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
        if ( p instanceof CompositeParagraph ) {
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
        for ( int i = 0; i < p.getNumParagraphs(); i++ ) {
                buffer.append(p.getParagraphAt(i));
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
        result.replace("\"%p\"", "\"<p>\"");
        result.replace("\"%/p\"", "\"</p>\"");

        try {
            File htmlFile = new File("path/to/html/file.html");
            PrintWriter writer = new PrintWriter(htmlFile);
            writer.print(result);
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
        buffer.append("<th valign=\"top\">").append(c.toString()).append("</th>");
    }
}
