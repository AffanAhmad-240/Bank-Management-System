import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField depFld;
    JButton depBtn, bacBtn;
    String pinNo;
    public Deposit(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);

        ImageIcon de_1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image de_1_1 = de_1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon de_1_2 = new ImageIcon(de_1_1);
        JLabel label = new JLabel(de_1_2);
        label.setBounds(0,0, 800,700);
        add(label);

        JLabel depMain = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        depMain.setFont(new Font("Raleway", Font.BOLD, 14));
        depMain.setBounds(155, 235, 300, 40);
        depMain.setForeground(Color.WHITE);
        label.add(depMain);

         depFld = new JTextField();
        depFld.setFont(new Font("Raleway", Font.BOLD, 14));
        depFld.setBounds(155,275, 280, 30);
        label.add(depFld);

         depBtn = new JButton("DEPOSIT");
        depBtn.setFont(new Font("Arial", Font.BOLD, 13));
        depBtn.setBounds(335,325,100,30);
        depBtn.setBackground(Color.WHITE);
        depBtn.addActionListener(this);
        label.add(depBtn);

        bacBtn = new JButton("BACK");
        depBtn.setFont(new Font("Arial", Font.BOLD, 13));
        bacBtn.setBounds(335,365,100,30);
        bacBtn.setBackground(Color.WHITE);
        bacBtn.addActionListener(this);
        label.add(bacBtn);


        setSize(800,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == depBtn) {
            String deposit = depFld.getText();
            Date date = new Date();
            if(deposit.equals("")){
                JOptionPane.showMessageDialog(null,"Please write deposit amount");
            } else {
                try {
                    Connectivity conn = new Connectivity();
                    String query = "insert into BankDepWith values('"+pinNo+"', '" +date+ "', 'Deposit','"+deposit+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs." + deposit + " deposited successfully");
                    setVisible(false);
                    new Transaction(pinNo);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if(ae.getSource() == bacBtn){
            setVisible(false);
            new Transaction(pinNo);
        }
    }

//    public static void main(String[] args) {
//          new Deposit("");
//    }
}
