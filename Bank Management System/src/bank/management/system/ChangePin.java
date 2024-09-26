package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangePin extends JFrame implements ActionListener {

    JLabel img,heading;
    JLabel newpin,repin;
    JPasswordField newpinText,repinText;
    JButton back,change;
    String pin;
    public ChangePin(String pin){
        
        this.pin=pin;
        //Main Image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,940, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        img= new JLabel(i3);
        img.setBounds(0,0,900,900);

        
        //heading
        heading=new JLabel();
        heading.setText("CHANGE YOUR PIN");
        heading.setBounds(250,280,300,30);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("System",Font.BOLD,20));
        
        //NEW pin
        newpin=new JLabel();
        newpin.setText("New PIN:");
        newpin.setBounds(165,350,300,30);
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("Raleway",Font.BOLD,16));
        
        //re pin
        repin=new JLabel();
        repin.setText("Re-Enter New PIN:");
        repin.setBounds(165,390,300,30);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        
        //new pin text
        newpinText=new JPasswordField(150);
        newpinText.setBounds(350,350,150,25);
        newpinText.setBackground(Color.WHITE);
        newpinText.setFont(new Font("Raleway",Font.BOLD,16));
        
        //repinText
        repinText=new JPasswordField(150);
        repinText.setBounds(350,390,150,25);
        repinText.setBackground(Color.WHITE);
        repinText.setFont(new Font("Raleway",Font.BOLD,16));
        
        //Button-1
        change=new JButton("Change");
        change.setBounds(355,485,150,30);
        
        //Button-2
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        
        add(img);
        img.add(heading);
        img.add(newpin);
        img.add(repin);
        img.add(newpinText);
        img.add(repinText);
        img.add(change);change.addActionListener(this);
        img.add(back);back.addActionListener(this);
        
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
        else if(e.getSource()==change){
               String storenewpin= newpinText.getText();
                String storerepin=  repinText.getText();
               if(storenewpin.equals("")||storerepin.equals("")){
                   JOptionPane.showMessageDialog(this,"One or more field cannot be empty!");
               }else{
                   if(!storenewpin.equals(storerepin)){
                       JOptionPane.showMessageDialog(this,"PIN entered do not match!");
                   }else{
                       System.out.println("PIN not empty and matched");
                       try{
                            con c= new con();
                            String query1="update signupThree set PIN='"+storenewpin+"' where PIN='"+this.pin+"'";
                            String query2="update transaction set pin='"+storenewpin+"' where pin='"+this.pin+"'";
                            String query3="update login set PIN='"+storenewpin+"' where PIN='"+this.pin+"'";
                            c.stm.executeUpdate(query1);
                            c.stm.executeUpdate(query2);
                            c.stm.executeUpdate(query3);
                            
                            JOptionPane.showMessageDialog(this,"PIN Changed");
                            setVisible(false);
                            this.pin=storenewpin;   //change pin globally
                            new transaction(this.pin).setVisible(true);  //pass new pin to transaction window so that new transaction is made in name of new pin
                       }catch(Exception error){}
                   }
               }
        }
    }
    
    
    public static void main(String args[]) {
        new ChangePin("").setVisible(true);
    }

    
}
