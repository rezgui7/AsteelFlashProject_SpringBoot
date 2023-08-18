package com.example.asteelflash.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Projets implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProjet;
    private String client;
    private String projet;
    private String designation;
    private String test;
    private String pm;
    private String pe;
    private String status;
    private Date start_date;
    private Date end_date;
    private Date due_end_date;
    private String progress;
    private String target;
    private String lead_time;
    private String delay;


    @Enumerated (EnumType.STRING)
    private ProjetType projetType;


    @JsonIgnore
    @OneToMany(mappedBy = "projets")
    public List<Sous_projets> sous_projets;


}