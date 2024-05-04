package management;

public class Student extends Person {
    private static int counter = 1;
    private int studentID;
    private Course[] previousCourses;
    private Course[] upcomingCourses;

    public Student(String name, String surname, String email, String mobilePhone, String homePhone, String address) {
        super(name, surname, email, mobilePhone, homePhone, address);
        this.studentID = counter++;
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
}
