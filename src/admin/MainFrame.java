package admin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class MainFrame extends JFrame {


    static public JPanel centerpanel;

    public void load() {
        setTitle("Hotel Management");
        setSize(600, 600);
        setResizable(false);
        setLayout(new BorderLayout(5, 5));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Left Side Tree For Computer Management
        LeftTreeAdmin left = new LeftTreeAdmin();
        add(new JScrollPane(left.getTree()));
        add(left.getTree(), BorderLayout.WEST);


        //titel for the center panel
        Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "Options");

        centerpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //adding the tite
        centerpanel.setBorder(title);
        centerpanel.setToolTipText("Select Your Choice");
        add(centerpanel, BorderLayout.CENTER);


        //Changin the icons
            /*ImageIcon imageIcon = new ImageIcon(TreeExample.class.getResource("/leaf.jpg"));
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(imageIcon);*/

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


}
