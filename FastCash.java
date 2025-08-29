import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton Rs_H, Rs_F, Rs_Thou, Rs_TwoThou, Rs_FiveThou, Rs_TenThous, bacBtn;
    String pinNo;

    public FastCash(String pinNo) {
        this.pinNo = pinNo;

        setLayout(null);

        ImageIcon t1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image t1_1 = t1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon t1_2 = new ImageIcon(t1_1);
        JLabel fixIm = new JLabel(t1_2);
        fixIm.setBounds(0,0,800,700);
        add(fixIm);

        JLabel tr_1 = new JLabel("Select your withdrawal amount:");
        tr_1.setFont(new Font("Raleway", Font.BOLD, 17));
        tr_1.setBounds(180,220,300,40);
        tr_1.setForeground(Color.WHITE);
        fixIm.add(tr_1);

        Rs_H = new JButton("Rs 100");
        Rs_H.setFont(new Font("Raleway", Font.BOLD, 12));
        Rs_H.setBounds(160,270, 125,30);
        Rs_H.addActionListener(this);
        fixIm.add(Rs_H);

        Rs_F = new JButton("Rs 500");
        Rs_F.setFont(new Font("Raleway", Font.BOLD, 12));
        Rs_F.setBounds(320,270, 125,30);
        Rs_F.addActionListener(this);
        fixIm.add(Rs_F);

        Rs_Thou = new JButton("Rs 1000");
        Rs_Thou.setFont(new Font("Raleway", Font.BOLD, 12));
        Rs_Thou.setBounds(160,310, 125,30);
        Rs_Thou.addActionListener(this);
        fixIm.add(Rs_Thou);

        Rs_TwoThou = new JButton("Rs 2000");
        Rs_TwoThou.setFont(new Font("Raleway", Font.BOLD, 12));
        Rs_TwoThou.setBounds(320,310, 125,30);
        Rs_TwoThou.addActionListener(this);
        fixIm.add(Rs_TwoThou);

        Rs_FiveThou = new JButton("Rs 5000");
        Rs_FiveThou.setFont(new Font("Raleway", Font.BOLD, 12));
        Rs_FiveThou.setBounds(160,350, 125,30);
        Rs_FiveThou.addActionListener(this);
        fixIm.add(Rs_FiveThou);

        Rs_TenThous = new JButton("Rs 10000");
        Rs_TenThous.setFont(new Font("Raleway", Font.BOLD, 12));
        Rs_TenThous.setBounds(320,350, 125,30);
        Rs_TenThous.addActionListener(this);
        fixIm.add(Rs_TenThous);

        bacBtn = new JButton("Back");
        bacBtn.setFont(new Font("Raleway", Font.BOLD, 12));
        bacBtn.setBounds(245,390, 115,30);
        bacBtn.addActionListener(this);
        fixIm.add(bacBtn);

        setSize(800,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setUndecorated(true); // this remove the things which are above frame such as cross tab
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == bacBtn){
            setVisible(false);
            new Transaction(pinNo);
        }
        else {
         String amount = ((JButton) ae.getSource()).getText().substring(3);  // .substring(3) remove Rs and space from Rs 500 etc
         Connectivity c = new Connectivity();
         try{

             ResultSet rs = c.s.executeQuery("select * from BankDepWith where pin = '"+pinNo+"'");
             int balance = 0;
             while(rs.next()){
                 if(rs.getString("type").equals("Deposit")){
                     balance += Integer.parseInt(rs.getString("amount"));
                 } else {
                     balance -= Integer.parseInt(rs.getString("amount"));
                 }
             }
             if(ae.getSource() != bacBtn && balance < Integer.parseInt(amount)){
                 JOptionPane.showMessageDialog(null, "Insufficient balance");
             } else {
                 Date date = new Date();
                 String query = "Insert into BankDepWith values('"+pinNo+"','"+ date +"','Withdraw','"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Rs "+amount+" withdrawal successfully");
                 setVisible(false);
                 new Transaction(pinNo);
             }

         } catch (Exception e) {
             System.out.println(e);
         }
        }
    }


//    public static void main(String[] args) {
//        new FastCash("");
//
//    }
}
