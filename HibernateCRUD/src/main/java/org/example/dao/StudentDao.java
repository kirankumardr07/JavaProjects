package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.dto.StudentDto;

public class StudentDao {
  EntityManagerFactory emf= Persistence.createEntityManagerFactory("example-unit");

  public void addStudent(StudentDto dto){
  EntityManager em=emf.createEntityManager();
  EntityTransaction et=em.getTransaction();
      et.begin();
      em.persist(dto);
      et.commit();
      em.close();
  }
}




