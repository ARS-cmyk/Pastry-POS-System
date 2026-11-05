
package pkg00f_tps_pastry_pos_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
//import static pkg00f_tps_pastry_pos_system.Ddatabase.category;

public class FpopUps {
       
    static JTextField tfPromo = new JTextField();  //promo ste by user
    static String promo;
    static JTextField tfVat = new JTextField();    // vat fix 12percent
    static JTextField tfMoney = new JTextField();   // money input by user
    static String money;
    
    static double subtotal = 0;
    static double total = 0;
    static double moneyGiven = 0;
    static double change = 0;
    static double promoAmount  = 0;
    static double vatAmount  = 0;
    
    static DefaultTableModel model = new DefaultTableModel(new String[]{"Item", "Qty", "Price"}, 0);

    
    // JFRAMES
    public static JFrame add(){
        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridLayout(2,1));
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel5 = new JPanel(new GridLayout(10,1));
        
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        JLabel l5 = new JLabel();
        JLabel l6 = new JLabel();
        JLabel l7 = new JLabel();
        JLabel l8 = new JLabel();
        JLabel l9 = new JLabel();
        JLabel l10 = new JLabel();
        JLabel l11 = new JLabel();
//        JLabel image = new JLabel();
        JLabel spacer1 = new JLabel("");
        
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        JButton image = new JButton();
        
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();
        
        JComboBox combo1 = new JComboBox();
        JComboBox combo2 = new JComboBox();
        
        for (Ddatabase.Category c : Ddatabase.category) {
        combo1.addItem(c.categoryname);
        }
        for (Ddatabase.Supplier s : Ddatabase.supplier) {
        combo2.addItem(s.comName);
        }
        
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  // do nothjing o close
        frame.setTitle("Add Products");
        frame.setResizable(false);
        frame.setSize(550,650);
        frame.setLocationRelativeTo(null);
        
        
        panel2.setBackground(AMain.green);
        panel2.setPreferredSize(new Dimension(0,70));
        panel2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        l1.setText("Add Product");
        l1.setFont(new Font("Serif", Font.BOLD, 25));
        l1.setForeground(AMain.gold);
        panel2.add(l1);
        l2.setText("Create an item for Sales terminal and Inventory");
        l2.setFont(new Font("Sans", Font.BOLD, 12));
        l2.setForeground(AMain.white);
        panel2.add(l2);
        panel1.add(panel2, BorderLayout.NORTH);
        
        
        
