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
    private static Connection conn;
    
    // Veri tabanina baglanti olusturan fonksiyon
    public static void connectDB(){
        try {
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Tum dersleri veri tabanindan ceken ve ara yuzdeki ders tablosuna ekleyen fonksiyon
    public static void displayAllCrafts(JTable table) {
        String checkSession;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        try {
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
                double weekdayFee = resultSet.getInt("weekdayFee");
                
                model.addRow(new Object[]{instructorID, name + ' ' + surname, email, mobilePhone, homePhone, address, weekdayFee});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Öğretmenler getirilirken bir hata oluştu!");
        }
    }
    
    // Ogretmen kaydini veri tabanına ekleyen fonksiyon
    public static void registerInstructor(String name, String surname, String email, String mobilePhone, 
            String homePhone, String address, double weekdayFee) {
        if (name.isBlank() || surname.isBlank() || email.isBlank() || mobilePhone.isBlank() || homePhone.isBlank() || address.isBlank()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm bilgileri giriniz!");
            return;
        }
        
        try {
            String insertQuery = "INSERT INTO Instructor (name, surname, email, mobilePhone, homePhone, address, weekdayFee) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            
            insertStatement.setString(1, name);
            insertStatement.setString(2, surname);
            insertStatement.setString(3, email);
            insertStatement.setString(4, mobilePhone);
            insertStatement.setString(5, homePhone);
            insertStatement.setString(6, address);
            insertStatement.setDouble(7, weekdayFee);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Kayıt başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ara yuzde guncellenen ogretmen bilgilerini veri tabaninda guncelleyen fonksiyon
    public static void updateInstructor(int instructorID, String mobilePhone, String homePhone, String address, double weekdayFee) {
        try {
            String updateQuery = "UPDATE Instructor SET mobilePhone = ?, homePhone = ?, address = ?, weekdayFee = ? where instructorID = ?";
            PreparedStatement insertStatement = conn.prepareStatement(updateQuery);
            
            insertStatement.setString(1, mobilePhone);
            insertStatement.setString(2, homePhone);
            insertStatement.setString(3, address);
            insertStatement.setDouble(4, weekdayFee);
            insertStatement.setInt(5, instructorID);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Öğretmen güncelleme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ara yuzde silinen ogretmen bilgilerini veri tabanindan silen fonksiyon
    public static void deleteInstructor(int instructorID) {
        try {
            String deleteWorkingHourQuery = "DELETE FROM WorkingHour WHERE instructorID = ?";
            PreparedStatement deleteWorkingHourStatement = conn.prepareStatement(deleteWorkingHourQuery);
            deleteWorkingHourStatement.setInt(1, instructorID);
            deleteWorkingHourStatement.executeUpdate();
            
            String deleteInstructorQuery = "DELETE FROM Instructor where instructorID = ?";
            PreparedStatement deleteInstructorStatement = conn.prepareStatement(deleteInstructorQuery);
            deleteInstructorStatement.setInt(1, instructorID);
            deleteInstructorStatement.executeUpdate();
            
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
            String deleteQuery = "DELETE FROM Student where studentID = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
            
            deleteStatement.setInt(1, studentID);
            deleteStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Öğrenci silme başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Tum calisma saatlerini veri tabanindan ceken ve ara yuzdeki tabloya ekleyen fonksiyon
    public static void displayAllWorkingHours(JTable table, int instructorID) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        String[] daysOfWeek = {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"};
        
        try {
            String query = "SELECT * FROM WorkingHour WHERE instructorID = ? ORDER BY workingHourID";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, instructorID);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Integer dayIndex = resultSet.getInt("day") - 1;
                String day = daysOfWeek[dayIndex];

                Integer startHour = resultSet.getInt("startHour");
                Integer endHour = startHour + 1;
                
                String timeSlot = startHour + ":00 - " + endHour + ":00";
                
                model.addRow(new Object[]{day, timeSlot});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Çalışma saatleri getirilirken bir hata oluştu!");
        }
    }
    
    // Calisma saati kaydini veri tabanina ekleyen fonksiyon
    public static void addWorkingHour(int instructorID, int day, int startHour){
        if (day < 1 || day > 7 || startHour < 0 || startHour > 23) {
            JOptionPane.showMessageDialog(null, "Lütfen gün (1-7) ve saat (0-23) bilgilerini uygun şekilde giriniz!");
            return;
        }
        
        try {
            String insertQuery = "INSERT INTO WorkingHour (instructorID, day, startHour, isBusy) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            
            insertStatement.setInt(1, instructorID);
            insertStatement.setInt(2, day);
            insertStatement.setInt(3, startHour);
            insertStatement.setBoolean(4, false);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Kayıt başarılı!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
