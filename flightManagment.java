
package finalfinalproject;

import static finalfinalproject.MenueGui.p;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class flightManagment {
    
}
abstract class  Person implements Serializable {
   
    private String name ;
    private int age;
    private int PhoneNum;
    private String  address;
    private String gender;
    private String username ;
    private String Password ;
    public  Person(){}
   
     Person(String name , int age , int PhoneNum , String  address, String  gender ,String username ,String Password){
        this.name = name ;
        this.age = age;
        this.address = address;
        this.gender = gender ;
        this.PhoneNum = PhoneNum;
        this.username = username;
        this.Password = Password;
    }

    
    public void addPerson(String name , int age , int PhoneNum , String  address, String  gender ){
        this.name = name ;
        this.age = age;
        this.address = address;
        this.gender = gender ;
        this.PhoneNum = PhoneNum;
        
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getPhoneNum() {
        return PhoneNum;
    }
    public String getusername(){
        return username ;
    }
    public String getpassword(){
        return Password ;
    }
     
    
     
      public void setName(String name) {
        this.name = name;
    }
      public  void setusername(String userName){
          username = userName;
      }
      public void setpassword ( String Password ){
          this.Password = Password;
      }

    public void setAge(int age) {
        this.age = age;
    }
    public void setGender (String  gender ){
        this.gender = gender;
    }
    public void setPhoneNum(int PhoneNum) {
        this.PhoneNum = PhoneNum;
    }
    public void setAddress(String address){
        this.address= address;
    }    
}
class login extends Person {
    
}

class Account extends Person implements Serializable {
    private String username;
    private String password;
    
