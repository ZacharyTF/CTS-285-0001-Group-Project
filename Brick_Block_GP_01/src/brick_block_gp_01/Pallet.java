/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_block_gp_01;

/**
 *
 * @author garre
 */
public class Pallet {
    Brick Brick;
    int Amount;
    Double Price;
    Block Block;
    public Pallet()
    {}
    public Pallet(Brick brick, int amount, double price)
    {
        Brick = brick;
        Amount = amount;
        Price = price;
    }
    public Pallet(Block block ,int amount, double price)
    {
        Block = block;
        Amount = amount;
        Price = price;
    }
    //Gets pallets from wall and brick choice and puts them into the brickpallets array
    public static void GetPallets(Brick brick, Double wallSqFt)
    {
       //set mortar size(3/8)" standard
       Double length = brick.Length + .375;
       Double width = brick.Width + .375;
       Double brickSqIn = length * width;
       Double wallSqIn = wallSqFt * 12;
       Double tempBrickTotal = wallSqIn / brickSqIn;
       //Rounds to an int and return an int
       int pallets = (int) Math.rint(tempBrickTotal / 500.0);
       Double palletPrice =  500 * brick.Price;
       Double wallPrice = palletPrice * pallets;
        for (int i = 0; i < MaterialArrays.brickPallets.length; i++)
        {  
            if (MaterialArrays.brickPallets[i].Brick.Name.equals(brick.Name)){
                System.out.println(MaterialArrays.brickPallets[i].Amount);
                //adds the pallet amount to the brickpallet specifically for later use
                MaterialArrays.brickPallets[i].Amount += pallets;
            }
        }
    }
    public static void GetPallets(Block block, Double wallSqFt)
    {
       //set mortar size(3/8)" standard
       Double length = block.Length + .375;
       Double width = block.Width + .375;
       Double blockSqIn = length * width;
       Double wallSqIn = wallSqFt * 12;
       Double tempBlockTotal = wallSqIn / blockSqIn;
       //Rounds to an int and return an int
       int blockAmount = (int) Math.rint(block.Price * tempBlockTotal);
        for (int i = 0; i < MaterialArrays.blockPallets.length; i++)
        {  
            if (MaterialArrays.blockPallets[i].Block.Name.equals(block.Name)){
                System.out.println(MaterialArrays.blockPallets[i].Amount);
                //adds the pallet amount to the brickpallet specifically for later use
                MaterialArrays.blockPallets[i].Amount += blockAmount;
            }
        }
    }
    
}
