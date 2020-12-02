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
import java.io.File;
import java.util.HashMap;
public class MainProject {
    public static void main(String[] args) {
        String filePath = new File("src\\main\\java\\com\\SlangWord\\source\\slang.txt").getAbsolutePath();
        readData rd = new readData();
        GUI UI = new GUI();
        UI.mapGoc = rd.read(filePath);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UI.createAndShowGUI();
            }
        });
    }
}
