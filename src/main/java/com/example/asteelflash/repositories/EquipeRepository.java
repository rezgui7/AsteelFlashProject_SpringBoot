package com.example.asteelflash.repositories;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.EquipeMember;
import com.example.asteelflash.entities.Sous_projets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe,Long> {
    @Query("select t from Equipe t where t.pm=?1")
    List<Equipe> findByName(String pmName);

    @Query("SELECT em FROM EquipeMember em JOIN em.equipes e WHERE e.idEquipe = :equipeId")
    List<EquipeMember> findByEquipe_Id(Long equipeId);
}
