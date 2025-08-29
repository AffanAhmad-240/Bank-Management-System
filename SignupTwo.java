import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener {

    JComboBox cb_rel, cb_cat, cb_inc, cb_Edu, cb_occ;
    JRadioButton S_yes, S_No, E_yes, E_No;
    JButton nxtBtn1;
    String random1;

    SignupTwo(String random1){
        this.random1 = random1;

        setSize(800,730);
        setTitle("NEW APPLICATION FORM - PAGE 2");
        setLocationRelativeTo(null); // by this ,frame is placed in centre.
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image ic2_1 = ic2.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ic2_2 = new ImageIcon(ic2_1);
        JLabel lab1 = new JLabel(ic2_2);
        lab1.setBounds(130,10,100,100);
        add(lab1);

        JLabel addDetails = new JLabel("Page 2: Additional Details");
        addDetails.setFont(new Font("Osward", Font.BOLD, 25));
        addDetails.setBounds(250,10, 400,100);
        add(addDetails);

        JLabel rel = new JLabel("Religion: ");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100, 140, 200, 40);
        add(rel);

        // JCombo Box for Religion
        String [] arr_rel = new String[4];
        arr_rel[0] = "Muslim";
        arr_rel[1] = "Hindu";
        arr_rel[2] = "Christian";
        arr_rel[3] = "Other";
         cb_rel = new JComboBox(arr_rel);
        cb_rel.setBackground(Color.WHITE);
        cb_rel.setBounds(300, 140, 380, 30);
        add(cb_rel);

        JLabel ctg = new JLabel("Category: ");
        ctg.setBounds(100, 200, 200, 40);
        ctg.setFont(new Font("Raleway", Font.BOLD, 20));
        add(ctg);

        // JCombo Box for category. This is another method for writing options. we can use both
         cb_cat = new JComboBox(new String[]{"Debit Card ", "Credit Card", "Prepaid Card"});
        cb_cat.setBackground(Color.WHITE);
        cb_cat.setBounds(300, 200, 380, 30);
        add(cb_cat);

        JLabel inc = new JLabel("Income: ");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100, 260, 200, 40);
        add(inc);

        // JCombo Box for income
        String [] arr_inc = new String[5];
        arr_inc[0] = "Null";
        arr_inc[1] = "< 1,50,000";
        arr_inc[2] = "< 2,50,000";
        arr_inc[3] = "< 5,00,000";
        arr_inc[4] = "Upto 10,00,000";
         cb_inc = new JComboBox(arr_inc);
        cb_inc.setBackground(Color.WHITE);
        cb_inc.setBounds(300, 260, 380, 30);
        add(cb_inc);

        JLabel edu = new JLabel("Educational ");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 320, 150, 40);
        add(edu);
        JLabel eduQ = new JLabel("Qualification:");
        eduQ.setFont(new Font("Raleway", Font.BOLD, 20));
        eduQ.setBounds(100,345,150,40);
        add(eduQ);

        // JCombo Box for Educational Qualification
        String [] arr_Eq = new String[4];
        arr_Eq[0] = "Matriculation";
        arr_Eq[1] = "Intermediate";
        arr_Eq[2] = "Bachelor";
        arr_Eq[3] = "Other";
         cb_Edu = new JComboBox(arr_Eq);
        cb_Edu.setBackground(Color.WHITE);
        cb_Edu.setBounds(300, 333, 380, 30);
        add(cb_Edu);

        JLabel occ = new JLabel("Occupation: ");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100, 405, 200, 40);
        add(occ);

        // JCombo Box for Occupation
        String [] arr_occ = new String[4];
        arr_occ[0] = "Student";
        arr_occ[1] = "Employee";
        arr_occ[2] = "Business Man";
        arr_occ[3] = "Other";
         cb_occ = new JComboBox(arr_occ);
        cb_occ.setBackground(Color.WHITE);
        cb_occ.setBounds(300, 405, 380, 30);
        add(cb_occ);

        JLabel sen = new JLabel("Senior Citizen: ");
        sen.setFont(new Font("Raleway", Font.BOLD, 20));
        sen.setBounds(100, 465, 200, 40);
        add(sen);

         S_yes = new JRadioButton("Yes");
        S_yes.setFont(new Font("Arial", Font.BOLD, 18));
        S_yes.setBounds(300,465,100,40);
        S_yes.setBackground(Color.WHITE);
        add(S_yes);

         S_No = new JRadioButton("No");
        S_No.setFont(new Font("Arial", Font.BOLD, 18));
        S_No.setBounds(450,465,100,40);
        S_No.setBackground(Color.WHITE);
        add(S_No);

        ButtonGroup btn = new ButtonGroup();
        btn.add(S_yes);
        btn.add(S_No);

        JLabel existAcc = new JLabel("Existing Account: ");
        existAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        existAcc.setBounds(100, 525, 200, 40);
        add(existAcc);

         E_yes = new JRadioButton("Yes");
        E_yes.setBackground(Color.WHITE);
        E_yes.setFont(new Font("Arial", Font.BOLD, 18));
        E_yes.setBounds(300,525,100,40);
        add(E_yes);

         E_No = new JRadioButton("No");
        E_No.setFont(new Font("Arial", Font.BOLD, 18));
        E_No.setBounds(450,525,100,40);
        E_No.setBackground(Color.WHITE);
        add(E_No);

        ButtonGroup btn1 = new ButtonGroup();
        btn1.add(E_yes);
        btn1.add(E_No);


        nxtBtn1 = new JButton("Next");
        nxtBtn1.setBounds(570,600,100,40);
        nxtBtn1.setForeground(Color.white);
        nxtBtn1.setBackground(Color.BLACK);
        nxtBtn1.addActionListener(this);
        add(nxtBtn1);


        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae2){

        String religion = (String) cb_rel.getSelectedItem();
        String category = (String) cb_cat.getSelectedItem();
        String income = (String) cb_inc.getSelectedItem();
        String Edu_qualification = (String) cb_Edu.getSelectedItem();
        String occupation = (String) cb_occ.getSelectedItem();

        String sen_citizen = null;
        if(S_yes.isSelected()){
            sen_citizen = "Yes";
        } else if (S_No.isSelected()) {
            sen_citizen = "No";
        }

        String exi_Acc = null;
        if(E_yes.isSelected()){
            exi_Acc = "Yes";
        } else if (E_No.isSelected()) {
            exi_Acc = "No";
        }

        try{
            Connectivity cn = new Connectivity();
            String query = "insert into signupTwo values('"+random1+"','"+religion+"', '"+category+"','"+income+"','"+Edu_qualification+"','"+occupation+"','"+sen_citizen+"','"+exi_Acc+"')";
            cn.s.executeUpdate(query);

            setVisible(false);
            new SignupThree(random1);


        } catch (Exception e){
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
