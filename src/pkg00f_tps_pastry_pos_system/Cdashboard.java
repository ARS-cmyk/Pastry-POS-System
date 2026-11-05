
package pkg00f_tps_pastry_pos_system;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
    
public class Cdashboard extends JFrame implements ActionListener{
    
    public static int item =0;
    public static int lowStock =0;
    public static int outOfStock =0;
    
     static  Font bfont =(new Font("Monospaced", Font.PLAIN, 14));
     static  Font tfont =(new Font("SansSerif", Font.BOLD, 10));
    
    ImageIcon icon1 = new ImageIcon(); 
    
    JPanel sidebar = new JPanel(new BorderLayout()); // GREEN SIDE PANEL
    JPanel panel2 = new JPanel(new GridLayout(3,1)); // FOR CONSLOE AND POS SYSTEM HOLDER
    JPanel panel3 = new JPanel(new GridLayout(20,1)); // FOR THE BUTTON FUNCTIONS
    JPanel topbar = new JPanel(new FlowLayout(FlowLayout.LEFT)); // TOPBAR 
    JPanel topbar1 = new JPanel(new GridLayout(1,10));
    JPanel panel4 = new JPanel(new BorderLayout()); // main panel for center contents
    JPanel panel5 = new JPanel(new BorderLayout(3,0)); 
    JPanel panel7 = new JPanel(new GridLayout(2,1,0,-10));
    JPanel panel9 = new JPanel();
    JPanel panel10 = new JPanel();
    
    public  JButton dashboard = new JButton  (" DashBoard     ");
    public  JButton sales = new JButton      (" Sales Terminal");
//    public  JButton orders = new JButton     (" Orders        ");
    
    public  JButton products = new JButton   (" Products      ");
    public  JButton categories = new JButton (" Catergories   ");
    public  JButton inventory = new JButton  (" Inventory     ");
    public  JButton suppliers = new JButton  (" Suppliers     ");
    
//    public  JButton customers = new JButton  (" Customers     ");
    public  JButton employees = new JButton  (" Employees     ");
    
//    public  JButton discounts = new JButton  (" Discounts     ");
//    public  JButton cash = new JButton       (" Cash & Shifts ");
//    public  JButton reports = new JButton    (" Reports       "); 
    
    public  JButton settings = new JButton   (" Settings      ");
    
    public  JButton logout = new JButton     (" Logout        ");
    
    
    
    public static JButton newsaleB = new JButton   ();
    public static JButton notif = new JButton   ();
    
    JLabel label1 = new JLabel(AMain.Sname);
    JLabel label2 = new JLabel("               ADMIN CONSOLE");
    JLabel label3 = new JLabel("__________________________________");
    JLabel label4 = new JLabel("MAIN");
    JLabel label5 = new JLabel("CATALOG");
    JLabel label6 = new JLabel("PEOPLE");
//    JLabel label7 = new JLabel("BUSINESS");
    JLabel label8 = new JLabel("SYSTEM");
    JLabel label9 = new JLabel("Dashboard");
    JLabel newsaleBnum = new JLabel(); // SEARCH ICON TO
    JLabel spacer0 = new JLabel("    "); // SPACER
    JLabel spacer1 = new JLabel("               "); // SPACER
    JLabel spacer2 = new JLabel("   "); // SPACER
    JLabel spacer3 = new JLabel("   "); // SPACER
    JLabel spacer4 = new JLabel("   "); // SPACER
    JLabel spacer5 = new JLabel("   "); // SPACER
            static String time;
    JLabel clock = new JLabel(time); // clock
    JLabel dateday = new JLabel("date and day sana to"); // date dady
    JLabel userprofile = new JLabel(); // date dady
//    JLabel notifnum = new JLabel(); // clock
    
   
    
    
    JTextField tfield1 = new JTextField(20); // SEARCH BAR 
    
    // FIELDS 
    JLabel pageTitle = new JLabel("Dashboard");
    JLabel pageSub = new JLabel();
    java.awt.Component currentPage; 
    
