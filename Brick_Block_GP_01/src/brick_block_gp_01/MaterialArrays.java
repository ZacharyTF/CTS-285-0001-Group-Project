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
    public static Pallet[] brickPallets = new Pallet[5];
    public static Pallet[] blockPallets = new Pallet[5];
    
    public static void loadBricks()
    {
        bricks[0] = new Brick("OldCastle Red Cored Wire Cut Concrete Brick",
                "A classic styled, wire cut red brick", 
                        "red", 7.62*3.56, .7, 7.62, 3.56);
        bricks[1] = new Brick("OldCastle Red Solid Concrete Brick",
        "A concrete, solid, red brick made for durability",
        "red", 4.0*8.0 , .80, 4.0, 8.0);
        bricks[2] = new Brick("Lee Masonry Gray, Concrete, solid brick",
        "Solid, grey brick, made for durability", "grey", 4.0 * 8.0, .65, 4.0, 8.0);
        bricks[3] = new Brick("General Shale Red, cored, clay brick",
        "Red cored brick with smooth finish", "red", 7.625 * 2.5, .86, 7.625, 2.5);
        bricks[4] = new Brick("Pacific Clay Standard Brick", "Natural clay brick"
                + "free/thaw resistant, 20 year warranty", "red", 8.0 * 3.75,
        .48, 8.0, 3.75);
    }
    public static void loadBlocks()
    {
        blocks[0] = new Block("Standard Cored Concrete Block(8x8x16)", "A standard gray block"
                + " that is fire reesistant", "grey", 8.0 * 16.0, 1.92, 8.0, 16.0);
        blocks[1] = new Block("Standar Cored Concrete Block(6x8x16)", "A standard gray block"
                + " that is fire reesistant", "grey", 8.0 * 16.0, 1.48, 8.0, 16.0);
        blocks[2] = new Block("Midwest Product Group Standard", "Natural Gray (4x8x16) High"
        + " strengh concrete", "brown", 8.0 * 16.0, 1.81, 8.0, 16.0);
        blocks[3] = new Block("Standard Cored Concrete Block(12x8x16)", "A standard gray block"+
                "used for large buildings.", "grey", 12.0 * 16.0, 3.43, 12.0, 16.0);
        blocks[4] = new Block("Half Cored Concred Block(8x8x8)", "Concrete block for single masonry",
        "grey", 8.0 * 8.0, 1.58, 8.0, 8.0);
    }
    public static void loadBrickPallets()
    {
        brickPallets[0] = new Pallet(bricks[0], 0,
                bricks[0].Price * 500);
        brickPallets[1] = new Pallet(bricks[1], 0,
                bricks[1].Price * 500);
        brickPallets[2] = new Pallet(bricks[2], 0,
                bricks[2].Price * 500);
        brickPallets[3] = new Pallet(MaterialArrays.bricks[3], 0,
                bricks[3].Price * 500);
        brickPallets[4] = new Pallet(bricks[4], 0,
                bricks[4].Price * 500);
    }
    public static void loadBlockPallets()
    {
        blockPallets[0] = new Pallet(blocks[0], 0,
                MaterialArrays.blocks[0].Price);
        blockPallets[1] = new Pallet(blocks[1], 0,
                MaterialArrays.blocks[1].Price);
        blockPallets[2] = new Pallet(blocks[2], 0,
                MaterialArrays.blocks[2].Price);
        blockPallets[3] = new Pallet(blocks[3], 0,
                MaterialArrays.blocks[3].Price);
        blockPallets[4] = new Pallet(blocks[4], 0,
                MaterialArrays.blocks[4].Price);
    }
    public static void loadWalls()
    {
        walls = new Wall[10];
    }
    public static void loadMaterials()
    {
        loadBricks();
        loadBlocks();
        loadBrickPallets();
        loadBlockPallets();
        loadWalls();
    }
}
