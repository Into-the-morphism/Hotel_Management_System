
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox idtype;
    JTextField number, name, country, deposite;
    JRadioButton male, female;
    Choice croom;
    JLabel currentTime;
    JButton add, back;
    
    AddCustomer(){
        
        
      //header
      
      JLabel header = new JLabel(" NEW CUSTOMER FORM");
      header.setBounds(170, 15, 300, 100);
      header.setForeground(Color.BLUE);
      header.setFont(new Font("Tahoma", Font.PLAIN,20 ));
      add(header);
      
       
      
        
      //ID type combobox(dropdown)
      JLabel lblID = new JLabel("ID");
      lblID.setBounds(30, 120, 53, 20);
      lblID.setFont(new Font("Tahoma", Font.BOLD,12 ));
      add(lblID);
      String[] idOption = {"NID", "Passport", "Student ID", "Office ID",};
      idtype = new JComboBox(idOption);
      idtype.setBounds(160, 120, 130, 20);
      idtype.setBackground(Color.BLUE);
      add(idtype);
      
       //ID number label and texfield
      JLabel lblnumber = new JLabel("Number");
      lblnumber.setBounds(30, 160, 53, 20);
      lblnumber.setFont(new Font("Tahoma", Font.BOLD,12 ));
      add(lblnumber);
   
      number = new JTextField();
      number.setBounds(160, 160, 130, 20);
      number.setBackground(Color.WHITE);
      add(number);
      
      //name label and textfield
      JLabel lblname = new JLabel("Name");
      lblname.setBounds(30, 200, 53, 20);
      lblname.setFont(new Font("Tahoma", Font.BOLD,12 ));
      add(lblname);
   
      name = new JTextField();
      name.setBounds(160, 200, 130, 20);
      name.setBackground(Color.WHITE);
      add(name);
      
      //gender label and radiobutton
      JLabel lblgender = new JLabel("Gender");
      lblgender.setBounds(30, 240, 53, 20);
      lblgender.setFont(new Font("Tahoma", Font.BOLD,12 ));
      add(lblgender);
   
      male = new JRadioButton("Male");
      male.setBounds(160, 240, 70, 20);
      male.setBackground(Color.WHITE);
      add(male);
      
      female = new JRadioButton("Female");
      female.setBounds(230, 240, 70, 20);
      female.setBackground(Color.WHITE);
      add(female);
      
      ButtonGroup bg = new ButtonGroup();
      bg.add(male);
      bg.add(female);
      
      
      //name label and textfield
      JLabel lblncountry = new JLabel("Country");
      lblncountry.setBounds(30, 280, 53, 20);
      lblncountry.setFont(new Font("Tahoma", Font.BOLD,12 ));
      add(lblncountry);
   
      country = new JTextField();
      country.setBounds(160, 280, 130, 20);
      country.setBackground(Color.WHITE);
      add(country);
      
      
      //room number Choice
      JLabel lblroom = new JLabel("Room Number");
      lblroom.setBounds(30, 320, 100, 20);
      lblroom.setFont(new Font("Tahoma", Font.BOLD,12 ));
      add(lblroom);
   
      croom = new Choice();
      
      try {
          Conn conn = new Conn();
          String query = "select * from room where availability = 'Available'";
          ResultSet rs = conn.s.executeQuery(query);
          
          while (rs.next()){
              
              croom.add(rs.getString("roomnumber"));
          
          }
      
      }
      catch(Exception e){
           e.printStackTrace();
      }
      
      croom.setBounds(160, 320, 130, 20);
      add(croom);
      
      
      
      // chickin time 
      JLabel lbltime = new JLabel("Checin time");
      lbltime.setBounds(30, 360, 100, 20);
      lbltime.setFont(new Font("Tahoma", Font.BOLD,12 ));
      add(lbltime);
      
      Date date = new Date();
      
      currentTime = new JLabel("" + date);
      currentTime.setBounds(160, 360, 170, 20);
      currentTime.setBackground(Color.WHITE);
      add(currentTime);
      
      
      //deposit
      JLabel lbldeposite = new JLabel("Deposite");
      lbldeposite.setBounds(30, 400, 53, 20);
      lbldeposite.setFont(new Font("Tahoma", Font.BOLD,12 ));
      add(lbldeposite);
   
      deposite = new JTextField();
      deposite.setBounds(160, 400, 130, 20);
      deposite.setBackground(Color.WHITE);
      add(deposite);
      
      //AddCustomer and back button
      add = new JButton("Add Customer");
      add.setBounds(50, 445, 130, 25);
      add.setBackground(Color.BLACK);
      add.setForeground(Color.WHITE);
      add.addActionListener(this);
      add(add);
      
      back = new JButton("Back");
      back.setBounds(200, 445, 130, 25);
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.addActionListener(this);
      add(back);
      
      
        
      //setting up the board   
      setLayout(null);
      getContentPane().setBackground(Color.WHITE);
      setBounds(100, 100, 700, 540);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    }
    
    public void actionPerformed(ActionEvent ae){
               if (ae.getSource() == add){
                   
                   String ID = (String)idtype.getSelectedItem();
                   String Number = number.getText();
                   String Name = name.getText();
                   String Gender = null;
                   
                   if (male.isSelected()){
                        Gender = "Male";
                   } else {
                        Gender = "Female";
                   }
                   String Country = country.getText();
                   String RoomNumber = (String)croom.getSelectedItem();
                   String Time = currentTime.getText();
                   String Deposite = deposite.getText();
                   try{
                       
                       Conn conn = new Conn();
                       String query = "insert into Customer values('" + ID + "','" + Number + "','" + Name + "','" + Gender + "','" + Country + "','" + RoomNumber + "','" + Time + "','" + Deposite + "')";
                       String query2 = "update room set availability = 'Booked' where roomnumber = '" + RoomNumber +"'";
                       conn.s.executeUpdate(query);
                       conn.s.executeUpdate(query2);
                       
                       JOptionPane.showMessageDialog(null, "New Customer Added Succesfully");
                       
                       setVisible(false);
                   
                   }
                   catch (Exception e){
                     e.printStackTrace();
                   }
               } else {
               setVisible(false);
               new Reception();
               }
    }
    
    
    public static void main(String[] arg){
    
       new AddCustomer();
    }
    
}
