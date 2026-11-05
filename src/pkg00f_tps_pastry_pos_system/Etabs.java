
package pkg00f_tps_pastry_pos_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import static pkg00f_tps_pastry_pos_system.Cdashboard.newsaleB;
import static pkg00f_tps_pastry_pos_system.Cdashboard.notif;
import pkg00f_tps_pastry_pos_system.Ddatabase;

public class Etabs{
    
    public static int price = 100;
    public static int available = 100;
    public static String productName = "pandesal";
    
    public static int all = 100;
    public static int inStock = 100;
    public static int lowStock = 100;
    public static int outStock = 100;
    
    // FOR billing / SALES TERMINAL WINDOW
    public static DefaultTableModel model = new DefaultTableModel(new String[]{"Item", "Qty", "Price"}, 0);
    public static JTable table = new JTable(model);

    
    public static DefaultTableModel product = new DefaultTableModel(new String[]{"Code","Product","Category","Price","Cost","Stock","Status","Supplier"}, 0);
    public static DefaultTableModel categorynames = new DefaultTableModel(new String[]{"Category Name", "Product Quantity", "Sales"}, 0);
    public static DefaultTableModel supplier = new DefaultTableModel(new String[]{"Company Name", "Manager Name","Location", "Contact Number","Email","Purchases"}, 0);
    public static String filter = "All Categories";
    
    static JTextField tf1 = new JTextField();  // name/
    static JTextField tf2 = new JTextField();    /// code

    public static String stockFilter = "all";  
    static JButton b3 = new JButton();
    static JButton b4  = new JButton();
    static JButton b5 = new JButton();
    static JButton b6 = new JButton();
    
    public static DefaultTableModel customer = new DefaultTableModel(new String[]{"Customer Name", "Invoice", "Date/Time", "Amount purchase"}, 0);
    static JComboBox<String> cbInvoice = new JComboBox<String>();
    static String customerFilter = "All Invoices";
    static boolean updatingCombo = false;
    
    public static DefaultTableModel employee = new DefaultTableModel(new String[]{"Role","Employee Name", "Position", "Email", "Phone number", "Username", "Password"}, 0);
    
    public static void refreshTableProd(){
        product.setRowCount(0);

        for (Ddatabase.Product p : Ddatabase.product) {

            // category filter
            if (!filter.equals("All Categories") && !filter.equalsIgnoreCase(p.category)) {
                continue;
            }

            // get the status
            String status;
            if (p.stock == 0) {
                status = "out of stock";
            } else if (p.stock <= p.lowAlert) {
                status = "low stock";
            } else {
                status = "in stock";
            }

            // stock filter (the buttons)
            boolean show = false;
            if (stockFilter.equals("all")) {
                show = true;
            } else if (stockFilter.equals(status)) {
                show = true;
            }

            if (show) {
                product.addRow(new Object[]{p.code, p.name, p.category, p.price, p.cost, p.stock, status, p.supplier});
            }
        }

        refreshCounts();
    }
    public static void refreshTableCat(){
    categorynames.setRowCount(0);   
 // ADD AKO LATER NG VALUE IF ilang product ang actegory nato maeron and yung totals sales of products
    for (Ddatabase.Category c : Ddatabase.category) {
        int count = 0;

        if (c.categoryname.equals("All Categories")) {
            count = Ddatabase.product.size();      
        } else {
            for (Ddatabase.Product p : Ddatabase.product) {
                if (p.category.equals(c.categoryname)) {
                    count++;
                }
            }
        }
        categorynames.addRow(new Object[]{c.categoryname, count, c.sales});
    }
    }
    public static void refreshTableSup(){
    supplier.setRowCount(0);  

    for (Ddatabase.Supplier s : Ddatabase.supplier) {
        supplier.addRow(new Object[]{s.comName, s.manName, s.loc, s.phone, s.email, s.purchases});
    }
}
    public static void refreshTableCustomer() {
        customer.setRowCount(0);
        for (Ddatabase.Customer c : Ddatabase.customer) {
            if (customerFilter.equals("All Invoices") || c.inv.equals(customerFilter)) {
                customer.addRow(new Object[]{c.cusname, c.inv, c.dateTime, c.total});
            }
        }
    }
    public static void refreshCustomerCombo() {
        updatingCombo = true;
        cbInvoice.removeAllItems();
        cbInvoice.addItem("All Invoices");
        for (Ddatabase.Customer c : Ddatabase.customer) {
            cbInvoice.addItem(c.inv);
        }
        cbInvoice.setSelectedItem("All Invoices");
        customerFilter = "All Invoices";
        updatingCombo = false;
    }
    public static void refreshTableEmployee(){
        employee.setRowCount(0);
        for (Ddatabase.Employee e : Ddatabase.employee) {
            // password is masked in the table
            employee.addRow(new Object[]{e.role, e.name, e.position, e.email, e.phoneNumber, e.username, e.password});
        }
    }
    public static JPanel comingsoon(){
        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel l1 = new JLabel("                                                        Comming Soon");
        l1.setFont(new Font("Serif", Font.BOLD, 15));
        panel1.add(l1, BorderLayout.CENTER);
        
        return panel1;
    }
    public static void loadCards(JPanel grid, String cat, String text){
        grid.removeAll();
        String q = text.trim().toLowerCase();

        for (Ddatabase.Product p : Ddatabase.product) {
            // category filter
            if (!cat.equals("All Categories") && !cat.equalsIgnoreCase(p.category)) {
                continue;
            }
            // search filter: name, category, or code
            if (!q.isEmpty()
                    && !p.name.toLowerCase().contains(q)
                    && !p.category.toLowerCase().contains(q)
                    && !p.code.toLowerCase().contains(q)) {
                continue;
            }
            grid.add(FpopUps.productCards(p));
        }
        grid.revalidate();
        grid.repaint();
    }

