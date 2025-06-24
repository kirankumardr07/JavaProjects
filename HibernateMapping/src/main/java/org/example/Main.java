package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class Main {
    public static void main(String[] args) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et=em.getTransaction();

        et.begin();
        Passport passport=new Passport("ABC123");
        Person person=new Person("Kiran Kumar DR", passport);
        passport.setPerson(person);
         em.persist(person);
        et.commit();

        Person data=em.find(Person.class, 5);
        System.out.println("Name is :"+ data.getName());
        System.out.println("Passport Number is :"+ data.getPassport().getPassportNumber());

        Passport passport1=em.find(Passport.class, 5);
        System.out.println("The passport number is:"+ passport1.getPassportNumber());
        System.out.println("The person name is:"+ passport1.getPerson().getName());

        em.close();
        JPAUtil.close();
    }
}









