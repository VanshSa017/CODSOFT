package gradecalculate;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GradeCalculate extends JFrame implements ActionListener{
       JLabel l1,l2,l3,l4,s1,s2,s3,s4,s5,name_heading,marks_heading;
       JTextField tfname,semname,t1,t2,t3,t4,t5,m1,m2,m3,m4,m5;
       JButton exit,next,clear;
       public String[][] data;
       public String name;
       public String sem;
       
     GradeCalculate(){
        data=new String[5][2]; 
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/images.jpg"));
        Image i2= i1.getImage().getScaledInstance(1000,700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        l1= new JLabel(i3);
        l1.setBounds(0,0,1000,700);
        
        //Making Main Heading
        l2= new JLabel("Student Grade Calculator");
        l2.setBounds(275,-35, 450,150);
        l2.setFont(new Font("Mongolian Baiti",Font.BOLD,40));
        l2.setForeground(Color.WHITE);
        
        tfname= new JTextField();
        tfname.setBounds(80,140,400,30);
        tfname.setHorizontalAlignment(JTextField.CENTER);
        tfname.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        
        semname= new JTextField();
        semname.setBounds(530,140,370,30);
        semname.setHorizontalAlignment(JTextField.CENTER);
        semname.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        
        name_heading= new JLabel("Subject Name");
        name_heading.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        name_heading.setBounds(360,220,150,16);
        name_heading.setForeground(Color.WHITE);
        
        marks_heading= new JLabel("Marks Scored");
        marks_heading.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        marks_heading.setBounds(615,220,150,16);
        marks_heading.setForeground(Color.WHITE);
        
        
        l3= new JLabel("Enter Student Name");
        l3.setBounds(190,40, 450,150);
        l3.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        l3.setForeground(Color.WHITE);
        
        l4= new JLabel("Enter Semester Name");
        l4.setBounds(630,40, 450,150);
        l4.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        l4.setForeground(Color.WHITE);
        
        s1= new JLabel("Subject 1:");
        s1.setBounds(80,260,100,20);
        s1.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        s1.setForeground(Color.WHITE);
        
        s2= new JLabel("Subject 2:");
        s2.setBounds(80,330,100,20);
        s2.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        s2.setForeground(Color.WHITE);
        
        s3= new JLabel("Subject 3:");
        s3.setBounds(80,400,100,20);
        s3.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        s3.setForeground(Color.WHITE);
        
        s4= new JLabel("Subject 4:");
        s4.setBounds(80,470,100,20);
        s4.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        s4.setForeground(Color.WHITE);
        
        s5= new JLabel("Subject 5:");
        s5.setBounds(80,540,100,20);
        s5.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        s5.setForeground(Color.WHITE);
        
        t1= new JTextField();
        t1.setBounds(270,255,300, 25);
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFont(new Font("Mongolian Baiti",Font.PLAIN,18));
        
        t2= new JTextField();
        t2.setBounds(270,325,300, 25);
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setFont(new Font("Mongolian Baiti",Font.PLAIN,18));
        
        t3= new JTextField();
        t3.setBounds(270,395,300, 25);
        t3.setHorizontalAlignment(JTextField.CENTER);
        t3.setFont(new Font("Mongolian Baiti",Font.PLAIN,18));
        
        t4= new JTextField();
        t4.setBounds(270,465,300, 25);
        t4.setHorizontalAlignment(JTextField.CENTER);
        t4.setFont(new Font("Mongolian Baiti",Font.PLAIN,18));
        
        t5= new JTextField();
        t5.setBounds(270,535,300, 25);
        t5.setHorizontalAlignment(JTextField.CENTER);
        t5.setFont(new Font("Mongolian Baiti",Font.PLAIN,18));
        
        m1= new JTextField();
        m1.setBounds(600,255,150, 25);
        m1.setHorizontalAlignment(JTextField.CENTER);
        m1.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        
        m2= new JTextField();
        m2.setBounds(600,325,150, 25);
        m2.setHorizontalAlignment(JTextField.CENTER);
        m2.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        
        m3= new JTextField();
        m3.setBounds(600,395,150, 25);
        m3.setHorizontalAlignment(JTextField.CENTER);
        m3.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        
        m4= new JTextField();
        m4.setBounds(600,465,150, 25);
        m4.setHorizontalAlignment(JTextField.CENTER);
        m4.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        
        m5= new JTextField();
        m5.setBounds(600,535,150, 25);
        m5.setHorizontalAlignment(JTextField.CENTER);
        m5.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        
        exit= new JButton("EXIT");
        exit.setBounds(320,640, 120,25);
        exit.setBackground(new Color(31, 23, 33));
        exit.setForeground(new Color(255,255,255));
        exit.addActionListener(this);
        exit.setFocusable(false);
        
        next= new JButton("Calculate");
        next.setBounds(460,640, 120,25);
        next.setBackground(new Color(31, 23, 33));
        next.setForeground(new Color(255,255,255));
        next.addActionListener(this);
        next.setFocusable(false);
        
        clear= new JButton("CLEAR");
        clear.setBounds(600,640, 120,25);
        clear.setBackground(new Color(31, 23, 33));
        clear.setForeground(new Color(255,255,255));
        clear.addActionListener(this);
        clear.setFocusable(false);
        
        
        add(l1);
        l1.add(l2);
        l1.add(tfname);
        l1.add(semname);
        l1.add(name_heading);
        l1.add(marks_heading);
        l1.add(l3);
        l1.add(l4);
        l1.add(s1);
        l1.add(s2);
        l1.add(s3);
        l1.add(s4);
        l1.add(s5);
        l1.add(t1);
        l1.add(t2);
        l1.add(t3);
        l1.add(t4);
        l1.add(t5);
        l1.add(m1);
        l1.add(m2);
        l1.add(m3);
        l1.add(m4);
        l1.add(m5);
        l1.add(exit);
        l1.add(next);
        l1.add(clear);
        setUndecorated(true);
        setVisible(true);
        setSize(1000,700);
        setLocation(300,70);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new GradeCalculate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==next){
            this.name=tfname.getText();
            this.sem=semname.getText();
            System.out.println(sem);
            data[0][0]=t1.getText();
            data[0][1]=m1.getText();
            
            data[1][0]=t2.getText();
            data[1][1]=m2.getText();
            
            data[2][0]=t3.getText();
            data[2][1]=m3.getText();
            
            data[3][0]=t4.getText();
            data[3][1]=m4.getText();
            
            data[4][0]=t5.getText();
            data[4][1]=m5.getText();
            
            new result(this.name,this.sem,data);
            setVisible(false);
        }else{
            tfname.setText("");
            semname.setText("");
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            m1.setText("");
            m2.setText("");
            m3.setText("");
            m4.setText("");
            m5.setText("");
        }
    }
    
}
