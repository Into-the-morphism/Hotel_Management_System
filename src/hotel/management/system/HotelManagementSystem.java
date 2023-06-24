package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
        setSize(1336, 565);
   
        setLocation(100, 100);
        
        setLayout(null);
        // adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0 , 1336, 565);
        add(image);
       
        // adding text
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("papyrus", Font.PLAIN, 40));
        image.add(text);
        
        // adding next button
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.addActionListener(this);
        image.add(next);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // flickering effect
        while (true){
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e) {
                e.printStackTrace();
            }
            
            text.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        
        
     @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();

    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }

   
    
}
