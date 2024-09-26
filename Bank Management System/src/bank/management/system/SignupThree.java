package bank.management.system
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener{
    JLabel head,accdetails,cardhead,cardsubhead,pinhead,pinsubhead,cardnum,pinnum,servicehead;
    JRadioButton savacc,recacc,fdacc,cuacc;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,decleration;
    JButton cancel,submit;
    String fno;
    ButtonGroup bg;
    public SignupThree(String fno)
    {
        this.fno=fno;
        setTitle("APPLICATION FORM");
        
        //Heading
        head= new JLabel("Page 3: Account Details");
        head.setBounds(290,70,500,30);
        head.setFont(new Font("Raleway",Font.BOLD,20));
        
        //Account Type
        accdetails= new JLabel("Account Type:");
        accdetails.setBounds(100,145,200,30);
        accdetails.setFont(new Font("Raleway",Font.BOLD,20));
        
        savacc= new JRadioButton("Saving Account");
        savacc.setBounds(100,190,170,30);        //SA radiobutton
        savacc.setBackground(Color.WHITE);
        
        fdacc= new JRadioButton("Fixed Deposit Account");
        fdacc.setBounds(330,190,170,30);        //FDA radiobutton
        fdacc.setBackground(Color.WHITE);
        
        recacc= new JRadioButton("Recurring Deposit Account");
        recacc.setBounds(100,240,190,30);        //RDA radiobutton
        recacc.setBackground(Color.WHITE);
        
        cuacc= new JRadioButton("Current Account");
        cuacc.setBounds(330,240,170,30);        //CA radiobutton
        cuacc.setBackground(Color.WHITE);
        
        bg= new ButtonGroup();
        bg.add(savacc);
        bg.add(fdacc);
        bg.add(recacc);
        bg.add(cuacc);
        
        //Card Number
        cardhead= new JLabel("Card Number");
        cardhead.setBounds(100,320,500,30);
        cardhead.setFont(new Font("Raleway",Font.BOLD,20));
        
        cardsubhead= new JLabel("Your 16 digit card number");
        cardsubhead.setBounds(100,345,500,30);
        cardsubhead.setFont(new Font("Raleway",Font.BOLD,10));
        
        cardnum= new JLabel("XXXX-XXXX-XXXX-0078");
        cardnum.setBounds(330,320,500,35);
        cardnum.setFont(new Font("Raleway",Font.BOLD,20));
        
        //PIN
        pinhead= new JLabel("PIN");
        pinhead.setBounds(100,400,500,30);
        pinhead.setFont(new Font("Raleway",Font.BOLD,20));
        
        pinsubhead= new JLabel("Your 4 digit password");
        pinsubhead.setBounds(100,425,500,30);
        pinsubhead.setFont(new Font("Raleway",Font.BOLD,10));
        
        pinnum= new JLabel("XXXX");
        pinnum.setBounds(330,400,500,35);
        pinnum.setFont(new Font("Raleway",Font.BOLD,20));
        
        //Services Required
        servicehead= new JLabel("Services Required:");
        servicehead.setBounds(100,480,250,30);
        servicehead.setFont(new Font("Raleway",Font.BOLD,20));
        
        cb1= new JCheckBox("ATM Card");
        cb1.setBounds(100,520,200,30);        //atm card radiobutton
        cb1.setBackground(Color.WHITE);
        
        cb2= new JCheckBox("Internet Banking");
        cb2.setBounds(330,520,200,30);        //Internet Banking radiobutton
        cb2.setBackground(Color.WHITE);
        
        cb3= new JCheckBox("Mobile Banking");
        cb3.setBounds(550,520,200,30);        //Mobile Banking radiobutton
        cb3.setBackground(Color.WHITE);
        
        cb4= new JCheckBox("Cheque Book");
        cb4.setBounds(100,560,200,30);        //Cheque Book radiobutton
        cb4.setBackground(Color.WHITE);
        
        cb5= new JCheckBox("E-Statement");
        cb5.setBounds(330,560,200,30);        //E Statement radiobutton
        cb5.setBackground(Color.WHITE);
        
        cb6= new JCheckBox("Email and SMS Alert");
        cb6.setBounds(550,560,300,30);        //sms radiobutton
        cb6.setBackground(Color.WHITE);
        
        decleration= new JCheckBox("I hereby declare that the information given above is true to the best of my knowledge.");
        decleration.setBounds(100,620,700,30);        //Decleration
        decleration.setBackground(Color.WHITE);
        
        //Cancel
        cancel= new JButton("CANCEL");
        cancel.setBounds(300,670,90,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        
         //Submit
        submit= new JButton("SUBMIT");
        submit.setBounds(410,670,85,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        
        add(head);
        add(accdetails);
        add(savacc);
        add(fdacc);
        add(cuacc);
        add(recacc);
        add(cardhead);
        add(cardsubhead);
        add(cardnum);
        add(pinhead);
        add(pinsubhead);
        add(pinnum);
        add(servicehead);
        add(cb1);
        add(cb2);
        add(cb3);
        add(cb4);
        add(cb5);
        add(cb6);
        add(decleration);
        add(cancel); cancel.addActionListener(this);
        add(submit); submit.addActionListener(this);
        setSize(850,800);
        setLocation(350,10);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
                String accType="";
            if(savacc.isSelected()){
                accType="Saving";
            }else if(fdacc.isSelected()){
                accType="Fixed Deposit";
            }else if(recacc.isSelected()){
                accType="Recurring Deposit";
            }else if(cuacc.isSelected())
            {
                accType="Current";
            }

            Random r= new Random();
            String cardNumber= Math.abs((r.nextLong()%90000000L)+ 5040658200000000L)+"";
            String pin=Math.abs((r.nextLong()%9000)+1000)+"";

            String facility="";
            if(cb1.isSelected()){
                facility+="Atm ";
            }
            if(cb2.isSelected()){
                facility+="Internet Banking ";
            }
            if(cb3.isSelected()){
                facility+="Mobile BAnking ";
            }
            if(cb4.isSelected()){
                facility+="Cheque Book ";
            }
            if(cb5.isSelected())
            {
                facility+="E Statement ";
            }
            if(cb6.isSelected()){
                facility+="SMS/Email alert ";
            }

            if(decleration.isSelected())
            {
                try{
                    System.out.println("insert into signupThree values('" + this.fno + "','" + accType + "','" + cardNumber + "','" + pin + "','" + facility+"')");
                    con co= new con();
                    String query = "insert into signupThree values('" + this.fno + "','" + accType + "','" + cardNumber + "','" + pin + "','" + facility+"')";
                    co.stm.executeUpdate(query);
                    System.out.println(query);
                           
                    String query2 = "insert into login values('" + cardNumber + "','" + pin + "')";
                    co.stm.executeUpdate(query2);
                    System.out.println("signupThree field updated in database");

                    JOptionPane.showMessageDialog(this,"Card Number: "+cardNumber+"\n"+" PIN: "+pin);
                    setVisible(false);
                    new transaction(pin).setVisible(true);
                }
                catch(Exception error){}
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Requires Decleration to Proceed!");
            }
        }
        
        else if(e.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
            System.out.println("Cancel");
        }
    
    }
    
    public static void main(String[] args)
    {
        SignupThree su3= new SignupThree("");
        su3.setVisible(true);
    }
 
}

    