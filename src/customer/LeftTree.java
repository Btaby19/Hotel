package customer;

import model.Packages;
import model.Car;
import model.Room;
import db.DBUtil;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;


public class LeftTree {

    private JTree tree;
    private ArrayList<String> roomTypes;
    private ArrayList<String> packages;
    private ArrayList<String> cars;
    private Packages selectedPackage;
    private Room selectedRoom;
    private Car selectedCar;
    private ArrayList<String> searchResults;
    private DBUtil dbc;

    public JTree getTree() {
        return tree;
    }

    public LeftTree() {
        DBUtil dbc = new DBUtil();
        //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Hotel Management");
        //create the child nodes
        DefaultMutableTreeNode packagesNodes = new DefaultMutableTreeNode("Packages");

        packages = dbc.loadPackageNames();
        for (String pack : packages) {
            packagesNodes.add(new DefaultMutableTreeNode(pack));
        }


        DefaultMutableTreeNode roomNodes = new DefaultMutableTreeNode("Rooms");
        roomTypes = dbc.loadRoomTypes();
        for (String type : roomTypes) {
            roomNodes.add(new DefaultMutableTreeNode(type));
        }


        DefaultMutableTreeNode carNodes = new DefaultMutableTreeNode("Cars");

        cars = dbc.loadCarModels();
        for (String car : cars) {
            carNodes.add(new DefaultMutableTreeNode(car));
        }


        DefaultMutableTreeNode searchNodes = new DefaultMutableTreeNode("Search");

        DefaultMutableTreeNode selectedNodes = new DefaultMutableTreeNode("Selection");


        //add the child nodes to the root node
        root.add(packagesNodes);
        root.add(roomNodes);
        root.add(carNodes);
        root.add(searchNodes);
        root.add(selectedNodes);


        //create the tree by passing in the root node
        tree = new JTree(root);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        tree.getLastSelectedPathComponent();
                JPanel panel = HotelManagement.centerPanel;
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setFont(new Font(Font.SERIF, Font.BOLD, 18));
                String selected = node.toString();
                if (packages.contains(selected)) {
                    Packages p = dbc.loadPackage(selected);
                    System.out.println(p);
                    panel.removeAll();
                    JLabel picLabel = new JLabel(new ImageIcon("package.jpg"));
                    panel.add(picLabel);
                    panel.add(newLabel(""));
                    panel.add(newColorLabel("Package"));
                    panel.add(newLabel("Name: " + p.getName()));
                    panel.add(newLabel("Price: " + p.getPrice() + ""));
                    panel.add(newLabel("Description: " + p.getDescription()));
                    JButton button = new JButton("Select");
                    button.addActionListener(e12 -> {
                        selectedPackage = p;
                        JOptionPane.showMessageDialog(null, "Package successfully selected : " + selectedPackage.getName());
                    });
                    panel.add(button);
                    panel.repaint();
                } else if (roomTypes.contains(selected)) {
                    //panel = new JPanel();
                    ArrayList<Room> r = dbc.loadRoom(selected);
                    System.out.println(r.size());
                    panel.removeAll();
                    JLabel picLabel = new JLabel(new ImageIcon("room1.jpg"));
                    panel.add(picLabel);
                    for (Room ir : r) {
                        panel.add(newLabel(""));
                        panel.add(newColorLabel("Room"));
                        panel.add(newLabel("Room No: " + ir.getRoomNo() + ""));
                        panel.add(newLabel("Price: " + ir.getPrice() + ""));
                        panel.add(newLabel("Description: " + ir.getDescription()));
                        JButton button = new JButton("Select");
                        button.addActionListener(e1 -> {
                            selectedRoom = ir;
                            JOptionPane.showMessageDialog(null, "Room successfully selected : " + selectedRoom.getRoomNo());
                        });
                        panel.add(button);
                    }
                    panel.repaint();
                } else if (cars.contains(selected)) {
                    Car c = dbc.loadCar(selected);
                    System.out.println(c);
                    //panel = new JPanel();
                    panel.removeAll();
                    JLabel picLabel = new JLabel(new ImageIcon("car.png"));
                    panel.add(picLabel);
                    panel.add(newLabel(""));
                    panel.add(newColorLabel("Car"));
                    panel.add(newLabel("Model: " + c.getModelNo()));
                    panel.add(newLabel("Price: " + c.getPrice() + ""));
                    panel.add(newLabel("Description: " + c.getDescription()));
                    JButton button = new JButton("Select");
                    button.addActionListener(e1 -> {
                        selectedCar = c;
                        JOptionPane.showMessageDialog(null, "Car successfully selected : " + selectedCar.getModelNo());
                    });
                    panel.add(button);
                    panel.repaint();
                } else if (selected.equals("Selection")) {
                    panel.removeAll();
                    boolean flag = false;
                    if (selectedPackage != null) {
                        panel.add(newLabel(""));
                        panel.add(newColorLabel("Package"));
                        panel.add(newLabel("Name: " + selectedPackage.getName()));
                        panel.add(newLabel("Price: " + selectedPackage.getPrice() + ""));
                        panel.add(newLabel("Description: " + selectedPackage.getDescription()));
                        flag = true;
                    }
                    if (selectedRoom != null) {
                        panel.add(newLabel(""));
                        panel.add(newColorLabel("Room"));
                        panel.add(newLabel("Room No: " + selectedRoom.getRoomNo() + ""));
                        panel.add(newLabel("Price: " + selectedRoom.getPrice() + ""));
                        panel.add(newLabel("Description: " + selectedRoom.getDescription()));
                        flag = true;
                    }
                    if (selectedCar != null) {
                        panel.add(newLabel(""));
                        panel.add(newColorLabel("Car"));
                        panel.add(newLabel("Model: " + selectedCar.getModelNo()));
                        panel.add(newLabel("Price: " + selectedCar.getPrice() + ""));
                        panel.add(newLabel("Description: " + selectedCar.getDescription()));
                        flag = true;
                    }
                    if (flag) {
                        /*JButton discard = new JButton("Discard Selected");
                        discard.addActionListener(e1 -> {
                            selectedCar = null;
                            selectedRoom = null;
                            selectedPackage = null;
                        });
                        panel.add(discard);*/
                        JButton save = new JButton("Save Selection");
                        save.addActionListener(e1 -> {
                            dbc.addSelection(HotelManagement.userName, (selectedPackage == null ? null : selectedPackage.getName()),
                                    (selectedRoom == null ? null : selectedRoom.getRoomNo()) , (selectedCar == null ? null : selectedCar.getModelNo()));
                            JOptionPane.showMessageDialog(null, "Selection Saved");
                            selectedCar = null;
                            selectedRoom = null;
                            selectedPackage = null;
                        });
                        panel.add(save);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Nothing Selected");

                    }
                    panel.repaint();

                } else if (selected.contains("Search")) {
                    panel.removeAll();
                    JTextField searchText = new JTextField(20);
                    searchText.setMaximumSize(searchText.getPreferredSize());
                    JLabel searchLabel = newLabel("");
                    JButton searchButton = new JButton("Search");
                    searchButton.addActionListener(e1 -> {
                        searchResults = dbc.loadSearchResults(searchText.getText().toLowerCase().trim());
                        searchLabel.setText("<html>");
                        for (String s : searchResults) {
                            searchLabel.setText(searchLabel.getText() + "<br/>" + s);
                        }
                        searchLabel.setText(searchLabel.getText() + "</html>");
                    });
                    panel.add(searchText);
                    panel.add(searchButton);
                    panel.add(searchLabel);
                    panel.repaint();
                }

            }
        });
        tree.setShowsRootHandles(true);
    }

    private JLabel newLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(null);
        return label;
    }

    private JLabel newColorLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(null);
        label.setForeground(Color.BLUE);
        return label;
    }
}
