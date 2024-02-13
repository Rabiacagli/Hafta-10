package org.library;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookBorrowing")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_borrowing_id")
    private Long id;

    @Column(name = "borrower_name" ,nullable = false)
    private String name;

    @Column(name = "borrower_mail" ,nullable = false)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date" ,nullable = false)
    private LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_bookBorrowing_id", referencedColumnName = "book_id")
    private Book book;

    public BookBorrowing() {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
