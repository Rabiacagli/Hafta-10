package org.library;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.library.Book;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<Book> bookList = new ArrayList<>();


      /*  Author author = new Author();
        author.setName("Gabriel Garcia Marquez");
        author.setBirthDate(LocalDate.parse("1927-03-06"));
        author.setCountry("Colombia"); */

      /*  Category category4 = new Category();
        category4.setName("Magical Realism");
        category4.setDescription("Category containing works that blend magical elements with reality.");
        Category category3 = new Category();
        category3.setName("Mystery");
        category3.setDescription("Category containing works that involve solving a puzzle or crime.");
        Category category2 = new Category();
        category2.setName("Horror");
        category2.setDescription("Category containing works intended to scare, unsettle, or horrify the audience.");*/

/*
        Publisher publisher1 = new Publisher();
        publisher1.setName("Bloomsbury");
        publisher1.setEstablishmentYear("1986");
        publisher1.setAddress("Bloomsbury, London, England");
        Publisher publisher2 = new Publisher();
        publisher2.setName("Doubleday");
        publisher2.setEstablishmentYear("1897");
        publisher2.setAddress("New York City, New York, United States");
        Publisher publisher3 = new Publisher();
        publisher3.setName("HarperCollins");
        publisher3.setEstablishmentYear("1989");
        publisher3.setAddress("London, England, United Kingdom");
*/

     /*   Author a1 = entityManager.find(Author.class,2);
        Author a2 = entityManager.find(Author.class,3);
        Author a3 = entityManager.find(Author.class,4);

        Publisher p1 = entityManager.find(Publisher.class,1);
        Publisher p2 = entityManager.find(Publisher.class,2);
        Publisher p3 = entityManager.find(Publisher.class,3);

        Book book1 = new Book();
        book1.setName("Harry Potter and the Philosopher's Stone");
        book1.setAuthor(a1);
        book1.setPublisher(p1);
        book1.setPublicationYear(1997);
        book1.setStock(100);


        Book book2 = new Book();
        book2.setName("The Shining");
        book2.setAuthor(a2);
        book2.setPublisher(p2);
        book2.setPublicationYear(1977);
        book2.setStock(75);




        Book book3 = new Book();
        book3.setName("Murder on the Orient Express");
        book3.setAuthor(a3);
        book3.setPublisher(p3);
        book3.setPublicationYear(1934);
        book3.setStock(50);  */


     /*   Book b1 = entityManager.find(Book.class,1);
        Book b2 = entityManager.find(Book.class,2);
        Book b3 = entityManager.find(Book.class,3);

        Category c1 = entityManager.find(Category.class,1);
        Category c2 = entityManager.find(Category.class,2);
        Category c3 = entityManager.find(Category.class,3);

        List<Category> categoryList = b1.getCategoryList();
        System.out.println(b2.getPublisher().getAddress());*/


        /*
        List<Category> categoryList = new ArrayList<>();

        categoryList.add(c1);
        categoryList.add(c2);
        categoryList.add(c3);
        b1.setCategoryList(categoryList);
        b2.setCategoryList(categoryList);
        b3.setCategoryList(categoryList);*/



       /* BookBorrowing borrowing1 = new BookBorrowing();
        borrowing1.setName("Sophia Lee");
        borrowing1.setMail("sophia@example.com");
        borrowing1.setBook(b1);
        borrowing1.setBorrowingDate(LocalDate.parse("2024-02-13"));
        borrowing1.setReturnDate(LocalDate.parse("2024-03-13"));


        BookBorrowing borrowing2 = new BookBorrowing();
        borrowing2.setName("Emily Johnson");
        borrowing2.setMail("emily@example.com");
        borrowing2.setBook(b2);
        borrowing2.setBorrowingDate(LocalDate.parse("2024-02-13"));
        borrowing2.setReturnDate(LocalDate.parse("2024-03-13"));


        BookBorrowing borrowing3 = new BookBorrowing();
        borrowing3.setName("Rabia Çağlı");
        borrowing3.setMail("rabia@example.com");
        borrowing3.setBook(b3);
        borrowing3.setBorrowingDate(LocalDate.parse("2024-02-13"));
        borrowing3.setReturnDate(LocalDate.parse("2024-03-13"));
*/



        transaction.begin();
        //   entityManager.persist(b1);
        // entityManager.persist(b2);
        //entityManager.persist(b3);
        transaction.commit();
    }
}