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

public class TranectionInfo
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
        public MyTransTable(int ID)
        {
            this.ID=ID;
            components();
        }
         public void components()
    {
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
        try{
            String ab="select * from transaction where id='"+ID+"'";
            ResultSet rs=da.getData(ab);
            for(int i=0;rs.next();i++)
            {
                rows[i][0]=Integer.toString(rs.getInt(3));
                rows[i][1]=Integer.toString(rs.getInt(2));
                rows[i][2]=Integer.toString(rs.getInt(4));
               
                
            }
        }
            catch(Exception ex)
                {
                   System.out.println(ex);
                }
        table=new JTable(rows,cols);
        scroll=new JScrollPane(table);
        scroll.setBounds(50,80,600,150);
        C.add(scroll);
    
}
        
    
}
class TransactionInfo{
	
        private int ID;
        public TransactionInfo(int ID)
        {
            this.ID=ID;
            MyTransTable mtb=new MyTransTable(ID);
            mtb.setVisible(true);
        }
    
}