package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientDemo implements CommandLineRunner
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception
    {

        Shipment s = new Shipment(1,"Electronics","10-03-2026","Shipped","Hyderabad");

        em.persist(s);

        System.out.println("Shipment Inserted");

        // DELETE 
        String hql = "delete from Shipment where id = :sid";

        int count = em.createQuery(hql)
                .setParameter("sid",1)
                .executeUpdate();

        System.out.println(count + " Record Deleted");
    }
}