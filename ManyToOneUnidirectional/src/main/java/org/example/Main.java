package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        // Creating Department
        Department dept = new Department("Finance");
        em.persist(dept);

        // Creating Employees
        Employee emp1 = new Employee("Alice", 70000, dept);
        Employee emp2 = new Employee("Bob", 80000, dept);

        em.persist(emp1);
        em.persist(emp2);

        transaction.commit();

        // Fetching Employee
        Employee fetchedEmp = em.find(Employee.class, 2);
        System.out.println("Employee: " + fetchedEmp.getName()
                + ", Department: " + fetchedEmp.getDepartment().getName());

        em.close();
        JPAUtil.close();
    }
}