        panel3.setBackground(AMain.cream);
        panel3.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
        panel3.setLayout(null);
        l3.setText("Product name:");
        l3.setBounds(40, 20, 100, 20);
        panel3.add(l3);
        t1.setBounds(40, 40, 470, 30);
        panel3.add(t1);
        l4.setText("Product Code:");
        l4.setBounds(40, 80, 100, 20);
        panel3.add(l4);
        t2.setBounds(40, 100,350, 30);
        panel3.add(t2);
        b3.setBackground(AMain.green);
        b3.setText("Generate");
        b3.setFont(new Font("Serif", Font.BOLD, 16));
        b3.setForeground(AMain.black);
        b3.setBounds(400, 100, 110, 30);
        panel3.add(b3);
        l5.setText("Category");
        l5.setBounds(40, 140, 100, 20);
        panel3.add(l5);
        combo1.setBounds(40, 160, 225, 30);
        panel3.add(combo1);
        l6.setText("Supplier");
        l6.setBounds(285, 140, 100, 20);
        panel3.add(l6);
        combo2.setBounds(285, 160, 225, 30);
        panel3.add(combo2);
        l7.setText("Cost Price");
        l7.setBounds(40, 200, 100, 20);
        panel3.add(l7);
        t3.setBounds(40, 220, 150, 30);
        panel3.add(t3);
        l8.setText("Selling Price");
        l8.setBounds(40, 260, 100, 20);
        panel3.add(l8);
        t4.setBounds(40, 280, 150, 30);
        panel3.add(t4);
        l9.setText("Initial Stock");
        l9.setBounds(40, 320, 100, 20);
        panel3.add(l9);
        t5.setBounds(40, 340, 150, 30);
        panel3.add(t5);
        l10.setText("Low Stock Alert");
        l10.setBounds(40, 380, 100, 20);
        panel3.add(l10);
        t6.setBounds(40, 400, 150, 30);
        panel3.add(t6);
        
//        l11.setText("Product Image");
//        l11.setBounds(300, 220, 100, 100);
//        panel3.add(l11);
//        image.setBounds(270, 280, 150,150);
//        image.setBackground(Color.red);
//        panel3.add(image);
        
        
        panel1.add(panel3,BorderLayout.CENTER);
        
        
        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,70));
        panel4.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        b1.setBackground(AMain.white);
        b1.setText("Cancel");
        b1.setFont(new Font("Serif", Font.BOLD, 16));
        b1.setForeground(AMain.gold);
        b1.setPreferredSize(new Dimension(130,40));
        b1.setFocusPainted(false);
        b1.setFocusable(false);
        panel4.add(spacer1);
        panel4.add(b1);
        
        b2.setBackground(AMain.gold);
        b2.setText("Save Product");
        b2.setFont(new Font("Serif", Font.BOLD, 16));
        b2.setForeground(AMain.black);
        b2.setPreferredSize(new Dimension(150,40));
        b2.setFocusPainted(false);
        b2.setFocusable(false);
        panel4.add(b2);
        panel1.add(panel4, BorderLayout.SOUTH);
        
        
        
        
        panel1.setBackground(AMain.cream);
        frame.add(panel1);
        
        b3.addActionListener(new ActionListener(){
            Random rand = new Random();
            String inv = "PRDCT_ID-" + (rand.nextInt(1000000) + 1000000);
            String code = inv;
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
//            int counter = Ddatabase.product.size() + 1;
//            String counter2 = Integer.toString(counter);
            t2.setText(inv);
            }
        });
        
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
            
        });
        
        b2.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
            String code = t2.getText();
            String name = t1.getText();
            String category = (String) combo1.getSelectedItem();
            String supplier = (String) combo2.getSelectedItem();
            double cost = Double.parseDouble(t3.getText());
            double price = Double.parseDouble(t4.getText());
            int stock = Integer.parseInt(t5.getText());
            int lowAlert = Integer.parseInt(t6.getText());
                
            if(code.isEmpty() || name.isEmpty() || category.isEmpty() || 
                    supplier.isEmpty() || t3.getText().isEmpty()|| 
                    t4.getText().isEmpty()|| t5.getText().isEmpty()|| t6.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "complete all details");
                return;
            }
            
            if (price < cost) {
            JOptionPane.showMessageDialog(null, "Price should be higher than Cost to make profit","Math error", JOptionPane.INFORMATION_MESSAGE);
                }
            else if (stock <= lowAlert) {
            JOptionPane.showMessageDialog(null, "Stock should be higher than Low Stock Alert",
            "Math error", JOptionPane.INFORMATION_MESSAGE);
                }
            else {
            Ddatabase.Product prod = new Ddatabase.Product(code, name, category, supplier, cost, price, stock, lowAlert);
            Ddatabase.product.add(prod);
                System.out.println(Ddatabase.product.size());
                
                for (Ddatabase.Supplier s : Ddatabase.supplier) {
                    if (s.comName.equals(supplier)) {
                        s.purchases += cost * stock;
                        break;
                    }
                }
                
            Etabs.refreshTableProd();
            Etabs.refreshTableSup();   
            Etabs.refreshTableCat(); 
            frame.dispose();
                 }
                }
            catch(NumberFormatException ea){
                JOptionPane.showMessageDialog(null, "COST PRICE, SELLING PRICE, INITIAL STOCK, LOW STOCK ALERT should not include LETTERS", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
                Etabs.refreshTableProd();
            }
        });
        
        
        frame.setVisible(true);
        return frame;
    }
    public static JFrame addCategory(){
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel(new GridLayout(2,1));
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();

    JButton cancel = new JButton();
    JButton save = new JButton();

//    JButton b1 = new JButton();
//    JButton b2 = new JButton();
//    JButton b3 = new JButton();
//    JButton b4 = new JButton();
//    JButton b5 = new JButton();
//    JButton b6 = new JButton();

    JTextField t1 = new JTextField();

//    Color[] selected = {null};   

    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setTitle("Add Category");
    frame.setResizable(false);
    frame.setSize(550, 400);
    frame.setLocationRelativeTo(null);

    
    panel2.setBackground(AMain.green);
    panel2.setPreferredSize(new Dimension(0,70));
    panel2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
    l1.setText("Add Category");
    l1.setFont(new Font("Serif", Font.BOLD, 25));
    l1.setForeground(AMain.gold);
    panel2.add(l1);
    l2.setText("List your categories");
    l2.setFont(new Font("Sans", Font.BOLD, 12));
    l2.setForeground(AMain.white);
    panel2.add(l2);
    panel1.add(panel2, BorderLayout.NORTH);

    
    panel3.setBackground(AMain.cream);
    panel3.setLayout(null);

    l3.setText("Category name");
    l3.setBounds(40, 20, 150, 20);
    panel3.add(l3);
    t1.setBounds(40, 40, 470, 30);
    panel3.add(t1);

//    l4.setText("Pick a color");
//    l4.setBounds(40, 90, 150, 20);
//    panel3.add(l4);

    
//    b1.setBackground(AMain.green);
//    b1.setBounds(40, 115, 50, 50);
//    b1.setFocusPainted(false);
//    b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//    panel3.add(b1);
//
//    b2.setBackground(AMain.gold);
//    b2.setBounds(110, 115, 50, 50);
//    b2.setFocusPainted(false);
//    b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//    panel3.add(b2);
//
//    b3.setBackground(AMain.gray);
//    b3.setBounds(180, 115, 50, 50);
//    b3.setFocusPainted(false);
//    b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//    panel3.add(b3);
//
//    b4.setBackground(AMain.cream);
//    b4.setBounds(250, 115, 50, 50);
//    b4.setFocusPainted(false);
//    b4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//    panel3.add(b4);
//
//    b5.setBackground(AMain.lgreen);
//    b5.setBounds(320, 115, 50, 50);
//    b5.setFocusPainted(false);
//    b5.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//    panel3.add(b5);
//
//    b6.setBackground(AMain.dgold);
//    b6.setBounds(390, 115, 50, 50);
//    b6.setFocusPainted(false);
//    b6.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//    panel3.add(b6);
//
    panel1.add(panel3, BorderLayout.CENTER);
    
    panel4.setBackground(AMain.green);
    panel4.setPreferredSize(new Dimension(0,70));
    panel4.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

    cancel.setBackground(AMain.white);
    cancel.setText("Cancel");
    cancel.setFont(new Font("Serif", Font.BOLD, 16));
    cancel.setForeground(AMain.gold);
    cancel.setPreferredSize(new Dimension(130,40));
    cancel.setFocusPainted(false);
    cancel.setFocusable(false);
    panel4.add(cancel);

    save.setBackground(AMain.gold);
    save.setText("Save Category");
    save.setFont(new Font("Serif", Font.BOLD, 16));
    save.setForeground(AMain.black);
    save.setPreferredSize(new Dimension(150,40));
    save.setFocusPainted(false);
    save.setFocusable(false);
    panel4.add(save);
    panel1.add(panel4, BorderLayout.SOUTH);

    panel1.setBackground(AMain.cream);
    frame.add(panel1);

    
//    b1.addActionListener(new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            selected[0] = AMain.green;
//        }
//    });
//    b2.addActionListener(new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            selected[0] = AMain.gold;
//        }
//    });
//    b3.addActionListener(new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            selected[0] = AMain.gray;
//        }
//    });
//    b4.addActionListener(new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            selected[0] = AMain.cream;
//        }
//    });
//    b5.addActionListener(new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            selected[0] = AMain.lgreen;
//        }
//    });
//    b6.addActionListener(new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            selected[0] = AMain.dgold;
//        }
//    });

    
    
    cancel.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    });

    save.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = t1.getText().trim();

            if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter a category name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (Ddatabase.Category c : Ddatabase.category) {
            if (c.categoryname.equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(null, "That category already exists.", "Duplicate", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        Ddatabase.Category cat = new Ddatabase.Category(name,0,0);
        cat.categoryname = name;
        Ddatabase.category.add(cat);
        Etabs.categorynames.addRow(new Object[]{cat.categoryname,0,0});
        Etabs.refreshTableCat();
        frame.dispose();
        }
    });
    frame.setVisible(true);
    return frame;
    }
    public static JFrame addSupplier(){
        JFrame frame = new JFrame();
    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel(new GridLayout(2,1));
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();
    JLabel l6 = new JLabel();
    JLabel l7 = new JLabel();
//    JLabel l8 = new JLabel();

    JButton cancel = new JButton();
    JButton save = new JButton();

    JTextField t1 = new JTextField();   // company name
    JTextField t2 = new JTextField();   // manager name
    JTextField t3 = new JTextField();   // location
    JTextField t4 = new JTextField();   // phone
    JTextField t5 = new JTextField();   // email
    JTextField t6 = new JTextField();   // purchases

    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setTitle("Add Supplier");
    frame.setResizable(false);
    frame.setSize(550, 440);
    frame.setLocationRelativeTo(null);

    // HEADER
    panel2.setBackground(AMain.green);
    panel2.setPreferredSize(new Dimension(0,70));
    panel2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
    l1.setText("Add Supplier");
    l1.setFont(new Font("Serif", Font.BOLD, 25));
    l1.setForeground(AMain.gold);
    panel2.add(l1);
    l2.setText("List your suppliers");
    l2.setFont(new Font("Sans", Font.BOLD, 12));
    l2.setForeground(AMain.white);
    panel2.add(l2);
    panel1.add(panel2, BorderLayout.NORTH);

    // CENTER
    panel3.setBackground(AMain.cream);
    panel3.setLayout(null);

    l3.setText("Company name");
    l3.setBounds(40, 20, 150, 20);
    panel3.add(l3);
    t1.setBounds(40, 40, 470, 30);
    panel3.add(t1);

    l4.setText("Manager name");
    l4.setBounds(40, 80, 150, 20);
    panel3.add(l4);
    t2.setBounds(40, 100, 470, 30);
    panel3.add(t2);

    l5.setText("Location");
    l5.setBounds(40, 140, 150, 20);
    panel3.add(l5);
    t3.setBounds(40, 160, 470, 30);
    panel3.add(t3);

    l6.setText("Phone");
    l6.setBounds(40, 200, 150, 20);
    panel3.add(l6);
    t4.setBounds(40, 220, 225, 30);
    panel3.add(t4);

    l7.setText("Email");
    l7.setBounds(285, 200, 150, 20);
    panel3.add(l7);
    t5.setBounds(285, 220, 225, 30);
    panel3.add(t5);

//    l8.setText("Purchases");
//    l8.setBounds(40, 260, 150, 20);
//    panel3.add(l8);
//    t6.setText("0");
//    t6.setBounds(40, 280, 225, 30);
//    panel3.add(t6);

    panel1.add(panel3, BorderLayout.CENTER);

    // FOOTER
    panel4.setBackground(AMain.green);
    panel4.setPreferredSize(new Dimension(0,70));
    panel4.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

    cancel.setBackground(AMain.white);
    cancel.setText("Cancel");
    cancel.setFont(new Font("Serif", Font.BOLD, 16));
    cancel.setForeground(AMain.gold);
    cancel.setPreferredSize(new Dimension(130,40));
    cancel.setFocusPainted(false);
    cancel.setFocusable(false);
    panel4.add(cancel);

    save.setBackground(AMain.gold);
    save.setText("Save Supplier");
    save.setFont(new Font("Serif", Font.BOLD, 16));
    save.setForeground(AMain.black);
    save.setPreferredSize(new Dimension(150,40));
    save.setFocusPainted(false);
    save.setFocusable(false);
    panel4.add(save);
    panel1.add(panel4, BorderLayout.SOUTH);

    panel1.setBackground(AMain.cream);
    frame.add(panel1);

    // ACTIONS
    cancel.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    });

    save.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String comName = t1.getText().trim();
            String manName = t2.getText().trim();
            String loc = t3.getText().trim();
            String phone = t4.getText().trim();
            String email = t5.getText().trim();

            if (comName.isEmpty() || manName.isEmpty() || loc.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!phone.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Phone should only contain numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(null, "Enter a valid email.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Ddatabase.Supplier s : Ddatabase.supplier) {
                if (s.comName.equalsIgnoreCase(comName)) {
                    JOptionPane.showMessageDialog(null, "That supplier already exists.", "Duplicate", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            int purchase = 0;
            Ddatabase.Supplier sup = new Ddatabase.Supplier(comName, manName, loc, phone, email, purchase);
            Ddatabase.supplier.add(sup);
            Etabs.refreshTableSup();
           
            frame.dispose();
        }
    });

    frame.setVisible(true);
    return frame;
    }
    public static JFrame addEmployee(){
        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridLayout(2,1));
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel("Employee name");
        JLabel l4 = new JLabel("Position");
        JLabel l5 = new JLabel("Email");
        JLabel l6 = new JLabel("Phone number");
        JLabel l7 = new JLabel("Username");
        JLabel l8 = new JLabel("Password");
        JLabel l9 = new JLabel("Confirm Password");
        
        JButton cancel = new JButton();
        JButton save = new JButton();

        JTextField t1 = new JTextField();          // name
        JTextField t2 = new JTextField();          // position
        JTextField t3 = new JTextField();          // email
        JTextField t4 = new JTextField();          // phone
        JTextField t5 = new JTextField();          // username
        JPasswordField t6 = new JPasswordField();  // password
        JPasswordField t7 = new JPasswordField();  // confirm

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setTitle("Add Employee");
        frame.setResizable(false);
        frame.setSize(550, 570);
        frame.setLocationRelativeTo(null);
        
        
        panel2.setBackground(AMain.green);
        panel2.setPreferredSize(new Dimension(0,70));
        panel2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        l1.setText("Add Employee");
        l1.setFont(new Font("Serif", Font.BOLD, 25));
        l1.setForeground(AMain.gold);
        panel2.add(l1);
        l2.setText("List your employees");
        l2.setFont(new Font("Sans", Font.BOLD, 12));
        l2.setForeground(AMain.white);
        panel2.add(l2);
        panel1.add(panel2, BorderLayout.NORTH);

        
        panel3.setBackground(AMain.cream);
        panel3.setLayout(null);

        l3.setBounds(40, 20, 150, 20);
        panel3.add(l3);
        t1.setBounds(40, 40, 470, 30);
        panel3.add(t1);

        l4.setBounds(40, 80, 150, 20);
        panel3.add(l4);
        t2.setBounds(40, 100, 470, 30);
        panel3.add(t2);

        l5.setBounds(40, 140, 150, 20);
        panel3.add(l5);
        t3.setBounds(40, 160, 225, 30);
        panel3.add(t3);

        l6.setBounds(285, 140, 150, 20);
        panel3.add(l6);
        t4.setBounds(285, 160, 225, 30);
        panel3.add(t4);

        l7.setBounds(40, 200, 150, 20);
        panel3.add(l7);
        t5.setBounds(40, 220, 225, 30);
        panel3.add(t5);

        l8.setBounds(285, 200, 150, 20);
        panel3.add(l8);
        t6.setBounds(285, 220, 225, 30);
        panel3.add(t6);
        
        l9.setBounds(40, 260, 150, 20);
        panel3.add(l9);
        t7.setBounds(40, 280, 225, 30);
        panel3.add(t7);

        JLabel lblRole = new JLabel("Set as:");
        JRadioButton rbEmployee = new JRadioButton();
        JRadioButton rbAdmin = new JRadioButton();
        JLabel lblRbEmployee = new JLabel("Employee");
        JLabel lblRbAdmin = new JLabel("Admin");
        ButtonGroup roleGroup = new ButtonGroup();

        roleGroup.add(rbEmployee);
        roleGroup.add(rbAdmin);
        rbEmployee.setSelected(true);   

        lblRole.setBounds(40, 340, 150, 20);
        lblRole.setFont(new Font("Sans", Font.BOLD, 13));
        panel3.add(lblRole);

        rbEmployee.setBounds(40, 360, 20, 20);
        rbEmployee.setBackground(AMain.cream);
        panel3.add(rbEmployee);
        lblRbEmployee.setBounds(65, 360, 80, 20);
        panel3.add(lblRbEmployee);

        rbAdmin.setBounds(160, 360, 20, 20);
        rbAdmin.setBackground(AMain.cream);
        panel3.add(rbAdmin);
        lblRbAdmin.setBounds(185, 360, 80, 20);
        panel3.add(lblRbAdmin);
        
        panel1.add(panel3, BorderLayout.CENTER);

        
        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,70));
        panel4.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        cancel.setBackground(AMain.white);
        cancel.setText("Cancel");
        cancel.setFont(new Font("Serif", Font.BOLD, 16));
        cancel.setForeground(AMain.gold);
        cancel.setPreferredSize(new Dimension(130,40));
        cancel.setFocusPainted(false);
        cancel.setFocusable(false);
        panel4.add(cancel);

        save.setBackground(AMain.gold);
        save.setText("Save Employee");
        save.setFont(new Font("Serif", Font.BOLD, 16));
        save.setForeground(AMain.black);
        save.setPreferredSize(new Dimension(160,40));
        save.setFocusPainted(false);
        save.setFocusable(false);
        panel4.add(save);
        panel1.add(panel4, BorderLayout.SOUTH);

        panel1.setBackground(AMain.cream);
        frame.add(panel1);

        // ACTIONS
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText().trim();
                String position = t2.getText().trim();
                String email = t3.getText().trim();
                String phone = t4.getText().trim();
                String username = t5.getText().trim();
                String password = new String(t6.getPassword());
                String confirm = new String(t7.getPassword());
                
                
                if (name.isEmpty() || position.isEmpty() || email.isEmpty() || phone.isEmpty()|| username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!phone.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Phone should only contain numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!email.contains("@") || !email.contains(".")) {
                    JOptionPane.showMessageDialog(null, "Enter a valid email.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!password.equals(confirm)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    t7.setText("");
                    return;
                }
                for (Ddatabase.Employee emp : Ddatabase.employee) {
                    if (emp.username.equalsIgnoreCase(username)) {
                        JOptionPane.showMessageDialog(null, "That username is already taken.", "Duplicate", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                for (Ddatabase.Admin ad : Ddatabase.admin) {
                    if (ad.username.equalsIgnoreCase(username)) {
                        JOptionPane.showMessageDialog(null, "That username is already taken.", "Duplicate", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }

                if (rbAdmin.isSelected()) {
                Ddatabase.Admin adm = new Ddatabase.Admin("Admin", name, position, email, phone, username, password);
                Ddatabase.admin.add(adm);
                }
                else{
                Ddatabase.Employee emp = new Ddatabase.Employee("Employee", name, position, email, phone, username, password);
                Ddatabase.employee.add(emp);
                }
                Etabs.refreshTableEmployee();
                frame.dispose();
            }
        });

        frame.setVisible(true);
        return frame;
    }
    public static JFrame editProduct(){
    if (Ddatabase.product.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No products to edit. Add a product first.");
        return null;
    }

    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel(new GridLayout(2,1));
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();
    JLabel l6 = new JLabel();
    JLabel l7 = new JLabel();
    JLabel l8 = new JLabel();
    JLabel l9 = new JLabel();
    JLabel l10 = new JLabel();
    JLabel l11 = new JLabel();
    JLabel l12 = new JLabel();
    JLabel spacer1 = new JLabel("");

    JButton b1 = new JButton();   // CAncel
    JButton b2 = new JButton();   // save
    JButton b3 = new JButton();   // delet
    JButton image = new JButton();

    JTextField t1 = new JTextField();   // Name
    JTextField t2 = new JTextField();  // code
    JTextField t3 = new JTextField();     // cost
    JTextField t4 = new JTextField();   // price
    JTextField t5 = new JTextField();   // stock
    JTextField t6 = new JTextField();   // low alert

    JComboBox combo0 = new JComboBox();   // select product
    JComboBox combo1 = new JComboBox();   // category
    JComboBox combo2 = new JComboBox();   // suplier

    //combobox
    for (Ddatabase.Category c : Ddatabase.category) {
        combo1.addItem(c.categoryname);
    }
    for (Ddatabase.Supplier s : Ddatabase.supplier) {
        combo2.addItem(s.comName);
    }

    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setTitle("Edit Products");
    frame.setResizable(false);
    frame.setSize(550,700);
    frame.setLocationRelativeTo(null);

    
    panel2.setBackground(AMain.green);
    panel2.setPreferredSize(new Dimension(0,70));
    panel2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
    l1.setText("Edit Product");
    l1.setFont(new Font("Serif", Font.BOLD, 25));
    l1.setForeground(AMain.gold);
    panel2.add(l1);
    l2.setText("Update or remove an item from Sales terminal and Inventory");
    l2.setFont(new Font("Sans", Font.BOLD, 12));
    l2.setForeground(AMain.white);
    panel2.add(l2);
    panel1.add(panel2, BorderLayout.NORTH);

    
    panel3.setBackground(AMain.cream);
    panel3.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
    panel3.setLayout(null);

    l12.setText("Select Product:");
    l12.setBounds(40, 20, 100, 20);
    panel3.add(l12);
    combo0.setBounds(40, 40, 470, 30);
    panel3.add(combo0);

    l3.setText("Product name:");
    l3.setBounds(40, 80, 100, 20);
    panel3.add(l3);
    t1.setBounds(40, 100, 470, 30);
    panel3.add(t1);
    l4.setText("Product Code:");
    l4.setBounds(40, 140, 100, 20);
    panel3.add(l4);
    t2.setBounds(40, 160, 470, 30);
    t2.setEditable(true);   
    panel3.add(t2);
    l5.setText("Category");
    l5.setBounds(40, 200, 100, 20);
    panel3.add(l5);
    combo1.setBounds(40, 220, 225, 30);
    panel3.add(combo1);
    l6.setText("Supplier");
    l6.setBounds(285, 200, 100, 20);
    panel3.add(l6);
    combo2.setBounds(285, 220, 225, 30);
    panel3.add(combo2);
    l7.setText("Cost Price");
    l7.setBounds(40, 260, 100, 20);
    panel3.add(l7);
    t3.setBounds(40, 280, 150, 30);
    panel3.add(t3);
    l8.setText("Selling Price");
    l8.setBounds(40, 320, 100, 20);
    panel3.add(l8);
    t4.setBounds(40, 340, 150, 30);
    panel3.add(t4);
    l9.setText("Stock");
    l9.setBounds(40, 380, 100, 20);
    panel3.add(l9);
    t5.setBounds(40, 400, 150, 30);
    panel3.add(t5);
    l10.setText("Low Stock Alert");
    l10.setBounds(40, 440, 100, 20);
    panel3.add(l10);
    t6.setBounds(40, 460, 150, 30);
    panel3.add(t6);

    l11.setText("Product Image");
    l11.setBounds(300, 280, 100, 100);
    panel3.add(l11);
    image.setBounds(270, 340, 150,150);
    image.setBackground(Color.red);
    panel3.add(image);

    panel1.add(panel3,BorderLayout.CENTER);

    
    panel4.setBackground(AMain.green);
    panel4.setPreferredSize(new Dimension(0,70));
    panel4.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

    b1.setBackground(AMain.white);
    b1.setText("Cancel");
    b1.setFont(new Font("Serif", Font.BOLD, 16));
    b1.setForeground(AMain.gold);
    b1.setPreferredSize(new Dimension(130,40));
    b1.setFocusPainted(false);
    b1.setFocusable(false);
    panel4.add(spacer1);
    panel4.add(b1);

    b3.setBackground(Color.red);
    b3.setText("Delete");
    b3.setFont(new Font("Serif", Font.BOLD, 16));
    b3.setForeground(AMain.white);
    b3.setPreferredSize(new Dimension(130,40));
    b3.setFocusPainted(false);
    b3.setFocusable(false);
    panel4.add(b3);

    b2.setBackground(AMain.gold);
    b2.setText("Save Changes");
    b2.setFont(new Font("Serif", Font.BOLD, 16));
    b2.setForeground(AMain.black);
    b2.setPreferredSize(new Dimension(150,40));
    b2.setFocusPainted(false);
    b2.setFocusable(false);
    panel4.add(b2);
    panel1.add(panel4, BorderLayout.SOUTH);

    panel1.setBackground(AMain.cream);
    frame.add(panel1);

    // buttons na

    // pag nag-select ng product, i-fill yung fields like sa  ADD PRODUCT BUT EDIT TO // I OOVERRIDE LNG
    combo0.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = combo0.getSelectedIndex();
            if (index < 0) {
                return;
            }
            Ddatabase.Product p = Ddatabase.product.get(index);
            t1.setText(p.name);
            t2.setText(p.code);
            combo1.setSelectedItem(p.category);
            combo2.setSelectedItem(p.supplier);
            t3.setText(String.valueOf(p.cost));
            t4.setText(String.valueOf(p.price));
            t5.setText(String.valueOf(p.stock));
            t6.setText(String.valueOf(p.lowAlert));
        }
    });

    b1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    });

    b2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                int index = combo0.getSelectedIndex();
                String name = t1.getText().trim();
                String category = (String) combo1.getSelectedItem();
                String supplier = (String) combo2.getSelectedItem();
                double cost = Double.parseDouble(t3.getText().trim());
                double price = Double.parseDouble(t4.getText().trim());
                int stock = Integer.parseInt(t5.getText().trim());
                int lowAlert = Integer.parseInt(t6.getText().trim());

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter a product name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (price < cost) {
                    JOptionPane.showMessageDialog(null, "Price should be higher than Cost to make profit","Math error", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (stock <= lowAlert) {
                    JOptionPane.showMessageDialog(null, "Stock should be higher than Low Stock Alert",
                    "Math error", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    Ddatabase.Product p = Ddatabase.product.get(index);
                    p.name = name;
                    p.category = category;
                    p.supplier = supplier;
                    p.cost = cost;
                    p.price = price;
                    p.stock = stock;
                    p.lowAlert = lowAlert;
                    Etabs.refreshTableProd();
                    frame.dispose();
                }
            }
            catch(NumberFormatException ea){
                JOptionPane.showMessageDialog(null, "COST PRICE, SELLING PRICE, STOCK, LOW STOCK ALERT should not include LETTERS", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    b3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = combo0.getSelectedIndex();
            String name = (String) combo0.getSelectedItem();
            int confirm = JOptionPane.showConfirmDialog(null, "Delete \"" + name + "\"? This cannot be undone.", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                Ddatabase.product.remove(index);
                Etabs.refreshTableProd();
                frame.dispose();
            }
        }
    });

    for (Ddatabase.Product p : Ddatabase.product) {
        combo0.addItem(p.name);
    }

    frame.setVisible(true);
    return frame;
}
    
    public static JFrame editsupplier(){
        if (Ddatabase.supplier.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No suppliers to edit. Add a supplier first.");
            return null;
        }

        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridLayout(2,1));
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();   
        JLabel l4 = new JLabel();   
        JLabel l5 = new JLabel();   
        JLabel l6 = new JLabel();   
        JLabel l7 = new JLabel();   
        JLabel l8 = new JLabel();  
        JLabel l9 = new JLabel();   
        JLabel spacer1 = new JLabel("");

        JButton b1 = new JButton();   
        JButton b2 = new JButton();  
        JButton b3 = new JButton();  

        JTextField t1 = new JTextField();   
        JTextField t2 = new JTextField();   
        JTextField t3 = new JTextField();   
        JTextField t4 = new JTextField();   
        JTextField t5 = new JTextField(); 
        JTextField t6 = new JTextField();   

        JComboBox combo0 = new JComboBox();   

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setTitle("Edit Supplier");
        frame.setResizable(false);
        frame.setSize(550,620);
        frame.setLocationRelativeTo(null);

       
        
        panel2.setBackground(AMain.green);
        panel2.setPreferredSize(new Dimension(0,70));
        panel2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        l1.setText("Edit Supplier");
        l1.setFont(new Font("Serif", Font.BOLD, 25));
        l1.setForeground(AMain.gold);
        panel2.add(l1);
        l2.setText("Update or remove a supplier from Inventory");
        l2.setFont(new Font("Sans", Font.BOLD, 12));
        l2.setForeground(AMain.white);
        panel2.add(l2);
        panel1.add(panel2, BorderLayout.NORTH);

        
        
        panel3.setBackground(AMain.cream);
        panel3.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
        panel3.setLayout(null);

        l3.setText("Select Supplier:");
        l3.setBounds(40, 20, 150, 20);
        panel3.add(l3);
        combo0.setBounds(40, 40, 470, 30);
        panel3.add(combo0);

        l4.setText("Company Name:");
        l4.setBounds(40, 80, 150, 20);
        panel3.add(l4);
        t1.setBounds(40, 100, 470, 30);
        panel3.add(t1);

        l5.setText("Manager Name:");
        l5.setBounds(40, 140, 150, 20);
        panel3.add(l5);
        t2.setBounds(40, 160, 470, 30);
        panel3.add(t2);

        l6.setText("Location:");
        l6.setBounds(40, 200, 150, 20);
        panel3.add(l6);
        t3.setBounds(40, 220, 470, 30);
        panel3.add(t3);

        l7.setText("Phone:");
        l7.setBounds(40, 260, 150, 20);
        panel3.add(l7);
        t4.setBounds(40, 280, 225, 30);
        panel3.add(t4);

        l8.setText("Email:");
        l8.setBounds(285, 260, 150, 20);
        panel3.add(l8);
        t5.setBounds(285, 280, 225, 30);
        panel3.add(t5);

        l9.setText("Total Purchases:");
        l9.setBounds(40, 320, 150, 20);
        panel3.add(l9);
        t6.setBounds(40, 340, 150, 30);
        t6.setEditable(false);          
        panel3.add(t6);

        panel1.add(panel3, BorderLayout.CENTER);

        
        
        
        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,70));
        panel4.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        b1.setBackground(AMain.white);
        b1.setText("Cancel");
        b1.setFont(new Font("Serif", Font.BOLD, 16));
        b1.setForeground(AMain.gold);
        b1.setPreferredSize(new Dimension(130,40));
        b1.setFocusPainted(false);
        b1.setFocusable(false);
        panel4.add(spacer1);
        panel4.add(b1);

        b3.setBackground(Color.red);
        b3.setText("Delete");
        b3.setFont(new Font("Serif", Font.BOLD, 16));
        b3.setForeground(AMain.white);
        b3.setPreferredSize(new Dimension(130,40));
        b3.setFocusPainted(false);
        b3.setFocusable(false);
        panel4.add(b3);

        b2.setBackground(AMain.gold);
        b2.setText("Save Changes");
        b2.setFont(new Font("Serif", Font.BOLD, 16));
        b2.setForeground(AMain.black);
        b2.setPreferredSize(new Dimension(150,40));
        b2.setFocusPainted(false);
        b2.setFocusable(false);
        panel4.add(b2);
        panel1.add(panel4, BorderLayout.SOUTH);

        panel1.setBackground(AMain.cream);
        frame.add(panel1);

        // when a supplier is selected, fill the fields
        combo0.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = combo0.getSelectedIndex();
                if (index < 0) {
                    return;
                }
                Ddatabase.Supplier s = Ddatabase.supplier.get(index);
                t1.setText(s.comName);
                t2.setText(s.manName);
                t3.setText(s.loc);
                t4.setText(s.phone);
                t5.setText(s.email);
                t6.setText(String.valueOf(s.purchases));
            }
        });

        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = combo0.getSelectedIndex();
                if (index < 0) {
                    return;
                }
                String comName = t1.getText().trim();
                String manName = t2.getText().trim();
                String loc = t3.getText().trim();
                String phone = t4.getText().trim();
                String email = t5.getText().trim();

                Ddatabase.Supplier current = Ddatabase.supplier.get(index);

                // duplicate company name check (ignore the supplier being edited)
                boolean duplicate = false;
                for (int i = 0; i < Ddatabase.supplier.size(); i++) {
                    if (i != index && Ddatabase.supplier.get(i).comName.equalsIgnoreCase(comName)) {
                        duplicate = true;
                        break;
                    }
                }

                if (comName.isEmpty() || manName.isEmpty() || loc.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (duplicate) {
                    JOptionPane.showMessageDialog(null, "A supplier with that company name already exists.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!phone.matches("[0-9+\\- ]+")) {
                    JOptionPane.showMessageDialog(null, "PHONE should only contain numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!email.contains("@") || !email.contains(".")) {
                    JOptionPane.showMessageDialog(null, "Enter a valid email address.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    String oldName = current.comName;

                    current.comName = comName;
                    current.manName = manName;
                    current.loc = loc;
                    current.phone = phone;
                    current.email = email;

                    // keep products linked to this supplier if the company name changed
                    if (!oldName.equals(comName)) {
                        for (Ddatabase.Product p : Ddatabase.product) {
                            if (p.supplier != null && p.supplier.equals(oldName)) {
                                p.supplier = comName;
                            }
                        }
                        Etabs.refreshTableProd();
                    }

                    Etabs.refreshTableSup();   // <-- use your actual supplier table refresh method
                    frame.dispose();
                }
            }
        });

        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = combo0.getSelectedIndex();
                if (index < 0) {
                    return;
                }
                String name = (String) combo0.getSelectedItem();

                // block deleting a supplier that still has products
                for (Ddatabase.Product p : Ddatabase.product) {
                    if (p.supplier != null && p.supplier.equals(name)) {
                        JOptionPane.showMessageDialog(null,
                            "\"" + name + "\" still supplies product \"" + p.name + "\".\nReassign or delete those products first.",
                            "Cannot Delete", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                int confirm = JOptionPane.showConfirmDialog(null, "Delete \"" + name + "\"? This cannot be undone.", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    Ddatabase.supplier.remove(index);
                    Etabs.refreshTableSup();  
                    frame.dispose();
                }
            }
        });

        for (Ddatabase.Supplier s : Ddatabase.supplier) {
            combo0.addItem(s.comName);
        }

        frame.setVisible(true);
        return frame;
}
    public static JFrame editCategory(){
        // index 0 is "All Categories", so we need at least 2 items
        if (Ddatabase.category.size() <= 1) {
            JOptionPane.showMessageDialog(null, "No categories to edit. Add a category first.");
            return null;
        }

        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridLayout(2,1));
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();   // select category
        JLabel l4 = new JLabel();   // category name
        JLabel spacer1 = new JLabel("");

        JButton b1 = new JButton();   // cancel
        JButton b2 = new JButton();   // save
        JButton b3 = new JButton();   // delete

        JTextField t1 = new JTextField();   // category name

        JComboBox combo0 = new JComboBox();   // select category

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setTitle("Edit Category");
        frame.setResizable(false);
        frame.setSize(550,360);
        frame.setLocationRelativeTo(null);

        // HEADER
        panel2.setBackground(AMain.green);
        panel2.setPreferredSize(new Dimension(0,70));
        panel2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        l1.setText("Edit Category");
        l1.setFont(new Font("Serif", Font.BOLD, 25));
        l1.setForeground(AMain.gold);
        panel2.add(l1);
        l2.setText("Rename or remove a category");
        l2.setFont(new Font("Sans", Font.BOLD, 12));
        l2.setForeground(AMain.white);
        panel2.add(l2);
        panel1.add(panel2, BorderLayout.NORTH);

        // CENTER
        panel3.setBackground(AMain.cream);
        panel3.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
        panel3.setLayout(null);

        l3.setText("Select Category:");
        l3.setBounds(40, 20, 150, 20);
        panel3.add(l3);
        combo0.setBounds(40, 40, 470, 30);
        panel3.add(combo0);

        l4.setText("Category name:");
        l4.setBounds(40, 80, 150, 20);
        panel3.add(l4);
        t1.setBounds(40, 100, 470, 30);
        panel3.add(t1);

        panel1.add(panel3, BorderLayout.CENTER);

        // BUTTONS
        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,70));
        panel4.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        b1.setBackground(AMain.white);
        b1.setText("Cancel");
        b1.setFont(new Font("Serif", Font.BOLD, 16));
        b1.setForeground(AMain.gold);
        b1.setPreferredSize(new Dimension(130,40));
        b1.setFocusPainted(false);
        b1.setFocusable(false);
        panel4.add(spacer1);
        panel4.add(b1);

        b3.setBackground(Color.red);
        b3.setText("Delete");
        b3.setFont(new Font("Serif", Font.BOLD, 16));
        b3.setForeground(AMain.white);
        b3.setPreferredSize(new Dimension(130,40));
        b3.setFocusPainted(false);
        b3.setFocusable(false);
        panel4.add(b3);

        b2.setBackground(AMain.gold);
        b2.setText("Save Changes");
        b2.setFont(new Font("Serif", Font.BOLD, 16));
        b2.setForeground(AMain.black);
        b2.setPreferredSize(new Dimension(150,40));
        b2.setFocusPainted(false);
        b2.setFocusable(false);
        panel4.add(b2);
        panel1.add(panel4, BorderLayout.SOUTH);

        panel1.setBackground(AMain.cream);
        frame.add(panel1);

        // ACTIONS

        // fill the field when a category is selected
        combo0.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = combo0.getSelectedIndex();
                if (index < 0) {
                    return;
                }
                // +1 because "All Categories" is skipped in the combo box
                Ddatabase.Category c = Ddatabase.category.get(index + 1);
                t1.setText(c.categoryname);
            }
        });

        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = combo0.getSelectedIndex() + 1;
                String newName = t1.getText().trim();
                String oldName = Ddatabase.category.get(index).categoryname;

                if (newName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter a category name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // check duplicate (ignore the category we are editing)
                for (int i = 0; i < Ddatabase.category.size(); i++) {
                    if (i != index && Ddatabase.category.get(i).categoryname.equalsIgnoreCase(newName)) {
                        JOptionPane.showMessageDialog(null, "That category already exists.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                Ddatabase.category.get(index).categoryname = newName;

                // keep products in sync if the name changed
                for (Ddatabase.Product p : Ddatabase.product) {
                    if (p.category.equals(oldName)) {
                        p.category = newName;
                    }
                }

                Etabs.refreshTableCat();
                Etabs.refreshTableProd();
                frame.dispose();
            }
        });

        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = combo0.getSelectedIndex() + 1;
                String name = (String) combo0.getSelectedItem();

                // don't allow delete if a product still uses this category
                for (Ddatabase.Product p : Ddatabase.product) {
                    if (p.category.equals(name)) {
                        JOptionPane.showMessageDialog(null, "Can't delete \"" + name + "\". Some products still use this category.", "Delete Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                int confirm = JOptionPane.showConfirmDialog(null, "Delete \"" + name + "\"? This cannot be undone.", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    Ddatabase.category.remove(index);
                    Etabs.refreshTableCat();
                    frame.dispose();
                }
            }
        });

        // fill the combo box last, skipping "All Categories" (index 0)
        for (int i = 1; i < Ddatabase.category.size(); i++) {
            combo0.addItem(Ddatabase.category.get(i).categoryname);
        }

        frame.setVisible(true);
        return frame;
    }
    public static JFrame editEmployee(){
        if (Ddatabase.employee.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No employees to edit. Add an employee first.");
            return null;
        }

        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridLayout(2,1));
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel("Select Employee:");
        JLabel l4 = new JLabel("Employee name:");
        JLabel l5 = new JLabel("Position:");
        JLabel l6 = new JLabel("Email:");
        JLabel l7 = new JLabel("Phone number:");
        JLabel l8 = new JLabel("Username:");
        JLabel l9 = new JLabel("Password:");
        JLabel spacer1 = new JLabel("");

        JButton b1 = new JButton();   // cancel
        JButton b2 = new JButton();   // save
        JButton b3 = new JButton();   // delete

        JTextField t1 = new JTextField();          // name
        JTextField t2 = new JTextField();          // position
        JTextField t3 = new JTextField();          // email
        JTextField t4 = new JTextField();          // phone
        JTextField t5 = new JTextField();          // username
        JPasswordField t6 = new JPasswordField();  // password

        JComboBox combo0 = new JComboBox();

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setTitle("Edit Employee");
        frame.setResizable(false);
        frame.setSize(550, 580);
        frame.setLocationRelativeTo(null);

        // HEADER
        panel2.setBackground(AMain.green);
        panel2.setPreferredSize(new Dimension(0,70));
        panel2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        l1.setText("Edit Employee");
        l1.setFont(new Font("Serif", Font.BOLD, 25));
        l1.setForeground(AMain.gold);
        panel2.add(l1);
        l2.setText("Update or remove an employee");
        l2.setFont(new Font("Sans", Font.BOLD, 12));
        l2.setForeground(AMain.white);
        panel2.add(l2);
        panel1.add(panel2, BorderLayout.NORTH);

        // CENTER
        panel3.setBackground(AMain.cream);
        panel3.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
        panel3.setLayout(null);

        l3.setBounds(40, 20, 150, 20);
        panel3.add(l3);
        combo0.setBounds(40, 40, 470, 30);
        panel3.add(combo0);

        l4.setBounds(40, 80, 150, 20);
        panel3.add(l4);
        t1.setBounds(40, 100, 470, 30);
        panel3.add(t1);

        l5.setBounds(40, 140, 150, 20);
        panel3.add(l5);
        t2.setBounds(40, 160, 470, 30);
        panel3.add(t2);

        l6.setBounds(40, 200, 150, 20);
        panel3.add(l6);
        t3.setBounds(40, 220, 225, 30);
        panel3.add(t3);

        l7.setBounds(285, 200, 150, 20);
        panel3.add(l7);
        t4.setBounds(285, 220, 225, 30);
        panel3.add(t4);

        l8.setBounds(40, 260, 150, 20);
        panel3.add(l8);
        t5.setBounds(40, 280, 225, 30);
        panel3.add(t5);

        l9.setBounds(285, 260, 150, 20);
        panel3.add(l9);
        t6.setBounds(285, 280, 225, 30);
        panel3.add(t6);

        panel1.add(panel3, BorderLayout.CENTER);

        // FOOTER
        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,70));
        panel4.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        b1.setBackground(AMain.white);
        b1.setText("Cancel");
        b1.setFont(new Font("Serif", Font.BOLD, 16));
        b1.setForeground(AMain.gold);
        b1.setPreferredSize(new Dimension(130,40));
        b1.setFocusPainted(false);
        b1.setFocusable(false);
        panel4.add(spacer1);
        panel4.add(b1);

        b3.setBackground(Color.red);
        b3.setText("Delete");
        b3.setFont(new Font("Serif", Font.BOLD, 16));
        b3.setForeground(AMain.white);
        b3.setPreferredSize(new Dimension(130,40));
        b3.setFocusPainted(false);
        b3.setFocusable(false);
        panel4.add(b3);

        b2.setBackground(AMain.gold);
        b2.setText("Save Changes");
        b2.setFont(new Font("Serif", Font.BOLD, 16));
        b2.setForeground(AMain.black);
        b2.setPreferredSize(new Dimension(150,40));
        b2.setFocusPainted(false);
        b2.setFocusable(false);
        panel4.add(b2);
        panel1.add(panel4, BorderLayout.SOUTH);

        panel1.setBackground(AMain.cream);
        frame.add(panel1);

        // ACTIONS
        combo0.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = combo0.getSelectedIndex();
                if (index < 0) {
                    return;
                }
                Ddatabase.Employee emp = Ddatabase.employee.get(index);
                t1.setText(emp.name);
                t2.setText(emp.position);
                t3.setText(emp.email);
                t4.setText(emp.phoneNumber);
                t5.setText(emp.username);
                t6.setText(emp.password);
            }
        });

        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = combo0.getSelectedIndex();
                if (index < 0) {
                    return;
                }
                String name = t1.getText().trim();
                String position = t2.getText().trim();
                String email = t3.getText().trim();
                String phone = t4.getText().trim();
                String username = t5.getText().trim();
                String password = new String(t6.getPassword());

                // duplicate username check (ignore the employee being edited)
                boolean duplicate = false;
                for (int i = 0; i < Ddatabase.employee.size(); i++) {
                    if (i != index && Ddatabase.employee.get(i).username.equalsIgnoreCase(username)) {
                        duplicate = true;
                        break;
                    }
                }
                for (Ddatabase.Admin ad : Ddatabase.admin) {
                    if (ad.username.equalsIgnoreCase(username)) {
                        duplicate = true;
                        break;
                    }
                }

                if (name.isEmpty() || position.isEmpty() || email.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (duplicate) {
                    JOptionPane.showMessageDialog(null, "That username is already taken.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!phone.matches("[0-9+\\- ]+")) {
                    JOptionPane.showMessageDialog(null, "PHONE should only contain numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!email.contains("@") || !email.contains(".")) {
                    JOptionPane.showMessageDialog(null, "Enter a valid email address.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    Ddatabase.Employee current = Ddatabase.employee.get(index);
                    current.name = name;
                    current.position = position;
                    current.email = email;
                    current.phoneNumber = phone;
                    current.username = username;
                    current.password = password;

                    Etabs.refreshTableEmployee();
                    frame.dispose();
                }
            }
        });

        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = combo0.getSelectedIndex();
                if (index < 0) {
                    return;
                }
                String name = (String) combo0.getSelectedItem();
                int confirm = JOptionPane.showConfirmDialog(null, "Delete \"" + name + "\"? This cannot be undone.", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    Ddatabase.employee.remove(index);
                    Etabs.refreshTableEmployee();
                    frame.dispose();
                }
            }
        });

        // fill the combo box last so the listener fills the fields for the first employee
        for (Ddatabase.Employee emp : Ddatabase.employee) {
            combo0.addItem(emp.name);
        }

        frame.setVisible(true);
        return frame;
    }
    public static JFrame reciept(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setTitle("Receipt");
        frame.setResizable(false);
        frame.setSize(380, 700);
        frame.setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(AMain.cream);
        frame.add(root);

        JPanel header = new JPanel(null);
        header.setBackground(AMain.white2);
        header.setPreferredSize(new Dimension(0, 64));
        root.add(header, BorderLayout.NORTH);

        JLabel lblTitle = new JLabel("Receipt");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 28));
        lblTitle.setForeground(AMain.green);
        lblTitle.setBounds(28, 10, 200, 36);
        header.add(lblTitle);

        JPanel paper = new JPanel(null);
        paper.setBackground(AMain.white2);

        JPanel body = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        body.setBackground(AMain.cream);
        body.setBorder(BorderFactory.createEmptyBorder(10, 0, 6, 0));
        body.add(paper);

        JScrollPane bodyScroll = new JScrollPane(body);
        bodyScroll.setBorder(null);
        bodyScroll.getViewport().setBackground(AMain.cream);
        bodyScroll.getVerticalScrollBar().setUnitIncrement(16);
        root.add(bodyScroll, BorderLayout.CENTER);

        JLabel lblShopName = new JLabel("PASTRY POS SYSTEM\u00C9", SwingConstants.CENTER);
        lblShopName.setFont(new Font("Serif", Font.BOLD, 22));
        lblShopName.setForeground(AMain.black);
        lblShopName.setBounds(0, 8, 300, 28);
        paper.add(lblShopName);

        addDash(paper, 36);

        JLabel lblInvoice = new JLabel(Etabs.tf2.getText().trim());
        lblInvoice.setFont(new Font("Monospaced", Font.BOLD, 13));
        lblInvoice.setForeground(AMain.black);
        lblInvoice.setBounds(16, 52, 120, 18);
        paper.add(lblInvoice);

        String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        JLabel lblDateTime = new JLabel(dt, SwingConstants.RIGHT);
        lblDateTime.setFont(new Font("Monospaced", Font.PLAIN, 11));
        lblDateTime.setForeground(AMain.gray);
        lblDateTime.setBounds(136, 52, 148, 18);
        paper.add(lblDateTime);

        JLabel lblCustomer = new JLabel("Customer: " + Etabs.tf1.getText().trim());
        lblCustomer.setFont(new Font("Monospaced", Font.PLAIN, 11));
        lblCustomer.setForeground(AMain.gray);
        lblCustomer.setBounds(16, 70, 268, 16);
        paper.add(lblCustomer);

        addDash(paper, 88);

        // ITEMS: galing sa Etabs.model, price x qty
        Font itemFont = new Font("Monospaced", Font.BOLD, 13);
        int y = 104;

        for (int i = 0; i < Etabs.model.getRowCount(); i++) {
            String name = Etabs.model.getValueAt(i, 0).toString();
            int qty = Integer.parseInt(Etabs.model.getValueAt(i, 1).toString());
            double unitPrice = Double.parseDouble(Etabs.model.getValueAt(i, 2).toString());
            addRow(paper, qty + " " + name, String.format("%.2f", unitPrice * qty), y, itemFont, AMain.black);
            y += 20;
        }

        y += 4;
        addDash(paper, y);
        y += 16;

        Font smallFont = new Font("Monospaced", Font.PLAIN, 13);

        addRow(paper, "Subtotal", String.format("%.2f", subtotal), y, smallFont, AMain.gray);
        y += 20;
        addRow(paper, "Promo (" + tfPromo.getText().trim() + "%)", "-" + String.format("%.2f", promoAmount), y, smallFont, AMain.gray);
        y += 20;
        addRow(paper, "VAT 12%", String.format("%.2f", vatAmount), y, smallFont, AMain.gray);
        y += 26;

        addRow(paper, "TOTAL", String.format("%.2f", total), y, new Font("Monospaced", Font.BOLD, 16), AMain.black);
        y += 28;

        addRow(paper, "Cash", String.format("%.2f", moneyGiven), y, smallFont, AMain.gray);
        y += 20;
        addRow(paper, "Change", String.format("%.2f", change), y, smallFont, AMain.gray);
        y += 26;

        addDash(paper, y);
        y += 20;

        JLabel lblThanks = new JLabel("Thank you! Come again.", SwingConstants.CENTER);
        lblThanks.setFont(new Font("Sans", Font.PLAIN, 13));
        lblThanks.setForeground(AMain.gray);
        lblThanks.setBounds(0, y, 300, 18);
        paper.add(lblThanks);
        y += 18;

        JLabel lblOfficial = new JLabel("This serves as your official receipt", SwingConstants.CENTER);
        lblOfficial.setFont(new Font("Sans", Font.PLAIN, 11));
        lblOfficial.setForeground(AMain.gray);
        lblOfficial.setBounds(0, y, 300, 16);
        paper.add(lblOfficial);
        y += 30;

        paper.setPreferredSize(new Dimension(300, y));

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(AMain.cream);
        bottom.setBorder(BorderFactory.createEmptyBorder(6, 28, 10, 28));
        root.add(bottom, BorderLayout.SOUTH);

        JPanel btnRow = new JPanel(new GridLayout(1, 2, 12, 0));
        btnRow.setOpaque(false);
        bottom.add(btnRow, BorderLayout.NORTH);

        JButton btnPrint = new JButton("Print");
        btnPrint.setBackground(AMain.green);
        btnPrint.setForeground(AMain.white);
        btnPrint.setFont(new Font("Sans", Font.BOLD, 14));
        btnPrint.setFocusPainted(false);
        btnPrint.setPreferredSize(new Dimension(0, 40));
        btnRow.add(btnPrint);

        JButton btnNewSale = new JButton("New Sale");
        btnNewSale.setBackground(AMain.white2);
        btnNewSale.setForeground(AMain.black);
        btnNewSale.setFont(new Font("Sans", Font.BOLD, 14));
        btnNewSale.setFocusPainted(false);
        btnRow.add(btnNewSale);

        btnNewSale.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                frame.dispose();
            }
        });

        frame.setVisible(true);
        return frame;
    }
    // bug recipt neef ix value crrash
    public static JFrame billing() {
        
    JFrame frame = new JFrame("Billing");
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    
    JPanel header = new JPanel(new GridLayout(2, 1));
    header.setBackground(AMain.green);
    header.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));
    JLabel title = new JLabel("Billing");
    title.setFont(new Font("Serif", Font.BOLD, 30));
    title.setForeground(AMain.gold);
    JLabel subtitle = new JLabel("Review the order and complete the payment");
    subtitle.setFont(new Font("Sans", Font.BOLD, 13));
    subtitle.setForeground(AMain.white);
    header.add(title);
    header.add(subtitle);
    frame.add(header, BorderLayout.NORTH);
    
    
    
    JPanel body = new JPanel(new GridLayout(1, 2, 30, 0));
    body.setBackground(AMain.cream);
    body.setBorder(BorderFactory.createEmptyBorder(25, 40, 25, 40));

    
    
    JPanel left = new JPanel(new BorderLayout(0, 15));
    left.setOpaque(false);

    JPanel info = new JPanel(new GridLayout(2, 2, 10, 8));
    info.setOpaque(false);
    JLabel lblCustomer = new JLabel();  // NAME
    JLabel lblInv = new JLabel();    // CODE
    lblCustomer.setFont(new Font("Monospaced", Font.BOLD, 14));
    lblCustomer.setText("Customer Name: " + Etabs.tf1.getText().trim().toString());
    lblInv.setFont(new Font("Monospaced", Font.BOLD, 14));
    lblInv.setText("Invoice No: " + Etabs.tf2.getText().trim().toString());
    info.add(lblCustomer);
    info.add(lblInv);
