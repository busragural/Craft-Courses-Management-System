package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DatabaseHelper {
    private static final String dbUrl = "jdbc:postgresql://localhost/postgres";
    private static final String dbUsername = "postgres";
    private static final String dbPassword = "-0admindb0-";
    public static Connection conn;
    
    // Veritabanina baglanti olusturan fonksiyon
    public static Connection connectDB() {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    // Tum dersleri veritabanindan ceken fonksiyon
    public static ResultSet selectAllCrafts() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM Craft ORDER BY craftID";
            PreparedStatement statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Dersler getirilirken bir hata olustu!");
        }
        return resultSet;
    }
    
    // Bir ogretmenin verdigi tum dersleri veritabanindan ceken fonksiyon
    public static ResultSet selectAllCraftsOfInstructor(int instructorID) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT t.craftID, c.name " +
                           "FROM Teach t " +
                           "INNER JOIN Craft c ON t.craftID = c.craftID " +
                           "WHERE t.instructorID = ? " +
                           "ORDER BY t.craftID";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, instructorID);
            resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Dersler getirilirken bir hata olustu!");
        }
        return resultSet;
    }
    
    // Gunlere bagli olarak tum dersleri veritabanindan ceken fonksiyon
    public static ResultSet selectAllCraftsDependingDays(boolean isWeekDay) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM Craft WHERE isWeekday = ? ORDER BY craftID";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setBoolean(1, isWeekDay);
            resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Dersler getirilirken bir hata olustu!");
        }
        return resultSet;
    }
    
    // Ders bilgilerini veritabanina ekleyen fonksiyon
    public static void addCraft(String name, String description, boolean isWeekday, double fee) {
        if (name.isBlank() || description.isBlank() || Double.isNaN(fee)) {
            JOptionPane.showMessageDialog(null, "Lutfen tum bilgileri giriniz!");
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
            
            JOptionPane.showMessageDialog(null, "Ders ekleme basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Arayuzde guncellenen ders bilgilerini veritabaninda guncelleyen fonksiyon
    public static void updateCraft(int craftID, boolean isWeekday, double fee) {
        try {
            String updateQuery = "UPDATE Craft SET isWeekday = ?, craftFee = ? where craftID = ?";
            PreparedStatement insertStatement = conn.prepareStatement(updateQuery);
            
            insertStatement.setBoolean(1, isWeekday);
            insertStatement.setDouble(2, fee);
            insertStatement.setInt(3, craftID);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ders guncelleme basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Arayuzde silinen ders bilgilerini veritabanindan silen fonksiyon
    public static void deleteCraft(int craftID) {
        try {
            String deleteQuery = "DELETE FROM Craft where craftID = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
            
            deleteStatement.setInt(1, craftID);
            deleteStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ders silme basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Tum ogretmenleri veritabanindan ceken ve arayuzdeki ogretmen tablosuna ekleyen fonksiyon
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
            JOptionPane.showMessageDialog(null, "Ogretmenler getirilirken bir hata olustu!");
        }
    }
    
    // Ogretmen kaydini veritabanina ekleyen fonksiyon
    public static void registerInstructor(String name, String surname, String email, String mobilePhone, 
            String homePhone, String address, double weekdayFee) {
        if (name.isBlank() || surname.isBlank() || email.isBlank() || mobilePhone.isBlank() || homePhone.isBlank() || address.isBlank()) {
            JOptionPane.showMessageDialog(null, "Lutfen tum bilgileri giriniz!");
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
            
            JOptionPane.showMessageDialog(null, "Kayit basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Arayuzde guncellenen ogretmen bilgilerini veritabaninda guncelleyen fonksiyon
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
            
            JOptionPane.showMessageDialog(null, "Ogretmen guncelleme basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Arayuzde silinen ogretmen bilgilerini veritabanindan silen fonksiyon
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
            
            JOptionPane.showMessageDialog(null, "Ogretmen silme basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ogretmenin verebildigi dersleri veritabanina ekleyen fonksiyon
    public static void addCraftsForInstructor(int instructorID, List<Integer> craftID) {
        try {
            for (Integer tmpID : craftID) {
                String checkQuery = "SELECT COUNT(*) FROM Teach WHERE instructorID = ? AND craftID = ?";
                PreparedStatement checkStatement = conn.prepareStatement(checkQuery);
                checkStatement.setInt(1, instructorID);
                checkStatement.setInt(2, tmpID);
                ResultSet resultSet = checkStatement.executeQuery();
                resultSet.next();

                int count = resultSet.getInt(1);
                if (count == 0) {
                    String insertQuery = "INSERT INTO Teach (instructorID, craftID) VALUES (?, ?)";
                    PreparedStatement insertStatement = conn.prepareStatement(insertQuery);

                    insertStatement.setInt(1, instructorID);
                    insertStatement.setInt(2, tmpID);
                    insertStatement.executeUpdate();
                } else {
                    JOptionPane.showMessageDialog(null, "Ayni ders bir daha eklenemez!");
                    return;
                }
            }
            
            JOptionPane.showMessageDialog(null, "Ilgili ogretmen icin ders ekleme basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Tum calisma saatlerini veritabanindan ceken ve arayuzdeki tabloya ekleyen fonksiyon
    public static void displayAllWorkingHours(JTable table, int instructorID) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        String[] daysOfWeek = {"Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar"};
        
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
            JOptionPane.showMessageDialog(null, "Calisma saatleri getirilirken bir hata olustu!");
        }
    }
    
    // Calisma saati kaydini veritabanina ekleyen fonksiyon
    public static void addWorkingHourForInstructor(int instructorID, int day, int startHour) {
        if (day < 1 || day > 7 || startHour < 0 || startHour > 23) {
            JOptionPane.showMessageDialog(null, "Lutfen gun (1-7) ve saat (0-23) bilgilerini uygun sekilde giriniz!");
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
            
            JOptionPane.showMessageDialog(null, "Kayit basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    // Tum ogrencileri veritabanindan ceken ve arayuzdeki ogrenci tablosuna ekleyen fonksiyon
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
            JOptionPane.showMessageDialog(null, "Ogrenciler getirilirken bir hata olustu!");
        }
    }
    
    // Ogrenci kaydini veritabanina ekleyen fonksiyon
    public static void registerStudent(String name, String surname, String email, String mobilePhone, String homePhone, String address) {
        if (name.isBlank() || surname.isBlank() || email.isBlank() || mobilePhone.isBlank() || homePhone.isBlank() || address.isBlank()) {
            JOptionPane.showMessageDialog(null, "Lutfen tum bilgileri giriniz!");
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
            
            JOptionPane.showMessageDialog(null, "Kayit basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Arayuzde guncellenen ogrenci bilgilerini veritabaninda guncelleyen fonksiyon
    public static void updateStudent(int studentID, String mobilePhone, String homePhone, String address) {
        try {
            String updateQuery = "UPDATE Student SET mobilePhone = ?, homePhone = ?, address = ? where studentID = ?";
            PreparedStatement insertStatement = conn.prepareStatement(updateQuery);
            
            insertStatement.setString(1, mobilePhone);
            insertStatement.setString(2, homePhone);
            insertStatement.setString(3, address);
            insertStatement.setInt(4, studentID);
            insertStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ogrenci guncelleme basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Arayuzde silinen ogrenci bilgilerini veritabanindan silen fonksiyon
    public static void deleteStudent(int studentID) {
        try {
            String deleteQuery = "DELETE FROM Student where studentID = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
            
            deleteStatement.setInt(1, studentID);
            deleteStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ogrenci silme basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Istenen zaman bilgisine ait tum dersleri veritabanindan ceken fonksiyon
    public static ResultSet selectCraftsForCourseCreation(boolean isWeekday) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT craftID, name " +
                           "FROM Craft " +
                           "WHERE isWeekday = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setBoolean(1, isWeekday);
            resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Dersler getirilirken bir hata olustu!");
        }
        return resultSet;
    }
    
    // Kurs olusturma islemi icin secilen dersi verebilen ogretmenleri veritabanindan ceken fonksiyon
    public static ResultSet selectInstructorsForCourseCreation(int craftID, boolean isWeekday) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT t.instructorID, i.name, i.surname, wh.day, wh.startHour, wh.workingHourID " +
                           "FROM Teach t " +
                           "JOIN WorkingHour wh ON t.instructorID = wh.instructorID " +
                           "JOIN Instructor i ON t.instructorID = i.instructorID " +
                           "WHERE t.craftID = ? " +
                           "AND " + (isWeekday ? "wh.day <= 5" : "wh.day > 5");
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, craftID);
            resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
    
    // Kurs bilgilerini veritabanina ekleyen ve olusturulan kursun ID'sini donduren fonksiyon
    public static int insertCourse(Date startDate, Date endDate, boolean isWeekday, double fee) {
        int id = -1;
        try {
            String insertQuery = "INSERT INTO Course (startDate, endDate, isWeekday, courseFee) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            
            insertStatement.setDate(1, startDate);
            insertStatement.setDate(2, endDate);
            insertStatement.setBoolean(3, isWeekday);
            insertStatement.setDouble(4, fee);
            int affectedRows = insertStatement.executeUpdate();
            
            if (affectedRows > 0) {
                ResultSet generatedKeys = insertStatement.getGeneratedKeys();
                
                JOptionPane.showMessageDialog(null, "Kurs ekleme basarili!");

                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1); 
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    // Bolum bilgilerini veritabanina ekleyen fonksiyon
    public static void insertSection(int instructorID, int workingHourID, int craftID, int courseID) {
        try {
            String insertQuery = "INSERT INTO Section (instructorID, workingHourID, craftID, courseID) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            
            insertStatement.setInt(1, instructorID);
            insertStatement.setInt(2, workingHourID);
            insertStatement.setInt(3, craftID);
            insertStatement.setInt(4, courseID);
            insertStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Ogrencinin kayitli oldugu guncel kurslari arayuzdeki tabloya ekleyen fonksiyon
    public static void DisplayCurrentCourses(int studentID, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try {
            String query = "SELECT r.date, r.registrationFee, r.courseID, string_agg(cr.name, ', ') AS courses " +
                           "FROM Registration r " +
                           "JOIN Course c ON r.courseID = c.courseID " +
                           "JOIN Section s ON c.courseID = s.courseID " +
                           "JOIN Craft cr ON s.craftID = cr.craftID " +
                           "WHERE r.studentID = ? AND r.isActive = true " +
                           "GROUP BY r.date, r.registrationFee, r.courseID";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, studentID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Date registrationDate = resultSet.getDate("date");
                double registrationFee = resultSet.getDouble("registrationFee");
                int courseID = resultSet.getInt("courseID");
                String courses = resultSet.getString("courses");
                
                Object[] row = { courseID, courses, registrationDate, registrationFee };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Ogrencinin kayitli oldugu gecmis kurslari arayuzdeki tabloya ekleyen fonksiyon
    public static void DisplayPastCourses(int studentID, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try {
            String query = "SELECT r.date, r.registrationFee, r.courseID, string_agg(cr.name, ', ') AS courses " +
                           "FROM Registration r " +
                           "JOIN Course c ON r.courseID = c.courseID " +
                           "JOIN Section s ON c.courseID = s.courseID " +
                           "JOIN Craft cr ON s.craftID = cr.craftID " +
                           "WHERE r.studentID = ? AND r.isActive = false " +
                           "GROUP BY r.date, r.registrationFee, r.courseID";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, studentID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Date registrationDate = resultSet.getDate("date");
                double registrationFee = resultSet.getDouble("registrationFee");
                int courseID = resultSet.getInt("courseID");
                String courses = resultSet.getString("courses");

                Object[] row = { courseID, courses, registrationDate, registrationFee };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Verilen e-posta adresine gore ogrencinin ad ve soyadini donduren fonksiyon
    public static String getStudentNameandSurname(String mail) {
        String fullName = "";
        try {
            String query = "SELECT name, surname FROM Student WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, mail);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String name = result.getString("name");
                String surname = result.getString("surname");
                fullName = name + " " + surname;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fullName;
    }
    
    // Verilen kurs ID'sine gore ilgili dersleri donduren fonksiyon
    public static String getCraftsByCourseID(int ID) {
        String crafts = "";
        
        String sql = "SELECT c.name " +
                     "FROM Craft c " +
                     "INNER JOIN Section s ON c.craftID = s.craftID " +
                     "WHERE s.courseID = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ID);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                crafts += resultSet.getString("name") + ", ";
            }
            
            if (!crafts.isEmpty()) {
                crafts = crafts.substring(0, crafts.length() - 2);
            }
            
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return crafts;
    }
    
    // Ucret ve Craft ID'lerine gore filtrelenen kurslari arayuzdeki tabloya ekleyen fonksiyon
    public static void displayFilteredCourses(JTable table, double fee, List<Integer> IDs) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT co.courseID, co.startDate, co.endDate, co.courseFee ");
            sql.append("FROM Course co ");
            sql.append("INNER JOIN Section s ON s.courseID = co.courseID ");
            sql.append("INNER JOIN Craft c ON c.craftID = s.craftID ");
            sql.append("WHERE EXISTS (SELECT 1 FROM Section s2 WHERE s2.courseID = co.courseID ");
            sql.append("AND s2.craftID IN (");
            for (int i = 0; i < IDs.size(); i++) {
                if (i != 0) sql.append(",");
                sql.append("?");
            }
            sql.append(") GROUP BY s2.courseID HAVING COUNT(DISTINCT s2.craftID) = ?) ");
            sql.append("AND co.courseFee <= ?");

            stmt = conn.prepareStatement(sql.toString());
            int parameterIndex = 1;
            for (int craftID : IDs) {
                stmt.setInt(parameterIndex++, craftID);
            }
            stmt.setInt(parameterIndex++, IDs.size());
            stmt.setDouble(parameterIndex, fee);
            rs = stmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("courseID"),
                    getCraftsByCourseID(rs.getInt("courseID")),
                    rs.getDate("startDate"),
                    rs.getDate("endDate"),
                    rs.getDouble("courseFee")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Verilen e-posta adresine gore ogrenci ID'sini donduren fonksiyon
    public static Integer getStudentID(String mail) {
        Integer ID = 0;
        try {
            String query = "SELECT studentID FROM Student WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, mail);
            ResultSet result = statement.executeQuery();
            result.next();
            ID = result.getInt("studentID");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID;
    }
    
    // Kurs kaydini veritabanina ekleyen fonksiyon
    public static void addRegistration(int ID, boolean isCash, String mail, double fee) throws SQLException {
        Integer studentID = getStudentID(mail);
        LocalDate currentDate = LocalDate.now();
        String sql = "INSERT INTO Registration (studentID, courseID, date, registrationFee, isActive, isCash) VALUES (?, ?, ?, ?, true, ?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, studentID);
        stmt.setInt(2, ID);
        stmt.setDate(3, java.sql.Date.valueOf(currentDate));
        stmt.setDouble(4, fee);
        stmt.setBoolean(5, isCash);
        stmt.executeUpdate();
    }
    
    // Verilen dersin hafta ici olup olmadigini kontrol eden fonksiyon
    public static boolean checkIfItsCompatible(String craftName) throws SQLException {
        boolean isWeekDay = false;
        String sql = "SELECT isWeekday FROM Craft WHERE name = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql); 
        stmt.setString(1, craftName);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            isWeekDay = rs.getBoolean("isWeekday");
        }
        return isWeekDay;
    }
    
    // Tum kurslari veritabanindan ceken ve arayuzdeki tabloya ekleyen fonksiyon
    public static void displayAllCourses(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int counter = 0;
        try {
            String query = "SELECT c.courseID, string_agg(cr.name, ', ') AS courses, c.startDate AS date, c.courseFee " +
                           "FROM Course c " +
                           "JOIN Section s ON c.courseID = s.courseID " +
                           "JOIN Craft cr ON s.craftID = cr.craftID " +
                           "GROUP BY c.courseID, c.startDate, c.courseFee";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int courseID = resultSet.getInt("courseID");
                String courses = resultSet.getString("courses");
                Date startDate = resultSet.getDate("date");
                double courseFee = resultSet.getDouble("courseFee");
                counter++;
                Object[] row = { courseID, courses, startDate, courseFee };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Verilen kurs ID'sine gore bolum bilgilerini temizleyen fonksiyon
    public static void clearSectionsByCourseID(int courseID) throws SQLException {
        String sql = "DELETE FROM Section WHERE courseID = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Verilen kurs ID'sine gore kayit bilgilerini temizleyen fonksiyon
    public static void clearRegistrationsByCourseID(int courseID) throws SQLException {
        String sql = "DELETE FROM Registration WHERE courseID = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Verilen kurs ID'sine gore kursu silen fonksiyon
    public static void deleteCourse(int courseID) {
        try {
            clearSectionsByCourseID(courseID);
            clearRegistrationsByCourseID(courseID);
            String deleteQuery = "DELETE FROM course where courseID = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
            
            deleteStatement.setInt(1, courseID);
            deleteStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Kurs silme basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
