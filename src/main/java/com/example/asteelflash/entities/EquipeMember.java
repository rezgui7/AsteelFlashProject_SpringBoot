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
public class EquipeMember implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMember;
    private String prenom;
    private String state;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.REMOVE,mappedBy = "equipeMembers")
    List<Equipe> equipes;





}
