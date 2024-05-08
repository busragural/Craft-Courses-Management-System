package management;

import database.DatabaseHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Course {
    private int courseID;
    private Date startDate;
    private Date endDate;
    private boolean isWeekday;
    private ArrayList<Craft> crafts;
    private ArrayList<Section> sections;
    private ArrayList<Student> students;
    private double fee;

    public Course(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.crafts = new ArrayList<>();
        this.sections = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public int getCourseID() {
        return courseID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isWeekday() {
        return isWeekday;
    }

    public ArrayList<Craft> getCrafts() {
        return crafts;
    }

    public double getFee() {
        return fee;
    }

    public void addCraft(Craft craft) {
        crafts.add(craft);
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void calculateCourseFee() {
        // Implement calculateCourseFee method
    }
    
    public static void displayCraftsForCourseCreation(JTable table, boolean isWeekday) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        try {
            ResultSet resultSet = DatabaseHelper.selectCraftsForCourseCreation(isWeekday);
            while (resultSet.next()) {
                int craftID = resultSet.getInt("craftID");
                String name = resultSet.getString("name");
                model.addRow(new Object[]{craftID, name});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Craft.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Dersler getirilirken bir hata oluştu!");
        }
    }
    
    public static void displayInstructorsForCourseCreation(JTable instructorsTable, int craftID, boolean isWeekday) {
        DefaultTableModel model = (DefaultTableModel) instructorsTable.getModel();
        model.setRowCount(0);
        
        String[] daysOfWeek = {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"};
        
        try {
            ResultSet resultSet = DatabaseHelper.selectInstructorsForCourseCreation(craftID, isWeekday);
            while (resultSet.next()) {
                int instructorID = resultSet.getInt("instructorID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int dayIndex = resultSet.getInt("day") - 1;
                int startHour = resultSet.getInt("startHour");
                
                String day = daysOfWeek[dayIndex];
                model.addRow(new Object[]{instructorID, name + " " + surname, day, startHour});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Öğretmenler getirilirken bir hata oluştu!");
        }
    }
}