    public static String getStatus(Ddatabase.Product p){
        if (p.stock == 0) {
            return "out of stock";
        } else if (p.stock <= p.lowAlert) {
            return "low stock";
        } else {
            return "in stock";
        }
    }
    public static void styleStockButton(JButton b, String text, boolean active){
        b.setText(text);
        b.setFont(new Font("Sans", Font.BOLD, 12));
        b.setPreferredSize(new Dimension(130,35));
        b.setFocusPainted(false);
        if (active) {
            b.setBackground(AMain.gold);
            b.setForeground(AMain.black);
        } else {
            b.setBackground(AMain.dgreen);
            b.setForeground(AMain.gold);
        }
    }
    public static void refreshCounts(){
        if (b3 == null) {
            return;   // inventory page not opened yet
        }

        int all = 0;
        int in = 0;
        int low = 0;
        int out = 0;

        for (Ddatabase.Product p : Ddatabase.product) {
            all++;
            if (p.stock == 0) {
                out++;
            } else if (p.stock <= p.lowAlert) {
                low++;
            } else {
                in++;
            }
        }

        b3.setText("All " + all);
        b4.setText("In stock " + in);
        b5.setText("Low stock " + low);
        b6.setText("Out of stock " + out);
    }
    
    
    public static JPanel dashboard(){
        JPanel panel1 = new JPanel(new BorderLayout());
        
        
            JPanel maindashboard = new JPanel(new BorderLayout()); 
            JPanel panel6 = new JPanel(new GridLayout(0,4,4,3)); 
            JPanel panel8 = new JPanel(new BorderLayout(1,2)); // sa maindashboard and sa loob ng apat na main numbers
            panel1.setBackground(AMain.cream);
            maindashboard.setBackground(AMain.cream);
            maindashboard.setOpaque(true);
            
        LocalDate today = LocalDate.now();
        int transactions = 0;
        double profit = 0;
        double costTotal = 0;
        double paidTotal = 0;

        for (Ddatabase.Sale s : Ddatabase.sales) {
            if (s.date.equals(today)) {            // only today's sales
                transactions++;
                profit += s.revenue - s.cost;
                costTotal += s.cost;
                paidTotal += s.amountPaid;
            }
        }

        double average = 0;
        if (transactions > 0) {
            average = paidTotal / transactions;    // total paid divided by number of orders
        }

        int lowCount = 0;
        for (Ddatabase.Product p : Ddatabase.product) {
            if (p.stock <= p.lowAlert) {           // low stock and out of stock
                lowCount++;
            }
        }
            
            
            
            
            JLabel todaysale = new JLabel("TODAY'S SALES"); // maindashaodr four details
            JLabel todaysaleNUM = new JLabel(); // maindashaodr four details NUMBER
            JLabel todaysaleCOMM = new JLabel(); // maindashaodr four details COMMENTS
            todaysaleNUM.setText(String.format("P %.2f", profit));
            todaysaleCOMM.setText(String.format("Cost: P %.2f", costTotal));
            JLabel icon2 = new JLabel(); // ICON
            JLabel TRANSACTIONS = new JLabel("TRANSACTIONS"); // maindashaodr four details
            JLabel TRANSACTIONSnum = new JLabel(); // maindashaodr four details NUMBER 
            JLabel TRANSACTIONSComm = new JLabel(); // maindashaodr four details CMNETS
            TRANSACTIONSnum.setText(String.valueOf(transactions));
            TRANSACTIONSComm.setText("Paid customers");
            JLabel icon3 = new JLabel(); // ICON
            JLabel AVERAGEASKET  = new JLabel("AVERAGE BASKET"); // maindashaodr four details
            JLabel AVERAGEASKETnum  = new JLabel(); // maindashaodr four details NUMBER
            JLabel AVERAGEASKETnumComm  = new JLabel(); // maindashaodr four details COMMENTS
            AVERAGEASKETnum.setText(String.format("P %.2f", average));
            AVERAGEASKETnumComm.setText("Per order");
            JLabel icon4 = new JLabel(); // ICON
            JLabel LOWSTOCKITEMS = new JLabel("LOW STOCK ITEMS"); // maindashaodr four details
            JLabel LOWSTOCKITEMSnum = new JLabel(); // maindashaodr four details NUMBER 
            JLabel LOWSTOCKITEMSnumComm = new JLabel(); // maindashaodr four details COMMENTS
            LOWSTOCKITEMSnum.setText(String.valueOf(lowCount));
            if (lowCount > 0) {
                LOWSTOCKITEMSnumComm.setText("Restock needed");
                LOWSTOCKITEMSnumComm.setForeground(AMain.red);
            } else {
                LOWSTOCKITEMSnumComm.setText("All stocked");
            }
            JLabel icon5 = new JLabel(); // ICON
            
            
            maindashboard.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            maindashboard.setOpaque(false);
            
            panel6.setBackground(AMain.green);
            panel6.setPreferredSize(new Dimension (0,110));
            
            
            
            // card 1
            panel8.add(icon2, BorderLayout.WEST);
            panel8.setBackground(AMain.white);
            panel8.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            icon2.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/teal/24px/cash_banknote.png")));
            icon2.setSize(50,50);
            
            JPanel p1 = new JPanel(new GridLayout(3,1,0,0));
            p1.setBackground(AMain.white);
            p1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            todaysale.setFont(new Font("Sans", Font.BOLD, 14));
            todaysale.setForeground(AMain.black);
            p1.add(todaysale);
            todaysaleNUM.setForeground(AMain.black);
            todaysaleNUM.setFont(new Font("Sans", Font.BOLD,28));
            p1.add(todaysaleNUM);
            todaysaleCOMM.setForeground(AMain.green);
            todaysaleCOMM.setFont(new Font("Sans", Font.BOLD, 14));
            p1.add(todaysaleCOMM);
            panel8.add(p1, BorderLayout.CENTER);
                   
            panel6.add(panel8);
            
            // card2
            JPanel p2 = new JPanel(new BorderLayout(1,2));
            p2.add(icon3, BorderLayout.WEST);
            p2.setBackground(AMain.white);
            p2.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            icon3.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/teal/24px/orders.png")));
            icon3.setSize(50,50);
            
            JPanel p22 = new JPanel(new GridLayout(3,1,0,0));
            p22.setBackground(AMain.white);
            p22.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            TRANSACTIONS.setFont(new Font("Sans", Font.BOLD, 14));
            TRANSACTIONS.setForeground(AMain.black);
            p22.add(TRANSACTIONS);
            TRANSACTIONSnum.setForeground(AMain.black);
            TRANSACTIONSnum.setFont(new Font("Sans", Font.BOLD,28));
            p22.add(TRANSACTIONSnum);
            TRANSACTIONSComm.setForeground(AMain.green);
            TRANSACTIONSComm.setFont(new Font("Sans", Font.BOLD, 14));
            p22.add(TRANSACTIONSComm);
            p2.add(p22, BorderLayout.CENTER);
            
            panel6.add(p2);
            
            // card3
            JPanel p3 = new JPanel(new BorderLayout(1,2));
            p3.add(icon4, BorderLayout.WEST);
            p3.setBackground(AMain.white);
            p3.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            icon4.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/teal/24px/cart.png")));
            icon4.setSize(50,50);
            
            JPanel p33 = new JPanel(new GridLayout(3,1,0,0));
            p33.setBackground(AMain.white);
            p33.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            AVERAGEASKET.setFont(new Font("Sans", Font.BOLD, 14));
            AVERAGEASKET.setForeground(AMain.black);
            p33.add(AVERAGEASKET);
            AVERAGEASKETnum.setForeground(AMain.black);
            AVERAGEASKETnum.setFont(new Font("Sans", Font.BOLD,28));
            p33.add(AVERAGEASKETnum);
            AVERAGEASKETnumComm.setForeground(AMain.green);
            AVERAGEASKETnumComm.setFont(new Font("Sans", Font.BOLD, 14));
            p33.add(AVERAGEASKETnumComm);
            p3.add(p33, BorderLayout.CENTER);
            
            panel6.add(p3);
            
            // card4
            JPanel p4 = new JPanel(new BorderLayout(1,2));
            p4.add(icon5, BorderLayout.WEST);
            p4.setBackground(AMain.white);
            p4.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            icon5.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/teal/24px/alert_triangle.png")));
            icon5.setSize(50,50);
            
            JPanel p44 = new JPanel(new GridLayout(3,1,0,0));
            p44.setBackground(AMain.white);
            p44.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            LOWSTOCKITEMS.setFont(new Font("Sans", Font.BOLD, 14));
            LOWSTOCKITEMS.setForeground(AMain.black);
            p44.add(LOWSTOCKITEMS);
            LOWSTOCKITEMSnum.setForeground(AMain.black);
            LOWSTOCKITEMSnum.setFont(new Font("Sans", Font.BOLD,28));
            p44.add(LOWSTOCKITEMSnum);
            LOWSTOCKITEMSnumComm.setForeground(AMain.green);
            LOWSTOCKITEMSnumComm.setFont(new Font("Sans", Font.BOLD, 14));
            p44.add(LOWSTOCKITEMSnumComm);
            p4.add(p44, BorderLayout.CENTER);
            
            panel6.add(p4);
            
            
            maindashboard.add(panel6, BorderLayout.NORTH);
            
            // GITNA NAAAAA
            
            JPanel cntr = new JPanel(new BorderLayout());
            cntr.setBackground(AMain.cream);
            cntr.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

            // combobox ng invoice
            JPanel filterRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
            filterRow.setBackground(AMain.cream);
            cbInvoice.setPreferredSize(new Dimension(220, 35));
            filterRow.add(cbInvoice);
            cntr.add(filterRow, BorderLayout.NORTH);

            // customer table
            JTable custTable = new JTable(customer);
            custTable.setFont(new Font("Serif", Font.PLAIN, 16));
            custTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
            custTable.getTableHeader().setPreferredSize(new Dimension(0, 40));
            custTable.setRowHeight(32);
            custTable.setForeground(AMain.black);
            custTable.setBackground(AMain.white);

            refreshCustomerCombo();
            refreshTableCustomer();

            JScrollPane custScroll = new JScrollPane(custTable);
//            custScroll.getViewport().setBackground(AMain.cream);
            custScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            custScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            custScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            cntr.add(custScroll, BorderLayout.CENTER);

            // tanggalin muna ang lumang listeners para hindi dumami kada bukas ng dashboard
            for (ActionListener al : cbInvoice.getActionListeners()) {
                cbInvoice.removeActionListener(al);
            }
            cbInvoice.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (updatingCombo || cbInvoice.getSelectedItem() == null) return;
                    customerFilter = (String) cbInvoice.getSelectedItem();
                    refreshTableCustomer();
                }
            });

            maindashboard.add(cntr, BorderLayout.CENTER);
            
            
            panel1.add(maindashboard, BorderLayout.CENTER);
            
        
        
        return panel1;
    }
    public static JPanel salesterminal(){
        
        // LEFYY
        
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridLayout(0, 4, 10, 10));
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel(new BorderLayout());
        JScrollPane scroll = new JScrollPane(panel4);
        
        panel1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        panel1.setBackground(AMain.cream);       
        
       
        panel2.setBackground(AMain.cream);   
        panel2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        panel4.setBackground(AMain.cream);
        panel4.add(panel2, BorderLayout.NORTH);
        
        
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel1.add(scroll, BorderLayout.CENTER);
        
        
        
        
        
        
        // PRODUCT CARDS INSIDE THE PANEL
        
        loadCards(panel2, "All Categories", "");
        JPanel filterBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        filterBar.setBackground(AMain.cream);

        JComboBox<String> cbCat = new JComboBox<String>();
        for (Ddatabase.Category c : Ddatabase.category) {
            cbCat.addItem(c.categoryname);
        }
        cbCat.setPreferredSize(new Dimension(170, 35));

        JTextField tfSearch = new JTextField();
        tfSearch.setPreferredSize(new Dimension(300, 35));

        JButton btnSearch = new JButton("Search");
        btnSearch.setPreferredSize(new Dimension(110, 35));
        btnSearch.setBackground(AMain.green);
        btnSearch.setForeground(AMain.gold);
        btnSearch.setFont(new Font("Sans", Font.BOLD, 13));
        btnSearch.setFocusPainted(false);

        filterBar.add(cbCat);
        filterBar.add(tfSearch);
        filterBar.add(btnSearch);
        panel1.add(filterBar, BorderLayout.NORTH);

        ActionListener doFilter = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                loadCards(panel2, (String) cbCat.getSelectedItem(), tfSearch.getText());
            }
        };
        cbCat.addActionListener(doFilter);     
        btnSearch.addActionListener(doFilter); 
        tfSearch.addActionListener(doFilter);  
        
        
        
        // another side panel
        JPanel panel5 = new JPanel(new GridLayout(3, 1, 0, 3));    // header
        JPanel panel6 = new JPanel(new BorderLayout());            // total row
        JPanel panel7 = new JPanel(new GridLayout(1, 3, 8, 0));    // cash/card/gcash
        JPanel panel8 = new JPanel(new GridLayout(3, 1, 0, 10));   // baba: total, payment, charge
        JPanel holderCustomer = new JPanel(new FlowLayout(FlowLayout.LEFT));   // baba: total, payment, charge
        JPanel code = new JPanel(new FlowLayout(FlowLayout.LEFT));   // baba: total, payment, charge
        
        
        JLabel label1 = new JLabel("Current Order");
        JLabel label3 = new JLabel("Customer Name: ");
        
        code.setBackground(AMain.brown);
        JButton buttonCode = new JButton("Code");
        buttonCode.setBackground(AMain.green);
        buttonCode.setForeground(AMain.gold);
        buttonCode.setPreferredSize(new Dimension(70,30));
        JLabel label2 = new JLabel("Code");
        tf2.setPreferredSize(new Dimension(200,30));
        tf2.setBackground(AMain.cream);
        code.add(buttonCode);
        code.add(tf2);
        
        
        tf1.setPreferredSize(new Dimension(200,30));
        tf1.setBackground(AMain.cream);
        
        
        
        
        panel6.setBackground(AMain.green);
        panel6.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        label1.setFont(new Font("Serif", Font.BOLD, 22));
        label1.setForeground(AMain.gold);
        panel6.add(label1);
        panel5.add(panel6);
        
        
        JButton button4 = new JButton("Proceed");
        button4.setPreferredSize(new Dimension(0, 50));
        button4.setForeground(AMain.gold);
        button4.setBackground(AMain.green);
        button4.setFont(new Font("Monospaced", Font.BOLD, 22));

        JButton restart = new JButton("Restart");
        restart.setPreferredSize(new Dimension(0, 50));
        restart.setForeground(AMain.gold);
        restart.setBackground(AMain.green);
        restart.setFont(new Font("Monospaced", Font.BOLD, 22));
        
        
        
        JScrollPane scroll2 = new JScrollPane(table);
        
        table.setRowHeight(32);
        table.setShowGrid(false);
        table.setBackground(AMain.cream);
        table.getTableHeader().setBackground(AMain.green);
        table.getTableHeader().setForeground(AMain.gold);
        
        
        panel3.setLayout(new BorderLayout(0, 10));
        panel3.setBackground(AMain.brown);
        panel3.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        
        panel5.setOpaque(false);
        tf2.setFont(new Font("Monospaced", Font.BOLD, 14));
        label3.setFont(new Font("Monospaced", Font.BOLD, 14));
        holderCustomer.setBackground(AMain.brown);
        holderCustomer.add(label3);
        holderCustomer.add(tf1);
        panel5.add(holderCustomer);
        panel5.add(code);
        panel3.add(panel5, BorderLayout.NORTH);

        
        
        

        scroll2.setBorder(null);
        scroll2.getViewport().setBackground(AMain.cream);
        panel3.add(scroll2, BorderLayout.CENTER);

        
