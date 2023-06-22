package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.agoncal.quarkus.jdbc.Artist;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name="t_items")
public class Item extends PanacheEntity{
    @Column(length = 100, nullable = false)
    public String title;

    @Column(length = 3000)
    public String description;
    @Column(nullable = false)
    public BigDecimal price;
    @Column(name="created_date")
    public Instant createdDate = Instant.now();

    @ManyToOne()
    @JoinColumn(name="artist_fk")
    public Artist artist;
}
