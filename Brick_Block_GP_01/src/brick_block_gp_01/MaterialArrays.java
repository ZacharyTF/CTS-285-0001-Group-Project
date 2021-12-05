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
public class MaterialArrays {
    public static Brick[] bricks = new Brick[5];
    public static Block[] blocks = new Block[5];
    public static Wall[] walls = new Wall[10];
    public static void loadBricks()
    {
        bricks[0] = new Brick("OldCastle Red Cored Wire Cut Concrete Brick",
                "A classic styled, wire cut red brick", 
                        "red", 7.62*3.56, .7);
        bricks[1] = new Brick("OldCastle Red Solid Concrete Brick",
        "A concrete, solid, red brick made for durability",
        "red", 4.0*8.0 , .80);
        bricks[2] = new Brick("Lee Masonry Gray, Concrete, solid brick",
        "Solid, grey brick, made for durability", "grey", 4.0 * 8.0, .65);
        bricks[3] = new Brick("General Shale Red, cored, clay brick",
        "Red cored brick with smooth finish", "red", 7.625 * 2.5, .86);
        bricks[4] = new Brick("Pacific Clay Standard Brick", "Natural clay brick"
                + "free/thaw resistant, 20 year warranty", "red", 8.0 * 3.75,
        .48);
    }
}
