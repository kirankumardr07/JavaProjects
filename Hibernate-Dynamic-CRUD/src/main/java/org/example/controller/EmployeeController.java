package org.example.controller;

import org.example.dao.EmployeeDao;
import org.example.dto.EmployeeDto;


import java.util.Scanner;

public class EmployeeController {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        EmployeeDao employeeDao=new EmployeeDao();

        while(true){
            System.out.println("\n1. Add Employee");
            System.out.println("2. Fetch Employee by ID");
            System.out.println("3. Update Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Delete All Employee");
            System.out.println("6. fetch All Employee");

            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter Name:");
                    String name=sc.next();
                    sc.nextLine(); // Consumes the leftover newline character
                    System.out.print("Enter Salary:");
                    Double salary=sc.nextDouble();
                    sc.nextLine(); // Consumes the leftover newline character
                    System.out.print("Enter Role:");
                    String role=sc.nextLine();
                    employeeDao.addEmployee(new EmployeeDto(name, salary, role));
                    break;

                case 2:
                    System.out.print("Enter ID:");
                    int id=sc.nextInt();
                    EmployeeDto emp=employeeDao.fetchEmployeeById(id);
                    System.out.println(emp!=null ? emp:"Employee Not Found!");
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name:");
                    name=sc.nextLine();
                    System.out.print("Enter New Salary:");
                    salary=sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter New Role:");
                    role=sc.nextLine();
                    employeeDao.updateEmployee(id, name, salary, role);
                    break;

                case 4:
                    System.out.print("Enter ID:");
                    id=sc.nextInt();
                    employeeDao.deleteEmployee(id);
                    break;

                case 5:
                    employeeDao.deleteAllEmployees();
                    break;

                case 6:
                    employeeDao.fetchAllEmployees();
                    break;

                default:
                    System.out.println("invalid choice!");
            }
        }
    }
}





