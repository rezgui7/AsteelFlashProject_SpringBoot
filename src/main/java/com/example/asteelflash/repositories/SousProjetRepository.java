package com.example.asteelflash.repositories;

import com.example.asteelflash.entities.Sous_projets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SousProjetRepository extends CrudRepository<Sous_projets,Long> {
    @Query("SELECT sp FROM Sous_projets sp JOIN sp.projets p WHERE p.idProjet = :projetId")
    List<Sous_projets> findByProjets_Id(Long projetId);

}
