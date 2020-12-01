
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trand
 */
public class GUI  implements ActionListener{
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    //GUI1
    public  JTextField searchWord;
    
    public GridBagConstraints c = new GridBagConstraints();
    public   JButton button;
    public HashMap<String,String> mapGoc;  
    public List<String> history = new ArrayList<String>();
    public JTextArea fieldReadOnly ;
    public JFrame frame1 = new JFrame("Slang Word");
    //New SlangWord
    public  JTextField newWord,NewWordReadOnly,NewDef,NewDefReadOnly;
    public JTextField notification;
    //function 9,10 ABCD
    public JTextField A,B,C,D;
    //function 1,2,3: Fix bug
    public JList<String> list ;
    public JScrollPane field= new JScrollPane();;
    
    //Menu
    public void FirstOfAddComponents(Container pane){
        if (RIGHT_TO_LEFT) 
            {
                pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            }
        pane.setLayout(new GridBagLayout());
        if (shouldFill) 
            {
                c.fill = GridBagConstraints.HORIZONTAL;
            }
    }
    public void addComponentsToPane(Container pane) {
        FirstOfAddComponents(pane);
        button = new JButton("Search with slang word ");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 80;  
        c.weighty = 0.1;
        pane.add(button, c);
        button.setActionCommand("Search with slang word ");   
        
        button.addActionListener(this);

        button = new JButton(" Search with definition ");
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 3;
        c.ipady = 20; 
        c.ipadx = 80;   
        c.insets = new Insets(5,200,5,200);  
        pane.add(button, c);
        button.setActionCommand(" Search with definition ");   
        
        button.addActionListener(this);

        button = new JButton("    History of search     ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 2;  
        c.weightx = 0.0;
        c.weighty = 0.1;
        pane.add(button, c);
        button.setActionCommand("    History of search     ");   
        
        button.addActionListener(this);
        button = new JButton("      Add slang word      ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 3;  
        c.weightx = 0.0;
        c.weighty = 0.1;
        pane.add(button, c);
        button.setActionCommand("      Add slang word      ");   
        
        button.addActionListener(this);
        button = new JButton("      Edit slang word      ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 4;  
        c.weightx = 0.0;
        c.weighty = 0.1;
        pane.add(button, c);
        button.setActionCommand("      Edit slang word      ");   
        
        button.addActionListener(this);
        button = new JButton("    Delete slang word    ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 5;  
        c.weightx = 0.0;
        c.weighty = 0.1;
        pane.add(button, c);
        button.setActionCommand("    Delete slang word    ");   
        
        button.addActionListener(this);
        button = new JButton("              Reset                ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200); 
        c.gridx = 1;
        c.gridy = 6;  
        c.weighty = 0.1;
        pane.add(button, c); 
        button.setActionCommand("              Reset                ");   
        
        button.addActionListener(this);
        button = new JButton("    Random slang word    ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 7;  
        c.weighty = 0.1;
        pane.add(button, c);
        button.setActionCommand("    Random slang word    ");   
        
        button.addActionListener(this);
        button = new JButton("   Game find definition    ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 8;  
        c.weighty = 0.1;
        pane.add(button, c);
        button.setActionCommand("   Game find definition    ");   
        
        button.addActionListener(this);
        button = new JButton("  Game find slang word   ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 9;  
        c.weighty = 0.1;
        pane.add(button, c);
        button.setActionCommand("  Game find slang word   ");   
        
        button.addActionListener(this);
    }
    public void createAndShowGUI() {
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame1.getContentPane());
        
        create();
        frame1.pack();
        frame1.setVisible(true);
    }
    //
    //function 1
    public void addComponentsToPaneSearchWord(Container pane){       
        searchWord = new JTextField(20);
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        pane.add(searchWord, c);
        button = new JButton("Search Definition");
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Search definition");    
        button.addActionListener(this);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
        fieldReadOnly = new JTextArea(15,35);
        fieldReadOnly.setEditable(false);
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 300;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        pane.add(fieldReadOnly,c);
    }
  
    public void GUIsearchWord(){
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPaneSearchWord(frame1.getContentPane());
        
        frame1.pack();
        frame1.setVisible(true);
    }
    //
    //function 2
    public void addComponentsToPaneFunction2(Container pane){       
        searchWord = new JTextField(20);
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        pane.add(searchWord, c);
        button = new JButton("Search Key");
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Search Key");    
        button.addActionListener(this);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
        
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 300;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        pane.add(field,c);
    }
  
    public void GUIfunction2(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        addComponentsToPaneFunction2(frame1.getContentPane());
        
        frame1.pack();
        frame1.setVisible(true);
    }
    // 
    //Function 3
    public void addComponentsToPaneFunction3(Container pane){       
        FirstOfAddComponents(pane);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
         
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 300;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        pane.add(field,c);
    }
    public void GUIfunction3(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        addComponentsToPaneFunction3(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    }
    //
    //Function 4
    public void CreateText(){
        newWord = new JTextField(20);
        NewWordReadOnly = new JTextField();
        NewDef = new JTextField(100);
        NewDefReadOnly = new JTextField();
        
    }
    public void addComponentsToPaneFunction4(Container pane){       
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewWordReadOnly.setText("New Slang Word");
        NewWordReadOnly.setEditable(false);
        pane.add(NewWordReadOnly, c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        pane.add(newWord, c);
         c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewDefReadOnly.setText("New Definition");
        NewDefReadOnly.setEditable(false);
        pane.add(NewDefReadOnly, c);
        
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        
        pane.add(NewDef, c);
        notification = new JTextField(20);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        notification.setText("");
        notification.setEditable(false);
        pane.add(notification, c);
        button = new JButton("Add Slang Word");
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Add Slang Word");    
        button.addActionListener(this);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
    }
    public void GUIfunction4(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        CreateText();
        addComponentsToPaneFunction4(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    }
    public void addComponentsToPaneFunction4WhenError(Container pane){       
        button = new JButton("OverWrite");
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("OverWrite");    
        button.addActionListener(this);
        button = new JButton("Duplicated");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Duplicated");    
        button.addActionListener(this);
    }
    public void GUIfunctionwWhenAddError(){
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        addComponentsToPaneFunction4(frame1.getContentPane());    
        addComponentsToPaneFunction4WhenError(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    }
    //
    //function 5
    public void addComponentsToPaneFunction5EditValue(Container pane){       
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewWordReadOnly.setText("Slang Word");
        NewWordReadOnly.setEditable(false);
        pane.add(NewWordReadOnly, c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        pane.add(newWord, c);
         c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewDefReadOnly.setText("New Meaning");
        NewDefReadOnly.setEditable(false);
        pane.add(NewDefReadOnly, c);
        
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        
        pane.add(NewDef, c);
        
        notification = new JTextField(20);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        notification.setText("");
        notification.setEditable(false);
        pane.add(notification, c);
        button = new JButton("Edit");
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Edit Meaning");    
        button.addActionListener(this);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
    } //Edit value
    public void GUIfunction5EditValue(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        CreateText();
        addComponentsToPaneFunction5EditValue(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    } // Edit Value
    public void addComponentsToPaneFunction5(Container pane){       
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewWordReadOnly.setText("Slang Word");
        NewWordReadOnly.setEditable(false);
        pane.add(NewWordReadOnly, c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        pane.add(newWord, c);
         c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewDefReadOnly.setText("New Slang Word");
        NewDefReadOnly.setEditable(false);
        pane.add(NewDefReadOnly, c);
        
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        
        pane.add(NewDef, c);
        
        notification = new JTextField(20);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        notification.setText("");
        notification.setEditable(false);
        pane.add(notification, c);
        button = new JButton("Edit");
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Edit Slang Word");    
        button.addActionListener(this);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
    } //Edit key
    public void GUIfunction5(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        CreateText();
        addComponentsToPaneFunction5(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    } // Edit key
    public void addComponentsToPaneFunction5Menu(Container pane){       
        button = new JButton("Edit Slang Word");
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Edit Slang Word Menu");    
        button.addActionListener(this);
        button = new JButton("Edit Meaning");
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Edit Meaning Menu");    
        button.addActionListener(this);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
    }
    public void GUIfunction5Menu(){     
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        CreateText();
        addComponentsToPaneFunction5Menu(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    }
    //
    //function 6
    public void addComponentsToPaneFunction6(Container pane){       
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewWordReadOnly.setText("Slang Word");
        NewWordReadOnly.setEditable(false);
        pane.add(NewWordReadOnly, c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        pane.add(newWord, c);
        notification = new JTextField(20);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        notification.setText("");
        notification.setEditable(false);
        pane.add(notification, c);
        button = new JButton("Remove");
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Remove Slang Word");    
        button.addActionListener(this);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
    }
    public void GUIfunction6(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        CreateText();
        addComponentsToPaneFunction6(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    }
    public void addComponentsToPaneFunction6Confirm(Container pane){       
        button = new JButton("Apply");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Apply");    
        button.addActionListener(this);
        button = new JButton("Cancel");
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Cancel");    
        button.addActionListener(this);
    }
    public void GUIfunction6Confirm(){
        
        addComponentsToPaneFunction6Confirm(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    }
    //
    //function 7
    public void addComponentsToPaneFunction7(Container pane){       
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewWordReadOnly.setText("Reset Success");
        NewWordReadOnly.setEditable(false);
        pane.add(NewWordReadOnly, c);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
    }
    public void GUIfunction7(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        CreateText();
        addComponentsToPaneFunction7(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    }
    //
    //function 8
    public void addComponentsToPaneFunction8(Container pane){       
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewWordReadOnly.setEditable(false);
        pane.add(NewWordReadOnly, c);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
    }
    public void GUIfunction8(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        CreateText();
        addComponentsToPaneFunction8(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    }
    //
    
    //function 9
    public void addComponentsToPaneFunction9(Container pane){       
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewWordReadOnly = new JTextField();
        NewWordReadOnly.setEditable(false);
        pane.add(NewWordReadOnly, c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewDefReadOnly = new JTextField();
        NewDefReadOnly.setText("Answer: ");
        NewDefReadOnly.setEditable(false);
        pane.add(NewDefReadOnly, c);
              
        button = new JButton("A. " + A.getText());
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("A");    
        button.addActionListener(this);
        
        button = new JButton("B. " + B.getText());
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("B");    
        button.addActionListener(this);
        
        button = new JButton("C. " + C.getText());
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("C");    
        button.addActionListener(this);
        
        button = new JButton("D. " + D.getText());
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("D");    
        button.addActionListener(this);
        button = new JButton("New Question");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("New");    
        button.addActionListener(this);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
    }
    public void GUIfunction9(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        addComponentsToPaneFunction9(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    } 
    //
    // function 10
    public void addComponentsToPaneFunction10(Container pane){       
        FirstOfAddComponents(pane);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewWordReadOnly = new JTextField();
        NewWordReadOnly.setEditable(false);
        pane.add(NewWordReadOnly, c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 300;  
        c.weighty = 0.1;
        NewDefReadOnly = new JTextField();
        NewDefReadOnly.setText("Answer: ");
        NewDefReadOnly.setEditable(false);
        pane.add(NewDefReadOnly, c);
              
        button = new JButton("A. " + A.getText());
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("A10");    
        button.addActionListener(this);
        
        button = new JButton("B. " + B.getText());
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("B10");    
        button.addActionListener(this);
        
        button = new JButton("C. " + C.getText());
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("C10");    
        button.addActionListener(this);
        
        button = new JButton("D. " + D.getText());
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("D10");    
        button.addActionListener(this);
        button = new JButton("New Question");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("New10");    
        button.addActionListener(this);
        button = new JButton("Exit");
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Exit");    
        button.addActionListener(this);
    }
    public void GUIfunction10(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        addComponentsToPaneFunction10(frame1.getContentPane());
        frame1.pack();
        frame1.setVisible(true);
    } 
    //
    public void actionPerformed(ActionEvent e)
	{
		String strActionCommand = e.getActionCommand();
		if (strActionCommand.equals("Search with slang word "))
		{
                        GUIsearchWord(); // Function 1 giao dien
                }
                else if (strActionCommand.equals("Exit") ){
                        createAndShowGUI(); // quay ve giao dien chinh
                        }
                else if (strActionCommand.equals(" Search with definition ") ){
                        GUIfunction2(); // function 2 giao dien
                        field.setViewportView(null);
                        }
                else if(strActionCommand.equals("Search definition")){ //Function 1: Search definition from key
                            String find = searchWord.getText();
                            history.add(find);
                            writeFile();
                            String ans= "";
                            if (find.equals("")){
                                searchWord.requestFocus();
                                }
                            else ans = searchWord(mapGoc, find);
                            fieldReadOnly.setText(ans);
                            System.out.println(ans);
                        
                }else if(strActionCommand.equals("Search Key")){ //Function 2: Search key from definition
                            String find = searchWord.getText();
                            history.add(find);
                            writeFile();
                            List<String> ans= null;
                            if (find.equals("")){
                                searchWord.requestFocus();
                            }
                            else ans = searchDef(mapGoc, find);
                            String text = null;
                            if (ans.size()== 0 ) ans.add("Not found!!!");
                            list = new JList<String>(ans.toArray(new String[ans.size()]));

                            field.setViewportView(list);
                            list.setLayoutOrientation(JList.VERTICAL);    
                }
                else if (strActionCommand.equals("    History of search     ") ){
                        
                        list = new JList<String>(history.toArray(new String[history.size()]));
                        
                        field.setViewportView(list);
                        list.setLayoutOrientation(JList.VERTICAL);
                        GUIfunction3(); //function 3: Giao dien
                }
                else if (strActionCommand.equals("      Add slang word      ") ){
                        GUIfunction4(); //function 4: Giao dien
                }
                else if (strActionCommand.equals("Add Slang Word") ){
                         //function 4: Add new slang word
                         String add = newWord.getText();
                         add = add.toUpperCase();
                         String def = NewDef.getText();
                         if(mapGoc.containsKey(add)){
                             GUIfunctionwWhenAddError();
                         }
                         else{
                             mapGoc.put(add, def);
                             writeFileWhenChangeMap();
                             newWord.setText("");
                             NewDef.setText("");
                             notification.setText("Add success");
                         }
                }
                else if (strActionCommand.equals("OverWrite") ){
                         //function 4: Add new slang word
                         String add = newWord.getText();
                         add = add.toUpperCase();
                         String def = NewDef.getText();
                         OverWrite(add, def);
                         writeFileWhenChangeMap();
                         notification.setText("Add success");
                }
                else if (strActionCommand.equals("Duplicated") ){
                         //function 4: Add new slang word
                         String add = newWord.getText();
                         add = add.toUpperCase();
                         String def = NewDef.getText();
                         Duplicated(add, def);
                         writeFileWhenChangeMap();
                         notification.setText("Add success");
                }
                else if (strActionCommand.equals("      Edit slang word      ") ){
                         //function 5: Edit slang word
                         GUIfunction5Menu();
                }
                else if (strActionCommand.equals("Edit Slang Word Menu") ){
                         //function 5: Edit slang word
                         GUIfunction5();
                }
                else if (strActionCommand.equals("Edit Meaning Menu") ){
                         //function 5: Edit slang word
                         GUIfunction5EditValue();
                }
                else if (strActionCommand.equals("Edit Meaning") ){
                         //function 5: Edit slang word
                         String key = newWord.getText();
                         key = key.toUpperCase();
                         String newdef = NewDef.getText();
                         if(mapGoc.containsKey(key)){
                            
                            mapGoc.put(key, newdef);
                            writeFileWhenChangeMap();
                            newWord.setText("");
                            NewDef.setText("");
                            notification.setText("Edit success");
                        }
                         else{
                             notification.setText("Not Found Slang Word");
                         }
                }
                else if (strActionCommand.equals("Edit Slang Word") ){
                         //function 5: Edit slang word
                         String oldkey = newWord.getText();
                         oldkey = oldkey.toUpperCase();
                         String newkey = NewDef.getText();
                         newkey = newkey.toUpperCase();
                         if(mapGoc.containsKey(oldkey)){
                             mapGoc.put(newkey,mapGoc.get(oldkey));
                             mapGoc.remove(oldkey);   
                             newWord.setText("");
                             NewDef.setText("");
                             writeFileWhenChangeMap();
                            notification.setText("Edit success ");
                        
                        }
                         else{
                             notification.setText("Not Found Slang Word");
                         }
                }
                else if (strActionCommand.equals("    Delete slang word    ") ){
                         //function 6: Remove slang word
                         GUIfunction6();
                         
                }
                else if (strActionCommand.equals("Remove Slang Word") ){
                         //function 6: Remove slang word
                         GUIfunction6Confirm();
                }
                else if (strActionCommand.equals("Apply") ){
                         //function 6: Remove slang word
                         String key = newWord.getText();
                         key = key.toUpperCase();
                         if(mapGoc.containsKey(key)){
                            mapGoc.remove(key);
                            GUIfunction6();
                            writeFileWhenChangeMap();
                            notification.setText("Remove success ");
                        }
                         else{
                             GUIfunction6();
                             notification.setText("Not Found Slang Word");
                         }   
                }
                else if (strActionCommand.equals("Cancel") ){
                         //function 6: Remove slang word
                         GUIfunction6();
                }
                else if (strActionCommand.equals("              Reset                ") ){
                         //function 7: Reset slang word
                         GUIfunction7();
                         mapGoc.clear();
                         String filePath = new File("src\\main\\java\\slangwordgoc.txt").getAbsolutePath();
                         readData rd = new readData();
                         mapGoc = rd.read(filePath);
                }
                else if (strActionCommand.equals("    Random slang word    ") ){
                         //function 8: Random
                         GUIfunction8();
                         String KeyRandom = RandomKey();
                         NewWordReadOnly.setText(KeyRandom);
                }
                else if (strActionCommand.equals("   Game find definition    ") ){
                         //function 9: Game find def 
                         String KeyRandom = RandomKey();
                         Random4Def(KeyRandom);
                         GUIfunction9();
                         NewWordReadOnly.setText(KeyRandom);
                         
                }
                else if (strActionCommand.equals("New") ){
                         //function 9: Game find def
                         String KeyRandom = RandomKey();
                         Random4Def(KeyRandom);
                         GUIfunction9();
                         NewWordReadOnly.setText(KeyRandom);
                }
                else if (strActionCommand.equals("A") ){
                         //function 9: Game find def
                         CompareAnsAndQues9(A, NewWordReadOnly);
                }
                else if (strActionCommand.equals("B") ){
                         //function 9: Game find def
                         CompareAnsAndQues9(B, NewWordReadOnly);
                }
                else if (strActionCommand.equals("C") ){
                         //function 9: Game find def
                         CompareAnsAndQues9(C, NewWordReadOnly);
                }
                else if (strActionCommand.equals("D") ){
                         //function 9: Game find def
                         CompareAnsAndQues9(D, NewWordReadOnly);
                }
                else if (strActionCommand.equals("  Game find slang word   ") ){
                         //function 10: Game find slang 
                         String[] ValueRandom = new String[2];
                         ValueRandom = RandomValueHaveKey();
                         Random4Slang(ValueRandom[0],ValueRandom[1]);
                         GUIfunction10();
                         NewWordReadOnly.setText(ValueRandom[1]);
                         newWord = new JTextField(); // Muon tam cai newWord de luu tru key ket qua va khoi tao bien moi
                         newWord.setText(ValueRandom[0]);
                }
                else if (strActionCommand.equals("New10") ){
                         //function 10: Game find slang
                         String[] ValueRandom = new String[2];
                         ValueRandom = RandomValueHaveKey();
                         Random4Slang(ValueRandom[0],ValueRandom[1]);
                         GUIfunction10();
                         NewWordReadOnly.setText(ValueRandom[1]);
                         newWord = new JTextField(); // Muon tam cai newWord de luu tru key ket qua va khoi tao bien moi
                         newWord.setText(ValueRandom[0]);
                         
                }
                else if (strActionCommand.equals("A10") ){
                         //function 10: Game find slang
                         CompareAnsAndQues10(A, newWord);
                }
                else if (strActionCommand.equals("B10") ){
                         //function 10: Game find slang
                         CompareAnsAndQues10(B, newWord);
                }
                else if (strActionCommand.equals("C10") ){
                        //function 10: Game find slang
                         CompareAnsAndQues10(C, newWord);
                }
                else if (strActionCommand.equals("D10") ){
                         //function 10: Game find slang
                         CompareAnsAndQues10(D, newWord);
                }
        }
    //
    //Write file when change map
    public void writeFileWhenChangeMap(){
        try {
            String filePath = new File("src\\main\\java\\slang.txt").getAbsolutePath();
            File fw = new File(filePath);
            
            OutputStream outputStream = new FileOutputStream(fw);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write("Slag`Meaning\n");
            for (String key : mapGoc.keySet()) {
                outputStreamWriter.write(key + "`" + mapGoc.get(key) + "\n");
               }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //
    //Function 1
    public String searchWord(HashMap<String,String> map,String find){
        String ans ="";
        find = find.toUpperCase();
        String search;
        for (String i : map.keySet()) {
            search = i.toUpperCase();
            if (search.equals(find)) {
                ans = map.get(i);
            }
        }
        if (ans == "") ans ="Not found!!!";
        return ans;
        }
    //
    //Function 2
    public static List<String> getKey(HashMap<String, String> map, String value) {
        List<String> ans = new ArrayList<String>();
        value = value.toUpperCase();
        String search;
        for (String i : map.keySet()) {
            search = map.get(i).toUpperCase();
            if (search.contains(value)) {
                ans.add(i);
            }
        }
        return ans;
    }
    public List<String> searchDef(HashMap<String,String> map,String find){
        List<String> ans;
        ans = getKey(map,find);
        return ans;
    }
    //
    //Function 3
    public void create(){
        File file;
        boolean isCreat;
        history.clear();
        try{
            
            String filePath = new File("src\\main\\java\\history.txt").getAbsolutePath();
            file = new File(filePath);
            isCreat = file.createNewFile();
            if (isCreat)
                System.out.print("Da tao file thanh cong!");
            else{
                BufferedReader br = new BufferedReader(new FileReader(filePath));       
                String textInALine = br.readLine();
                while ((textInALine) != null) {
                    history.add(textInALine);
                    textInALine = br.readLine();
             }
            }
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
    public void writeFile(){
        try {
            String filePath = new File("src\\main\\java\\history.txt").getAbsolutePath();
            File fw = new File(filePath);
            
            OutputStream outputStream = new FileOutputStream(fw);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            for(int i=0;i<history.size();i++){
                outputStreamWriter.write(history.get(i));
                if(i < history.size()-1) outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //
    //Function4
    public void OverWrite(String newKey,String newValue){
        mapGoc.put(newKey, newValue);
        GUIfunction4();
    }
    public void Duplicated(String newKey, String newValue){
        String text = mapGoc.get(newKey);
        text = text + " | " + newValue;
        mapGoc.put(newKey, text);
        GUIfunction4();
    }
    //
    //Function8 : Random key
    public String RandomKey(){
            Object[] randomArray = mapGoc.keySet().toArray();
            Random generator = new Random();
            int n = generator.nextInt(randomArray.length);
            Object randomObject = randomArray[n];
            return randomObject.toString();
    }
    public String RandomValue(){
            Object[] randomArray = mapGoc.keySet().toArray();
            Random generator = new Random();
            int n = generator.nextInt(randomArray.length);
            Object randomObject = randomArray[n];
            return mapGoc.get(randomObject);
    }
    //
    //Function9 : Random 4 def
    public void Random4Def(String KeyRandom){
        Random generator = new Random();
        int n = generator.nextInt(4) + 1; 
        String textA,textB,textC,textD;
        if ( n==1) textA = mapGoc.get(KeyRandom);
        else textA = RandomValue();
        if ( n==2) textB = mapGoc.get(KeyRandom);
        else textB = RandomValue();
        if ( n==3) textC = mapGoc.get(KeyRandom);
        else textC = RandomValue();
        if ( n==4) textD = mapGoc.get(KeyRandom);
        else textD = RandomValue();
        
        A = new JTextField();
        B = new JTextField();
        C = new JTextField();
        D = new JTextField();
        
        A.setText(textA);
        B.setText(textB);
        C.setText(textC);
        D.setText(textD);
    }
    public void CompareAnsAndQues9(JTextField ans, JTextField ques){
        String question = mapGoc.get(ques.getText());
        String answer = ans.getText();
        if (question.equals(answer)){
                        NewDefReadOnly.setText("Answer: True");
            }
        else NewDefReadOnly.setText("Answer: False");
    }
    //
    //Function 10:
    public String[] RandomValueHaveKey(){
            Object[] randomArray = mapGoc.keySet().toArray();
            Random generator = new Random();
            int n = generator.nextInt(randomArray.length);
            Object randomObject = randomArray[n];
            String[] ans = new String[2];
            ans[0] = randomObject.toString();
            ans[1] = mapGoc.get(randomObject);
            return ans ;
    }
    public void Random4Slang(String Key,String ValueRandom){
        Random generator = new Random();
        int n = generator.nextInt(4) + 1; 
        String textA,textB,textC,textD;
        if ( n==1) textA = Key;
        else textA = RandomKey();
        if ( n==2) textB = Key;
        else textB = RandomKey();
        if ( n==3) textC = Key;
        else textC = RandomKey();
        if ( n==4) textD = Key;
        else textD = RandomKey();
        
        A = new JTextField();
        B = new JTextField();
        C = new JTextField();
        D = new JTextField();
        
        A.setText(textA);
        B.setText(textB);
        C.setText(textC);
        D.setText(textD);
    }
    public void CompareAnsAndQues10(JTextField ans, JTextField ques){
        String question = ques.getText();
        String answer = ans.getText();
        if (question.equals(answer)){
                        NewDefReadOnly.setText("Answer: True");
            }
        else NewDefReadOnly.setText("Answer: False");
    }
    //
}
