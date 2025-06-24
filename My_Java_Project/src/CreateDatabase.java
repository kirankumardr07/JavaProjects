import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/";
            String username="root";
            String password="";

            String databaseQuery="create database new_database;";
            try(Connection conn= DriverManager.getConnection(url,username,password);
                Statement stmt= conn.createStatement()){
               stmt.executeUpdate(databaseQuery);
               System.out.println("Database Created Successfully");

            } catch (Exception e) {
                System.out.println("Querying error: "+ e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Driver Loading Error or Connection Error: "+ e.getMessage());
        }
    }
}





