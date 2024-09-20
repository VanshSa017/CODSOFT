package guessthenumber;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class congrats extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3;
    JButton again,exit;
    
    public congrats(){
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/frame3.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,500, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        l1= new JLabel(i3);
        l1.setBounds(0,0,800,500);
        
        l2= new JLabel("Congratulations!!");
        l2.setBounds(205, 30, 400,100);
        l2.setFont(new Font("Raleway",Font.BOLD,45));
        l2.setForeground(Color.WHITE);
        
        l3= new JLabel("Your guess was correct");
        l3.setBounds(275,110, 400,100);
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l3.setForeground(Color.WHITE);
        
        again= new JButton("Play Again");
        again.setBounds(270,240,100,30);
        again.setBackground(Color.BLACK);
        again.setForeground(Color.WHITE);
        again.addActionListener(this);
        again.setFocusable(false);
        
        exit= new JButton("EXIT");
        exit.setBounds(420,240,100,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        exit.setFocusable(false);
        
        add(l1);
        l1.add(l2);
        l1.add(l3);
        l1.add(again);
        l1.add(exit);
        
        setUndecorated(true);
        setVisible(true);
        setSize(800, 500);
        setLocation(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String...args){
        congrats c= new congrats();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==exit){
                System.exit(0);
            }
            else if(e.getSource()==again){
                new GuessTheNumber().setVisible(true);
                this.setVisible(false);
            }
        }
}
