package com.example.asteelflash.repositories;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.entities.Sous_projets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetsRepository extends CrudRepository<Projets,Long> {
//    @Query("select t from Sous_projets t where t=?1")
//    List<Sous_projets> findByIdProject(Long idProject);
}
