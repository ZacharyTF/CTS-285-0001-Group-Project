/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_block_gp_01;


import static brick_block_gp_01.Brick_Block_GP_01.consoleMainMenu;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author davisg0104
 */
public class Measurements {

    public static void brickMeasurements()
    {
        double brickWidth;
        double brickLength;
        Scanner key = new Scanner(System.in); 
        String userInput;
        System.out.println("Enter the Length of the brick being used");
        brickLength = key.nextDouble();
        System.out.println("Enter the Width of the brick being used");
        brickWidth = key.nextDouble();
        double brick_sqFt = brickLength * brickWidth;
        System.out.println("Just to make sure we have the Length of the brick at " + brickLength + " and the width at " + brickWidth + " is that correct? y/n");
        userInput = key.next();
        if("y".equals(userInput)){
            System.out.println("The Square Foot of those bricks is " + brick_sqFt);
            consoleMainMenu();
        } else if ("n".equals(userInput)){
            brickMeasurements();
        }
        
    }
    public static void blockMeasurements() {
        double blockWidth;
        double blockLength;
        Scanner key = new Scanner(System.in); 
        String userInput;
        System.out.println("Enter the Length of the block being used");
        blockLength = key.nextDouble();
        System.out.println("Enter the Width of the block being used");
        blockWidth = key.nextDouble();
        double brick_sqFt = blockLength * blockWidth;
        System.out.println("Just to make sure we have the Length of the block at " + blockLength + " and the width at " + blockWidth + " is that correct? y/n");
        userInput = key.next();
        if("y".equals(userInput)){
            System.out.println("The Square Foot of those block is " + brick_sqFt);
            consoleMainMenu();
        } else if ("n".equals(userInput)){
            blockMeasurements();
        } 
    }
    public static void wallMeasurements(){
        double wallWidth;
        double wallLength;
        Scanner key = new Scanner(System.in); 
        String userInput;
        System.out.println("Enter the Length of the wall being used");
        wallLength = key.nextDouble();
        System.out.println("Enter the Width of the wall being used");
        wallWidth = key.nextDouble();
         double wall_sqFt = wallLength * wallWidth;
        System.out.println("Just to make sure we have the Length of the wall at " + wallLength + " and the width at " + wallWidth + " is that correct? y/n");
        userInput = key.next();
        if("y".equals(userInput)){
            System.out.println("The Square Foot of the wall is " + wall_sqFt);
            wallMeasurementsMisc();
        }else if ("n".equals(userInput)){
            wallMeasurements();
    }
    }
    public  static void wallMeasurementsMisc()
    {
        double holeLength;
        double holeWidth;
        Scanner key = new Scanner(System.in); 
        String userInput;
        System.out.println("Enter the Length of the hole from the wall that is being used");
        holeLength = key.nextDouble();
        System.out.println("Enter the Width of the hole from the wall that is  being used");
        holeWidth = key.nextDouble();
        double hole_sqFt = holeLength * holeWidth;
        System.out.println("Just to make sure we have the Length of the wall at " + holeLength + " and the width at " + holeWidth + " is that correct? y/n");
        userInput = key.next();
        if("y".equals(userInput)){
            System.out.println("The Square Foot of the wall is " + hole_sqFt);
            consoleMainMenu();
        }else if ("n".equals(userInput)){
            wallMeasurementsMisc();
        }
    }

    public static double windowsWallMeasurementsMisc()
    {
        double holeLength;
        double holeWidth; 
        double hole_sqFt;
        JFrame f;
        f = new JFrame();
        String wallLength = JOptionPane.showInputDialog(f, "Please enter the length of the hole from the wall being used.");
        holeLength = Double.parseDouble(wallLength);
        String wallWidth = JOptionPane.showInputDialog(f, "Please enter the Width of the hole from the wall being used.");
        holeWidth = Double.parseDouble(wallWidth);
        String userInput = JOptionPane.showInputDialog(f, "Just to make sure we "
                + "have the Length of the wall at " + holeLength + 
                " and the width at " + holeWidth + " is that correct? y/n");
        hole_sqFt = holeLength * holeWidth;
        if(userInput.equalsIgnoreCase("y"))
        {
            
        }
        if(userInput.equalsIgnoreCase("n"))
        {
            
        }
        
        
        
        return hole_sqFt;
    }
}
