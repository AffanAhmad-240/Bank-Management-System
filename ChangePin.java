import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener {
    JPasswordField pinCh1 , pinCh2;
    JButton chanBtn, bacBt;
    String pinNo;
    public ChangePin(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);

        ImageIcon t1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image t1_1 = t1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon t1_2 = new ImageIcon(t1_1);
        JLabel fixIm = new JLabel(t1_2);
        fixIm.setBounds(0,0,800,700);
        add(fixIm);

        JLabel pinC = new JLabel("CHANGE YOUR PIN");
        pinC.setForeground(Color.WHITE);
        pinC.setBounds(220,230, 200, 40);
        pinC.setFont(new Font("Raleway", Font.BOLD, 17));
        fixIm.add(pinC);

        JLabel pinC1 = new JLabel("NEW PIN:");
        pinC1.setForeground(Color.WHITE);
        pinC1.setBounds(150,270, 100, 30);
        pinC1.setFont(new Font("Raleway", Font.BOLD, 12));
        fixIm.add(pinC1);

        pinCh1 = new JPasswordField();
        pinCh1.setFont(new Font("Raleway", Font.BOLD, 12));
        pinCh1.setBounds(290, 270, 140, 25);
        fixIm.add(pinCh1);

        JLabel pinC2 = new JLabel("RE-ENTER NEW PIN:");
        pinC2.setForeground(Color.WHITE);
        pinC2.setBounds(150,310, 130, 30);
        pinC2.setFont(new Font("Raleway", Font.BOLD, 12));
        fixIm.add(pinC2);

        pinCh2 = new JPasswordField();
        pinCh2.setFont(new Font("Raleway", Font.BOLD, 12));
        pinCh2.setBounds(290, 310, 140, 25);
        fixIm.add(pinCh2);

        chanBtn = new JButton("CHANGE");
        chanBtn.setBounds(330, 350, 100, 30);
        chanBtn.setForeground(Color.BLACK);
        chanBtn.addActionListener(this);
        fixIm.add(chanBtn);

        bacBt = new JButton("BACK");
        bacBt.setBounds(330, 390, 100, 30);
        bacBt.setForeground(Color.BLACK);
        bacBt.addActionListener(this);
        fixIm.add(bacBt);

        setSize(800,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == chanBtn) {
            try {
                String pin = pinCh1.getText();
                String re_pin = pinCh2.getText();

                if(pin.equals("") && re_pin.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill out required fields");
                }
                else if(pin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new pin");
                }
                else if(re_pin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new pin");
                }
            else if(!pin.equals(re_pin)){
                JOptionPane.showMessageDialog(null, "Pin does not match");
                return;
            }

             else {

            Connectivity c = new Connectivity();
            String query1 = "update BankDepWith set pin = '"+re_pin+"' where pin = '"+pinNo+"'";
            String query2 = "update login set pin = '"+re_pin+"' where pin = '"+pinNo+"'";
            String query3 = "update signupThree set pin = '"+re_pin+"' where pin = '"+pinNo+"'";

            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transaction(re_pin);
              }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else
            setVisible(false);
        new Transaction(pinNo);

    }
//    public static void main(String[] args) {
//        new ChangePin("");
//    }
}
