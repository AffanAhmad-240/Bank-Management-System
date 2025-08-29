import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNo;
    public BalanceEnquiry(String pinNo){
        this.pinNo = pinNo;
        setLayout(null);

        ImageIcon t1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image t1_1 = t1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon t1_2 = new ImageIcon(t1_1);
        JLabel fixIm = new JLabel(t1_2);
        fixIm.setBounds(0,0,800,700);
        add(fixIm);

        back = new JButton("Back");
        back.setBounds(350,370,80,30);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        fixIm.add(back);

        // if you want to display on frame then we build connection inside the constructor.
        Connectivity c = new Connectivity();
        int balance = 0;
        try{

            ResultSet rs = c.s.executeQuery("select * from BankDepWith where pin = '"+pinNo+"'");

            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

        JLabel label1 = new JLabel("Your current account balance is: ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Raleway", Font.BOLD, 13));
        label1.setBounds(150, 240, 220, 30);
        fixIm.add(label1);

        JTextField bal = new JTextField("Rs: " + balance);
        bal.setFont(new Font("Raleway", Font.BOLD, 13));
        bal.setBounds(370,240,80, 30);
        bal.setEditable(false);
        bal.setCaretColor(new Color(0,0,0,0));
        fixIm.add(bal);

        setSize(800,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinNo);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
