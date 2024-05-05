package management;

import database.DatabaseHelper;
import javax.swing.JOptionPane;

public class Student extends Person {
    private int studentID;
    private Course[] previousCourses;
    private Course[] upcomingCourses;

    public Student(String name, String surname, String email, String mobilePhone, String homePhone, String address) {
        super(name, surname, email, mobilePhone, homePhone, address);
    }

    public int getStudentID() {
        return studentID;
    }

    public Course[] getPreviousCourses() {
        return previousCourses;
    }

    public Course[] getUpcomingCourses() {
        return upcomingCourses;
    }
    
    public static void update(int studentID, String mobilePhone, String homePhone, String address){
        if (mobilePhone.isBlank() || mobilePhone.isBlank() || homePhone.isBlank() || address.isBlank()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm bilgileri giriniz!");
            return;
        }
        
        DatabaseHelper.updateStudent(studentID, mobilePhone, homePhone, address);
    }
}