//    for (Component c : info.getComponents()) {
//        if (c != lblInv) c.setFont(new Font("Sans", Font.BOLD, 14));
//    }
    left.add(info, BorderLayout.NORTH);

    
    JTable table = new JTable(Etabs.model);
    table.setFont(new Font("Serif", Font.PLAIN, 15));
    table.setRowHeight(30);
    table.setBackground(AMain.white);
    table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 16));
    table.getTableHeader().setBackground(AMain.green);
    table.getTableHeader().setForeground(AMain.gold);
    JScrollPane scroll = new JScrollPane(table);
    scroll.getViewport().setBackground(AMain.white);
    left.add(scroll, BorderLayout.CENTER);

    
    
    JPanel right = new JPanel(new BorderLayout(0, 15));
    right.setOpaque(false);
    
//     promo = tfPromo.getText().trim().toString();
//     double promo1 = Double.parseDouble(promo);
//     money = tfMoney.getText().trim().toString();
//     int money1 = Integer.parseInt(money);
//
//
//    for (int i = 0; i < Etabs.model.getRowCount(); i++) {
//        int quantity = Integer.parseInt(Etabs.model.getValueAt(i, 1).toString());
//        double price = Double.parseDouble(Etabs.model.getValueAt(i, 2).toString());
//        subtotal = price * quantity;
//    }
//
//    double promoAmount = subtotal - (promo1 / 100);
//    double discounted = subtotal - promoAmount;
//
//    double minusTax = discounted * 0.12;
//    total = discounted + minusTax;
        
        
    JComboBox<String> cbMode = new JComboBox<String>(new String[]{"Cash", "GCash", "Card"});
    tfPromo.setBackground(AMain.white);
    tfVat.setBackground(AMain.white);
    tfVat.setText("0.12");
    tfMoney.setBackground(AMain.white);
    
    tfVat.setEditable(false);
    tfPromo.setText("0");
    tfMoney.setText("");
    
    JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
    form.setOpaque(false);

    Font labelFont = new Font("Sans", Font.BOLD, 14);
    
    JLabel lblSubtotal = new JLabel("Subtotal");
    lblSubtotal.setFont(labelFont);
    lblSubtotal.setForeground(AMain.green);

    JLabel lblSubtotalValue = new JLabel();
    String subtotal1 = Double.toString(subtotal);
    lblSubtotalValue.setText(subtotal1);
    lblSubtotalValue.setFont(labelFont);
    lblSubtotalValue.setForeground(AMain.green);

    JLabel lblPromo = new JLabel("Promo / Sale (%)");
    lblPromo.setFont(labelFont);
    lblPromo.setForeground(AMain.green);

    JLabel lblVat = new JLabel("VAT (%)");
    lblVat.setFont(labelFont);
    lblVat.setForeground(AMain.green);

    JLabel lblMode = new JLabel("Payment Mode");
    lblMode.setFont(labelFont);
    lblMode.setForeground(AMain.green);

    JLabel lblMoney = new JLabel("Money Received");
    lblMoney.setFont(labelFont);
    lblMoney.setForeground(AMain.green);

    form.add(lblSubtotal);
    form.add(lblSubtotalValue);
    form.add(lblPromo);
    form.add(tfPromo);
    form.add(lblVat);
    form.add(tfVat);
    form.add(lblMode);
    form.add(cbMode);
    form.add(lblMoney);
    form.add(tfMoney);
    right.add(form, BorderLayout.NORTH);

    
    JPanel quick = new JPanel(new GridLayout(1, 5, 6, 0));
    quick.setOpaque(false);
    quick.setBorder(BorderFactory.createTitledBorder("Quick Payment (PHP)"));
    quick.setPreferredSize(new Dimension(0, 75));

    JButton btn1000 = new JButton("1000");
    btn1000.setBackground(AMain.gold);
    btn1000.setFont(new Font("Sans", Font.BOLD, 13));
    quick.add(btn1000);

    JButton btn500 = new JButton("500");
    btn500.setBackground(AMain.gold);
    btn500.setFont(new Font("Sans", Font.BOLD, 13));
    quick.add(btn500);

    JButton btn100 = new JButton("100");
    btn100.setBackground(AMain.gold);
    btn100.setFont(new Font("Sans", Font.BOLD, 13));
    quick.add(btn100);

    JButton btn50 = new JButton("50");
    btn50.setBackground(AMain.gold);
    btn50.setFont(new Font("Sans", Font.BOLD, 13));
    quick.add(btn50);

    JButton btn20 = new JButton("20");
    btn20.setBackground(AMain.gold);
    btn20.setFont(new Font("Sans", Font.BOLD, 13));
    quick.add(btn20);

    JPanel mid = new JPanel(new BorderLayout());
    mid.setOpaque(false);
    mid.add(quick, BorderLayout.NORTH);
    right.add(mid, BorderLayout.CENTER);

    
    
    
    JPanel totalBar = new JPanel(new BorderLayout());
    totalBar.setBackground(AMain.green);
    totalBar.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
    JLabel lblTotalT = new JLabel("TOTAL");
    JLabel lblTotal = new JLabel("P543.20");
    lblTotalT.setFont(new Font("Serif", Font.BOLD, 22));
    lblTotal.setFont(new Font("Serif", Font.BOLD, 26));
    lblTotalT.setForeground(AMain.gold);
    lblTotal.setForeground(AMain.gold);
    totalBar.add(lblTotalT, BorderLayout.WEST);
    totalBar.add(lblTotal, BorderLayout.EAST);

    JPanel changeRow = new JPanel(new BorderLayout());
    changeRow.setOpaque(false);
    changeRow.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
    JLabel lblChangeT = new JLabel("Change");
    JLabel lblChange = new JLabel();
    lblChangeT.setFont(new Font("Sans", Font.BOLD, 16));
    lblChange.setFont(new Font("Sans", Font.BOLD, 20));
    changeRow.add(lblChangeT, BorderLayout.WEST);
    changeRow.add(lblChange, BorderLayout.EAST);

    
    compute(lblSubtotalValue, lblTotal, lblChange);
    
    
    
    JPanel totals = new JPanel(new GridLayout(2, 1, 0, 8));
    totals.setOpaque(false);
    totals.add(totalBar);
    totals.add(changeRow);
    right.add(totals, BorderLayout.SOUTH);

    body.add(left);
    body.add(right);
    frame.add(body, BorderLayout.CENTER);

    
    
    // FOOTER
    JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 15));
    footer.setBackground(AMain.green);
    footer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));

    JButton btnCancel = new JButton("Cancel");
    btnCancel.setBackground(AMain.white);
    btnCancel.setForeground(AMain.gold);
    btnCancel.setFont(new Font("Serif", Font.BOLD, 16));
    btnCancel.setPreferredSize(new Dimension(160, 50));

    JButton btnComplete = new JButton("Complete Payment");
    btnComplete.setBackground(AMain.gold);
    btnComplete.setForeground(AMain.black);
    btnComplete.setFont(new Font("Serif", Font.BOLD, 16));
    btnComplete.setPreferredSize(new Dimension(200, 50));

    footer.add(btnCancel);
    footer.add(btnComplete);
    frame.add(footer, BorderLayout.SOUTH);

    frame.setSize(900, 680);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    
    btnComplete.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean ok = compute(lblSubtotalValue, lblTotal, lblChange);
            if (!ok) {
                return;
            }
            if (Etabs.model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "The cart is empty.");
                return;
            }
            if (moneyGiven < total) {
                JOptionPane.showMessageDialog(null, "Insufficient payment.", "Payment", JOptionPane.ERROR_MESSAGE);
                return;
            }
         double costTotal = 0;   // ilipat dito, bago ang loop

        for (int i = 0; i < Etabs.model.getRowCount(); i++) {
            String itemName = Etabs.model.getValueAt(i, 0).toString();
            int qty = Integer.parseInt(Etabs.model.getValueAt(i, 1).toString());
            double itemPrice = Double.parseDouble(Etabs.model.getValueAt(i, 2).toString());

            for (Ddatabase.Product p : Ddatabase.product) {
                if (p.name.equals(itemName)) {
                    for (Ddatabase.Category c : Ddatabase.category) {
                        if (c.categoryname.equals(p.category)) {
                            c.sales += itemPrice * qty;
                        }
                    }
                    costTotal += p.cost * qty;   // BAGO: cost ng product x dami
                    p.stock -= qty;
                    break;
                }
            }
        }
        
        double revenue = total / 1.12;   
        Ddatabase.Sale sale = new Ddatabase.Sale(Etabs.tf1.getText().trim(),Etabs.tf2.getText().trim(),total,revenue,costTotal);
        Ddatabase.sales.add(sale);
        
        Ddatabase.Customer cuh = new Ddatabase.Customer(Etabs.tf1.getText().trim(),Etabs.tf2.getText().trim(),subtotal,vatAmount,promoAmount,moneyGiven,total);
        Ddatabase.customer.add(cuh);
        
        
        reciept();
        
        Etabs.refreshTableCat();
        Etabs.refreshTableProd();
        Etabs.model.setRowCount(0);  
        Etabs.refreshCustomerCombo();
        Etabs.refreshTableCustomer();
        frame.dispose();
        
        
                }
            });
    
    btnCancel.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    });
    
    btn1000.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            addToMoneyField(1000);
            compute(lblSubtotalValue, lblTotal, lblChange);
        }
    });
    
    btn500.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            addToMoneyField(500);
            compute(lblSubtotalValue, lblTotal, lblChange);
        }
    });
    
    btn100.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            addToMoneyField(100);
            compute(lblSubtotalValue, lblTotal, lblChange);
        }
    });
    
    btn50.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            addToMoneyField(50);
            compute(lblSubtotalValue, lblTotal, lblChange);
        }
    });
    
    btn20.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            addToMoneyField(20);
            compute(lblSubtotalValue, lblTotal, lblChange);
        }
    });
    
    return frame;
}
        
    // HELPER METHODS
    public static JPanel productCards(Ddatabase.Product p){
//        String prodCode = p.code;
        String prodName = p.name;
        int quantity = p.stock;
        double price = p.price;
        
        JPanel panel1 = new JPanel(new BorderLayout(0, 8));
        panel1.setPreferredSize(new Dimension(140, 180));
        panel1.setBackground(AMain.green);
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        
        
        panel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel1.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            addToCart(p);
        }
        });
        
        
        
