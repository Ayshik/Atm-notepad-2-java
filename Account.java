import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Account
{
	public static void main(String args[])
	{
		AdminHome cna = new AdminHome();
		cna.setVisible(true);
	}
}

class AdminHome extends JFrame implements ActionListener
{
	private JLabel labelWelcome;
	private JButton createNewButton, DepositButton, withdrawButton,CustomerInfoButton;
	private JPanel panel;
	
        
	
	public AdminHome()
	{
		super("Sample Management System - Admin Home Window");
		
		this.setSize(600, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		 createNewButton =new JButton("Create New Account");
		createNewButton.setBounds(120, 100, 150, 30);
		createNewButton.addActionListener(this);
		panel.add(createNewButton);
		
		
		
		DepositButton = new JButton("Deposit");
		DepositButton.setBounds(300, 100, 150, 30);
		DepositButton.addActionListener(this);
		panel.add(DepositButton);
		
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(210, 150, 150, 30);
		withdrawButton.addActionListener(this);
		panel.add(withdrawButton);
		
		
		CustomerInfoButton = new JButton("Customer Info");
		CustomerInfoButton.setBounds(210, 200, 150, 30);
		CustomerInfoButton.addActionListener(this);
		panel.add(CustomerInfoButton);
	
		
		
                
                
                
		
		
		this.add(panel);
		
		
	}

   
	public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		if(buttonClicked.equals(createNewButton.getText()))
		{
			CreateNewAccount cna = new CreateNewAccount();
			cna.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonClicked.equals(DepositButton.getText()))
		{
			               Deposit de = new Deposit();
		                   de.setVisible(true);
			                this.setVisible(false);
		}
		else if(buttonClicked.equals(withdrawButton.getText()))
		{
			            Withdraw w = new Withdraw();
		                w.setVisible(true);
						this.setVisible(false);
		}
		else if(buttonClicked.equals(CustomerInfoButton.getText()))
		{
			            CustomerInfo w = new CustomerInfo();
		                w.setVisible(true);
						this.setVisible(false);
		}
		


	}
}