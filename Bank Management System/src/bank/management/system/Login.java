package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField cardTextfield;
    JPasswordField pinTextfield;
    JButton signin,signup,clear;
    int attempt=0;
    public Login()
    {
        super("AUTOMATED TELLER MACHINE");
        //Logo Making
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        l1= new JLabel();
        l1.setIcon(i3);
        l1.setBounds(100, 10, 100,100);
        
        //Making Main Heading
        l2= new JLabel("Welcome to ATM");
        l2.setBounds(280, 10, 300,100);
        l2.setFont(new Font("Times New Roman",Font.BOLD,35));
        
        //Card Number Heading
        l3= new JLabel("Card No.");
        l3.setBounds(200, 180, 100,30);
        l3.setFont(new Font("Times New Roman",Font.BOLD,25));
        
        //PIN Number Heading
        l4= new JLabel("PIN");
        l4.setBounds(200, 240, 100,30);
        l4.setFont(new Font("Times New Roman",Font.BOLD,25));
        
        //Card Number Input Textfield
        cardTextfield= new JTextField();
        cardTextfield.setBounds(350, 180,220,30);
        cardTextfield.setFont(new Font("Arial",Font.BOLD,16));
        
        //Pin Number Input Textfield
        pinTextfield= new JPasswordField();
        pinTextfield.setBounds(350, 240,220,30);
        pinTextfield.setFont(new Font("Arial",Font.BOLD,16));
        
        //Signin Button Design
        signin= new JButton("SIGN IN");
        signin.setBounds(350,300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE); //changing color of a text inside button
        
        //Clear Button Design
        clear= new JButton("CLEAR");
        clear.setBounds(470,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE); //changing color of a text inside button
        clear.addActionListener(this);
        
        //SignUp Button Design
        signup= new JButton("SIGN UP");
        signup.setBounds(350,355,220,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE); //changing color of a text inside button
        signup.addActionListener(this);
        add(l1);
        add(l2);
        add(l3);
        add(cardTextfield);
        add(l4);
        add(pinTextfield);
        add(signin); signin.addActionListener(this);
        add(clear);
        add(signup);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);  //To change the color of a JFrame(Swing)
        setSize(800,480);
        setLocation(350,200); //Setting Loacation of opening a frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Event Handling
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()==signin)
        {
           
            try{
                con c= new con();
                String crdno=cardTextfield.getText();
                String pin=pinTextfield.getText();
                String query = "select * from signupThree where CardNumber='" + crdno + "' and pin='" + pin + "'";
                System.out.println("Query executed...");
                ResultSet rs= c.stm.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new transaction(pin).setVisible(true);
                }else{
                    attempt++;
                    if(attempt==3)
                    {
                        JOptionPane.showMessageDialog(this,"Reached out of attempt! \n Contact your Bank");
                        System.exit(0);
                        
                    }else{
                        JOptionPane.showMessageDialog(this,"Wrong Credential \n Attempt "+attempt+"/3");
                    }
                }
            }catch(Exception error){}
        }
       else if (e.getSource()==clear)
        {
            cardTextfield.setText("");
            pinTextfield.setText("");
        }
       else if(e.getSource()==signup)
        {
            setVisible(false);
            new SignupFrameOne().setVisible(true);  
        }
    }
    
     public static void main(String[] args)
    {
        Login mf= new Login();
        mf.setVisible(true);

    }
}
