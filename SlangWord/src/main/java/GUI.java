
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public  JTextField newWord;
    public  JTextField NewWordReadOnly;
    public  JTextField NewDef;
    public  JTextField NewDefReadOnly;
    public JTextField notification;
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
        button = new JButton("    Random slang word    ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 7;  
        c.weighty = 0.1;
        pane.add(button, c);
        button = new JButton("   Game find definition    ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 8;  
        c.weighty = 0.1;
        pane.add(button, c);
        button = new JButton("  Game find slang word   ");
        c.ipady = 20;
        c.ipadx = 80;
        c.insets = new Insets(5,200,5,200);  
        c.gridx = 1;
        c.gridy = 9;  
        c.weighty = 0.1;
        pane.add(button, c);
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
        button = new JButton("Add Slang Word");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("Add Slang Word");    
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
        c.gridy = 4;
        c.insets = new Insets(5,200,5,200); 
        c.ipady = 20;  
        c.ipadx = 50;  
        c.weighty = 0.1;
        pane.add(button,c);
        button.setActionCommand("OverWrite");    
        button.addActionListener(this);
        button = new JButton("Duplicated");
        c.gridx = 1;
        c.gridy = 5;
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
    }
    public void GUIfunction5(){
        
        frame1.getContentPane().removeAll();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(15, 15, 15, 5));
        CreateText();
        addComponentsToPaneFunction5(frame1.getContentPane());
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
        c.gridy = 6;
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
                            for(int i=0;i<ans.size();i++)
                            {
                                if (text == null) text = ans.get(i);
                                else text = text + "\n" + ans.get(i);
                            }
                            fieldReadOnly.setText(text);      
                }
                else if (strActionCommand.equals("    History of search     ") ){
                        GUIfunction3(); //function 3: Giao dien
                        String text = null;
                        fieldReadOnly.setText(""); 
                        for(int i=0;i<history.size();i++)
                            {
                                if (text == null) text = history.get(i);
                                else text = text + "\n" + history.get(i);
                            }
                        fieldReadOnly.setText(text); 
                }
                else if (strActionCommand.equals("      Add slang word      ") ){
                        GUIfunction4(); //function 4: Giao dien
                }
                else if (strActionCommand.equals("Add Slang Word") ){
                         //function 4: Add new slang word
                         String add = newWord.getText();
                         String def = NewDef.getText();
                         if(mapGoc.containsKey(add)){
                             GUIfunctionwWhenAddError();
                         }
                         else{
                             mapGoc.put(add, def);
                         }
                }
                else if (strActionCommand.equals("OverWrite") ){
                         //function 4: Add new slang word
                         String add = newWord.getText();
                         String def = NewDef.getText();
                         OverWrite(add, def);
                }
                else if (strActionCommand.equals("Duplicated") ){
                         //function 4: Add new slang word
                         String add = newWord.getText();
                         String def = NewDef.getText();
                         Duplicated(add, def);
                }
                else if (strActionCommand.equals("      Edit slang word      ") ){
                         //function 5: Edit slang word
                         GUIfunction5();
                }
                else if (strActionCommand.equals("Edit Slang Word") ){
                         //function 5: Edit slang word
                         String oldkey = newWord.getText();
                         String newkey = NewDef.getText();
                         if(mapGoc.containsKey(oldkey)){
                             mapGoc.put(newkey,mapGoc.get(oldkey));
                             mapGoc.remove(oldkey);
                             
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
                         String key = newWord.getText();
                         if(mapGoc.containsKey(key)){
                             mapGoc.remove(key);
                             
                            notification.setText("Remove success ");
                            
                            

                        
                        }
                         else{
                             notification.setText("Not Found Slang Word");
                         }
                         
                }
        }
    //Function 1
    public String searchWord(HashMap<String,String> map,String find){
        String ans ="";
        if (map.containsKey(find)){
            ans = map.get(find);
        }
        else ans ="Not found!!!";
        return ans;
        }
    //
    //Function 2
    public static List<String> getKey(HashMap<String, String> map, String value) {
        List<String> ans = new ArrayList<String>();
        for (String i : map.keySet()) {
            if (map.get(i).contains(value)) {
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
}