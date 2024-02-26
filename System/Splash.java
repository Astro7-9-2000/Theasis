package Hotel.Management.System;

import javax.swing.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/theasis-suites.jpg"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(5,10,900 , 700);
        add(label);

        setLayout(null);
        setLocation(325 , 50);
        setSize(900 , 750);
        setVisible(true);

        try {
            Thread.sleep(5000);
            new Login();
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
