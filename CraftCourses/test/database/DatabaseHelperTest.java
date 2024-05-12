package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseHelperTest {
    private static final String dbUrl = "jdbc:postgresql://localhost/postgres";
    private static final String dbUsername = "postgres";
    private static final String dbPassword = "mudafer69";
    private static Connection conn;
    
    @BeforeClass
    public static void setUp() throws SQLException {
        conn = DatabaseHelper.connectDB();
        clearDatabase();
        insertTestData();
    }
    
    @AfterClass
    public static void tearDown(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            fail("Bağlantı kapatılırken hata oluştu: " + ex.getMessage());
        }
    }

    public static void clearDatabase() throws SQLException {
        String[] tables = {"teach", "section", "registration", "course", "student", "workingHour", "instructor", "craft"};
        
        for (String table : tables) {
            String query = "TRUNCATE TABLE " + table + " RESTART IDENTITY CASCADE;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.executeUpdate();
        }
    }
    
    public static void insertTestData() throws SQLException{
        String sql = "INSERT INTO Instructor(name, surname, email, mobilePhone, homePhone, address, weekdayFee) " +
                     "VALUES ('John', 'Doe', 'john.doe@example.com', '1234567890', '9876543210', '123 Street, City', 50.00);" +
                     "INSERT INTO Student(name, surname, email, mobilePhone, homePhone, address) " +
                     "VALUES ('Jane', 'Doe', 'jane.doe@example.com', '0987654321', '5678901234', '456 Avenue, Town');" +
                     "INSERT INTO Craft(name, description, isWeekday, craftFee) " +
                     "VALUES ('Coding', 'Learn coding skills', true, 100.00);" +
                     "INSERT INTO Course(startDate, endDate, isWeekday, courseFee) " +
                     "VALUES ('2024-06-01', '2024-07-01', true, 500.00);";
                     
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        
        sql =   "INSERT INTO WorkingHour(instructorID, day, startHour, isBusy) " +
                "VALUES (1, 1, 9, false);";
        
        statement = conn.prepareStatement(sql);
        statement.execute();
        
        sql =   "INSERT INTO Section(instructorID, workingHourID, craftID, courseID) " +
                "VALUES (1, 1, 1, 1);" +
                "INSERT INTO Registration(studentID, courseID, date, registrationFee, isActive, isCash)"  +
                "VALUES (1, 1, '2024-05-12', 100.00, true, true);" + 
                "INSERT INTO Teach(instructorID, craftID) " +
                "VALUES (1, 1);";
                
        
        statement = conn.prepareStatement(sql);
        statement.execute();
        
    }
   
    
    @Test
    public void testConnectDB() {
        assertNotNull("Database connection is not established.", conn);
    }

    
    @Test
    public void testSelectAllCrafts() throws SQLException {
        ResultSet resultSet = DatabaseHelper.selectAllCrafts();
        resultSet.next();
        assertEquals(1, resultSet.getInt("craftID")) ;
        assertEquals("Coding", resultSet.getString("name")) ;
        assertEquals("Learn coding skills", resultSet.getString("description")) ;
        assertEquals(true, resultSet.getBoolean("isWeekday")) ;
        assertEquals(100.00, resultSet.getDouble("craftFee"), 0.01) ;
    }
    
    @Test
    public void testAddCraft() throws SQLException {
        String name = "Java Programming";
        String description = "Learn Java programming skills";
        boolean isWeekday = true;
        double fee = 150.0;

        DatabaseHelper.addCraft(name, description, isWeekday, fee);

        assertTrue(checkCraftExists(name, description, isWeekday, fee));
    }
    
    private boolean checkCraftExists(String name, String description, boolean isWeekday, double fee) throws SQLException {
        String query = "SELECT COUNT(*) FROM Craft WHERE name = ? AND description = ? AND isWeekday = ? AND craftFee = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setBoolean(3, isWeekday);
        statement.setDouble(4, fee);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count == 1; // Ders varsa true, yoksa false
        }
        return false;
    }
    
    private boolean checkCraftExists(int craftID) throws SQLException {
        String query = "SELECT COUNT(*) FROM Craft WHERE craftID = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setInt(1, craftID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count == 1;
        }
        return false;
    }
    
    @Test
    public void testUpdateCraft() throws SQLException {
        int craftID = 1;
        boolean newIsWeekday = false;
        double newFee = 200.0;
        
        DatabaseHelper.updateCraft(craftID, newIsWeekday, newFee);
        
        assertTrue(checkCraftUpdated(craftID, newIsWeekday, newFee));
    }

    private boolean checkCraftUpdated(int craftID, boolean isWeekday, double fee) throws SQLException {
        String query = "SELECT isWeekday, craftFee FROM Craft WHERE craftID = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setInt(1, craftID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            boolean updatedIsWeekday = resultSet.getBoolean("isWeekday");
            double updatedFee = resultSet.getDouble("craftFee");
            return updatedIsWeekday == isWeekday && updatedFee == fee; 
        }
        return false;
    }
    
     @Test
    public void testDeleteCraft() throws SQLException {
        int craftID = 2;
        DatabaseHelper.deleteCraft(craftID);

        assertFalse(checkCraftExists(craftID));
    }

    @Test
    public void testRegisterInstructor() throws SQLException {
        // Test verileri
         String name = "Michael";
        String surname = "Scott";
        String email = "michael.scott@example.com";
        String mobilePhone = "5551234567";
        String homePhone = "5559876543";
        String address = "123 Office Ave, Scranton";
        double weekdayFee = 75.0;

        DatabaseHelper.registerInstructor(name, surname, email, mobilePhone, homePhone, address, weekdayFee);

        assertTrue(checkInstructorExists(name, surname, mobilePhone));
    }

    private boolean checkInstructorExists(String name, String surname, String mobilePhone) throws SQLException {
        String query = "SELECT COUNT(*) FROM Instructor WHERE name = ? AND surname = ? AND mobilePhone = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setString(3, mobilePhone);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count == 1;
        }
        return false;
    }
    
    @Test
    public void testUpdateInstructor() throws SQLException {
        int instructorID = 1;
        String newMobilePhone = "5551112222";
        String newHomePhone = "5553334444";
        String newAddress = "456 Business St, Scranton";
        double newWeekdayFee = 100.0;

        DatabaseHelper.updateInstructor(instructorID, newMobilePhone, newHomePhone, newAddress, newWeekdayFee);

        assertTrue(checkInstructorUpdated(instructorID, newMobilePhone, newHomePhone, newAddress, newWeekdayFee));
    }

    private boolean checkInstructorUpdated(int instructorID, String mobilePhone, String homePhone, String address, double weekdayFee) throws SQLException {
        String query = "SELECT mobilePhone, homePhone, address, weekdayFee FROM Instructor WHERE instructorID = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setInt(1, instructorID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String updatedMobilePhone = resultSet.getString("mobilePhone");
            String updatedHomePhone = resultSet.getString("homePhone");
            String updatedAddress = resultSet.getString("address");
            double updatedWeekdayFee = resultSet.getDouble("weekdayFee");
            return updatedMobilePhone.equals(mobilePhone) && updatedHomePhone.equals(homePhone) && updatedAddress.equals(address) && updatedWeekdayFee == weekdayFee; 
        }
        return false;
    }
    
    @Test
    public void testDeleteInstructor() throws SQLException {
        int instructorID = getInstructorIDByName("Michael", "Scott");

        DatabaseHelper.deleteInstructor(instructorID);

        assertFalse(checkInstructorExists(instructorID));
    }

    private boolean checkInstructorExists(int instructorID) throws SQLException {
        String query = "SELECT COUNT(*) FROM Instructor WHERE instructorID = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setInt(1, instructorID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count == 1; 
        }
        return false;
    }

    private int getInstructorIDByName(String name, String surname) throws SQLException {
        String query = "SELECT instructorID FROM Instructor WHERE name = ? AND surname = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, surname);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("instructorID");
        }
        return -1;
    }
    @Test
    public void testAddCraftsForInstructor() throws SQLException {
        int instructorID = 1; 
        List<Integer> craftIDs = Arrays.asList(1);

        DatabaseHelper.addCraftsForInstructor(instructorID, craftIDs);

        assertTrue(checkCraftsAddedForInstructor(instructorID, craftIDs)); 
    }

    private boolean checkCraftsAddedForInstructor(int instructorID, List<Integer> craftIDs) throws SQLException {
        for (Integer craftID : craftIDs) {
            String query = "SELECT COUNT(*) FROM Teach WHERE instructorID = ? AND craftID = ?";
            PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
            statement.setInt(1, instructorID);
            statement.setInt(2, craftID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count != 1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true; 
    }
   
    @Test
    public void testAddWorkingHourForInstructor() throws SQLException {
        int instructorID = 1; 
        int day = 2; 
        int startHour = 9; 

        DatabaseHelper.addWorkingHourForInstructor(instructorID, day, startHour);

        assertTrue(checkWorkingHourAdded(instructorID, day, startHour)); 
    }

    private boolean checkWorkingHourAdded(int instructorID, int day, int startHour) throws SQLException {
        String query = "SELECT COUNT(*) FROM WorkingHour WHERE instructorID = ? AND day = ? AND startHour = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setInt(1, instructorID);
        statement.setInt(2, day);
        statement.setInt(3, startHour);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count == 1;
        }
        return false;
    }
    
    @Test
    public void testRegisterStudent() throws SQLException {
        String name = "Ahmet";
        String surname = "Yılmaz";
        String email = "ahmet.yilmaz@example.com";
        String mobilePhone = "5551234567";
        String homePhone = "5559876543";
        String address = "123 Avenue, City";

        DatabaseHelper.registerStudent(name, surname, email, mobilePhone, homePhone, address);

        assertTrue(checkStudentRegistered(name, surname, email, mobilePhone, homePhone, address)); // Öğrenci başarıyla kaydedilmiş olmalı
    }

    private boolean checkStudentRegistered(String name, String surname, String email, String mobilePhone, String homePhone, String address) throws SQLException {
        String query = "SELECT COUNT(*) FROM Student WHERE name = ? AND surname = ? AND email = ? AND mobilePhone = ? AND homePhone = ? AND address = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setString(3, email);
        statement.setString(4, mobilePhone);
        statement.setString(5, homePhone);
        statement.setString(6, address);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count == 1;
        }
        return false;
    }
    
    @Test
    public void testUpdateStudent() throws SQLException {
        int studentID = 1; 
        String mobilePhone = "5555555555"; 
        String homePhone = "5554443333";
        String address = "456 Street, Town"; 

        DatabaseHelper.updateStudent(studentID, mobilePhone, homePhone, address);

        assertTrue(checkStudentUpdated(studentID, mobilePhone, homePhone, address)); // Öğrenci bilgileri başarıyla güncellenmiş olmalı
    }

    private boolean checkStudentUpdated(int studentID, String mobilePhone, String homePhone, String address) throws SQLException {
        String query = "SELECT * FROM Student WHERE studentID = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setInt(1, studentID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String retrievedMobilePhone = resultSet.getString("mobilePhone");
            String retrievedHomePhone = resultSet.getString("homePhone");
            String retrievedAddress = resultSet.getString("address");

            return retrievedMobilePhone.equals(mobilePhone) &&
                   retrievedHomePhone.equals(homePhone) &&
                   retrievedAddress.equals(address);
        }
        return false;
    }
    
    @Test
    public void testDeleteStudent() throws SQLException {
        int studentID = 2; 

        DatabaseHelper.deleteStudent(studentID);

        assertFalse(checkStudentExists(studentID)); 
    }

    private boolean checkStudentExists(int studentID) throws SQLException {
        String query = "SELECT * FROM Student WHERE studentID = ?";
        PreparedStatement statement = DatabaseHelper.conn.prepareStatement(query);
        statement.setInt(1, studentID);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
    
    @Test
    public void testSelectCraftsForCourseCreation() throws SQLException {
        boolean isWeekday = true; 

        ResultSet resultSet = DatabaseHelper.selectCraftsForCourseCreation(isWeekday);

        assertNotNull(resultSet);

        while (resultSet.next()) {
            int craftID = resultSet.getInt("craftID");
            String name = resultSet.getString("name");

            assertTrue(craftID > 0); 
            assertNotNull(name); 
        }
    }
    
    @Test
    public void testSelectInstructorsForCourseCreation() throws SQLException {
        int craftID = 1;
        boolean isWeekday = true; 

        ResultSet resultSet = DatabaseHelper.selectInstructorsForCourseCreation(craftID, isWeekday);

        assertNotNull(resultSet);

        while (resultSet.next()) {
            int instructorID = resultSet.getInt("instructorID");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            int day = resultSet.getInt("day");
            int startHour = resultSet.getInt("startHour");
            int workingHourID = resultSet.getInt("workingHourID");

            assertTrue(instructorID > 0); 
            assertNotNull(name); 
            assertNotNull(surname); 
            assertTrue(day >= 1 && day <= 7);
            assertTrue(startHour >= 0 && startHour <= 23);
            assertTrue(workingHourID > 0); 
        }
    }
    
    @Test
    public void testGetStudentNameandSurname() throws SQLException {
        String email = "jane.doe@example.com";
        String expectedFullName = "Jane Doe";

        String fullName = DatabaseHelper.getStudentNameandSurname(email);

        assertEquals(expectedFullName, fullName);
    }
    
    @Test
    public void testGetCraftsByCourseID() throws SQLException {
        int courseID = 1;
        String expectedCrafts = "Coding";

        String crafts = DatabaseHelper.getCraftsByCourseID(courseID);

        assertEquals(expectedCrafts, crafts);
    }
    
    @Test
    public void testGetStudentID() throws SQLException {
        String email = "jane.doe@example.com";
        int expectedID = 1;

        int studentID = DatabaseHelper.getStudentID(email);

        assertEquals(expectedID, studentID);
    }
    
    @Test
    public void testAddRegistration() throws SQLException {
        int courseID = 1;
        String email = "jane.doe@example.com";
        double fee = 100.0;
        boolean isCash = true;

        try {
            DatabaseHelper.addRegistration(courseID, isCash, email, fee);
        } catch (SQLException e) {
            fail("SQLException thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void testCheckIfItsCompatible() throws SQLException {
        String craftName = "Coding";
        boolean expectedIsWeekDay = false;

        boolean isWeekDay = DatabaseHelper.checkIfItsCompatible(craftName);

        assertEquals(expectedIsWeekDay, isWeekDay);
    }
    
    @Test
    public void testInsertCourse() throws SQLException {
        Date startDate = Date.valueOf("2024-06-01"); 
        Date endDate = Date.valueOf("2024-06-30");
        boolean isWeekday = true; 
        double fee = 100.0; 

        int id = DatabaseHelper.insertCourse(startDate, endDate, isWeekday, fee);

        assertTrue(id > 0);
    }
    
    @Test
    public void testClearSectionsByCourseID() throws SQLException {
        int courseID = 2;

        try {
            DatabaseHelper.clearSectionsByCourseID(courseID);
        } catch (SQLException e) {
            fail("Sectons could not be cleared: " + e.getMessage());
        }
    }
    
    @Test
    public void testClearRegistrationsByCourseID() throws SQLException {
        int courseID = 2;

        try {
            DatabaseHelper.clearRegistrationsByCourseID(courseID);
        } catch (SQLException e) {
            fail("Registrations could not be cleared: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testDeleteCourse() throws SQLException {
        int courseID = 2;
        DatabaseHelper.insertCourse(null, null, true, 500.00);
        assertTrue(checkCourseExists(courseID));

        DatabaseHelper.deleteCourse(courseID);

        assertFalse(checkCourseExists(courseID));
    }
    
    
    public static boolean checkCourseExists(int courseID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM course WHERE courseID = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
