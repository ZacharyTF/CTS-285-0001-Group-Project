/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_block_gp_01;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


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
        for (int i = 0; i < count; i++)
        {        
           Wall wall =  wallMenu(i + 1);
           MaterialArrays.walls[i] = wall;
           if (MaterialArrays.walls[i].Material.equals("Bricks"))
           {
               BrickMenu(i);
           }
           else
           {
               BlockMenu();
           }
        }

    }
    //Will take the counter for wall number for window name
    //Basically takes foot and inches of wall, converts it to a decimal
    //Then does the same for the amount of holes(walls/windows) the wall has
    //and returns the value into the array of wall sizes
    public static Wall wallMenu(int counter)
    {
        boolean tryAgain;
        String material = "";
        double lengthFeet = 0;
        double lengthInch = 0;
        double length;
        double widthFeet = 0;
        double widthInch = 0;
        double width;
        int holeAmount = 0;
        double wallSqFt;
        //setup Text Fields
        JTextField lengthFeetField = new JTextField();
        JTextField lengthInchField = new JTextField();
        JTextField widthFeetField = new JTextField();
        JTextField widthInchField = new JTextField();
        JTextField holeField = new JTextField();
        //ComboBox
        Object [] materials = {"Bricks", "Blocks"};
        JComboBox materialBox = new JComboBox(materials);
        materialBox.setSelectedIndex(0);
        do{
        tryAgain = false;
        Object[] frameObjects = new Object[]{"Length Feet", lengthFeetField, "Length Inches",
            lengthInchField, "Width Feet", widthFeetField, "Width Inches", widthInchField,
            "Number of Holes", holeField, "Building Material", materialBox
        };
        int option = JOptionPane.showConfirmDialog(null, frameObjects, "Wall " + counter+1 + " inputs",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
            try 
            {
            lengthFeet = Double.parseDouble(lengthFeetField.getText());
            lengthInch = Double.parseDouble(lengthInchField.getText());
            widthFeet = Double.parseDouble(widthFeetField.getText());
            widthInch = Double.parseDouble(widthInchField.getText());
            holeAmount = Integer.parseInt(holeField.getText());
            material = materialBox.getSelectedItem().toString();
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
        Wall output = new Wall(material , wallSqFt);
        return output;
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
    public static void BrickMenu(int count)
    {
        JDialog dialog = null;
        Brick brickChoice = new Brick();
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage("<html><font size=+2><font color=red>Brick"
                + " Menu</font></html>");
        optionPane.setMessageType(JOptionPane.DEFAULT_OPTION);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1));
        //Setup Brick Choice Labels
        JLabel brickLbl = new JLabel("----Brick Choice----");
        JLabel brickName = new JLabel("Brick Name");
        JLabel brickDesc = new JLabel("Brick Description");
        JLabel brickColor = new JLabel("Brick Color");
        JLabel brickSqInch = new JLabel("Brick Square Inches");
        JLabel brickPrice = new JLabel("Price per brick");
        //buttons
        JRadioButton brick1Btn = new JRadioButton("Brick1");
        JRadioButton brick2Btn = new JRadioButton("Brick2");
        JRadioButton brick3Btn = new JRadioButton("Brick3");
        JRadioButton brick4Btn = new JRadioButton("Brick4");
        JRadioButton brick5Btn = new JRadioButton("Brick5");
        //ButtonGroup to make sure only one button is selected at a time
        ButtonGroup brickBtns = new ButtonGroup();
        brickBtns.add(brick1Btn);
        brickBtns.add(brick2Btn);
        brickBtns.add(brick3Btn);
        brickBtns.add(brick4Btn);
        brickBtns.add(brick5Btn);
        //Add panel buttons
        panel.add(brick1Btn);
        panel.add(brick2Btn);
        panel.add(brick3Btn);
        panel.add(brick4Btn);
        panel.add(brick5Btn);
        //add panel labels
        panel.add(brickLbl);
        panel.add(brickName);
        panel.add(brickDesc);
        panel.add(brickColor);
        panel.add(brickSqInch);
        panel.add(brickPrice);
        //click event for buttons
        brick1Btn.addActionListener(new ActionListener()
        {
         public void actionPerformed(ActionEvent a)
         {   
             brickName.setText(MaterialArrays.bricks[0].Name);
             brickDesc.setText(MaterialArrays.bricks[0].Description);
             brickColor.setText(MaterialArrays.bricks[0].Color);
             brickSqInch.setText(String.format("%.2f", MaterialArrays.bricks[0].SqInches));
             brickPrice.setText(MaterialArrays.bricks[0].Price.toString());
             MaterialArrays.walls[count].Brick = MaterialArrays.bricks[0];
         }   
        });
        brick2Btn.addActionListener(new ActionListener()
        {
         public void actionPerformed(ActionEvent a)
         {   
             brickName.setText(MaterialArrays.bricks[1].Name);
             brickDesc.setText(MaterialArrays.bricks[1].Description);
             brickColor.setText(MaterialArrays.bricks[1].Color);
             brickSqInch.setText(String.format("%.2f", MaterialArrays.bricks[1].SqInches) + " square inches");
             brickPrice.setText(MaterialArrays.bricks[1].Price.toString() + "$");
             MaterialArrays.walls[count].Brick = MaterialArrays.bricks[1];
         }   
        });
        brick3Btn.addActionListener(new ActionListener()
        {
         public void actionPerformed(ActionEvent a)
         {   
             brickName.setText(MaterialArrays.bricks[2].Name);
             brickDesc.setText(MaterialArrays.bricks[2].Description);
             brickColor.setText(MaterialArrays.bricks[2].Color);
             brickSqInch.setText(String.format("%.2f", MaterialArrays.bricks[2].SqInches) + " square inches");
             brickPrice.setText(MaterialArrays.bricks[2].Price.toString() + "$");
             MaterialArrays.walls[count].Brick = MaterialArrays.bricks[2];
         }   
        });
        brick4Btn.addActionListener(new ActionListener()
        {
         public void actionPerformed(ActionEvent a)
         {   
             brickName.setText(MaterialArrays.bricks[3].Name);
             brickDesc.setText(MaterialArrays.bricks[3].Description);
             brickColor.setText(MaterialArrays.bricks[3].Color);
             brickSqInch.setText(String.format("%.2f", MaterialArrays.bricks[3].SqInches) + " square inches");
             brickPrice.setText(MaterialArrays.bricks[3].Price.toString());
             MaterialArrays.walls[count].Brick = MaterialArrays.bricks[3];
         }   
        });
        brick5Btn.addActionListener(new ActionListener()
        {
         public void actionPerformed(ActionEvent a)
         {   
             brickName.setText(MaterialArrays.bricks[4].Name);
             brickDesc.setText(MaterialArrays.bricks[4].Description);
             brickColor.setText(MaterialArrays.bricks[4].Color);
             brickSqInch.setText(String.format("%.2f", MaterialArrays.bricks[4].SqInches) + " square inches");
             brickPrice.setText(MaterialArrays.bricks[4].Price.toString() + "$");
             MaterialArrays.walls[count].Brick = MaterialArrays.bricks[4];
         }   
        });
        
        optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
        optionPane.add(panel);
        Dimension dimension = new Dimension(325, 400);
        dialog = optionPane.createDialog(null, "Brick Menu");
        dialog.setSize(dimension);
        dialog.setVisible(true);
    }
    public static void BlockMenu()
    {
        
    }
    
}