    public Account(){
        username ="";
        password = "";
    }
    public Account(String username ,String password){
        this.username = username;
        this.password = password;
        
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 
    
}

class Flight implements Serializable,prices {
    private LocalTime DepartureTime= LocalTime.of(10,42,10);
    private String flightClass; 
    private int  Flight_id;
    private int NoOfSeats;
    private String departurePlace;
    private String destination;
    private String  DepartureDate;
    private String ArrivalDate;
    private double bill;
    public Flight(int Flight_id, int NoOfSeats, String departurePlace, String destination, String DepartureDate, String ArrivalDate,double b,String fc) {
        this.Flight_id = Flight_id;
        this.NoOfSeats = NoOfSeats;
        this.departurePlace = departurePlace;
        this.destination = destination;
        this.DepartureDate = DepartureDate;
        this.ArrivalDate = ArrivalDate;
        bill = b;
        flightClass = fc ; 
    }
    
    
    
    
    Flight(){
      
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
      public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
    
     public Double TotalBill (int seats){
         return 0.0;
     };
    public void display(){
        System.out.println("Flight ID :"+ Flight_id);
        System.out.println("Seats " + NoOfSeats);
        System.out.println("Deaprture Date :"+DepartureDate);
        System.out.println("Arrival Date" + ArrivalDate);
        System.out.println("Destination" +destination);
        System.out.println("Total Bill :" +this.TotalBill(NoOfSeats));
    }
    

    public String getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(String DepartureDate) {
        this.DepartureDate = DepartureDate;
    }

    public String getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(String ArrivalDate) {
        this.ArrivalDate = ArrivalDate;
    }

    public LocalTime getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(LocalTime DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public int getFlight_id() {
        return Flight_id;
    }

    public void setFlight_id() {
        Flight_id = (int) (Math.random()*1000);
    }

    public int getNoOfSeats() {
        return NoOfSeats;
    }

    public void setNoOfSeats(int NoOfSeats) {
        this.NoOfSeats = NoOfSeats;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getArrivalPlace() {
        return destination;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.destination = arrivalPlace;
    }

    public LocalTime getEta() {
        return Eta;
    }

    public void setEta(LocalTime Eta) {
        this.Eta = Eta;
    }
    private LocalTime Eta = DepartureTime.plusHours(10);
    
       
    
    
 public  void NewTicket(File p,int id,int NoOfSeats, String departurePlace, String destination, String DepartureDate, String ArrivalDate,double b,String fc ) throws FileNotFoundException, IOException, ClassNotFoundException{
  //Flight_id, int NoOfSeats, String departurePlace, String destination, String DepartureDate, String ArrivalDate,double b
        Flight c = new Flight(id, NoOfSeats,departurePlace,destination,DepartureDate,ArrivalDate,b,fc);
        ObjectOutputStream oos;
        if(p.exists()){
            FileOutputStream fos = new FileOutputStream(p,true);
            oos = new   MyObjectOutputStream(fos);
           
            oos.writeObject(c);
            
        }
        else{
             FileOutputStream fos = new FileOutputStream(p);
             oos = new ObjectOutputStream(fos);
             oos.writeObject(c);
             
        }
        
        oos.close();
    }
 
public  boolean SearchTicket(int id,File f) throws FileNotFoundException, IOException, ClassNotFoundException{
     boolean found = false;
        try{  
              FileInputStream fis = new FileInputStream(f); 
                ObjectInputStream ois = new ObjectInputStream(fis);
        
        while (true ){
            Flight c2 = (Flight) ois.readObject();
            if(c2.getFlight_id()==id) {
                
                JOptionPane.showMessageDialog(null,"Your flight  exists OK to view details");
                
                String s = "Arrival Date:  "+c2.ArrivalDate;
                String d = "Departure Time:  " +c2.DepartureTime ;
                String dd = "Destiantion:  " +c2.destination;
                String no = "Number of Seats Booked  "+ c2.NoOfSeats ;
                
                JOptionPane.showMessageDialog(null,s+"\n"+d+"\n"+dd+"\n"+"\n"+no);
                
                
                found=true;
            break;
            }
            else{
               
                return found = false;   
            }
        }
        
        
    }
     catch(EOFException e){
         
     }
     if(!found){
           JOptionPane.showMessageDialog(null," Your Filght does not exists ");
        }
        return false;
       
}
public  void updateTicket(int id,File f) throws FileNotFoundException, IOException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
         boolean found = false;
        
         File temp = new File("p.txt");
        try{  

        FileInputStream fis = new FileInputStream(f); 
        ObjectInputStream ois = new ObjectInputStream(fis);
                 Flight c2;
  
        do{
           c2 = (Flight) ois.readObject();

            if (c2.getFlight_id()==id){
                found = true;
                
                System.out.println("Ticket found ");
                System.out.println("Enter updated information");
                System.out.println("enter new Destination");
                String newD = input.next();
                System.out.println("enter new Arrival Date  ");
                String newA = input.next();
                System.out.println("enter new number of seats");
                
                 int   newSeats = input.nextInt();
               String dd = input.next();
               String fc =input.next();
               c2.setFlightClass(fc);
               c2.setDepartureDate(dd);
                c2.setArrivalPlace(newD);
                c2.setArrivalDate(newA);
                c2.setNoOfSeats(newSeats);
             //   File p,int id,int NoOfSeats, String departurePlace, String destination, String DepartureDate, String ArrivalDate,double b
                NewTicket( temp,c2.getFlight_id(), c2.getNoOfSeats(), c2.getDeparturePlace(),
                        c2.getArrivalPlace(), c2.getDepartureDate(), c2.getArrivalDate(),
                        c2.getBill(),c2.getFlightClass());
            }
            else {
               
                 NewTicket(temp,c2.getFlight_id(), c2.getNoOfSeats(), c2.getDeparturePlace()
                         ,c2.getArrivalPlace(), c2.getDepartureDate(), c2.getArrivalDate(),
                         c2.getBill(),c2.getFlightClass());

            }
           
                
        }while (c2!=null);
     
   
        
    }
        
     catch(EOFException e){
         
     }
     if(found){
               System.out.println("Contact updated");
        }
        else{
            System.out.println("Record dose not Exist");
        }
       ObjectOutputStream oos;
       try{
       oos = new ObjectOutputStream(new FileOutputStream(f));
       FileInputStream fis = new FileInputStream(temp); 
       ObjectInputStream ois = new ObjectInputStream(fis);
        
        
         
        while(true){
              Flight c2 = (Flight) ois.readObject();
              oos.writeObject(c2);
            
        }
       }
       catch(EOFException w){
           
       }
      

    }
  public  boolean deleteTicket(int id,File f) throws FileNotFoundException, IOException, ClassNotFoundException{
         boolean found = false;
        File temp2 = new File("p2.txt");
        try{  
      
        FileInputStream fis = new FileInputStream(f); 
        ObjectInputStream ois = new ObjectInputStream(fis);
         Flight c2;
      
        do{
           c2 = (Flight) ois.readObject();
             if (c2.getFlight_id()==id){
                
                found = true;
            }
            else{
              
               NewTicket(temp2,c2.getFlight_id(), c2.getNoOfSeats(),
                       c2.getDeparturePlace(),c2.getArrivalPlace(), c2.getDepartureDate(),
                       c2.getArrivalDate(), c2.getBill(),c2.getFlightClass());

            }       
        }while(c2!=null);
        ois.close();
    }
        
     catch(EOFException e){
         
     }
         if(found){
               JOptionPane.showMessageDialog(null,"Your Flight has been canceled");
        }
        else{
             JOptionPane.showMessageDialog(null,"Record Does not exists");
         }
         ObjectOutputStream oos;
       try{
       oos = new ObjectOutputStream(new FileOutputStream(f));
       FileInputStream fis = new FileInputStream(temp2); 
       ObjectInputStream ois = new ObjectInputStream(fis);
        
        
         
        while(true){
              Flight c2 = (Flight) ois.readObject();
              
              oos.writeObject(c2);
            
        }
       }
       catch(EOFException w){
           
       }
     return found; 
    }
 }




interface prices {
    final double economyTicket =7000;
    final double FirstClassTicket =15000;
    final double BuissnessTicket =10000;
}
class economy extends Flight implements prices{

    @Override
    public Double TotalBill(int seats) {
      return economyTicket *seats; 
    }   
    
    
}
class Firstclass extends Flight implements prices{

    @Override
    public Double TotalBill(int seats) {
      return FirstClassTicket * seats;
    }
    
}
class BuisnessClass extends Flight implements prices {

    @Override
    public Double TotalBill(int seats) {
      return BuissnessTicket *seats;  
    }
    
    
}
class MenueGui extends JFrame implements ActionListener{
   
   
      static   File p = new File("Flight.txt ");
    JButton b1 = new JButton("Book a Flight");
    JButton b2 = new JButton("Cancel FLight");
    JButton b3 = new JButton("check Flight Description");
    JButton b4 = new JButton("Print Ticket");
    JButton b5 = new JButton("LOGOUT :(");
    
   
    public MenueGui(File g ){
        p= g;
    }
    public MenueGui(int x){
        
    }
    
    
     MenueGui(){
         // First Gui for the Menu 
         JPanel mypp = new JPanel (new GridLayout(5,0));
         b1.setBackground(Color.red);
         b2.setBackground(Color.ORANGE);
         b3.setBackground(Color.YELLOW);
         b4.setBackground(Color.GREEN);
         
         b1.addActionListener(this);
         b2.addActionListener(this);
         b3.addActionListener(this);
         b4.addActionListener(this);
         b5.addActionListener(this);
         
         mypp.add(b1);
         mypp.add(b2);
         mypp.add(b3);
         mypp.add(b4);
         mypp.add(b5);
         JLabel l1 = new JLabel("*************HELLO CUSTOMER***************** ");
         l1.setBackground(Color.black);
         l1.setFont(new Font(l1.getText(),Font.ITALIC,20));
         JLabel l2 = new JLabel("What would you like to do? ");
         l2.setFont(new Font(l1.getText(),Font.ITALIC,20));
         JPanel p2 = new JPanel (new GridLayout(2,0));
         p2.add(l1);
         p2.add(l2);
         JFrame f2 = new JFrame("Account");
         f2.add(mypp,BorderLayout.CENTER);
         f2.add(p2,BorderLayout.NORTH);
         f2.setVisible(true);
         f2.setSize(500,500);
         f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
     }
     public File getFile(){
         return  p;
     }
     
     
        
    
         

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1)
        {
            //adding new reservations from here 
            flightGUI g = new flightGUI();    
        }
        else if (e.getSource()==b2){
            //canceling your flight wala code iddr jaye ga (Deleting)
           cancelFlightGUI cfg = new cancelFlightGUI();
           // deleteTicketGui g = new deleteTicketGui();
          
        }
        else if (e.getSource()==b3){
            //Searching for your flight will occur here at this moment 
            SearchFlightGUI sfg = new SearchFlightGUI();
        }
        else if (e.getSource()==b4){
            printD ticket = new printD();
            
        }
        else if(e.getSource()==b5){
            System.exit(0);
        }
       
    }
}
class SearchFlightGUI{
       JPanel p3 = new JPanel();
       JTextField t3 = new JTextField(10);
       

