package com.example.asteelflash.repositories;

import com.example.asteelflash.entities.Sous_projets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousProjetRepository extends CrudRepository<Sous_projets,Long> {
}
