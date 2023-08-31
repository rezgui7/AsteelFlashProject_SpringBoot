package com.example.asteelflash.repositories;

import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.entities.ScheduleEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleEntryRepository extends CrudRepository<ScheduleEntry,Long> {
}