    Cdashboard(){
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(1366, 768);
        this.getContentPane().setBackground(AMain.cream);
        this.setLocationRelativeTo(null);
        this.setTitle("POS System - Dashboard");
        
        sidebar1();
        topbar3();
        action();                                                
        showPage("Dashboard", "Overview", Etabs.dashboard());
        this.setVisible(true);
    }
    

        public void action(){
             dashboard.addActionListener(this);
             sales.addActionListener(this);
//             orders.addActionListener(this);
             products.addActionListener(this);
             categories.addActionListener(this);
             inventory.addActionListener(this);
             suppliers.addActionListener(this);
//             customers.addActionListener(this);
             employees.addActionListener(this);
//             discounts.addActionListener(this);
//             cash.addActionListener(this);
//             reports.addActionListener(this);
             settings.addActionListener(this);
             logout.addActionListener(this);
             
        }
        public void sidebar1(){
            
//        this.add(panel1);
        sidebar.setPreferredSize(new Dimension(232,704));
        sidebar.setBackground(AMain.dgreen);
        sidebar.setLayout(new BorderLayout());
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 16));
        
//        this.add(label1);  WHOLE SIDEBAR W/ BUTTONS/LABELS/ICONS
        label1.setFont(new Font ("Serif", Font.BOLD, 18));
        label1.setForeground(AMain.cream);
        
        label2.setForeground(AMain.gold);
        label2.setFont(new Font("Sans", Font.PLAIN, 10));

        label3.setForeground(AMain.lgreen);
        label3.setFont(new Font("Sans", Font.BOLD, 10));

        panel2.add(label1);
        panel2.add(label2);
        panel2.add(label3);
        panel2.setOpaque(false);
        sidebar.add(panel2, BorderLayout.NORTH);
        
        title(label4);
        panel3.add(label4);
        buttons(dashboard,"/24px icon/light/24px/home.png");
        panel3.add(dashboard);
        buttons(sales,"/24px icon/light/24px/cart.png");
        panel3.add(sales);
//        buttons(orders,"/24px icon/light/24px/orders.png");
//        panel3.add(orders);
        
        title(label5);
        panel3.add(label5);
        buttons(products,"/24px icon/light/24px/products.png");
        panel3.add(products);
        buttons(categories,"/24px icon/light/24px/categories.png");
        panel3.add(categories);
        buttons(inventory,"/24px icon/light/24px/inventory.png");
        panel3.add(inventory);
        buttons(suppliers,"/24px icon/light/24px/suppliers.png");
        panel3.add(suppliers);
        
        title(label6);
        panel3.add(label6);
//        buttons(customers,"/24px icon/light/24px/customers.png");
//        panel3.add(customers);
        buttons(employees,"/24px icon/light/24px/user.png");
        panel3.add(employees);
        
