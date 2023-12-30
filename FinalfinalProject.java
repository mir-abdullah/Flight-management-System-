
package finalfinalproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class FinalfinalProject implements ActionListener{
     public static File file = new File("SignUpData.txt");// signup wala data person ka data ha 
      public static File file2 = new File("LogginData.txt");
     
      private static  String  user ;
      private static String pass; 
      private static JTextField Logginid;
      private static JPasswordField loginkey;
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        StartUp();
        
    }
    public File getFile(){
        return file ;
    }
    
    
    public static void StartUp() throws IOException, FileNotFoundException, ClassNotFoundException{
        JPanel myp2 = new JPanel();
        JTextField choice = new JTextField(10);
        myp2.add(new JLabel("Press 1 to sign up and press 2 for  login page" ));
        myp2.add(choice);
       
         
           int result = JOptionPane.showConfirmDialog(null, myp2, 
               " Please fill in the form given below ", JOptionPane.OK_CANCEL_OPTION);
           if(result == JOptionPane.OK_OPTION){
                String choicee = choice.getText();
                System.out.println(choicee);
                int choose = Integer.parseInt(choicee);
                 switch (choose) {
             case 1:
                 signuppage();
                 Welcomelogs();
                 break;
             case 2:
                 //entering the data from the user as it completes the sign up page
                 setLoggins();
                 Logginsetup();
                 
                    
                 // taking the loggin from its file and checking its credibility

                 break;
             default:
                 JOptionPane.showMessageDialog(null, "Invalid Input please enter the corrent input");
                 break;
         }
        
           }
        
        
        
        
    }
    public static void Welcomelogs() throws IOException, FileNotFoundException, ClassNotFoundException{
        JOptionPane.showMessageDialog(null,"You have successfully created your account you can sign up now ");
        setLoggins();
                 // taking the loggin from its file and checking its credibility
        Logginsetup();
    }
    public static void signuppage() throws FileNotFoundException, IOException{
         Person p1 = new Person() {
             
         };
        // Testing 123 for the first time plz  yara  chal jayien 
            
            JTextField name = new JTextField(12);
            JTextField age =  new JTextField(12);
            JTextField gender = new JTextField(12);
            JTextField PhoneNumber = new JTextField(12);
            JTextField address = new JTextField(15);
            JTextField username = new JTextField(15);
            JTextField password = new JTextField(15);
            
            
            JPanel myPanel = new JPanel(new GridLayout(7,0));
            
            myPanel.add(new JLabel("name :"));
            myPanel.add(name);
            myPanel.add(new JLabel("age :"));
            myPanel.add(age);
            myPanel.add(new JLabel("Gender (m/F): "));
            myPanel.add(gender);
            myPanel.add(new JLabel("PhoneNumber :"));
            myPanel.add(PhoneNumber);
            myPanel.add(new JLabel("address: "));
            myPanel.add(address);
            myPanel.add(new JLabel("UserName: "));
            myPanel.add(username);
            myPanel.add(new JLabel("Password: "));
            myPanel.add(password);
            
            
            
           int result = JOptionPane.showConfirmDialog(null, myPanel, 
               " Please fill in the form given below ", JOptionPane.OK_CANCEL_OPTION);
           
           if(result == JOptionPane.OK_OPTION){
                  String naam = name .getText();
                  int umer = Integer.parseInt(age.getText());
                  String shanakth = gender.getText();
                  int number = Integer.parseInt(PhoneNumber.getText());
                  String pata = address.getText();
                  user = username.getText();
                  pass = password.getText();
                  
                  
                  
                  p1.setName( naam);
                  p1.setPhoneNum(umer);
                  p1.setGender(shanakth);
                  p1.setPhoneNum(number);
                  p1.setAddress(pata);
                  p1.setusername(user);
                  p1.setpassword(pass);
                  
                  ObjectOutputStream oos;
                   if (!file.exists()){
                       
                    FileOutputStream fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream (fos);
                    oos.writeObject(new Person(naam,umer,number,pata,shanakth,user,pass) {
                        
                    });
        
                }
                else{
                FileOutputStream fos = new FileOutputStream(file,true);
                oos = new MyObjectOutputStream (fos);
                oos.writeObject(new Person(naam,umer,number,pata,shanakth,user,pass) {
                    
                });
                   }
                    oos.close();
           
           
           
           }    
    }
    //trying to store the signup data in the new loggin file 
    public static void setLoggins()throws FileNotFoundException, IOException, ClassNotFoundException{
           
            ObjectOutputStream oos = null ;
            
             try{
               
            FileInputStream fis = new FileInputStream (file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
            Person p3 = (Person) ois.readObject();

             Account a1 = new Account(p3.getusername(),p3.getpassword());

        

            
            
            if(!file2.exists()){
                    FileOutputStream fos = new FileOutputStream(file2);
                    oos = new ObjectOutputStream (fos);
                    oos.writeObject(a1);
                }
                else {
                     FileOutputStream fos = new FileOutputStream(file2,true);
                        oos = new MyObjectOutputStream (fos);
                        oos.writeObject(a1);
                    }
            }
         
             }
        catch(EOFException ex)
        {
    }
              oos.close(); 
//Might need to edit it out from here 
}
    
    // here goes the loggin system 
    
    //--------------------------------------------------Here is the problem  occuring please khud se sia ho ja yar //
    public static  void Logginsetup(){
     
    
     JButton Lbutton;
     
     JFrame frame = new JFrame();
        JPanel  panel = new JPanel();
        frame.setSize(400,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.add(panel);
        panel.setLayout(null);
   
        JLabel userlabel = new JLabel("User");
        userlabel.setBounds(10,20,80,25);
        panel.add(userlabel);
        
        Logginid = new JTextField(20);
        Logginid.setBounds(100,20,165,25);
        panel.add(Logginid);
       
        JLabel passwordLabel = new JLabel("password");
        passwordLabel .setBounds(10,50,80,25);
        panel.add(passwordLabel);
        
         loginkey = new JPasswordField();
        loginkey.setBounds(100,50,165,25);
        panel.add(loginkey);
        
        Lbutton = new JButton("Loggin");
        Lbutton.setBounds(10,80,80,25);
        Lbutton.addActionListener( new FinalfinalProject());
        panel.add(Lbutton);
        
        //change this label to make a new panel which will show the loggin page for the customer 
       
        

        frame.setVisible(true);
 
 }

    
    @Override
    public void actionPerformed(ActionEvent e) {
         FileInputStream fis = null ;
         boolean found = false;
         try {
             fis = new FileInputStream(file2);
             ObjectInputStream ois = new ObjectInputStream(fis);
             String banda  = Logginid.getText();//ye variable nai chalte yar store nai karte veraible 
             String pasword = loginkey.getText();//ye wala bhi 
             System.out.println("The user name is :" + banda );
             System.out.println(" The Password is :" + pasword);
               while(true){
               Account a3 = (Account)ois.readObject();
                   System.out.println(a3.getPassword());
                   System.out.println(a3.getUsername());
                   // ye logic to sai ha lekin L lagy we hn iddr hi kahien 
             if(banda.equals(a3.getUsername())&& pasword.equals(a3.getPassword())){
                 JOptionPane.showMessageDialog(null, "You are now eligible to book a flight ");
                 found = true;
                 MenueGui m = new MenueGui();
                 //calling of the main project occurs here its been a hell of a weekend 
                   break;
                 //This will change when we will add another panel here for the menu
             }
             else {
                found = false ;    
             }
               }
               if(!found ){
                    JOptionPane.showMessageDialog(null, "Your login credentials not present in database create a new Account ");
               }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(FinalfinalProject.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(FinalfinalProject.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(FinalfinalProject.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             try {
                 fis.close();
             } catch (IOException ex) {
                 Logger.getLogger(FinalfinalProject.class.getName()).log(Level.SEVERE, null, ex);
             }
         }   
}
}

    
    

