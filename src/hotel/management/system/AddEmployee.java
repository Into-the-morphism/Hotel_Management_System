
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname, tfage, tfsalary, tfphone, tfemail;
    JRadioButton rbmale, rbfemale ;
    JComboBox jcjob;
    JButton submit;
    AddEmployee(){
        
    //All the labels and text field
    
        // NAME label and TextField
    JLabel lblname = new JLabel("NAME :");
    lblname.setBounds(50, 60, 60, 30);
    lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
    add(lblname); 
    
    tfname = new JTextField();
    tfname.setBounds(140, 60, 140, 30);
    add(tfname);
    
        // Age label and TextField
    JLabel Agename = new JLabel("AGE :");
    Agename.setBounds(50, 120, 60, 30);
    Agename.setFont(new Font("Tahoma", Font.PLAIN, 17));
    add(Agename); 
    
    tfage = new JTextField();
    tfage.setBounds(140, 120, 140, 30);
    add(tfage);
       // Gender label
       
    JLabel gendername = new JLabel("GENDER :");
    gendername.setBounds(50, 180, 80, 30);
    gendername.setFont(new Font("Tahoma", Font.PLAIN, 17));
    add(gendername);
      //male radio button
    rbmale = new JRadioButton("MALE");
    rbmale.setBackground(Color.GRAY);
    rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
    rbmale.setBounds(140, 180, 70, 30);
    add(rbmale);
      //female radio button
    rbfemale = new JRadioButton("FEMALE");
    rbfemale.setBackground(Color.GRAY);
    rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
    rbfemale.setBounds(210, 180, 80, 30);
    add(rbfemale);
    
    ButtonGroup bg = new ButtonGroup();
    bg.add(rbmale);
    bg.add(rbfemale);
    
      //Job label
    JLabel lbljob = new JLabel("JOB :");
    lbljob.setBounds(50, 240, 80, 30);
    lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
    add(lbljob);
    
      //dropdown 
    String str[] = { "Manager", "Waiter", "Porter", "Driver", "Kitchen Staff"};
    jcjob = new JComboBox(str);
    jcjob.setBounds(140, 240, 130, 30);
    add(jcjob);
    
    
    // salary label and text field
    JLabel lblsalary = new JLabel("SALARY :");
    lblsalary.setBounds(50, 300, 80, 30);
    lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
    add(lblsalary);
    
    tfsalary = new JTextField();
    tfsalary.setBounds(140, 300, 140, 30);
    add(tfsalary);
    
    
     // phone label and text field
    JLabel lblphone = new JLabel("PHONE :");
    lblphone.setBounds(50, 360, 80, 30);
    lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
    add(lblphone);
    
    tfphone = new JTextField();
    tfphone.setBounds(140, 360, 140, 30);
    add(tfphone);
    
     // email label and text field
    JLabel lblemail = new JLabel("EMAIL :");
    lblemail.setBounds(50, 420, 80, 30);
    lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
    add(lblemail);
    
    tfemail = new JTextField();
    tfemail.setBounds(140, 420, 140, 30);
    add(tfemail);
    
    //submit button
    
    submit = new JButton("SUBMIT");
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.setBounds(140, 480, 120, 30);
    submit.addActionListener(this);
    add(submit);
    
    
        
        //Setting up the board
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setBounds(400, 200, 850,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        
        String gender = null;
        
        if (rbmale.isSelected()){
            gender = "Male";
        } else {
            gender = "Female";
        }
        
        String job = (String) jcjob.getSelectedItem();
        
        try {
           Conn conn = new Conn();
           String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + salary + "','" + job + "','" + phone + "','" + email + "')";
           
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Employee added succesfully!");
           setVisible(false);
           
           
        } 
        catch (Exception e){
               e.printStackTrace();       
        }
        
        
        
    }
    
    public static void main(String[] args){
            new AddEmployee();
    }

   
}
