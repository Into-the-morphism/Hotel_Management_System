
package hotel.management.system;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField userpass;        
    JButton login, cancel;
    
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        setBounds(500, 200, 600, 300);
        
      
        //User Namelabel and field
        
        JLabel user = new JLabel("Username");
        
        user.setBounds(40, 20,100, 30);
        
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username); 
        
        //User password label and field
        
        JLabel password = new JLabel("Password");
        
        password.setBounds(40, 70,100, 30);
        
        add(password);
        
        userpass = new JPasswordField();
        userpass.setBounds(150, 70, 150, 30);
        add(userpass);
        
        // Buttons
             //login button
        login = new JButton("Log-In");
        login.setBounds(40, 150, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
           
            // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(170, 150, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        //image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(300, 10, 200, 200);
        add(image);
        
            
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == login){
            String user = username.getText();
            String pass = userpass.getText();
             
            try {
            Conn c = new Conn();
            String query = "select * from login where username ='" + user + "' and password = '" + pass + "'" ;
            ResultSet rs = c.s.executeQuery(query);
            
            if (rs.next()){
                setVisible(false);
                new Dashboard();
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);    
            }
            
            
            
            }
            catch(Exception e){
                e.printStackTrace();}
                    
        } else if (ae.getSource() == cancel){
             setVisible(false); 
        }
        
    }
    
    public static void main(String[] args){
        new Login();
    }
    
}
