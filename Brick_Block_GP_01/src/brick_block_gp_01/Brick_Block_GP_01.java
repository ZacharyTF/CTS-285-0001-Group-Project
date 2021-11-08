/*
 * Group Project for Brick Block
 * Group members: Zachary Fegan, Garrett Davis, Travis Bivins
 * Created: 10-25-2021
 * Updated: 10-25-2021
 * Travis
 */
package brick_block_gp_01;
//import javax.swing.*;
//import java.io.*;
import java.util.Scanner;
public class Brick_Block_GP_01 {
 
    public static void main(String[] args) {
        costOfMaterials();
        wallMeasurements();
    }
    
    public static void costOfMaterials()
    {
        Scanner key = new Scanner(System.in); 
        double perBrick1 = 0.35;
        double perBrick2 = 0.90;
        double userBrick;
        
        System.out.println("Enter the price of one of your bricks: ");
        userBrick = key.nextDouble();
        
        if((userBrick >= perBrick1) && (userBrick <= perBrick2))
        {
            wallMeasurements();
        }
        else
        {
            System.out.println("Enter a valid price per brick ($0.35 to $0.90)");
            costOfMaterials();
        }
    }
    
    public static void wallMeasurements()
    {
        double brickWidth;
        double brickLength;
        Scanner key = new Scanner(System.in); 
        String userInput;
        System.out.println("Enter the Length of the brick being used");
        brickWidth = key.nextDouble();
        System.out.println("Enter the Width of the brick being used");
        brickLength = key.nextDouble();
        double brick_sqFt = brickLength * brickWidth;
        System.out.println("Just to make sure we have the Length of the brick at " + brickLength + " and the width at " + brickWidth + " is that correct? y/n");
        userInput = key.next();
        if("y".equals(userInput)){
            System.out.println("The Square Foot of those bricks is " + brick_sqFt);
        } else if ("n".equals(userInput)){
            wallMeasurements();
        }
    }
}
