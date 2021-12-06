/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_block_gp_01;

import java.time.LocalDate;
import java.io.*;
import java.awt.Desktop;

/**
 *
 * @author feganz5140
 */

public class Receipt {
    public static void writeToReceipt(String name, Double price)throws IOException
    {
        LocalDate myDate = LocalDate.now();
        
        FileOutputStream fileStream = null;
        PrintWriter outFS = null;
        
        fileStream = new FileOutputStream(name + ".txt"); //later add the date made of the receipt
        outFS = new PrintWriter(fileStream);
        
        outFS.println(name + "'s Receipt         Made on: " + myDate); //later add the date that is was made
        outFS.println("======================================================");
        outFS.println("                Brick Pallets(500 Bricks)             ");
        outFS.println("======================================================");
        for (Pallet brickPallet : MaterialArrays.brickPallets)
        {
            outFS.println(brickPallet.Brick.Name + " pallet: " + brickPallet.Amount);
            outFS.println(" at " + brickPallet.Brick.Price + "$ per brick.");
        }
        outFS.println("                        Blocks                        ");
        outFS.println("======================================================");
        for (Pallet blockPallet : MaterialArrays.blockPallets)
        {
            outFS.println(blockPallet.Block.Name + " pallet: " + blockPallet.Amount);
            outFS.println(" at " + blockPallet.Block.Price + "$ per block.");
        }
        outFS.println("Subtotal Price : " + String.format("%.2f", price) + "$");
        outFS.println("Taxes: " + String.format("%.2f",price * .0475));
        outFS.println("Total(10% overage included): " + String.format("%.2f", price + (price * .0475)));
        
        outFS.close();
        //outFS.println(name);
        displayReceipt(name);
    }
    public static void CalculateTotalAmount()
    {
        double totalPrice = 0;
        double totalBrickPrice = 0;
        double totalBlockPrice = 0;
        for (Pallet brickPallet : MaterialArrays.brickPallets)
        {
            if (brickPallet.Amount > 0)
            {
            totalBrickPrice += brickPallet.Amount * brickPallet.Price;
            }
        }
        for (Pallet blockPallet : MaterialArrays.blockPallets)
        {
            if (blockPallet.Amount > 0)
            {totalBlockPrice += blockPallet.Amount * blockPallet.Price;}
            
        }
        totalPrice = totalBrickPrice + totalBlockPrice;
        try{      
        writeToReceipt(Brick_Block_GP_01.name, totalPrice);
        }
        catch(Exception ex)
        {System.out.println(ex.toString());}
        
    }
    
    public static void displayReceipt(String name)
    {
        try{
            File file = new File(name + ".txt");
            if(!Desktop.isDesktopSupported())
            {
                System.out.println("not supported");
            }
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists()) 
            {
                desktop.open(file);
            }
        }
        catch(IOException e)
        {
        }
    }
}

//public class Receipt {
//    public static void writeToReceipt() throws IOException
//    {
//        FileOutputStream fileStream = null;
//        PrintWriter outFS = null;
//        
//        fileStream = new FileOutputStream(name + ".txt"); //later add the date made of the receipt
//        outFS = new PrintWriter(fileStream);
//        
//        outFS.println(name + "'s Receipt"); //later add the date that is was made
//        outFS.println("======================================================");
//        outFS.println(brickType + "      " + pricePerBrick);
//        outFS.println(totalBricks + "       " + totalPriceOfBricks);
//        outFS.println(BusinessName + "        " + totalCostOfServices);
//        
//        
//        
//        //outFS.println(name);
//        
//        outFS.close();
//        
//        displayReceipt(name);
//    }
//    
//    public static void displayReceipt(String name)
//    {
//        try{
//            File file = new File(name + ".txt");
//            if(!Desktop.isDesktopSupported())
//            {
//                System.out.println("not supported");
//            }
//            Desktop desktop = Desktop.getDesktop();  
//            if(file.exists()) 
//            {
//                desktop.open(file);
//            }
//        }
//        catch(IOException e)
//        {
//        }
//    }
//}
