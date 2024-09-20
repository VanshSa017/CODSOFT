/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guessthenumber;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuessTheNumber extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3;
    JButton info,start,exit;
    
    public GuessTheNumber(){
        
        super("Guess The Number");
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/frame3.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,500, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        l1= new JLabel(i3);
        l1.setBounds(0,0,800,500);
        
        //Making Main Heading
        l2= new JLabel("Mystery Number Quest");
        l2.setBounds(220, 30, 400,100);
        l2.setFont(new Font("Times New Roman",Font.BOLD,35));
        l2.setForeground(Color.WHITE);
        
        l3= new JLabel("Guess the Number");
        l3.setBounds(310,85,200,100);
        l3.setFont(new Font("Times New Roman",Font.BOLD,18));
        l3.setForeground(Color.RED);

        start= new JButton("START");
        start.setBounds(275,210,100,30);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        start.setFocusable(false);      //removes inside border appearance
        
        info= new JButton("INFO");
        info.setBounds(405,210,100,30);
        info.setBackground(Color.BLACK);
        info.setForeground(Color.WHITE);
        info.addActionListener(this);
        info.setFocusable(false);
        
        exit= new JButton("EXIT");
        exit.setBounds(340,270,100,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        exit.setFocusable(false);
        
        setLayout(null);
        add(l1);
        l1.add(l2);
        l1.add(l3);
        l1.add(start);
        l1.add(info);
        l1.add(exit);
        
        
        setUndecorated(true);
        setVisible(true);
        setSize(800, 500);
        setLocation(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {        
        GuessTheNumber gn = new GuessTheNumber();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==start){
            System.out.println("Game started");
            this.setVisible(false);
            new play().setVisible(true);
        }else if(e.getSource()==info){
            System.out.println("Info pannel opening");
            new info().setVisible(true);
        }
    }
}
