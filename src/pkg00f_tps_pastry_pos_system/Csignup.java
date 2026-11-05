package pkg00f_tps_pastry_pos_system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Csignup extends JFrame{
     
    JButton but1 = new JButton("SIGN UP");
    JButton but2 = new JButton("Log in");
    JTextField text = new JTextField();
    JPasswordField pass = new JPasswordField();
    JPasswordField pass2 = new JPasswordField();
    JLabel label1 = new JLabel("CREATE ACCOUNT ");
    JLabel label2 = new JLabel("Username");
    JLabel label3 = new JLabel("Password");
    JLabel label3e = new JLabel("Confirm password");
    JLabel label4 = new JLabel("_______________________      OR      _______________________ ");
    JLabel label5 = new JLabel("Register as Admin or USer");
    JLabel label6 = new JLabel("Already have an account?");
    JLabel label7 = new JLabel("Admin");
    JLabel label8 = new JLabel("User");
    JLabel label9 = new JLabel("Register as:");
    JPanel panel = new JPanel();
    JRadioButton rbut1 = new JRadioButton();
    JRadioButton rbut2 = new JRadioButton();
    
    Color color1 = Color.decode("#0F5B4C"); // DARK GREEN
    Color color2 = Color.decode("#FFFFFF"); // WHITE
    Color color3 = Color.decode("#14b8a6"); // LIGHT GREEN
    Color color4 = Color.decode("#6B7280"); // silver
    Color color5 = Color.decode("#0F5B4C");
    
    
    Csignup (){
        
        // MAIN JFRAME
        this.setSize(460, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("PET SHOP DAWG");
        this.getContentPane().setBackground(AMain.cream);
        
        // CERATE AN ACCOUNT TEXT
        this.add(label1);
        label1.setBounds(170, 50, 150, 20);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label1.setForeground(AMain.white);
        
        // REG AS ADMIN OR USER
        this.add(label5);
        label5.setBounds(170, 80, 150, 20);
        label5.setFont(new Font("Segoe UI", Font.BOLD, 10));
        label5.setForeground(AMain.white);
        
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
        
        // PASS2 TEXT
        this.add(label3e);
        label3e.setBounds(60, 314, 120, 20);
        
        // PASS2 FIELD
        this.add(pass2);
        pass2.setBounds(60, 339, 330, 40);
        
        
        // registrer as TEXT
        this.add(label9);
        label9.setBounds(60, 385, 70, 20);
        
        // for rbut1 ADMIN 
        this.add(rbut1);
        rbut1.setBounds(60, 415, 30, 30);
        
        // for rbut1 TEXT
        this.add(label7);
        label7.setBounds(90, 405, 50, 50);
        label7.setForeground(AMain.green);
        
        // for rbut2 USER 
        this.add(rbut2);
        rbut2.setBounds(270, 415, 30, 30);
        
        // for rbut1 TEXT
        this.add(label8);
        label8.setBounds(300, 405, 50, 50);
        label8.setForeground(AMain.green);
        
        
        // BUTTON FOR SIGN UP
        this.add(but1);
        but1.setBounds(60, 470, 330, 46);
        but1.setBackground(AMain.green);
        but1.setForeground(AMain.white);
   
        // ALREDY HAEV AN ACCOUNT TEXT SAPCER
        this.add(label6);
        label6.setBounds(160, 530, 330, 46);
        label6.setForeground(AMain.gray);
        label6.setFont(new Font("Segoe UI", Font.BOLD, 10));
        
        // BUTTON FOR LOG IN
        this.add(but2);
        but2.setBounds(170, 570, 100, 20);
        but2.setBackground(AMain.green);
        but2.setForeground(AMain.white);
        
        
    }  
}
