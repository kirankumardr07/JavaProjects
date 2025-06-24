import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class GetStudentNameByCallable {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/new_database";
        String username = "root";
        String password = "";

        String query = "{CALL getStudentName(?, ?)}"; // IN and OUT parameters

        try (Connection conn = DriverManager.getConnection(url, username, password);
             CallableStatement cstmt = conn.prepareCall(query)) {

            // Set input parameter
            cstmt.setInt(1, 5);

            // Register the OUT parameter
            cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);

            // Execute the stored procedure
            cstmt.execute();

            // Retrieve the OUT parameter value
            String name = cstmt.getString(2);
            System.out.println("Name: " + name);

        } catch (Exception e) {
            System.out.println("Querying Error: " + e.getMessage());
        }
    }
}
