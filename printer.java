import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Printer
{
	public static void main(String args[])
	{
		Print cna = new Print();
		cna.setVisible(true);
	}
}

class Print extends JFrame implements ActionListener
{
	private JLabel numberLabel;
	private JTextField numberTF;
	private JButton buttonSubmit;
	private JPanel panel;

         private String password;
        private int accountNumber;
        private String accountHolderName;
        private double balance;
        public int withdrawn;
	private String userId;
	
	public Print()
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
		
		buttonSubmit = new JButton("Insert");
		buttonSubmit.setBounds(190, 300, 80, 30);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		
		this.add(panel);
	}
		public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		if(buttonClicked.equals(buttonSubmit.getText()))
		{
		     String a=   "Name:\t\t\t" + nameTF.getText()+   
				
				
           a.print();
        
		
                    				
		}
		
		
    }
}	