/*
 * Group Project for Brick Block
 * Group members: Zachary Fegan, Garrett Davis, Travis Bivins
 * Created: 10-25-2021
 * Updated: 10-25-2021
 * Travis
 */
package brick_block_gp_01;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
public class Brick_Block_GP_01 {

    public static void main(String[] args) {
        
    }
    
    public void costOfMaterials()
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
    
    public void wallMeasurements()
    {
        
    }
}
