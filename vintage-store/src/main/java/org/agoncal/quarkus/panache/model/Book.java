package org.agoncal.quarkus.panache.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="t_books")
public class Book extends Item{

    @Column(name="isbn", length = 15)
    public String isbn;
    @Column(name="nb_of_pages")
    public int nbOfPages;
    @Column(name="publication_date")
    public LocalDate publicationDate;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    public Language language;

    @ManyToOne()
    @JoinColumn(name="publisher_fk")
    public Publisher publisher;

}
