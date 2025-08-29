import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupOne extends JFrame implements ActionListener {

    long randomAppNo;
    JTextField name_Fld, F_nameFld, DOBFld, email_Fld, address_Fld, cty_Fld, postalC_Fld, state_Fld;
    JRadioButton Ml, Fl, Mrd, UnMrd, other;

    JButton nxtBtn;
    public SignupOne() {

        setSize(800,730);
        setTitle("NEW ACCOUNT APPLICATION FORM");
        setLayout(null);
        // below lines are for generating application numbers
        Random ran = new Random();
         randomAppNo = ((Math.abs(ran.nextLong() % 9000L)) + 1000L);

//        setLocation(260,5);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Image adjustment
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image ic2 = ic1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel img_label = new JLabel(ic3);
        img_label.setBounds(30,10,100,100);
        add(img_label);

        JLabel text = new JLabel("APPLICATION FORM NO. " + randomAppNo);
        text.setFont(new Font("Osward", Font.BOLD, 35));
        text.setBounds(150, 10, 500, 100);
        add(text);

        JLabel p_details = new JLabel("Page 1: Personal Details");
        p_details.setFont(new Font("Osward", Font.BOLD, 21));
        p_details.setBounds(280, 80, 300, 50);
        add(p_details);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 17));
        name.setBounds(110, 125, 100, 50);
        add(name);

        // name textField
         name_Fld = new JTextField();
        name_Fld.setFont(new Font("Arial", Font.BOLD, 16));
        name_Fld.setBounds(290,132, 350, 30);
        add(name_Fld);

        JLabel F_name = new JLabel("Father's Name: ");
        F_name.setFont(new Font("Raleway", Font.BOLD, 17));
        F_name.setBounds(110, 177, 200, 50);
        add(F_name);

        // Father Name TexField
         F_nameFld = new JTextField();
        F_nameFld.setFont(new Font("Arial", Font.BOLD, 16));
        F_nameFld.setBounds(290,184, 350, 30);
        add(F_nameFld);

        JLabel DOB = new JLabel("Date of Birth: ");
        DOB.setFont(new Font("Raleway", Font.BOLD, 17));
        DOB.setBounds(110, 229, 200, 50);
        add(DOB);

        // DOBFld
         DOBFld = new JTextField();
        DOBFld.setFont(new Font("Arial", Font.BOLD, 16));
        DOBFld.setBounds(290,236, 350, 30);
        add(DOBFld);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 17));
        gender.setBounds(110, 281, 150, 50);
        add(gender);

        // Radio button for male
         Ml = new JRadioButton("Male");
        Ml.setFont(new Font("Arial",Font.BOLD, 15));
        Ml.setBounds(285,283,100,50);
        Ml.setBackground(Color.white);
        add(Ml);

        // Radio button for female
         Fl = new JRadioButton("Female");
        Fl.setFont(new Font("Arial",Font.BOLD, 15));
        Fl.setBounds(410,283,100,50);
        Fl.setBackground(Color.white);
        add(Fl);

        // For grouping of radio buttons
        ButtonGroup MF_group = new ButtonGroup();
        MF_group.add(Ml);
        MF_group.add(Fl);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 17));
        email.setBounds(110, 333, 200, 50);
        add(email);

        // Text Field for email
         email_Fld = new JTextField();
        email_Fld.setFont(new Font("Arial", Font.BOLD, 16));
        email_Fld.setBounds(290,340, 350, 30);
        add(email_Fld);

        JLabel Martial = new JLabel("Martial status: ");
        Martial.setFont(new Font("Raleway", Font.BOLD, 17));
        Martial.setBounds(110, 385, 200, 50);
        add(Martial);

        // Radio button for Married
         Mrd = new JRadioButton("Married");
        Mrd.setFont(new Font("Arial",Font.BOLD, 15));
        Mrd.setBounds(285,387,100,50);
        Mrd.setBackground(Color.white);
        add(Mrd);

        // Radio button for UnMarried
         UnMrd = new JRadioButton("UnMarried");
        UnMrd.setFont(new Font("Arial",Font.BOLD, 15));
        UnMrd.setBounds(410,387,100,50);
        UnMrd.setBackground(Color.white);
        add(UnMrd);

         other = new JRadioButton("Other");
        other.setFont(new Font("Arial",Font.BOLD, 15));
        other.setBounds(535,387,100,50);
        other.setBackground(Color.white);
        add(other);

        // For grouping of radio buttons
        ButtonGroup MU_Group = new ButtonGroup();
        MU_Group.add(Mrd);
        MU_Group.add(UnMrd);
        MU_Group.add(other);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 17));
        address.setBounds(110, 437, 150, 50);
        add(address);

        // Text Field for address
         address_Fld = new JTextField();
        address_Fld.setFont(new Font("Arial", Font.BOLD, 16));
        address_Fld.setBounds(290,444, 350, 30);
        add(address_Fld);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 17));
        city.setBounds(110, 489, 200, 50);
        add(city);

        // Text field for city
         cty_Fld = new JTextField();
        cty_Fld.setFont(new Font("Arial", Font.BOLD, 16));
        cty_Fld.setBounds(290,496, 350, 30);
        add(cty_Fld);

        JLabel post_C = new JLabel("Postal Code : ");
        post_C.setFont(new Font("Raleway", Font.BOLD, 17));
        post_C.setBounds(110, 541, 200, 50);
        add(post_C);

       // Text field for pin
         postalC_Fld = new JTextField();
        postalC_Fld.setFont(new Font("Arial", Font.BOLD, 16));
        postalC_Fld.setBounds(290,548, 350, 30);
        add(postalC_Fld);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 17));
        state.setBounds(110, 593, 200, 50);
        add(state);

        // Text field for state
         state_Fld = new JTextField();
        state_Fld.setFont(new Font("Arial", Font.BOLD, 16));
        state_Fld.setBounds(290,600, 350, 30);
        add(state_Fld);

        // Next Button
         nxtBtn = new JButton("Next");
        nxtBtn.setForeground(Color.white);
        nxtBtn.setBackground(Color.BLACK);
        nxtBtn.setBounds(538,645,100,40);
        nxtBtn.addActionListener(this);
        add(nxtBtn);

        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae1){
        String random1 = "" + randomAppNo;
        String name = name_Fld.getText();
        String F_name = F_nameFld.getText();
        LocalDate DOB = LocalDate.parse(DOBFld.getText());

        String gender = null;
        if(Ml.isSelected()){
            gender = "Male";
        } else if (Fl.isSelected()) {
            gender = "Female";
        }

        String email = email_Fld.getText();

        String M_status = null;
        if(Mrd.isSelected()){
            M_status = "Married";
        } else if (UnMrd.isSelected()) {
            M_status = "UnMarried";
        } else if (other.isSelected()) {
            M_status = "Other";
        }

        String address = address_Fld.getText();
        String city = cty_Fld.getText();
        int postCode = Integer.parseInt(postalC_Fld.getText());
        String state = state_Fld.getText();

        try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null, "Name is required");
           } else {
               Connectivity cn = new Connectivity();
               String query = "insert into signup values('"+random1+"','"+name+"', '"+F_name+"','"+DOB+"','"+gender+"','"+email+"','"+M_status+"','"+address+"','"+city+"','"+postCode+"','"+state+"')";
               cn.s.executeUpdate(query);

               setVisible(false);
               new SignupTwo(random1);
           }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
