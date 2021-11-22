/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_block_gp_01;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


/**
 *
 * @author davisg0104
 */
public abstract class Menu implements ActionListener{  
    public static void MainMenu(){
        JDialog dialog = null;
    JOptionPane optionPane = new JOptionPane();
    optionPane.setMessage("Main Menu");
    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    String[] buttonTxt = {"Normal Wall","Misc Wall","Exit"};
    JButton[] buttons = new JButton[buttonTxt.length];
    for (int i = 0; i < buttonTxt.length; i++)
    {
        buttons[i] = new JButton(buttonTxt[i]);
        panel.add(buttons[i]);
    }
    buttons[0].addActionListener(new ActionListener()
    {public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(buttons[2], "You've chosen Normal Wall");
    }}
    );
    buttons[1].addActionListener(new ActionListener()
    {public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(buttons[2], "You've chosen Misc Wall");
    }}
    );
    buttons[2].addActionListener(new ActionListener()
    {public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(buttons[2], "You've chosen Exit");
    }}
    );
    optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
    optionPane.remove(1);
    optionPane.add(panel);
    dialog = optionPane.createDialog(null, "Icon/Text Button");
    dialog.setVisible(true);
 
    } 
}
