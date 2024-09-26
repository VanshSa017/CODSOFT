package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener {
    
    JLabel img,heading;
    JButton w100,w500,w1000,w5000,w2000,w10000,back;
    String pin;
    public FastCash(String pin)
    {
        this.pin=pin;
        //Main Image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,940, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        img= new JLabel(i3);
        img.setBounds(0,0,900,900);

        
        //heading
        heading=new JLabel();
        heading.setText("Please Select Your Transaction");
        heading.setBounds(230, 300,300,30);
        heading.setForeground(new Color(194, 192, 188));
        heading.setFont(new Font("System",Font.BOLD,14));
        
        //Button-1
        w100=new JButton("Rs 100");
        w100.setBounds(165,415,150,30);
        
        //Button-2
        w500=new JButton("Rs 500");
        w500.setBounds(355,415,150,30);
        
        //Button-3
        w1000=new JButton("Rs 1000");
        w1000.setBounds(165,450,150,30);
        
        //Button-4
        w2000=new JButton("Rs 2000");
        w2000.setBounds(355,450,150,30);
        
        //Button-5
        w5000=new JButton("PRs 5000");
        w5000.setBounds(165,485,150,30);
        
        //Button-6
        w10000=new JButton("Rs 10000");
        w10000.setBounds(355,485,150,30);
        
        //Exit
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        
        
        add(img);
        img.add(heading);
        img.add(w100); w100.addActionListener(this);
        img.add(w500);w500.addActionListener(this);
        img.add(w1000);w1000.addActionListener(this);
        img.add(w2000);w2000.addActionListener(this);
        img.add(w5000);w5000.addActionListener(this);
        img.add(w10000);w10000.addActionListener(this);
        img.add(back); back.addActionListener(this);
        setLayout(null);
        setSize(900,940);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        
        Date d=new Date();
        String query="";
        if(e.getSource()==back)
        {
            backOperation();
        }else if(e.getSource()==w100){
            if(balanceCalculate(100)){
                try{
                    query = "insert into transaction values('" + this.pin + "','" + d + "','" + "Withdraw" + "','" + "100" + "')";
                    con cn=new con();
                    cn.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"Withdrawal Rs.100 successfully.");
                    backOperation();
                }
                catch(Exception error){}
            }
            else
                JOptionPane.showMessageDialog(this,"Insufficient Balance");
                
            
        }else if(e.getSource()==w500){
            
             if(balanceCalculate(500)){
                try{
                    query = "insert into transaction values('" + this.pin + "','" + d + "','" + "Withdraw" + "','" + "500" + "')";
                    con cn=new con();
                    cn.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"Withdrawal Rs.500 successfully.");
                    backOperation();
                }
                catch(Exception error){}
            }
            else
                JOptionPane.showMessageDialog(this,"Insufficient Balance");
        }else if(e.getSource()==w1000)
        {
             if(balanceCalculate(1000)){
                try{
                    query = "insert into transaction values('" + this.pin + "','" + d + "','" + "Withdraw" + "','" + "1000" + "')";
                    con cn=new con();
                    cn.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"Withdrawal Rs.1000 successfully.");
                    backOperation();
                }
                catch(Exception error){}
            }
            else
                JOptionPane.showMessageDialog(this,"Insufficient Balance");
             
             
        }else if(e.getSource()==w2000){
             if(balanceCalculate(2000)){
                try{
                    query = "insert into transaction values('" + this.pin + "','" + d + "','" + "Withdraw" + "','" + "2000" + "')";
                    con cn=new con();
                    cn.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"Withdrawal Rs.2000 successfully.");
                    backOperation();
                }
                catch(Exception error){}
            }
            else
                JOptionPane.showMessageDialog(this,"Insufficient Balance");
             
             
             
        }else if(e.getSource()==w5000)
        {
             if(balanceCalculate(5000)){
                try{
                    query = "insert into transaction values('" + this.pin + "','" + d + "','" + "Withdraw" + "','" + "5000" + "')";
                    con cn=new con();
                    cn.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"Withdrawal Rs.5000 successfully.");
                    backOperation();
                }
                catch(Exception error){}
            }
            else
                JOptionPane.showMessageDialog(this,"Insufficient Balance");
             
             
             
        }else if(e.getSource()==w10000){
            if(balanceCalculate(10000)){
                try{
                    query = "insert into transaction values('" + this.pin + "','" + d + "','" + "Withdraw" + "','" + "10000" + "')";
                    con cn=new con();
                    cn.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"Withdrawal Rs.10000 successfully.");
                    backOperation();
                }
                catch(Exception error){}
            }
            else
                JOptionPane.showMessageDialog(this,"Insufficient Balance");
        }
        
    }
    
    public void backOperation(){
            setVisible(false);
            new transaction(this.pin).setVisible(true);
    }
    
    public boolean balanceCalculate(int amt){
        int balance=0;
        try
        {
            con c= new con();
            ResultSet rs= c.stm.executeQuery("select type,amount from transaction where pin='"+this.pin+"'");

            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }           
        }catch(Exception e){}
           
        if(balance>=amt)
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String args[]) {
        
        new FastCash("").setVisible(true);
    }

}
