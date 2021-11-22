/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_block_gp_01;

import java.io.*;
import java.awt.Desktop;

/**
 *
 * @author feganz5140
 */

public class Receipt {
    public static void writeToReceipt() throws IOException
    {
        FileOutputStream fileStream = null;
        PrintWriter outFS = null;
        
        fileStream = new FileOutputStream(name + ".txt"); //later add the date made of the receipt
        outFS = new PrintWriter(fileStream);
        
        outFS.println(name + "'s Receipt"); //later add the date that is was made
        outFS.println("======================================================");
        outFS.println(brickType + "      " + pricePerBrick);
        outFS.println(totalBricks + "       " + totalPriceOfBricks);
        outFS.println(BusinessName + "        " + totalCostOfServices);
        outFS.println("======================================================");
        outFS.println("                             " + subTotal);
        outFS.println("                             " + addedTaxes);
        outFS.println("                             " + total);
        
        outFS.close();
        //outFS.println(name);
        displayReceipt(name);
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
