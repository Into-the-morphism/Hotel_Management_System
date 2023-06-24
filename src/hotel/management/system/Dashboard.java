
package hotel.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard(){
        
        setBounds(0, 0, 1500, 1000);
        
        setLayout(null);
        
        
        //adding image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1500, 1000);
        add(image);
        
        //adding text
        JLabel text = new JLabel("THE HOTEL");
        text.setBounds(580, 80, 1000, 50);
        text.setFont(new Font("Papyrus", Font.BOLD, 45));
        text.setForeground(Color.WHITE);
        image.add(text);
        // Menu bar
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        
        
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
            // menu item inside hotel managment
            JMenuItem reception = new JMenuItem("RECEPTION");
            reception.addActionListener(this);
            hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin); 
           // menu ite inside admin
           JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
           addEmployee.addActionListener(this);
           admin.add(addEmployee);
           
           JMenuItem addRoom = new JMenuItem("ADD ROOMS");
           addRoom.addActionListener(this);
           admin.add(addRoom);
           
           JMenuItem addDriver = new JMenuItem("ADD DRIVER");
           addDriver.addActionListener(this);
           admin.add(addDriver);
        
        
        image.add(mb);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
    }
    
    public void actionPerformed(ActionEvent ae){
          if (ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
         } else if (ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
            
         } else if (ae.getActionCommand().equals("ADD DRIVER")) {
            new AddDriver();
         } else {
            new Reception();}  
    }
    
    
    public static void main(String arg[]){
        new Dashboard();
    }
    
}
