package Hotel.Management.System;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {
    PickUp(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3 , 45 , 48));
        panel.setBounds(5 , 5 , 790 , 590);
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(90 , 11 , 160 , 25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Cambria" , Font.BOLD , 20));
        panel.add(pus);

        JLabel TOC = new JLabel("Type of Car");
        TOC.setBounds(32 , 97 , 89 , 16);
        TOC.setForeground(Color.WHITE);
        TOC.setFont(new Font("Georgia" , Font.PLAIN , 14));
        panel.add(TOC);

        Choice c = new Choice();
        c.setBounds(123 , 94 , 150 , 25);
        panel.add(c);

        try{
            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("select * from driver");
            while (resultSet.next()){
                c.add(resultSet.getString("carname"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10 , 233 , 800 , 250);
        table.setBackground(new Color(3 , 45 , 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            con C = new con();
            String q = "select * from driver";
            ResultSet resultSet = C.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(24 , 208 , 100 , 14);
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(165 , 208 , 100 , 14);
        age.setFont(new Font("Georgia" , Font.BOLD, 15));
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(264 , 208 , 46 , 14);
        gender.setFont(new Font("Georgia" , Font.BOLD, 15));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(366 , 208 , 100 , 14);
        company.setFont(new Font("Georgia" , Font.BOLD, 15));
        company.setForeground(Color.WHITE);
        panel.add(company);

        JLabel Carname = new JLabel("Carname");
        Carname.setBounds(486 , 208 , 100 , 14);
        Carname.setFont(new Font("Georgia" , Font.BOLD, 15));
        Carname.setForeground(Color.WHITE);
        panel.add(Carname);

        JLabel available = new JLabel("Available");
        available.setBounds(600 , 208 , 100 , 14);
        available.setFont(new Font("Georgia" , Font.BOLD, 15));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel location = new JLabel("location");
        location.setBounds(700 , 208 , 100 , 14);
        location.setFont(new Font("Georgia" , Font.BOLD, 15));
        location.setForeground(Color.WHITE);
        panel.add(location);

        JButton display = new JButton("Display");
        display.setBounds(200 , 500 , 120 , 30);
        display.setBackground(Color.WHITE);
        display.setForeground(Color.BLACK);
        display.setFont(new Font("Arial" , Font.BOLD, 14));
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carname = '"+c.getSelectedItem()+"'";
                try {
                    con c = new con();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(420 , 500 , 120 , 30);
        Back.setBackground(Color.WHITE);
        Back.setForeground(Color.BLACK);
        Back.setFont(new Font("Arial" , Font.BOLD, 14));
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setLayout(null);
        setSize(800 , 600);
        setLocation(500 , 100);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PickUp();
    }
}
