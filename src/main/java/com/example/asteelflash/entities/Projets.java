package com.example.asteelflash.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
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
    private String etat;


    @Enumerated (EnumType.STRING)
    private ProjetType projetType;


    @OneToMany(mappedBy = "projets")
    public List<Sous_projets> sous_projets;


}