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
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEquipe;

    private Integer nombreDeProjet;
    private Integer nombreDeProjetTerminer;
    private Integer nombreDeProjetEnCours;
    private Integer nombreDeProjetAnnuler;

    @Enumerated (EnumType.STRING)
    private EquipeType equipeType;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Sous_projets> sous_projets;

}