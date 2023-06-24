
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class AddRooms extends JFrame implements ActionListener{
    JLabel header, roomNumberlbl,availlbl,cleanlbl,pricelbl,bedtypelbl;
    JTextField roomNumbertf, pricetf;
    JComboBox avail, clean, bedtype;
    JButton addRoom, cancel;
    
    AddRooms(){
        
        
        //AddRooms header
        
        header = new JLabel("Add Rooms");
        header.setBounds(150, 50, 100, 20);
        header.setFont(new Font("Gothic", Font.BOLD, 17));
        add(header);
        
        
         //Room number label and textfield
        
        roomNumberlbl = new JLabel("Room Number");
        roomNumberlbl.setBounds(70, 105, 140, 20);
        roomNumberlbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(roomNumberlbl);
        
        roomNumbertf = new JTextField();
        roomNumbertf.setBounds(200, 100, 140, 25);
        add(roomNumbertf);
        
        
        
        //available deopDown and label
        
        availlbl = new JLabel("Available");
        availlbl.setBounds(70, 160, 140, 20);
        availlbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(availlbl);
        
        String[] availoption = {"Available", "Booked"};
        avail = new JComboBox(availoption);
        avail.setBounds(200, 160, 140, 20);
        add(avail);
        
        
         //cleaning Status dropDown and label
        
        cleanlbl = new JLabel("Cleaning Status");
        cleanlbl.setBounds(70, 210, 140, 20);
        cleanlbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(cleanlbl);
        
        String[] cleanoption = {"Clean", "Unclean"};
        clean = new JComboBox(cleanoption);
        clean.setBounds(200, 210, 140, 20);
        add(clean);
        
        
         //price label and textfield
        
        pricelbl = new JLabel("Price");
        pricelbl.setBounds(70, 260, 140, 20);
        pricelbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(pricelbl);
        
        pricetf = new JTextField();
        pricetf.setBounds(200, 260, 140, 25);
        add(pricetf);

        
        
         //Bedtype dropDown and label
        
        bedtypelbl = new JLabel("Bed Type");
        bedtypelbl.setBounds(70, 310, 140, 20);
        bedtypelbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(bedtypelbl);
        
        String[] bedoption = {"Single", "Double"};
        bedtype = new JComboBox(bedoption);
        bedtype.setBounds(200, 310, 140, 20);
        add(bedtype);
        
        
        //adding addroom and cancel button
        
        addRoom = new JButton("Add Room");
        addRoom.setBounds(70, 355, 100, 25);
        addRoom.setBackground(Color.BLACK);
        addRoom.setForeground(Color.WHITE);
        addRoom.addActionListener(this);
        add(addRoom);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 355, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
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
             if(ae.getSource() == addRoom){
                 
                 String roomnumber = roomNumbertf.getText();
                 String availabilty = (String) avail.getSelectedItem();
                 String status = (String) clean.getSelectedItem();
                 String price = pricetf.getText();
                 String type = (String) bedtype.getSelectedItem();
                         
                 try {
                     Conn conn = new Conn();
                     
                     String query = "insert into room values('" + roomnumber + "','" + availabilty + "', '" + status + "','" + price + "','" + type + "')";
                     conn.s.executeUpdate(query);
                     
                     JOptionPane.showMessageDialog(null, "New Room Added Succefully!");
                     
                     setVisible(false);
                     
                 } catch (Exception e){
                   e.printStackTrace();
                 }
                 
             } else {
                setVisible(false);
                
             
             }
    
    }
    
    
    public static void main(String[] arg){
       new AddRooms();
    }
}
