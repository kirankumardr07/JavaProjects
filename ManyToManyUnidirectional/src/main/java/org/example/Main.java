package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        // Creating Courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Physics");

        em.persist(course1);
        em.persist(course2);

        // Creating Student and associating with Courses
        Student student = new Student("Alice", Arrays.asList(course1, course2));

        em.persist(student);

        transaction.commit();

        // Fetching Student and Courses
        Student fetchedStudent = em.find(Student.class, 1);
        System.out.println("Student: " + fetchedStudent.getName());
        for (Course c : fetchedStudent.getCourses()) {
            System.out.println("Enrolled in Course: " + c.getName());
        }

        em.close();
        JPAUtil.close();
    }
}






