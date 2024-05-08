package management;

import database.DatabaseHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    public static void displayAllDashboard(JTable table){
        String checkSession;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        ResultSet resultSet = DatabaseHelper.selectAllCrafts();
        
        try {
            while (resultSet.next()) {
                int craftID = resultSet.getInt("craftID");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                boolean isWeekday = resultSet.getBoolean("isWeekday");
                double fee = resultSet.getDouble("craftFee");
                
                if (isWeekday) {
                    checkSession = "Hafta içi";
                } else {
                    checkSession = "Hafta sonu";
                }
                
                model.addRow(new Object[]{craftID, name, description, checkSession, fee});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Craft.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Dersler getirilirken bir hata oluştu!");
        }
    }
    
    public static void displayAllInstructor(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        ResultSet resultSet = DatabaseHelper.selectAllCrafts();
        
        try {
            while (resultSet.next()) {
                int craftID = resultSet.getInt("craftID");
                String name = resultSet.getString("name");
                model.addRow(new Object[]{craftID, name});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Craft.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Dersler getirilirken bir hata oluştu!");
        }
    }
    
    public static void displayAllCraftsOfInstructor (int instructorID, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        ResultSet resultSet = DatabaseHelper.selectAllCraftsOfInstructor(instructorID);
        
        try {
            while (resultSet.next()) {
                int craftID = resultSet.getInt("craftID");
                String craftName = resultSet.getString("name");
                model.addRow(new Object[]{craftID, craftName});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Craft.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Dersler getirilirken bir hata oluştu!");
        }
    }
}
