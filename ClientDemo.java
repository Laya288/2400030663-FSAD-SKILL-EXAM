package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ClientDemo implements CommandLineRunner
{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception
    {
        // Insert Sample Records
        Shipment s = new Shipment(1,"Electronics","10-03-2026","Shipped","Hyderabad");
        Shipment s2 = new Shipment(2,"Television","11-04-2026","Shipped","Bangalore");

        em.persist(s);
        em.persist(s2);

        System.out.println("Shipments Inserted");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Shipment ID to delete: ");
        int id = sc.nextInt();

       
        String hql = "delete from Shipment where id = :sid";

        int count = em.createQuery(hql)
                .setParameter("sid", id)
                .executeUpdate();

        if(count > 0)
        {
            System.out.println(count + " Record Deleted Successfully");
        }
        else
        {
            System.out.println("No Shipment found with ID: " + id);
        }

        sc.close();
    }
}