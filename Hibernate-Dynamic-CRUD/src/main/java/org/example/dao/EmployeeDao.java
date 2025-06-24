package org.example.dao;

import jakarta.persistence.*;
import org.example.dto.EmployeeDto;

import java.util.List;


public class EmployeeDao {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("example-unit");


    //For Add the Employee Details
    public void addEmployee(EmployeeDto employeeDto){
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try{
            et.begin();
            em.persist(employeeDto);
            et.commit();
            System.out.println("Employee Added Successfully!");
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }

    // Fetch EmployeeById
      public EmployeeDto fetchEmployeeById(int id){
            EntityManager em=emf.createEntityManager();
            EmployeeDto emp=em.find(EmployeeDto.class,id);
            em.close();
            return emp;
      }


      public void updateEmployee(int id,String name,double salary, String role){
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        et.begin();
        EmployeeDto emp=em.find(EmployeeDto.class, id);
        if(emp!=null){
            emp.setName(name);
            emp.setSalary(salary);
            emp.setRole(role);
            System.out.println("Employee Updated Successfully");
        }else{
            System.out.println("No Employee Found!");
        }
        et.commit();
      }


      public void deleteEmployee(int id){
       EntityManager em=emf.createEntityManager();
       EntityTransaction et=em.getTransaction();
           et.begin();

           EmployeeDto employeeDto=em.find(EmployeeDto.class, id);
           em.remove(employeeDto);

           et.commit();
           em.close();
      }

      public void deleteAllEmployees(){
          EntityManager em=emf.createEntityManager();
          EntityTransaction et=em.getTransaction();
          et.begin();
          Query query = em.createQuery("Delete from EmployeeDto");
          query.executeUpdate();
          et.commit();
          em.close();
      }

    public void fetchAllEmployees() {
        EntityManager em = emf.createEntityManager(); // Create EntityManager
        try {
            Query query = em.createQuery("SELECT e FROM EmployeeDto e"); // Correct query syntax
            List<EmployeeDto> lists = query.getResultList(); // Get list of employees

            for (EmployeeDto list : lists) {
                System.out.println(list); // Print each employee
            }
        } finally {
            em.close(); // Close EntityManager
        }
    }


}

















