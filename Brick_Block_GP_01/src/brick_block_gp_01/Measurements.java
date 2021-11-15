/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_block_gp_01;


import java.util.Scanner;

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
            blockMeasurements();
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
            wallMeasurements();
        } else if ("n".equals(userInput)){
            blockMeasurements();
        } 
    }
    public static void wallMeasurements(){
         System.out.println("This is a test");
    }
    public static void wallMeasurementsMisc()
    {
        
    }
}
