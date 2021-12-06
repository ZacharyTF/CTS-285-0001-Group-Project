/*
 * Group Project for Brick Block
 * Group members: Zachary Fegan, Garrett Davis, Travis Bivins
 * Created: 10-25-2021
 * Updated: 12-6-2021
 */
package brick_block_gp_01;
import java.io.IOException;
import javax.swing.*;
//import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Brick_Block_GP_01 {

    public static String name;
 
    public static void main(String[] args) {
        
        MaterialArrays.loadMaterials();
        getUserName();
    }
    
    public static String getUserName()
    {
       JFrame f; 
       f = new JFrame();
       name = JOptionPane.showInputDialog(f,"Please Enter your name:");
       userMainMenu();
       return name;
    }
    
    public static void userMainMenu()
    {
        JFrame f;
        f = new JFrame();
        String userChoice = JOptionPane.showInputDialog(f,"Choose if you want to see the application in console or in windows");
        
        if (userChoice.equalsIgnoreCase("console"))
        {
            consoleMainMenu();
        }
        if (userChoice.equalsIgnoreCase("windows"))
        {
            Menu.MainMenu();
        }
        else
        {
            ShowErrorMessage();
        }
        
//        switch(userChoice)
//        {
//            case "console":
//                consoleMainMenu();
//                break;
//            case "windows":
//                WindowsMainMenu();
//                break;
//            default:
//                ShowErrorMessage();
//                break;
//        }
    }
    
    public static void ShowErrorMessage()
    {
        
        JFrame f;
        f = new JFrame();
        JOptionPane.showMessageDialog(f,"Please type Console, for console comand window, and Windows for a more user friendly box.");
        userMainMenu();
    }
    
    public static void consoleMainMenu()
    {
        Scanner key = new Scanner(System.in);
        int userChoice;
        
        System.out.println("        Console Main Menu         ");
        System.out.println("===============================");
        System.out.println("1.  Measure wall");
        System.out.println("2.  Measure wall with Misc.");
        System.out.println("3.  Cost of materials");
        System.out.println("4.  Brick Measurements");
        System.out.println("5.  Block Measurements");
        System.out.println("6.  Exit");
        System.out.println();
        System.out.print("Enter a choice number: ");
        userChoice = key.nextInt();
        
        switch(userChoice)
        {
            case 1:
                Measurements.wallMeasurements();
                break;
            case 2:
                Measurements.wallMeasurementsMisc();
                break;
            case 3:
                materialsMenu();
                break;
            case 4:
                Measurements.brickMeasurements();
                break;
            case 5:
                Measurements.blockMeasurements();
                break;
            case 6:
                if(userChoice == 6)
                {
                    System.exit(6);
                }
                break;
            default:
                System.out.println("Enter a valid number choice 1 - 6!");
                consoleMainMenu();
                break;
        }
    }
    public static void materialsMenu()
    {
        Scanner key = new Scanner(System.in);
        int userChoice;
        
        System.out.println("        Materials Menu         ");
        System.out.println("===============================");
        System.out.println("1.  Cost per brick");
        System.out.println("2.  Cost per bricks");
        System.out.println("3.  Cost per pallet of bricks");
        System.out.println("4.  Main Menu");
        System.out.println();
        System.out.print("Enter a choice number: ");
        userChoice = key.nextInt();
        
        switch(userChoice)
        {
            case 1:
                Pricing.costPerBrick();
                break;
            case 2:
                Pricing.costPerBricks();
                break;
            case 3:
                Pricing.costPerPalletOfBricks();
                break;
            case 4:
                consoleMainMenu();
                break;
            default:
                System.out.println("Enter a valid number choice 1 - 4!");
                materialsMenu();
                break;
        }
    }
    
    
}
