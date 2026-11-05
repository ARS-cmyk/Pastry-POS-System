
package pkg00f_tps_pastry_pos_system;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Blogin extends JFrame {
    
         
    JLabel label1 = new JLabel("POS SYSTEM");
    JLabel label2 = new JLabel("Username");
    JLabel label3 = new JLabel("Password");
//    JLabel label4 = new JLabel("_______________________      OR      _______________________ ");
//    JLabel label5 = new JLabel("Don't have an account?");
    JPanel panel = new JPanel();
    
    ButtonGroup adminoruser = new ButtonGroup();
    
    Blogin (){
        
        // MAIN JFRAME
        this.setSize(460, 560);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("PET SHOP DAWG");
        this.getContentPane().setBackground(AMain.cream);
        
         JRadioButton Admin = new JRadioButton();
          JRadioButton Employee = new JRadioButton();
    
    
      JButton login = new JButton("LOG IN");
//    JButton Admin = new JButton("Admin");
//    JButton User = new JButton("User");
      JButton butforgot = new JButton("Forgot password?");
      JTextField text = new JTextField();
      JPasswordField pass = new JPasswordField();
        
        
        // POS SYSTEM SINGNAGE
        this.add(label1);
        label1.setBounds(170, 70, 100, 20);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label1.setForeground(AMain.white);
        
        // GREEN TOP HEADER
        this.add(panel);
        panel.setBounds(0, 0, 450, 130);
        panel.setBackground(AMain.green);
        
        // USERNAME TEXT
        this.add(label2);
        label2.setBounds(60, 150, 100, 20);
        
        // USERNAME FIELD
        this.add(text);
        text.setBounds(60, 175, 330, 40 );
        
        // PASS TEXT
        this.add(label3);
        label3.setBounds(60, 232, 100, 20);
        
        // PASS FIELD
        this.add(pass);
        pass.setBounds(60, 257, 330, 40);
        
        // FORGOT PASS TEXT
        this.add(butforgot);
        butforgot.setBounds(260, 300, 130, 15);
        butforgot.setFont(new Font("Segoe UI", Font.BOLD, 10));
        butforgot.setBackground(AMain.white);
        butforgot.setForeground(AMain.green);
        
        // user/ admin

        JLabel lblAdmin = new JLabel("Admin");
        JLabel lblEmployee = new JLabel("Employee");
        
        adminoruser.add(Admin);
        adminoruser.add(Employee);
        Admin.setSelected(true);   

        Admin.setBounds(60, 330, 20, 20);
        Admin.setBackground(AMain.cream);
        this.add(Admin);

        lblAdmin.setBounds(85, 330, 60, 20);
        lblAdmin.setFont(new Font("Segoe UI", Font.BOLD, 13));
        this.add(lblAdmin);

        Employee.setBounds(180, 330, 20, 20);
        Employee.setBackground(AMain.cream);
        this.add(Employee);

        lblEmployee.setBounds(205, 330, 80, 20);
        lblEmployee.setFont(new Font("Segoe UI", Font.BOLD, 13));
        this.add(lblEmployee);
        
        // BUTTON FOR LOGIN
        this.add(login);
        login.setBounds(60, 400, 330, 46);
        login.setBackground(AMain.green);
        login.setForeground(AMain.white);
        
        
        
        // ___ OR ___ TEXT SAPCER
//        this.add(label4);
//        label4.setBounds(110, 380, 330, 46);
//        label4.setForeground(AMain.gray);
//        label4.setFont(new Font("Segoe UI", Font.BOLD, 10));
        
        // DONT HAVE AN ACCOUNT TEXT
//        this.add(label5);
//        label5.setBounds(175, 420, 120, 10);
//        label5.setFont(new Font("Segoe UI", Font.BOLD, 10));
//        label5.setForeground(AMain.gray);
        
        // BUTTON FOR SIGN UP
//        this.add(but2);
//        but2.setBounds(180, 435, 100, 20);
//        but2.setBackground(AMain.green);
//        but2.setForeground(AMain.white);
        
//        adminoruser.add(but2);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (text.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill up the UserName", "UserName Problem", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (pass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill up the Password", "Password Problem", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                if(Admin.isSelected()){
                        boolean access = false;
                    for (Ddatabase.Admin d : Ddatabase.admin) {
                        if (d.username.equals(text.getText()) && d.password.equals(pass.getText())) {
                            access = true;
                            break;
                        }
                    }
                        if (access) {
                            AMain.loginName = text.getText().trim();
                            new Cdashboard().setVisible(true);
                            Blogin.this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Invalid UserName/Password");
                        }
                }
                else if(Employee.isSelected()){
                        boolean access = false;
                    for (Ddatabase.Employee d : Ddatabase.employee) {
                        if (d.username.equals(text.getText()) && d.password.equals(pass.getText())) {
                            access = true;
                            break;
                        }
                    }
                        if (access) {
                            new Ccdashboard().setVisible(true);
                            Blogin.this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Invalid UserName/Password");
                        }
                }
            }
            }
        });
        
        butforgot.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Admin.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please contact the system owner to reset your password.", "Forgot Password", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if(Employee.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please contact the Administrator to reset your password.", "Forgot Password", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        });
        
        

        
    }
    
}
