package org.library;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name" , nullable = false)
    private String name;

    @Column(name= "book_publication_year",nullable = false)
    private int publicationYear;

    @Column(name = "book_stock" , nullable = false)
    private int stock;


    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> bookBorrowingList;

    @ManyToOne
    @JoinColumn(name  = "book_author_id" ,referencedColumnName = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name  = "book_publisher_id" ,referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "book_to_category",
     joinColumns = {@JoinColumn(name = "book_id")},
     inverseJoinColumns = @JoinColumn(name = "book_category_id"))
    private List<Category> categoryList;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<BookBorrowing> getBookBorrowingList() {
        return bookBorrowingList;
    }

    public void setBookBorrowingList(List<BookBorrowing> bookBorrowingList) {
        this.bookBorrowingList = bookBorrowingList;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", stock=" + stock +
                ", bookBorrowingList=" + bookBorrowingList +
                ", author=" + author +
                ", publisher=" + publisher +
                ", categoryList=" + categoryList +
                '}';
    }
}
