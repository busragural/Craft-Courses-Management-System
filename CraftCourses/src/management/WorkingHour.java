package management;

public class WorkingHour {
    private static int counter = 1;
    private int workingHourID;
    private Instructor instructor;
    private int day;
    private int startHour;
    private boolean isBusy;

    public WorkingHour(Instructor instructor, int day, int startHour) {
        this.workingHourID = counter++;
        this.instructor = instructor;
        this.day = day;
        this.startHour = startHour;
    }

    public int getWorkingHourID() {
        return workingHourID;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public int getDay() {
        return day;
    }

    public int getStartHour() {
        return startHour;
    }

    public boolean isBusy() {
        return isBusy;
    }
}
