package com.example.asteelflash.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private String pm;
    private Integer npp;
    private Integer ncp;
    private Integer projet_on_going;
    private Integer projet_stand_by;
    private Integer projet_canceled;

    @Enumerated (EnumType.STRING)
    private EquipeType equipeType;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Sous_projets> sous_projets;

    @ManyToMany
    @JoinTable(name = "equipe_equipe_member",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_member_id"))
    private List<EquipeMember> equipeMembers;



}