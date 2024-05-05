package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DatabaseHelper {
    private static final String dbUrl = "jdbc:postgresql://localhost/postgres";
    private static final String dbUsername = "postgres";
    private static final String dbPassword = "mudafer69";
    
    // Tum dersleri veri tabanindan ceken ve ara yuzdeki ders tablosuna ekleyen fonksiyon
    public static void displayAllCrafts(JTable table) {
        String checkSession;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String query = "SELECT * FROM Craft ORDER BY craftID";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int craftID = resultSet.getInt("craftID");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                boolean isWeekday = resultSet.getBoolean("isWeekday");
                double fee = resultSet.getDouble("craftFee");
                
                if (isWeekday) {
                    checkSession = "Hafta içi";
                } else {
                    checkSession = "Hafta sonu";
                }
                
                model.addRow(new Object[]{craftID, name, description, checkSession, fee});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Dersler getirilirken bir hata oluştu!");
        }
    }
    
    // Ders bilgilerini veri tabanina ekleyen fonksiyon
    public static void addCraft(String name, String description, boolean isWeekday, double fee) {
        if (name.isBlank() || description.isBlank() || Double.isNaN(fee)) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm bilgileri giriniz!");
            return;
        }
        
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String insertQuery = "INSERT INTO Craft (name, description, isWeekday, craftFee) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            
            insertStatement.setString(1, name);
            insertStatement.setString(2, description);
            insertStatement.setBoolean(3, isWeekday);
            insertStatement.setDouble(4, fee);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ders ekleme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ara yuzde guncellenen ders bilgilerini veri tabaninda guncelleyen fonksiyon
    public static void updateCraft(int craftID, boolean isWeekday, double fee) {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String updateQuery = "UPDATE Craft SET isWeekday = ?, craftFee = ? where craftID = ?";
            PreparedStatement insertStatement = conn.prepareStatement(updateQuery);
            
            insertStatement.setBoolean(1, isWeekday);
            insertStatement.setDouble(2, fee);
            insertStatement.setInt(3, craftID);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ders güncelleme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ara yuzde silinen ders bilgilerini veri tabanindan silen fonksiyon
    public static void deleteCraft(int craftID) {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String deleteQuery = "DELETE FROM Craft where craftID = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
            
            deleteStatement.setInt(1, craftID);
            deleteStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ders silme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Tum ogretmenleri veri tabanindan ceken ve arayuzdeki ogretmen tablosuna ekleyen fonksiyon
    public static void displayAllInstructors(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String query = "SELECT * FROM Instructor ORDER BY instructorID";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int instructorID = resultSet.getInt("instructorID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                String mobilePhone = resultSet.getString("mobilePhone");
                String homePhone = resultSet.getString("homePhone");
                String address = resultSet.getString("address");
                
                model.addRow(new Object[]{instructorID, name + ' ' + surname, email, mobilePhone, homePhone, address});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Öğretmenler getirilirken bir hata oluştu!");
        }
    }
    
    // Ogretmen kaydini veri tabanına ekleyen fonksiyon
    public static void registerInstructor(String name, String surname, String email, String mobilePhone, String homePhone, String address) {
        if (name.isBlank() || surname.isBlank() || email.isBlank() || mobilePhone.isBlank() || homePhone.isBlank() || address.isBlank()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm bilgileri giriniz!");
            return;
        }
        
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String insertQuery = "INSERT INTO Instructor (name, surname, email, mobilePhone, homePhone, address) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            
            insertStatement.setString(1, name);
            insertStatement.setString(2, surname);
            insertStatement.setString(3, email);
            insertStatement.setString(4, mobilePhone);
            insertStatement.setString(5, homePhone);
            insertStatement.setString(6, address);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Kayıt başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ara yuzde guncellenen ogretmen bilgilerini veri tabaninda guncelleyen fonksiyon
    public static void updateInstructor(int instructorID, String mobilePhone, String homePhone, String address) {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String updateQuery = "UPDATE Instructor SET mobilePhone = ?, homePhone = ?, address = ? where instructorID = ?";
            PreparedStatement insertStatement = conn.prepareStatement(updateQuery);
            
            insertStatement.setString(1, mobilePhone);
            insertStatement.setString(2, homePhone);
            insertStatement.setString(3, address);
            insertStatement.setInt(4, instructorID);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Öğretmen güncelleme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ara yuzde silinen ogretmen bilgilerini veri tabanindan silen fonksiyon
    public static void deleteInstructor(int instructorID) {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String deleteQuery = "DELETE FROM Instructor where instructorID = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
            
            deleteStatement.setInt(1, instructorID);
            deleteStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Öğretmen silme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Tum ogrencileri veri tabanindan ceken ve ara yuzdeki ogrenci tablosuna ekleyen fonksiyon
    public static void displayAllStudents(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String query = "SELECT * FROM Student ORDER BY studentID";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int studentID = resultSet.getInt("studentID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                String mobilePhone = resultSet.getString("mobilePhone");
                String homePhone = resultSet.getString("homePhone");
                String address = resultSet.getString("address");
                
                model.addRow(new Object[]{studentID, name + ' ' + surname, email, mobilePhone, homePhone, address});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Öğrenciler getirilirken bir hata oluştu!");
        }
    }
    
    // Ogrenci kaydini veri tabanina ekleyen fonksiyon
    public static void registerStudent(String name, String surname, String email, String mobilePhone, String homePhone, String address) {
        if (name.isBlank() || surname.isBlank() || email.isBlank() || mobilePhone.isBlank() || homePhone.isBlank() || address.isBlank()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm bilgileri giriniz!");
            return;
        }
        
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String insertQuery = "INSERT INTO Student (name, surname, email, mobilePhone, homePhone, address) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            
            insertStatement.setString(1, name);
            insertStatement.setString(2, surname);
            insertStatement.setString(3, email);
            insertStatement.setString(4, mobilePhone);
            insertStatement.setString(5, homePhone);
            insertStatement.setString(6, address);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Kayıt başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ara yuzde guncellenen ogrenci bilgilerini veri tabaninda guncelleyen fonksiyon
    public static void updateStudent(int studentID, String mobilePhone, String homePhone, String address) {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String updateQuery = "UPDATE Student SET mobilePhone = ?, homePhone = ?, address = ? where studentID = ?";
            PreparedStatement insertStatement = conn.prepareStatement(updateQuery);
            
            insertStatement.setString(1, mobilePhone);
            insertStatement.setString(2, homePhone);
            insertStatement.setString(3, address);
            insertStatement.setInt(4, studentID);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Öğrenci güncelleme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ara yuzde silinen ogrenci bilgilerini veri tabanindan silen fonksiyon
    public static void deleteStudent(int studentID) {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String deleteQuery = "DELETE FROM Student where studentID = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
            
            deleteStatement.setInt(1, studentID);
            deleteStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Öğrenci silme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
