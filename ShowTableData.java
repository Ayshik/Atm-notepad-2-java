import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowTableData extends JFrame
{    
    JTable table;
    ResultSet rs;
    DataAccess da;
    public ShowTableData()
    {
        table = new JTable();
        da = new DataAccess();
        String[] columnNames = new String[] {
            "AccountNumber", "Amount", "Transactiontype"
        };
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        String query = "select * from transaction";
        rs = da.getData(query);
        try{
            while(rs.next())
            {
                String col1 = rs.getString("AccountNumber");
                String col2 = rs.getString("Transaction");
                String col3 = rs.getString("Transactiontype");
                model.addRow(new Object[]{col1, col2, col3});
            }
            table.setModel(model);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        this.add(new JScrollPane(table));

        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new ShowTableData();
    }
}
