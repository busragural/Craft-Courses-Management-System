package management;

import database.DatabaseHelper;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    public static void registerControl(String name, String surname, String email, String mobilePhone, 
            String homePhone, String address, String tmpWeekdayFee){
        double weekdayFee;
        
        if (name.isBlank() || surname.isBlank() || email.isBlank() || mobilePhone.isBlank() || 
                homePhone.isBlank() || address.isBlank() || tmpWeekdayFee.isBlank()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm bilgileri giriniz!");
            return;
        }
        
        try {
            weekdayFee = Double.parseDouble(tmpWeekdayFee);
            DatabaseHelper.registerInstructor(name, surname, email, mobilePhone, homePhone, address, weekdayFee);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Geçersiz ücret bilgisi!");
            return;
        }
    }
    
    public static void updateInfoControl(int instructorID, String mobilePhone, String homePhone, String address, String tmpWeekdayFee){
        double weekdayFee;
        
        if (mobilePhone.isBlank() || homePhone.isBlank() || address.isBlank() || tmpWeekdayFee.isBlank()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm bilgileri giriniz!");
            return;
        }
        
        try {
            weekdayFee = Double.parseDouble(tmpWeekdayFee);
            DatabaseHelper.updateInstructor(instructorID, mobilePhone, homePhone, address, weekdayFee);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Geçersiz ücret bilgisi!");
            return;
        }
    }
    
    public static boolean craftDetailControl(List<String> selectedCrafts){
        if (selectedCrafts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen en az bir ders seçiniz!");
            return true;
        }
        return false;
    }
    
    public static boolean workingHourDetailControl(String dayValue, String feeText, String selectedTime){
        if (dayValue.isBlank() || selectedTime == null) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm gerekli bilgiler seçiniz!");
            return true;
        }
        return false;
    }
    
    public static void displaySchedule(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
    }
}