//        label5.setFont(new Font("Serif", Font.BOLD, 26));
//        label5.setForeground(AMain.gold);
//        panel6.add(label4, BorderLayout.WEST);
//        panel6.add(label5, BorderLayout.EAST);

        
        panel7.setOpaque(false);
//        panel7.add(button1);
//        panel7.add(button2);
//        panel7.add(button3);

        
        
        panel8.setOpaque(false);
        panel8.add(panel7);
        panel8.add(restart);
        panel8.add(button4);
        panel3.add(panel8, BorderLayout.SOUTH);
        
        
        panel1.add(panel3, BorderLayout.EAST);
//        
//        String name = tf1.getText().trim().toString();
//        String codeINV = tf2.getText().trim().toString();
//        
//        Ddatabase.CartItem a = new Ddatabase.CartItem(name, codeINV);
        
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = tf1.getText().trim().toString();
                String salesCode = tf2.getText().trim().toString();
                
                if (customerName.isEmpty() || salesCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PLease Complete the details", "Input Details",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                if(table.getRowCount() == 0){
                    JOptionPane.showMessageDialog(null, "No Product to checkout/Click the Products to add to Cart","Add to cart",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                FpopUps.billing();
            }
            
        });
     
        restart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(table.getRowCount() == 0){
//                    JOptionPane.showMessageDialog(null, "No Product to checkout/Click the Products to add to Cart","Add to cart",JOptionPane.INFORMATION_MESSAGE);
////                    return;
//                }
                model.setRowCount(0);
            }
            
        });
        
        buttonCode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(table.getRowCount() == 0){
//                    JOptionPane.showMessageDialog(null, "No Product to checkout/Click the Products to add to Cart","Add to cart",JOptionPane.INFORMATION_MESSAGE);
////                    return;
//                }
                tf2.setText(FpopUps.INV());
            }
            
        });
        
        
        
        
        return panel1;
    }
    public static JPanel salesterminal1(){
        JPanel panel1 = new JPanel(new GridLayout(4,1,0,-10));
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        
        panel1.setPreferredSize(new Dimension(150,150));
        panel1.setBackground(AMain.green);
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        label1.setIcon(new ImageIcon(AMain.class.getResource("/pic/malunggay.png/")));
        panel1.add(label1);
        
        label2.setText(productName);
        label2.setFont(new Font("Sans", Font.BOLD, 15));
        panel1.add(label2);
        
        String available2 = Integer.toString(available);
        label3.setText(available2+ " In Stock");
        label3.setFont(new Font("Sans", Font.BOLD, 10));
        panel1.add(label3);
        
        String price2 = Integer.toString(price);
        label4.setText("P"+price2);
        label4.setForeground(AMain.gold);
        label3.setFont(new Font("Sans", Font.BOLD, 10));
        panel1.add(label4);
        
        return panel1;
    }
    public static JPanel products(){
//        String[] categories = {"All Categories", "pandesal", "tig singko", "tig bente"};
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel5 = new JPanel(new BorderLayout());
        
        JComboBox combox = new JComboBox();
        for (Ddatabase.Category c : Ddatabase.category) {
        combox.addItem(c.categoryname);
        }
        
//        JButton b1 = new JButton(" Export");
        JButton b2 = new JButton(" Add Product");
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
       
        JButton b3 = new JButton();
        JButton b4 = new JButton();
        JButton b5 = new JButton();
        JButton b6 = new JButton();
        
        panel1.setBackground(AMain.cream);
        panel1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        
        panel3.setBackground(AMain.cream);
        panel3.setPreferredSize(new Dimension(0,50));
        // COMBO BOX TO NG CATEGORY SA INVENTORY KO NLNG NILAGAY YUNG FEATURE NATO // UNCOMMENT IF GUSTO
//        combox.setPreferredSize(new Dimension(170,35));
//        panel3.add(combox);
//        b1.setBackground(AMain.green);
//        b1.setFont(new Font("Sans", Font.BOLD,15));
//        b1.setPreferredSize(new Dimension(170,35));
//        b1.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/printer_export.png")));
//        panel3.add(b1);
        b2.setBackground(AMain.gold);
        b2.setFont(new Font("Sans", Font.BOLD,15));
        b2.setPreferredSize(new Dimension(170,35));
        b2.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/plus.png")));
        panel3.add(b2);
        panel2.add(panel3, BorderLayout.NORTH);
        
//        
//        
        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,50));
