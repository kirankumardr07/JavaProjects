import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData{
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/new_database";
            String username="root";
            String password="";

            String tableQuery="insert into  new_table(id , name , rollno ,place ,dob) values (1,'Kiran Kumar D R','KIR070500','Tumakuru','2000/5/7');";
            try(Connection conn= DriverManager.getConnection(url,username,password);
                Statement stmt= conn.createStatement()){
                stmt.executeUpdate(tableQuery);
                System.out.println("Data Inserted Successfully");

            } catch (Exception e) {
                System.out.println("Querying error: "+ e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Driver Loading Error or Connection Error: "+ e.getMessage());
        }
    }
}






