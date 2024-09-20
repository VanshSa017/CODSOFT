package guessthenumber;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class info extends JFrame implements ActionListener{
    JLabel l1, line1,line2,line3,line4,line5;
    JButton back;
    public info(){
        
        super("Game Info");
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/frame3.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,500, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        l1= new JLabel(i3);
        l1.setBounds(0,0,800,500);
        
        line1= new JLabel("*  You have to guess the correct number between 1 to 100");
        line1.setBounds(25,40,500,20);
        line1.setFont(new Font("Times New Roman",Font.BOLD,20));
        line1.setForeground(Color.WHITE);
        
        line2= new JLabel("*  Think a number and enter it in the text field.");
        line2.setBounds(25,90,500,20);
        line2.setFont(new Font("Times New Roman",Font.BOLD,20));
        line2.setForeground(Color.WHITE);
        
        line3= new JLabel("*  Click on the submit button to check your guess.");
        line3.setBounds(25,140,500,20);
        line3.setFont(new Font("Times New Roman",Font.BOLD,20));
        line3.setForeground(Color.WHITE);
        
        line4= new JLabel("*  You are restricted to 3 attempts only.");
        line4.setBounds(25,190,500,20);
        line4.setFont(new Font("Times New Roman",Font.BOLD,20));
        line4.setForeground(Color.WHITE);
        
        line5= new JLabel("*  If the guess is correct you won otherwise, you lose.");
        line5.setBounds(25,240,500,20);
        line5.setFont(new Font("Times New Roman",Font.BOLD,20));
        line5.setForeground(Color.WHITE);
        
        back= new JButton("BACK");
        back.setBounds(340,310,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFocusable(false);
        
        add(l1);
        l1.add(line1);
        l1.add(line2);
        l1.add(line3);
        l1.add(line4);
        l1.add(line5);
        l1.add(back);
        
        setUndecorated(true);
        setVisible(true);
        setSize(800, 500);
        setLocation(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String...args){
        info obj= new info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            this.setVisible(false);
        }
    }
}