//        String t1 = Integer.toString(Ddatabase.product.size());
//        String t2 = Integer.toString(inStock);
//        String t3 = Integer.toString(lowStock);
//        String t4 = Integer.toString(outStock);
//        
//        b3.setFont(new Font("Sans", Font.BOLD, 12));
//        b3.setText("All "+t1);
//        b3.setPreferredSize(new Dimension(130,35));
//        b3.setBackground(AMain.white);
//      
//        b4.setFont(new Font("Sans", Font.BOLD, 12));
//        b4.setText("In stock "+t2);
//        b4.setPreferredSize(new Dimension(130,35));
//        b4.setBackground(AMain.white);
//        
//        b5.setFont(new Font("Sans", Font.BOLD, 12));
//        b5.setText("Low stock "+t3);
//        b5.setPreferredSize(new Dimension(130,35));
//        b5.setBackground(AMain.white);
//        
//        b6.setFont(new Font("Sans", Font.BOLD, 12));
//        b6.setText("Out of stock "+t4);
//        b6.setPreferredSize(new Dimension(130,35));
//        b6.setBackground(AMain.white);
//        
//        panel4.add(b3);
//        panel4.add(b4);
//        panel4.add(b5);
//        panel4.add(b6);
        
        panel2.add(panel4, BorderLayout.SOUTH);
        
        panel2.setBackground(Color.black);
        panel2.setPreferredSize(new Dimension(0,100));
        panel1.add(panel2, BorderLayout.NORTH);
        
        panel5.setBackground(Color.pink);
        
        
        
        JTable table = new JTable(product);
        table.setFont(new Font("Serif", Font.PLAIN,16));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        table.getTableHeader().setPreferredSize(new Dimension(0, 40));
        table.setRowHeight(32);
        table.setForeground(AMain.black);
        table.setBackground(AMain.white);
        refreshTableProd();
       
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        
        
        panel5.add(scroll, BorderLayout.CENTER);
        
        
        panel1.add(panel5, BorderLayout.CENTER);
        
        // ACTIONS
        
        //add product button
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // ADD CONFIRMATION IF USER ALREADY ADDED CATEGORY AND SUPPLIER FISRT 
                if(Ddatabase.category.isEmpty()){
                JOptionPane.showMessageDialog(null, "I Suggest Add Category First");
                return;
                }
                if(Ddatabase.supplier.isEmpty()){
                JOptionPane.showMessageDialog(null, "I Suggest Add Supplier First");
                return;
                }
                FpopUps.add();
            }
            
        });
        combox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            filter = (String) combox.getSelectedItem();   // what the user picked
            refreshTableProd();                           // rebuild the table
            }
        });
        
        
        
        return panel1;
    }
    public static JPanel category(){
//        String[] categories = {"All Categories", "pandesal", "tig singko", "tig bente"};
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel5 = new JPanel(new BorderLayout());
        
//        JButton b1 = new JButton(" Export");
        JButton b2 = new JButton(" Add Category");
        JButton b3 = new JButton(" Edit Category");
        
        panel1.setBackground(AMain.cream);
        panel1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        
        panel3.setBackground(AMain.cream);
        panel3.setPreferredSize(new Dimension(0,50));
        
    //        b1.setBackground(AMain.green);
    //        b1.setFont(new Font("Sans", Font.BOLD,15));
    //        b1.setPreferredSize(new Dimension(170,35));
    //        b1.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/printer_export.png")));
    //        panel3.add(b1);
        b2.setBackground(AMain.gold);
        b2.setFont(new Font("Sans", Font.BOLD,15));
        b2.setPreferredSize(new Dimension(170,35));
        b2.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/plus.png")));
        panel3.add(b2);
        b3.setBackground(AMain.gold);
        b3.setFont(new Font("Sans", Font.BOLD,15));
        b3.setPreferredSize(new Dimension(170,35));
        b3.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/edit_pencil.png")));
        panel3.add(b3);
        panel2.add(panel3, BorderLayout.NORTH);
        
        
        
        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,50));
        String t1 = Integer.toString(Ddatabase.product.size());
        String t2 = Integer.toString(inStock);
        String t3 = Integer.toString(lowStock);
        String t4 = Integer.toString(outStock);
        
        
        panel2.add(panel4, BorderLayout.SOUTH);
        
        panel2.setBackground(Color.black);
        panel2.setPreferredSize(new Dimension(0,100));
        panel1.add(panel2, BorderLayout.NORTH);
        
        panel5.setBackground(Color.pink);
        
        
        JTable table = new JTable(categorynames);
        table.setFont(new Font("Serif", Font.PLAIN,16));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        table.getTableHeader().setPreferredSize(new Dimension(0, 40));
        table.setRowHeight(32);
        table.setForeground(AMain.black);
        table.setBackground(AMain.white);
        refreshTableCat();
       
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        
        
        panel5.add(scroll, BorderLayout.CENTER);
        
        
        panel1.add(panel5, BorderLayout.CENTER);
        
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // ADD CONFIRMATION IF USER ALREADY ADDED CATEGORY AND SUPPLIER FISRT 
//                JOptionPane.showMessageDialog(null, "I Suggest Add Category and Supplier First");
                FpopUps.addCategory();
            }
            
        });
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FpopUps.editCategory();
            }
        });
        
        
        
        return panel1;
    }
    public static JPanel supplier(){
        //        String[] categories = {"All Categories", "pandesal", "tig singko", "tig bente"};
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel5 = new JPanel(new BorderLayout());
//        JComboBox combox = new JComboBox(categories);
//        JButton b1 = new JButton(" Export");
        JButton b2 = new JButton(" Add Supplier");
        JButton b3 = new JButton(" Edit Supplier");
        
        panel1.setBackground(AMain.cream);
        panel1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        
        panel3.setBackground(AMain.cream);
        panel3.setPreferredSize(new Dimension(0,50));
        
//        b1.setBackground(AMain.green);
//        b1.setFont(new Font("Sans", Font.BOLD,15));
//        b1.setPreferredSize(new Dimension(170,35));
//        b1.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/printer_export.png")));
//        panel3.add(b1);
        b2.setBackground(AMain.gold);
        b2.setFont(new Font("Sans", Font.BOLD,15));
        b2.setPreferredSize(new Dimension(170,35));
        b2.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/plus.png")));
        panel3.add(b2);
        b3.setBackground(AMain.gold);
        b3.setFont(new Font("Sans", Font.BOLD,15));
        b3.setPreferredSize(new Dimension(170,35));
        b3.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/edit_pencil.png")));
        panel3.add(b3);
        panel2.add(panel3, BorderLayout.NORTH);
        
        
        
        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,50));
        String t1 = Integer.toString(Ddatabase.product.size());
        String t2 = Integer.toString(inStock);
        String t3 = Integer.toString(lowStock);
        String t4 = Integer.toString(outStock);
        
        panel2.add(panel4, BorderLayout.SOUTH);
        
        panel2.setBackground(Color.black);
        panel2.setPreferredSize(new Dimension(0,100));
        panel1.add(panel2, BorderLayout.NORTH);
        
        panel5.setBackground(Color.pink);
        
       
        JTable table = new JTable(supplier);
        table.setFont(new Font("Serif", Font.PLAIN,16));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        table.getTableHeader().setPreferredSize(new Dimension(0, 40));
        table.setRowHeight(32);
        table.setForeground(AMain.black);
        table.setBackground(AMain.white);
        refreshTableSup();
       
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        
        
        panel5.add(scroll, BorderLayout.CENTER);
        
        
        panel1.add(panel5, BorderLayout.CENTER);
        
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // ADD CONFIRMATION IF USER ALREADY ADDED CATEGORY AND SUPPLIER FISRT 
//                JOptionPane.showMessageDialog(null, "I Suggest Add Category and Supplier First");
                FpopUps.addSupplier();
            }
            
        });
        
        b3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            FpopUps.editsupplier();
        }
        });
        
            
        
        return panel1;
    }
    public static JPanel inventory(){
//        String[] categories = {"All Categories", "pandesal", "tig singko", "tig bente"};
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel5 = new JPanel(new BorderLayout());
        
        JComboBox combox = new JComboBox();
        for (Ddatabase.Category c : Ddatabase.category) {
        combox.addItem(c.categoryname);
        }
        
//        JButton b0 = new JButton(" Export");
//        JButton b1 = new JButton(" Export");
        JButton b2 = new JButton(" Edit Product");
        stockFilter = "all";
        filter = "All Categories";
        // EDIT LATER mga value if meron paba or whatsoever sa INVENORY class
//        JLabel l1 = new JLabel();
//        JLabel l2 = new JLabel();
//        JLabel l3 = new JLabel();
//        JLabel l4 = new JLabel();
       
//        JButton b3 = new JButton();
//        JButton b4 = new JButton();
//        JButton b5 = new JButton();
//        JButton b6 = new JButton();
        
        panel1.setBackground(AMain.cream);
        panel1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        
        panel3.setBackground(AMain.cream);
        panel3.setPreferredSize(new Dimension(0,50));
        combox.setPreferredSize(new Dimension(170,35));
        panel3.add(combox);
//        b1.setBackground(AMain.green);
//        b1.setFont(new Font("Sans", Font.BOLD,15));
//        b1.setPreferredSize(new Dimension(170,35));
//        b1.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/printer_export.png")));
//        panel3.add(b1);
        b2.setBackground(AMain.gold);
        b2.setFont(new Font("Sans", Font.BOLD,15));
        b2.setPreferredSize(new Dimension(170,35));
        b2.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/edit_pencil.png")));
        panel3.add(b2);
        panel2.add(panel3, BorderLayout.NORTH);
        
        
        
        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,50));
        String t1 = Integer.toString(Ddatabase.product.size());
        String t2 = Integer.toString(inStock);
        String t3 = Integer.toString(lowStock);
        String t4 = Integer.toString(outStock);
        
        b3.setFont(new Font("Sans", Font.BOLD, 12));
        b3.setForeground(AMain.gold);
        b3.setText("All "+t1);
        b3.setPreferredSize(new Dimension(130,35));
        b3.setBackground(AMain.dgreen);
      
        b4.setFont(new Font("Sans", Font.BOLD, 12));
        b4.setForeground(AMain.gold);
        b4.setText("In stock "+t2);
        b4.setPreferredSize(new Dimension(130,35));
        b4.setBackground(AMain.dgreen);
        
        b5.setFont(new Font("Sans", Font.BOLD, 12));
        b5.setForeground(AMain.gold);
        b5.setText("Low stock "+t3);
        b5.setPreferredSize(new Dimension(130,35));
        b5.setBackground(AMain.dgreen);
        
        b6.setFont(new Font("Sans", Font.BOLD, 12));
        b6.setForeground(AMain.gold);
        b6.setText("Out of stock "+t4);
        b6.setPreferredSize(new Dimension(130,35));
        b6.setBackground(AMain.dgreen);
        
        panel4.add(b3);
        panel4.add(b4);
        panel4.add(b5);
        panel4.add(b6);
        
        panel2.add(panel4, BorderLayout.SOUTH);
        
        panel2.setBackground(Color.black);
        panel2.setPreferredSize(new Dimension(0,100));
        panel1.add(panel2, BorderLayout.NORTH);
        
        panel5.setBackground(Color.pink);
        
        
        
        JTable table = new JTable(product);
        table.setFont(new Font("Serif", Font.PLAIN,16));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        table.getTableHeader().setPreferredSize(new Dimension(0, 40));
        table.setRowHeight(32);
        table.setForeground(AMain.black);
        table.setBackground(AMain.white);
        refreshTableProd();
       
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        
        
        panel5.add(scroll, BorderLayout.CENTER);
        
        
        panel1.add(panel5, BorderLayout.CENTER);
        
        // ACTIONS
        
        //add product button
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // ADD CONFIRMATION IF USER ALREADY ADDED CATEGORY AND SUPPLIER FISRT 
                if(Ddatabase.category.isEmpty()){
                JOptionPane.showMessageDialog(null, "I Suggest Add Category First");
                return;
                }
                if(Ddatabase.supplier.isEmpty()){
                JOptionPane.showMessageDialog(null, "I Suggest Add Supplier First");
                return;
                }
                FpopUps.editProduct();
            }
            
        });
        combox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            filter = (String) combox.getSelectedItem();   // what the user picked
            refreshTableProd();                           // rebuild the table
            }
        });
        b3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            stockFilter = "all";
            refreshTableProd();
        }
        });

        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                stockFilter = "in stock";
                refreshTableProd();
            }
        });

        b5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                stockFilter = "low stock";
                refreshTableProd();
            }
        });

        b6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                stockFilter = "out of stock";
                refreshTableProd();
            }
        });
        
        
        return panel1;
    }
    public static JPanel customer() {
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel5 = new JPanel(new BorderLayout());

        panel1.setBackground(AMain.cream);
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // HEADER: only the invoice combobox
        panel3.setBackground(AMain.cream);
        panel3.setPreferredSize(new Dimension(0, 50));
        cbInvoice.setPreferredSize(new Dimension(220, 35));
        panel3.add(cbInvoice);

        panel2.add(panel3, BorderLayout.NORTH);
        panel2.setBackground(AMain.cream);
        panel2.setPreferredSize(new Dimension(0, 50));
        panel1.add(panel2, BorderLayout.NORTH);

        // TABLE
        JTable table = new JTable(customer);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        table.getTableHeader().setPreferredSize(new Dimension(0, 40));
        table.setRowHeight(32);
        table.setForeground(AMain.black);
        table.setBackground(AMain.white);

        refreshCustomerCombo();
        refreshTableCustomer();

        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        panel5.setBackground(AMain.cream);
        panel5.add(scroll, BorderLayout.CENTER);
        panel1.add(panel5, BorderLayout.CENTER);

        // ACTION
        for (ActionListener al : cbInvoice.getActionListeners()) {
        cbInvoice.removeActionListener(al);
        }
        cbInvoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (updatingCombo || cbInvoice.getSelectedItem() == null) return;
                customerFilter = (String) cbInvoice.getSelectedItem();
                refreshTableCustomer();
            }
        });

        return panel1;
    }
    public static JPanel employee(){
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel5 = new JPanel(new BorderLayout());

        JButton b2 = new JButton(" Add Employee");
        JButton b3 = new JButton(" Edit Employee");

        panel1.setBackground(AMain.cream);
        panel1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel3.setBackground(AMain.cream);
        panel3.setPreferredSize(new Dimension(0,50));

        b2.setBackground(AMain.gold);
        b2.setFont(new Font("Sans", Font.BOLD,15));
        b2.setPreferredSize(new Dimension(170,35));
        b2.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/plus.png")));
        panel3.add(b2);
        b3.setBackground(AMain.gold);
        b3.setFont(new Font("Sans", Font.BOLD,15));
        b3.setPreferredSize(new Dimension(170,35));
        b3.setIcon(new ImageIcon(AMain.class.getResource("/24px icon/light/24px/edit_pencil.png")));
        panel3.add(b3);
        panel2.add(panel3, BorderLayout.NORTH);

        panel4.setBackground(AMain.green);
        panel4.setPreferredSize(new Dimension(0,50));
        panel2.add(panel4, BorderLayout.SOUTH);

        panel2.setBackground(Color.black);
        panel2.setPreferredSize(new Dimension(0,100));
        panel1.add(panel2, BorderLayout.NORTH);

        panel5.setBackground(Color.pink);

        JTable table = new JTable(employee);
        table.setFont(new Font("Serif", Font.PLAIN,16));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        table.getTableHeader().setPreferredSize(new Dimension(0, 40));
        table.setRowHeight(32);
        table.setForeground(AMain.black);
        table.setBackground(AMain.white);
        refreshTableEmployee();

        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));

        panel5.add(scroll, BorderLayout.CENTER);
        panel1.add(panel5, BorderLayout.CENTER);

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FpopUps.addEmployee();
            }
        });

        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FpopUps.editEmployee();
            }
        });

        return panel1;
    }
    public static JPanel settings(){
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));    // top buttons
        JPanel panel3 = new JPanel(new BorderLayout());                 // holds the fields
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));   // save button
        JPanel profilePanel = new JPanel(null);
        JPanel accountPanel = new JPanel(null);

        JButton b1 = new JButton("User Profile");
        JButton b2 = new JButton("Admin Account");
        JButton save = new JButton("Save Changes");

        // user profile fields
        JLabel l1 = new JLabel("Full name");
        JLabel l2 = new JLabel("Position");
        JLabel l3 = new JLabel("Email");
        JLabel l4 = new JLabel("Phone number");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();

        // admin account fields
        JLabel l5 = new JLabel("Username");
        JLabel l6 = new JLabel("Current password");
        JLabel l7 = new JLabel("New password");
        JLabel l8 = new JLabel("Confirm new password");
