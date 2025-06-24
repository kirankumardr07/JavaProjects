package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    public static EntityManagerFactory emf= Persistence.createEntityManagerFactory("example-unit");


    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

    public static void close(){
        emf.close();
    }

}





