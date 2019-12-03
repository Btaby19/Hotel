import admin.Admin;
import customer.HotelManagement;
import customer.SignUp;
import db.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main
{
    private JFrame frame;
    private JTextField username;
    private JPasswordField password;
    private JLabel lblPassword;
    private JButton Signup;
    private JButton admin;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     * @throws Exception
     */
    public Main() throws Exception {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws Exception
    {
        frame = new JFrame("Hotel");
        frame.setBounds(0, 0, 500, 375);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        username = new JTextField();
        username.setBounds(130, 85, 236, 28);
        frame.getContentPane().add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setBounds(130, 169, 236, 28);
        password.setEchoChar('*');
        frame.getContentPane().add(password);
        password.setColumns(10);

        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setBounds(132, 60, 120, 15);
        frame.getContentPane().add(lblUserName);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(133, 142, 70, 15);
        frame.getContentPane().add(lblPassword);



        Signup = new JButton("Sign Up");
        Signup.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                SignUp.SignUp();
            }
        });
        Signup.setBounds(199, 273, 117, 25);
        frame.getContentPane().add(Signup);

        admin=new JButton("Admin");
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin ad=new Admin();
                ad.adminLogin(frame);
            }
        });
        admin.setBounds(199, 240, 117, 25);
        frame.getContentPane().add(admin);

        JButton login = new JButton("Login");
        login.addActionListener(arg0 -> {

            try{

                String name=username.getText();
                String pass=new String(password.getPassword());
                DBUtil dbc=new DBUtil();
                if(dbc.validateLogin(name,pass))
                {
                    //System.out.println("DB Connected");
                    //AdminView.MainFrame mainFrame=new AdminView.MainFrame();
                    //mainFrame.load();
                    HotelManagement cm=new HotelManagement();
                    cm.load(name);
                    frame.setVisible(false);
                    frame.dispose();

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong Input ");
                }
                dbc.close();
            }catch(Exception e2){
                JOptionPane.showMessageDialog(null,"Please Enter Valid username or password");
            }

        });
        login.setBounds(199, 209, 117, 25);
        frame.getContentPane().add(login);
    }
}
