package admin;

import model.Packages;
import model.Car;
import model.Room;
import db.DBUtil;
import model.Selection;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;


public class LeftTreeAdmin {

    private JTree tree;
    private ArrayList<String> roomTypes;
    private DBUtil dbc;

    public JTree getTree() {
        return tree;
    }

    public LeftTreeAdmin() {
        dbc = new DBUtil();
        //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Hotel Management");
        //create the child nodes
        DefaultMutableTreeNode packagesNodes = new DefaultMutableTreeNode("Packages");
        packagesNodes.add(new DefaultMutableTreeNode("Add Package"));

        DefaultMutableTreeNode roomNodes = new DefaultMutableTreeNode("Rooms");
        roomTypes = dbc.loadRoomTypes();
        for (String type : roomTypes) {
            DefaultMutableTreeNode roomNode = new DefaultMutableTreeNode(type);
            roomNode.add(new DefaultMutableTreeNode("Add Room " + type));
            roomNodes.add(roomNode);
        }

        DefaultMutableTreeNode carNodes = new DefaultMutableTreeNode("Cars");
        carNodes.add(new DefaultMutableTreeNode("Add Car"));

        DefaultMutableTreeNode selectedNodes = new DefaultMutableTreeNode("Selection");

        //add the child nodes to the root node
        root.add(packagesNodes);
        root.add(roomNodes);
        root.add(carNodes);
        root.add(selectedNodes);


        //create the tree by passing in the root node
        tree = new JTree(root);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        tree.getLastSelectedPathComponent();
                JPanel panel = MainFrame.centerpanel;
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setFont(new Font(Font.SERIF, Font.BOLD, 18));
                String selected = node.toString();
                if (selected.equals("Packages")) {
                    ArrayList<Packages> packages = dbc.loadPackages();
                    panel.removeAll();
                    panel.add(newColorLabel("Packages"));
                    panel.add(newColorLabel("Name      Price      Description"));

                    for (Packages p : packages) {
                        String pdes = p.getName() + "      " + p.getPrice() + "      " + p.getDescription();
                        JButton button = new JButton("Delete");
                        button.addActionListener(e12 -> {
                            dbc.deletePackage(p.getName());
                            JOptionPane.showMessageDialog(null, "Package successfully deleted : " + p.getName());
                        });
                        panel.add(newLabel(pdes));
                        panel.add(button);
                    }
                    panel.repaint();
                } else if (roomTypes.contains(selected)) {
                    //panel = new JPanel();
                    panel.removeAll();
                    ArrayList<Room> rooms = dbc.loadRoom(selected);
                    System.out.println(rooms.size());
                    panel.removeAll();
                    panel.add(newColorLabel("Room: " + selected));
                    panel.add(newColorLabel("RoomNo      Price      Description"));
                    for (Room p : rooms) {
                        String pdes = p.getRoomNo() + "      " + p.getPrice() + "      " + p.getDescription();
                        JButton button = new JButton("Delete");
                        button.addActionListener(e12 -> {
                            dbc.deleteRoom(p.getRoomNo());
                            JOptionPane.showMessageDialog(null, "Room successfully deleted : " + p.getRoomNo());
                        });
                        panel.add(newLabel(pdes));
                        panel.add(button);
                    }
                    panel.repaint();
                } else if (selected.equals("Cars")) {
                    ArrayList<Car> cars = dbc.loadCars();
                    panel.removeAll();
                    panel.add(newColorLabel("Cars"));
                    panel.add(newColorLabel("ModelNo      Price      Description      Quantity"));
                    for (Car p : cars) {
                        String pdes = p.getModelNo() + "      " + p.getPrice() + "      " + p.getDescription() + "      " + p.getQuantity();
                        JButton button = new JButton("Delete");
                        button.addActionListener(e12 -> {
                            dbc.deleteCar(p.getModelNo());
                            JOptionPane.showMessageDialog(null, "Car successfully deleted : " + p.getModelNo());
                        });
                        panel.add(newLabel(pdes));
                        panel.add(button);
                    }
                    panel.repaint();
                } else if (selected.equals("Selection")) {
                    ArrayList<Selection> selections = dbc.loadSelections();
                    System.out.println(selections.size());
                    panel.removeAll();
                    panel.add(newColorLabel("Selection:"));
                    panel.add(newColorLabel("Username      Package      Room      Car"));
                    for (Selection p : selections) {
                        String pdes = p.getUserName() + "      " + p.getPackageName() + "      " + p.getRoomNo() + "      " +
                                p.getCarModel();
                        panel.add(newLabel(pdes));
                    }
                    panel.repaint();
                } else if (selected.equals("Add Package")) {
                    panel.removeAll();
                    panel.add(newColorLabel("Package"));
                    panel.add(newLabel("Name: "));
                    JTextField name = newTextField();
                    panel.add(name);
                    panel.add(newLabel("Price: "));
                    JTextField price = newTextField();
                    panel.add(price);
                    panel.add(newLabel("Description: "));
                    JTextField desc = newTextField();
                    panel.add(desc);
                    JButton button = new JButton("Add");
                    button.addActionListener(e12 -> {
                        dbc.addPackage(name.getText(), Integer.parseInt(price.getText()), desc.getText());
                        JOptionPane.showMessageDialog(null, "Package successfully added : " + name.getText() + "," + price.getText() + "," + desc.getText());
                    });
                    panel.add(button);
                    panel.repaint();
                } else if (selected.equals("Add Car")) {
                    panel.removeAll();
                    panel.add(newColorLabel("Car"));
                    panel.add(newLabel("ModelNo: "));
                    JTextField modelNo = newTextField();
                    panel.add(modelNo);
                    panel.add(newLabel("Price: "));
                    JTextField price = newTextField();
                    panel.add(price);
                    panel.add(newLabel("Description: "));
                    JTextField desc = newTextField();
                    panel.add(desc);
                    panel.add(newLabel("Quantity: "));
                    JTextField qty = newTextField();
                    panel.add(qty);
                    JButton button = new JButton("Add");
                    button.addActionListener(e12 -> {
                        dbc.addCar(modelNo.getText(), Integer.parseInt(price.getText()), desc.getText(), Integer.parseInt(qty.getText()));
                        JOptionPane.showMessageDialog(null, "Car successfully added : " + modelNo.getText() + "," + price.getText() + "," + desc.getText() + ", " + qty.getText());
                    });
                    panel.add(button);
                    panel.repaint();
                }
                else if (selected.contains("Add Room")) {
                    String type = selected.substring(9, selected.length());
                    panel.removeAll();
                    panel.add(newColorLabel("Room : " + type));
                    panel.add(newLabel("Room No: "));
                    JTextField roomNo = newTextField();
                    panel.add(roomNo);
                    panel.add(newLabel("Price: "));
                    JTextField price = newTextField();
                    panel.add(price);
                    panel.add(newLabel("Description: "));
                    JTextField desc = newTextField();
                    panel.add(desc);
                    JButton button = new JButton("Add");
                    button.addActionListener(e12 -> {
                        dbc.addRoom(Integer.parseInt(roomNo.getText()), Integer.parseInt(price.getText()), desc.getText(), type);
                        JOptionPane.showMessageDialog(null, type + "Room successfully added : " + roomNo.getText() + "," + price.getText() + "," + desc.getText());
                    });
                    panel.add(button);
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

    private JTextField newTextField() {
        JTextField textField = new JTextField(20);
        textField.setMaximumSize(textField.getPreferredSize());
        return textField;
    }
}
