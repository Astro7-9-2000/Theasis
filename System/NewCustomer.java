package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber , TextName , TextCountry , TextDeposit;
    JRadioButton r1 , r2;
    Choice c1;
    JLabel date;
    JButton add , back;


    NewCustomer(){

        JPanel panel = new JPanel();
        panel.setBounds(5 , 5 , 840 , 540);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageicon.getImage().getScaledInstance(200 , 200 , Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(500 , 150 , 200 , 200);
        panel.add(imglabel);

        JLabel labelName = new JLabel("NEW CUSTOMER FORM");
        labelName.setBounds(118 , 11 , 260 , 53);
        labelName.setFont(new Font("Cambria" , Font.BOLD , 20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(35 , 76 , 200 , 14);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Passport" , "Aadhar card" , "Voter ID" , "Driving License"});
        comboBox.setBounds(271 , 73 , 150 , 20);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(new Color(3 , 45 , 48));
        comboBox.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number: ");
        labelNumber.setBounds(35 , 111 , 200 , 14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271 , 111 , 150 , 20);
        panel.add(textFieldNumber);

        JLabel labelname = new JLabel("Name: ");
        labelname.setBounds(35 , 151 , 200 , 14);
        labelname.setForeground(Color.WHITE);
        labelname.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(labelname);
        TextName = new JTextField();
        TextName.setBounds(271 , 151 , 150 , 20);
        panel.add(TextName);

        JLabel labelGender = new JLabel("Gender: ");
        labelGender.setBounds(35 , 191 , 200 , 14);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Georgia" , Font.BOLD , 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3 , 45 , 48));
        r1.setBounds(271 , 191 , 80 , 12);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Georgia" , Font.BOLD , 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3 , 45 , 48));
        r2.setBounds(350 , 191 , 80 , 12);
        panel.add(r2);

        JLabel labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(35 , 231 , 200 , 14);
        labelCountry.setForeground(Color.WHITE);
        labelCountry.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(labelCountry);
        TextCountry = new JTextField();
        TextCountry.setBounds(271 , 231 , 150 , 20);
        panel.add(TextCountry);

        JLabel labelRoom = new JLabel("Allocated Room No. : ");
        labelRoom.setBounds(35 , 274 , 200 , 14);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(labelRoom);

        c1 = new Choice();
        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("Select * from room");
            while(resultSet.next()){
                c1.add(resultSet.getString("roomnumber"));
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271 , 274 , 150 , 20);
        c1.setFont(new Font("Georgia" , Font.BOLD , 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelCIS = new JLabel("Checked-In: ");
        labelCIS.setBounds(35 , 316 , 200 , 14);
        labelCIS.setForeground(Color.WHITE);
        labelCIS.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(labelCIS);

       Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271 , 316 , 200 , 14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit : ");
        labelDeposit.setBounds(35 , 359 , 200 , 14);
        labelDeposit.setForeground(Color.WHITE);
        labelDeposit.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(labelDeposit);
        TextDeposit = new JTextField();
        TextDeposit.setBounds(271 , 359 , 150 , 20);
        panel.add(TextDeposit);

        add = new JButton("ADD");
        add.setBounds(100 , 430 , 120 , 30);
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setFont(new Font("Arial" , Font.BOLD , 14));
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260 , 430 , 120 , 30);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Arial" , Font.BOLD , 14));
        back.addActionListener(this);
        panel.add(back);


        setSize(850 , 550 );
        setVisible(true);
        setLocation(500 , 150);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == add){
            con c = new con();
            String radioBtn = null;
            if (r1.isSelected()){
                radioBtn = "Male";
            } else if (r2.isSelected()){
                radioBtn = "Female";
            }

            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = TextName.getText();
            String s4 = radioBtn;
            String s5 = TextCountry.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = TextDeposit.getText();

            try {

                String q = "insert into customer values ('"+s1+"' , '"+s2+"' , '"+s3+"' , '"+s4+"' , '"+s5+"' , '"+s6+"' , '"+s7+"' , '"+s8+"')";
                String q1 = "update room set availability = 'Occupied' where roomnumber = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null , "added successfully");


            }catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
