import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JCheckBox c1_A, c2_I, c3_M, c4_E, c5_C, c6_Es, c7_tc;
    JRadioButton sav_acc, Fxd_acc, curr_acc, Rec_acc;
    JButton canBtn, subBtn;
    String random1;

    public SignupThree(String random1) {
        this.random1 = random1;

        setSize(800, 730);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setLayout(null);

//      setLocation(260,5);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Image adjustment
        ImageIcon Mic1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image Mic2 = Mic1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon Mic3 = new ImageIcon(Mic2);
        JLabel img_label2 = new JLabel(Mic3);
        img_label2.setBounds(130, 10, 100, 100);
        add(img_label2);


        JLabel acc_details = new JLabel("Page 3: Account Details");
        acc_details.setFont(new Font("Osward", Font.BOLD, 25));
        acc_details.setBounds(250, 30, 400, 50);
        add(acc_details);

        JLabel acc_T = new JLabel("Account Type: ");
        acc_T.setFont(new Font("Raleway", Font.BOLD, 20));
        acc_T.setBounds(110, 125, 200, 50);
        add(acc_T);

        // Radio button for saving account
        sav_acc = new JRadioButton("Saving Account");
        sav_acc.setFont(new Font("Arial", Font.BOLD, 18));
        sav_acc.setBounds(110, 170, 200, 50);
        sav_acc.setBackground(Color.white);
        add(sav_acc);

        // Radio button for fixed deposit account
        Fxd_acc = new JRadioButton("Fixed Deposit Account");
        Fxd_acc.setFont(new Font("Arial", Font.BOLD, 18));
        Fxd_acc.setBounds(330, 170, 250, 50);
        Fxd_acc.setBackground(Color.white);
        add(Fxd_acc);

        // Radio button for current account
        curr_acc = new JRadioButton("Current Account");
        curr_acc.setFont(new Font("Arial", Font.BOLD, 18));
        curr_acc.setBounds(110, 220, 200, 50);
        curr_acc.setBackground(Color.white);
        add(curr_acc);

        // Radio button for Recurring Deposit Account
        Rec_acc = new JRadioButton("Recurring Deposit Account");
        Rec_acc.setFont(new Font("Arial", Font.BOLD, 18));
        Rec_acc.setBounds(330, 220, 300, 50);
        Rec_acc.setBackground(Color.white);
        add(Rec_acc);

        // For grouping of radio buttons
        ButtonGroup Ty_Group = new ButtonGroup();
        Ty_Group.add(sav_acc);
        Ty_Group.add(Fxd_acc);
        Ty_Group.add(curr_acc);
        Ty_Group.add(Rec_acc);

        JLabel crdNo = new JLabel("Card Number: ");
        crdNo.setFont(new Font("Raleway", Font.BOLD, 20));
        crdNo.setBounds(110, 290, 150, 40);
        add(crdNo);

        JLabel crd_details = new JLabel("(Your 16 Digit Card Number) ");
        crd_details.setFont(new Font("Raleway", Font.BOLD, 14));
        crd_details.setBounds(110, 310, 200, 40);
        add(crd_details);

        JLabel demoCno = new JLabel("XXXX-XXXX-XXXX-4184");
        demoCno.setFont(new Font("Raleway", Font.BOLD, 20));
        demoCno.setBounds(350, 290, 250, 40);
        add(demoCno);

        JLabel info_crd = new JLabel("It would appear on ATM CardCheque Book and Statements  ");
        info_crd.setFont(new Font("Raleway", Font.BOLD, 12));
        info_crd.setBounds(350, 310, 400, 40);
        add(info_crd);

        JLabel pn = new JLabel("Pin: ");
        pn.setFont(new Font("Raleway", Font.BOLD, 20));
        pn.setBounds(110, 350, 150, 40);
        add(pn);

        JLabel pn_details = new JLabel("(4-digit password) ");
        pn_details.setFont(new Font("Raleway", Font.BOLD, 14));
        pn_details.setBounds(110, 370, 150, 40);
        add(pn_details);

        JLabel pn_demo = new JLabel("XXXX");
        pn_demo.setFont(new Font("Raleway", Font.BOLD, 20));
        pn_demo.setBounds(350, 350, 150, 40);
        add(pn_demo);

        JLabel ser = new JLabel("Services Required:");
        ser.setFont(new Font("Raleway", Font.BOLD, 20));
        ser.setBounds(110,410,200,40);
        add(ser);

         c1_A = new JCheckBox("ATM CARD");
        c1_A.setFont(new Font("Raleway", Font.BOLD, 20));
        c1_A.setBounds(110, 450, 200, 40);
        c1_A.setBackground(Color.WHITE);
        add(c1_A);

         c2_I = new JCheckBox("Internet Banking");
        c2_I.setFont(new Font("Raleway", Font.BOLD, 20));
        c2_I.setBounds(330, 450, 200, 40);
        c2_I.setBackground(Color.WHITE);
        add(c2_I);


         c3_M = new JCheckBox("Mobile Banking");
        c3_M.setFont(new Font("Raleway", Font.BOLD, 20));
        c3_M.setBounds(110, 490, 200, 40);
        c3_M.setBackground(Color.WHITE);
        add(c3_M);


         c4_E = new JCheckBox("EMAIL Alerts");
        c4_E.setFont(new Font("Raleway", Font.BOLD, 20));
        c4_E.setBounds(330, 490, 200, 40);
        c4_E.setBackground(Color.WHITE);
        add(c4_E);


         c5_C = new JCheckBox("Cheque Book");
        c5_C.setFont(new Font("Raleway", Font.BOLD, 20));
        c5_C.setBounds(110, 530, 200, 40);
        c5_C.setBackground(Color.WHITE);
        add(c5_C);


         c6_Es = new JCheckBox("E-Statement");
        c6_Es.setFont(new Font("Raleway", Font.BOLD, 20));
        c6_Es.setBounds(330, 530, 200, 40);
        c6_Es.setBackground(Color.WHITE);
        add(c6_Es);


         c7_tc = new JCheckBox("I hereby declares that the above entered details correct to the best of my knowledge");
        c7_tc.setFont(new Font("Raleway", Font.BOLD, 13));
        c7_tc.setBounds(110, 580, 650, 40);
        c7_tc.setBackground(Color.WHITE);
        add(c7_tc);


         canBtn = new JButton("Cancel");
        canBtn.setForeground(Color.white);
        canBtn.setBackground(Color.BLACK);
        canBtn.setBounds(250,635,100,40);
        canBtn.addActionListener(this);
        add(canBtn);

         subBtn = new JButton("Submit");
        subBtn.setForeground(Color.white);
        subBtn.setBackground(Color.BLACK);
        subBtn.setBounds(450,635,100,40);
        subBtn.addActionListener(this);
        add(subBtn);

        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == subBtn){
          String accountType = null;
          if(sav_acc.isSelected()){
              accountType = "Saving Account";
          } else if (Fxd_acc.isSelected()) {
              accountType = "Fixed Deposit Account";
          } else if (curr_acc.isSelected()) {
              accountType = "Current Account";
          } else if(Rec_acc.isSelected()){
              accountType = "Recurring Deposit Account";
          }
          Random random = new Random();
          String cardNum = "" + Math.abs((random.nextLong() % 90000000L) +  5040936000000099L);

          String pinNum = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

          String facility = "";
          if(c1_A.isSelected()){
              facility = facility+ "ATM CARD";
          }  if (c2_I.isSelected()){
              facility = facility+ "Internet Banking";
          }  if (c3_M.isSelected()){
              facility = facility+ "Mobile Banking";
          }  if (c4_E.isSelected()){
              facility = facility+ "EMAIL Alerts";
          }  if (c5_C.isSelected()){
              facility = facility+ "Cheque Book";
          }  if (c6_Es.isSelected()){
              facility = facility+ "E-Statement";
          }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required!!!");
                } else {
                    Connectivity conn = new Connectivity();
                    String query1 = "insert into signupThree values('" + random1 + "','" + accountType + "', '" + cardNum + "','" + pinNum + "','" + facility + "')";
                    String query2 = "insert into login values('"+random1+"','"+cardNum+"','"+pinNum+"')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: "+ cardNum +"\nPin: " + pinNum);
                    setVisible(false);
                    new Deposit(pinNum);  // account bnate hi deposit karwana zaroori he
                }

            } catch (Exception e){
                System.out.println(e);
            }


        } else if (ae.getSource() == canBtn) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
         new SignupThree("");
    }
}
