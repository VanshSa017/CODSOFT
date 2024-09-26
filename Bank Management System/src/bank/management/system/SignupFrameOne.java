package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.*;

public class SignupFrameOne extends JFrame implements ActionListener {
    JLabel heading, subhead, name, fathname, dob, gender, marstatus, email, address, city, state, pincode;
    JTextField nameText, fathnameText, emailText, addressText, cityText, stateText, pincodeText;
    JDateChooser dateChooser;
    JRadioButton rmale, rfemale;
    JRadioButton rmarried, runmarried, rdivorced;
    ButtonGroup bg, bg2;
    JButton next, clear;
    long count;

    public SignupFrameOne() {
        super("APPLICATION FORM");

        // Heading Design
        Random ran = new Random();
        count = Math.abs((ran.nextLong() % 9000L) + 1000);
        heading = new JLabel("APPLICATION FORM NO. " + count);
        heading.setBounds(140, 20, 600, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 38));
        heading.setForeground(Color.BLUE);

        // Subheading Design
        subhead = new JLabel("Page 1: Personal Details");
        subhead.setBounds(290, 70, 500, 30);
        subhead.setFont(new Font("Raleway", Font.BOLD, 20));

        // Name Label and textfield
        name = new JLabel("Name:");
        name.setBounds(100, 145, 200, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        nameText = new JTextField();
        nameText.setBounds(330, 145, 400, 30);
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));

        // Father Name Label and textfield
        fathname = new JLabel("Father Name:");
        fathname.setBounds(100, 195, 200, 30);
        fathname.setFont(new Font("Raleway", Font.BOLD, 18));
        fathnameText = new JTextField();
        fathnameText.setBounds(330, 195, 400, 30);
        fathnameText.setFont(new Font("Raleway", Font.BOLD, 14));

        // DOB Label and chooser
        dob = new JLabel("Date of Birth:");
        dob.setBounds(100, 245, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 18));

        dateChooser = new JDateChooser();
        dateChooser.setBounds(330, 245, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 14));

        // Gender
        gender = new JLabel("Gender:");
        gender.setBounds(100, 295, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 18));

        rmale = new JRadioButton("Male");
        rmale.setBounds(330, 295, 100, 30); // MALE radiobutton
        rmale.setBackground(Color.WHITE);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(450, 295, 100, 30); // FEMALE radiobutton
        rfemale.setBackground(Color.WHITE);
        bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        // Marital status
        marstatus = new JLabel("Marital status:");
        marstatus.setBounds(100, 345, 200, 30);
        marstatus.setFont(new Font("Raleway", Font.BOLD, 18));

        rmarried = new JRadioButton("Married:");
        rmarried.setBounds(330, 345, 123, 30); // MALE radiobutton
        rmarried.setBackground(Color.WHITE);

        runmarried = new JRadioButton("Unmarried");
        runmarried.setBounds(468, 345, 123, 30); // FEMALE radiobutton
        runmarried.setBackground(Color.WHITE);

        rdivorced = new JRadioButton("Divorced");
        rdivorced.setBounds(606, 345, 123, 30); // FEMALE radiobutton
        rdivorced.setBackground(Color.WHITE);

        bg2 = new ButtonGroup();
        bg2.add(rmarried);
        bg2.add(runmarried);
        bg2.add(rdivorced);

        // email
        email = new JLabel("Email:");
        email.setBounds(100, 395, 200, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        emailText = new JTextField();
        emailText.setBounds(330, 395, 400, 30);
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));

        // Address
        address = new JLabel("Address:");
        address.setBounds(100, 445, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        addressText = new JTextField();
        addressText.setBounds(330, 445, 400, 30);
        addressText.setFont(new Font("Raleway", Font.BOLD, 14));

        // city
        city = new JLabel("City:");
        city.setBounds(100, 495, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        cityText = new JTextField();
        cityText.setBounds(330, 495, 400, 30);
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));

        // State
        state = new JLabel("State:");
        state.setBounds(100, 545, 200, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        stateText = new JTextField();
        stateText.setBounds(330, 545, 400, 30);
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));

        // pincode
        pincode = new JLabel("Pin Code:");
        pincode.setBounds(100, 595, 200, 30);
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincodeText = new JTextField();
        pincodeText.setBounds(330, 595, 400, 30);
        pincodeText.setFont(new Font("Raleway", Font.BOLD, 14));

        // Next Button
        next = new JButton("NEXT");
        next.setBounds(620, 660, 80, 30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);

        setLayout(null);
        add(heading);
        add(subhead);
        add(name);
        add(nameText);
        add(fathname);
        add(fathnameText);
        add(dob);
        add(dateChooser);
        add(gender);
        add(rmale);
        add(rfemale);
        add(marstatus);
        add(rmarried);
        add(runmarried);
        add(rdivorced);
        add(email);
        add(emailText);
        add(address);
        add(addressText);
        add(city);
        add(cityText);
        add(state);
        add(stateText);
        add(pincode);
        add(pincodeText);
        add(next);

        // Register a Listener to the next Button
        next.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Handling Event
    @Override
    public void actionPerformed(ActionEvent e) {
        if (nameText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name field Should not be empty");
        } else if (fathnameText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Father Name field Should not be empty");
        } else if (emailText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email field Should not be empty");
        } else if (addressText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address field Should not be empty");
        } else if (cityText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "City field Should not be empty");
        } else if (stateText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "State field Should not be empty");
        } else if (pincodeText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pincode field Should not be empty");
        } else if(!rmarried.isSelected() && !runmarried.isSelected() && !rdivorced.isSelected()){
            JOptionPane.showMessageDialog(this, "Maritial field Should not be empty");
        }else if(!rmale.isSelected() && !rfemale.isSelected()){
            JOptionPane.showMessageDialog(this, "Gender field Should not be empty");
        }
        
        
        else {
            String formno = count + "";
            String storeName = nameText.getText();
            String storeFathname = fathnameText.getText();
            String storeDob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String storeGender = "";
            if (rmale.isSelected()) {
                storeGender = "Male";
            } else if (rfemale.isSelected()) {
                storeGender = "Female";
            }

            String storeEmail = emailText.getText();

            // storing marital status
            String storemaristatus = "";
            if (rmarried.isSelected()) {
                storemaristatus = "Married";
            } else if (runmarried.isSelected()) {
                storemaristatus = "UnMarried";
            }
            if (rdivorced.isSelected()) {
                storemaristatus = "Divorced";
            }

            String storeAddress = addressText.getText();
            String storeCity = cityText.getText();
            String storeState = stateText.getText();
            String storePincode = pincodeText.getText();

            try {
                con co = new con();
                String query = "insert into signup values('" + formno + "','" + storeName + "','" + storeFathname + "','" + storeDob + "','" + storeGender + "','" + storemaristatus + "','" + storeEmail + "','" + storeAddress + "','" + storeCity + "','" + storeState + "','" + storePincode + "')";
                co.stm.executeUpdate(query);
                System.out.println("signupOne field updated in database");
            } catch (Exception error) {
                error.printStackTrace();
            }

            setVisible(false);
            new SignupFrameTwo(formno).setVisible(true);
        }
    }

    public static void main(String args[]) {
        SignupFrameOne mf2 = new SignupFrameOne();
        mf2.setVisible(true);
    }
}

