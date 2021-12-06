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
public class Wall
{
    String Material;
    Double SqFt;
    Brick Brick;
    Block Block;
    
    public Wall(String material, Double sqFt)
    {
        Material = material;
        SqFt = sqFt;
    }
    public Wall(String material, Double sqFt, Brick brick)
    {
        Material = material;
        SqFt = sqFt;
        Brick = brick;
    }
    public Wall(String material, Double sqFt, Block block)
    {
     Material = material;
     SqFt = sqFt;
     Block = block;
    }
    
}
