package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupFrameTwo extends JFrame implements ActionListener {

    JLabel head,religion,category,qualification,occupation,pan,aadhar,senior,existingacc,income;
    JTextField panText,aadharText,occupationText;
    JComboBox religionBox,categoryBox,incomeBox,qualificationBox;
    JRadioButton exist_yes,exist_no,senior_yes,senior_no;
    ButtonGroup bg1,bg2;
    JButton next;
    String fno;
    public SignupFrameTwo(String fno)
    {
        this.fno=fno;
        setTitle("APPLICATION FORM");
        //Heading
        head= new JLabel("Page 2: Additional Information");
        head.setBounds(290,90,500,30);
        head.setFont(new Font("Raleway",Font.BOLD,20));
        
        //Religion
        religion= new JLabel("Religion:");
        religion.setBounds(100,165,200,30);
        religion.setFont(new Font("Raleway",Font.BOLD,18));
        String[] rel={"--Select One--","Hindu","Sikhs","Muslim","Christian","Other"};
        religionBox= new JComboBox(rel);
        religionBox.setBounds(330,165,400,30);
        religionBox.setFont(new Font("Raleway",Font.BOLD,14));
        religionBox.setBackground(Color.WHITE);
        
        //Category
        category= new JLabel("Category:");
        category.setBounds(100,215,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,18));
        String[] cat={"--Select One--","General","SC","ST","OBC"};
        categoryBox= new JComboBox(cat);
        categoryBox.setBounds(330,215,400,30);
        categoryBox.setFont(new Font("Raleway",Font.BOLD,14));
        categoryBox.setBackground(Color.WHITE);
        
        //educational qualification
        qualification= new JLabel("Qualification:");
        qualification.setBounds(100,265,200,30);
        qualification.setFont(new Font("Raleway",Font.BOLD,18));
        String[] edu={"--Select One--","Non Graduated","Graduated","Post Graduated","Doctorate"};
        qualificationBox= new JComboBox(edu);
        qualificationBox.setBounds(330,265,400,30);
        qualificationBox.setFont(new Font("Raleway",Font.BOLD,14));
        qualificationBox.setBackground(Color.WHITE);
        
        //Occupation
        occupation= new JLabel("Occupation:");
        occupation.setBounds(100,315,200,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,18));
        occupationText= new JTextField();
        occupationText.setBounds(330,315,400,30);
        occupationText.setFont(new Font("Raleway",Font.BOLD,14));
        
        //PAN
        pan= new JLabel("PAN Number:");
        pan.setBounds(100,365,200,30);
        pan.setFont(new Font("Raleway",Font.BOLD,18));
        panText= new JTextField();
        panText.setBounds(330,365,400,30);
        panText.setFont(new Font("Raleway",Font.BOLD,14));
        
        //Aadhar Number
        aadhar= new JLabel("Aadhar Number:");
        aadhar.setBounds(100,415,200,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,18));
        aadharText= new JTextField();
        aadharText.setBounds(330,415,400,30);
        aadharText.setFont(new Font("Raleway",Font.BOLD,14));
        
        //Senior Citizen
        senior= new JLabel("Senior Citizen:");
        senior.setBounds(100,465,200,30);
        senior.setFont(new Font("Raleway",Font.BOLD,18));
        senior_yes= new JRadioButton("Yes");
        senior_yes.setBounds(330,465,100,30);        //Yes radiobutton
        senior_yes.setBackground(Color.WHITE);
        
        senior_no= new JRadioButton("No");
        senior_no.setBounds(450,465,100,30);      //No radiobutton
        senior_no.setBackground(Color.WHITE);
        bg1= new ButtonGroup();
        bg1.add(senior_yes);
        bg1.add(senior_no);
        
        //Existing Account
        existingacc= new JLabel("Existing Account:");
        existingacc.setBounds(100,515,200,30);
        existingacc.setFont(new Font("Raleway",Font.BOLD,18));
        exist_yes= new JRadioButton("Yes");
        exist_yes.setBounds(330,515,100,30);        //Yes radiobutton
        exist_yes.setBackground(Color.WHITE);
        
        exist_no= new JRadioButton("No");
        exist_no.setBounds(450,515,100,30);      //No radiobutton
        exist_no.setBackground(Color.WHITE);
        bg1= new ButtonGroup();
        bg1.add(exist_yes);
        bg1.add(exist_no);
        
        //Income
        income= new JLabel("Income:");
        income.setBounds(100,565,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,18));
        String[] inc={"--Select One--","<250000","250000-500000","500000-1000000","100000-2000000",">2000000"};
        incomeBox= new JComboBox(inc);
        incomeBox.setBounds(330,565,400,30);
        incomeBox.setFont(new Font("Raleway",Font.BOLD,14));
        incomeBox.setBackground(Color.WHITE);
        
        //Next Button
        next= new JButton("NEXT");
        next.setBounds(620,660,80,30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        
        add(head);
        add(religion);
        add(religionBox);
        add(category);
        add(categoryBox);
        add(qualification);
        add(qualificationBox);
        add(occupation);
        add(occupationText);
        add(pan);
        add(panText);
        add(aadhar);
        add(aadharText);
        add(senior);
        add(senior_yes);
        add(senior_no);
        add(existingacc);
        add(exist_yes);
        add(exist_no);
        add(income);
        add(incomeBox);
        add(next);
        next.addActionListener(this);
        setLayout(null);
        getContentPane().setBackground(new Color(255,255,255));  //Another way to set color
        setSize(850,800);
        setLocation(350,10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Storing formno.
        String formno=this.fno;
        //Storing Occupation
        String storeOccupation= occupationText.getText();
        //Storing Pan
        String storePan= panText.getText();

        //Storing Senior Citizen
        String storeSenior="";
        if(senior_yes.isSelected()){
            storeSenior="Yes";
        }else if(senior_no.isSelected()){
            storeSenior="No";
        }
        
        //Storing aadhar
        String storeAadhar= aadharText.getText();
        
        //storing Existing Acc
        String storeExisting="";
        if(exist_yes.isSelected()){
            storeExisting="Yes";
        }
        else if(exist_no.isSelected()){
            storeExisting="No";
        }   
        
        String storeReligion= (String)religionBox.getSelectedItem();
        String storeCategory= (String)categoryBox.getSelectedItem();
        String storeQualification=(String) qualificationBox.getSelectedItem();
        String storeIncome=(String)incomeBox.getSelectedItem();
        
        try
        {
            con co= new con();
            String query = "insert into signupTwo values('" + formno + "','" + storeReligion + "','" + storeCategory + "','" + storeQualification + "','" + storeIncome + "','" + storeOccupation + "','" + storePan + "','" + storeAadhar + "','" + storeSenior + "','" + storeExisting+"')";
            co.stm.executeUpdate(query);
            System.out.println("signupTwo field updated in database");
            
        }
        catch(Exception error){}
        
        setVisible(false);
        new SignupThree(this.fno).setVisible(true);
        
    }
    
    public static void main(String args[]) 
    {
        SignupFrameTwo mf3= new SignupFrameTwo("");
        mf3.setVisible(true);
        
    }

    
}
