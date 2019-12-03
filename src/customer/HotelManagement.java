package customer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class HotelManagement extends JFrame {
    static public JPanel centerPanel;
    static public JScrollPane scrollPane;
    static public String userName;

    public void load(String userName) {
        this.userName = userName;
        setTitle("Hotel Management");
        setSize(600, 600);
        setResizable(false);
        setLayout(new BorderLayout(5, 5));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Left Side Tree For Hotel Management
        LeftTree left = new LeftTree();
        add(new JScrollPane(left.getTree()));
        add(left.getTree(), BorderLayout.WEST);

        //title for the center panel
        Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "Options");

        centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //adding the tite
        centerPanel.setBorder(title);
        centerPanel.setToolTipText("Select Your Choice");
        scrollPane = new JScrollPane(centerPanel);
        add(scrollPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
