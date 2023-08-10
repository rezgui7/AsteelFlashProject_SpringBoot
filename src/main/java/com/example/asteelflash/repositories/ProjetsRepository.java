package com.example.asteelflash.repositories;

import com.example.asteelflash.entities.Projets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetsRepository extends CrudRepository<Projets,Long> {
}
