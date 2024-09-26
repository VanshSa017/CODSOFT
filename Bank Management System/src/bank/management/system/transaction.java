package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class transaction extends JFrame implements ActionListener {
    
    JLabel img,heading;
    JButton deposit,withdrawal,fastcash,pinchange,ministmt,balenq,exit;
    String pin;
    public transaction(String pin)
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
        deposit=new JButton("Deposit");
        deposit.setBounds(165,415,150,30);
        
        //Button-2
        withdrawal=new JButton("Cash Withdraw");
        withdrawal.setBounds(355,415,150,30);
        
        //Button-3
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(165,450,150,30);
        
        //Button-4
        ministmt=new JButton("Mini Statement");
        ministmt.setBounds(355,450,150,30);
        
        //Button-5
        pinchange=new JButton("PIN Change");
        pinchange.setBounds(165,485,150,30);
        
        //Button-6
        balenq=new JButton("Balance Enquiry");
        balenq.setBounds(355,485,150,30);
        
        //Exit
        exit=new JButton("EXIT");
        exit.setBounds(355,520,150,30);
        
        
        add(img);
        img.add(heading);
        img.add(deposit); deposit.addActionListener(this);
        img.add(withdrawal);withdrawal.addActionListener(this);
        img.add(fastcash);fastcash.addActionListener(this);
        img.add(ministmt);ministmt.addActionListener(this);
        img.add(pinchange);pinchange.addActionListener(this);
        img.add(balenq);balenq.addActionListener(this);
        img.add(exit); exit.addActionListener(this);
        setLayout(null);
        setSize(900,940);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit)
        {
            System.exit(0);
        }else if(e.getSource()==deposit){
            setVisible(false);
            new deposit(this.pin).setVisible(true);
        }else if(e.getSource()==withdrawal){
            setVisible(false);
            new withdraw(this.pin).setVisible(true);
        }else if(e.getSource()==fastcash){
            setVisible(false);
            new FastCash(this.pin).setVisible(true);
        }else if(e.getSource()==balenq){
            setVisible(false);
            new balance(this.pin).setVisible(true);
            
        }else if(e.getSource()==pinchange){
            setVisible(false);
            new ChangePin(this.pin).setVisible(true);
        }else if(e.getSource()==ministmt){
            new MiniStatement(this.pin).setVisible(true);
        }
    }
    public static void main(String args[]) {
        
        new transaction("").setVisible(true);
    }

}
