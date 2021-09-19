

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class NewAccount
{
	public static void main(String args[])
	{
		CreateNewAccount cna = new CreateNewAccount();
		cna.setVisible(true);
	}
}
class CreateNewAccount extends JFrame implements ActionListener
{
	private JLabel nameLabel, numberLabel, initialBalanceLabel, idLabel, passwordLabel,passwordPF,hasLabel,has2Label,slLabel;
	private JTextField nameTF, numberTF, initialBalanceTF, idTF,mTF,yTF;
	
	private JButton buttonBack,buttonInsert;
	private JPanel panel;
         private String userId;
        private String password;
        private int accountNumber;
        private String accountHolderName;
        private double balance;
	public CreateNewAccount()
	{
		super("BANK Management System - Create New Account Window");
		
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		nameLabel = new JLabel("Enter Name : ");
		nameLabel.setBounds(50,50,150,30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(260,50,100,30);
		panel.add(nameTF);
		
		numberLabel = new JLabel("Enter DOB(DD-MM-YYYY: ");
		numberLabel.setBounds(50,100,150,30);
		panel.add(numberLabel);
		
		numberTF = new JTextField();
		numberTF.setBounds(260,100,100,30);
		panel.add(numberTF);
		
		mTF = new JTextField();
		mTF.setBounds(380,100,100,30);
		panel.add(mTF);
		
		yTF = new JTextField();
		yTF.setBounds(500,100,100,30);
		panel.add(yTF);
		
		hasLabel = new JLabel("-");
		hasLabel.setBounds(370,100,100,30);
		panel.add(hasLabel);
		
		has2Label = new JLabel("-");
		has2Label.setBounds(490,100,100,30);
		panel.add(has2Label);
		
		
		
		initialBalanceLabel = new JLabel("Enter Initial Balance : ");
		initialBalanceLabel.setBounds(50,150,150,30);
		panel.add(initialBalanceLabel);
		
		initialBalanceTF = new JTextField();
		initialBalanceTF.setBounds(260,150,100,30);
		panel.add(initialBalanceTF);
		
		idLabel = new JLabel("Enter Nominee : ");
		idLabel.setBounds(50,200,150,30);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(260,200,100,30);
		panel.add(idTF);
		
		passwordLabel = new JLabel("Your Account No Is : ");
		passwordLabel.setBounds(100, 250, 150, 30);
		panel.add(passwordLabel);
		
		passwordPF =new JLabel("----------- ");
		passwordPF.setBounds(260, 250, 100, 30);
		panel.add(passwordPF);
		
		slLabel = new JLabel("sl");
		slLabel.setBounds(360,250,100,30);
		panel.add(slLabel);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(100, 300, 80, 30);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		buttonInsert = new JButton("Insert");
		buttonInsert.setBounds(280, 300, 80, 30);
		buttonInsert.addActionListener(this);
		panel.add(buttonInsert);
		
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		if(buttonClicked.equals(buttonBack.getText()))
		{
		              AdminHome adh = new AdminHome();
							this.setVisible(false);
							adh.setVisible(true);
		}
		else if(buttonClicked.equals(buttonInsert.getText()))
		{
			System.out.println("Sign up successfull");
                    boolean flag = true;
					insertIntoDB();
					fetchFromCustomer();
		}
		
	}
	public void insertIntoDB()
	{
		String query = "INSERT INTO users VALUES ('0','"+nameTF.getText()+"', '"+yTF.getText()+""+mTF.getText()+"0000','0','"+initialBalanceTF.getText()+"','"+numberTF.getText()+"-"+mTF.getText()+"-"+yTF.getText()+"','"+idTF.getText()+"','0','0')";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clintinfo", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
                        JOptionPane.showMessageDialog(this,"CONGATULATIONS YOUR ACCOUNT HAS BEEN CREATED!!"); 
					
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			 JOptionPane.showMessageDialog(this,"please try Again!!"); 
        }
    }
    public void fetchFromCustomer()
	{
		
		String query = "SELECT * FROM `users` WHERE `AccountHolderName`='"+nameTF.getText()+"';";     
		
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clintinfo","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			
			boolean flag = false;
			String iName = null;
			String iFatherName = null;
			String iGender = null;
			String iDOB = null;
			String iPhonenumber = null;
			String iAddress = null;
			
					
			while(rs.next())
			{   
             String iAccountno = rs.getString("AccountNumber");
              String  islno =rs.getString("sl");
                
               
                
                
				flag=true;
				
				passwordPF.setText(iAccountno);
				
				slLabel.setText(islno);
				
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Something is Wrong!!!","Inane warning",JOptionPane.WARNING_MESSAGE);
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
       
		
		try
		{
			System.out.println(".");
			query = "UPDATE users SET AccountNumber='"+passwordPF.getText()+""+slLabel.getText()+"' where AccountHolderName='"+nameTF.getText()+"';";
                        
                        
			            st.executeUpdate(query);
                        
                       
						System.out.println(query);
               
			st.close();
			con.close();
			rs.close();
                        JOptionPane.showMessageDialog(this,"please remember your Account Number"); 
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	}
	
	
	




