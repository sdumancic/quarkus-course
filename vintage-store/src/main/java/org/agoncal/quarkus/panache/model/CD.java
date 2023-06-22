package org.agoncal.quarkus.panache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_cds")
public class CD extends Item{

    @Column(name="music_company")
    public String musicCompany;
    public String genre;

    @OneToMany(mappedBy = "cd")
    public List<Track> tracks = new ArrayList<>();
}
