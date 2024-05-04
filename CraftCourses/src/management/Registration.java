package management;

import java.util.Date;

public class Registration {
    private static int counter = 1;
    private int registrationID;
    private Student student;
    private Course course;
    private Date date;
    private double fee;
    private boolean isActive;

    public Registration(Student student, Course course, Date date, double fee) {
        this.registrationID = counter++;
        this.student = student;
        this.course = course;
        this.date = date;
        this.fee = fee;
    }

    public int getRegistrationID() {
        return registrationID;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Date getDate() {
        return date;
    }

    public double getFee() {
        return fee;
    }

    public boolean isActive() {
        return isActive;
    }
}
