import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinNo;
    public MiniStatement(String pinNo) {
        this.pinNo = pinNo;

        setLayout(null);
        setTitle("Mini Statement");



        JLabel bank = new JLabel("NexaVault Bank");
        bank.setFont(new Font("Raleway", Font.BOLD, 17));
        bank.setBounds(125,20,150,30);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,30);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400, 200);
        add(mini);

        JLabel bal = new JLabel();
        bal.setFont(new Font("Raleway", Font.BOLD, 16));
        bal.setBounds(20,400,350,20);
        add(bal);


        try{
            Connectivity c = new Connectivity();
            String query1 = "select * from login where pin = '"+pinNo+"'";
            ResultSet rs = c.s.executeQuery(query1);
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("CardNum").substring(0,4) + "-XXXX-XXXX-" + rs.getString("CardNum").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        int balance = 0;
        try{
            Connectivity c = new Connectivity();
            String query2 = "select * from BankDepWith where pin = '"+pinNo+"'";
            ResultSet rs1 = c.s.executeQuery(query2);
            while(rs1.next()) {
                mini.setText(mini.getText() +"<html>" + rs1.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("amount")+ "<br><br><html>");

                if(rs1.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs1.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs1.getString("amount"));
                }
            }
            bal.setText("Your current account balance is Rs: " + balance);
        } catch (Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20,20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

//    public static void main(String[] args) {
//        new MiniStatement("");
//    }
}
