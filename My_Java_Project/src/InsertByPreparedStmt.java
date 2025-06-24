import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertByPreparedStmt {
    public static void main(String[]args) throws  Exception{
        Scanner sc=new Scanner(System.in);
       Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/new_database";
        String username="root";
        String password="";
         String insertQuery="insert into new_table(id,name,rollno,place,dob) values (?,?,?,?,?)";

        try(Connection conn= DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt=conn.prepareStatement(insertQuery)){
            
            System.out.print("Enter ID:");
            int id=sc.nextInt();
            sc.nextLine();  // Consume the newline
            System.out.print("Enter Name:");
            String name=sc.nextLine();
            System.out.print("Enter RollNo:");
            String rollno=sc.nextLine();
            System.out.print("Enter Place:");
            String place=sc.nextLine();
            System.out.print("Enter DOB:");
            String dob=sc.nextLine();

            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,rollno);
            pstmt.setString(4,place);
            pstmt.setString(5,dob);

             int rowsAffected= pstmt.executeUpdate();

             if(rowsAffected >=0){
                 System.out.println("Data has been  inserted Successfully");
             }else{
                 System.out.println("Data hasn't been inserted Successfully");
             }

        } catch (Exception e) {
            System.out.println("Querying Error: "+ e.getMessage());
        }

    }
  }