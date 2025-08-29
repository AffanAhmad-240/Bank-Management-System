import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField WithFld;
    JButton WithBtn, bacBtn;
    String pinNo;
    public Withdraw(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);

        ImageIcon de_1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image de_1_1 = de_1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon de_1_2 = new ImageIcon(de_1_1);
        JLabel label = new JLabel(de_1_2);
        label.setBounds(0,0, 800,700);
        add(label);

        JLabel depMain = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        depMain.setFont(new Font("Raleway", Font.BOLD, 14));
        depMain.setBounds(155, 235, 300, 40);
        depMain.setForeground(Color.WHITE);
        label.add(depMain);

        WithFld = new JTextField();
        WithFld.setFont(new Font("Raleway", Font.BOLD, 14));
        WithFld.setBounds(155,275, 280, 30);
        label.add(WithFld);

        WithBtn = new JButton("WITHDRAW");
        WithBtn.setFont(new Font("Arial", Font.BOLD, 11));
        WithBtn.setBounds(335,325,100,30);
        WithBtn.setBackground(Color.WHITE);
        WithBtn.addActionListener(this);
        label.add(WithBtn);

        bacBtn = new JButton("BACK");
        bacBtn.setFont(new Font("Arial", Font.BOLD, 11));
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
        if (ae.getSource() == WithBtn) {
            String withdraw = WithFld.getText();
            Date date = new Date();
            if(withdraw.equals("")){
                JOptionPane.showMessageDialog(null,"Please write withdrawal amount");
            }
            else {
                try {
                    Connectivity conn = new Connectivity();
                    String query = "insert into BankDepWith values('"+pinNo+"', '" +date+ "', 'Withdraw','"+withdraw+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs." + withdraw + " withdrawal successfully");
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
//        new Withdraw("");
//    }
}

