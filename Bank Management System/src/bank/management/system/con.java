package bank.management.system;
import java.sql.*;

public class con
{
    
    public Statement stm;
    public con() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","SaiBaba7781@");
        stm=c.createStatement();    
          
    }
}
