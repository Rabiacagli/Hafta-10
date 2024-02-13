package org.library;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long id;

    @Column(name = "publisher_name" , nullable = false)
    private String name;

    @Column(name = "publisher_address" , nullable = false)
    private String address;

    @Column(name = "publisher_establishment_year" , nullable = false)
    private String establishmentYear;

    @OneToMany(mappedBy = "publisher")
    private List<Book> bookList;

    public Publisher() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(String establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", establishmentYear='" + establishmentYear + '\'' +
                '}';
    }
}
