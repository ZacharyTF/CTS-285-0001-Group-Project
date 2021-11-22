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
public class Pricing {
    double perBrick1;
    double perBrick2;
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
            Measurements.brickMeasurements();
        }
        else
        {
            System.out.println("Enter a valid price per brick ($0.35 to $0.90)");
            costPerBrick();
        }
    }
    public static void costPerBricks()
    {
        Scanner key = new Scanner(System.in);
        double perBrick1 = 0.35;
        double perBrick2 = 0.90;
        double amountOfBricks;
        double cost;
        double userBrick;
        System.out.println("Enter the price of the brick: ");
        userBrick = key.nextDouble();
        if((userBrick >= perBrick1) && (userBrick <= perBrick2))
        {
            System.out.print("Enter the amount of bricks you getting: ");
            amountOfBricks = key.nextDouble();
            cost = amountOfBricks * userBrick;
            System.out.println("We have you using " + amountOfBricks + " for a total of $" + cost);
        }
        else
        {
            System.out.println("Enter a valid price per brick ($0.35 to $0.90)");
            costPerBricks();
        }
    }
    
    public static void costPerPalletOfBricks()
    {
        Scanner key = new Scanner(System.in);
        double amountOfBricks;
        double pallet;
        double cost;
        double userCost, userBrick, userPallet;
        System.out.println("How many pallets are you purchasing? ");
        userPallet = key.nextDouble();
        System.out.println("What is the cost per pallet? ");
        userCost = key.nextDouble();
        System.out.println("and how many bricks are there per pallet? ");
        userBrick = key.nextDouble();
        amountOfBricks = userPallet * userBrick;
        cost = userPallet * userCost;
        System.out.println("Right now we have you marked down for " + userPallet + " pallets for a total of " + amountOfBricks + " bricks for $" + cost);
    }
    
}
