package management;

import database.DatabaseHelper;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Instructor extends Person {
    private int instructorID;
    private List<WorkingHour> workingHours;
    private List<Craft> crafts;
    private double weekdayFee;
    private double weekendFee;
    
    public Instructor(String name, String surname, String email, String mobilePhone, String homePhone, String address) {
        super(name, surname, email, mobilePhone, homePhone, address);
        this.workingHours = new ArrayList<>();
        this.crafts = new ArrayList<>();
    }
    
    public int getInstructorID() {
        return instructorID;
    }
    
    public List<WorkingHour> getWorkingHours() {
        return workingHours;
    }
    
    public List<Craft> getCrafts() {
        return crafts;
    }
    
    public double getWeekdayFee() {
        return weekdayFee;
    }
    
    public double getWeekendFee() {
        return weekendFee;
    }
    
    public static void update(int instructorID, String mobilePhone, String homePhone, String address){
        if (mobilePhone.isBlank() || mobilePhone.isBlank() || homePhone.isBlank() || address.isBlank()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm bilgileri giriniz!");
            return;
        }
        
        DatabaseHelper.updateInstructor(instructorID, mobilePhone, homePhone, address);
    }
}
