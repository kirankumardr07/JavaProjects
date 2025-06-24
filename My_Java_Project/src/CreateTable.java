import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/new_database";
            String username="root";
            String password="";

            String tableQuery="create table new_table(id int primary key , name varchar(255) not null, rollno varchar(255) not null,place varchar(255) not null,dob date not null );";
            try(Connection conn= DriverManager.getConnection(url,username,password);
                Statement stmt= conn.createStatement()){
                stmt.executeUpdate(tableQuery);
                System.out.println("Table Created Successfully");

            } catch (Exception e) {
                System.out.println("Querying error: "+ e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Driver Loading Error or Connection Error: "+ e.getMessage());
        }
    }
}