//        JLabel label1 = new JLabel("", SwingConstants.CENTER);
//        ImageIcon icon = new ImageIcon(AMain.class.getResource("/pic/malunggay.png"));
//        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//        label1.setIcon(new ImageIcon(img));
//        panel1.add(label1, BorderLayout.CENTER);

        
        JPanel info = new JPanel(new GridLayout(3, 1, 0, 3));
        info.setOpaque(false);   
        JPanel info1 = new JPanel(new BorderLayout(6, 0));
        info1.setOpaque(false);   

        JLabel label2 = new JLabel(prodName, SwingConstants.CENTER);
        label2.setForeground(AMain.white);
        label2.setFont(new Font("Sans", Font.BOLD, 14));
        
//        JLabel label22 = new JLabel(prodCode, SwingConstants.CENTER);
//        label22.setForeground(AMain.gold);
//        label22.setFont(new Font("Sans", Font.BOLD, 15));

//        info1.add(label22, BorderLayout.WEST);
        info1.add(label2, BorderLayout.CENTER);
        
        JLabel label3 = new JLabel(quantity + " In Stock", SwingConstants.CENTER);
        label3.setForeground(AMain.white);
        label3.setFont(new Font("Sans", Font.BOLD, 11));

        JLabel label4 = new JLabel(String.format("P%.2f", price), SwingConstants.CENTER);
