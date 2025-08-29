import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Transaction extends JFrame implements ActionListener {
    JButton dep, cash_with, fast_c, min_stat, pin_ch, balance_E, exit;
    String pinNo;

    public Transaction(String pinNo) {
        this.pinNo = pinNo;

        setLayout(null);

        ImageIcon t1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image t1_1 = t1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon t1_2 = new ImageIcon(t1_1);
        JLabel fixIm = new JLabel(t1_2);
        fixIm.setBounds(0,0,800,700);
        add(fixIm);

        JLabel tr_1 = new JLabel("Please select your transaction");
        tr_1.setFont(new Font("Raleway", Font.BOLD, 17));
        tr_1.setBounds(180,220,300,40);
        tr_1.setForeground(Color.WHITE);
        fixIm.add(tr_1);

        dep = new JButton("Deposit");
        dep.setFont(new Font("Raleway", Font.BOLD, 12));
        dep.setBounds(160,270, 125,30);
        dep.addActionListener(this);
        fixIm.add(dep);

        cash_with = new JButton("Cash Withdraw");
        cash_with.setFont(new Font("Raleway", Font.BOLD, 12));
        cash_with.setBounds(320,270, 125,30);
        cash_with.addActionListener(this);
        fixIm.add(cash_with);

        fast_c = new JButton("Fast Cash");
        fast_c.setFont(new Font("Raleway", Font.BOLD, 12));
        fast_c.setBounds(160,310, 125,30);
        fast_c.addActionListener(this);
        fixIm.add(fast_c);

        min_stat = new JButton("Mini Statement");
        min_stat.setFont(new Font("Raleway", Font.BOLD, 12));
        min_stat.setBounds(320,310, 125,30);
        min_stat.addActionListener(this);
        fixIm.add(min_stat);

        pin_ch = new JButton("Pin Change");
        pin_ch.setFont(new Font("Raleway", Font.BOLD, 12));
        pin_ch.setBounds(160,350, 125,30);
        pin_ch.addActionListener(this);
        fixIm.add(pin_ch);

        balance_E = new JButton("Balance Enquiry");
        balance_E.setFont(new Font("Raleway", Font.BOLD, 12));
        balance_E.setBounds(320,350, 125,30);
        balance_E.addActionListener(this);
        fixIm.add(balance_E);

        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway", Font.BOLD, 12));
        exit.setBounds(320,390, 125,30);
        exit.addActionListener(this);
        fixIm.add(exit);

        setSize(800,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setUndecorated(true); // this remove the things which are above frame such as cross tab
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == dep) {
            setVisible(false);
            new Deposit(pinNo);
        } else if(ae.getSource() == cash_with){
            setVisible(false);
            new Withdraw(pinNo);
        } else if(ae.getSource() == fast_c){
            setVisible(false);
            new FastCash(pinNo);
        } else if (ae.getSource() == pin_ch) {
            setVisible(false);
            new ChangePin(pinNo);

        } else if (ae.getSource() == balance_E) {
            setVisible(false);
            new BalanceEnquiry(pinNo);
        } else if (ae.getSource() == min_stat) {
            new MiniStatement(pinNo);
        }
    }


//    public static void main(String[] args) {
//         new Transaction(" ");
//
//    }
}


