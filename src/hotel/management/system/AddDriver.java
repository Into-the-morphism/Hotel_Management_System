
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener {
    
    
    JLabel header, namelbl,availlbl,carlbl,agelbl,locationlbl;
    JTextField nametf, agetf;
    JComboBox avail, car, location;
    JButton addDriver, cancel;
    
    AddDriver(){
        
        
        //AddDriver header
        
        header = new JLabel("Add Driver");
        header.setBounds(150, 50, 100, 20);
        header.setFont(new Font("Gothic", Font.BOLD, 17));
        add(header);
        
        
         //name number label and textfield
        
        namelbl = new JLabel("Name");
        namelbl.setBounds(70, 105, 140, 20);
        namelbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(namelbl);
        
        nametf = new JTextField();
        nametf.setBounds(200, 100, 140, 25);
        add(nametf);
        
        
        
        //available deopDown and label
        
        availlbl = new JLabel("Available");
        availlbl.setBounds(70, 160, 140, 20);
        availlbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(availlbl);
        
        String[] availoption = {"Available", "Occupied"};
        avail = new JComboBox(availoption);
        avail.setBounds(200, 160, 140, 20);
        add(avail);
        
        
         //car dropDown and label
        
        carlbl = new JLabel("Car Model");
        carlbl.setBounds(70, 210, 140, 20);
        carlbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(carlbl);
        
        String[] caroption = {"Honda", "Corolla", "Tesla", "Bugatti"};
        car = new JComboBox(caroption);
        car.setBounds(200, 210, 140, 20);
        add(car);
        
        
         //age label and textfield
        
        agelbl = new JLabel("Age");
        agelbl.setBounds(70, 260, 140, 20);
        agelbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(agelbl);
        
        agetf = new JTextField();
        agetf.setBounds(200, 260, 140, 25);
        add(agetf);

        
        
         //Location dropDown and label
        
        locationlbl = new JLabel("Bed Type");
        locationlbl.setBounds(70, 310, 140, 20);
        locationlbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(locationlbl);
        
        String[] locoption = {"Airport", "Seaport", "Citysquare",};
        location = new JComboBox(locoption);
        location.setBounds(200, 310, 140, 20);
        add(location);
        
        
        //adding addroom and cancel button
        
        addDriver = new JButton("Add Driver");
        addDriver.setBounds(70, 355, 100, 25);
        addDriver.setBackground(Color.BLACK);
        addDriver.setForeground(Color.WHITE);
        addDriver.addActionListener(this);
        add(addDriver);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 355, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 80 ,500, 300);
        add(image);
        
        
        
        
        
        //making the Frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(100, 100, 1000, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addDriver){
                 
                 String name = nametf.getText();
                 String availabilty = (String) avail.getSelectedItem();
                 String carmodel = (String) car.getSelectedItem();
                 String age = agetf.getText();
                 String loc = (String) location.getSelectedItem();
                         
                 try {
                     Conn conn = new Conn();
                     
                     String query = "insert into driver values('" + name + "','" + availabilty + "', '" + carmodel + "','" + age + "','" + loc + "')";
                     conn.s.executeUpdate(query);
                     
                     JOptionPane.showMessageDialog(null, "New Driver Added Succefully!");
                     
                     setVisible(false);
                     
                 } catch (Exception e){
                   e.printStackTrace();
                 }
                 
             } else {
                setVisible(false);
                
             
        }
    
                           }
    
    
    
    public static void main(String[] args){
    
    new AddDriver();
    }
    
}
