package management;

public class Craft {
    private static int counter = 1;
    private int craftID;
    private String name;
    private String description;
    private boolean isWeekday;
    private double fee;

    public Craft(String name, String description, double fee) {
        this.craftID = counter++;
        this.name = name;
        this.description = description;
        this.fee = fee;
    }

    public int getCraftID() {
        return craftID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isWeekday() {
        return isWeekday;
    }

    public double getFee() {
        return fee;
    }
}
