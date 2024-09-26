package bank.management.system;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class balance extends JFrame implements ActionListener {

    JLabel img,heading,subheading,bal;
    String pin;
    JButton back;
    public balance(String pin){
        
        this.pin=pin;
        //Main Image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,940, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        img= new JLabel(i3);
        img.setBounds(0,0,900,900);
        
        //statement
        Date d= new Date();
        heading=new JLabel();
        heading.setText("Your Current Balance Reported on");
        heading.setBounds(200, 300,300,30);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("System",Font.BOLD,16));
        
        //cont--
        subheading=new JLabel();
        subheading.setText(d+" is:");
        subheading.setBounds(215, 335,300,30);
        subheading.setForeground(Color.WHITE);
        subheading.setFont(new Font("System",Font.BOLD,14));
        
        //Balance
        bal=new JLabel();
        bal.setText("Rs "+balanceAmount(this.pin));
        bal.setBounds(165,415,300,30);
        bal.setForeground(Color.WHITE);
        bal.setFont(new Font("System",Font.BOLD,25));
        
        //Button-1
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        
        
        add(img);
        img.add(heading);
        img.add(subheading);
        img.add(bal);
        img.add(back); back.addActionListener(this);
        setLayout(null);
        setSize(900,940);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==back){
            setVisible(false);
            new transaction(this.pin).setVisible(true);
        }
    }
    
    public int balanceAmount(String pin){
        int balance=0;
        try
        {
            con c= new con();
            ResultSet rs= c.stm.executeQuery("select type,amount from transaction where pin='"+pin+"'");

            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }           
        }catch(Exception e){}
           
        return balance;
    }

    public static void main(String args[]){
        new balance("").setVisible(true);
    }

    
}
