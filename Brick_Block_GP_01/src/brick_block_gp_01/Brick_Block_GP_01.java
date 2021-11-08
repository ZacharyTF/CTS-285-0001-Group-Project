/*
 * Group Project for Brick Block
 * Group members: Zachary Fegan, Garrett Davis, Travis Bivins
 * Created: 10-25-2021
 * Updated: 11-8-2021
 */
package brick_block_gp_01;
//import javax.swing.*;
//import java.io.*;
import java.util.Scanner;
public class Brick_Block_GP_01 {
 
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        
        costOfMaterials();
        brickMeasurements();
        blockMeasurments();
        wallMeasurements();
    }
    
    public static void costPerBrick()
    {
        Scanner key = new Scanner(System.in); 
        double perBrick1 = 0.35;
        double perBrick2 = 0.90;
        double userBrick;
        
        System.out.println("Enter the price of one of your bricks: ");
        userBrick = key.nextDouble();
        
        if((userBrick >= perBrick1) && (userBrick <= perBrick2))
        {
            brickMeasurements();
        }
        else
        {
            System.out.println("Enter a valid price per brick ($0.35 to $0.90)");
            costPerBrick();
        }
    }
    
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
            blockMeasurments();
        } else if ("n".equals(userInput)){
            brickMeasurements();
        }
    }
    private static void blockMeasurments() {
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
            wallMeasurements();
        } else if ("n".equals(userInput)){
            blockMeasurments();
        } 
    }
    public static void wallMeasurements(){
         
    }
     
    public void materialsMenu()
    {
        Scanner key = new Scanner(System.in);
        double perBrick1 = 0.35;
        double perBrick2 = 0.90;
        double userBrick;
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
                costPerBrick();
                break;
            case 2:
                costPerBricks();
                break;
            case 3:
                costPerPalletOfBricks();
                break;
            default:
                System.out.println("Enter a valid number choice 1 - 4!");
                materialsMenu();
                break;
        }
    }
}
