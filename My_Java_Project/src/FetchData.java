import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchData {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/hectronic_india";
            String username="root";
            String password="";

            String fetchQuery="select * from Customer where id=1";
            try(Connection conn= DriverManager.getConnection(url,username,password);
                Statement stmt= conn.createStatement()){
               ResultSet rs =stmt.executeQuery(fetchQuery);

               while(rs.next()){

                   int id=rs.getInt("id");
                   String customer_name=rs.getString("customer_name");
                   String project_id=rs.getString("project_id");
                   String shipping_address=rs.getString("shipping_address");

                 System.out.println("ID :"+ id +"\nCustomer Name :"+customer_name+ "\nProject ID:"+ project_id+ "\nShipping Address:"+ shipping_address +"\n*******");
               }

            } catch (Exception e) {
               System.out.println("Querying error: "+ e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Driver Loading Error or Connection Error: "+ e.getMessage());
        }
    }
}





