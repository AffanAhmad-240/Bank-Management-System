import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    // Globally define these bcz these are also used outside constructor
    JButton sign_in , clear, sign_up;
    JTextField cdField;
    JPasswordField pinField;


    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img_size = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        // we can't pass Image in JLabel therefore we create another object of image icon and
        // pass object of Image into it.
        ImageIcon fixed_Img = new ImageIcon(img_size);
        JLabel label = new JLabel(fixed_Img);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);

        // textField for card no
        cdField = new JTextField();
        cdField.setFont(new Font("Arial", Font.BOLD, 14));
        cdField.setBounds(300, 150, 230, 30);
        add(cdField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        // textField for pin
        pinField = new JPasswordField();
        pinField.setFont(new Font("Arial", Font.BOLD, 14));
        pinField.setBounds(300, 220, 230, 30);
        add(pinField);

        // sign_in button
        sign_in = new JButton("SIGN IN");
        sign_in.setBounds(300, 300, 100, 30);
        sign_in.setBackground(Color.BLACK);
        sign_in.setForeground(Color.white);
        sign_in.addActionListener(this);
        add(sign_in);

        // clear button
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        // sign_up button
        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(300, 350, 230, 30);
        sign_up.setBackground(Color.BLACK);
        sign_up.setForeground(Color.white);
        sign_up.addActionListener(this);
        add(sign_up);


        // This below line change the colour of frame
        getContentPane().setBackground(Color.white);

        setSize(800, 480);
        setVisible(true);
        setLocation(300, 130);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cdField.setText("");
            pinField.setText("");
        } else if (ae.getSource() == sign_up) {
            setVisible(false);
            new SignupOne();
        } else if (ae.getSource() == sign_in) {
            Connectivity conn = new Connectivity();
            String cardNo = cdField.getText();
            String pinNo = pinField.getText();

            String query = "select * from login where cardNum = '"+cardNo+"' and pin = '"+pinNo+"'";
            try{
                ResultSet r_Set = conn.s.executeQuery(query);
                if(r_Set.next()){ // This line means data came here . (if written login credentials match wth data present in database
                  setVisible(false);
                  new Transaction(pinNo);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin ");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
