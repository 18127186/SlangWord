/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trand
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
public class readData {
    public HashMap<String,String> read(String filePath) {
        BufferedReader br;
        HashMap<String,String> mapWord = new HashMap<String, String>();
        try {
            br = new BufferedReader(new FileReader(filePath));       
            String textInALine = br.readLine();
            String[] words;
            while ((textInALine) != null) {
                    textInALine = br.readLine();
                    if(textInALine == null) break;
                    words = textInALine.split("`");
                    mapWord.put(words[0], words[1]);       
             }
            
         } catch (IOException e) {
             System.out.print("Khong co file");
             e.printStackTrace();
        }
        return mapWord;
    }
    
    
}
