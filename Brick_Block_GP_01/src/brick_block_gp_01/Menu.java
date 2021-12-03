/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_block_gp_01;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager;


/**
 *
 * @author davisg0104
 */
//Starter menu method
public abstract class Menu implements ActionListener{  
    public static void MainMenu(){
        JDialog dialog = null;
    JOptionPane optionPane = new JOptionPane();
    optionPane.setMessage("<html><font size=+2><font color=red>Welcome to our</font></html>"
            + "\n" + "<html><font size=+2><font color=red><u>Brick Block Project</u></font></html>");
    optionPane.setMessageType(JOptionPane.DEFAULT_OPTION);
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    String[] buttonTxt = {"Calculate Brick or Blocks needed",
        "Calculate Price of Bricks or Blocks","Exit"};
    JButton[] buttons = new JButton[buttonTxt.length];
    for (int i = 0; i < buttonTxt.length; i++)
    {
        buttons[i] = new JButton(buttonTxt[i]);
        panel.add(buttons[i]);
    }
    buttons[0].addActionListener(new ActionListener()
    {public void actionPerformed(ActionEvent e){
        wallAmountMenu();
    }}
    );
    buttons[1].addActionListener(new ActionListener()
    {public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(buttons[2], Measurements.windowsWallMeasurementsMisc());
    }}
    );
    buttons[2].addActionListener(new ActionListener()
    {public void actionPerformed(ActionEvent e){
        System.exit(0);
    }}
    );
    optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
    optionPane.remove(1);
    optionPane.add(panel);
    dialog = optionPane.createDialog(null, "Welcome!");
    UIManager UI=new UIManager();
    dialog.setVisible(true);
 
    }
    //Menu for getting amount of walls from user
    public static void wallAmountMenu()
    {
        //Sets frame for menu
        JFrame frame = new JFrame();
        Object[] options = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Object selectionObject = JOptionPane.showInputDialog(frame, "How many walls do you have?", 
                "Wall Amount Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionString = selectionObject.toString();
        //return amount of walls
        int selectionInt = Integer.parseInt(selectionString);
        wallSizeMenu(selectionInt);
    }
    //this menu will run the wall measurement window/hole window for as many walls
    //as the user selected and return the total square footage of the wall.
    public static void wallSizeMenu(int count)
    {
        double[] wallSizes = new double[count];
        double totalWallSize = 0;
        for (int i = 0; i < count; i++)
        {
           double wallSize =  wallMeasurementMenu(i);
           totalWallSize += wallSize;
           wallSizes[i] = wallSize;
        }
        JOptionPane.showConfirmDialog(null, String.format("%.2f", totalWallSize));
        
    }
    //Will take the counter for wall number for window name
    //Basically takes foot and inches of wall, converts it to a decimal
    //Then does the same for the amount of holes(walls/windows) the wall has
    //and returns the value into the array of wall sizes
    public static double wallMeasurementMenu(int counter)
    {
        boolean tryAgain;
        double lengthFeet = 0;
        double lengthInch = 0;
        double length;
        double widthFeet = 0;
        double widthInch = 0;
        double width;
        int holeAmount = 0;
        double wallSqFt;
        JTextField lengthFeetField = new JTextField();
        JTextField lengthInchField = new JTextField();
        JTextField widthFeetField = new JTextField();
        JTextField widthInchField = new JTextField();
        JTextField holeField = new JTextField();
        do{
        tryAgain = false;
        Object[] frameObjects = new Object[]{"Length Feet", lengthFeetField, "Length Inches",
            lengthInchField, "Width Feet", widthFeetField, "Width Inches", widthInchField,
            "Number of Holes", holeField
        };
        int option = JOptionPane.showConfirmDialog(null, frameObjects, "Wall " + counter+1 + " inputs",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
            try {
            lengthFeet = Double.parseDouble(lengthFeetField.getText());
            lengthInch = Double.parseDouble(lengthInchField.getText());
            widthFeet = Double.parseDouble(widthFeetField.getText());
            widthInch = Double.parseDouble(widthInchField.getText());
            holeAmount = Integer.parseInt(holeField.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
            JOptionPane.showMessageDialog(null, "Please Make sure to input " 
           + "numbers only. And only whole numbers for the number of holes.");
            tryAgain = true;
        }
            
        }
        //cancel option should return user to wall amount menu
        else if(option ==JOptionPane.CANCEL_OPTION)
        {
            wallAmountMenu();
        }
        
        }while(tryAgain == true);
        
        length = Measurements.convertFeetToDecimal(lengthFeet, lengthInch);
        width = Measurements.convertFeetToDecimal(widthFeet, widthInch);
        wallSqFt = length * width;
        if (holeAmount > 0)
        {
        wallSqFt -= holeMenu(holeAmount);
        }
        return wallSqFt;
    }
    public static double holeMenu(int count)
    {
        boolean tryAgain;
        double lengthFeet = 0;
        double lengthInch = 0;
        double length;
        double widthFeet = 0;
        double widthInch = 0;
        double width;
        double holeSqFt = 0;
        
        JFrame frame = new JFrame();
        JTextField lengthFeetField = new JTextField();
        JTextField lengthInchField = new JTextField();
        JTextField widthFeetField = new JTextField();
        JTextField widthInchField = new JTextField();
        Object[] frameObjects = new Object[]{"Length Feet", lengthFeetField,
        "Length Inches", lengthInchField, "Width Feet", widthFeetField, 
        "Width Inches", widthInchField};
        for (int i = 0; i < count; i++){
        do{
            tryAgain = false;
            int option = JOptionPane.showConfirmDialog(null, frameObjects, "Hole " + i + " inputs",
                JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION)
            {
               try 
            {
             lengthFeet = Double.parseDouble(lengthFeetField.getText());
             lengthInch = Double.parseDouble(lengthInchField.getText());
             widthFeet = Double.parseDouble(widthFeetField.getText());
             widthInch = Double.parseDouble(widthInchField.getText());   
            }
            catch (Exception e)
            {
               JOptionPane.showMessageDialog(null, "Please Make sure to input " 
              + "numbers only."); 
               tryAgain = true;
            } 
            }
            else if(option == JOptionPane.CANCEL_OPTION)
            {
                wallAmountMenu();
            }
            
        }while (tryAgain == true);
           length = Measurements.convertFeetToDecimal(lengthFeet, lengthInch);
           width = Measurements.convertFeetToDecimal(widthFeet, widthInch);
           holeSqFt += length * width;
        }
        return holeSqFt;
        
    }
    public static void BrickMenu()
    {
        
    }
    
}
