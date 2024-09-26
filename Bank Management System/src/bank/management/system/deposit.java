package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class deposit extends JFrame implements ActionListener{

    JLabel img,heading;
    JTextField amt;
    JButton deposit,back;
    String pin;
    public deposit(String pin)
    {
        this.pin=pin;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,940, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        img= new JLabel(i3);
        img.setBounds(0,0,900,900);
        
        //heading
        heading=new JLabel();
        heading.setText("Enter the amount you want to Deposit");
        heading.setBounds(205,275,300,30);
        heading.setForeground(new Color(194, 192, 188));
        heading.setFont(new Font("System",Font.BOLD,14));

        //TextField
        amt= new JTextField();
        amt.setBounds(185,320,305,25);
        amt.setFont(new Font("System",Font.BOLD,14));
        
        //Button-1
        deposit=new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        
        //Button-2
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        
        add(img);
        img.add(heading);
        img.add(amt);
        img.add(deposit); deposit.addActionListener(this);
        img.add(back); back.addActionListener(this);
        
        setSize(900,940);
        setLocation(300,0);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit)
        {
            if(amt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this,"Field cannot be empty!");
            }else{
                Date d= new Date();
                String amount=amt.getText();
                String query = "insert into transaction values('" + this.pin + "','" + d + "','" + "Deposit" + "','" + amount + "')";
                System.out.println("transaction updated in database");
                try
                {
                    con c=new con();
                    c.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"Deposited Rs."+amount+" successfully.");
                    setVisible(false);
                    new transaction(this.pin).setVisible(true);
                }catch(Exception error){}
            }
        }else if(e.getSource()==back)
        {
            setVisible(false);
            new transaction(this.pin).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new deposit("").setVisible(true);
    }

}
