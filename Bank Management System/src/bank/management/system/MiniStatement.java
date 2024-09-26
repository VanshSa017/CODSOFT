package bank.management.system;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class MiniStatement extends JFrame implements ActionListener {

    JLabel bankname,img,details,stmt,bal,displayDate;
    String pin;
    String str,str2;
    JButton ok;
    public MiniStatement(String pin){
        
        setTitle("Mini Statement");
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/unionbank.png"));
        Image i2= i1.getImage().getScaledInstance(100,50, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        img= new JLabel(i3);
        img.setBounds(20,20,100,50);
        
        
        bankname= new JLabel("Union Bank of India");
        bankname.setBounds(130,30, 300, 20);
        bankname.setFont(new Font("System",Font.BOLD,16));

        
        //details
        details=new JLabel();
        details.setBounds(35,100, 300, 20);
        
        try{
            con c= new con();
            ResultSet rs=c.stm.executeQuery("select CardNumber from signupThree where PIN='"+this.pin+"'");
            while(rs.next()){
                this.str="Card Number:   "+rs.getString("CardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("CardNumber").substring(12);
            }
            
        }catch(Exception e){}
        
        details.setText(this.str);
        details.setFont(new Font("Raleway",Font.BOLD,14));
        
        stmt= new JLabel();
        add(stmt);
        
        try{
            con cn= new con();
            String query2="select * from transaction where PIN='"+this.pin+"'";
            ResultSet rs2=cn.stm.executeQuery(query2);
            while(rs2.next()){
                stmt.setText(stmt.getText()+"<html>"+rs2.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs2.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs2.getString("amount")+"<br><br><html>");
            }
        }catch(Exception er){}
        
        stmt.setBounds(20,140,400,295);
        
        
        bal= new JLabel("Your Total Balance is: Rs "+balanceAmount(this.pin));
        bal.setBounds(20,450, 300, 20);
        bal.setFont(new Font("System",Font.BOLD,16));
        bal.setForeground(Color.red);
        
        ok=new JButton("Back");
        ok.setBounds(215,510,120,30);
//        ok.setBackground(new Color(48, 45, 42));
//        ok.setForeground(Color.WHITE);
        
        
        
        add(img);
        add(bankname);
        add(details);
        add(bal);
        add(ok);ok.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    public static void main(String args[]) {
        
        new MiniStatement("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new transaction(this.pin).setVisible(true);
    }
}
