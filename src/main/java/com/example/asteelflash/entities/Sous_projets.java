package com.example.asteelflash.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sous_projets implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAppel;


    @ManyToOne(cascade = CascadeType.ALL)
    Projets projets;

    @JsonIgnore
    @ManyToMany(mappedBy = "sous_projets")
    List<Equipe> equipes;
}
