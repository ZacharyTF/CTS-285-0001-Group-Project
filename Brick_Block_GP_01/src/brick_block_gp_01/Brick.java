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
public class Brick {
    public Brick[] bricks = new Brick[5];
    String Name;
    String Description;
    String Color;
    Double SqInches;
    Double Price;
    Double Length;
    Double Width;
    public Brick()
    {
        
    }
    public Brick(String name, String description, String color, Double sqInches,
            double price, double length, double width)
    {
        Name = name;
        Description = description;
        Color = color;
        SqInches = sqInches;
        Price = price;
        Length = length;
        Width = width;
    }
    
}
