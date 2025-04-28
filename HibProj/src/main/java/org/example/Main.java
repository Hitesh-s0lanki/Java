package org.example;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        String brand = "Asus";

        Query query = session.createQuery("from Laptop where brand like ?1");
        query.setParameter(1, "%" + brand + "%");
        List<Laptop> laptops = query.getResultList();

        System.out.println(laptops);

        session.close();
        sf.close();
    }
}

//        Laptop laptop = session.get(Laptop.class, 2);
//        Laptop laptop = session.load(Laptop.class, 2);
//Laptop laptop = session.byId(Laptop.class).getReference(2);
//        System.out.println(laptop);
//        session.close();


//https://github.com/navinreddy20/hibernate6/blob/main/HibProj-Le16/src/main/java/com/telusko/Main.java