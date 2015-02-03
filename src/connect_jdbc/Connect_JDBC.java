
package connect_jdbc;
import java.sql.*;
/**
 *
 * @author Dmitri Velenteenko
 */
public class Connect_JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
        Statement stat = null;
        ResultSet set = null;
        
        try
        {
            // create the new instance for JDBC driver
            Driver d = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
            String url_con_string = "jdbc:sqlite:/home/velenteenko/SqliteDataBase/CarShop.db";
            
            //getting the new connection by URL
            conn = DriverManager.getConnection(url_con_string);
            
            //create a statement for query processing
            // at first create new string containt sql query
            String sql_string = "SELECT * FROM spr_Model";
            stat = conn.createStatement();
            
            //executing a query using Statement
            // getting query in ResultSet
            set = stat.executeQuery(sql_string);
            
            while (set.next())
            {
                System.out.println("Model name (RU) - "+set.getString("name_ru")+"\t\t\t\tModel name (EN) - "+set.getString("name_en"));
            }
            
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (set!=null) set.close();
                if (stat!=null) stat.close();
                if (conn!=null) conn.close();
            } catch(Exception ex)
            {
                
            }
        }
        
        
    }
    
}
