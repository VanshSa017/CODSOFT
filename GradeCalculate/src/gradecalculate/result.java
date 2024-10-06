package gradecalculate;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class result extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,s1,s2,s3,s4,s5, name_heading,marks_heading,per,grade,m1,m2,m3,m4,m5,p1,p2,p3,p4,p5,g1,g2,g3,g4,g5,final_score,final_grade;
    int marks1,marks2,marks3,marks4,marks5;
    double per1,per2,per3,per4,per5;
    JButton exit,next;
    String name;
    String sem;
    String[][] data;
    
    
    public result(String name,String sem,String[][] data){
        
        this.name=name;
        this.sem=sem;
        this.data=data;
        
        marks1=Integer.parseInt(data[0][1]);
        marks2=Integer.parseInt(data[1][1]);
        marks3=Integer.parseInt(data[2][1]);
        marks4=Integer.parseInt(data[3][1]);
        marks5=Integer.parseInt(data[4][1]);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/images.jpg"));
        Image i2= i1.getImage().getScaledInstance(1000,700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        l1= new JLabel(i3);
        l1.setBounds(0,0,1000,700);
        
        l2= new JLabel("Student Progress Report");
        l2.setBounds(275,-35,1000,150);
        l2.setFont(new Font("Mongolian Baiti",Font.BOLD,40));
        l2.setForeground(Color.WHITE);
        
        l3= new JLabel("Student Name: "+name);
        l3.setBounds(80,110,1000,30);
        l3.setFont(new Font("Mongolian Baiti",Font.BOLD,25));
        l3.setForeground(Color.WHITE);
        
        l4= new JLabel("Semester Name: "+sem);
        l4.setBounds(80,160,1000,30);
        l4.setFont(new Font("Mongolian Baiti",Font.BOLD,25));
        l4.setForeground(Color.WHITE);
        
        name_heading= new JLabel("Subject Name");
        name_heading.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        name_heading.setBounds(150,220,150,16);
        name_heading.setForeground(Color.WHITE);
        
        marks_heading= new JLabel("Marks ");
        marks_heading.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        marks_heading.setBounds(470,220,150,16);
        marks_heading.setForeground(Color.WHITE);
        
        per= new JLabel("Percentage");
        per.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        per.setBounds(600,220,150,18);
        per.setForeground(Color.WHITE);
        
        grade= new JLabel("Grade");
        grade.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        grade.setBounds(760,220,150,16);
        grade.setForeground(Color.WHITE);
        
        s1= new JLabel(data[0][0]);
        s1.setBounds(80,270,1000,20);
        s1.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        s1.setForeground(Color.WHITE);
        
        s2= new JLabel(data[1][0]);
        s2.setBounds(80,320,1000,20);
        s2.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        s2.setForeground(Color.WHITE);
        
        s3= new JLabel(data[2][0]);
        s3.setBounds(80,380,1000,20);
        s3.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        s3.setForeground(Color.WHITE);
        
        s4= new JLabel(data[3][0]);
        s4.setBounds(80,440,1000,20);
        s4.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        s4.setForeground(Color.WHITE);
        
        s5= new JLabel(data[4][0]);
        s5.setBounds(80,500,1000,20);
        s5.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        s5.setForeground(Color.WHITE);
        
        m1= new JLabel(data[0][1]);
        m1.setBounds(445,270,100,25);
        m1.setHorizontalAlignment(JTextField.CENTER);
        m1.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        m1.setForeground(Color.WHITE);
        
        m2= new JLabel(data[1][1]);
        m2.setBounds(445,320,100,25);
        m2.setHorizontalAlignment(JTextField.CENTER);
        m2.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        m2.setForeground(Color.WHITE);
        
        m3= new JLabel(data[2][1]);
        m3.setBounds(445,380,100,25);
        m3.setHorizontalAlignment(JTextField.CENTER);
        m3.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        m3.setForeground(Color.WHITE);
        
        m4= new JLabel(data[3][1]);
        m4.setBounds(445,440,100,25);
        m4.setHorizontalAlignment(JTextField.CENTER);
        m4.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        m4.setForeground(Color.WHITE);
        
        m5= new JLabel(data[4][1]);
        m5.setBounds(445,500,100,25);
        m5.setHorizontalAlignment(JTextField.CENTER);
        m5.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        m5.setForeground(Color.WHITE);
        
        p1= new JLabel(data[0][1]);
        p1.setBounds(590,270,100,25);
        p1.setHorizontalAlignment(JTextField.CENTER);
        p1.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        p1.setForeground(Color.WHITE);
        
        p2= new JLabel(data[1][1]);
        p2.setBounds(590,320,100,25);
        p2.setHorizontalAlignment(JTextField.CENTER);
        p2.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        p2.setForeground(Color.WHITE);
        
        p3= new JLabel(data[2][1]);
        p3.setBounds(590,380,100,25);
        p3.setHorizontalAlignment(JTextField.CENTER);
        p3.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        p3.setForeground(Color.WHITE);
        
        p4= new JLabel(data[3][1]);
        p4.setBounds(590,440,100,25);
        p4.setHorizontalAlignment(JTextField.CENTER);
        p4.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        p4.setForeground(Color.WHITE);
        
        p5= new JLabel(data[4][1]);
        p5.setBounds(590,500,100,25);
        p5.setHorizontalAlignment(JTextField.CENTER);
        p5.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        p5.setForeground(Color.WHITE);
        
        g1= new JLabel(gradecal(marks1));
        g1.setBounds(730,270,100,25);
        g1.setHorizontalAlignment(JTextField.CENTER);
        g1.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        g1.setForeground(Color.WHITE);
        
        g2= new JLabel(gradecal(marks2));
        g2.setBounds(730,320,100,25);
        g2.setHorizontalAlignment(JTextField.CENTER);
        g2.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        g2.setForeground(Color.WHITE);
        
        g3= new JLabel(gradecal(marks3));
        g3.setBounds(730,380,100,25);
        g3.setHorizontalAlignment(JTextField.CENTER);
        g3.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        g3.setForeground(Color.WHITE);
        
        g4= new JLabel(gradecal(marks4));
        g4.setBounds(730,440,100,25);
        g4.setHorizontalAlignment(JTextField.CENTER);
        g4.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        g4.setForeground(Color.WHITE);
        
        g5= new JLabel(gradecal(marks5));
        g5.setBounds(730,500,100,25);
        g5.setHorizontalAlignment(JTextField.CENTER);
        g5.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        g5.setForeground(Color.WHITE);
        
        final_score= new JLabel("Total Percentage: "+((marks1+marks2+marks3+marks4+marks5)/5));
        final_score.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        final_score.setBounds(480,570,200,20);
        final_score.setForeground(Color.WHITE);
        
        final_grade= new JLabel("Grade: "+gradecal((marks1+marks2+marks3+marks4+marks5)/5));
        final_grade.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        final_grade.setBounds(750,570,200,20);
        final_grade.setForeground(Color.WHITE);
        
        exit= new JButton("EXIT");
        exit.setBounds(350,620, 120,25);
        exit.setBackground(new Color(31, 23, 33));
        exit.setForeground(new Color(255,255,255));
        exit.addActionListener(this);
        exit.setFocusable(false);
        
        next= new JButton("BACK");
        next.setBounds(530,620, 120,25);
        next.setBackground(new Color(31, 23, 33));
        next.setForeground(new Color(255,255,255));
        next.addActionListener(this);
        next.setFocusable(false);
        
        add(l1);
        l1.add(l2);
        l1.add(l3);
        l1.add(l4);
        l1.add(name_heading);
        l1.add(marks_heading);
        l1.add(s1);
        l1.add(s2);
        l1.add(s3);
        l1.add(s4);
        l1.add(s5);
        l1.add(per);
        l1.add(grade);
        l1.add(m1);
        l1.add(m2);
        l1.add(m3);
        l1.add(m4);
        l1.add(m5);
        l1.add(p1);
        l1.add(p2);
        l1.add(p3);
        l1.add(p4);
        l1.add(p5);
        l1.add(g1);
        l1.add(g2);
        l1.add(g3);
        l1.add(g4);
        l1.add(g5);
        l1.add(final_score);
        l1.add(final_grade);
        l1.add(exit);
        l1.add(next);
          
        
//        setUndecorated(true);
        setVisible(true);
        setSize(1000,700);
        setLocation(300,70);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public String gradecal(int marks){
        if(marks>=90){
            return "S";
        }else if(marks>=80&&marks<90){
            return "A";
        }else if(marks>=70&&marks<80){
            return "B";
        }else if(marks>=50 && marks<70){
            return "C";
        }else if(marks>=40 && marks<50){
            return "D";
        }else{
            return "F";
        }
    }
    
    public static void main(String...args){
        String[][] ar= new String[2][3];
        new result("","",ar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }else{
            setVisible(false);
            GradeCalculate gc=new GradeCalculate();
            gc.tfname.setText(name);
            gc.semname.setText(sem);
            gc.t1.setText(data[0][0]);
            gc.t2.setText(data[1][0]);
            gc.t3.setText(data[2][0]);
            gc.t4.setText(data[3][0]);
            gc.t5.setText(data[4][0]);
            gc.m1.setText(data[0][1]);
            gc.m2.setText(data[1][1]);
            gc.m3.setText(data[2][1]);
            gc.m4.setText(data[3][1]);
            gc.m5.setText(data[4][1]);
        }
    }
}
