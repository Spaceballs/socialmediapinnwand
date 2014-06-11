/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_IOandHelper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class ReadWriteTextFile {

    final static Charset ENCODING = StandardCharsets.UTF_8;
    
    public ReadWriteTextFile(){}
    
    public List<String> readSmallTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllLines(path, ENCODING);
    }

    public void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
        
        File policyFile = new File(aFileName);
        policyFile.createNewFile();
        PrintWriter writer = new PrintWriter(policyFile);
        for (int i = 0; i < aLines.size(); i++) {
            writer.println(aLines.get(i));
        }
        writer.close();
    }
}
