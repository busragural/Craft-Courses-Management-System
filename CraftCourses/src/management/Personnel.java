package management;

import java.util.ArrayList;
import database.DatabaseHelper;

public class Personnel {
    private String username;
    private String password;
    
    public Personnel(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
  
    public void createCraftCourses(/* ? */) {
        // Implement createCraftCourses method
    }
}
