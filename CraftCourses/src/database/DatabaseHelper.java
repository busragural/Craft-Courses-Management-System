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
    
    // Tum dersleri veri tabanindan ceken ve ders tablosuna ekleyen fonksiyon
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
    
    // Guncellenen ders bilgilerini veri tabaninda da guncelleyen fonksiyon
    public static void updateCraft(int id, boolean isWeekday, double fee) {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String updateQuery = "UPDATE Craft SET isWeekday = ?, craftFee = ? where craftID = ?";
            PreparedStatement insertStatement = conn.prepareStatement(updateQuery);
            
            insertStatement.setBoolean(1, isWeekday);
            insertStatement.setDouble(2, fee);
            insertStatement.setInt(3, id);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ders güncelleme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Silinen ders bilgilerini veri tabaninda da silen fonksiyon
    public static void deleteCraft(int id) {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String deleteQuery = "DELETE FROM Craft where craftID = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
            
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ders silme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
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
}