//        label4.setOpaque(false);
        label4.setBackground(AMain.dgreen);
        label4.setForeground(AMain.gold);
        label4.setFont(new Font("Sans", Font.BOLD, 13));

        
        info.add(info1);
        info.add(label3);
        info.add(label4);
        panel1.add(info, BorderLayout.SOUTH);

        
        return panel1;
    }
    public static void addToCart(Ddatabase.Product p){
        
        if (p.stock == 0) {
            JOptionPane.showMessageDialog(null, p.name + "Out of stock", "Product", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i = 0; i < Etabs.model.getRowCount(); i++) {
            String items = Etabs.model.getValueAt(i,0).toString();
            
            if(items.equals(p.name)){
                int qyt = Integer.parseInt(Etabs.model.getValueAt(i, 1).toString());
                
                if(qyt >= p.stock){
                    JOptionPane.showMessageDialog(null, "Not enough stock");
                    return;
                }
                Etabs.model.setValueAt(qyt + 1, i, 1);
                return;
            }
        }
        Etabs.model.addRow(new Object[]{p.name, 1,p.price});
    }
    public static String INV (){
        Random rand = new Random();
            String inv = " INV-" + (rand.nextInt(1000000) + 1000000);
            String code = inv;
            
            return code;
    }
    public static boolean compute(JLabel lblSubtotalValue, JLabel lblTotal, JLabel lblChange) {

        String promoText = tfPromo.getText();
        promo = promoText.trim();
        String moneyText = tfMoney.getText();
        money = moneyText.trim();

        double promo1 = 0;
        double money1 = 0;

        try {
            if (!promo.isEmpty()) {
                promo1 = Double.parseDouble(promo);
            }
            if (!money.isEmpty()) {
                money1 = Double.parseDouble(money);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Promo and Money should be numbers only.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (promo1 < 0 || promo1 > 100) {
            JOptionPane.showMessageDialog(null, "Promo should be from 0 to 100.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        subtotal = 0;  
        for (int i = 0; i < Etabs.model.getRowCount(); i++) {
            Object qtyValue = Etabs.model.getValueAt(i, 1);
            String qtyText = qtyValue.toString();
            int quantity = Integer.parseInt(qtyText);

            Object priceValue = Etabs.model.getValueAt(i, 2);
            String priceText = priceValue.toString();
            double price = Double.parseDouble(priceText);

            subtotal += price * quantity;  
        }

        promoAmount = subtotal * (promo1 / 100);
        double discounted = subtotal - promoAmount;

        vatAmount = discounted * 0.12;
        total = discounted + vatAmount;
    
        
        moneyGiven = money1;
        change = money1 - total;
        if (change < 0) {
            change = 0;
        }

        String subtotalText = String.format("P %.2f", subtotal);
        lblSubtotalValue.setText(subtotalText);
        String totalText = String.format("P %.2f", total);
        lblTotal.setText(totalText);
        String changeText = String.format("P %.2f", change);
        lblChange.setText(changeText);

        return true;
    }
    public static void addToMoneyField(double amount) {
    String text = tfMoney.getText();
    text = text.trim();

    double current = 0;
    if (!text.isEmpty()) {
        try {
            current = Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            current = 0;
        }
    }

    current += amount;
    String newText = String.format("%.2f", current);
    tfMoney.setText(newText);
}
    
    private static void addRow(JPanel paper, String left, String right, int y, Font font, Color color){
        JLabel l = new JLabel(left);
        l.setFont(font);
        l.setForeground(color);
        l.setBounds(16, y, 170, 20);
        paper.add(l);

        JLabel r = new JLabel(right, SwingConstants.RIGHT);
        r.setFont(font);
        r.setForeground(color);
        r.setBounds(166, y, 118, 20);
        paper.add(r);
    }
    private static void addDash(JPanel paper, int y){
        JLabel d = new JLabel("- - - - - - - - - - - - - - - - - - -", SwingConstants.CENTER);
        d.setFont(new Font("Monospaced", Font.PLAIN, 11));
        d.setForeground(AMain.lgreen);
        d.setBounds(16, y, 268, 14);
        paper.add(d);
    }
    
    
    
}
