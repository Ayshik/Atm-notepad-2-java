import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  CustomerInfo extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField userfield;
	private JPasswordField passfield;
	private JButton info,Back;
	private JLabel logolabel;
	private ImageIcon logo;
	
	private JLabel CName,CFatherName,CGender,CDOB,CPhoneInfo,CAddress,CNID,CBankId,CPassword,CBalance;
	private JTextField Name,FatherName,Gender,DOB,PhoneInfo,Address,NID,BankId,Password,Balance;
    private static String userId;
    private static double tk=0;
	
	
	public CustomerInfo()
	{
		super("Your Information");
		this.userId=userId;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font myFont= new Font("Consolas",Font.PLAIN, 25);
		Color fontColor = new Color (41,41,41);
		Color panelColor = new Color (225,225,225);
		Color buttonColColor = new Color (74,96,132);
		Color activeButtonColColor = new Color (249,249,249);
	
		panel= new JPanel ();
		panel.setLayout(null);
		panel.setBackground(panelColor);
	
		logo = new ImageIcon("images.png");
		logolabel = new JLabel(logo);
		logolabel.setBounds(0,-25,800,150);
		panel.add(logolabel);
		
		
		
		int xAxis=0,yAxis=100,width=150,height=40;
		
		info =new JButton("INFO");
		info.setBounds(xAxis,yAxis,width,height);
		info.setFont(myFont);
		info.setForeground(fontColor);
		info.setBackground(activeButtonColColor);
		info.addActionListener(this);
		panel.add(info);
		
		
		
		Back =new JButton("Back");
		Back.setBounds(xAxis,yAxis+420,width,height);
		Back.setFont(myFont);
		Back.setForeground(fontColor);
		Back.setBackground(buttonColColor);
		Back.addActionListener(this);
		panel.add(Back);

		
		
		int labelxAxis=200,labelyAxis=120,labelWidth=200,labelHeight=40;
		
		CName=new JLabel("Name :");
		CName.setBounds(labelxAxis,labelyAxis+80,labelWidth,labelHeight);
		CName.setFont(myFont);
		CName.setForeground(fontColor);
		panel.add(CName);
		
		Name=new JTextField("");
		Name.setBounds(labelxAxis+250,labelyAxis+80,labelWidth,labelHeight);
		Name.setFont(myFont);
		Name.setForeground(fontColor);
		panel.add(Name);

		

		CGender=new JLabel("AccountNo");
		CGender.setBounds(labelxAxis,labelyAxis,labelWidth,labelHeight);
		CGender.setFont(myFont);
		CGender.setForeground(fontColor);
		panel.add(CGender);
		
		Gender=new JTextField("");
		Gender.setBounds(labelxAxis+250,labelyAxis,labelWidth,labelHeight);
		Gender.setFont(myFont);
		Gender.setForeground(fontColor);
		panel.add(Gender);

		CDOB=new JLabel("Diposited");
		CDOB.setBounds(labelxAxis,labelyAxis+120,labelWidth,labelHeight);
		CDOB.setFont(myFont);
		CDOB.setForeground(fontColor);
		panel.add(CDOB);
		
		DOB=new JTextField("");
		DOB.setBounds(labelxAxis+250,labelyAxis+120,labelWidth,labelHeight);
		DOB.setFont(myFont);
		DOB.setForeground(fontColor);
		panel.add(DOB);

		CPhoneInfo=new JLabel("Withdraw");
		CPhoneInfo.setBounds(labelxAxis,labelyAxis+160,labelWidth,labelHeight);
		CPhoneInfo.setFont(myFont);
		CPhoneInfo.setForeground(fontColor);
		panel.add(CPhoneInfo);
		
		PhoneInfo=new JTextField("");
		PhoneInfo.setBounds(labelxAxis+250,labelyAxis+160,labelWidth,labelHeight);
		PhoneInfo.setFont(myFont);
		PhoneInfo.setForeground(fontColor);
		panel.add(PhoneInfo);

		

		

		CBankId=new JLabel("DOB");
		CBankId.setBounds(labelxAxis,labelyAxis+200,labelWidth,labelHeight);
		CBankId.setFont(myFont);
		CBankId.setForeground(fontColor);
		panel.add(CBankId);
		
		BankId=new JTextField("");
		BankId.setBounds(labelxAxis+250,labelyAxis+200,labelWidth,labelHeight);
		BankId.setFont(myFont);
		BankId.setForeground(fontColor);
		panel.add(BankId);

		CPassword=new JLabel("Nominee");
		CPassword.setBounds(labelxAxis,labelyAxis+240,labelWidth,labelHeight);
		CPassword.setFont(myFont);
		CPassword.setForeground(fontColor);
		panel.add(CPassword);
		
		Password=new JTextField("");
		Password.setBounds(labelxAxis+250,labelyAxis+240,labelWidth,labelHeight);
		Password.setFont(myFont);
		Password.setForeground(fontColor);
		panel.add(Password);

		CBalance=new JLabel("Balance");
		CBalance.setBounds(labelxAxis,labelyAxis+280,labelWidth,labelHeight);
		CBalance.setFont(myFont);
		CBalance.setForeground(fontColor);
		panel.add(CBalance);

		Balance=new JTextField("");
		Balance.setBounds(labelxAxis+250,labelyAxis+280,labelWidth,labelHeight);
		Balance.setFont(myFont);
		Balance.setForeground(fontColor);
		panel.add(Balance);		
		
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(ae.getSource()== info)
		{   System.out.println("Information about Customer");
            fetchFromCustomer();
			
            		
			
		}
	if(ae.getSource()== Back)
		{   
            AdminHome adh = new AdminHome();
							this.setVisible(false);
							adh.setVisible(true);
			
            		
			
		}
		
	}
	
	public void fetchFromCustomer()
	{
		
		String query = "SELECT * FROM `users` WHERE `AccountNumber`='"+Gender.getText()+"';";     
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
			String ipassword = null;
			String inominee = null;
			String ibankid = null;
			String iWithdraw = null;
			String iAddress = null;
			String iDOB = null;
			String iDeposit = null;
			String iAc = null;
			
			int iNID = 0;
			
			double iBalance = 0.0;			
			while(rs.next())
			{   
                iName = rs.getString("AccountHolderName");
               
                iAc = rs.getString("AccountNumber");
                iDeposit = rs.getString("Deposited");
                iWithdraw = rs.getString("Withdrawn");
				iDOB = rs.getString("DOB");
                 
                inominee=rs.getString("Nominee");
                iBalance = rs.getDouble("Balance");
				
				flag=true;
				
				Name.setText(iName);
				DOB.setText(iDeposit);
				PhoneInfo.setText(iWithdraw);
				BankId.setText(iDOB);
				Password.setText(inominee);
				
				
				Balance.setText(""+iBalance);
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
		