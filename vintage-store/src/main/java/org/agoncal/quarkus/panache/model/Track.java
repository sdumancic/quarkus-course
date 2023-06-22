package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name="t_tracks")
public class Track extends PanacheEntity {

    public String title;
    public Duration duration;
    @Column(name="created_date")
    public Instant createdDate = Instant.now();
    @ManyToOne()
    @JoinColumn(name="cd_fk")
    public CD cd;
}
