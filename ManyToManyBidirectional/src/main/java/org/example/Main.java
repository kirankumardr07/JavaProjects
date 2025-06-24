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
        Course course1 = new Course("Computer Science");
        Course course2 = new Course("Artificial Intelligence");

        // Creating Students
        Student student1 = new Student("Bob", Arrays.asList(course1, course2));
        Student student2 = new Student("Charlie", Arrays.asList(course1));

        // Linking Courses to Students
        course1.setStudents(Arrays.asList(student1, student2));
        course2.setStudents(Arrays.asList(student1));

        em.persist(course1);
        em.persist(course2);
        em.persist(student1);
        em.persist(student2);

        transaction.commit();

        // Fetching Course and Students
        Course fetchedCourse = em.find(Course.class, 1);
        System.out.println("Course: " + fetchedCourse.getName());
        for (Student s : fetchedCourse.getStudents()) {
            System.out.println("Enrolled Student: " + s.getName());
        }

        em.close();
        JPAUtil.close();
    }
}