//        title(label7);
//        panel3.add(label7);
//        buttons(discounts,"/24px icon/light/24px/discounts_percent.png");
//        panel3.add(discounts);
//        buttons(cash,"/24px icon/light/24px/cash_shifts_wallet.png");
//        panel3.add(cash);
//        buttons(reports,"/24px icon/light/24px/reports_chart.png");
//        panel3.add(reports);
        
        title(label8);
        panel3.add(label8);
        buttons(settings,"/24px icon/light/24px/settings_gear.png");
        panel3.add(settings);
        
        
        buttons(logout,"/24px icon/light/24px/logout.png");
        panel3.add(logout);
        
         panel3.setOpaque(false);
        sidebar.add(panel3, BorderLayout.CENTER);
        this.add(sidebar, BorderLayout.WEST);
        
        }
        public void topbar1(){
        // TOPBAR W/ PANEL TO CONTAIN BUTTONS AND LANELS 
        topbar.setPreferredSize(new Dimension(0,64));
        topbar.setBackground(AMain.white2);
        
        topbar.add(spacer0);
        
        panel7.setPreferredSize(new Dimension(150,64));
        panel7.setBackground(AMain.white);
        
        label9.setForeground(AMain.green);
        label9.setFont(new Font("Serif", Font.BOLD, 24));
        label9.setBounds(23, 10, 300, 30);
        
        dateday.setForeground(AMain.black);
        dateday.setFont(new Font ("Sans", Font.PLAIN, 13));
        
        panel7.add(label9);
        panel7.add(dateday);
        
        topbar.add(panel7);
        topbar.add(spacer1);
        
        
        
        
        
        panel5.setPreferredSize(new Dimension(350,36));
        panel5.setBackground(AMain.white);
        
        newsaleBnum.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/teal/24px/search.png")));
        panel5.add(newsaleBnum, BorderLayout.WEST);
        
        tfield1.setBackground(AMain.white2);
        tfield1.setForeground(AMain.green);
//        tfield1.setSize(350,36);
        tfield1.setBackground(AMain.cream);
        tfield1.setFont(new Font("Monospaced", Font.BOLD, 20));
        panel5.add(tfield1, BorderLayout.CENTER);
        topbar.add(panel5);
        topbar.add(spacer2);
        
        newsaleB.setBackground(AMain.gold);
        newsaleB.setSize(130,36);
        newsaleB.setText("+ New sale  " + AMain.newsale);
        newsaleB.setForeground(AMain.black);
        newsaleB.setFont(new Font ("Sans", Font.BOLD, 14));
        
//        panel5.add(newsaleB, BorderLayout.EAST);
        topbar.add(newsaleB);
        topbar.add(spacer3);
        
        topbar.add(clock);
        topbar.add(spacer4);
        
        notif.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/gold/24px/bell.png")));
        notif.setSize(40,40);
        notif.setBackground(AMain.white);
        notif.setBorderPainted(false);
        notif.setFocusPainted(false);
        notif.setText(AMain.parsedNotif);
        notif.setForeground(AMain.red);
        notif.setFont(new Font("Sans", Font.BOLD, 15));
        topbar.add(notif);
        topbar.add(spacer5);
        
        
        
        userprofile.setIcon(new ImageIcon(AMain.class.getResource("/pic/ariel24px.png/")));
        userprofile.setText(AMain.profilename);
        
        topbar.add(userprofile);
        
        
        panel4.add(topbar, BorderLayout.NORTH);
        panel4.setOpaque(false);
        this.add(panel4, BorderLayout.CENTER);
        }  // not used
        public void topbar2(){
            // TOPBAR W/ PANEL TO CONTAIN BUTTONS AND LANELS 
            
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        JLabel l5 = new JLabel();
        JLabel magnifying = new JLabel();
        
        JLabel spcr0 = new JLabel("     ");
        JLabel spcr1 = new JLabel("               ");
        JLabel spcr2 = new JLabel("                                                    ");
        JLabel spcr3 = new JLabel("   ");
        JLabel spcr4 = new JLabel("   ");
        JLabel spcr5 = new JLabel("   ");
        JLabel spcr6 = new JLabel("   ");
            
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        JPanel p1 = new JPanel(new GridLayout(2,1,0,-10)); 
        JPanel p2 = new JPanel(new BorderLayout(3,0)); 
        JPanel p3 = new JPanel(new BorderLayout()); 
        
        JTextField text1 = new JTextField();
        
        
        top.add(spacer0);
        
        top.setPreferredSize(new Dimension(0,64));
        top.setBackground(AMain.white2);
        
        top.add(spcr1);
        
        p1.setPreferredSize(new Dimension(150,64));
        p1.setBackground(AMain.white);
        
        l1.setText("Sales Terminal");
        l1.setForeground(AMain.green);
        l1.setFont(new Font("Serif", Font.BOLD, 24));
        l1.setBounds(23, 10, 300, 30);
        
//        l2.setText("Cashier : " + username);  // username
        l2.setForeground(AMain.black);
        l2.setFont(new Font ("Sans", Font.PLAIN, 13));
        
        p1.add(l1);
        p1.add(l2);
        
        top.add(p1);
        top.add(spcr1);
        
        
        p2.setPreferredSize(new Dimension(350,36));
        p2.setBackground(AMain.white);
        
        magnifying.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/teal/24px/search.png")));
        p2.add(magnifying, BorderLayout.WEST);
        
        text1.setBackground(AMain.white2);
        text1.setForeground(AMain.green);
//        tfield1.setSize(350,36);
        text1.setBackground(AMain.cream);
        text1.setFont(new Font("Monospaced", Font.BOLD, 20));
        p2.add(text1, BorderLayout.CENTER);
        top.add(p2);
        top.add(spcr2);
        
        //clock
        top.add(clock);
        top.add(spcr4);
        
        notif.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/gold/24px/bell.png")));
        notif.setSize(40,40);
        notif.setBackground(AMain.white);
        notif.setBorderPainted(false);
        notif.setFocusPainted(false);
        notif.setText(AMain.parsedNotif);
        notif.setForeground(AMain.red);
        notif.setFont(new Font("Sans", Font.BOLD, 15));
        top.add(notif);
        top.add(spcr5);
        
        
        userprofile.setIcon(new ImageIcon(AMain.class.getResource("/pic/ariel24px.png/")));
        userprofile.setText(AMain.profilename);
        
        top.add(userprofile);
        
        
        panel4.add(top, BorderLayout.NORTH);
        panel4.setOpaque(false);
        this.add(panel4, BorderLayout.CENTER);
        }  // not used
        public void topbar3(){
             // TOPBAR W/ PANEL TO CONTAIN BUTTONS AND LANELS 
            
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        JLabel l5 = new JLabel();
        JLabel magnifying = new JLabel();
        
        JLabel spcr0 = new JLabel("     ");
        JLabel spcr1 = new JLabel("               ");
        JLabel spcr2 = new JLabel("                                                    ");
        JLabel spcr3 = new JLabel("   ");
        JLabel spcr4 = new JLabel("   ");
        JLabel spcr5 = new JLabel("   ");
        JLabel spcr6 = new JLabel("   ");
            
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        JPanel p1 = new JPanel(new GridLayout(2,1,0,-10)); 
        JPanel p2 = new JPanel(new BorderLayout(3,0)); 
        JPanel p3 = new JPanel(new BorderLayout()); 
        
        JTextField text1 = new JTextField();
        
        
        top.add(spacer0);
        
        top.setPreferredSize(new Dimension(0,64));
        top.setBackground(AMain.white2);
        
        top.add(spcr1);
        
        p1.setPreferredSize(new Dimension(150,64));
        p1.setBackground(AMain.white);
        
        pageTitle.setForeground(AMain.green);
        pageTitle.setFont(new Font("Serif", Font.BOLD, 24));
        pageSub.setForeground(AMain.black);
        pageSub.setFont(new Font("Sans", Font.PLAIN, 10));

        p1.add(pageTitle);
        p1.add(pageSub);
        
        top.add(p1);
        top.add(spcr1);
        
        
        p2.setPreferredSize(new Dimension(350,36));
        p2.setBackground(AMain.white);
        
//        magnifying.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/teal/24px/search.png")));
//        p2.add(magnifying, BorderLayout.WEST);
        
//        text1.setBackground(AMain.white2);
//        text1.setForeground(AMain.green);
//        tfield1.setSize(350,36);
//        text1.setBackground(AMain.cream);
//        text1.setFont(new Font("Monospaced", Font.BOLD, 20));
//        p2.add(text1, BorderLayout.CENTER);
//        top.add(p2);
//        top.add(spcr2);
        
        //clock
        top.add(clock);
        top.add(spcr4);
        
//        notif.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/gold/24px/bell.png")));
//        notif.setSize(40,40);
//        notif.setBackground(AMain.white);
//        notif.setBorderPainted(false);
//        notif.setFocusPainted(false);
//        notif.setText(AMain.parsedNotif);
//        notif.setForeground(AMain.red);
//        notif.setFont(new Font("Sans", Font.BOLD, 15));
//        top.add(notif);
//        top.add(spcr5);
        
        
//        userprofile.setIcon(new ImageIcon(AMain.class.getResource("/pic/ariel24px.png/")));
//        userprofile.setText(AMain.profilename);
//        top.add(userprofile);
        
        
        panel4.add(top, BorderLayout.NORTH);
        panel4.setOpaque(false);
        this.add(panel4, BorderLayout.CENTER);
        }
        
