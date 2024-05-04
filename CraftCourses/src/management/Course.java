package management;

import java.util.ArrayList;
import java.util.Date;

public class Course {
    private static int counter = 1;
    private int courseID;
    private Date startDate;
    private Date endDate;
    private boolean isWeekday;
    private ArrayList<Craft> crafts;
    private ArrayList<Section> sections;
    private ArrayList<Student> students;
    private double fee;

    public Course(Date startDate, Date endDate) {
        this.courseID = counter++;
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
}
