package com.example.asteelflash.repositories;

import com.example.asteelflash.entities.Equipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe,Long> {
}
