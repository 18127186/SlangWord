package com.SlangWord;

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
import java.util.HashMap;
public class readData {
    public HashMap<String,String> read(String filePath) {
        BufferedReader br;
        FileReader fr;
        HashMap<String,String> mapWord = new HashMap<String, String>();
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            
            String textInALine = br.readLine();
            String[] words;
            while ((textInALine) != null) {
                    textInALine = br.readLine();
                    if(textInALine == null) break;
                    words = textInALine.split("`");
                    mapWord.put(words[0], words[1]);       
             }
            fr.close();
            br.close();
        } catch (IOException e) {
             System.out.print("Khong co file");
             e.printStackTrace();
        }
        return mapWord;
    }
    
    
}
