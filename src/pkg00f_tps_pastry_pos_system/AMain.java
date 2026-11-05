
package pkg00f_tps_pastry_pos_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AMain {
    
    public static final Color lgreen = Color.decode("#7FA5A8");;
    public static final Color lgreen1 = Color.decode("#4A943E");;
    public static final Color green = Color.decode("#0d5c63");;
    public static final Color dgreen = Color.decode("#084044");;
    public static final Color gold = Color.decode("#D4AF37");
    public static final Color dgold = Color.decode("#A8861F");
    public static final Color cream = Color.decode("#F8F3EB");
    public static final Color brown = Color.decode("#E4DBCB");
    public static final Color white = Color.decode("#FFFFFF");
    public static final Color white2 = Color.decode("#FFFCF7");
    public static final Color gray = Color.decode("#5C6770");
    public static final Color black = Color.decode("#232323");
    public static final Color red = Color.decode("#B22222");
    
    public static String loginName;
    public static String Sname = "PASTRY POS SYSTEM";
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static  int newsale = 0;
    public static  int notif = 0;
    public static String parsedNotif = Integer.toString(notif);
    public static String profilename = "boss mason";
    
    
    
    public static String datee;
    public static String timee;
    
    
    public static void main(String[] args) {
        
        Ddatabase.Admin admin = new Ddatabase.Admin("Admin","name","Manager","admin@gmail.com","09326662871","admin","admin");
        Ddatabase.admin.add(admin);
        new Blogin().setVisible(true);
    }

}