//        public void centerdashboard(){
//            // center dashboadr contents
//            
////              panel4.add(Etabs.dashboard());
////            panel4.add(Etabs.salesterminal());
//            panel4.add(Etabs.products());
//        }
//        public void salesTerminal(){
//            panel4.add(Etabs.salesterminal(), BorderLayout.CENTER);
//        }
        public  void clock(){
            while(true){
            SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm:ss a");     
            time = timeformat.format(Calendar.getInstance().getTime());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cdashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
        public static void buttons(JButton button, String icon){
        button.setIcon(new ImageIcon(AMain.class.getResource(icon)));
        button.setForeground(AMain.white);
        button.setBackground(AMain.green);
        button.setFont(bfont);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
            
        } 
        public static void title (JLabel label){
        label.setForeground(AMain.lgreen);
        label.setFont(tfont);
        }
        
        private JPanel placeholder(String name){
            JPanel p = new JPanel(new BorderLayout());
            p.setBackground(AMain.cream);
            p.add(new javax.swing.JLabel(name + " (coming soon)", javax.swing.SwingConstants.CENTER), BorderLayout.CENTER);
            return p;
            } 
        public void showPage(String title, String sub, JPanel page){
             if (currentPage != null) panel4.remove(currentPage);   // magreremove nung lumang page
             currentPage = page;
             panel4.add(page, BorderLayout.CENTER);
             pageTitle.setText(title);
             pageSub.setText(sub);
             panel4.revalidate();    // pang print ng bagong page
             panel4.repaint();
        }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(dashboard)){
            showPage("Dashboard", "Business Overview", Etabs.dashboard());
        }
        else if(e.getSource().equals(sales)){
            showPage("SalesTerminal", "Process Transactions", Etabs.salesterminal());
        }
//        else if(e.getSource().equals(orders)){
//            showPage("Orders", "Overview", Etabs.comingsoon());
//        }
        else if(e.getSource().equals(products )){
            showPage("Products", "Manage Product Catalog", Etabs.products());
        }
        else if(e.getSource().equals(categories )){
            showPage("Category", "Organize Product Groups", Etabs.category());
        }
        else if(e.getSource().equals(inventory )){
            showPage("Inventory", "Track Stock Levels", Etabs.inventory());
        }
        else if(e.getSource().equals(suppliers )){
            showPage("Suppliers", "Manage Supplier Details", Etabs.supplier());
        }
//        else if(e.getSource().equals(customers )){
//            showPage("Customer", "Customer Records", Etabs.customer());
//        }
        else if(e.getSource().equals(employees )){
            showPage("Employee", "Staff Accounts & Roles", Etabs.employee());
        }
//        else if(e.getSource().equals(discounts )){
//            showPage("Dashboard", "Overview", Etabs.comingsoon());
//        }
//        else if(e.getSource().equals(cash )){
//            showPage("Dashboard", "Overview", Etabs.comingsoon());
//        }
//        else if(e.getSource().equals(reports )){
//            showPage("Dashboard", "Overview", Etabs.comingsoon());
//        }
        else if(e.getSource().equals(settings )){
            showPage("Settings", "System Preferences", Etabs.settings());
        }
        else if(e.getSource().equals(logout )){
             int choice = JOptionPane.showConfirmDialog(Cdashboard.this,"Are you sure you want to log out?","Confirm Logout",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
             
             if (choice == JOptionPane.YES_OPTION) {
            AMain.loginName = "";
            Cdashboard.this.dispose();       
            new Blogin().setVisible(true);
             }
        }
        
    }
}
