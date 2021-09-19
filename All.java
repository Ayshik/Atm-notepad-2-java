import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class All
{
	public static void main(String args[])
	{
		Transaction cna = new Transaction();
		cna.setVisible(true);
	}
}

class Transaction extends JFrame implements ActionListener
{
	private JLabel numberLabel;
	private JTextField numberTF;
	private JButton buttonSubmit,buttonBack;
	 private JTable table;
    private String[] cols={"Account No","Amount","TransactionType"};
   private String rows[][]=new String[100][3];
	 private JScrollPane scroll;
	private JPanel panel;
	private String userId;
        private String password;
        private int accountNumber;
        private String accountHolderName;
        private double balance;
	public int deposited;
	
	
	public Transaction()
	{
		super("Bank Management System - Transaction Window");
		
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		numberLabel = new JLabel("Enter Account Number : ");
		numberLabel.setBounds(100,30,150,30);
		panel.add(numberLabel);
		
		numberTF = new JTextField();
		numberTF.setBounds(260,30,100,30);
		panel.add(numberTF);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(30, 30, 100, 30);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		table=new JTable(rows,cols);
        scroll=new JScrollPane(table);
        scroll.setBounds(50,80,600,150);
		
		
		
		this.add(panel);
		this.userId=userId;
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
        else if(buttonClicked.equals(buttonSubmit.getText()))		
        {
			check();
		}
	}
	
	public void check()
	{   
         
		
        String query1 = "SELECT * FROM `transaction`WHERE `AccountNumber`='"+numberTF.getText()+"';";    
          
        
        Connection con=null;//connection er jonno
        
        Statement st = null;//query execution korbe
       ResultSet rs = null;// DB theke result collect korbe
        
        System.out.println(query1);
        
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clintinfo","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(query1);
			System.out.println("results received");
					
			while(rs.next())
			{      
                String Uid = rs.getString("AccountNumber");
                String Withdraw = rs.getString("Transaction");
                    String td=rs.getString("Transactiontype");
					
                      table.addRow(Uid,Withdraw,td);
                     
                    
                        }			
			                           

			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
    } 






}
