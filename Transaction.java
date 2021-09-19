import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Transaction
{
	public static void main(String args[])
	{
		MyTransTable cna = new MyTransTable();
		cna.setVisible(true);
	}
}



class MyTransTable extends JFrame{
    private int ID;
    private Container C;
    private Font f;
    private JTable table;
    private String[] cols={"Account No","Amount","TransactionType"};
    private String rows[][]=new String[100][3];
    private JScrollPane scroll;
	private JLabel numberLabel;
	private JTextField numberTF;
	private JButton buttonSearch,
        public MyTransTable()
        {
            this.ID=ID;
            components();
        }
         public void components()
    {   numberLabel = new JLabel("Enter Account Number : ");
		numberLabel.setBounds(100,30,150,30);
		panel.add(numberLabel);
		
		numberTF = new JTextField();
		numberTF.setBounds(260,30,100,30);
		panel.add(numberTF);
		
        DataAccess da=new DataAccess();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100,100,750,450);
        this.setTitle("All Transaction");
        C=this.getContentPane();
        C.setLayout(null);
        C.setBackground(Color.red);
        f=new Font("Arial",Font.BOLD,22);
        JLabel InLabel=new JLabel("All Transaction Info");
        InLabel.setBounds(250,20,200,50);
        InLabel.setFont(f);
        C.add(InLabel);
       
        table=new JTable(rows,cols);
        scroll=new JScrollPane(table);
        scroll.setBounds(50,80,600,150);
        C.add(scroll);
    
}
        
    
}
class TransactionInfo{
	
        private int ID;
        public TransactionInfo()
        {
            this.ID=ID;
            MyTransTable mtb=new MyTransTable();
            mtb.setVisible(true);
        }
    
}