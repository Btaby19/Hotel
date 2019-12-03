package customer;

import db.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {

    private JFrame frame;
    private JTextField name;
    private JTextField username;
    private JTextField password;
    private JTextField address;
    private JTextField phone;
    private JTextField email;
    private JTextField checkin;
    private JTextField checkout;


    /**
     * Launch the application.
     */
    public static void SignUp() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUp window = new SignUp();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SignUp() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Sign Up");
        frame.setBounds(100, 100, 700, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);


        JLabel lblName = new JLabel("Name");
        lblName.setBounds(34, 50, 70, 15);
        frame.getContentPane().add(lblName);

        name = new JTextField();
        name.setBounds(34, 70, 280, 35);
        frame.getContentPane().add(name);
        name.setColumns(10);

        JLabel lblusername = new JLabel("User Name");
        lblusername.setBounds(34, 110, 130, 15);
        frame.getContentPane().add(lblusername);

        username = new JTextField();
        username.setBounds(34, 130, 280, 33);
        frame.getContentPane().add(username);
        username.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(34, 170, 70, 15);
        frame.getContentPane().add(lblPassword);

        password = new JTextField();
        password.setBounds(34, 185, 280, 33);
        frame.getContentPane().add(password);
        password.setColumns(10);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(34, 230, 70, 15);
        frame.getContentPane().add(lbladdress);

        address = new JTextField();
        address.setBounds(34, 245, 280, 33);
        frame.getContentPane().add(address);
        address.setColumns(10);


        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(334, 50, 70, 15);
        frame.getContentPane().add(lblPhone);

        phone = new JTextField();
        phone.setBounds(334, 70, 280, 35);
        frame.getContentPane().add(phone);
        phone.setColumns(10);

        JLabel lblemail = new JLabel("E-Mail");
        lblemail.setBounds(334, 110, 70, 15);
        frame.getContentPane().add(lblemail);

        email = new JTextField();
        email.setBounds(334, 130, 280, 33);
        frame.getContentPane().add(email);
        email.setColumns(10);

        JLabel lblcheckin = new JLabel("Check In");
        lblcheckin.setBounds(334, 170, 70, 15);
        frame.getContentPane().add(lblcheckin);

        checkin = new JTextField();
        checkin.setBounds(334, 185, 280, 33);
        frame.getContentPane().add(checkin);
        checkin.setColumns(10);

        JLabel lblcheckout = new JLabel("Check Out");
        lblcheckout.setBounds(334, 230, 130, 15);
        frame.getContentPane().add(lblcheckout);

        checkout = new JTextField();
        checkout.setBounds(334, 245, 280, 33);
        frame.getContentPane().add(checkout);
        checkout.setColumns(10);

        JButton signup = new JButton("Sign Up");
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    String na = name.getText();
                    String user = username.getText();
                    String pass = password.getText();
                    String add = address.getText();
                    String phn = phone.getText();
                    String em = email.getText();
                    String ckin = checkin.getText();
                    String ckout = checkout.getText();
                    if (!user.trim().equals("") && !pass.trim().equals("")) {
                        DBUtil dbc = new DBUtil();
                        dbc.addCustomer(na, user, pass, add, phn, em, ckin, ckout);
                        dbc.close();
                        frame.setVisible(false);
                        frame.dispose();
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Something Went Wrong Please try again Later");
                }
            }
        });
        signup.setBounds(334, 310, 117, 25);
        frame.getContentPane().add(signup);
    }
}
