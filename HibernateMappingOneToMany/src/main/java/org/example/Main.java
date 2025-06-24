package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et=em.getTransaction();

        et.begin();
        Employee employee=new Employee("SRK", "50,000");
        Employee employee1=new Employee("CR7", "80,000");

        Department department=new Department("Business", Arrays.asList(employee, employee1));
        em.persist(department); 
        et.commit();

        //Fetch the Department Name
        Department dept=em.find(Department.class,1);
        System.out.println("The Name of the department is:"+ dept.getName());

        em.close();
        JPAUtil.close();
    }
}









