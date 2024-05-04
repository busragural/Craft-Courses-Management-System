package management;

import java.util.ArrayList;
import java.util.List;

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

    public void addWorkingHour() {
        // Implement addWorkingHour method
    }

    public void addCraft() {
        // Implement addCraft method
    }
}
