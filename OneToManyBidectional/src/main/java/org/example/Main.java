package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et=em.getTransaction();

        et.begin();
         Department dept= new Department("HR", null);

        Employee employee1=new Employee("Kr7", "2,50,000",dept);
        Employee employee2=new Employee("Cr7", "9,50,000",dept);
        Employee employee3=new Employee("Srk", "8,50,000",dept);

         dept.setEmployees(Arrays.asList(employee1,employee2,employee3));

         em.persist(dept);

        et.commit();

        Department department=em.find(Department.class,3);
        System.out.println("Department Name:"+department.getName());

        for(Employee employee: department.getEmployees()){
            System.out.println("Id:"+employee.getId()+"Name: "+ employee.getName()+"Salary:"+ employee.getSalary());
        }


        em.close();
        JPAUtil.close();
    }
}