//        JLabel nametext = new JLabel("Enter System Name"); // sysname
//        JTextField nameholder = new JTextField();  // tfieldname
        JTextField t5 = new JTextField();
        JPasswordField t6 = new JPasswordField();
        JPasswordField t7 = new JPasswordField();
        JPasswordField t8 = new JPasswordField();

        boolean[] onProfile = {true};                       // which tab is open
        String loginName = AMain.loginName;    // who is logged in
        Ddatabase.Admin[] adm = new Ddatabase.Admin[1];
        Ddatabase.Employee[] emp = new Ddatabase.Employee[1];

        // find the logged in account
        for (Ddatabase.Admin a : Ddatabase.admin) {
            if (a.username.equalsIgnoreCase(loginName)) {
                adm[0] = a;
            }
        }
        for (Ddatabase.Employee e : Ddatabase.employee) {
            if (e.username.equalsIgnoreCase(loginName)) {
                emp[0] = e;
            }
        }

        // layout
        panel1.setBackground(AMain.cream);
        panel1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel2.setBackground(AMain.cream);
        b1.setBackground(AMain.gold);
        b1.setFont(new Font("Sans", Font.BOLD, 15));
        b1.setPreferredSize(new Dimension(170,35));
        panel2.add(b1);
        b2.setBackground(AMain.green);
        b2.setForeground(AMain.gold);
        b2.setFont(new Font("Sans", Font.BOLD, 15));
        b2.setPreferredSize(new Dimension(170,35));
        panel2.add(b2);
        panel1.add(panel2, BorderLayout.NORTH);

        profilePanel.setBackground(AMain.white);
        l1.setBounds(40, 20, 200, 20);
        t1.setBounds(40, 40, 470, 30);
        l2.setBounds(40, 80, 200, 20);
        t2.setBounds(40, 100, 470, 30);
        l3.setBounds(40, 140, 200, 20);
        t3.setBounds(40, 160, 470, 30);
        l4.setBounds(40, 200, 200, 20);
        t4.setBounds(40, 220, 470, 30);
