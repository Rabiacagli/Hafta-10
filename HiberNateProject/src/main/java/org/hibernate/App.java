package org.hibernate;

import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Session

        SessionFactory factory = new Configuration()  // session oluşturma
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        // CRUD işlemleri -   Create , Read , Update , Delete

        session.beginTransaction();      // transactıon ı baslatma
        try {
            // Customer ekleme - create
            Customer customer = new Customer();

         /*   customer.setName("Hibernate Test");
            customer.setGender(Customer.GENDER.FEMALE);
            customer.setOnDate(LocalDate.now());
            customer.setMail("test@patika.dev");

            session.persist(customer);*/


       /*     customer = session.get(Customer.class,1);  // Read işlemi
        //    System.out.println(customer.toString());
            customer.setName("Güncellendi");
            session.persist(customer);            // Update işlemi
            session.remove(customer);           // Delete işlemi
*/


        //    customer = session.byId(Customer.class).getReference(2);  //id" ye göre veri çekme
        //    System.out.println(customer.toString());


            //Hql ile veri tabanındaki tüm verileri çekme
         /*   List <Customer > customers = session
                    .createSelectionQuery("FROM Customer", Customer.class)
                    .getResultList();
            System.out.println(customers.toString());*/


            // hql ile id ye göre arama yapma
            Customer customer1 = session
                    .createSelectionQuery("FROM Customer WHERE id = 2", Customer.class)
                    .getSingleResult();
            System.out.println(customer1.toString());


            session.getTransaction().commit();  //hata alınmazsa commıt
        } catch (Exception e) {
            session.getTransaction().rollback();  // hata alınırsa rollback yapma
            e.printStackTrace();
        } finally {
            session.close(); // kapatma işlemi
        }
    }
}
