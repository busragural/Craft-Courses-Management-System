package management;

import database.DatabaseHelper;
import javax.swing.JOptionPane;

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
    
    public static void updateInfoControl(int craftID, String tmpIsWeekday, String tmpFee){
        boolean isWeekday;
        double fee = Double.parseDouble(tmpFee);
        
        if (tmpIsWeekday.isBlank() || Double.isNaN(fee)) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm bilgileri giriniz!");
            return;
        }
        
        if (tmpIsWeekday.equalsIgnoreCase("Hafta içi")) {
            isWeekday = true;
        }
        else if (tmpIsWeekday.equalsIgnoreCase("Hafta sonu")) {
            isWeekday = false;
        }
        else {
            JOptionPane.showMessageDialog(null, "Zaman bilgisini 'Hafta içi' veya 'Hafta sonu' olarak giriniz!");
            return;
        }
        
        DatabaseHelper.updateCraft(craftID, isWeekday, fee);
    }
}
