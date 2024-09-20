package guessthenumber;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class play extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3;
    JTextField tf;
    JButton submit,exit;
    int attempt;
    int random_number;
    
    public play(){ 
        super("Play Zone");
        
        this.attempt=1;
        this.random_number=generateRandom();
        System.out.println(this.random_number);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/frame3.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,500, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        l1= new JLabel(i3);
        l1.setBounds(0,0,800,500);
        
        l2= new JLabel("Enter a Number");
        l2.setBounds(270,18, 300,100);
        l2.setFont(new Font("Times New Roman",Font.BOLD,35));
        l2.setForeground(Color.WHITE);
        
        tf= new JTextField();
        tf.setBounds(290, 110, 200, 50);
        tf.setFont(new Font("Raleway", Font.BOLD,25));
        tf.setHorizontalAlignment(JTextField.CENTER);
        
        l3= new JLabel("Attempt "+this.attempt+" /3");
        l3.setBounds(320,155,250,100);
        l3.setFont(new Font("Times New Roman",Font.BOLD,25));
        l3.setForeground(Color.WHITE);
        
        submit= new JButton("SUBMIT");
        submit.setBounds(270,260,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        
        exit= new JButton("EXIT");
        exit.setBounds(420,260,100,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        
        add(l1);
        l1.add(l2);
        l1.add(tf);
        l1.add(submit);
        l1.add(exit);
        l1.add(l3);

            
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(800, 500);
        setLocation(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public int generateRandom(){
        Random ran= new Random();
        return ran.nextInt(1, 101);
    }
    
    public static void main(String[] args) {        
        play gn = new play();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            this.attempt++;
            int num=Integer.parseInt(tf.getText());
            
            if(num<=0||num>100){
                JOptionPane.showMessageDialog(this,"Enter number in valid range 1-100");
                tf.setText("");

            }else{
                
                if(num==this.random_number){
                    
                    new congrats().setVisible(true);
                    this.setVisible(false);

                }
                else{
                    if(this.attempt==4){

                    JOptionPane.showMessageDialog(this,"Reached out of Attempt!!");
                    new GuessTheNumber().setVisible(true);
                    this.setVisible(false);
                    }else{
                
                        l3.setText("Attempt "+this.attempt+" /3");
                        JOptionPane.showMessageDialog(this,"Oops!!! Wrong Guess");
                        tf.setText("");
                    }
                }
            }
        }else if(e.getSource()==exit){
            new GuessTheNumber().setVisible(true);
            this.setVisible(false);
        }
    }
}