          SearchFlightGUI(){
              p3.add(new JLabel("Enter Id You want to Search "));
              p3.add(t3);
              int result = JOptionPane.showConfirmDialog(null, p3, 
               " Please fill in the form given below ", JOptionPane.OK_CANCEL_OPTION);
           if(result == JOptionPane.OK_OPTION){
               String delTick = t3.getText();
               int del = Integer.parseInt(delTick);
               try {
                Flight ffs = new Flight();
                ffs.SearchTicket(del, p);
            } catch (IOException ex) {
                Logger.getLogger(cancelFlightGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cancelFlightGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
              
          }
}

class cancelFlightGUI extends JFrame {

   
        
       JPanel p1 = new JPanel();
       JTextField t1 = new JTextField(10);
       JButton b2 = new JButton("Delete ticket:");
       
       
    cancelFlightGUI(){
        p1.add(new JLabel("Enter Id You want to Delete"));
        p1.add(t1);
        
        int result = JOptionPane.showConfirmDialog(null, p1, 
               " Please fill in the form given below ", JOptionPane.OK_CANCEL_OPTION);
           if(result == JOptionPane.OK_OPTION){
               String delTick = t1.getText();
               int del = Integer.parseInt(delTick);
               try {
                Flight ffs = new Flight();
                ffs.deleteTicket(del, p);
            } catch (IOException ex) {
                Logger.getLogger(cancelFlightGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cancelFlightGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
           }            
    }

    
}

class flightGUI extends JFrame implements ActionListener,Serializable {
   
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextField t5 = new JTextField();
    

    
    JRadioButton r1 = new JRadioButton("Economy");
    JRadioButton r2 = new JRadioButton("First Class");
    JRadioButton r3 = new JRadioButton("Buisness Class");
     
   
    JButton b1 = new JButton("BOOK FLight") ;
    flightGUI(){
        ButtonGroup b = new ButtonGroup();
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        b.add(r1);
        b.add(r2);
        b.add(r3);
      
       JLabel l2 = new JLabel(" Enter Departure city");
       JLabel l3 = new JLabel("  Enter Arrival city");
       JLabel l4 = new JLabel("  Enter Number of seats");
       JLabel l5 = new JLabel("  Departure Date(dd-mm-yy)");
       JLabel l6 = new JLabel("  Arrival Date(dd-mm-yy)");
       JPanel p = new JPanel(new GridLayout(5,0));
      
       p.add(l2);
       p.add(l3);
       p.add(l4);
       p.add(l5);
       p.add(l6);
       JPanel p2 = new JPanel(new GridLayout(5,0));
       
       p2.add(t1);
        p2.add(t2);
       p2.add(t3);
       p2.add(t4);
        p2.add(t5);
        
        JPanel p3 = new JPanel(new GridLayout(3,0));
        p3.add(r1);
        p3.add(r2);
        p3.add(r3);
        
        b1.addActionListener(this);
        JFrame f =new JFrame("Ticket");
        f.add(p,BorderLayout.WEST);
        f.add(p2,BorderLayout.CENTER);
        f.add(p3,BorderLayout.EAST);
        f.add(b1,BorderLayout.SOUTH);
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
}


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
         
            if (r1.isSelected()){
                
                    Flight f1 = new economy();
                    f1.setFlight_id();
                    JOptionPane.showMessageDialog(null,"Your Flight ID is "+f1.getFlight_id());
                    f1.setNoOfSeats(Integer.parseInt(t3.getText()));
                    f1.setDeparturePlace(t1.getText());
                    f1.setArrivalPlace(t2.getText());
                    f1.setDepartureDate(t4.getText());
                    f1.setArrivalDate(t5.getText());
                    f1.setDepartureTime(LocalTime.MIN);
                    double b =f1.TotalBill(f1.getNoOfSeats());
                    f1.setBill(b);
                    f1.setFlightClass(r1.getText());
                try{
                    f1.NewTicket(p,f1.getFlight_id(), f1.getNoOfSeats(), f1.getDeparturePlace(),f1.getArrivalPlace()
                            , f1.getDepartureDate(), f1.getArrivalDate(), f1.getBill(),f1.getFlightClass());
                 
                    } catch (ClassNotFoundException ex) {
                    Logger.getLogger(flightGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(flightGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
                        
 
                  
    }
            
            if(r2.isSelected()){
                Flight f2 = new Firstclass();
                f2.setFlight_id();
                JOptionPane.showMessageDialog(null,"Your Flight ID is  "+f2.getFlight_id());
                f2.setNoOfSeats(Integer.parseInt(t3.getText()));
                f2.setDeparturePlace(t1.getText());
                f2.setArrivalPlace(t2.getText());
                f2.setDepartureTime(LocalTime.MIN);
                f2.setDepartureDate(t4.getText());
                f2.setArrivalDate(t5.getText());
                 double b =f2.TotalBill(f2.getNoOfSeats());
                 f2.setBill(b);
                  f2.setFlightClass(r2.getText());
                  try{
                    f2.NewTicket(p,f2.getFlight_id(), f2.getNoOfSeats(), f2.getDeparturePlace()
                            ,f2.getArrivalPlace(), f2.getDepartureDate(), f2.getArrivalDate()
                            , f2.getBill(),f2.getFlightClass());
                 
                    } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(flightGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
            if(r3.isSelected()){
                Flight f3 = new BuisnessClass();
                f3.setFlight_id();
                JOptionPane.showMessageDialog(null,"Your Flight ID is "+f3.getFlight_id());
                f3.setDeparturePlace(t1.getText());
                f3.setArrivalPlace(t2.getText());
                f3.setNoOfSeats(Integer.parseInt(t3.getText()));
                f3.setDepartureDate(t4.getText());
                f3.setArrivalDate(t5.getText());
                f3.setDepartureTime(LocalTime.MIN);
                 double b =f3.TotalBill(f3.getNoOfSeats());
                 f3.setBill(b);
                 f3.setFlightClass(r3.getText());
                 try{
                    f3.NewTicket(p,f3.getFlight_id(), f3.getNoOfSeats(), f3.getDeparturePlace(),
                            f3.getArrivalPlace(), f3.getDepartureDate(), f3.getArrivalDate(), f3.getBill(),f3.getFlightClass());
                 
                    } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(flightGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
    } 
            }
 
    }
class printD  {
    private Person per1;
    private Flight fli1;
    JPanel p5 = new JPanel();
    JTextField t5 = new JTextField(10);
    
    public Person getP() {
        return per1;
    }

    public void setP(Person p) {
        this.per1 = p;
    }

    public Flight getFli1() {
        return fli1;
    }

    public void setFli1(Flight fli1) {
        this.fli1 = fli1;
    }
    printD(){
    p5.add(new JLabel("Enter Id You want get the Ticket of"));
              p5.add(t5);
              int result = JOptionPane.showConfirmDialog(null, p5, 
               " Please fill in the form given below ", JOptionPane.OK_CANCEL_OPTION);
           if(result == JOptionPane.OK_OPTION){
               String delTick = t5.getText();
               int del = Integer.parseInt(delTick);
               try {
                Flight ffs = new Flight();
                boolean choice;
                choice = ffs.SearchTicket(del, p);
                if( choice == true ){
                    JOptionPane.showMessageDialog(null,"go get a booking ");
                                }
                else{
                    
                   getTicket();  
                
                }
                
            } catch (IOException ex) {
                Logger.getLogger(cancelFlightGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cancelFlightGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
            

            

    }
    public void getTicket() throws FileNotFoundException, IOException, ClassNotFoundException{
        //fetching data from the flight system 
        MenueGui mygui = new MenueGui(1);
        
        //fetching data from peron class
        FinalfinalProject myf =new  FinalfinalProject();
        
        
        FileInputStream fis = new FileInputStream(mygui.getFile());
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        FileInputStream fis2 = new FileInputStream(myf.getFile());
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        
        while(true){
            
           Flight mygui2 = (Flight)ois.readObject();
           Person mypp2 = (Person)ois2.readObject(); 
           
           JOptionPane.showMessageDialog(null, "Flight ID : " + mygui2.getFlight_id()+"\n"
                                  +"Name  " +mypp2.getName() + "\n"+
                                  "Phone Number  " +mypp2.getPhoneNum() + "\n"+       
                                  " Destination  " + mygui2.getDeparturePlace() + "\n"+
                                  " Departure Date  " + mygui2.getDepartureDate() + "\n"+
                                  " Arrival Date  " + mygui2.getArrivalDate() +"\n"+
                                  " departure Time "+mygui2.getDepartureTime()+"\n"+
                                  " Total Number of Seats  " + mygui2.getNoOfSeats() + "\n"+
                                  " Flight class  " + mygui2.getFlightClass() +"\n"+
                                  " Total Bill "+ mygui2.getBill()+"\n");  
           
            
        }
        
        
    }
    
}


         
        

 

class MyObjectOutputStream extends ObjectOutputStream{
    
    MyObjectOutputStream() throws IOException{
        super();
    }
    MyObjectOutputStream (OutputStream e) throws IOException{
        super(e);
    }
     
    @Override
    public void writeStreamHeader(){
        
    }
             
}