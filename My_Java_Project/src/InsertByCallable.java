import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class InsertByCallable {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/new_database";
        String username="root";
        String password="";

        String query="{CALL insertStudents(?,?,?)}";

        try(Connection conn= DriverManager.getConnection(url,username,password);
            CallableStatement cstmt=conn.prepareCall(query)){

            System.out.print("Enter ID:");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name:");
            String name=sc.nextLine();
            System.out.print("Enter Place:");
            String place=sc.nextLine();



            cstmt.setInt(1,id);
            cstmt.setString(2,name);
            cstmt.setString(3,place);

           int rowsAffected =cstmt.executeUpdate();
           System.out.println("Data inserted Successfully"+ rowsAffected);

        } catch (Exception e) {
            System.out.println("Driver Load Error or Connection Error"+ e.getMessage());
        }
    }
}







