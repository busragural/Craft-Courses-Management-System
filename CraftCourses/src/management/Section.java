package management;

public class Section {
    private int sectionID;
    private WorkingHour workingHour;
    private Craft craft;
    private Course course;

    public Section(WorkingHour workingHour, Craft craft, Course course) {
        this.workingHour = workingHour;
        this.craft = craft;
        this.course = course;
    }

    public int getSectionID() {
        return sectionID;
    }

    public WorkingHour getWorkingHour() {
        return workingHour;
    }

    public Craft getCraft() {
        return craft;
    }

    public Course getCourse() {
        return course;
    }
}
