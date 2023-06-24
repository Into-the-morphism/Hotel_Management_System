
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Reception extends JFrame implements ActionListener{
    
    JButton customer, rooms, department, allemployees, customerInfo, managerInfo, checkout, updateStat, updateRoom, pickupServ, searchRoom , logOut;
    
    Reception(){
        
      //  1 New Customer From button
      
      customer = new JButton("New Customer Form");
      customer.setBackground(Color.BLACK);
      customer.setForeground(Color.WHITE);
      customer.setBounds(10, 20, 150, 25);
      customer.addActionListener(this);
      add(customer);
      
      // 2 Rooms button
      
      rooms = new JButton("Rooms");
      rooms.setBackground(Color.BLACK);
      rooms.setForeground(Color.WHITE);
      rooms.setBounds(10, 55, 150, 25);
      add(rooms);
      
      
      // 3  Department button
      
      department = new JButton("Department");
      department.setBackground(Color.BLACK);
      department.setForeground(Color.WHITE);
      department.setBounds(10, 90, 150, 25);
      add(department);
      
       
      // allempyee button
      
      allemployees = new JButton("All Employees");
      allemployees.setBackground(Color.BLACK);
      allemployees.setForeground(Color.WHITE);
      allemployees.setBounds(10, 125, 150, 25);
      add(allemployees);
      
       
      // Chcekout button
      
      checkout = new JButton("Chcekout");
      checkout.setBackground(Color.BLACK);
      checkout.setForeground(Color.WHITE);
      checkout.setBounds(10, 160, 150, 25);
      add(checkout);
      
      
       // update status button
      
      updateStat = new JButton("Update Status");
      updateStat.setBackground(Color.BLACK);
      updateStat.setForeground(Color.WHITE);
      updateStat.setBounds(10, 195, 150, 25);
      add(updateStat);
      
      
      // Manager info button
      
      managerInfo = new JButton("Manager info");
      managerInfo.setBackground(Color.BLACK);
      managerInfo.setForeground(Color.WHITE);
      managerInfo.setBounds(10, 230, 150, 25);
      add(managerInfo);
      
      
       // update room info button
      
      updateRoom = new JButton("Update Room Status");
      updateRoom.setBackground(Color.BLACK);
      updateRoom.setForeground(Color.WHITE);
      updateRoom.setBounds(10, 265, 150, 25);
      add(updateRoom);
      
      
       // pickup service button
      
      pickupServ = new JButton("Pickup Services");
      pickupServ.setBackground(Color.BLACK);
      pickupServ.setForeground(Color.WHITE);
      pickupServ.setBounds(10, 300, 150, 25);
      add(pickupServ);
      
       // customerInfo service button
      
      customerInfo = new JButton("Customer Info");
      customerInfo.setBackground(Color.BLACK);
      customerInfo.setForeground(Color.WHITE);
      customerInfo.setBounds(10, 335, 150, 25);
      add(customerInfo);
       
      // searchRoom button 
      
      searchRoom = new JButton("Search Room");
      searchRoom.setBackground(Color.BLACK);
      searchRoom.setForeground(Color.WHITE);
      searchRoom.setBounds(10, 370, 150, 25);
      add(searchRoom);
      
       // logOut button
       
       
      logOut = new JButton("Logout");
      logOut.setBackground(Color.BLACK);
      logOut.setForeground(Color.WHITE);
      logOut.setBounds(10, 405, 150, 25);
      add(logOut);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
      JLabel image = new JLabel(i1);
      image.setBounds(180, 20, 500, 400);
      add(image);
      
      setLayout(null);
      getContentPane().setBackground(Color.WHITE);
      setBounds(100, 100, 700, 500);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == customer){
        
        new AddCustomer();
        setVisible(false);
        
        }
        
    }
 
    

 public static void main(String[] arg){
     
     new Reception();
  
 }

}
