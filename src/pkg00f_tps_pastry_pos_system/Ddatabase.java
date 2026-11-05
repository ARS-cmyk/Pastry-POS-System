
package pkg00f_tps_pastry_pos_system;

import java.util.ArrayList;

public class Ddatabase {
    
    public static ArrayList<Employee> employee = new ArrayList<>();
    public static ArrayList<Admin> admin = new ArrayList<>();
    public static ArrayList<Product> product = new ArrayList<>();
    public static ArrayList<Category> category = new ArrayList<>();
    public static ArrayList<Supplier> supplier = new ArrayList<>();
    public static ArrayList<CartItem> cartItem = new ArrayList<>();
    public static ArrayList<Sale> sales = new ArrayList<>();
    public static ArrayList<Customer> customer = new ArrayList<>();
    public static ArrayList<Profile> profile = new ArrayList<>();
    
    static{
        category.add(new Category("All Categories",0,0));
    }
    
    
    
    public static class Employee{
    public String role;
    public String name;
    public String position;
    public String email;
    public String phoneNumber;
    public String username;
    public String password;
    
    public Employee(String role,String name,String position,String email,String phoneNumber,String username, String password){
        this.role = role;
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }
    }
    
    public static class Admin{
    public String role;
    public String name;
    public String position;
    public String email;
    public String phoneNumber;
    public String username;
    public String password;
    
    public Admin(String role,String name,String position,String email,String phoneNumber,String username, String password){
        this.role = role;
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }
    }
    
    public static class Product{
        public String code, name, category, supplier;
        public double cost, price;
        public int stock, lowAlert;
    public Product(String code, String name, String category, String supplier,double cost, double price, int stock, int lowAlert){
            this.code = code; 
            this.name = name; 
            this.category = category;
            this.supplier = supplier; 
            this.cost = cost; 
            this.price = price;
            this.stock = stock; 
            this.lowAlert = lowAlert;
        }
    }
    
    public static class Category{
        
        public String categoryname;
        public int prodQuan;
        public double sales;
    public Category(String categoryname,int prodQuan,double sales){
            this.categoryname = categoryname;
            this.prodQuan = prodQuan;
            this.sales = sales;
        }
    }

    public static class Supplier{
        public  String comName;
        public  String manName,email, loc, phone;
        public double  purchases;
        
    public Supplier(String comName,String manName,String loc, String phone,String email,double purchases){
        this.comName = comName;
        this.email = email;
        this.manName = manName;
        this.loc = loc;
        this.phone = phone;
        this.purchases = purchases;
    }    
    }
    
    public static class CartItem{
        public String nameCus;
        public String code;
    public CartItem(String nameCus,String code){
        this.nameCus = nameCus;
        this.code = code;
    }
}
    
    public static class Sale{
        public String customer, invoice;
        public double amountPaid;   
        public double revenue;      
        public double cost;        
        public java.time.LocalDate date;

    public Sale(String customer, String invoice, double amountPaid, double revenue, double cost){
        this.customer = customer;
        this.invoice = invoice;
        this.amountPaid = amountPaid;
        this.revenue = revenue;
        this.cost = cost;
        this.date = java.time.LocalDate.now();  
    }
}
    
    public static class Customer{
        public String cusname;
        public String inv;
        public double bill;
        public double vat;
        public double discount;
        public double money;
        public double total;
        public String dateTime = java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

    public Customer(String cusname,String inv,double bill,double vat,double discount,double money,double total){
        this.cusname = cusname;
        this.inv = inv;
        this.bill = bill;
        this.vat = vat;
        this.discount = discount;
        this.money = money;
        this.total = total;
    }
        
    }
    
    public static class Profile{
    public String username;      
    public String displayName;   
    public String email;
    public String phone;

    public Profile(String username, String displayName, String email, String phone){
        this.username = username;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
    }
}
    
//    public Ddatabase(String username, String password, String passwordCon){
//        this.username = username;
//        this.password = password;
//        this.passwordCon = passwordCon;
//    }
//    public Ddatabase (int pin){
//        this.pin = pin;
//    }
    
    
}
