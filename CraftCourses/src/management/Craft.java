package management;

public class Craft {
    private int craftID;
    private String name;
    private String description;
    private boolean isWeekday;
    private double fee;
    
    public Craft(int craftID, String name, String description, boolean isWeekday, double fee) {
        this.craftID = craftID;
        this.name = name;
        this.description = description;
        this.isWeekday = isWeekday;
        this.fee = fee;
    }
    
    public int getCraftID() {
        return craftID;
    }
    
    public void setCraftID(int craftID) {
        this.craftID = craftID;
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
