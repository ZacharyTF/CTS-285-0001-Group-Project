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
        
    }
    
    public static void costPerPalletOfBricks()
    {
        
    }
    
}