//        nametext.setBounds(40, 260, 200, 20);
//        nameholder.setBounds(40, 280, 470, 30);
        profilePanel.add(l1);
        profilePanel.add(t1);
        profilePanel.add(l2);
        profilePanel.add(t2);
        profilePanel.add(l3);
        profilePanel.add(t3);
        profilePanel.add(l4);
        profilePanel.add(t4);
//        profilePanel.add(nametext);
//        profilePanel.add(nameholder);

        accountPanel.setBackground(AMain.white);
        l5.setBounds(40, 20, 200, 20);
        t5.setBounds(40, 40, 470, 30);
        l6.setBounds(40, 80, 200, 20);
        t6.setBounds(40, 100, 470, 30);
        l7.setBounds(40, 140, 200, 20);
        t7.setBounds(40, 160, 470, 30);
        l8.setBounds(40, 200, 200, 20);
        t8.setBounds(40, 220, 470, 30);
        accountPanel.add(l5);
        accountPanel.add(t5);
        accountPanel.add(l6);
        accountPanel.add(t6);
        accountPanel.add(l7);
        accountPanel.add(t7);
        accountPanel.add(l8);
        accountPanel.add(t8);

        panel3.add(profilePanel, BorderLayout.CENTER);
        panel3.setBorder(BorderFactory.createEmptyBorder(15,0,15,0));
        panel3.setOpaque(false);
        panel1.add(panel3, BorderLayout.CENTER);

        panel4.setBackground(AMain.cream);
        save.setBackground(AMain.green);
        save.setForeground(AMain.gold);
        save.setFont(new Font("Sans", Font.BOLD, 15));
        save.setPreferredSize(new Dimension(170,40));
        panel4.add(save);
        panel1.add(panel4, BorderLayout.SOUTH);

        // fill the fields with the current data
        if (adm[0] != null) {
            t1.setText(adm[0].name);
            t2.setText(adm[0].position);
            t3.setText(adm[0].email);
            t4.setText(adm[0].phoneNumber);
        } else if (emp[0] != null) {
            t1.setText(emp[0].name);
            t2.setText(emp[0].position);
            t3.setText(emp[0].email);
            t4.setText(emp[0].phoneNumber);
        }
        t5.setText(loginName);

        // ACTIONS
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onProfile[0] = true;
                panel3.removeAll();
                panel3.add(profilePanel, BorderLayout.CENTER);
                panel3.revalidate();
                panel3.repaint();
            }
        });

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onProfile[0] = false;
                panel3.removeAll();
                panel3.add(accountPanel, BorderLayout.CENTER);
                panel3.revalidate();
                panel3.repaint();
            }
        });

        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // if the logged in account is not in the lists yet, create it
                if (adm[0] == null && emp[0] == null) {
                    adm[0] = new Ddatabase.Admin("Admin", "", "", "", "", loginName, "");
                    Ddatabase.admin.add(adm[0]);
                }
                

                if (onProfile[0]) {
                    String name = t1.getText().trim();
                    String position = t2.getText().trim();
                    String email = t3.getText().trim();
                    String phone = t4.getText().trim();

                    if (name.isEmpty() || position.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!email.contains("@") || !email.contains(".")) {
                        JOptionPane.showMessageDialog(null, "Enter a valid email.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!phone.matches("[0-9+\\- ]+")) {
                        JOptionPane.showMessageDialog(null, "Phone should only contain numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (adm[0] != null) {
                        adm[0].name = name;
                        adm[0].position = position;
                        adm[0].email = email;
                        adm[0].phoneNumber = phone;
                    } else {
                        emp[0].name = name;
                        emp[0].position = position;
                        emp[0].email = email;
                        emp[0].phoneNumber = phone;
                    }
                    AMain.profilename = name;     // name shown in the topbar
                    refreshTableEmployee();
                    JOptionPane.showMessageDialog(null, "Profile saved.");
                }
                else {
                    String username = t5.getText().trim();
                    String current = new String(t6.getPassword());
                    String newPass = new String(t7.getPassword());
                    String confirm = new String(t8.getPassword());
                    String stored = (adm[0] != null) ? adm[0].password : emp[0].password;

                    if (username.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter a username.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!current.equals(stored)) {
                        JOptionPane.showMessageDialog(null, "Current password is wrong.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!newPass.isEmpty() && !newPass.equals(confirm)) {
                        JOptionPane.showMessageDialog(null, "New passwords do not match.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // username must not be used by someone else
                    for (Ddatabase.Admin a : Ddatabase.admin) {
                        if (a != adm[0] && a.username.equalsIgnoreCase(username)) {
                            JOptionPane.showMessageDialog(null, "That username is already taken.", "Duplicate", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    for (Ddatabase.Employee em : Ddatabase.employee) {
                        if (em != emp[0] && em.username.equalsIgnoreCase(username)) {
                            JOptionPane.showMessageDialog(null, "That username is already taken.", "Duplicate", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }

                    if (adm[0] != null) {
                        adm[0].username = username;
                        if (!newPass.isEmpty()) {
                            adm[0].password = newPass;
                        }
                    } else {
                        emp[0].username = username;
                        if (!newPass.isEmpty()) {
                            emp[0].password = newPass;
                        }
                    }
                    AMain.loginName = username; ;   // keeps the lookup working next time
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    refreshTableEmployee();
                    JOptionPane.showMessageDialog(null, "Account saved.");
                }
            }
//            String syname = nameholder.getText().trim().toString();
//            if(syname.isEmpty()){
//                    JOptionPane.showMessageDialog(null, "Please input System Name");
//                    return;
//                }
//            else{
//                AMain.Sname = syname;
//            }
            
        });

        return panel1;
    }
}
