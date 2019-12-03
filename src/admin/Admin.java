package admin;

import javax.swing.*;


public class Admin {
    public void adminLogin(JFrame frame) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(10);
        pass.setEchoChar('*');
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "The title",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
        String password = "";
        if (option == 0) // pressing OK button
        {
            password = new String(pass.getPassword());
        }
        if (password.equals("bushra")) {
            System.out.println("admin.Admin Logged In");
            frame.setVisible(false);
            frame.dispose();
            MainFrame mainFrame = null;
            try {
                mainFrame = new MainFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mainFrame.load();
        }
    }
}
