package db;

import model.Packages;
import model.Car;
import model.Room;
import com.mysql.jdbc.PreparedStatement;
import model.Selection;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DBUtil {
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    public DBUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
            statement = connection.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }

    //Getting Data For Login
    public boolean validateLogin(String n, String p) {
        try {
            String query = "SELECT * FROM customers";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String username = rs.getString("username");
                String pass = rs.getString("password");
                if (n.equals(username) && p.equals(pass)) {
                    return true;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }

        return false;
    }

    //Inserting Data into database from customer.SignUp
    public void addCustomer(String name, String user, String pass, String address, String phone, String email, String checkin, String checkout) {
        try {
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement("INSERT INTO customers(name,username,password,address,phone,email,check_in,check_out)VALUES(?,?,?,?,?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2, user);
            statement.setString(3, pass);
            statement.setString(4, address);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.setString(7, checkin);
            statement.setString(8, checkout);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "SuccesFully Registered");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }

    public ArrayList<String> loadRoomTypes() {
        ArrayList<String> arrayList = new ArrayList<>();
        Room dr;
        try {
            String query = "SELECT distinct type  FROM rooms";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                arrayList.add(rs.getString("type"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
        return arrayList;
    }

    public ArrayList loadRoom(String roomType) {
        ArrayList<Room> arrayList = new ArrayList<>();
        Room dr;
        try {
            String query = "SELECT * FROM rooms where type = '" + roomType + "'";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int RoomNo = Integer.parseInt(rs.getString("RoomNo"));
                int Price = rs.getInt("Price");
                String Description = rs.getString("Description");
                int isAvailable = Integer.parseInt(rs.getString("isAvailable"));
                dr = new Room(RoomNo, Price, Description, isAvailable);
                //System.out.println(id+" "+RoomNo+" "+Price+" "+Description+" "+isAvailable);
                arrayList.add(dr);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }

        return arrayList;
    }

    public ArrayList loadPackages() {
        ArrayList<Packages> arrayList = new ArrayList<>();
        Packages dr;
        try {
            String query = "SELECT * FROM packages";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String Name = rs.getString("Name");
                int Price = Integer.parseInt(rs.getString("Price"));
                String Description = rs.getString("Description");
                dr = new Packages(Name, Price, Description);
                //System.out.println(id+" "+RoomNo+" "+Price+" "+Description+" "+isAvailable);
                arrayList.add(dr);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }

        return arrayList;
    }

    public Packages loadPackage(String pname) {
        Packages p = null;
        try {
            String query = "SELECT * FROM packages where name = '" + pname + "'";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                String Name = rs.getString("Name");
                int Price = Integer.parseInt(rs.getString("Price"));
                String Description = rs.getString("Description");
                p = new Packages(Name, Price, Description);
                //System.out.println(id+" "+RoomNo+" "+Price+" "+Description+" "+isAvailable);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }

        return p;
    }

    public ArrayList<String> loadPackageNames() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String query = "SELECT distinct name FROM packages";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                arrayList.add(rs.getString("name"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }

        return arrayList;
    }

    public ArrayList<Car> loadCars() {
        ArrayList<Car> arrayList = new ArrayList<>();
        Car c = null;
        try {
            String query = "SELECT * FROM cars";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                c = new Car();
                c.setModelNo(rs.getString("modelno"));
                c.setPrice(rs.getInt("price"));
                c.setDescription(rs.getString("description"));
                c.setQuantity(rs.getInt("quantity"));
                arrayList.add(c);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }

        return arrayList;
    }


    public Car loadCar(String model) {
        Car c = null;
        try {
            String query = "SELECT * FROM cars where modelNo = '" + model + "'";
            rs = statement.executeQuery(query);
            if (rs.next()) {
                c = new Car();
                c.setModelNo(rs.getString("modelno"));
                c.setPrice(rs.getInt("price"));
                c.setDescription(rs.getString("description"));
                c.setQuantity(rs.getInt("quantity"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }

        return c;
    }

    public ArrayList<String> loadCarModels() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String query = "SELECT modelNo FROM cars";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                arrayList.add(rs.getString("modelno"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }

        return arrayList;
    }

    public ArrayList<Selection> loadSelections() {
        ArrayList<Selection> arrayList = new ArrayList<>();
        Selection s = null;
        try {
            String query = "SELECT * FROM selection";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                s = new Selection();
                s.setUserName(rs.getString("username"));
                s.setPackageName(rs.getString("packagename"));
                s.setRoomNo(rs.getInt("roomno"));
                s.setCarModel(rs.getString("carmodel"));
                arrayList.add(s);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
        return arrayList;
    }

    public void close() {
        try {
            statement = null;
            connection.close();
            connection = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }

    public ArrayList<String> loadSearchResults(String text) {
        ArrayList<String> results = new ArrayList<>();
        try {
            String query = "SELECT * FROM packages where lower(description) like '%" + text + "%'";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                results.add("Package: " + rs.getString("Name") + ", " + rs.getString("price") + ", " + rs.getString("description"));
            }
            query = "SELECT * FROM rooms where lower(description) like '%" + text + "%'";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                results.add("Room: " + rs.getString("roomNo") + ", " + rs.getString("price") + ", " + rs.getString("description"));
            }
            query = "SELECT * FROM cars where lower(description) like '%" + text + "%'";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                results.add("Car: " + rs.getString("modelNo") + ", " + rs.getString("price") + ", " + rs.getString("description"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
        return results;
    }

    public void addRoom(int roomNo, int price, String description, String type) {
        String query = String.format("insert into rooms (roomNo, price, description, isavailable, type) " +
                " values (%d, %d, '%s', 1, '%s')", roomNo, price, description, type);
        System.out.println(query);
        try {
            statement.executeUpdate(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }

    public void addCar(String modelNo, int price, String description, int quantity) {
        String query = String.format("insert into cars (modelNo, price, description, quantity) " +
                " values ('%s', %d, '%s', %d)", modelNo, price, description, quantity);
        System.out.println(query);
        try {
            statement.executeUpdate(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }

    public void addPackage(String name, int price, String description) {
        String query = String.format("insert into packages (name, price, description) " +
                " values ('%s', '%s', '%s')", name, price, description);
        System.out.println(query);
        try {
            statement.executeUpdate(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }

    public void addSelection(String userName, String packageName, int roomNo, String carModel) {
        String query = String.format("insert into selection (username, packagename, roomno, carmodel) " +
                " values ('%s', '%s', '%s', '%s')", userName, packageName, roomNo, carModel);
        System.out.println(query);
        try {
            statement.executeUpdate(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }

    public void deletePackage(String name) {
        String query = "DELETE FROM packages where name = '" + name + "'";
        System.out.println(query);
        try {
            statement.executeUpdate(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }

    public void deleteCar(String modelNo) {
        String query = "DELETE FROM cars where modelNo = '" + modelNo + "'";
        System.out.println(query);
        try {
            statement.executeUpdate(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }

    public void deleteRoom(int roomNo) {
        String query = "DELETE FROM rooms where roomNo = " + roomNo;
        System.out.println(query);
        try {
            statement.executeUpdate(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
        }
    }
}
